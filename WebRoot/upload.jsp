<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form action="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=6zs4hTxJ5LTUjgAq7TZ53OA2OoaC4YfhZCoRWeZeKK_-aqVFPB43zsvAt-ouoRCCCE9gv3pSQfSz30A40JnCFqCPPFAUzxuKeFn_jl7J6ObC-4AgMabI7B7-Jsv9yM1SVZXdAJAMQO" method="post"
		enctype="multipart/form-data">
		<label for="file">Filename:</label> <input type="file" name="file"
			id="file" /> <br /> <input type="submit" name="submit"
			value="Submit" />
	</form>
</body>
</html>
