<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="../common/head.jsp"></jsp:include>
<script type="text/javascript" src="admin/js/treeview/bootstrap-treeview.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='admin/js/contentManage/articleManage.js'></script>
<title>新闻管理</title>
</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<script type="text/javascript">
	try{ace.settings.check('main-container' , 'fixed')}catch(e){}
</script>
<jsp:include page="../common/menu.jsp"></jsp:include>
<div class="main-content">
<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
	</script>

	<ul class="breadcrumb">
		<li>
			<i class="ace-icon fa fa-home home-icon"></i>
			<a href="admin/home">首页</a>
		</li>
		<li><a href="admin/columnManage">内容管理</a></li>
		<li class="active">新闻管理</li>
	</ul><!-- /.breadcrumb -->
</div>
<div class="page-content">
<div class="page-header">
	<h1>
		内容管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
			栏目管理
		</small>
	</h1>
</div>
<div class="">
	<div class="col-xs-10">
		<div class="row form-horizontal cms-form-horizontal">
			<div class="col-xs-6 form-group">
				<label class="col-sm-3  control-label">栏目名:</label>
				<div class="col-sm-9">
					<input id="columnNameSearch" class="input-sm" type="text"	aria-controls="sample-table-2" />
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-2">
		<button class="btn btn-sm btn-primary" onclick="onSearch()">搜索</button>
	</div>
</div>
<div class="row" style="margin-top: 64px">
	<div class="col-xs-3" style="padding-right:1px;">
		<div class="widget-box widget-color-blue2" style="margin-top: 0px;">
			<div class="widget-header">
				<h4 class="widget-title lighter smaller">栏目</h4>
			</div>
			<div class="widget-body">
				<div class="widget-main padding-8">
					<div id="tree" class="treeview" style="margin-left: -25px;"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-9" style="padding-left:1px;">
		<div style="margin-top: -10px">
			<h5 class="bigger lighter">
				<a id="add-user-btn" class="btn btn-xs btn-primary" data-toggle="modal" data-id="-1" data-target="#user-modal">
					<i class="glyphicon glyphicon-plus"></i>新增
				</a> 
				<a id="del-user-btn" class="btn btn-xs btn-danger">
					<i class="glyphicon glyphicon-trash"></i>删除
				</a>
			</h5>
		</div>
		<div>
			<div id="sample-table-2_wrapper"
				class="dataTables_wrapper form-inline" role="grid">
				<table id="sample-table-2"
					class="table table-striped table-bordered table-hover dataTable"
					aria-describedby="sample-table-2_info">
					<thead>
						<tr>
							<th class="center col-md-1"><label class="position-relative">
									<input type="checkbox" class="ace checkbox-user-all" /> <span class="lbl"></span>
							</label></th>
							<th class="col-md-2">标题</th>
							<th class="col-md-2">推荐</th>
							<th class="col-md-1">置顶</th>
							<th class="col-md-1">点击数</th>
							<th class="col-md-1">排序</th>
							<th class="col-md-2">更新时间</th>
							<th class="col-md-2">操作</th>
						</tr>
					</thead>
					<tbody id="table-tbody">
					</tbody>
				</table>
				<div class="row" id="pagination">
					<div class="col-xs-5">
						<div class="dataTables_info" id="sample-table-2_info">
							<label for="mySelect">每页:</label> 
							<select	style="width: 80px;" id="total-count-selector" name="totalCount">
								<option value="10" selected="selected" label="10条">10条</option>
								<option value="20" label="20条">20条</option>
								<option value="30" label="30条">30条</option>
								<option value="40" label="40条">40条</option>
								<option value="50" label="50条">50条</option>
							</select> 总共 <span id="total-count"></span>条
						</div>
					</div>
					<div class="col-xs-7" id="paginationBox">
						<div class="dataTables_paginate paging_bootstrap">
							<ul class="pagination pull-right no-margin" id="page">
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="loading">
			<img class="loading-gif" src="admin/img/loading.gif"> 
		</div>
		<div class="submit-loading">
			<img class="loading-gif" src="admin/img/loading.gif"> 
			<span class="loading-word">正在提交...</span>
		</div>
	</div>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
   	$('#tree').treeview({
   		color: "#428bca",
   		expandIcon: 'glyphicon glyphicon-chevron-right',
        collapseIcon: 'glyphicon glyphicon-chevron-down',
   	});
   	$('#tree').treeview('collapseAll', { silent: false });
</script>
</html>