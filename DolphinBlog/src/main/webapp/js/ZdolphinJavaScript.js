/* global tinyMCE, tinymce */

$(document).ready(function () {

    loadMainPage();
    loadMainPagePopular();
    hashLoadFront();
//    loadHashtagSelectMenu();    //
//    loadAdminPageApprove();
//    loadAdminPageWait();
//    loadAdminEditPage();
    

//    $('#editModal-add-hashtag-btn').click(function (event) {
//        var newHashtag = $('#editModal-add-hashtag-name').val();
//        $.ajax({
//            type: 'POST',
//            url: 'posts/addhashtag',
//            data: newHashtag
//        }).success(function () {
//            $('#editModal-add-hashtag-name').val('');
//            loadHashtagSelectMenuOfEditModal();
//        });
//    });
//
//    $('#add-hashtag-btn').click(function (event) {
//        var newHashtag = $('#add-hashtag-name').val();
//        $.ajax({
//            type: 'POST',
//            url: 'posts/addhashtag',
//            data: newHashtag
//        }).success(function () {
//            $('#add-hashtag-name').val('');
//            loadHashtagSelectMenu();
//        });
//    });
//
//
//
//    $("#edit-post-modal").on('show.bs.modal', function (event) {
//        var element = $(event.relatedTarget);
//        var postID = element.data("post-id");
//        loadHashtagSelectMenuOfEditModal();
//        loadEditModal(postID);
//    });


//
////TINYMCE MODAL BUTTONS STUFF================================
//    //this is the save button from the Add Post Modal
//    $('#saveNewPostBtn').click(function (event) {
//        event.preventDefault();
//        addPost();
//        console.log(tinyMCE.activeEditor.getContent());
//    });
//
//
//    $('#updatePostBtn').click(function (event) {
//        event.preventDefault();
//        editPost();
//    });
//
//
////END TINYMCE STUFF============================



    $('#search-button').click(function (event) {
        event.preventDefault();
        var searchInput = $('#search-field').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/searchfor/' + searchInput

        }).success(function (data) {
            $('#divToFill').empty();
            processPosts(data);
        });

    });

    $('#search-button2').click(function (event) {
        event.preventDefault();
        $('#divToFillSearch').empty();
        var searchInput = $('#search-field2').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/searchfor/' + searchInput
        }).success(function (data) {
            //$('#divToFillSearch').empty();
            processSearchPosts(data);


        });//should clear the div to fill and populate it with posts returned from the search
    });


//    var searchInput=$('#search-field2').val();
//    $('#search-button2').attr({
//        
//         type: 'GET',
//         url: '/DolphinBlog/search/' + searchInput
//    });



    $('#training-link').click(function (event) {
        event.preventDefault();
        //var searchInput=$('#search-field').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/category/' + 1
        }).success(function (data) {

            $('#divToFill').empty();
            processPosts(data);

        });//should clear the div to fill and populate it with posts returned from the search
    });

    $('#travels-link').click(function (event) {
        event.preventDefault();
        //var searchInput=$('#search-field').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/category/' + 2
        }).success(function (data) {

            $('#divToFill').empty();
            processPosts(data);

        });//should clear the div to fill and populate it with posts returned from the search
    });

    $('#style-link').click(function (event) {
        event.preventDefault();
        //var searchInput=$('#search-field').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/category/' + 3
        }).success(function (data) {

            $('#divToFill').empty();
            processPosts(data);

        });//should clear the div to fill and populate it with posts returned from the search
    });
    $('#mission-link').click(function (event) {
        event.preventDefault();
        //var searchInput=$('#search-field').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/category/' + 4
        }).success(function (data) {

            $('#divToFill').empty();
            processPosts(data);

        });//should clear the div to fill and populate it with posts returned from the search
    });
    $('#other-link').click(function (event) {
        event.preventDefault();
        //var searchInput=$('#search-field').val();
        $.ajax({
            type: 'GET',
            url: '/DolphinBlog/category/' + 5
        }).success(function (data) {

            $('#divToFill').empty();
            processPosts(data);
        });//should clear the div to fill and populate it with posts returned from the search
    });

    $('.delete-comment-button').click(function (event) {
        event.preventDefault();
        var commentID = $.parseJSON($(this).attr('data-comment-id'));
        $.ajax({
            type: 'DELETE',
            url: '/DolphinBlog/RemoveComment/' + commentID
        }).success(function (data) {

        });
        $(this).text("DELETED");
        $(this).attr({
            'class': "btn btn-danger",
            'onclick': f()
        });

    });

    $('#like-button-test-page').click(function (event) {
        var id = $('#secret-post-id-div').html();



        $.ajax({
            type: 'PUT',
            url: '/DolphinBlog/like/' + id
        }).success(function () {
        });

        var likeCount = $('#secret-likes-div').html();
        var newLike = +likeCount + 1;
        var newLikeText = newLike.toString();
        $('#like-text-test-page').empty();


        $('#likes-display').attr({
            'style': " font-family: 'Oswald', sans-serif;display:inline-block;"

        });
        $('#likes-display').text("(" + newLikeText + ")").attr({
        });

        $('#like-text-test-page').append("<h3>").append('<span>').attr({
            'class': "glyphicon glyphicon-thumbs-up",
            'style': "display:inline-block"

        });

    });


});




