<%@page import="Scarch_vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="users"
  scope="request"
  class="java.util.ArrayList" 
  type="java.util.ArrayList<Scarch_vo.User>"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
  "http://www.w3.org/TR/html4/loose.dtd"> 
 
<html>
<head>

 
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
<title>Search Friend</title>
<jsp:include page="/Header.jsp"/>
</head>
<body>



	<div align="center">
	
	<br><br><br><br>
				<div class="centered" align="center" style="border:2px solid #000000; width:350px; height: 200px; padding: 1em; text-align:left;" >
				
					<form action='SearchFriend' method='post' >
						<h2>Serch Friend</h1>
	<select style="width: 350px" name="nationalty">
		<option value="국적" selected disabled hidden>-국적-</option>
		<option value="한국">한국</option>
		<option value="일본">일본</option>
		<option value="미국">미국</option>
		<option value="중국">중국</option>
	</select><br><br>
	<select style="width: 350px" name="hobby">
		<option value="취미" selected disabled hidden>-취미-</option>
		<option value="음악">음악</option>
		<option value="여행">여행</option>
		<option value="스포츠">스포츠</option>
		<option value="음식">음식</option>
	</select><br><br>
	<input type="submit" value="검색 ">
	</form>
					</div>
				</div> <br>

<div class="tableclass" align="center">

<table width="200" class="table" align="center">
    <% int l =0;
    for(User user : users) {
    	if(l==1) break;%>
<h1> Friend </h1> <% l++;} %>
     <tr>
     <% 	int z = 0;
    for(User user : users) {
	if (z==3 || users.get(z) == null) break; %>
      <td><a href='searchDetail?no=<%=users.get(z).getId()%>'> <img  class="photo" src="<%=users.get(z).getPhoto()%>" width="300px" height="300px"> </a> </td>
      
      
       <%  z++; } %>
    </tr>
    <tr align="center">
   
    <% 	int i = 0;
    for(User user : users) {
	if (i==3 || users.get(i) == null) break; %>
      <td><%=users.get(i).getName() %></td>
     <%  i++; } %>
    </tr>
    <tr align="center">
    <% int j = 0;
    for(User user : users) {
	if (j==3 || users.get(j) == null) break; %>
      <td><%=users.get(j).getMessage() %></td>
      <%  j++; } %>
    </tr>  
</table>
			</div>
<style>
	.centered {width:300px; height: 150px; padding: 1em; text-align:left; }
	.table { align="center"}
		
	.photo {
	object-fit: cover;
	object-position:top;
	border-radius:50%;
	 }
	html{
	font-family: "Arial"
	}
	
		
		
	</style>
<jsp:include page="/Tail.jsp"/>
</body>


</html>





