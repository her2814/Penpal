<%@page import="Scarch_vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>BoradList</title>
<jsp:include page="/Header.jsp"/>
</head>
<body>
	
<div class="container" align="center">
		<div class="centered" align="center"  style= "width:900px; height: 300px; text-align:center; background:url(./Photo/penpal1.jpg) no-repeat; background-size: 100% 100%;">
			<div style="padding-top: 12%">
	<font size="+4"> Pen Pal </font>
		</div>	
	</div>
	  </div>
	<br>
<div align="center"> 
	<table width="900" align="center" style="border-spacing:10px;">
  <tbody>
    <tr>
   <td> <a href="BoardFree?no=free"><img src='./Photo/board.jpg' style="width: 420px; height: 300px;" name="board"> </a> </td>
      <td> <a href="BoardFree?no=hobby"> <img src="./Photo/hobby.jpg" style="width: 420px; height: 300px;" name=hobby> </a> </td>
    </tr>
    <tr align="center">
      <td> <br><br> <a href='BoardFree?no=free' style="text-decoration: none; color: #000000;"> <font size="+3" > 자유 게시판 </font></a> </td>
      <td> <br><br> <a href='BoardFree?no=hobby' style="text-decoration: none; color: #000000;"> <font size="+3"> 취미 활동</font></a> </td>
    </tr>
  </tbody>
</table>

	
	</div>
	<jsp:include page="/Tail.jsp"/>
</body>
</html>