function loadMainPage() {
    $.ajax({
        url: "/DolphinBlog/blogposts",
        type: "GET"
    }).success(function (data) {
        processPosts(data);
        //processPopularPosts(data);
    });
}
function loadMainPagePopular() {
    $.ajax({
        url: "/DolphinBlog/blogposts/popular",
        type: "GET"
    }).success(function (data) {
       
        processPopularPosts(data);
    });
}



function processPosts(posts) {
    var postDiv = $('#divToFill');
    postDiv.attr({
     
    });
    

    $.each(posts, function (index, post) {
        var IDl = "like" + post.postID;
        var IDlc = "likes" + post.postID;
        var IDn = "num" + post.postID;
        var IDnc = "nums" + post.postID;
        var IDlhash = "#" + IDl;
        var IDlchash = "#" + IDlc;
        var IDnhash = "#" + IDn;
        var IDnchash = "#" + IDnc;

        var coma = post.comments;
        var com = coma.length;

        postDiv.append($("<div class='blogDiv' >")
                .append($("<div>")
                .attr({
                    'class': "col-md-12 recent",
                    'data-post-id': post.postID
                })
                .append($("<div>")
                        .attr({
                            'class': "col-md-6 col-md-offset-2"
                        })
                        .append($("<h3>")
                                .append($("<a>")
                                        .attr({
                                            'href': "blogpost/" + post.postID,
                                            'method': 'GET'
                                            

                                        })
                                        .append(post.title))))
                .attr({
                    'class': "title-md"
            
                })
                .append($("<div>")
                        .attr({
                            'class': "col-md-3"
                        }).append($("<h4>")
                        .attr({
                            'class': "date-md"
                        })
                        .text(convertDate(post.pubDate))))
                .append($("<div>")
                        .attr({
                            'class': "pic-div-md col-md-6 col-md-offset-2"
                        })
                        .append($("<img>")
                                .attr({
                                    'src': post.photoUrl,
                                    'class': "pic-md image-responsive img-rounded"
                                    
                                })))
                .append($("<div>")
                        .attr({
                            'class': "text-div-md col-md-8 col-md-offset-2"
                    //'style': "background-color:white;"
                        })
                        .append($("<p>")
                                .text(post.synopsis)))
                .append($("<div>")
                        .attr({
                            'class': "col-xs-3 col-xs-offset-2"
                    //'style': "margin-bottom:80px;background-color:white;"
                        })
                        .append($("<h3>")
                                .text("( "+ com +" )")
                                .append($("<span>")
                                        .attr({
                                            'class': "glyphicon glyphicon-comment"
                                        }))))
                .append($("<div>")
                        .attr({
                            'class': "col-xs-3 col-xs-offset-3"
                    //'style': "margin-bottom:80px;background-color:white;"
                        })
                        .append($("<h3>").attr({
                            'id': IDn
                        })
                                .text("( " + post.likes + " )").append($("<a>").attr({
                            'id': IDl
                                    // 'onclick': fLikeMain(post.postID,post.likes)
                        })
                                .append($("<span>")
                                        .attr({
                                            'class': "glyphicon glyphicon-thumbs-up"
                                        })))))
                ));
        //var likeCount = $(IDnhash).text();
        var newLike = +post.likes + 1;
        var newLikeText = newLike.toString();
        $(IDlhash).click(function (event) {
            event.preventDefault();
            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/like/' + post.postID
            }).success(function () {


                //loadInventory3();
            });
            $(IDlhash).attr({
                'style': 'color:white;',
                'onclick': 'f();'
            });
            $(IDnhash).empty();
            $(IDnchash).empty();
            $(IDnhash).text("( " + newLikeText + " )");
            $(IDnchash).text("( " + newLikeText + " )");
            $(IDnhash).append($("<span>").attr({
                'class': "glyphicon glyphicon-thumbs-up"
            }));
            $(IDnchash).append($("<span>").attr({
                'class': "glyphicon glyphicon-thumbs-up"
            }));


        });
    });


}




