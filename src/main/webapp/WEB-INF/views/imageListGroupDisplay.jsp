<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
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
				<div class="introduce_r_tittle">
					<h3>${column.name}</h3>
					<span></span>
				</div>
				<div class="join">
					<div class="master">
						<c:forEach items="${articleGroup}" var="item">
							<ul>
								<div class="master_tittle">
									<h4>${item.key}</h4>
								</div>
								<li>
									<ul>
										<c:forEach items="${item.value}" var="article">
											<li><a href="${column.path}/${article.id}"><img
													style="width: 210px; height: 252px"
													src="${article.titleImg}" /><b>${article.title}</b></a></li>
										</c:forEach>
									</ul>
								</li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="common/foot.jsp"></jsp:include>
	</div>
</body>
</html>