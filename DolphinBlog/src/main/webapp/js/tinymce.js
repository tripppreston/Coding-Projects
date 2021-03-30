


/* global tinymce */

tinymce.init({
    selector: '.tinyMCE',
    height: 300,
//                skin: 'charcoal', // can be used to specify a custom skin. See http://skin.tinymce.com/
    plugins: [
        'advlist autolink autosave charmap hr link lists print preview ',
        ' wordcount visualblocks visualchars image imagetools',
        'table contextmenu emoticons template',
        'paste searchreplace textcolor'
    ],
    // "contextmenu" refers to the menu options available when the user right-clicks
    contextmenu: "link image",
    imagetools_toolbar: "rotateleft rotateright | flipv fliph | editimage imageoptions",
//                imagetools_cors_hosts: ['imgur.com', 'otherdomain.com'], //we may need to use this option if we hook up an imgur acct
//                content_css:'css/dolphinstyles.css',  //link to internal style sheet
    toolbar: 'insertfile undo redo | styleselect | forecolor bold italic underline | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link charmap image emoticons | preview'

});
