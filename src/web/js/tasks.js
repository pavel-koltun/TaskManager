$(document).ready(function () {
    loadAll();

    $("#inputForm").submit(function(event) {
        var title = $('#inputTitle').val();
        var description = $('#inputDescription').val();
        var priority = $('#inputPriority').val();
        var status = $('#inputStatus').val();

        var json = { "title": title, "description": description, "priority": priority, "status": status, "archived": false};

        $.ajax({
            url: "/rest/tasks",
            data: JSON.stringify(json),
            type: "POST",

            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (task) {
                $('#inputForm').trigger("reset");
                $("#addModal").modal('hide');
                addTask(task);
            },
            error: function(msg) {
                console.log(msg);
            }
        });

        event.preventDefault();
    });

    $("#editForm").submit(function(event) {
        var id = $("#taskId").val();
        var title = $('#editTitle').val();
        var description = $('#editDescription').val();
        var priority = $('#editPriority').val();
        var status = $('#editStatus').val();

        var json = {
            "id": id,
            "title": title,
            "description": description,
            "priority": priority,
            "status": status,
            "archived": false
        };

        console.log(JSON.stringify(json));
        console.log("URL: " + "/rest/tasks/" + id);

        $.ajax({
            url: "/rest/tasks/" + id,
            data: JSON.stringify(json),
            type: "PUT",

            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (task) {
                $('#editForm').trigger("reset");
                $("#editModal").modal('hide');
                updateTask(id);
            },
            error: function(msg) {
                console.log(msg);
            }
        });

        event.preventDefault();
    });
});

function loadAll() {
    $.ajax({
        type: "GET",
        url: "/rest/tasks/",
        data: null
    }).then(function (data) {
        $('tbody').empty();

        for (var i = 0; i < data.length; i++) {
            var $tr = $("<tr>");
            $tr.append("<td class='id hidden'>" + data[i].id + "</td>");
            $tr.append("<td class='title'>" + data[i].title + "</td>");
            $tr.append("<td class='description hidden'>" + data[i].description + "</td>");
            $tr.append("<td class='status'>" + data[i].status + "</td>");
            $tr.append("<td class='priority'>" + data[i].priority + "</td>");

            var $editBtn = $("<td><button class='btn btn-warning'>Edit</button></td>");
            $editBtn.bind("click", function () {
                $("#editModal").modal("show");

                var $row = $(this).closest("tr");

                $("#taskId").val($row.find("td.id").html());
                $("#editTitle").val($row.find("td.title").html());
                $("#editDescription").val($row.find("td.description").html());
                $("#editStatus").val($row.find("td.status").html()).prop("selected", true);
                $("#editPriority").val($row.find("td.priority").html()).prop("selected", true);
            });

            var $deleteBtn = $("<td><button class='btn btn-danger'>Delete</button></td>");
            $deleteBtn.bind("click", function () {
                //var taskId = $(this).find("button").attr("id").match(/\d+/)[0];
                var taskId = $(this).closest("tr").find("td.hidden").html();
                var row = $(this).parent();

                (function (id, row) {
                    console.log("Deleting task #" + id);
                    $.ajax({
                        type: "DELETE",
                        url: "/rest/tasks/" + id
                    }).then(function () {
                        row.remove();
                    }).then(function () {
                        $("tbody:empty").append("<tr><td class='text-center info' colspan='5'>There are no tasks :(</td></tr>");
                    });
                })(taskId, row);
            });
            $tr.append($editBtn, $deleteBtn);

            $('table > tbody').append($tr);
        }

        $("tbody:empty")
            .append("<tr><td class='text-center info' colspan='5'>There are no tasks :(</td></tr>");
    });
}

function addTask(task) {
    var $tr = $("<tr>");
    $tr.append("<td class='id hidden'>" + task.id + "</td>");
    $tr.append("<td class='title'>" + task.title + "</td>");
    $tr.append("<td class='description hidden'>" + task.description + "</td>");
    $tr.append("<td class='status'>" + task.status + "</td>");
    $tr.append("<td class='priority'>" + task.priority + "</td>");

    var $editBtn = $("<td><button class='btn btn-warning'>Edit</button></td>");
    $editBtn.bind("click", function () {
        $("#editModal").modal("show");

        var $row = $(this).closest("tr");

        $("#editTitle").val($row.find("td.title").html());
        $("#editDescription").val($row.find("td.description").html());
        $("#editStatus").val($row.find("td.status").html()).prop("selected", true);
        $("#editPriority").val($row.find("td.priority").html()).prop("selected", true);
    });
    var $deleteBtn = $("<td><button class='btn btn-danger'>Delete</button></td>");

    $deleteBtn.bind("click", function () {
        //var taskId = $(this).find("button").attr("id").match(/\d+/)[0];
        var taskId = $(this).closest("tr").find("td.hidden").html();

        var row = $(this).parent();

        (function (id, row) {
            console.log("Deleting task #" + id);
            $.ajax({
                type: "DELETE",
                url: "/rest/tasks/" + id
            }).then(function () {
                row.remove();
            }).then(function () {
                $("tbody:empty").append("<tr><td class='text-center info' colspan='5'>There are no tasks :(</td></tr>");
            });
        })(taskId, row);
    });
    $tr.append($editBtn, $deleteBtn);

    if ($("td.info").length)
        $("tbody").empty();
    $('table > tbody').append($tr);
}

function updateTask(id) {

}