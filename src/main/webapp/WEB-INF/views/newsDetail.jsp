<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="index_wap">
	<jsp:include page="common/head.jsp"></jsp:include>
	<div class="index_wap_con">
		<div class="logo">
			<img src="front/upload/images/logo.png">
		</div>
		<jsp:include page="common/menu.jsp"></jsp:include>
		<jsp:include page="common/columnHead.jsp"></jsp:include>
        <div class="introduce_r">
            <div class="introduce_r_tittle">
                <h3>商會新聞</h3>
                <span></span>
            </div>
            <div class="news_contact">
               <h4>廣東省僑聯黨組書記、主席程學源接見加拿大潮商會代表團</h4>
               <span><small>作者：haojun512</small><small>时间：2017-10-20</small></span>
                <p>2017年11月2日，由國際潮團總會永遠榮譽主席、加拿大潮商會會長林少毅率領的我會訪問團到位於中國廣州市的廣東省歸國華僑聯合會拜訪。訪問團成員還有：加拿大潮商會執行會長蔡光，常務副會長方俊洪、曾斌，副會長林麗珊，名譽會長吳海冰等。</p>
                <img src="images/news_photo.jpg">
                <p>廣東省僑聯黨組書記、主席程學源，副主席李豐、顏珂，廣東省僑聯常委、聯絡部長楊春華，聯絡部副部長王小蕾等熱情接見了我會代表團一行。</p>
                <img src="images/news_photo.jpg">
                <p>程學源主席對代表團一行的到訪表示熱烈歡迎，對林少毅會長長期以來為僑界作出的貢獻表示欽佩。對加拿大潮商會成立以來，充分發揮商會的平臺作用，團結凝聚廣大海外潮商，促進中加經貿往來，並成功地舉辦了第十八屆國際潮團聯誼年會表示贊賞。</p>
                <p>程學源主席說，以習近平同誌為核心的黨中央高度重視僑聯工作。中國共產黨第十九次代表大會確立的以習近平主席為核心的新時代中國特色社會主義思想，是引領做好僑聯各項工作的理論源泉和行動指南。不忘初心，牢記使命，堅持海內、海外兩個平臺並重，堅持新僑和老僑工作並重，讓歸僑僑眷和海外僑胞有更多的歸屬感，為中華民族的偉大復興積聚僑界力量而努力。他希望加拿大潮商會充分發揮自身的特點和優勢，發揮商會橋梁與紐帶作用，團結凝聚廣大海外潮商，積極參與國家經濟建設，為國家 “一带一路”建設服務，實現優勢互補、共贏發展。</p>
                <p>林少毅會長對程學源主席等省僑聯領導的親切會見和盛情接待表示感謝。在介紹了加拿大潮商會的概況以及近期的主要工作之後，林少毅會長表示，廣東省僑聯是海外僑胞的娘家，到省僑聯如同到家，倍感親切。在省僑聯的大力支持和關懷下，加拿大潮商會承辦的第十八屆國際潮團聯誼年會得以順利召開。國際潮團總會和加拿大潮商會熱切希望今後加強與廣東省僑聯的聯系與合作，不斷深化雙方情誼，攜手為國家“一带一路”建設，為廣東經濟社會發展貢獻智慧和力量。</p>
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