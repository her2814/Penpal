<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
a {
	width:200px; text-align:center;
	order:1 solid silver; padding:5px 25px 0; margin:0 15 0;
	text-decoration: none;
	color: #000000;
	}</style>
    <head>
            <title>�α���</title>
             <link rel = "stylesheet" type = "text/css" href = "./Login/style.css">
             <script language="javascript">

	</script>
    </head>
    <body>
        <form class="form-4" action="Login" method="post">
           <div align="center">  
            <h1>Login</h1>
			</div>
            <p>
                <input type="text" name="id" placeholder="Username or email" required>
            </p>
            <p>
                <input type="password" name='password' placeholder="Password" required> 
            </p><div align="center">
			<input type="button" value="ȸ �� �� �� " onclick='window.open("MemberShip","ȸ������","width=500,height=900,scrollbar=no,toolbar=no,directories=no,noresize")'
					style="border: 0; outline: 0; background-color: #FFFFFF; width: 45%">
			<input type="button" value="ID/�н����� ã�� " onclick='window.open("MemberShip","ȸ������","width=400,height900,scrollbar=no,toolbar=no,directories=no,noresize")'
					style="border: 0; outline: 0; background-color: #FFFFFF;  width: 45%"> </div>
            <p>
                <input type="submit" name="submit" value="Continue">
            </p>       
        </form>
        <jsp:include page="/Tail.jsp"/>
    </body>
</html>