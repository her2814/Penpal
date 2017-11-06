<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Scarch_vo.User"%>

<!DOCTYPE html>
<style>.linksize a {width:200px; text-align:center;}
	
a{border:1 solid silver; padding:5px 25px 0; margin:0 15 0;
	text-decoration: none;
	color: #000000;
	}</style>
<jsp:useBean id="loginInfo" scope="session" class="Scarch_vo.User" />
<p class='linksize' align="center">
	<div style="height: 0px; margin-right: 20%; " align="right">
	<%if(loginInfo.getId()==null) { %>	
<a href='Login' style="font-size: 14px"> login</a>
	<% } 
	else { %>
	<a href='Logout' style="font-size: 14px"> logout </a>
<% } %>
</div>
<div align="center">
<a href='Main'><img src="./dpo.png" width=50px height=50px align=center alt=image></a>
<a href='Main' style="color: #7795A3;
		font-size: 26px;"> pen pal</a>
<a href='Main'> Home</a>
<a href='MyPage'> My page</a>
<a href='#링크/주소'> Mail</a>
<a href='#링크/주소'> Photo</a>
<a href='BoardList'> Bulletin Board</a>
<a href='SearchFriend'>  Search Friend</a></div></p>
