<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uploadform</title>
</head>
<body>
<h1>상품 업로드</h1>
<br><br>
 <form method="post" action="upload" enctype="multipart/form-data">
	제품 이름 : <input type="text" name = "product_name"><br>
	가격 : <input type="text" name = "price"><br>
    file : <input type="file" name="file"><br>
    <input type="submit">
 </form>    
</body>
</html>