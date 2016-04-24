$(document).ready(function() {
        $("form").submit(function (e) {
          var titleTxt = document.getElementById("posttitle").value;
               var bodyTxt = document.getElementById("postdesc").value;
               var data = JSON.stringify({ title: titleTxt, content: bodyTxt});
               alert( data);
               $.ajax({
                 type : "POST",
                 url : 'cmad/blogs',
                 dataType :"json",
                 contentType: "application/json",
                 data : data,
                 success : function(result) {
                   alert("DONE"); // result is an object which is created from the returned JSON
    },

});
      });
      });