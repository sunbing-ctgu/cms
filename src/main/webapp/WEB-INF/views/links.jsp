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
        <div class="introduce_position">
           <div class="introduce_r_tittle" style="margin-bottom: 0; display: block; overflow: hidden">
               <h3>友情鏈接</h3>
               <span></span>
           </div>
			<ul class="link">
				<c:forEach items="${linksSummary}" var="item">
					<li class="link_list">
                        <h4>${item.key}</h4>
                        <ul>
                        	<c:forEach items="${item.value}" var="article">
                        		<li><a href="${article.href}" target="_blank">${article.title}</a> </li>
                        	</c:forEach>
                        </ul>
                    </li>
				</c:forEach>
                </ul>
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