function createPost(){
	var reader = reader;
	var xhr = new XMLHttpRequest();
	var summary = document.getElementById('summary').value;
	var mainPageText = document.getElementById('mainPageText').value;
	var textPost = document.getElementById('textPost').value;
	var img;
	var post = {
		"summary":summary,
		"mainPageText":mainPageText,
		"textPost":textPost,
		"image":img
	};

	var postJson = JSON.stringify(post);
	xhr.open('POST', "api/create-post", true);
	xhr.onload = function(){
		alert(xhr.staus);
	}
	xhr.send(postJson);
}