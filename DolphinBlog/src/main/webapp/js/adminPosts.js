

/* global tinyMCE, tinymce */

$(document).ready(function () {

    loadAdminPageApprove();
    loadAdminPageWait();
    loadAdminPageWaitE();
    loadEditModePosts();
    loadHashtagSelectMenu();
    loadHashtagSelectMenuOfEditModal();




    $('#editModal-add-hashtag-btn').click(function (event) {
        var newHashtag = $('#editModal-add-hashtag-name').val();
        $.ajax({
            type: 'POST',
            url: 'posts/addhashtag',
            data: newHashtag
        }).success(function () {
            $('#editModal-add-hashtag-name').val('');
            loadHashtagSelectMenuOfEditModal();
        });
    });

    $('#add-hashtag-btn').click(function (event) {
        var newHashtag = $('#add-hashtag-name').val();
        $.ajax({
            type: 'POST',
            url: 'posts/addhashtag',
            data: newHashtag
        }).success(function () {
            $('#add-hashtag-name').val('');
            loadHashtagSelectMenu();
        });
    });

//this should be emptying the edit post modal of updated data
    $("#edit-post-modal").on('hidden.bs.modal', function () {
        $(this).find("input,textarea,select").val('').end();

    });

    $("#edit-post-modal").on('show.bs.modal', function (event) {
        var element = $(event.relatedTarget);
        var postID = element.data("post-id");
        loadHashtagSelectMenuOfEditModal();
        loadEditModal(postID);
    });


//TINYMCE MODAL BUTTONS STUFF================================
    //this is the save button from the Add Post Modal
    $('#saveNewPostBtn').click(function (event) {
        event.preventDefault();
        addPost();
        console.log(tinyMCE.activeEditor.getContent());
    });


    $('#updatePostBtn').click(function (event) {
        event.preventDefault();
        editPost();
    });


//   END TINYMCE STUFF============================

    $('#post-search-button').click(function (event) {
        $('#approvedRows').empty();
        event.preventDefault();

        var searchInput = $('#post-search').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/searchfor/' + searchInput
        }).success(function (data) {
            //$('#divToFillSearch').empty();
            processApprovedPosts(data);


        });//should clear the div to fill and populate it with posts returned from the search
    });



});

//============================================
//================== FUNCTIONS ===============
//============================================
//============================================
//============================================



function loadAdminPageWait() {
    $.ajax({
        url: "posts/waitposts",
        type: "GET"
    }).success(function (data) {
        processWaitPosts(data);

    });

}
function loadAdminPageWaitE() {
    $.ajax({
        url: "posts/waitposts",
        type: "GET"
    }).success(function (data) {

        processWaitPostsEmployee(data);
    });

}
function loadEditModePosts() {
    $.ajax({
        url: "posts/editposts",
        type: "GET"
    }).success(function (data) {
        processEditPosts(data);
    });

}




function loadEditModal(postID) {
    $.ajax({
        type: 'GET',
        url: 'loadEditModal/' + postID,
        headers: {
            'Accept': 'application/json'
        }
    }).success(function (post) {
        //I put the postID in the button so it's accessible when we update
        $('#updatePostBtn').attr({
            "data-post-id": post.postID
        });
        $('#edit-post-title').val(post.title);
        $('#edit-post-author').val(post.author);
        $('#edit-post-category').val(post.categoryId).change();
        $('#edit-post-hashtags').val(post.hashtags).change();
        $('#edit-post-photoUrl').val(post.photoUrl);
        $('#edit-post-synopsis').val(post.synopsis);
        tinyMCE.activeEditor.setContent(post.content, {format: 'raw'});
    });
}




function loadHashtagSelectMenu() {
    $.ajax({
        url: "posts/hashtags",
        type: "GET"
    }).success(function (hashtags) {
        var hashtagOptions = $('#add-post-hashtags');
        hashtagOptions.empty();
        $.each(hashtags, function (index, hashtag) {
            hashtagOptions.append($('<option>').attr({'value': hashtag})
                    .text("#" + hashtag));
        });
    });
}

