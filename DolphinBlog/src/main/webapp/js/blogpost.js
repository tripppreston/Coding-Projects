$(document).ready(function () {
    $('#refreshPageMsg').hide();
    

$('#addCommentBtn').click(function (event) {
    event.preventDefault();
        var newComment = $('#newCommentBox').val();
        var postID = $('#secret-post-id-div').text();
//        var data = JSON.stringify({
//        newComment: newComment
//    });
        $.ajax({
            type: 'POST',
            url: 'addComment/' + postID,
            headers: {
              'Content-Type':'text/plain'
            },
            dataType:'text',
            data: newComment
        }).success(function () {
            $('#newCommentBox').val(' ');
            $("#commentDiv").fadeOut(2000);
            $('#refreshPageMsg').show();
            
        });
    });


});

