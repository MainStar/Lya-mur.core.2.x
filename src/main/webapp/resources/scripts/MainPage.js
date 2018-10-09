window.onload = function(){
    if (window.innerWidth > 1200) {
        //alert(window.innerWidth);
    	document.getElementById("photo_class_under_serviceInTop").style.height = '22%';
	    document.getElementById("container_blog_services").style.margin = '130px auto';
    	document.getElementById("pod_all_services").style.marginTop = '-17%';
    }
    if(window.innerWidth <= 1200){
        document.getElementById("photo_class_under_serviceInTop").style.height = '52%';
        document.getElementById("container_blog_services").style.margin = '0 auto';
        document.getElementById("pod_all_services").style.marginTop = '-11%';
    }
}
$( document ).ready(function() {
  $('.trigger').on('click', function() {
     $('.modal-wrapper').toggleClass('open');
     return false;
  });
});

var xhr = new XMLHttpRequest();
xhr.open('POST', "api/post/getPosts", true);
xhr.onload = function(){
    //alert(xhr.responseText);
    var postObject = JSON.parse(xhr.responseText);
    for(var i = postObject.length - 1; i < postObject.length; i--){
        var root = document.getElementById('blog');
            var blog_post = document.createElement('div');

                var blog_img = document.createElement('div');
                    var img = document.createElement('img');

                var blog_info = document.createElement('div');
                    var summary = document.createElement('div');
                        var a_summary = document.createElement('a');
                        var h4_summary = document.createElement('h4');
                    var info = document.createElement('div');
                        var a_info = document.createElement('a');
                        var h4_info = document.createElement('h4');

                var blog_link = document.createElement('div');
                    var a = document.createElement('a');
                    var h4 = document.createElement('h4');

        img.src = postObject[i].image;
        h4_summary.innerHTML = postObject[i].summary;
        h4_info.innerHTML = postObject[i].mainPageText;
        a.href = " ";
        h4.innerHTML = "Читать далее";

        blog_post.className = "blog_post";
        blog_img.className = "blog_img";
        blog_info.className = "blog_info";
        summary.className = "summary";
        info.className = "info";
        blog_link.className = "blog_link";

        root.appendChild(blog_post);

        blog_post.appendChild(blog_img);
        blog_post.appendChild(blog_info);
        blog_post.appendChild(blog_link);

        blog_img.appendChild(img);

        blog_info.appendChild(summary);
            summary.appendChild(a_summary);
            summary.appendChild(h4_summary);
        blog_info.appendChild(info);
            info.appendChild(a_info);
            info.appendChild(h4_info);
        blog_link.appendChild(a);
            a.appendChild(h4);
    }
    alert(xhr.responseText);
    var root = document.getElementById('block_blog');
        var blog_post = document.createElement('div');

            var blog_img = document.createElement('div');
                var img = document.createElement('img');

            var blog_info = document.createElement('div');
                var summary = document.createElement('div');
                    var a_summary = document.createElement('a');
                    var h4_summary = document.createElement('h4');
                var info = document.createElement('div');
                    var a_info = document.createElement('a');
                    var h4_info = document.createElement('h4');

            var blog_link = document.createElement('div');
                var a = document.createElement('a');
                var h4 = document.createElement('h4');

    var postObject = JSON.parse(xhr.responseText);
   // if(xhr.status == 200){
        img.src = postObject.image;
        h4_summary.innerHTML = postObject.summary;
        h4_info.innerHTML = postObject.mainPageText;
    //}

    blog_post.className = "blog_post";
    blog_img.className = "blog_img";
    blog_info.className = "blog_info";
    summary.className = "summary";
    info.className = "info";
    blog_link.className = "blog_link";

    blog_post.appendChild(blog_img);
        blog_img.appendChild(img);
    blog_info.appendChild(summary);
        summary.appendChild(a_summary);
        summary.appendChild(h4_summary);
    blog_info.appendChild(info);
        info.appendChild(a_info);
        info.appendChild(h4_summary);
    blog_link.appendChild(a);
        a.appendChild(h4);

    alert(document.getElementById('summary').textContent);
}
xhr.send();