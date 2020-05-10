<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="introduce_position">
           <div class="introduce_r_tittle" style="margin-bottom: 0; display: block; overflow: hidden">
               <h3>${column.name}</h3>
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
                         <p>電話：001-604-370-5788</p>
                         <p>郵箱：canadachaoshang@gmail.com</p>
                         <div class="contact_img"><img src="upload/images/map.png"></div>
                    </div>
                </div>
             </div>
       </div>
   </div>
<jsp:include page="common/foot.jsp"></jsp:include>
</div>
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
</script>
</html>