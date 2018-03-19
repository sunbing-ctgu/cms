<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="index_wap">
	<jsp:include page="common/head.jsp"></jsp:include>
	<div class="index_wap_con">
		<div class="logo">
			<img src="upload/images/logo.png">
		</div>
		<jsp:include page="common/menu.jsp"></jsp:include>
		<jsp:include page="common/columnHead.jsp"></jsp:include>
		<jsp:include page="common/columnLeft.jsp"></jsp:include>
        <div class="introduce_r">
           <div class="introduce_r_tittle" style="margin-bottom: 0; display: block; overflow: hidden">
               <h3>${column.name}</h3>
               <span></span>
           </div>

           <ul class="introduce_r_contact">
           		<c:forEach  items="${pageInfo.list}" var="item">
           			<li class="news_li">
                       <div class="news_time">
                           <div class="news_time_day">${item.date}</div>
                           <div class="news_time_year">${item.year}</div>
                       </div>
                       <dl class="news_con">
                           <dt><a href="${column.path}/${item.id}"> ${item.title}</a></dt>
                           <dd>${item.summary}</dd>
                       </dl>
                   </li>
           		</c:forEach>	
               </ul>
           <div class="page">
               <div value="10"></div>
               <div id="page" class="page_div"></div>
           </div>
       </div>
   </div>
<jsp:include page="common/foot.jsp"></jsp:include>
</div>
<script type="text/javascript" src="js/paging.js"></script>
<script id="jsID" type="text/javascript">
    jQuery(".nav").slide({
        type:"menu",// 效果类型，针对菜单/导航而引入的参数（默认slide）
        titCell:".nLi", //鼠标触发对象
        targetCell:".sub", //titCell里面包含的要显示/消失的对象
        effect:"slideDown", //targetCell下拉效果
        delayTime:300 , //效果时间
        triggerTime:0, //鼠标延迟触发时间（默认150）
        returnDefault:true //鼠标移走后返回默认状态（默认false）
    });
  	//分页
    $("#page").paging({
        pageNo:parseInt("${pageInfo.pageNum}"),
        totalPage:parseInt("${pageInfo.pages}"),
        totalSize: parseInt("${pageInfo.total}"),
        callback: function(pageNum) {
        	queryData(pageNum);
        }
    });
  	
  	function queryData(pageNum) {
  		$.ajax({
  			url: '${column.path}',
  			type: 'POST',
			async: true,
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({'pageNum':pageNum}),
            dataType: 'json',
            success: function(data) {
            	console.log(data);
             	$(".introduce_r_contact").html('');
             	var res = data.pageInfo;
             	for(var i = 0; i< res.list.length; i++){
             		var article = res.list[i];
             		var htmlValue ="<li class='news_li'><div class='news_time'><div class='news_time_day'>"+article.date+"</div><div class='news_time_year'>"+article.year+"</div></div><dl class='news_con'><dt><a href='${column.path}/"+article.id+"'> "+article.title+"</a></dt><dd>"+isNull(article.summary)+"</dd></dl></li>"
	             	$(".introduce_r_contact").append(htmlValue);
             	}
            	$("#page").paging({
                    pageNo:parseInt(res.pageNum),
                    totalPage:parseInt(res.pages),
                    totalSize: parseInt(res.total),
                    callback: function(pageNum) {
                    	queryData(pageNum);
                    }
                });
            }
  		});
  	}
  	
  	function isNull(data){ 
  		return (data == undefined || data == null) ? "" : data; 
  	}
</script>
</html>