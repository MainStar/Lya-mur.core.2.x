var xhr = new XMLHttpRequest();
xhr.open('POST', "api/post/getPosts", true);
xhr.onload = function(){
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