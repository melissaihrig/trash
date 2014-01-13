<div class="task-form hidden panel panel-default" data-number="0">              
    <div class="panel-body">
        <div class="row">
            <div class="col-md-8">
                <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'description', 'error')} required">
                     <input type="text" name="tasks[numberTask].description" required="" value="" class="form-control" placeholder="${message(code: 'task.description.label', default: 'Description')}*" id="tasks-description-numberTask">

                    <span class="help-block">${hasErrors(bean: taskInstance, field: 'description', 'error')}</span>
                </div>

                <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'detail', 'error')} ">
                    <textarea name="tasks[numberTask].detail" value="" class="form-control" placeholder="${message(code: 'task.detail.label', default: 'Detail')}" rows="3" id="tasks-detail-numberTask" ></textarea>
                    <span class="help-block">${hasErrors(bean: taskInstance, field: 'detail', 'error')}</span>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group fieldcontain ${hasErrors(bean: taskInstance, field: 'weight', 'error')} required">
                    <label for="weight" class="col-sm-3"><g:message code="tasks.weight.label" default="Weight" /><span class="required-indicator">*</span></label>
                    <div class="col-sm-9">
                        <input type="number" name="tasks[numberTask].weight" min="0" required="" value="1" class="form-control" id="tasks-weight-numberTask">
                        <span class="help-block">${hasErrors(bean: taskInstance, field: 'weight', 'error')}</span>
                    </div>
                </div>
                <a role="button" class="col-md-4 col-md-offset-4 btn btn-danger delete-task"><g:message code="default.button.delete.label" default="Delete"/></a>
            </div>
        </div>
    </div>
</div>