<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- <head>
<base href="<%=basePath%>">
</head> --%>
<div class="nav">
	<ul class="con_1100">
		<c:forEach  items="${sessionScope.menuList}" var="item">
			<c:choose>
				<c:when test="${item.path == sessionScope.currentPath}">
					<li class="nLi on" style="background: #C73A31">
				</c:when>
				<c:otherwise>
					<li class="nLi ">
				</c:otherwise>
			</c:choose>
				<h3>
					<a href="${item.path}"><b>${item.text}</b></a>
				</h3>
				<ul class="sub">
					<c:if test="${not empty item.nodes}">
						<c:forEach  items="${item.nodes}" var="node">
							<li><a href="${node.path}">${node.text}</a></li>
						</c:forEach>
					</c:if>
				</ul>
			</li>
		</c:forEach>
	</ul>
</div>
</html>