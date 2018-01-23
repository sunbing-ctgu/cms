<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
             <div class="introduce_r_contact">
             	${article.content}
                 <!-- <p>加拿大憑藉豐富的自然資源、先進的教育體制、國際領先的高科技產業以及全球一流的居住環境，成為世界最大的移民國家之一，吸引來自世界各地成功人士移民，其中包括許多移民加拿大的潮籍商人。經過多年籌劃，在1987年成立的溫哥華潮州同鄉會的基礎上，一批成功的潮籍商人和加國各地潮人社團共同發起，聯合創立了加拿大潮商會，共同選舉加拿大溫哥華潮州同鄉會會長林少毅先生擔任加拿大潮商會會長。</p>
                 <p>加拿大潮商會堅持“擴展團結潮籍商人，搭建加中商貿平臺，促進加中經貿往來，加強加拿大與中國及國際的協作和交流，拓展合作空間，增強潮人凝聚力和國際影響力”的服務宗旨，按照健全的管理制度，合理運用資源，攜手共進，實現雙贏。</p>
                 <p>目前，加拿大潮商會凝聚了許多優秀的商業人才，每個會員都是成功的企業家，從事金融、房地產、礦產資源、森林資源、高科技產業、節能環保產業、教育、養老服務事業等相關方面投資；參與各種類型的專案推介和招商引資活動，積極發揮商會的橋樑紐帶作用，成功推動加中兩國和各國際社團在商貿、文化交流、社會福利事業等領域合作，得到社會各界的肯定與高度讚譽，擴大了潮商的影響力。</p>
                 <p>加拿大潮商會積極推動國際潮團事務的發展，成功獲得第十八屆國際潮團聯誼年會在溫哥華召開的舉辦權。通過舉辦一系列的經貿、文化、旅遊、教育活動，為全世界潮人搭建敦睦鄉誼，攜手并進的平台。</p>
                 <p>加拿大潮商會將繼續與世界各地的華人及商會發展友好合作關係，互相促進經貿發展，共創輝煌。</p> -->
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
</body>
</html>