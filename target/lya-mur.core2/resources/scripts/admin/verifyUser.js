function checkUser(){
    var name = document.getElementById('name_input').value;
    var password = document.getElementById('password_input').value;
    var user = {
        "id":"",
        "name":name,
        "password":password,
        "status":""
    };
    var userJson = JSON.stringify(user);
    alert(userJson);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', "api/validation/user", true);
    xhr.send(userJson);
    xhr.onload = function(){
        alert(xhr.responseText);
    }
}