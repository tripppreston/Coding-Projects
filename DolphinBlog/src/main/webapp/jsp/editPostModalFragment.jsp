<div class="modal fade" id="edit-post-modal" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">

                <button type="button" class="close" data-dismiss="modal">

                    &times;
                </button>
                <h1 class="modal-title">Edit This Post:</h1>
            </div>
            <div class="modal-body">
                <form target='#' method="post">
                    <div class="row">
                        <div class="col-sm-5">
                            <div class='form-group'>
                                <h3>Title:</h3>   
                                <input type='text' id="edit-post-title" class="input-lg form-control"/>
                            </div>

                            <div class='form-group'>
                                <h3>Author:</h3>   
                                <input type='text'id="edit-post-author" class="input-lg form-control"/>
                            </div>
                            <div class="form-group">
                                <h3>Category:</h3> 
                                <select id="edit-post-category" class="input-lg form-control">
                                    <!--automatically generate JS content here-->
                                    <option value="1">Training</option>
                                    <option value="2">Travels</option>
                                    <option value="3">Style</option>
                                    <option value="4">Personnel</option>
                                    <option value="5">Mission</option>
                                    <option value="6">Other</option>
                                </select>
                            </div>
                        </div>

                        <div class=" col-sm-6 col-sm-offset-1">
                            <div class="row">
                                <div class="col-sm-10">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <h3>Hashtags:</h3>
                                            </div>
                                            <div class="col-sm-8">
                                                <span  style="margin-top:20px;" class="pull-right">Ctrl + click to select multiple</span>
                                            </div>
                                        </div>
                                        <select style="min-height: 200px;" multiple id="edit-post-hashtags" class="input-lg form-control">
                                            <!--automatically generated JS content here-->
                                        </select>
                                    </div>
                                    <div class='input-group'>
                                        <span class = "input-group-addon">#</span>
                                        <input id="editModal-add-hashtag-name" class="form-control" type="text"
                                               placeholder="Type a new hashtag to add" />
                                        <span class="input-group-btn">
                                            <button id="editModal-add-hashtag-btn" class="btn btn-secondary" type="button">Add</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class='form-group'>
                                <h3>Photo URL:</h3>   
                                <input id="edit-post-photoUrl" type='text' class="input-lg form-control"/>
                            </div>
                            <div class="form-group">
                                <h3>Synopsis</h3>
                                <textarea class="form-control input-lg" id="edit-post-synopsis"
                                          placeholder="Write a few sentences here to summarize the content of this post"></textarea>
                            </div>
                            <div class="form-group">
                                <h3>Content:</h3>
                                <textarea id="postsTinyMCE" class="tinyMCE"></textarea>
                                <br>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id='updatePostBtn' data-dismiss="modal" class='btn btn-lg btn-success'
                        type='submit'>Update Post</button>
            </div>
        </div>
    </div>
</div>