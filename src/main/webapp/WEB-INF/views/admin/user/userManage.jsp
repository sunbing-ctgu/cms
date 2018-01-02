<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="../common/head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='admin/js/user/userManage.js'></script>
<title>用户管理</title>
</head>
<body class="no-skin">
	<div class="main-container" id="main-container">
		<jsp:include page="../common/menu.jsp"></jsp:include>
		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="admin/home">首页</a></li>
					<li><a href="admin/systemManage/userManage">系统管理</a></li>
					<li class="active">用户管理</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h1>
						系统管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
							用户管理
						</small>
					</h1>
				</div>
				<div class="">
					<div class="col-xs-10">
						<div class="row form-horizontal cms-form-horizontal">
							<div class="col-xs-6 form-group">
								<label class="col-sm-3  control-label">用户名:</label>
								<div class="col-sm-9">
									<input id="userNameSearch" class="input-sm" type="text"	aria-controls="sample-table-2" />
								</div>
								<!-- <label>用户名: <input class="input-sm" type="text" aria-controls="sample-table-2" /></label> -->
							</div>
							<div class="col-xs-6 form-group">
								<label class="col-sm-3  control-label">姓名:</label>
								<div class="col-sm-9">
									<input id="realNameSearch" class="input-sm" type="text"	aria-controls="sample-table-2" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-2">
						<button class="btn btn-sm btn-primary" onclick="onSearch()">搜索</button>
					</div>
				</div>
				<div class="row" style="margin-top: 64px">
					<div class="col-xs-12">
						<div>
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
											<th class="col-md-2">用户名</th>
											<th class="col-md-2">姓名</th>
											<th class="col-md-1">性别</th>
											<th class="col-md-2">手机号</th>
											<th class="col-md-2">是否锁定</th>
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
											<!-- <ul class="pagination pull-right no-margin">
												<li class="prev disabled"><a href="#">&nbsp;<i
														class="fa fa-angle-double-left"></i></a></li>
												<li class="prev disabled"><a href="#">&nbsp;<i
														class="fa fa-angle-left"></i></a></li>
												<li class="active"><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li class="next"><a href="#">&nbsp;<i
														class="fa fa-angle-right"></i></a></li>
												<li class="next"><a href="#">&nbsp;<i
														class="fa fa-angle-double-right"></i></a></li>
											</ul> -->
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
	<!-- Modal -->
	<div class="modal fade" id="user-modal" tabindex="-1" role="dialog"	aria-labelledby="myModalLabel" data-backdrop="static">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="user-modal-title"></h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="username">账号</label>
							<div class="col-sm-9">
								<input type="text" id="username" class="col-xs-10 col-sm-8">
							</div> 
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="password">密码</label>
							<div class="col-sm-9">
								<input type="password" class="col-xs-10 col-sm-8" id="password" aria-describedby="basic-addon3">
							</div> 
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="repassword">确认密码</label>
							<div class="col-sm-9">
								<input type="password" class="col-xs-10 col-sm-8" id="repassword">
							</div> 
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="realname">真实姓名</label>
							<div class="col-sm-9">
								<input type="text" id="realname" class="col-xs-10 col-sm-8">
							</div> 
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="tel">手机号</label>
							<div class="col-sm-9">
								<input type="text" id="tel" class="col-xs-10 col-sm-8">
							</div> 
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="tel">性别</label>
							<div class="col-sm-9 radio">
								<label>
									<input name="sex" type="radio" value="0" class="ace" checked="checked"/>
									<span class="lbl">男</span>
								</label>
								<label>
									<input name="sex" type="radio" value="1" class="ace"/>
									<span class="lbl">女</span>
								</label>
							</div> 
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary user-modal-submit"></button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal确认框 -->
	<div class="modal fade" id="confirm-modal" tabindex="-1" role="dialog"	aria-labelledby="confirmLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="confirmLabel">确认</h4>
				</div>
				<div class="modal-body" id="modal-alert-content"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        			<button type="button" class="btn btn-primary" id="confirm-modal-submit">确定</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>