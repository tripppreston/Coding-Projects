<div class="modal fade" id="edit-page-modal" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    &times;
                </button>
                <h1 class="modal-title">Edit Page:</h1>
            </div>
            <div class="modal-body">
                <form target='#' method="post">
                    <div class="row">

                        <div class='form-group col-sm-5'>
                            <h3>Title:</h3>   
                            <input type='text' id="edit-page-title" class="input-lg form-control"/>
                        </div>
                        <div class="form-group col-sm-3 col-sm-offset-1">
                            <h3>Under Which Tab?</h3> 
                            <select id="edit-page-tab-select" class="input-lg form-control">
                                <!--automatically generate JS content here-->
                                <option value="1">Other</option>
                                <option value="2">Dolphin</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <h3>Content:</h3>
                                <textarea id="edit-page-content" class="tinyMCE"></textarea>
                                <br>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id='updatePageBtn' data-dismiss="modal" class='btn btn-lg btn-success'
                        type='submit'>Update Page</button>
            </div>
        </div>
    </div>
</div>