function fLikeMain(id, likes) {
    $.ajax({
        type: 'PUT',
        url: '/like/' + id
    }).success(function () {
        //loadInventory3();
    });

    $('#like1').attr({
        'style': "color:black;"
    });
}




function hashLoadFront() {
    $.ajax({
        type: 'GET',
        url: '/DolphinBlog/HashtagsMain/'
    }).success(function (hashtags) {
        var hashTagArray = new Array;
        var hashtagText1 = $('#hash-text-1');
        var hashtagLink1 = $('#hash-link-1');
        var hashtagText2 = $('#hash-text-2');
        var hashtagLink2 = $('#hash-link-2');
        var hashtagText3 = $('#hash-text-3');
        var hashtagLink3 = $('#hash-link-3');
        var hashtagText4 = $('#hash-text-4');
        var hashtagLink4 = $('#hash-link-4');
        var hashtagText5 = $('#hash-text-5');
        var hashtagLink5 = $('#hash-link-5');
        var hashtagText6 = $('#hash-text-6');
        var hashtagLink6 = $('#hash-link-6');
        var hashtagText7 = $('#hash-text-7');
        var hashtagLink7 = $('#hash-link-7');
        var hashtagText8 = $('#hash-text-8');
        var hashtagLink8 = $('#hash-link-8');
        var hashtagText9 = $('#hash-text-9');
        var hashtagLink9 = $('#hash-link-9');
        var hashtagText10 = $('#hash-text-10');
        var hashtagLink10 = $('#hash-link-10');

        //hashtagOptions.empty();
        $.each(hashtags, function (index, hashtag) {
            hashTagArray.push(hashtag);

        });
        hashtagText1.text("#" + hashTagArray[0]);
        hashtagLink1.attr({
            'data-stuff': hashTagArray[0]
        });
        hashtagText2.text("#" + hashTagArray[1]);
        hashtagLink2.attr({
            'data-stuff': hashTagArray[1]
        });
        hashtagText3.text("#" + hashTagArray[2]);
        hashtagLink3.attr({
            'data-stuff': hashTagArray[2]
        });
        hashtagText4.text("#" + hashTagArray[3]);
        hashtagLink4.attr({
            'data-stuff': hashTagArray[3]
        });
        hashtagText5.text("#" + hashTagArray[4]);
        hashtagLink5.attr({
            'data-stuff': hashTagArray[4]
        });
        hashtagText6.text("#" + hashTagArray[5]);
        hashtagLink6.attr({
            'data-stuff': hashTagArray[5]
        });
        hashtagText7.text("#" + hashTagArray[6]);
        hashtagLink7.attr({
            'data-stuff': hashTagArray[6]
        });
        hashtagText8.text("#" + hashTagArray[7]);
        hashtagLink8.attr({
            'data-stuff': hashTagArray[7]
        });
        hashtagText9.text("#" + hashTagArray[8]);
        hashtagLink9.attr({
            'data-stuff': hashTagArray[8]
        });
        hashtagText10.text("#" + hashTagArray[9]);
        hashtagLink10.attr({
            'data-stuff': hashTagArray[9]
        });

        hashtagLink1.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink1.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink2.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink2.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink3.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink3.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink4.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink4.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink5.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink5.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink6.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink6.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink7.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink7.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink8.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink8.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink9.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink9.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
        hashtagLink10.click(function (event) {
            event.preventDefault();
            //var searchInput=$('#search-field').val();
            $.ajax({
                type: 'GET',
                url: "/DolphinBlog/HashtagsMainX/" + hashtagLink10.data('stuff')
            }).success(function (data) {

                $('#divToFill').empty();
                processPosts(data);

            });
        });
    });




}

