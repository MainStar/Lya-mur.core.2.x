function createPost(){
	var reader = reader;
	var xhr = new XMLHttpRequest();
	var summary = document.getElementById('summary').value;
	var mainPageText = document.getElementById('mainPageText').value;
	var textPost = document.getElementById('textPost').value;
	var img = window.valueImg;
	var post = {
	    "id":"",
		"summary":summary,
		"mainPageText":mainPageText,
		"textPost":textPost,
		"image":img
	};

	var postJson = JSON.stringify(post);
	xhr.open('POST', "api/post/new", true);
	xhr.onload = function(){
		alert(xhr.status);
	}
	xhr.send(postJson);
}