<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
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
                    <div class="logo"><img src="wap/images/logo.png"> </div>
                    <div class="menu" style="display: none"><img src="wap/images/menu.jpg"> </div>
                </div>
                <div class="index_new">
                    <div class="index_new_l">
                        <div id="turn" class="turn">
                            <div class="turn-loading"><img src="wap/images/loading_comment.gif" /></div>
                            <ul class="turn-pic">
								<c:forEach  items="${frontCarouselFigureList}" var="item">
									<li><a href="wap/${item.href}"><img src="${item.imgPath}" title="${item.title}"/></a></li>
								</c:forEach>	
							</ul>
                        </div>
                    </div>
                    <ul class="index_new_r">
                    	<c:forEach  items="${topArticleList}" var="item">
							<li>
		                        <a href="wap/front/news/chamber/${item.id}"><img src="${item.titleImg}"/></a>
		                        <dl>
		                            <dt><a href="wap/front/news/chamber/${item.id}" id="">${item.title}</a></dt>
		                            <dd>${item.summary}</dd>
		                        </dl>
		                    </li>
						</c:forEach>
                        <!-- <li onclick="javascript:document.getElementById('index_news01').click();">
                            <img src="images/img_small.png"/>
                            <dl>
                                <dt><a href="#" id="index_news01"> 加拿大總理哈珀會見第珀會見珀會見珀會見珀會見珀會見珀會見</a></dt>
                                <dd>加拿大總理史蒂文哈柏於5月27日在加拿大渥太華會見…</dd>
                            </dl>
                        </li> -->
                    </ul>
                </div>

                <ul class="news">
                    <li class="news_l">
                        <div class="news_l_tittle">
                            <h4>最新公告</h4>
                            <a href="wap/front/notice">更多></a>
                        </div>
                        <ul class="news_l_con">
                            <div class="vticker">
                                <ul>
                                	<c:forEach  items="${noticeList}" var="item">
										<li><a href="wap/front/notice/${item.id}" target="_blank">${item.summary}</a> </li>
									</c:forEach>
                                </ul>
                            </div>
                        </ul>
                    </li>

                    <li class="news_l">
                        <div class="news_l_tittle">
                            <h4>商會新聞</h4>
                            <a href="wap/front/news/chamber">更多></a>
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
																<td align="center"><a href="wap/${item.columnPath}/${article.id}"><img src="${article.titleImg}"  width=230 height=178  border=0><br>${article.title}</a></td>
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
                    </li>
                    <li class="news_c">
                        <div class="news_l_tittle">
                            <h4>會員動態</h4>
                            <a href="wap/front/news/member">更多></a>
                        </div>
                        <ul class="news_l_con">
                        	<c:forEach items="${newsSummaryList}" var="item" varStatus="status">
								<c:choose>
									<c:when test="${status.count == 2}">
										<c:forEach  items="${item.articleList}" var="article">
											<li id="news_l_t_img"  class="index_news01"><a href="wap/${item.columnPath}/${article.id}">
					                            <img src="${article.titleImg}">
					                            <dl>
					                                <dt>${article.title}</dt>
					                                <dd>${article.summary}……</dd>
					                            </dl>
					                            </a>
					                        </li>
										</c:forEach>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</c:forEach>
                        </ul>
                    </li>
                    <li class="news_r" style="margin-right: 0">
                        <div class="news_l_tittle">
                            <h4>國際潮商</h4>
                            <a href="wap/front/news/international">更多></a>
                        </div>
                        <ul class="news_l_con">
							<c:forEach items="${newsSummaryList}" var="item" varStatus="status">
								<c:choose>
									<c:when test="${status.count == 3}">
										<c:forEach  items="${item.articleList}" var="article">
											<li id="news_l_t_img"  class="index_news01"><a href="wap/${item.columnPath}/${article.id}">
					                            <img src="${article.titleImg}">
					                            <dl>
					                                <dt>${article.title}</dt>
					                                <dd>${article.summary}……</dd>
					                            </dl>
					                            </a>
					                        </li>
										</c:forEach>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</c:forEach>
                        </ul>
                    </li>
                </ul>
                <%-- <ul class="news">
                	<c:forEach  items="${humanitySummaryList}" var="item" varStatus="status">
						<c:choose>
							<c:when test="${status.count == 1}">
								<li class="news_l" id="${status.count}">
				                    <div class="news_l_tittle">
				                        <h4>${item.columnName}</h4>
				                        <a href="wap/${item.columnPath}">更多></a>
				                    </div>
				                    <ul class="news_l_t_con">
				                        <c:forEach  items="${item.articleList}" var="article" varStatus="status">
											<li><a href="wap/${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
										</c:forEach>
				                    </ul>
				                </li>
							</c:when>
							<c:when test="${status.count == 2}">
								<li class="news_c" id="${status.count}">
				                    <div class="news_l_tittle">
				                        <h4>${item.columnName}</h4>
				                        <a href="wap/${item.columnPath}">更多></a>
				                    </div>
				                    <ul class="news_l_t_con">
				                        <c:forEach  items="${item.articleList}" var="article" varStatus="status">
											<li><a href="wap/${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
										</c:forEach>
				                    </ul>
				                </li>
							</c:when>
							<c:otherwise>
								<li class="news_r" id="${status.count}" style="margin-right: 0">
				                    <div class="news_l_tittle">
				                        <h4>${item.columnName}</h4>
				                        <a href="wap/${item.columnPath}">更多></a>
				                    </div>
				                    <ul class="news_l_t_con">
										<c:forEach  items="${item.articleList}" var="article" varStatus="status">
											<li><a href="wap/${item.columnPath}/${article.id}"> ${article.summary}</a><span>${article.date}</span></li>
										</c:forEach>
				                    </ul>
				                </li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
                </ul> --%>
                <div class="index_banner"><img src="upload/images/banner.png"> </div>
                <div class="index_bottom">
                    <div class="index_stars">
                        <div class="news_l_tittle">
                            <h4>加拿大潮人</h4>
                            <a href="wap/front/chaosan">更多></a>
                        </div>
                        <ul class="index_stars_con">
                        	<c:forEach  items="${chaorenList}" var="item" varStatus="status">
								<li><a href="wap/front/chaosan/${item.id}"> <img height="222" width="180" src="${item.titleImg}"> <span>${item.title}</span></a>
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
                                <dd>8836 Selkirk Street,Vancouver V6P 4J8</dd>
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

                <%-- <div class="index_link rolling_new">
                    <div class="news_l_tittle">
                        <h4>友情鏈接</h4>
                        <a href="wap/front/links">更多></a>
                    </div>
                    <div class="index_link_con">
                    	<c:forEach  items="${linksList}" var="item" varStatus="status">
	                		<c:if test="${status.count eq 1 || (status.count-1) % 2 eq 0}">
	                			<ul>
	                		</c:if>
							<li><a href="${item.href}">${item.title}</a>
							<c:if test="${status.count % 2 eq 0 || status.count % 2 eq 2}">
	                			</ul>
	                		</c:if>
		           		</c:forEach>
                    </div>
                </div> --%>
 			<jsp:include page="common/menu.jsp"></jsp:include>
            </div>
            <jsp:include page="common/foot.jsp"></jsp:include>
        </div>
    </div>
       <script type="text/javascript">
        $(document).ready(function(){

            var dd = $('.vticker').easyTicker({
                direction: 'up',
                easing: 'easeInOutBack',
                speed: 'slow',
                interval: 2000,
                height: '36',
                visible: 1,
                mousePause: 0,
                controls: {
                    up: '.up',
                    down: '.down',
                    toggle: '.toggle',
                    stopText: 'Stop !!!'
                }
            }).data('easyTicker');


        });

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
    <script type="text/javascript">
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
    </script>

    <script type="text/javascript">
        var speed=50
        marquePic2.innerHTML=marquePic1.innerHTML
        function Marquee(){
            if(demo.scrollLeft>=marquePic1.scrollWidth){
                demo.scrollLeft=0
            }else{
                demo.scrollLeft++
            }
        }
        var MyMar=setInterval(Marquee,speed)
        demo.onmouseover=function() {clearInterval(MyMar)}
        demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
    </script>
</body>
</html>