<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
  "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
	<script type="text/javascript"> 
	function validatePwd() {
		invalid =" ";
		minlength=8;
		pd1 = document.name.password.value;
		pd2 = document.name.password1.value;
		
		if(pd1==""||pd2=="") {
			alert("암호를 두번 입력하세요.");
			return false;
		}
		if((document.name.password.value.length < minlength) || (document.name.password1.value.length < minlength)) {
			alert("패스워드를 8자리 이상 입력하세요.");
			return false;
		}
		if((document.name.password.value.indexOf(invalid)>-1) || (document.name.password1.value.indexOf(invalid)>-1)) {
			alert("공백은 입력할수 없습니다.");
			return false;
		} else {
			if(pd1!=pd2) {
				alert("입력하신 암호가 다릅니다.");
				return false;
			}
		}
	}
	
	function onlyNumber(event){
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
			return;
		else
			return false;
	}
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
			return;
		else
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}

	
	
	</script>
	<style>
	input[type=text]::-ms-clear{
	}
		
	.form-4 {
    /* Size and position */
		
    width:400px;
    padding: 10px;
    color: black;
    
}

.form-4 h1 {
    font-size: 22px;
    padding-bottom: 20px;
}
.form-4 input[type=text],
.form-4 input[type=password],
.form-4 select {
    /* Size and position */
    width: 70%;
    padding: 8px 4px 8px 10px;
    margin-bottom: 15px;

    /* Styles */
    border: 1px solid #4e3043; /* Fallback */
    border: 1px solid rgba(78,48,67, 0.8);
    background: rgba(0,0,0,0.15);
    border-radius: 2px;
    box-shadow: 
        0 1px 0 rgba(255,255,255,0.2), 
        inset 0 1px 1px rgba(0,0,0,0.1);
    -webkit-transition: all 0.3s ease-out;
    -moz-transition: all 0.3s ease-out;
    -ms-transition: all 0.3s ease-out;
    -o-transition: all 0.3s ease-out;
    transition: all 0.3s ease-out;

    /* Font styles */
    font-family: 'Raleway', 'Lato', Arial, sans-serif;
    color: #000000;
    font-size: 13px;
}
.form-4 input::-webkit-input-placeholder {
    color: rgba(37,21,26,0.5);
    text-shadow: 0 1px 0 rgba(255,255,255,0.15);
}

.form-4 input:-moz-placeholder {
    color: rgba(37,21,26,0.5);
    text-shadow: 0 1px 0 rgba(255,255,255,0.15);
}

.form-4 input:-ms-input-placeholder {
    color: rgba(37,21,26,0.5);
    text-shadow: 0 1px 0 rgba(255,255,255,0.15);
}
.form-4 input[type=text]:hover,
.form-4 select:hover,
.form-4 input[type=password]:hover {
    border-color: #333;
}

.form-4 input[type=text]:focus,
.form-4 select:focus,
.form-4 input[type=password]:focus,
.form-4 input[type=submit]:focus,
.form-4 input[type=button]:focus
		{
    box-shadow: 
        0 1px 0 rgba(255,255,255,0.2), 
        inset 0 1px 1px rgba(0,0,0,0.1),
        0 0 0 3px rgba(255,255,255,0.15);

}

/* Fallback */
.no-boxshadow .form-4 input[type=text]:focus,
.no-boxshadow .form-4 select:focus,
.no-boxshadow .form-4 input[type=password]:focus {
    outline: 1px solid white;
}
.form-4 input[type=submit],
.form-4 input[type=button] {
    /* Size and position */
    width: 45%;
    padding: 8px 5px;
    
    /* Styles */
    background: linear-gradient(rgba(99,64,86,0.5), rgba(76,49,65,0.7));    
    border-radius: 5px;
    border: 1px solid #4e3043;
    box-shadow: 
    	inset 0 1px rgba(255,255,255,0.4), 
    	0 2px 1px rgba(0,0,0,0.1);
    transition: all 0.3s ease-out;

    /* Font styles */
    color: white;
    text-shadow: 0 1px 0 rgba(0,0,0,0.3);
    font-size: 16px;
    font-weight: bold;
    font-family: 'Raleway', 'Lato', Arial, sans-serif;
}

.form-4 input[type=submit]:hover,
		.form-4 input[type=button]:hover {
    box-shadow: 
        inset 0 1px rgba(255,255,255,0.2), 
        inset 0 20px 30px rgba(99,64,86,0.5);
}

/* Fallback */
.no-boxshadow .form-4 input[type=submit]:hover,
		.form-4 input[type=button]:hover{
    background: #594642;
}
	
	</style>


	
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
<title>Insert title here</title>
</head>
</head>
<body>			
				<form class="form-4" action="MemberShip" method="post" enctype="multipart/form-data" name=name onSubmit='return validatePwd()'>
					<div align="center" style="height: 25px"><h3>회원 가입<h3></div>
				<div align="right"> 
					<font> 아&nbsp&nbsp&nbsp이&nbsp&nbsp&nbsp디 </font>   <input type="text" name='id' required ><br>
					<font>  비&nbsp&nbsp밀&nbsp&nbsp번&nbsp&nbsp호 </font>  <input type="password" name="password" required ><br>
					<font>  비밀번호 확인  </font>  <input type="password" name="password1" required ><br>
					<font>  이 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp름 </font>  <input type="text" name="name" required><br>
					<font>  나 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp이 </font>  <input type="text" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' name="age" required ><br>
					<font>  취 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp미 </font>
					<select style="width: 295px" name="hobby" required>
					<option value="취미" selected disabled hidden>-취미-</option>
					<option value="음악">음악</option>
					<option value="여행">여행</option>
					<option value="스포츠">스포츠</option>
					<option value="음식">음식</option>

					</select><br>
					<font> 국 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp적</font>
					<select style="width: 295px" name="nationality" required >
					<option value="국적" selected disabled hidden>-국적-</option>
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="미국">미국</option>
					<option value="중국">중국</option>
					</select><br>				
					<font> 주 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp소</font>  <input type="text" name="address" required ><br>
					<font> 가&nbsp능&nbsp언&nbsp어</font>  <input type="text" name="language" required ><br>
					<font> 종 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp교</font>  <input type="text" name="religion" required ><br>
					<font> 직 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp업</font>  <input type="text" name="job"><br>
					<font> 이&nbsp&nbsp&nbsp메&nbsp&nbsp&nbsp일</font>  <input type="text" name="email"><br>
					<font> 찾기  질문</font>
					<select style="width: 295px" name="question" required >
					<option selected disabled hidden>-비밀번호 찾기용 질문-</option>
					<option value=1>본인이 태어난 곳은 ?</option>
					<option value=2>제 보몰 1호</option>
					<option value=3>졸업한 초등학교</option>
					<option value=4>부모님 성함은 ? </option>
					</select><br>	
					<font> 질문 답  </font>  <input type="text" name="answer" required><br>
					 <div align="center"> 
					<font>프&nbsp로&nbsp필&nbsp사&nbsp진</font>  </div> 
					<input type="file" name="photo" style="width: 45%" required ><br><br>  
				
					<div align="center"><font> 자&nbsp&nbsp&nbsp기&nbsp&nbsp&nbsp소&nbsp&nbsp&nbsp개</font> </div> <br> <textarea rows="5" cols="50" name="message"></textarea><br><br>
					
					
					<input type="submit" value="등록" > <input type="button" value="취소" onclick="window.close()">
				</div>
				</form>
			</body>

</html>