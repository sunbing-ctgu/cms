<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <h3>聯繫我們</h3>
                    <span></span>
                </div>
                <div class="contact">
                    <div class="contact_t">
                        <div class="contact_t_message">
                            <div><label>姓名：</label><input type="text" name="name" ></div>
                            <div><label>电邮：</label><input type="email" name="user_email" ></div>
                            <div><label>留言：</label><textarea ></textarea></div>
                            <a href="#">提交</a>
                            <p>*您的留言我们会尽快回复。</p>
                        </div>
                        <div class="contact_add">
                            <h4>加拿大潮商會</h4>
                            <p style=" margin-bottom: 20px">Canada Chaoshan Business Association</p>
                            <p>地址：8836 Selkirk Street,Vancouver V6P 4J8</p>
                            <p>電話：001-604-370-1828</p>
                            <p>郵箱：canadachaoshang@gmail.com</p>
                            <div class="contact_img"><img src="upload/images/map.png"></div>
                        </div>
                    </div>
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