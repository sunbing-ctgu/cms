<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="nav_menu">
    <div class="nav_menu_tittle"><h3>菜单导航</h3><span></span></div>
    <div class="subNavBox">
    	<c:forEach  items="${sessionScope.menuList}" var="item">
        	<c:choose>
				<c:when test="${not empty item.nodes}">
					<div class="subNav">${item.text}</div>
				</c:when>
				<c:otherwise>
					<a href="wap/${item.path}"><div class="subNav">${item.text}</div></a>
				</c:otherwise>
			</c:choose>
			<c:if test="${not empty item.nodes}">
				<ul class="navContent">
					<c:forEach  items="${item.nodes}" var="node">
						 <li><a href="wap/${node.path}">${node.text}</a></li>
					</c:forEach>
	            </ul>
			</c:if>
		</c:forEach>
    </div>
</div>
</html>