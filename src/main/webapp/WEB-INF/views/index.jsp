<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加拿大潮商会</title>
<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<script type="text/javascript" src="front/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="front/js/jquery.superslide.2.1.1.js"></script>
<link rel="stylesheet" href="front/css/style.css" />
</head>
<body>
	<div class="index_wap">
		<div class="index_top_tip">
			<div class="index_top_tip_text">
				<a href="#">中文版</a> <a href="#">英文版</a>
			</div>
		</div>
		<div class="index_wap_con">
			<div class="logo">
				<img src="front/upload/images/logo.png">
			</div>
			<div class="nav">
				<ul class="con_1100">
					<li class="nLi on" style="background: #C73A31">
						<h3>
							<a href="index.html" target="_blank"><b>首页</b></a>
						</h3>
					</li>
					<li class="nLi ">
						<h3>
							<a href="introduce.html" target="_blank"><b>商會簡介</b></a>
						</h3>
						<ul class="sub">
							<li><a href="introduce.html" target="_blank">商會簡介</a><a
								href="history.html" target="_blank">商會歷程</a></li>
							<li><a href="emblem.html" target="_blank">商會會徽</a></li>
							<li><a href="#" target="_blank">組織架構</a></li>
							<li><a href="#" target="_blank">商會章程</a></li>
							<li><a href="join.html" target="_blank">入會申請</a></li>
							<li><a href="master.html" target="_blank">理事會名錄</a></li>
						</ul>
					</li>
					<li class="nLi ">
						<h3>
							<a href="news.html" target="_blank"><b>新聞動態</b></a>
						</h3>
						<ul class="sub">
							<li><a href="#" target="_blank">商會新聞</a></li>
							<li><a href="#" target="_blank">會員動態</a></li>
							<li><a href="#" target="_blank">國際潮商</a></li>
						</ul>
					</li>
					<li class="nLi ">
						<h3>
							<a href="celebrity.html" target="_blank"><b>加拿大潮人</b></a>
						</h3>
					</li>
					<li class="nLi ">
						<h3>
							<a href="#" target="_blank"><b>人文風光</b></a>
						</h3>
						<ul class="sub">
							<li><a href="#" target="_blank">潮汕人文</a></li>
							<li><a href="#" target="_blank">加拿大風光</a></li>
							<li><a href="#" target="_blank">潮人資訊</a></li>
						</ul>
					</li>
					<li class="nLi ">
						<h3>
							<a href="brand.html" target="_blank"><b>會員品牌</b></a>
						</h3>
					</li>
					<li class="nLi ">
						<h3>
							<a href="link.html" target="_blank"><b>友情鏈接</b></a>
						</h3>
						<ul class="sub">
							<li><a href="#" target="_blank">潮商社團</a></li>
							<li><a href="#" target="_blank">政府網站</a></li>
							<li><a href="#" target="_blank">潮汕資訊</a></li>
						</ul>
					</li>
					<li class="nLi ">
						<h3>
							<a href="contact.html" target="_blank"><b>聯繫我們</b></a>
						</h3>
					</li>
				</ul>
			</div>
			<div class="index_new">
				<div class="index_new_l">
					<div id="turn" class="turn">
						<div class="turn-loading">
							<img src="front/upload/images/loading_comment.gif" />
						</div>
						<ul class="turn-pic">
							<li><a href="#"><img src="front/upload/images/1.jpg" title="演示信息1" /></a></li>
							<li><a href="#"><img src="front/upload/images/2.jpg" title="演示信息2" /></a></li>
							<li><a href="#"><img src="front/upload/images/3.jpg" title="演示信息3" /></a></li>
							<li><a href="#"><img src="front/upload/images/4.jpg" title="演示信息4" /></a></li>
						</ul>
					</div>
				</div>
				<ul class="index_new_r">
					<li
						onclick="javascript:document.getElementById('index_news01').click();">
						<img src="front/upload/images/img_small.png" />
						<dl>
							<dt>
								<a href="#" id="index_news01"> 加拿大總理哈珀會見第珀會見珀會見珀會見珀會見珀會見珀會見</a>
							</dt>
							<dd>加拿大總理史蒂文哈柏於5月27日在加拿大渥太華會見…</dd>
						</dl>
					</li>
					<li style="background: #E0E2E5"
						onclick="javascript:document.getElementById('index_news02').click();">
						<img src="front/upload/images/img_small.png" />
						<dl>
							<dt>
								<a href="#" id="index_news02">加拿大總理哈珀會見第</a>
							</dt>
							<dd>加拿大總理史蒂文哈柏於5月27日在加拿大渥太華會見…</dd>
						</dl>
					</li>
					<li
						onclick="javascript:document.getElementById('index_news03').click();">
						<img src="front/upload/images/img_small.png" />
						<dl>
							<dt>
								<a href="#" id="index_news03">加拿大總理哈珀會見第</a>
							</dt>
							<dd>加拿大總理史蒂文哈柏於5月27日在加拿大渥太華會見…</dd>
						</dl>
					</li>
					<li style="background: #E0E2E5"
						onclick="javascript:document.getElementById('index_news04').click();">
						<img src="front/upload/images/img_small.png" />
						<dl>
							<dt>
								<a href="#" id="index_news04">加拿大總理哈珀會見第</a>
							</dt>
							<dd>加拿大總理史蒂文哈柏於5月27日在加拿大渥太華會見…</dd>
						</dl>
					</li>
				</ul>
			</div>
			<div class="index_banner">
				<img src="front/upload/images/banner.png">
			</div>
			<ul class="news">
				<li class="news_l">
					<div class="news_l_tittle">
						<h4>商会新闻</h4>
						<a href="#">更多></a>
					</div>
					<ul class="news_l_con">
						<li><a href="#">
								廣東省僑聯黨組書記、主席程學源接見黨組書記、主席程學源接見黨組書記、主席程學源接見黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見學源接見黨組書記、主席程……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>

					</ul>
				</li>
				<li class="news_c">
					<div class="news_l_tittle">
						<h4>商会新闻</h4>
						<a href="#">更多></a>
					</div>
					<ul class="news_l_con">
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
					</ul>
				</li>
				<li class="news_r" style="margin-right: 0">
					<div class="news_l_tittle">
						<h4>商会新闻</h4>
						<a href="#">更多></a>
					</div>
					<ul class="news_l_con">
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
						<li><a href="#"> 廣東省僑聯黨組書記、主席程學源接見……</a><span>11-09</span></li>
					</ul>
				</li>

			</ul>
			<div class="index_landscape">
				<ul class="index_landscape_tittle">
					<li class="current" id="s1">潮人資訊</li>
					<li class="current1" id="s2">潮汕人文</li>
					<li class="current1" id="s3">加拿大风光</li>
				</ul>
				<ul class="index_landscape_con">
					<li id="s11">
						<div class="index_landscape_img">
							<img src="front/upload/images/index_landscape.jpg">
						</div>
						<div class="index_landscape_in">
							<h4>马化腾建议创业者：产业跨界领域最具创新机会</h4>
							<hr color="#eaeaea" />
							<p>腾讯科技讯
								腾讯董事会主席兼首席执行官马化腾(微博)周二在香港向青年创业者建议，要关注两个产业跨界的部分，“因为一个产业已经做得很久，已经是一片红海，我们现在看到用新技术在两个产业跨界部分往往是最有可能诞生创新的机会，那可能是一片蓝海”。</p>
							<a href="#">查看更多+</a>
						</div>
					</li>

					<li style="display: none" id="s22">
						<div class="index_landscape_img">
							<img src="front/upload/images/index_landscape.jpg">
						</div>
						<div class="index_landscape_in">
							<h4>马东敏建议创业者：拥抱AI才能赢得未来</h4>
							<hr color="#eaeaea" />
							<p>腾讯科技讯
								腾讯董事会主席兼首席执行官马化腾(微博)周二在香港向青年创业者建议，要关注两个产业跨界的部分，“因为一个产业已经做得很久，已经是一片红海，我们现在看到用新技术在两个产业跨界部分往往是最有可能诞生创新的机会，那可能是一片蓝海”。</p>
							<a href="#">查看更多+</a>
						</div>
					</li>

					<li style="display: none" id="s33">
						<div class="index_landscape_img">
							<img src="front/upload/images/index_landscape.jpg">
						</div>
						<div class="index_landscape_in">
							<h4>马云建议创业者：要抱紧淘宝的大腿</h4>
							<hr color="#eaeaea" />
							<p>腾讯科技讯
								腾讯董事会主席兼首席执行官马化腾(微博)周二在香港向青年创业者建议，要关注两个产业跨界的部分，“因为一个产业已经做得很久，已经是一片红海，我们现在看到用新技术在两个产业跨界部分往往是最有可能诞生创新的机会，那可能是一片蓝海”。</p>
							<a href="#">查看更多+</a>
						</div>
					</li>
				</ul>
			</div>
			<div class="index_bottom">
				<div class="index_stars">
					<div class="news_l_tittle">
						<h4>加拿大潮人</h4>

					</div>
					<ul class="index_stars_con">
						<li><a href="#"> <img src="front/upload/images/people.jpg"> <span>林思齊</span></a>
						</li>
						<li><a href="#"> <img src="front/upload/images/people.jpg"> <span>林思齊</span></a>
						</li>
						<li><a href="#"> <img src="front/upload/images/people.jpg"> <span>林思齊</span></a>
						</li>
						<li><a href="#"> <img src="front/upload/images/people.jpg"> <span>林思齊</span></a>
						</li>
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
		<div class="footer" style="margin-top: 100px;">
			<p>Copyright © 2012 - 2013 加拿大潮商會 ALL Rights Reserved</p>
		</div>

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