function loadHashtagSelectMenuOfEditModal() {
    $.ajax({
        url: "posts/hashtags",
        type: "GET"
    }).success(function (hashtags) {
        var hashtagOptions = $('#edit-post-hashtags');
        hashtagOptions.empty();
        $.each(hashtags, function (index, hashtag) {
            hashtagOptions.append($('<option>').attr({'value': hashtag})
                    .text("#" + hashtag));
        });
    });
}







function loadAdminPageApprove() {
    $.ajax({
        url: "posts/approvedposts",
        type: "GET"
    }).success(function (data) {
        processApprovedPosts(data);
    });
}

function processApprovedPosts(posts) {//processes active posts
    $('#approvedRows').empty();
    var approvedRows = $('#approvedRows');
    var approvedRow = $("<tr>");

    $.each(posts, function (index, post) {
        var admintitle = $("<td>");
        var adminId = $("<td>");

        var viewLink = $("<a>").attr({
            'href': "/DolphinBlog/blogpost/" + post.postID,
            'method': 'GET',
            'style': "margin-right:20px;"
        });
        var unpostBtn = $("<button class='btn btn-info admin-button'>").attr({
            'style': "margin-right:20px;"
        });
        var deleteBtn = $("<button class='btn btn-info admin-button'>");

        viewLink.text("View");
        unpostBtn.text("Unpost");
        deleteBtn.text("Delete");

        if (index % 1 === 0) {
            approvedRow = $("<tr>");
        }

        admintitle.text(post.title);
        adminId.text(post.postID);

        approvedRow.append(adminId);
        approvedRow.append(admintitle);
        approvedRow.append(viewLink);
        approvedRow.append(unpostBtn);
        approvedRow.append(deleteBtn);


        approvedRows.append(approvedRow);

        unpostBtn.click(function (event) {
            event.preventDefault();
            fUpdate(post.postID);
            $(this).text("UNPOSTED");
            $(this).attr({
                'class': "btn btn-danger",
                'onclick': f()
            });
        });
        deleteBtn.click(function (event) {
            event.preventDefault();
            fDelete(post.postID);
            $(this).text("DELETED");
            $(this).attr({
                'class': "btn btn-danger",
                'onclick': f()
            });
        });
    });
    function fUpdate(id) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: '/DolphinBlog/Unpost/' + id
        }).success(function () {
            loadAdminPageApprove();
            loadEditModePosts();
        });
//     $(this).text("UNPOSTED");
//        $(this).attr({
//            'class': "btn btn-danger",
//            'onclick': f()
//        });


    }
    function fDelete(id) {
        event.preventDefault();
        $.ajax({
            type: 'DELETE',
            url: '/DolphinBlog/post/delete/' + id
        }).success(function () {
            loadAdminPageApprove();
        });
//    
    }
}





function addPost() {
//  VAR NEEDED IN FORM
//  title;
//  author;
//  categoryId (dropdown in html)
//  List<String> hashtags;  OPTIONAL
//  content;
//  photoUrl;
//  synopsis;
//    
//  AUTO_ASSIGNED VAR
//  postID - assigned automatically in the DB
//  statusId is set by DEFAULT to Edit Mode when entered into the database;
//  pubDate - automatically timestamped in DB
//  likes -- automatically set to 0 ON INSERT in the database
//  List<String> comments - set to null


    var postTitle = $("#add-post-title").val();
    var postAuthor = $("#add-post-author").val();
    var postCategory = $("#add-post-category").val();
    var postPhotoUrl = $("#add-post-photoUrl").val();
    var postContent = tinyMCE.activeEditor.getContent();
    var postSynopsis = $("#add-post-synopsis").val();
    var postHashtags = [];
    $('#add-post-hashtags > option').each(function () {
        if (this.selected === true) {
            postHashtags.push(this.value);
        }
    });
    var data = JSON.stringify({
// DTO variable name : variable from above
        title: postTitle,
        author: postAuthor,
        categoryId: postCategory,
        photoUrl: postPhotoUrl,
        synopsis: postSynopsis,
        content: postContent,
        hashtags: postHashtags

    });
    console.log(data);
    $.ajax({
        url: 'post/add',
        type: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        data: data
    }).success(function (data) {
        //Here we refresh the Edit Mode/Employee section so the new one appears
        loadAdminPageApprove();
        loadAdminPageWait();
        loadAdminPageWaitE();
        loadEditModePosts();
        //here we empty the form
        $("#add-post-title").val("");
        $("#add-post-author").val("");
        $("#add-post-category").prop('selectedIndex', 0);
        $("#add-post-photoUrl").val("");
        tinyMCE.activeEditor.setContent('');
        tinymce.activeEditor.setContent('');
//        tinyMCE.get('#addPostsTinyMCE').setContent(" ");
        $("#add-post-synopsis").val("");
        $('#add-post-hashtags > option').removeAttr("selected");
    });

}


