<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加拿大潮商会</title>
<meta name="description" content="overview &amp; stats"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.superslide.2.1.1.js"></script>
<script src="js/breakingnews.js"></script>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/breakingnews.css">
<script src="<c:url value="js/uaredirect.js"/>" type="text/javascript"></script>
<script type="text/javascript">
uaredirect("wap");
</script>
</head>
<div class="index_wap">
	<div class="index_top_tip">
        <div class="index_top_tip_text">
            <a href="#">中文版</a> <a href="#">英文版</a>
        </div>
    </div>
</div>
</html>