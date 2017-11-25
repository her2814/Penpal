<%@page import="Board_vo.BoardVO"%>
<%@page import="Board_dao.BoardDao"%>
<%@page import="Scarch_vo.User"%>
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


	<script type="text/javascript">
	function ReFresh() {
		location.replace= "BoardFree?no=" + <%=request.getAttribute("board")%>;
		window.alert("처리되었습니다.");
		location.href = this.location.href;
	}
	
	
	function insertBoard() {
		window.open("BoardUpload?no=<%=request.getAttribute("board")%>","insert","width = 500, height = 500, resizable = no, scrollbars = no, status= no");
	}
	</script>
	<style> 
		.tab tr td { border: solid 0px;	
			}	
	</style>
<jsp:include page="/Header.jsp"/>
</head>

<body>
	
	
	<div class="container" align="center">
		<div class="centered" align="center"  style= "width:900px; height: 300px; text-align:center; background:url(./Photo/board.jpg)no-repeat; background-size: 100% 100%;">
			<div style="padding-top: 12%">
	<font size="+4"> 자 유 게 시 판 </font>
		</div>	
	</div>
	  </div>
	<div align="center"> 
		<div align="center">  
			<br>
			<% User userInfo = (User) request.getAttribute("User1");
			if(userInfo.getId() != null) { %>
			<div align="right" style="width: 900px; margin-right: 5%">
		<input type="button" value="게시물 작성하기" style="height: 35px" onclick="insertBoard()"> </div></div>
		<br>
		<%} else {  %>
		<div align="right" style="width: 900px;">
	<a href='BoardUpload'><input type="button" value="게시물 작성하기" style="height: 35px"></a></div></div>
	<br>
	<% } %>
<%
String Page = (String) request.getAttribute("page");
int size = boards.size();
int pa = (size%5 == 0) ? (size/5) : (size/5)+1 ;
System.out.print(page);
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
	  
	   <%if(boards.get(i+pagercount).getPhoto().equals("./Photo/null")) { %>
	   
		   	<table class="tab" border="1" align="center" style="width: 900px" height="200px"; >
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
		<td> <h3 style="padding-left: 20px; padding-right: 20px;" > <a href='DetailsBoard?no=<%=boards.get(i+pagercount).getPostNo()%>'> <%=boards.get(i+pagercount).getPostname() %> </a> </h3>	
      <p style="padding-left: 20px; padding-right: 20px;">  <%=boards.get(i+pagercount).getPostContent() %> </p> </td>
    </tr>       
  </tbody>
</table>
	
    <%  } else { %>
	<table class="tab" border="1" align="center" style="width: 900px" height="500px"; >
  <tbody>
  <tr>
        <td>
			<table style="width:100%">	
			<tr> 
				<td style="padding-left: 20px;"> <%=boards.get(i+pagercount).getWriterID() %></td>
				<td style="padding-left: 20px;" align="right"><%=boards.get(i+pagercount).getUploadDay() %></td>
			</tr>	
			</table>
		</td>
		</tr>
    <tr>
		<td> <h3 style="padding-left: 20px; padding-right: 20px;" > <a href='DetailsBoard?no=<%=boards.get(i+pagercount).getPostNo()%>'> <%=boards.get(i+pagercount).getPostname() %> </a> </h3>	
      <p style="padding-left: 20px; padding-right: 20px;">  <%=boards.get(i+pagercount).getPostContent() %> </p> </td>
    </tr>    
    <tr>
      <td height="100%" width="100%" id=ab; style="background:url(<%=boards.get(i+pagercount).getPhoto()%>) no-repeat; background-size: 100% 100%; "> </td>
    </tr>
  </tbody>
</table>
 <%} %> 
<br>
<%
	i++;
}
%>
<form action="BoardFree?no=hobby"  method='post'>

<%
int count=1;
for(int z = 0; z < pa; z++ ) { %>
<input type="submit" name="page" value=<%=count%> style="border: 0; outline: 0; background-color: #FFFFFF" >
<%if (z != pa-1) { %>
 | 
<% } 
count++;
} %>

 </form>

	</div>
	
	<style>

	</style>
	<jsp:include page="/Tail.jsp"/>
</body>
</html>