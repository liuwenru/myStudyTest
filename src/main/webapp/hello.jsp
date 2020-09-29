<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
       <title>Upload File Request Page</title>
    </head>
    <body>
        <form method="POST" action="spring/uploadFile" enctype="multipart/form-data">
           File to upload: <input type="file" name="file">
           <input type="submit" value="Upload"> 单击此处进行上传
        </form>
    </body>
</html>