function editPost() {
//  VAR NEEDED IN FORM
//  postID -  used as a path variable to show which post to updated
//  title
//  author
//  categoryId (dropdown in html)
//  photoUrl
//  content
//  synopsis
//  List<String> hashtags;  OPTIONAL
//    
//   OTHER PROPERTIES

//  statusId is changed elsewhere (by the admin buttons in the html)
//  pubDate - has already been timestamped in DB
//  likes -- not changeable
//  List<String> comments - can't be edited here

    //the id (next line) is smuggled into the Update Button when
    //the edit Modal is loaded with all the other data
    var postID = $('#updatePostBtn').data("post-id");

    var postTitle = $("#edit-post-title").val();
    var postAuthor = $("#edit-post-author").val();
    var postCategory = $("#edit-post-category").val();
    var postPhotoUrl = $("#edit-post-photoUrl").val();
    var postContent = tinyMCE.activeEditor.getContent();
    var postSynopsis = $("#edit-post-synopsis").val();
    var postHashtags = [];
    $('#edit-post-hashtags > option').each(function () {
        if (this.selected === true) {
            postHashtags.push(this.value);
        }
    });
    var data = JSON.stringify({
// DTO variable name : variable from above
        title: postTitle,
        author: postAuthor,
        categoryId: postCategory,
        photoUrl: postPhotoUrl,
        synopsis: postSynopsis,
        content: postContent,
        hashtags: postHashtags

    });
    console.log(data);
    $.ajax({
        url: 'post/update/' + postID,
        type: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        data: data
    }).success(function (data) {
        $("#edit-post-title").val("");
        $("#edit-post-author").val("");
        $("#edit-post-category").prop('selectedIndex', 0);
        $("#edit-post-photoUrl").val("");
        tinyMCE.activeEditor.setContent('');
        $("#edit-post-synopsis").val("");
        $('#edit-post-hashtags > option').removeAttr("selected");
        loadAdminPageApprove();
        loadAdminPageWait();
        loadAdminPageWaitE();
        loadEditModePosts();
    });

}

