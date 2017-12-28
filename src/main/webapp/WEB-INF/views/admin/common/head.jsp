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
<title>CMS后台管理平台</title>
<meta name="description" content="overview &amp; stats"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
<link rel="stylesheet" href="admin/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="admin/assets/css/font-awesome.min.css"/>
<link rel="stylesheet" href="admin/assets/css/ace-fonts.css"/>
<link rel="stylesheet" href="admin/assets/css/ace.min.css"/>
<link rel="stylesheet" href="admin/assets/css/ace-skins.min.css"/>
<link rel="stylesheet" href="admin/assets/css/ace-rtl.min.css"/>
<link rel="stylesheet" href="admin/assets/css/ace.onpage-help.css" />
<link rel="stylesheet" href="admin/css/style.css" />

<script src='admin/assets/js/jquery.min.js'></script>
<script src='admin/assets/js/jquery.mobile.custom.min.js'></script>	
<script src="admin/assets/js/jquery-ui.custom.min.js"></script>
<script src="admin/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="admin/assets/js/jquery.easypiechart.min.js"></script>
<script src="admin/assets/js/jquery.sparkline.min.js"></script>
<script src="admin/assets/js/ace-extra.min.js"></script>
<script src="admin/assets/js/bootstrap.min.js"></script>
<script src="admin/assets/js/spin.min.js"></script>
<script src="admin/js/bootstrap-paginator/bootstrap-paginator.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="admin/assets/js/flot/jquery.flot.min.js"></script>
<script src="admin/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="admin/assets/js/flot/jquery.flot.resize.min.js"></script>


</head>
<body class="no-skin">
<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	</script>

	<div class="navbar-container" id="navbar-container">
		<!-- #section:basics/sidebar.mobile.toggle -->
		<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
			<span class="sr-only">Toggle sidebar</span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>
		</button>
		<!-- /section:basics/sidebar.mobile.toggle -->
		<div class="navbar-header pull-left">
			<!-- #section:basics/navbar.layout.brand -->
			<a href="admin/home" class="navbar-brand">
				<small>
					<i class="fa fa-leaf"></i>
					CMS 后台管理平台
				</small>
			</a>
		</div>
		<!-- #section:basics/navbar.dropdown -->
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="green">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i class="ace-icon fa fa-tasks"></i>
						<span class="badge badge-success">语言</span>
					</a>

					<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close" style="width:120px;">
						<li class="dropdown-header">
							<i class="ace-icon fa fa-check"></i>
							选择语言
						</li>

						<li>
							<a href="admin/setLanguage?lang=zh_CN">
								<div class="clearfix">
									<span class="pull-left">中文简体</span>
								</div>
							</a>
						</li>

						<li>
							<a href="admin/setLanguage?lang=en_US">
								<div class="clearfix">
									<span class="pull-left">English</span>
								</div>
							</a>
						</li>

					</ul>
				</li>
				<!-- #section:basics/navbar.user_menu -->
				<li class="light-blue">
					<a data-toggle="dropdown" href="javascript:void(0);" class="dropdown-toggle">
						<img class="nav-user-photo" src="admin/assets/avatars/user.png" alt="Jason's Photo" />
						<span class="user-info">
							<small>Welcome,</small>
							Jason
						</span>

						<i class="ace-icon fa fa-caret-down"></i>
					</a>

					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="admin/personalCenter">
								<i class="ace-icon fa fa-user"></i>
								个人中心
							</a>
						</li>

						<li class="divider"></li>

						<li>
							<a href="admin/logout">
								<i class="ace-icon fa fa-power-off"></i>
								退出
							</a>
						</li>
					</ul>
				</li>
				<!-- /section:basics/navbar.user_menu -->
			</ul>
		</div>
		<!-- /section:basics/navbar.dropdown -->
	</div><!-- /.navbar-container -->
</div>
<!-- ace scripts -->
<script src="admin/assets/js/ace-elements.min.js"></script>
<script src="admin/assets/js/ace.min.js"></script>
<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="admin/assets/js/ace/ace.onpage-help.js"></script>
</body>
</html>