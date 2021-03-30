$(document).ready(function () {
    loadGames();
    $("#add-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'game',
            data: JSON.stringify({
                title: $("#add-game-title").val(),
                publisher: $("#add-game-publisher").val(),
                genre: $("#add-game-genre").val(),
                isMultiplayer: $("#add-game-multiplayer").prop('checked'),
                esrbRating: $("#add-game-rating").val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            loadGames();
            $("#add-game-title").val('');
            $("#add-game-publisher").val('');
            $("#add-game-genre").val('');
            $("#add-game-multiplayer").prop('checked', false);
            $("#add-game-rating").val('RP');
        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });

    });
    $("#edit-button").click(function (event) {
        event.preventDefault(); // stops submit from button
        editGame();

    });
    $('#search-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/games',
            data: JSON.stringify({
                title: $("#add-game-title").val(),
                publisher: $("#add-game-publisher").val(),
                genre: $("#add-game-genre").val(),
                isMultiplayer: $("#add-game-multiplayer").prop('checked'),
                esrbRating: $("#add-game-rating").val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            clearGameTable();

            $("#add-game-title").val('');
            $("#add-game-publisher").val('');
            $("#add-game-genre").val('');
            $("#add-game-multiplayer").prop('checked', false);
            $("#add-game-rating").val('');
           fillGameTable(data, status);
        });
    });
    $("#game-details-modal").on('show.bs.modal', function (event) {
        var element = $(event.relatedTarget);
        var gameId = element.data('game-id');
        gameDetails(gameId);
    });
    $("#game-edit-modal").on('show.bs.modal', function (event) {
        var element = $(event.relatedTarget);
        var gameId = element.data('game-id'); 
        gameEditDetails(gameId);
    });
});

function clearGameTable() {
    $('#gameRows').empty();
}

function processGameList(games) {

    var gameRows = $('#gameRows');
    $.each(games, function (index, game) {

        var titleField = $("<td>");
        var publisherField = $("<td>");
        var editField = $("<td>");
        var deleteField = $("<td>");
        var titleLink = $("<a>");
        titleLink.attr({'data-toggle': 'modal',
            'data-target': '#game-details-modal',
            'data-game-id': game.id});
        titleLink.text(game.title);
        titleField.append(titleLink);
        publisherField.text(game.publisher);
        var editLink = $("<a>");
        editLink.attr({'data-toggle': 'modal', 'data-target': '#game-edit-modal',
            'data-game-id': game.id});
        editLink.text("Edit");
        editField.append(editLink);
        var deleteLink = $("<a>");
        deleteLink.attr({
            'onclick': 'removeGame(' + game.id + ')'
        });
        deleteLink.text("Delete");
        deleteField.append(deleteLink);
        var gameRow = $("<tr>");
        gameRow.append(titleField);
        gameRow.append(publisherField);
        gameRow.append(editField);
        gameRow.append(deleteField);
        gameRows.append(gameRow);
    });
}
function fillGameTable(gameList, status) {
    var gameRows = $('#gameRows');
    $.each(gameList, function (index, game) {

        var titleField = $("<td>");
        var publisherField = $("<td>");
        var editField = $("<td>");
        var deleteField = $("<td>");
        var titleLink = $("<a>");
        titleLink.attr({'data-toggle': 'modal',
            'data-target': '#game-details-modal',
            'data-game-id': game.id});
        titleLink.text(game.title);
        titleField.append(titleLink);
        publisherField.text(game.publisher);
        var editLink = $("<a>");
        editLink.attr({'data-toggle': 'modal', 'data-target': '#game-edit-modal',
            'data-game-id': game.id});
        editLink.text("Edit");
        editField.append(editLink);
        var deleteLink = $("<a>");
        deleteLink.attr({
            'onclick': 'removeGame(' + game.id + ')'
        });
        deleteLink.text("Delete");
        deleteField.append(deleteLink);
        var gameRow = $("<tr>");
        gameRow.append(titleField);
        gameRow.append(publisherField);
        gameRow.append(editField);
        gameRow.append(deleteField);
        gameRows.append(gameRow);
    });
}

function loadGames() {


    var gameContents = $('#gameRows');
    clearGameTable();
    $.ajax({
        url: 'games'
    }).success(function (data, status) {
        fillGameTable(data, status);
    });
}

function editGame() {

    var gameId = $("#game-edit-id").text();
    var gameTitle = $("#edit-game-title").val();
    var gamePublisher = $("#edit-game-publisher").val();
    var gameGenre = $("#edit-game-genre").val();
    var gameMultiplayer = $("#edit-game-multiplayer").prop('checked');
    var gameRating = $("#edit-game-rating").val();
    $.ajax({
        url: 'game/' + gameId,
        type: 'PUT',
        headers: {
            'Accept': 'application/json', 
            'Content-Type': 'application/json' 
        },
        'dataType': 'json', 


        data: JSON.stringify({
            id: gameId,
            title: gameTitle,
            publisher: gamePublisher,
            genre: gameGenre,
            isMultiplayer: gameMultiplayer,
            esrbRating: gameRating
          
        })

    }).success(function (data) {

        loadGames();
    });
}

function  removeGame(id) {
    $.ajax({
        url: 'game/' + id,
        type: 'DELETE'
    }).success(function () {

        loadGames();
    });
}

function gameDetails(id) {

    $.ajax({
        url: 'game/' + id,
        type: 'GET',
        headers: {
            'Accept': 'application/json'

        }
    }).success(function (game) {
        $("#game-detail-id").text(game.id);
        $("#game-detail-title").text(game.title);
        $("#game-detail-publisher").text(game.publisher);
        $("#game-detail-genre").text(game.genre);
        $("#game-detail-multiplayer").text(game.isMultiplayer);
        $("#game-detail-rating").text(game.esrbRating);
    });
}
function gameEditDetails(id) {

    $.ajax({
        url: 'game/' + id,
        type: 'GET',
        headers: {
            'Accept': 'application/json'

        }
    }).success(function (game) {
    $("#game-edit-id").text(game.id);
    $("#edit-game-title").val(game.title);
    $("#edit-game-publisher").val(game.publisher);
    $("#edit-game-genre").val(game.genre);
    $("#edit-game-multiplayer").prop('checked', game.isMultiplayer);
    $("#edit-game-rating").val(game.esrbRating);
    });
}