//
//function addPost() {
////  VAR NEEDED IN FORM
////  title;
////  author;
////  categoryId (dropdown in html)
////  List<String> hashtags;  OPTIONAL
////  content;
////  photoUrl;
////  synopsis;
////    
////  AUTO_ASSIGNED VAR
////  postID - assigned automatically in the DB
////  statusId is set by DEFAULT to Edit Mode when entered into the database;
////  pubDate - automatically timestamped in DB
////  likes -- automatically set to 0 ON INSERT in the database
////  List<String> comments - set to null
//
//
//    var postTitle = $("#add-post-title").val();
//    var postAuthor = $("#add-post-author").val();
//    var postCategory = $("#add-post-category").val();
//    var postPhotoUrl = $("#add-post-photoUrl").val();
//    var postContent = tinyMCE.activeEditor.getContent();
//    var postSynopsis = $("#add-post-synopsis").val();
//    var postHashtags = [];
//    $('#add-post-hashtags > option').each(function () {
//        if (this.selected === true) {
//            postHashtags.push(this.value);
//        }
//    });
//    var data = JSON.stringify({
//// DTO variable name : variable from above
//        title: postTitle,
//        author: postAuthor,
//        categoryId: postCategory,
//        photoUrl: postPhotoUrl,
//        synopsis: postSynopsis,
//        content: postContent,
//        hashtags: postHashtags
//
//    });
//    console.log(data);
//    $.ajax({
//        url: 'post/add',
//        type: 'POST',
//        headers: {
//            'Content-Type': 'application/json'
//        },
//        'dataType': 'json',
//        data: data
//    }).success(function (data) {
//        //Here we refresh the Edit Mode/Employee section so the new one appears
//        loadAdminEditPage();
//        //here we empty the form
//        $("#add-post-title").val("");
//        $("#add-post-author").val("");
//        $("#add-post-category").prop('selectedIndex', 0);
//        $("#add-post-photoUrl").val("");
//        tinyMCE.activeEditor.setContent('');
//        tinyMCE.get('#addPostsTinyMCE').setContent(" ");
//        $("#add-post-synopsis").val("");
//        $('#add-post-hashtags > option').removeAttr("selected");
//    });
//
//}

//function editPost() {
////  VAR NEEDED IN FORM
////  postID -  used as a path variable to show which post to updated
////  title
////  author
////  categoryId (dropdown in html)
////  photoUrl
////  content
////  synopsis
////  List<String> hashtags;  OPTIONAL
////    
////   OTHER PROPERTIES
//
////  statusId is changed elsewhere (by the admin buttons in the html)
////  pubDate - has already been timestamped in DB
////  likes -- not changeable
////  List<String> comments - can't be edited here
//
//    //the id (next line) is smuggled into the Update Button when
//    //the edit Modal is loaded with all the other data
//    var postID = $('#updatePostBtn').data("post-id");
//
//    var postTitle = $("#edit-post-title").val();
//    var postAuthor = $("#edit-post-author").val();
//    var postCategory = $("#edit-post-category").val();
//    var postPhotoUrl = $("#edit-post-photoUrl").val();
//    var postContent = tinyMCE.activeEditor.getContent();
//    var postSynopsis = $("#edit-post-synopsis").val();
//    var postHashtags = [];
//    $('#edit-post-hashtags > option').each(function () {
//        if (this.selected === true) {
//            postHashtags.push(this.value);
//        }
//    });
//    var data = JSON.stringify({
//// DTO variable name : variable from above
//        title: postTitle,
//        author: postAuthor,
//        categoryId: postCategory,
//        photoUrl: postPhotoUrl,
//        synopsis: postSynopsis,
//        content: postContent,
//        hashtags: postHashtags
//
//    });
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
//        //Here we refresh the Edit Mode/Employee section so the new one appears
//
//        //here we empty the form
//        $("#edit-post-title").val("");
//        $("#edit-post-author").val("");
//        $("#edit-post-category").prop('selectedIndex', 0);
//        $("#edit-post-photoUrl").val("");
//        tinyMCE.activeEditor.setContent('');
//        $("#edit-post-synopsis").val("");
//        $('#edit-post-hashtags > option').removeAttr("selected");
//        loadAdminEditPage();
//    });
//
//}


