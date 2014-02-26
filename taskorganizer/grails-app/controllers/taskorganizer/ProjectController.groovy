package taskorganizer

import org.springframework.dao.DataIntegrityViolationException

/**
 * ProjectController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class ProjectController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [projectInstanceList: Project.list(params), projectInstanceTotal: Project.count()]
    }

    def create() {
        [projectInstance: new Project(params)]
    }

    def save() {

        println params
        def projectInstance = new Project(params)
        
        projectInstance.tasks.each {
            it.status = projectInstance.cycle.status.first()
        }

        if (!projectInstance.save(flush: true)) {
            render(view: "create", model: [projectInstance: projectInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'project.label', default: 'Project'), projectInstance.name])
        redirect(action: "show", id: projectInstance.id)
    }

    def show() {
        def projectInstance = Project.get(params.id)
        if (!projectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
            return
        }

        [projectInstance: projectInstance, projectProgress: projectInstance.percentageProgress()]
    }

    def edit() {
        def projectInstance = Project.get(params.id)
        if (!projectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
            return
        }

        [projectInstance: projectInstance]
    }

    def update() {
        def projectInstance = Project.get(params.id)
        if (!projectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (projectInstance.version > version) {
                projectInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'project.label', default: 'Project')] as Object[],
                          "Another user has updated this Project while you were editing")
                render(view: "edit", model: [projectInstance: projectInstance])
                return
            }
        }

        projectInstance.properties = params

        if (!projectInstance.save(flush: true)) {
            render(view: "edit", model: [projectInstance: projectInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'project.label', default: 'Project'), projectInstance.id])
        redirect(action: "show", id: projectInstance.id)
    }

    def delete() {
        def projectInstance = Project.get(params.id)
        if (!projectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
            return
        }

        try {
            projectInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'project.label', default: 'Project'), params.id])
            redirect(action: "show", id: params.id)
        }
    }

    def ajaxProject() {
        //TODO limitar la cantidad que se muestran
        render(view: "listPicture", model: [projectsIntances: Project.getAll()])
    }

    def viewImage = {
        
        def project = Project.get(params.id)
        
        response.setHeader("Content-disposition", "attachment; filename=${params.id}")
        response.outputStream << project.image  //'myphoto.jpg' will do too
        response.outputStream.flush()

        return;
    }

    

    def changeStatus() {

        def task = Task.get(params.id)
        def nextStatus

        if (task.project.id == params.projectId.toInteger()) {

            def project = Project.get(params.projectId)

            println "previousStatus " + task.status

            nextStatus = project.cycle.nextStatus(task.status)

            if (nextStatus == null) {
                render "Error al actualizar"
                return
            }
            else {
                task.status = nextStatus
                render nextStatus
                return
            }

        }

            println "siguiente estado " + nextStatus
    }

    def updateProgress() {
        /* actualmente recalcula todo el progreso del proyecto de nuevo.

            mejora: fijarse si la está terminado y en ese caso, recalcular, sino
            es el valor de antes.*/
        def project = Project.get(params.projectId)
        render project.percentageProgress()
    }
}
