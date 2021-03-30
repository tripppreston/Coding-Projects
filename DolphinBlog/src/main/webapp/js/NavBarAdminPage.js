$(document).ready(function () {
    loadNav();
});

function loadNav(){
    
     $.ajax({
        url: "pages/Active",
        type: "GET"
    }).success(function (data) {
        populateList(data);
    });
}

function populateList(pages){
   var dolphinDrop=$('#dolphins-dropdown');
   var dolphinNav=$('#nav-bar');
    $.each(pages, function (index, page) {
        if(page.tabId===2){
        
        var viewLink = $("<a>").attr({
            'href': "/DolphinBlog/Dolphin/" + page.pageID,
            'method': 'GET'
            
        });
       var check= page.pageID;
       console.log(check);
       
//        var deleteBtnTD = $("<td class='col-sm-2'>");
        dolphinDrop.append($("<li>").append(viewLink));
       

       viewLink.append(viewLink.text(page.title));}
       else{
           dolphinNav.append($('<li>').attr({
               'role': "presentation"
           }).append($('<a>').attr({
            'href': "/DolphinBlog/Dolphin/" + page.pageID,
            'method': 'GET'
           }).append($('<h5>').text(page.title))));
       }
       

    });
}
