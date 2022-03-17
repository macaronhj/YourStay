//	var submit = document.getElementById('submitButton');
//	submit.onclick = showImage;     //Submit 버튼 클릭시 이미지 보여주기
	
	/*function showImage() {
	    var newImage = document.getElementById('image-show').lastElementChild;
	  
	    //이미지는 화면에 나타나고
	    newImage.style.visibility = "visible";
	  
	    //이미지 업로드 버튼은 숨겨진다
	    document.getElementById('image-upload').style.visibility = 'hidden';
	
	    document.getElementById('fileName').textContent = null;     //기존 파일 이름 지우기
	}*/

   function loadFile(input) {
	    var file = input.files[0];	//선택된 파일 가져오기

	    //미리 만들어 놓은 div에 text(파일 이름) 추가
	    var name = document.getElementById('fileName');
	    name.textContent = file.name;

	  	//새로운 이미지 div 추가
	    var newImage = document.createElement("img");
	    newImage.setAttribute("class", 'img');

	    //이미지 source 가져오기
	    newImage.src = URL.createObjectURL(file);   

	    newImage.style.width = "100%";
	    newImage.style.height = "100%";
	    
	   // newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지를 숨긴다
	    newImage.style.objectFit = "contain";

	    //이미지를 image-show div에 추가
	    var container = document.getElementById('image-show');
	    container.appendChild(newImage);
	    
	    document.getElementById('image-upload').style.visibility = 'hidden';
	    if(newImage != null){
	    	newImage.style.visibility = "hidden;"
	    }else{
	    	newImage.style.visibility = "visible";
	    }
		
	    document.getElementById('fileName').textContent = null;
	};
	
	function loadFile1(input1) {
	    var file1 = input1.files[0];	//선택된 파일 가져오기

	    //미리 만들어 놓은 div에 text(파일 이름) 추가
	    var name1 = document.getElementById('fileName1');
	    name1.textContent = file1.name;

	  	//새로운 이미지 div 추가
	    var newImage1 = document.createElement("img1");
	    newImage1.setAttribute("class1", 'img1');

	    //이미지 source 가져오기
	    newImage1.src = URL.createObjectURL(file1);   

	    newImage1.style.width = "100%";
	    newImage1.style.height = "100%";
	    
	   // newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지를 숨긴다
	    newImage1.style.objectFit = "contain";

	    //이미지를 image-show div에 추가
	    var container = document.getElementById('image-show1');
	    container.appendChild(newImage1);
	    
	    document.getElementById('image-upload1').style.visibility = 'hidden';
	    if(newImage1 != null){
	    	newImage1.style.visibility = "hidden;"
	    }else{
	    	newImage1.style.visibility = "visible";
	    }
		
	    document.getElementById('fileName1').textContent = null;
	};
	
	function loadFile2(input2) {
	    var file2 = input2.files[0];	//선택된 파일 가져오기

	    //미리 만들어 놓은 div에 text(파일 이름) 추가
	    var name2 = document.getElementById('fileName2');
	    name2.textContent = file2.name;

	  	//새로운 이미지 div 추가
	    var newImage2 = document.createElement("img2");
	    newImage2.setAttribute("class2", 'img2');

	    //이미지 source 가져오기
	    newImage2.src = URL.createObjectURL(file2);   

	    newImage2.style.width = "100%";
	    newImage2.style.height = "100%";
	    
	   // newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지를 숨긴다
	    newImage2.style.objectFit = "contain";

	    //이미지를 image-show div에 추가
	    var container = document.getElementById('image-show2');
	    container.appendChild(newImage2);
	    
	    document.getElementById('image-upload2').style.visibility = 'hidden';
	    if(newImage2 != null){
	    	newImage2.style.visibility = "hidden;"
	    }else{
	    	newImage2.style.visibility = "visible";
	    }
		
	    document.getElementById('fileName').textContent = null;
	};