function processPopularPosts(posts) {
    var popDiv = $('#popDivToFill');
    $.each(posts, function (index, post) {
        var IDl = "likes" + post.postID;
        var IDlc = "like" + post.postID;
        var IDn = "nums" + post.postID;
        var IDnc = "num" + post.postID;
        var IDlhash = "#" + IDl;
        var IDlchash = "#" + IDlc;
        var IDnhash = "#" + IDn;
        var IDnchash = "#" + IDnc;
        var coma = post.comments;
        var com = coma.length;

        popDiv.append($("<div>").attr({'class': "col-md-12 right-min",
            'data-post-id': post.postID})
                .append($("<h4>").attr({'class': "title-sm col-md-12"}).append($('<a>').attr({
                    'href': "/DolphinBlog/blogpost/" + post.postID,
                    'method': 'GET'
                })
                        .text(post.title)))
                // I removed the date here.  it's unnecessary, and caused all sorts of formatting issues
                .append($("<div>").attr({'class': "content-div-sm col-md-6"})
                        .append($("<img>").attr({'src': post.photoUrl,
                            'class': "pic-sm img-responsive img-rounded"})))
                .append($("<div>").attr({'class': "content-div-sm col-md-6"})
                        .append($("<p>").attr({'class': "col-xs-12"})
                                .text(post.synopsis.substring(0, 83)))
                        .append($("<div>").attr({'class': "col-xs-12"})
                                .append($("<h4>").text("( " + com + " )")
                                        .attr({'class': "col-xs-6"})
                                        .append($("<span>").attr({
                                            'class': "glyphicon glyphicon-comment"})))
                                .append($("<h4>").text("( " + post.likes + " )")
                                        .attr({'class': "col-xs-6", 'id': IDn}).append($("<a>").attr({
                                    'id': IDl
                                            // 'onclick': fLikeMain(post.postID,post.likes)
                                })
                                        .append($("<span>")
                                                .attr({
                                                    'class': "glyphicon glyphicon-thumbs-up"

                                                })))
                                        ))));
        var newLike = +post.likes + 1;
        var newLikeText = newLike.toString();
        $(IDlhash).click(function (event) {
            event.preventDefault();
            $.ajax({
                type: 'PUT',
                url: '/DolphinBlog/like/' + post.postID
            }).success(function () {


                //loadInventory3();
            });
            $(IDlhash).attr({
                'style': 'color:white;',
                'onclick': 'f();'
            });
            $(IDnhash).empty();
            $(IDnchash).empty();
            $(IDnhash).text("( " + newLikeText + " )");
            $(IDnchash).text("( " + newLikeText + " )");
            $(IDnhash).append($("<span>").attr({
                'class': "glyphicon glyphicon-thumbs-up"
            }));
            $(IDnchash).append($("<span>").attr({
                'class': "glyphicon glyphicon-thumbs-up"
            }));
//                                        
//        
        });



    });
}






