<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
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
            <jsp:include page="common/columnHead.jsp"></jsp:include>
            <div class="introduce_r">
	             <div class="introduce_r_tittle" style="margin-top: 30px;">
	                 <h3>${rootColumn.name}</h3>
	                 <span></span>
	             </div>
	             <ul class="link">
					<c:forEach items="${linksSummary}" var="item">
						<li class="link_list">
	                        <h4>${item.key}</h4>
	                        <ul>
	                        	<c:forEach items="${item.value}" var="article">
	                        		<li><a href="${article.href}">${article.title}</a> </li>
	                        	</c:forEach>
	                        </ul>
	                    </li>
					</c:forEach>
	                </ul>
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