<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="index_wap">
	<jsp:include page="common/head.jsp"></jsp:include>
	<div class="index_wap_con">
		<div class="logo">
			<img src="upload/images/logo.png">
		</div>
		<jsp:include page="common/menu.jsp"></jsp:include>
		<div class="introduce_banner">
		    <img src="${column.img}">
		    <div class="banner_introduce_text">
		        <hr />
		        <h2>${column.name}</h2>
		        <p>${column.rename}</p>
		    </div>
		</div>
		<div class="introduce_position">
		    <a href="">首页</a>  <a href="${column.path}">${column.name}</a>
		</div>
        <div class="introduce_r" style="float:left">
            <div class="introduce_r_tittle">
                <h3>最新公告</h3>
                <span></span>
            </div>
            <ul class="notice_con__r_contact">
                <h4>${article.title}</h4>
                <span><small>发布时间：<fmt:formatDate value="${article.publishTime}" pattern="yyyy-MM-dd"/></small><small>浏览次数：288</small></span>
                ${article.content}
            </ul>
            <div class="notice_con_paging">
                <p><b>上一篇：</b><a href="#">我會代表團參加第十九屆國際潮團聯誼年會團長暨秘書長會議</a> </p>
                <p><b>下一篇：</b><a href="#">加拿大商會代表拜訪臺北市潮州同鄉會</a> </p>
            </div>
            <%-- <div class="news_contact">
               <h4>${article.title}</h4>
               <span><small>作者：${article.author}</small><small>时间：<fmt:formatDate value="${article.publishTime}" pattern="yyyy-MM-dd"/></small></span>
                ${article.content}
            </div> --%>
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
  	//分页
    $("#page").paging({
        pageNo:5,
        totalPage: 9,
        totalSize: 300,
        callback: function(num) {
            alert(num)
        }
    })
</script>
</html>