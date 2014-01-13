$(document).ready(function() {

    $('.selector-image').on('click', function() {
        $( "input:file" ).click();
    });

    $('input[type=file]').on('change', function () {
        var path = $(this).val();
        $("#selector-result").text(path.split('\\').pop());
    });

    $('#add-task').on('click', function() {
        var task_form = $(".task-form").clone().removeClass("hidden task-form");
        initNamesTask(task_form);
        initIdsTask(task_form);
        task_form.insertBefore("#add-task");
        task_form.data('number', currentTask);
        currentTask++;
    });

    $('.form').on('click', '.delete-task' ,function() {
        var panel = $(this).closest(".panel-default");
        var number = panel.data('number');
        var panel_next = panel.next();

        for (var num = number; num < currentTask - 1;  num++) {
            changeNamesTask(panel_next, (num+1), num);
            changeIdsTask(panel_next, (num+1), num);
            panel_next.data('number', num);
            panel_next = panel_next.next();
        }

        panel.remove();
        currentTask--;
    });

    function initNamesTask(task_form) {
        changeNamesTask(task_form, "numberTask", currentTask);
    };
        
    function initIdsTask(task_form) {
        changeIdsTask(task_form, "numberTask", currentTask);
    };

    function changeNamesTask(task_form, old_value, new_value) {
        task_form.find("#tasks-description-" + old_value).attr('name', 'tasks['+ new_value +'].description');
        task_form.find("#tasks-detail-" + old_value).attr('name', 'tasks['+ new_value +'].detail');
        task_form.find("#tasks-weight-" + old_value).attr('name', 'tasks['+ new_value +'].weight');
    };

    function changeIdsTask(task_form, old_value, new_value) {
        task_form.find("#tasks-description-" + old_value).attr('id', 'tasks-description-'+ new_value);
        task_form.find("#tasks-detail-" + old_value).attr('id', 'tasks-detail-'+ new_value);
        task_form.find("#tasks-weight-" + old_value).attr('id', 'tasks-weight-'+ new_value); 
    };

});