package taskorganizer

import org.springframework.dao.DataIntegrityViolationException

/**
 * CycleController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class CycleController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [cycleInstanceList: Cycle.list(params), cycleInstanceTotal: Cycle.count()]
    }

    def create() {
        [cycleInstance: new Cycle(params)]
    }

    def save() {
        def cycleInstance = new Cycle(params)
        if (!cycleInstance.save(flush: true)) {
            render(view: "create", model: [cycleInstance: cycleInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'cycle.label', default: 'Cycle'), cycleInstance.id])
        redirect(action: "show", id: cycleInstance.id)
    }

    def show() {
        def cycleInstance = Cycle.get(params.id)
        if (!cycleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'cycle.label', default: 'Cycle'), params.id])
            redirect(action: "list")
            return
        }

        [cycleInstance: cycleInstance]
    }

    def edit() {
        def cycleInstance = Cycle.get(params.id)
        if (!cycleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cycle.label', default: 'Cycle'), params.id])
            redirect(action: "list")
            return
        }

        [cycleInstance: cycleInstance]
    }

    def update() {
        def cycleInstance = Cycle.get(params.id)
        if (!cycleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cycle.label', default: 'Cycle'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (cycleInstance.version > version) {
                cycleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'cycle.label', default: 'Cycle')] as Object[],
                          "Another user has updated this Cycle while you were editing")
                render(view: "edit", model: [cycleInstance: cycleInstance])
                return
            }
        }

        cycleInstance.properties = params

        if (!cycleInstance.save(flush: true)) {
            render(view: "edit", model: [cycleInstance: cycleInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'cycle.label', default: 'Cycle'), cycleInstance.id])
        redirect(action: "show", id: cycleInstance.id)
    }

    def delete() {
        def cycleInstance = Cycle.get(params.id)
        if (!cycleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'cycle.label', default: 'Cycle'), params.id])
            redirect(action: "list")
            return
        }

        try {
            cycleInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'cycle.label', default: 'Cycle'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cycle.label', default: 'Cycle'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
