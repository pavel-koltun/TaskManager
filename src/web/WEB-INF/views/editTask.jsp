<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit task</h4>
            </div>
            <form id="editForm" class="form-horizontal">
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label for="editTitle" class="col-sm-2 control-label">Title</label>

                            <div class="col-sm-10">
                                <input name="title" class="form-control" id="editTitle" placeholder="Title" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="editDescription" class="col-sm-2 control-label">Description</label>

                            <div class="col-sm-10">
                                <input name="description" class="form-control" id="editDescription" placeholder="Description" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="editPriority" class="col-sm-2 control-label">Priority</label>

                            <div class="col-sm-10">
                                <select name="priority" id="editPriority" class="form-control">
                                    <option>Low</option>
                                    <option>Medium</option>
                                    <option>High</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="editStatus" class="col-sm-2 control-label">Status</label>

                            <div class="col-sm-10">
                                <select name="status" id="editStatus" class="form-control">
                                    <option>Not Started</option>
                                    <option>Started</option>
                                </select>
                            </div>
                        </div>
                        <input name="id" id="taskId" type="hidden">
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Confirm changes</button>
                </div>
            </form>
        </div>
    </div>
</div>