function processWaitPosts(posts) {
    $('#waitRows').empty();
    var waitRows = $('#waitRows');
    var waitRow = $("<tr>");

    $.each(posts, function (index, post) {
        var postTitle = $("<td>");
        var postId = $("<td>");

        
        var editBtn = $('<button class="adminButton btn btn-default" data-toggle="modal" data-target="#edit-post-modal" data-post-id="' + post.postID + '" \n\
                         value="Edit Post" type="button" style="margin-right:20px;">');
        var rejectBtn = $("<button class='btn btn-info' style='margin-right:20px;'>");
        var postBtn = $("<button class='btn btn-info' style='margin-right:20px;'>");
        var deleteBtn = $("<button class='btn btn-info' style='margin-right:20px;'>");

        editBtn.text("Edit");
        rejectBtn.text("Reject");
        postBtn.text("Post");
        deleteBtn.text("Delete");

        if (index % 1 === 0) {
            waitRow = $("<tr>");
        }

        postTitle.text(post.title);
        postId.text(post.postID);

        waitRow.append(postId);
        waitRow.append(postTitle);
        waitRow.append(editBtn);
        waitRow.append(rejectBtn);
        waitRow.append(postBtn);
        waitRow.append(deleteBtn);

        waitRows.append(waitRow);

        rejectBtn.click(function (event) {
            event.preventDefault();
            fReject(post.postID);
            $(this).text("REJECTED");

        });
        postBtn.click(function (event) {
            event.preventDefault();
            fPost(post.postID);
            $(this).text("POSTED");

        });
        deleteBtn.click(function (event) {
            event.preventDefault();
            fDelete(post.postID);
            $(this).text("DELETED");

        });
        function fReject(id) {
            event.preventDefault();
            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/reject/' + id
            }).success(function () {
                loadAdminPageApprove();
                loadAdminPageWait();
                loadAdminPageWaitE();
                loadEditModePosts();
            });



        }
        function fPost(id) {
            event.preventDefault();
            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/postit/' + id
            }).success(function () {
                loadAdminPageApprove();
                loadAdminPageWait();
                loadAdminPageWaitE();
                loadEditModePosts();
            });



        }
        function fDelete(id) {
            event.preventDefault();
            $.ajax({
                type: 'DELETE',
                url: '/DolphinBlog/post/delete/' + id
            }).success(function () {
                loadAdminPageApprove();
                loadAdminPageWait();
                loadAdminPageWaitE();
                loadEditModePosts();
            });
//    
        }

    });



}
function processWaitPostsEmployee(posts) {
    $('#waitRowsEmployee').empty();
    var waitRows = $('#waitRowsEmployee');
    var waitRow = $("<tr>");

    $.each(posts, function (index, post) {
        var postTitle = $("<td>");
        var postId = $("<td>");





        if (index % 1 === 0) {
            waitRow = $("<tr>");
        }

        postTitle.text(post.title);
        postId.text(post.postID);

        waitRow.append(postId);
        waitRow.append(postTitle);


        waitRows.append(waitRow);


    });



}

function processEditPosts(posts) {
    $('#editRows').empty();
    var editRows = $('#editRows');
    var rowTrElement = $("<tr>");

    $.each(posts, function (index, post) {
        var titleTdElement = $("<td>");
        var postId = $("<td>");

//        <tr>
//            <th scope="row"><h3 style="margin:0px;">1</h3></th>
//            <td><h3 style="margin:0px;">Soviet Exile Drowned at Sea World</h3></td>
//            <td class = "adminButton"><button type="button" class="btn btn-success">View</button></td>
//            <td style="width:50px;"><button type="button" class="btn btn-warning">Unpost</button></td>
//            <td class = "adminButton"><button type="button" class="btn btn-danger" >Delete</button></td>
//        </tr>

        var editBtn = $('<button style="margin-right:20px;" data-toggle="modal" data-target="#edit-post-modal" data-post-id="' + post.postID + '" \n\
                        class="adminButton btn btn-default" value="Edit Post" type="button">');
        var submitBtn = $("<button class='btn btn-info'>");

        editBtn.text("Edit");
        submitBtn.text("Submit");

        if (index % 1 === 0) {
            rowTrElement = $("<tr>");
        }

        titleTdElement.text(post.title);
        postId.text(post.postID);

        rowTrElement.append(postId);
        rowTrElement.append(titleTdElement);
        rowTrElement.append(editBtn);
        rowTrElement.append(submitBtn);

        editRows.append(rowTrElement);

        submitBtn.click(function (event) {
            event.preventDefault();
            fsubmit(post.postID);
            $(this).text("SUBMITED");

        });

        function fsubmit(id) {
            event.preventDefault();
            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/submit/' + id
            }).success(function () {
                loadAdminPageApprove();
                loadAdminPageWait();
                loadAdminPageWaitE();
                loadEditModePosts();
                loadAdminEditPage();
            });
//    
        }

    });

}


