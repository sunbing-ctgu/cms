<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="index_wap"  id="wrapper">
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
            <div class="introduce_banner">
			    <img src="${column.img}">
			    <div class="banner_introduce_text">
			        <hr />
			        <h2>${column.name}</h2>
			        <p>${column.rename}</p>
			    </div>
			</div>
			<div class="introduce_position">
			    <a href="">首页</a> <a href="wap/${column.path}">${column.name}</a>
			</div>
            <div class="introduce_r">
	             <div class="introduce_r_tittle">
	                 <h3>${column.name}</h3>
	                 <span></span>
	             </div>
	             <div class="news_contact">
	               <h4>${article.title}</h4>
	               <span><small>作者：${article.author}</small><small>时间：<fmt:formatDate value="${article.publishTime}" pattern="yyyy-MM-dd"/></small></span>
	               <div class="news_content">${article.content}</div>
	            </div>
	         </div>
			<jsp:include page="common/menu.jsp"></jsp:include>
        </div>
        <jsp:include page="common/foot.jsp"></jsp:include>
    </div>
</div>
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
</script>
</body>
</html>