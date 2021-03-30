/* global tinymce, tinyMCE */

$(document).ready(function () {

    loadActivePages();
    loadPagesInEditMode();
    //loadPagesUnpostedMode();


// MODAL SUBMIT BUTTONS FOR ADMIN-PAGES==============
    $('#saveNewPageBtn').click(function (event) {
        event.preventDefault();
        console.log(tinyMCE.activeEditor.getContent());
        addPage();
    });

    $('#updatePageBtn').click(function (event) {
        event.preventDefault();
        console.log(tinyMCE.activeEditor.getContent());
        editPage();
    });
//===================================================


    $("#edit-page-modal").on('show.bs.modal', function (event) {
        var element = $(event.relatedTarget);
        var pageID = element.data("page-id");
        loadEditModal(pageID);
    });
    
    
});


//=====================
//=====================
//      FUNCTIONS  
//=====================
//=====================


function loadActivePages() {
    $.ajax({
        url: "pages/active",
        type: "GET"
    }).success(function (data) {
        processActivePages(data);
    });
}

function processActivePages(pages) {//processes active posts
    $('#activePagesRows').empty();
    var approvedRows = $('#activePagesRows');
    var approvedRow = $("<tr style='width:100%;'>");

    $.each(pages, function (index, page) {
        var pageTitle = $("<td class='col-sm-9'>");
//        var pageTabID = $("<td>");
        var viewLinkTD = $("<td class='col-sm-1 adminButton'>");
        var unpostBtnTD = $("<td class='col-sm-1 adminButton'>");
//        var deleteBtnTD = $("<td class='col-sm-2'>");

        var viewLink = $("<a>").attr({
            'href': "/DolphinBlog/Dolphin/" + page.pageID,
            'method': 'GET',
            'style': "margin-right:20px;"
        });
        viewLinkTD.append(viewLink.text("View"));

        var unpostBtn = $("<button class='btn btn-info admin-button'>").attr({
            'style': "margin-right:20px;",
            'data-page-id': page.pageID
        });
        unpostBtnTD.append(unpostBtn.text("Unpost"));

//        var deleteBtn = $("<button class='btn btn-info admin-button'>");
//        deleteBtnTD.append(deleteBtn.text("Delete"));

        if (index % 1 === 0) {
            approvedRow = $("<tr>");
        }

        pageTitle.text(page.title);

        approvedRow.append(pageTitle);
        approvedRow.append(viewLinkTD);
        approvedRow.append(unpostBtnTD);

        approvedRows.append(approvedRow);

        unpostBtnTD.click(function (event) {
            event.preventDefault();

            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/UnpostPage/' + page.pageID
            }).success(function (data) {
                loadActivePages();
                loadPagesInEditMode();

            });
            $(this).text("UNPOSTED");
//        $(this).attr({
//            'class': "btn btn-danger",
//            'onclick': f()
//        });

        });

    });
}

function loadPagesInEditMode() {
    $.ajax({
        url: "pages/editmode",
        type: "GET"
    }).success(function (data) {
        processEditModePages(data);
    });

}
function loadPagesUnpostedMode() {
    $.ajax({
        url: "pages/unpostedmode",
        type: "GET"
    }).success(function (data) {
        processUnpostedPages(data);
    });

}


function processEditModePages(pages) {
    $('#editModePagesRows').empty();
    var editModeRows = $('#editModePagesRows');
    var editModeRow = $("<tr>");

    $.each(pages, function (index, page) {
        var pageTitle = $("<td class='col-sm-9'>");
        var editBtnTD = $("<td class='col-sm-1'>");
        var deleteBtnTD = $("<td class='col-sm-1'>");
        var postBtnTD = $("<td class='col-sm-1'>");

        var editBtn = $('<button data-toggle="modal" data-target="#edit-page-modal" data-page-id="' + page.pageID + '" \n\
                        class="btn btn-default adminButton" type="button">').attr({
            'style': "margin-right:20px;"
        });
        editBtnTD.append(editBtn.text("Edit"));

        var deleteBtn = $("<button class='btn btn-info adminButton'>").attr({
            'data-page-id': page.pageID
        });
        deleteBtnTD.append(deleteBtn.text("Delete"));

        var postBtn = $("<button class='btn btn-info adminButton'>").attr({
            'data-page-id': page.pageID
        });
        postBtnTD.append(postBtn.text("Post"));

        if (index % 1 === 0) {
            editModeRow = $("<tr>");
        }

        pageTitle.text(page.title);

        editModeRow.append(pageTitle);
        editModeRow.append(editBtnTD);
        editModeRow.append(postBtnTD);
        editModeRow.append(deleteBtnTD);


        editModeRows.append(editModeRow);

        postBtnTD.click(function (event) {
            event.preventDefault();

            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/PostPage/' + page.pageID
            }).success(function (data) {
                loadActivePages();
                loadPagesInEditMode();

            });
            $(this).text("POSTED");
//        $(this).attr({
//            'class': "btn btn-danger",
//            'onclick': f()
//        });

        });

        deleteBtnTD.click(function (event) {
            event.preventDefault();

            $.ajax({
                type: 'DELETE',
                url: '/DolphinBlog/DeletePage/' + page.pageID
            }).success(function (data) {
                loadActivePages();
                loadPagesInEditMode();

            });
            $(this).text("DELETED");
//        $(this).attr({
//            'class': "btn btn-danger",
//            'onclick': f()
//        });

        });

    });

}
function processUnpostedPages(pages) {
    $('#unpostedPagesRows').empty();
    var editModeRows = $('#unpostedPagesRows');
    var editModeRow = $("<tr>");

    $.each(pages, function (index, page) {
        var pageTitle = $("<td class='col-sm-9'>");
//        var editBtnTD = $("<td class='col-sm-1'>");
//        var deleteBtnTD = $("<td class='col-sm-1'>");
        var postBtnTD = $("<td class='col-sm-1'>");

//        var editBtn = $('<button data-toggle="modal" data-target="#edit-page-modal" data-page-id="' + page.pageID + '" \n\
//                        class="btn btn-default adminButton" type="button">').attr({
//            'style': "margin-right:20px;"
//        });
//        editBtnTD.append(editBtn.text("Edit"));
//
//        var deleteBtn = $("<button class='btn btn-info adminButton'>").attr({
//            'data-page-id': page.pageID
//        });
//        deleteBtnTD.append(deleteBtn.text("Delete"));

        var postBtn = $("<button class='btn btn-info adminButton'>").attr({
            'data-page-id': page.pageID
        });
        postBtnTD.append(postBtn.text("Post"));

        if (index % 1 === 0) {
            editModeRow = $("<tr>");
        }

        pageTitle.text(page.title);
//
        editModeRow.append(pageTitle);
//        editModeRow.append(editBtnTD);
        editModeRow.append(postBtnTD);
//        editModeRow.append(deleteBtnTD);


        editModeRows.append(editModeRow);

        postBtnTD.click(function (event) {
            event.preventDefault();

            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/PostPage/' + page.pageID
            }).success(function (data) {

            });
            $(this).text("POSTED");
//        $(this).attr({
//            'class': "btn btn-danger",
//            'onclick': f()
//        });

        });

//        deleteBtnTD.click(function (event) {
//        event.preventDefault();
//        
//        $.ajax({
//            type: 'DELETE',
//            url: '/DolphinBlog/DeletePage/' + page.pageID
//        }).success(function (data) {
//
//        });
//        $(this).text("DELETED");
////        $(this).attr({
////            'class': "btn btn-danger",
////            'onclick': f()
////        });
//
//    });

    });

}



