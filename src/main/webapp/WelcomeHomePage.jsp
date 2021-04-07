<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.cloudproject.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Logged Successfully</title>
<link rel="stylesheet" type="text/css" href="css/upload.css">
 <script language="JavaScript">
    function inform(){
        document.getElementById("p1").innerHTML = "1 File Selected";
    }
 </script>
</head>
<body>
	<%-- <center>
		<% UserBean currentUser =  (UserBean)session.getAttribute("currentSessionUser");%>
		Welcome <%= currentUser.getUserId()%>
	</center>
	
	 <!-- <form action="UploadFileServlet" method="post" name="putFile" id="putFile"
                enctype="multipart/form-data">
                <input type="file" name="myFile" id="fileName">
                <input type="submit" value="Upload">
        </form>  --> --%>
        
   <form action="UploadFileServlet" enctype="multipart/form-data"  method="POST">
      <input type="file" class="file-upload" name ="myFile" onChange='inform()'>
   	  <p id="p1">Drag your files here or click in this area.</p>
   		<button type="submit">Upload</button>
 	</form>
 	
</body>
</html>
