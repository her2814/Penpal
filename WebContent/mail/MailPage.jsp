<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
	<style>
	input[type=text]::-ms-clear{
	display: none;
	}
		
	.form-4 {
    /* Size and position */
		
    width:300px;
    padding: 10px;
    color: black;
    
}

.form-4 h1 {
    font-size: 22px;
    padding-bottom: 20px;
}
.form-4 input[type=text] {
    /* Size and position */
    width: 100%;
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
.form-4 input[type=password]:hover {
    border-color: #333;
}

.form-4 input[type=text]:focus,
.form-4 input[type=password]:focus,
.form-4 input[type=submit]:focus {
    box-shadow: 
        0 1px 0 rgba(255,255,255,0.2), 
        inset 0 1px 1px rgba(0,0,0,0.1),
        0 0 0 3px rgba(255,255,255,0.15);
    outline: none;
}

/* Fallback */
.no-boxshadow .form-4 input[type=text]:focus,
.no-boxshadow .form-4 input[type=password]:focus {
    outline: 1px solid white;
}
.form-4 input[type=submit] {
    /* Size and position */
    width: 100%;
    padding: 8px 5px;
    
    /* Styles */
    background: linear-gradient(rgba(99,64,86,0.5), rgba(76,49,65,0.7));    
    border-radius: 5px;
    border: 1px solid #4e3043;
    box-shadow: 
    	inset 0 1px rgba(255,255,255,0.4), 
    	0 2px 1px rgba(0,0,0,0.1);
    cursor: pointer;
    transition: all 0.3s ease-out;

    /* Font styles */
    color: white;
    text-shadow: 0 1px 0 rgba(0,0,0,0.3);
    font-size: 16px;
    font-weight: bold;
    font-family: 'Raleway', 'Lato', Arial, sans-serif;
}

.form-4 input[type=submit]:hover {
    box-shadow: 
        inset 0 1px rgba(255,255,255,0.2), 
        inset 0 20px 30px rgba(99,64,86,0.5);
}

/* Fallback */
.no-boxshadow .form-4 input[type=submit]:hover {
    background: #594642;
}
	
	</style>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    	
        <title>메일</title>
    </head>
    <body>
        <form class="form-4" action="sendMessage?recvID=${recverInfo}" method="post" >
			<div align="center"> 
			<p>
       	    <h4> 수  &nbsp&nbsp&nbsp&nbsp 신  &nbsp&nbsp&nbsp&nbsp 인  </h4> <input type="text" value="${recverInfo}"  readonly  style="width:300px;"/>
			</p>
            <p> <h4> 제 &nbsp&nbsp&nbsp&nbsp 목 </h4>
				<input type="text" name="title" style="width:300px;">
			</p>
            <h4> 내 &nbsp &nbsp&nbsp&nbsp용 </h4> <input type="text" name="content" style="width:300px; height:200px;">
			</p>

            <input type="submit" value="보내기" onclick="window.close()" style="width: 200px;">
			</div>
        </form>
        
    </body>
</html>