function addPage() {
    var pageTitle = $("#add-page-title").val();
    var pageTabId = $("#add-page-tab-select").val();
    var pageContent = tinyMCE.activeEditor.getContent();

    var data = JSON.stringify({
// DTO variable name : variable from above
        title: pageTitle,
        tabId: pageTabId,
        content: pageContent
    });
    console.log(data);

    $.ajax({
        url: 'page/add',
        type: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        data: data
    }).success(function (data) {
        loadPagesInEditMode();
        //here we empty the form
        $("#add-page-title").val("");
        $("#add-page-tab-select").prop('selectedIndex', 0);
        tinyMCE.activeEditor.setContent(' ');
        tinyMCE.get('#edit-page-content').setContent(' ');
    });

}

function loadEditModal(pageID) {
    $.ajax({
        type: 'GET',
        url: 'loadEditPageModal/' + pageID,
        headers: {
            'Accept': 'application/json'
        }
    }).success(function (page) {
        $('#updatePageBtn').attr({
            "data-post-id": page.pageID
        });
        $('#edit-page-title').val(page.title);
        $('#edit-page-tab-select').val(page.tabId);
        tinyMCE.activeEditor.setContent(page.content, {format: 'raw'});
    });
}

function editPage() {
    var pageID = $('#updatePageBtn').data("post-id");
    var pageTitle = $("#edit-page-title").val();
    var pageTabId = $("#edit-page-tab-select").val();
    var pageContent = tinyMCE.activeEditor.getContent();

    var data = JSON.stringify({
// DTO variable name : variable from above
        title: pageTitle,
        tabId: pageTabId,
        content: pageContent
    });
    console.log(data);

    $.ajax({
        url: 'page/update/' + pageID,
        type: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        'dataType': 'json',
        data: data
    }).success(function (data) {
        loadPagesInEditMode();
        //here we empty the form
        $("#edit-page-title").val("");
        $("#edit-page-tab-select").prop('selectedIndex', 0);
        tinyMCE.activeEditor.setContent(' ');
//        tinyMCE.get('#edit-page-content').setContent(' ');
    });

}




//

//    console.log(data);
//    $.ajax({
//        url: 'post/update/' + postID,
//        type: 'PUT',
//        headers: {
//            'Content-Type': 'application/json'
//        },
//        'dataType': 'json',
//        data: data
//    }).success(function (data) {
//        $("#edit-post-title").val("");
//        $("#edit-post-author").val("");
//        $("#edit-post-category").prop('selectedIndex', 0);
//        $("#edit-post-photoUrl").val("");
//        tinyMCE.activeEditor.setContent('');
//        $("#edit-post-synopsis").val("");
//        $('#edit-post-hashtags > option').removeAttr("selected");
//        loadAdminPageApprove();
//        loadAdminPageWait();
//        loadAdminPageWaitE();
//        loadEditModePosts();
//    });
//
//}




//tinymce.init({
//    selector: '.tinyMCE',
//    height: 300,
////                skin: 'charcoal', // can be used to specify a custom skin. See http://skin.tinymce.com/
//    plugins: [
//        'advlist autolink autosave charmap hr link lists print preview ',
//        ' wordcount visualblocks visualchars image imagetools',
//        'table contextmenu emoticons template',
//        'paste searchreplace textcolor'
//    ],
//    // "contextmenu" refers to the menu options available when the user right-clicks
//    contextmenu: "link image",
//    imagetools_toolbar: "rotateleft rotateright | flipv fliph | editimage imageoptions",
////                imagetools_cors_hosts: ['imgur.com', 'otherdomain.com'], //we may need to use this option if we hook up an imgur acct
////                content_css:'css/dolphinstyles.css',  //link to internal style sheet
//    toolbar: 'insertfile undo redo | styleselect | forecolor bold italic underline | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link charmap image emoticons | preview'

//});

