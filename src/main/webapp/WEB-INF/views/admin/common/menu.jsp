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
<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>
<ul class="nav nav-list">
	<li class="">
		<a href="index.html">
			<i class="menu-icon fa fa-home"></i>
			<span class="menu-text"> 管理首页</span>
		</a>

		<b class="arrow"></b>
	</li>
	<li class="active open">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-book"></i>
			<span class="menu-text"> 内容管理 </span>

			<b class="arrow fa fa-angle-down"></b>
		</a>

		<b class="arrow"></b>

		<ul class="submenu">
			<li class="active">
				<a href="tables.html">
					<i class="menu-icon fa fa-caret-right"></i>
					简介管理
				</a>

				<b class="arrow"></b>
			</li>

			<li class="">
				<a href="jqgrid.html">
					<i class="menu-icon fa fa-caret-right"></i>
					新闻管理
				</a>

				<b class="arrow"></b>
			</li>
			
			<li class="">
				<a href="jqgrid.html">
					<i class="menu-icon fa fa-caret-right"></i>
					栏目管理
				</a>

				<b class="arrow"></b>
			</li>
		</ul>
	</li>
	<li class="">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-desktop"></i>
			<span class="menu-text"> 界面风格 </span>

			<b class="arrow fa fa-angle-down"></b>
		</a>

		<b class="arrow"></b>

		<ul class="submenu">
			<li class="">
				<a href="form-elements.html">
					<i class="menu-icon fa fa-caret-right"></i>
					导航管理
				</a>

				<b class="arrow"></b>
			</li>

			<li class="">
				<a href="form-wizard.html">
					<i class="menu-icon fa fa-caret-right"></i>
					图片管理
				</a>

				<b class="arrow"></b>
			</li>
		</ul>
	</li>	
	<li class="">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-cogs"></i>
			<span class="menu-text"> 系统管理 </span>

			<b class="arrow fa fa-angle-down"></b>
		</a>

		<b class="arrow"></b>

		<ul class="submenu">
			<li class="">
				<a href="form-elements.html">
					<i class="menu-icon fa fa-caret-right"></i>
					用户管理
				</a>

				<b class="arrow"></b>
			</li>

			<li class="">
				<a href="form-wizard.html">
					<i class="menu-icon fa fa-caret-right"></i>
					站点设置
				</a>

				<b class="arrow"></b>
			</li>
		</ul>
	</li>	
</ul>					
<!-- #section:basics/sidebar.layout.minimize -->
<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
	<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
</div>
<!-- /section:basics/sidebar.layout.minimize -->
<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
</script>
</div>
</html>