function checkUser(){
    var name = document.getElementById('name_input').value;
    var password = document.getElementById('password_input').value;
    var xhr = new XMLHttpRequest();
    xhr.open('POST', "api/", true);
}