<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Add New Task</h4>
            </div>
            <form id="inputForm" class="form-horizontal">
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label for="inputTitle" class="col-sm-2 control-label">Title</label>
                            <div class="col-sm-10">
                                <input name="title" class="form-control" id="inputTitle" placeholder="Title" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputDescription" class="col-sm-2 control-label">Description</label>

                            <div class="col-sm-10">
                                <input name="description" class="form-control" id="inputDescription" placeholder="Description" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPriority" class="col-sm-2 control-label">Priority</label>

                            <div class="col-sm-10">
                                <select name="priority" id="inputPriority" class="form-control">
                                    <option>Low</option>
                                    <option>Medium</option>
                                    <option>High</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputStatus" class="col-sm-2 control-label">Status</label>
                            <div class="col-sm-10">
                                <select name="status" id="inputStatus" class="form-control">
                                    <option>Not Started</option>
                                    <option>Started</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>