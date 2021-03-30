<div class="modal fade" id="game-edit-modal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <h2 id="game-edit-id"></h2>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-game-title" class="col-md-4 control-label">Title:</label>
                        <div class="col-md-8">
                            <input id="edit-game-title" name="title" type="text" class="form-control" placeholder="Title" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-game-publisher" class="col-md-4 control-label">Publisher:</label>
                        <div class="col-md-8">
                            <input id="edit-game-publisher" name="publisher" type="text" class="form-control" placeholder="Publisher" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-game-genre" class="col-md-4 control-label">Genre:</label>
                        <div class="col-md-8">
                            <input id="edit-game-genre" disposition="genre" type="text" class="form-control" placeholder="Genre" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-game-multiplayer" class="col-md-4 control-label">Multiplayer:</label>
                        <div class="col-md-8">
                            <input id="edit-game-multiplayer" name="multiplayer" type="checkbox" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-game-rating" class="col-md-4 control-label">ESRB Rating:
                            <div class="col-md-8">
                                <select class="form-control" id="edit-game-rating">
                                    <option>RP</option> 
                                    <option>EC</option> 
                                    <option>E</option> 
                                    <option>E10+</option> 
                                    <option>T</option> 
                                    <option>M</option> 
                                    <option>A</option> 
                                </select>
                            </div>
                        </label>

                    </div>                       
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit Game</button>
                        </div>
                    </div>  
                </form>

            </div>

        </div>
    </div>
</div>