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
<jsp:include page="common/head.jsp"></jsp:include>
<script type="text/javascript" src="admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="admin/ueditor/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="admin/js/treeview/bootstrap-treeview.js"></script>
</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<script type="text/javascript">
	try{ace.settings.check('main-container' , 'fixed')}catch(e){}
</script>
<jsp:include page="common/menu.jsp"></jsp:include>
<div class="main-content">
<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
	</script>

	<ul class="breadcrumb">
		<li>
			<i class="ace-icon fa fa-home home-icon"></i>
			<a href="#">Home</a>
		</li>
		<li class="active">Dashboard</li>
	</ul><!-- /.breadcrumb -->
</div>
<div class="page-content">
<script id="container" name="content" type="text/plain">
        这里写你的初始化内容
</script>
<div class="col-sm-3">
<div class="widget-box widget-color-green2">
<div class="widget-header">
<h4 class="widget-title lighter smaller">栏目</h4>
</div>
<div class="widget-body">
<div class="widget-main padding-8">
<div id="tree" class="treeview"></div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
    var ue = UE.getEditor('container');
    var tree = [
    	  {
    	    text: "Parent 1",
    	    nodes: [
    	      {
    	        text: "Child 1",
    	        nodes: [
    	          {
    	            text: "Grandchild 1"
    	          },
    	          {
    	            text: "Grandchild 2"
    	          }
    	        ]
    	      },
    	      {
    	        text: "Child 2"
    	      }
    	    ]
    	  },
    	  {
    	    text: "Parent 2"
    	  },
    	  {
    	    text: "Parent 3"
    	  },
    	  {
    	    text: "Parent 4"
    	  },
    	  {
    	    text: "Parent 5"
    	  }
    	];
    function getTree() {
    	  // Some logic to retrieve, or generate tree structure
    	  return tree;
    	}

   	$('#tree').treeview({
   		color: "#428bca",
   		expandIcon: 'glyphicon glyphicon-chevron-right',
        collapseIcon: 'glyphicon glyphicon-chevron-down',
   		data: getTree()
   		
   	});
   	$('#tree').treeview('collapseAll', { silent: true });
</script>
</html>