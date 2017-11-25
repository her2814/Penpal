<%@page import="Scarch_vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
  "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<jsp:include page="/Header.jsp"/>
<jsp:useBean id="loginInfo" scope="session" class="Scarch_vo.User" />
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
<title>HOME</title>


</head>
	<style type="text/css">

		#imgarea {		
			height: 600px;
			margin: 0; 		
		}
		
		
		#wrap {
 width: 370px; /* 폭이나 높이가 일정해야 합니다. */
 height: 150px; /* 폭이나 높이가 일정해야 합니다. */
 position: absolute;
 top: 50%; /* 화면의 중앙에 위치 */
 left: 50%; /* 화면의 중앙에 위치 */
 margin: -180px 0 0 -165px; /* 높이의 절반과 너비의 절반 만큼 margin 을 이용하여 조절 해 줌 */
filter: alpha(opacity=70);
-moz-opacity: 0.7;  
opacity: 0.7; 
}


</style>
<body>

	<div id="imgarea" align="center" > <img src="" width="100%" height="100%" />
		
		
	<div id="wrap" style="background: #FFFFFF;" align="center" >
		
		<p style="margin-top: 55px"> Dongseo university</p>
		<p> Pen Pal</p>

	<%if(loginInfo.getId()==null) { %>	
		 <a href='Login'> <input type="button" value="login"  style="background:#C78322; text-align: center; width: 120px; height: 50px;" > </a>
		<% } 
	else { %>
	<a href="Logout"> 
		<input type="button" value="logout"  style="background:#C78322; text-align: center; width: 120px; height: 50px;" > </a>
		<% } %>
		</div>


	</div>
	
	</div>
	<input name="textfield" type="text" id="textfield" width="110" style="background-color:transparent; border-style:none" size="12"   />
	
	<jsp:include page="/Tail.jsp"/>
	
			

<script> 

var img = ["Photo/main.jpg","Photo/mug_obj_201603080130343734.jpg","Photo/aqws.jpg"];

var sp = document.getElementById("imgarea");

show(0); 

var currnum = 0; 

function show(currnum) { 

   sp.getElementsByTagName("img")[0].src = img[currnum];

   currnum;

} 

function goPrev() { 

   currnum--; 

   if(currnum < 0) currnum = img.length - 1; 

   show(currnum); 

} 

function goNext() { 

   currnum++; 

   if(currnum >= 3) currnum = 0; 

   show(currnum); 

}

setInterval(goNext,7000);

</script> 
	
</body>

</html>
