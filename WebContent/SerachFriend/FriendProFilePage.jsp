<%@page import="Scarch_vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="users"
  scope="request"
  class="Scarch_vo.User" 
  />
  
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>fiendProfile</title>
<jsp:include page="/Header.jsp"/>
<style>
	.photo {
	object-fit: cover;
	object-position:top;
	border-radius:50%;
	 }
	 html{
	font-family: "Arial"
	}
	
</style>
</head>
<body>
<div align="center"> 
<table width="700" height="500" cellspacing="0" >
  <tbody>
  	
     <tr>
   	 <td width="500" height="500"> <img class="photo" src="<%=users.getPhoto()%>" width="400px" height="400px">  </td>
      <td width="500" height="500" style="text-align:center; line-height:2" >
  
<font size="2">Name : <%=users.getName()%></font> <br>
		<font size="2"> Nationality : <%=users.getNationality()%> </font> <br>
		<font size="2"> Language :<%=users.getLanguage()%> </font><br>
		<font size="2"> hobby : <%=users.getHobby()%></font><br>
		<font size="2"> Religion : <%=users.getReligion()%></font><br>
	<font size="2"> self-introduction : <%=users.getMessage()%> </font> <br>
		  <br><br><br>
		</td>
    </tr>
    <tr>
		  <td style="font-style: normal;"> </td>
	
	  	<td align="right">
	  	<input type="submit" value="친구추가" onclick='location.href="addfriend?no=<%=users.getId()%>"'>
	 	<input type="submit" value="메일 보내기" onclick='window.open("sendMessage?no=<%=users.getId()%>","메일","width=350,height=650,scrollbar=no,toolbar=no,directories=no,noresize")'>
		</td>
	  </tr>
  </tbody>
</table>
	</div>
	<br><br><br>
	<jsp:include page="/Tail.jsp"/>
</body>
</html>
