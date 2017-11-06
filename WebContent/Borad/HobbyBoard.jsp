<%@page import="Board_vo.BoardVO"%>
<%@page import="Board_dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="boards"
  scope="request"
  class="java.util.ArrayList" 
  type="java.util.ArrayList<Board_vo.BoardVO>"/>
      
    
    
<!doctype html>
<html>
<head>



<meta charset="utf-8">
<title>FreeBoard</title>
	
	<style> 
		.tab tr td { border: solid 0px;	
			}	
	</style>
<jsp:include page="/Header.jsp"/>
</head>

<body>
	
	
	<div class="container" align="center">
		<div class="centered" align="center"  style= "width:900px; height: 300px; text-align:center; background:url(./Photo/hobby.jpg)no-repeat; background-size: 100% 100%;">
			<div style="padding-top: 12%">
	<font size="+4"> Pen Pal </font>
		</div>	
	</div>
	  </div>
	<div align="center"> 
		<div align="center">  
		<div align="right" style="width: 900px;">
			<br>
		<input type="button" value="게시물 작성하기" style="height: 35px"> </div></div>
		<br>

<%
	String Page = (String) request.getAttribute("page");
	int size = boards.size();
	int pa = (size%5 == 0) ? (size/5) : (size/5)+1 ;
	
	int pagercount = 0;
		if(Page != null) {
			pagercount = Integer.parseInt(Page);
				if(pagercount == 1) {
					pagercount = 0;
				}
				else  {
					pagercount = (pagercount*5)-5 ;
				}
		}
		int i = 0;
		 for(BoardVO boardVO : boards) {
				if(i == 5) {
					break;
				} else if ((i+pagercount) == size) {
					break;
				}
		  %> 
	<table class="tab" border="1" align="center" style="width: 900px" height="500px"; >
  <tbody>
  <tr>
        <td>
			<table style="width:100%">	
			<tr> 
				<td style="padding-left: 20px;">  <%=boards.get(i+pagercount).getWriterID() %> </td>
				<td style="padding-left: 20px;" align="right"><%=boards.get(i+pagercount).getUploadDay() %></td>
			</tr>	
			</table>
		</td>
		</tr>
    <tr>
		<td> <h3 style="padding-left: 20px; padding-right: 20px;" > <%=boards.get(i+pagercount).getPostname() %> </h3>	
      <p style="padding-left: 20px; padding-right: 20px;">  <%=boards.get(i+pagercount).getPostContent() %> </p> </td>
    </tr>
    <tr>
      <td height="100%" width="100%" id=ab; style="background:url(./Photo/main.jpg) no-repeat; background-size: 100% 100%; "> </td>
    </tr>
	  <tr> <tr>
  </tbody>
</table>
<%
	i++;
}
%>
<form action="BoardFree?no=hobby"  method='post'>

<%
int count=1;
for(int z = 0; z < pa; z++ ) { %>
<input type="submit" name="page" value=<%=count%>> 

<%count++;
} %>

 </form>

	</div>
	
	<style>

	</style>
	<jsp:include page="/Tail.jsp"/>
</body>
</html>