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
    var xhr = new XMLHttpRequest();
    xhr.open('POST', "api/validation/user", true);
    xhr.onload = function(){
            alert(xhr.responseText);
            var status = xhr.responseText;
            if(status == "valid"){
                //window.open("http://google.com");
                location.replace("/lya-mur.core2/dashboard");
            }
    };
    xhr.send(userJson);
}