package mydesk

import org.springframework.dao.DataIntegrityViolationException

/**
 * UserStoryController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class UserStoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [userStoryInstanceList: UserStory.list(params), userStoryInstanceTotal: UserStory.count()]
    }

    def create() {
        [userStoryInstance: new UserStory(params)]
    }

    def save() {
        def userStoryInstance = new UserStory(params)
        if (!userStoryInstance.save(flush: true)) {
            render(view: "create", model: [userStoryInstance: userStoryInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'userStory.label', default: 'UserStory'), userStoryInstance.id])
        redirect(action: "show", id: userStoryInstance.id)
    }

    def show() {
        def userStoryInstance = UserStory.get(params.id)
        if (!userStoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'userStory.label', default: 'UserStory'), params.id])
            redirect(action: "list")
            return
        }

        [userStoryInstance: userStoryInstance]
    }

    def edit() {
        def userStoryInstance = UserStory.get(params.id)
        if (!userStoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'userStory.label', default: 'UserStory'), params.id])
            redirect(action: "list")
            return
        }

        [userStoryInstance: userStoryInstance]
    }

    def update() {
        def userStoryInstance = UserStory.get(params.id)
        if (!userStoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'userStory.label', default: 'UserStory'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (userStoryInstance.version > version) {
                userStoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'userStory.label', default: 'UserStory')] as Object[],
                          "Another user has updated this UserStory while you were editing")
                render(view: "edit", model: [userStoryInstance: userStoryInstance])
                return
            }
        }

        userStoryInstance.properties = params

        if (!userStoryInstance.save(flush: true)) {
            render(view: "edit", model: [userStoryInstance: userStoryInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'userStory.label', default: 'UserStory'), userStoryInstance.id])
        redirect(action: "show", id: userStoryInstance.id)
    }

    def delete() {
        def userStoryInstance = UserStory.get(params.id)
        if (!userStoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'userStory.label', default: 'UserStory'), params.id])
            redirect(action: "list")
            return
        }

        try {
            userStoryInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'userStory.label', default: 'UserStory'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'userStory.label', default: 'UserStory'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
