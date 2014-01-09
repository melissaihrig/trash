import taskorganizer.*
import grails.util.Environment;

class BootStrap {

    def init = { servletContext ->

        if (Environment.current != Environment.PRODUCTION) {

            //status 
            def statusNotStarted = new Status(name: "not started", description: "")
            statusNotStarted.save(failOnError: true) // The failOnError option ensures that an exception is thrown if the save fails for any reason
            def statusStarted = new Status(name: "started", description: "")
            statusStarted.save(failOnError: true)
            def statusFinished = new Status(name: "finished", description: "")
            statusFinished.save(failOnError: true)

            //cycle
            def cycle = new Cycle(name: "0-100")
            cycle.addToStatus(statusNotStarted)
            cycle.addToStatus(statusStarted)
            cycle.addToStatus(statusFinished)
            cycle.save(failOnError: true)

            //project
            def project = new Project(name: "Diario", description: "Crear un programa web para escribir un diario", cycle: cycle, image:1)
            project.save(failOnError: true)

            def task = new Task(project: project, description: "Como usuario quiero poder agregar lo que me pasó hoy para que quede registrado en mi diario", detail:"", weight:10, status:statusNotStarted).save(failOnError: true)
            task = new Task(project: project, description: "Como usuario quiero poder exportar mi diario para poder guardar su contenido en un archivo", detail:"", weight:10, status:statusNotStarted).save(failOnError: true)

        }
    }
    def destroy = {
    }
}
