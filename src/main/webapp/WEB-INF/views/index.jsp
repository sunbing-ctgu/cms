<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
    .demo { width: 99.5%; margin: 0 auto; box-sizing: border-box}
    .demo2 { margin-top: 24px;}

</style>
</head>
<body>
	<div class="index_wap">
		<jsp:include page="common/head.jsp"></jsp:include>
		<div class="index_wap_con">
			<div class="logo">
				<img src="upload/images/logo.png">
			</div>
			<jsp:include page="common/menu.jsp"></jsp:include>
			<div class="index_new">
				<div class="index_new_l">
					<div id="turn" class="turn">
						<div class="turn-loading">
							<img src="upload/images/loading_comment.gif" />
						</div>
						<ul class="turn-pic">
							<c:forEach  items="${frontCarouselFigureList}" var="item">
								<li><a href="${item.href}"><img src="${item.imgPath}" title="${item.title}"/></a></li>
							</c:forEach>	
						</ul>
					</div>
				</div>
				<div class="index_new_r">
						<c:forEach  items="${topArticleList}" var="item">
							<li>
		                        <a href="front/news/chamber/${item.id}"><img src="${item.titleImg}"/></a>
		                        <dl>
		                            <dt><a href="front/news/chamber/${item.id}" id="index_news01">${item.title}</a></dt>
		                            <dd>${item.summary}</dd>
		                        </dl>
		                    </li>
						</c:forEach>
                </div>	
			</div>

			<div class="demo demo2">
                <div class="BreakingNewsController easing" id="breakingnews2">
                    <div class="bn-title"></div>
                    <ul id="abc">
                   		<c:forEach  items="${noticeList}" var="item">
							<li><a href="front/notice/${item.id}" target="_blank">${item.summary}</a> </li>
						</c:forEach>
                    </ul>
                    <div class="bn-arrows"><span class="bn-arrows-left"></span><span class="bn-arrows-right"></span></div>
                </div>
            </div>
			<div class="rolling_new">
                <div class="news_l_tittle">
                    <h4>商會新聞</h4>
                    <a href="front/news/chamber">更多></a>
                </div>
                <div class="rolling_new_con">
                    <div id=demo style="overflow:hidden;width:96%; margin: 10px 2%;" align=center>
                        <table border=0 align=center cellpadding=1 cellspacing=1 cellspace=0 >
                            <tr><td valign=top bgcolor=ffffff id=marquePic1>
                                <table width='100%' border='0' cellspacing='0'>
                                    <tr>
                                    	<c:forEach  items="${newsSummaryList}" var="item" varStatus="status">
											<c:choose>
												<c:when test="${status.count == 1}">
													<c:forEach  items="${item.articleList}" var="article">
														<td align=center><a href='${item.columnPath}/${article.id}'><img src="${article.titleImg}"  width=230  border=0><br>...</a></td>
													</c:forEach>
												</c:when>
												<c:otherwise>
												</c:otherwise>
											</c:choose>
										</c:forEach>
                                    </tr>
                                </table>
                            </td><td id=marquePic2 valign=top></td></tr>
                        </table>
                    </div>
                </div>
            </div>
			<ul class="news">
				<c:forEach  items="${newsSummaryList}" var="item" varStatus="status">
					<c:choose>
						<c:when test="${status.count == 2}">
							<li class="news_l_t">
								<div class="news_l_tittle">
									<h4>${item.columnName}</h4>
									<a href="${item.columnPath}">更多></a>
								</div>
								<ul class="news_l_t_con">
									<c:forEach  items="${item.articleList}" var="article" varStatus="status">
										<c:choose>
											<c:when test="${status.index==0}">
												<li id="news_l_t_img"><a href="${item.columnPath}/${article.id}">
						                            <img src="${article.titleImg}">
						                            <dl>
						                                <dt>${article.title}</dt>
						                                <dd>${article.summary}……</dd>
						                            </dl>
						                            </a>
						                        </li>
											</c:when>
											<c:otherwise>
												<li><a href="${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</ul>
							</li>
						</c:when>
						<c:when test="${status.count == 3}">
							<li class="news_r_t" style="margin-right: 0">
								<div class="news_l_tittle">
									<h4>${item.columnName}</h4>
									<a href="${item.columnPath}">更多></a>
								</div>
								<ul class="news_l_con">
									<c:forEach  items="${item.articleList}" var="article" varStatus="status">
										<c:choose>
											<c:when test="${status.index==0}">
												<li id="news_l_t_img_r"><a href="${item.columnPath}/${article.id}">
						                            <img src="${article.titleImg}">
						                            <dl>
						                                <dt>${article.title}</dt>
						                                <dd>${article.summary}……</dd>
						                            </dl>
						                            </a>
						                        </li>
											</c:when>
											<c:otherwise>
												<li><a href="${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</ul>
							</li>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
			<div class="index_landscape">
				<c:forEach  items="${humanitySummaryList}" var="item" varStatus="status">
					<c:choose>
						<c:when test="${status.count == 1}">
							<li class="news_l" id="${status.count}">
			                    <div class="news_l_tittle">
			                        <h4>${item.columnName}</h4>
			                        <a href="${item.columnPath}">更多></a>
			                    </div>
			                    <ul class="news_l_con">
			                        <c:forEach  items="${item.articleList}" var="article" varStatus="status">
										<li><a href="${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
									</c:forEach>
			                    </ul>
			                </li>
						</c:when>
						<c:when test="${status.count == 2}">
							<li class="news_c" id="${status.count}">
			                    <div class="news_l_tittle">
			                        <h4>${item.columnName}</h4>
			                        <a href="${item.columnPath}">更多></a>
			                    </div>
			                    <ul class="news_l_con">
			                        <c:forEach  items="${item.articleList}" var="article" varStatus="status">
										<li><a href="${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
									</c:forEach>
			                    </ul>
			                </li>
						</c:when>
						<c:otherwise>
							<li class="news_r" id="${status.count}" style="margin-right: 0">
			                    <div class="news_l_tittle">
			                        <h4>${item.columnName}</h4>
			                        <a href="${item.columnPath}">更多></a>
			                    </div>
			                    <ul class="news_l_con">
									<c:forEach  items="${item.articleList}" var="article" varStatus="status">
										<li><a href="${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
									</c:forEach>
			                    </ul>
			                </li>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</div>
			<div class="index_banner">
				<img src="upload/images/banner.png">
			</div>
			<div class="index_bottom">
				<div class="index_stars">
					<div class="news_l_tittle">
						<h4>加拿大潮人</h4>
						<a href="front/chaosan">更多&gt;</a>
					</div>
					<ul class="index_stars_con">
						<c:forEach  items="${chaorenList}" var="item" varStatus="status">
							<li><a href="front/chaosan/${item.id}"> <img height="222" width="180" src="${item.titleImg}"> <span>${item.title}</span></a>
		           		</c:forEach>	
					</ul>
				</div>
				<div class="index_cantact_us">
					<div class="news_l_tittle">
						<h4>联系我们</h4>
					</div>
					<div class="index_cantact_us_con">
						<dl>
							<dt>Address:</dt>
							<dd>250-8260 Granville Avenue,Richmond BC V6Y 1P3</dd>
						</dl>
						<dl>
							<dt>TEL:</dt>
							<dd>001-604-370-1828</dd>
						</dl>
						<dl>
							<dt>EMAIL:</dt>
							<dd>canadachaoshang@gmail.com</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<div class="index_link rolling_new">
                <div class="news_l_tittle">
                    <h4>友情鏈接</h4>
                    <a href="front/links">更多></a>
                </div>
                <div class="index_link_con">
                	<c:forEach  items="${linksList}" var="item" varStatus="status">
                		<c:if test="${status.count eq 1 || (status.count-1) % 5 eq 0}">
                			<ul>
                		</c:if>
						<li><a href="${item.href}">${item.title}</a>
						<c:if test="${status.count % 5 eq 0 || status.count % 5 eq 5}">
                			</ul>
                		</c:if>
	           		</c:forEach>
                </div>
            </div>
		<jsp:include page="common/foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
        $(function(){

            $('#breakingnews2').BreakingNews({
                title: '最新公告',
                titlebgcolor: '#E94034',
                linkhovercolor: '#E94034',
                border: '1px solid #e8e6e7',
                timer: 4000,
                effect: 'slide'
            });

        });
    </script>
    <script type="text/javascript">
    
        jQuery(".nav").slide({
            type:"menu",// 效果类型，针对菜单/导航而引入的参数（默认slide）
            titCell:".nLi", //鼠标触发对象
            targetCell:".sub", //titCell里面包含的要显示/消失的对象
            effect:"slideDown", //targetCell下拉效果
            delayTime:300 , //效果时间
            triggerTime:0, //鼠标延迟触发时间（默认150）
            returnDefault:true //鼠标移走后返回默认状态（默认false）
        });

        (function(id,t){
            if(!document.getElementById(id)){return false;}
            var doc = document,
                auto='',
                oId = doc.getElementById(id),
                IE = /msie (\d+\.\d)/i.test(navigator.userAgent),
                num = 0,
                bot = true,
                setOpacity = function(obj, opacity){
                    if(IE){
                        obj.style.filter = 'Alpha(Opacity=' + (opacity * 100) + ')';
                    }
                    else{
                        obj.style.opacity = opacity;
                    };
                },
                setBottom = function(obj, bottom){
                    obj.style.bottom = bottom + 'px';
                },
                fideIn = function(obj, timeLimit){
                    if(obj.style.display === 'none'){
                        obj.style.display = 'block';
                    };
                    setOpacity(obj, 0);
                    obj.style.zIndex = 1;
                    if(!timeLimit){
                        timeLimit = 200;
                    };
                    var opacity = 0,
                        step = timeLimit / 20;
                    clearTimeout(fideInTime);
                    var fideInTime = setTimeout(function(){
                        bot = false;
                        if(opacity >= 1){
                            bot = true;
                            return;
                        };
                        opacity += 1 / step;
                        setOpacity(obj, opacity);
                        fideInTime = setTimeout(arguments.callee, 20);
                    },20);
                },
                fideOut = function(obj, timeLimit){
                    if(!timeLimit){
                        timeLimit = 200;
                    };
                    setOpacity(obj, 1);
                    obj.style.zIndex = 0;
                    var opacity = 1,
                        step = timeLimit / 20;
                    clearTimeout(fideOutTime);
                    var fideOutTime = setTimeout(function(){
                        if (opacity <= 0) {
                            setOpacity(obj, 0);
                            return;
                        };
                        opacity -= 1 / step;
                        setOpacity(obj, opacity);
                        fideOutTime = setTimeout(arguments.callee, 20);

                    },20);
                },
                heightIn = function(obj, timeLimit){
                    if(obj.style.display === 'none'){
                        obj.style.display = 'block';
                    };
                    setBottom(obj, -40);
                    if(!timeLimit){
                        timeLimit = 200;
                    };
                    var bottom = -40,
                        step = timeLimit / 20;
                    clearTimeout(heightInTime);
                    var heightInTime = setTimeout(function(){
                        if(bottom >= 8){
                            setBottom(obj, 8);
                            return;
                        };
                        bottom += 28 / step;
                        setBottom(obj, bottom);
                        heightInTime = setTimeout(arguments.callee, 20);
                    },20);
                },
                heightOut = function(obj, timeLimit){
                    if(!timeLimit){
                        timeLimit = 200;
                    };
                    setBottom(obj, 8);
                    var bottom = 8,
                        step = timeLimit / 20;
                    clearTimeout(heightOutTime);
                    var heightOutTime = setTimeout(function(){
                        if(bottom <= -40){
                            setBottom(obj, -40);
                            return;
                        };
                        bottom -= 28 / step;
                        setBottom(obj, bottom);
                        heightOutTime = setTimeout(arguments.callee, 20);
                    },20);
                },
                getClass = function(oElem, strTagName, strClassName){
                    var arrElements = (strTagName == '*' && oElem.all) ? oElem.all : oElem.getElementsByTagName(strTagName);
                    var returnArrElements = new Array();
                    var oRegExp =  new RegExp('(^|\\s)' + strClassName + '($|\\s)');
                    for(var i=0; i<arrElements.length; i++){
                        if(oRegExp.test(arrElements[i].className)){
                            returnArrElements.push(arrElements[i]);
                        }
                    }
                    return (returnArrElements);
                },
                createElement = function(tag, id, cla){
                    var elem = document.createElement(tag);
                    if(id && id !== ""){
                        elem.id = id;
                    }
                    if(cla && cla !== ""){
                        elem.className = cla;
                    }
                    return elem;
                },
                showImg = function(n,b){
                    var turnPic = getClass(oId,'ul','turn-pic')[0];
                    var oLi = turnPic.getElementsByTagName('li');
                    var turnTit = getClass(oId,'ul','turn-tit')[0];
                    var oLi2 = turnTit.getElementsByTagName('li');
                    var turnBtn = getClass(oId,'div','turn-btn')[0];
                    var oSpan = turnBtn.getElementsByTagName('span')[0];
                    fideIn(oLi[n],300);
                    heightIn(oLi2[n],300);
                    oSpan.innerHTML = (n+1)+'/'+oLi.length;
                    if(b==true){
                        if(n==oLi.length-1){
                            fideOut(oLi[0],300);
                            heightOut(oLi2[0],300);
                        }
                        if(n<oLi.length-1){
                            fideOut(oLi[n+1],300);
                            heightOut(oLi2[n+1],300);
                        }
                    }
                    else{
                        if(n>0){
                            fideOut(oLi[n-1],300);
                            heightOut(oLi2[n-1],300);
                        }
                        if(n==0){
                            fideOut(oLi[oLi.length-1],300);
                            heightOut(oLi2[oLi2.length-1],300);
                        }
                    }
                },
                addHtml = function(){
                    var oBg = createElement('div','','turn-bg');
                    var oTit = createElement('ul','','turn-tit');
                    var oBtn = createElement('div','','turn-btn');
                    var turnPic = getClass(oId,'ul','turn-pic')[0];
                    var oA = turnPic.getElementsByTagName('a');
                    var oImg = turnPic.getElementsByTagName('img');
                    for(var i=0,len=oA.length;i<len;i++){
                        oTit.innerHTML += '<li><a href="'+ oA[i].href +'">'+ oImg[i].title +'</a></li>';
                    }
                    oBtn.innerHTML = '<div class="lb"></div><div class="rb"></div><span></span>';
                    oId.appendChild(oBg);
                    oId.appendChild(oTit);
                    oId.appendChild(oBtn);
                },
                init = function(){
                    addHtml();
                    showImg(0);
                    var turnLoading = getClass(oId,'div','turn-loading')[0];
                    oId.removeChild(turnLoading);
                    oId.onmouseover = function(){
                        clearInterval(auto);
                    };
                    oId.onmouseout = function(){
                        auto = setInterval(autoTurn, t*1000);
                    };
                    var turnPic = getClass(oId,'ul','turn-pic')[0];
                    var oLi = turnPic.getElementsByTagName('li');
                    var oLb = getClass(oId,'div','lb')[0];
                    var oRb = getClass(oId,'div','rb')[0];
                    oLb.onmouseover = function(){
                        this.style.backgroundPosition = '-12px 0';
                    }
                    oLb.onmouseout = function(){
                        this.style.backgroundPosition = '0 0';
                    }
                    oLb.onclick = function(){
                        if(!bot){ return false; }
                        if(num==0){
                            num = oLi.length-1;
                        }
                        else{
                            num = num - 1;
                        }
                        showImg(num,1);
                    }
                    oRb.onmouseover = function(){
                        this.style.backgroundPosition = '-18px 0';
                    }
                    oRb.onmouseout = function(){
                        this.style.backgroundPosition = '-6px 0';
                    }
                    oRb.onclick = function(){
                        if(!bot){ return false; }
                        if(num==oLi.length-1){
                            num = 0;
                        }
                        else{
                            num = num + 1;
                        }
                        showImg(num);
                    }
                },
                autoTurn=function(){
                    var turnPic = getClass(oId,'ul','turn-pic')[0];
                    var oLi = turnPic.getElementsByTagName('li');
                    if(num==oLi.length-1){
                        num = 0;
                    }
                    else{
                        num = num + 1;
                    }
                    showImg(num);
                };
            init();
            auto = setInterval(autoTurn, t*1000);
        })('turn',3);
        $('#s1').click(function(){
            $('#s11').css('display','block');
            $('#s1').attr('class','current');
            $('#s22').css('display','none');
            $('#s2').removeClass('current');
            $('#s33').css('display','none');
            $('#s3').removeClass('current');
        });
        $('#s2').click(function(){
            $('#s22').css('display','block');
            $('#s2').attr('class','current');
            $('#s11').css({'display':'none',});
            $('#s1').removeClass('current');
            $('#s33').css('display','none');
            $('#s3').removeClass('current');
        });
        $('#s3').click(function(){
            $('#s33').css('display','block');
            $('#s3').attr('class','current');
            $('#s11').css({'display':'none',});
            $('#s1').removeClass('current');
            $('#s22').css('display','none');
            $('#s2').removeClass('current');
        });
    </script>
</body>
</html>