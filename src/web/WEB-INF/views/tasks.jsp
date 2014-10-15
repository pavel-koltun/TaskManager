<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task manager</title>
    <script src="/js/jquery-2.1.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/tasks.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/tasks.css">
</head>
<body>
<div class="task-panel">
    <h1 class="task-panel-heading">
        <span class="task-panel-title">Recent Tasks</span>
        <a id="add" href="#" data-toggle="modal" data-target="#addModal">
            <span class="task-panel-add">Add New Task</span>
        </a>
    </h1>

    <div class="table-responsive">
        <table class="table table-stripped">
            <thead>
            <tr>
                <th class="hidden">Id</th>
                <th class="col-lg-6">Title</th>
                <th class="col-lg-2">Status</th>
                <th class="col-lg-2">Priority</th>
                <th class="col-lg-1">Edit</th>
                <th class="col-lg-1">Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="text-center info" colspan="5">
                    There are no tasks :(
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="addTask.jsp"/>
<jsp:include page="editTask.jsp"/>
</body>
</html>
