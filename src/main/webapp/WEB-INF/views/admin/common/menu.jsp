<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div id="sidebar" class="sidebar responsive">
<ul class="nav nav-list">
	<li class="">
		<a href="index.html">
			<i class="menu-icon fa fa-tachometer"></i>
			<span class="menu-text"> Dashboard </span>
		</a>

		<b class="arrow"></b>
	</li>
	<li class="active open">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-list"></i>
			<span class="menu-text"> Tables </span>

			<b class="arrow fa fa-angle-down"></b>
		</a>

		<b class="arrow"></b>

		<ul class="submenu">
			<li class="active">
				<a href="tables.html">
					<i class="menu-icon fa fa-caret-right"></i>
					Simple &amp; Dynamic
				</a>

				<b class="arrow"></b>
			</li>

			<li class="">
				<a href="jqgrid.html">
					<i class="menu-icon fa fa-caret-right"></i>
					jqGrid plugin
				</a>

				<b class="arrow"></b>
			</li>
		</ul>
	</li>
	<li class="">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-pencil-square-o"></i>
			<span class="menu-text"> Forms </span>

			<b class="arrow fa fa-angle-down"></b>
		</a>

		<b class="arrow"></b>

		<ul class="submenu">
			<li class="">
				<a href="form-elements.html">
					<i class="menu-icon fa fa-caret-right"></i>
					Form Elements
				</a>

				<b class="arrow"></b>
			</li>

			<li class="">
				<a href="form-wizard.html">
					<i class="menu-icon fa fa-caret-right"></i>
					Wizard &amp; Validation
				</a>

				<b class="arrow"></b>
			</li>

			<li class="">
				<a href="wysiwyg.html">
					<i class="menu-icon fa fa-caret-right"></i>
					Wysiwyg &amp; Markdown
				</a>

				<b class="arrow"></b>
			</li>

			<li class="">
				<a href="dropzone.html">
					<i class="menu-icon fa fa-caret-right"></i>
					Dropzone File Upload
				</a>

				<b class="arrow"></b>
			</li>
		</ul>
	</li>		
</ul>					
</div>
</html>