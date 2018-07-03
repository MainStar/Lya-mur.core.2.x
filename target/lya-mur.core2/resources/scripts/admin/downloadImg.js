function newImage(event){
    /*var input = event.target;*/
    var output = document.getElementById('photo');
    var out = document.querySelector('img');

    var reader = new FileReader();
    reader.onload = function(){
        alert(dataURL);
        out.src = dataURL;
    };
    if (true) {
        reader.readAsDataUrl(input.files[0]);    
    }else{
        out.src = "";
    }
    
}