//function processWaitPosts(posts) {
//    $('#waitRows').empty();
//    var waitRows = $('#waitRows');
//    var waitRow = $("<tr>");
//
//    $.each(posts, function (index, post) {
//        var postTitle = $("<td>");
//        var postId = $("<td>");
//
//        var editBtn = $("<button class='btn btn-primary'>");
//        var rejectBtn = $("<button class='btn btn-info'>");
//        var postBtn = $("<button class='btn btn-info'>");
//        var deleteBtn = $("<button class='btn btn-info'>");
//
//        editBtn.text("Edit");
//        rejectBtn.text("Reject");
//        postBtn.text("Post");
//        deleteBtn.text("Delete");
//
//        if (index % 1 === 0) {
//            waitRow = $("<tr>");
//        }
//
//        postTitle.text(post.title);
//        postId.text(post.postID);
//
//        waitRow.append(postId);
//        waitRow.append(postTitle);
//        waitRow.append(editBtn);
//        waitRow.append(rejectBtn);
//        waitRow.append(postBtn);
//        waitRow.append(deleteBtn);
//
//        waitRows.append(waitRow);
//
//    });
//
//
//
//}
//  THIS COMMENT IS HERE JUST SO I CAN SEE IT, IT CAN BE DELETED
//function loadAdminEditPage() {
//    $.ajax({
//        url: "posts/editposts",
//        type: "GET"
//    }).success(function (data) {
//        processEditPosts(data);
//    });
//
//}
//function processEditPosts(posts) {
//    $('#editRows').empty();
//    var editRows = $('#editRows');
//    var rowTrElement = $("<tr>");
//
//    $.each(posts, function (index, post) {
//        var titleTdElement = $("<td>");
//        var postId = $("<td>");
//
////        <tr>
////            <th scope="row"><h3 style="margin:0px;">1</h3></th>
////            <td><h3 style="margin:0px;">Soviet Exile Drowned at Sea World</h3></td>
////            <td class = "adminButton"><button type="button" class="btn btn-success">View</button></td>
////            <td style="width:50px;"><button type="button" class="btn btn-warning">Unpost</button></td>
////            <td class = "adminButton"><button type="button" class="btn btn-danger" >Delete</button></td>
////        </tr>
//
//        var editBtn = $('<button data-toggle="modal" data-target="#edit-post-modal" data-post-id="' + post.postID + '" \n\
//                        class="btn btn-default" value="Edit Post" type="button">');
//        var submitBtn = $("<button class='btn btn-info'>");
//
//        editBtn.text("Edit");
//        submitBtn.text("Submit");
//
//        if (index % 1 === 0) {
//            rowTrElement = $("<tr>");
//        }
//
//        titleTdElement.text(post.title);
//        postId.text(post.postID);
//
//        rowTrElement.append(postId);
//        rowTrElement.append(titleTdElement);
//        rowTrElement.append(editBtn);
//        rowTrElement.append(submitBtn);
//
//        editRows.append(rowTrElement);
//
//    });
//
//}




function f() {

}

function convertDate(timeStamp) {
    // 2016-11-28 17:54:15.0
    var date = timeStamp.substring(0, 11);
    if (date.substring(9, 10) !== " ") {
        var mm = date.substring(5, 7);
        var dd = date.substring(8, 10);
    } else if (date.substring(8, 10) === "  ") {
        var mm = date.substring(5, 6);
        var dd = date.substring(7, 8);
    } else if (date.substring(8, 9) !== " " && date.substring(9, 10) === " ") {
        if (date.substring(6, 7) === "-") {
            var mm = date.substring(5, 6);
            var dd = date.substring(7, 9);
        } else {
            var mm = date.substring(5, 7);
            var dd = date.substring(8, 9);

        }
    }
    var yyyy = timeStamp.substring(0, 4);
    return mm + " - " + dd + " - " + yyyy;
}

//===============================
//       TinyMCE Init and Setup
//===============================

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
//
//});

//tinymce.init({
//    selector: '#commentMCE',
//    height: 100,
//    plugins: [
//        'autosave'
//    ]
//});


//unpostBtn.click(function (event) {
//            event.preventDefault();
//            fUpdate(post.postID)
//        });


//
//function processSearchPosts(posts) {
//    var popDiv = $('#divToFillSearch');
//    $.each(posts, function (index, post) {
//        popDiv.append($("<div>").attr({
//            'style': "height:30px;",
//            'class': "col-md-12 right-min",
//            'data-post-id': post.postID})
//                .append($("<h4>").attr({'class': "title-sm col-md-12"}).append($('<a>').attr({
//                    'href': "/DolphinBlog/blogpost/" + post.postID,
//                    'method': 'GET'
//                })
//                        .text(post.title))));
//
//    });
//}
