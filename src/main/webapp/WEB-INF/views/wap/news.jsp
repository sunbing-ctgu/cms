<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="index_wap" id="wrapper">
	<jsp:include page="common/head.jsp"></jsp:include>
	<div class="overlay"></div>
	<jsp:include page="common/navbar.jsp"></jsp:include>
	<div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>
        <div class="index_wap_con">
            <div class="top">
				<div class="logo">
					<img src="upload/images/logo.png">
				</div>
            </div>
            <jsp:include page="common/columnHead.jsp"></jsp:include>
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
	                           <dt><a href="wap/${column.path}/${item.id}"> ${item.title}</a></dt>
	                           <dd>${item.summary}</dd>
	                       </dl>
	                   </li>
	           		</c:forEach>	
	               </ul>
	               <div id="page" class="page_phone"></div>
	         </div>
			<jsp:include page="common/menu.jsp"></jsp:include>
        </div>
        <jsp:include page="common/foot.jsp"></jsp:include>
    </div>
</div>
<script type="text/javascript" src="wap/js/paging.js"></script>
<script type="text/javascript">
    $(function(){
        $(".subNav").click(function(){
            $(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
            $(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")

            // 修改数字控制速度， slideUp(500)控制卷起速度
            $(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
        })
    });
    $(document).ready(function () {
        var trigger = $('.hamburger'),
            overlay = $('.overlay'),
            isClosed = false;

        trigger.click(function () {
            hamburger_cross();
        });

        function hamburger_cross() {

            if (isClosed == true) {
                overlay.hide();
                trigger.removeClass('is-open');
                trigger.addClass('is-closed');
                isClosed = false;
            } else {
                overlay.show();
                trigger.removeClass('is-closed');
                trigger.addClass('is-open');
                isClosed = true;
            }
        }

        $('[data-toggle="offcanvas"]').click(function () {
            $('#wrapper').toggleClass('toggled');

        });
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
  			url: 'wap/${column.path}',
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
             		var htmlValue ="<li class='news_li'><div class='news_time'><div class='news_time_day'>"+article.date+"</div><div class='news_time_year'>"+article.year+"</div></div><dl class='news_con'><dt><a href='wap/${column.path}/"+article.id+"'> "+article.title+"</a></dt><dd>"+isNull(article.summary)+"</dd></dl></li>"
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