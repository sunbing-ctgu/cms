<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="introduce_l">
    <ul>
    	<c:forEach  items="${rootColumn.childColumn}" var="item">
    		<li><a href="${item.path}" id="introduce_l_int">${item.name}</a> </li>
    	</c:forEach>
        <!-- <li onclick="javascript:document.getElementById('introduce_l_int').click();"><a href="introduce.html" id="introduce_l_int">商會簡介</a> </li>
        <li onclick="javascript:document.getElementById('introduce_l_his').click();"><a href="history.html" id="introduce_l_his">商會歷程</a> </li>
        <li onclick="javascript:document.getElementById('introduce_l_emb').click();"><a href="emblem.html" id="introduce_l_emb">商會會徽</a> </li>
        <li onclick="javascript:document.getElementById('introduce_l_org').click();"><a href="#" id="introduce_l_org">組織架構</a> </li>
        <li onclick="javascript:document.getElementById('introduce_l_reg').click();"><a href="#" id="introduce_l_reg">商會章程</a> </li>
        <li onclick="javascript:document.getElementById('introduce_l_join').click();"><a href="join.html" id="introduce_l_join">入會申請</a> </li>
        <li onclick="javascript:document.getElementById('introduce_l_mas').click();"><a href="master.html" id="introduce_l_mas">理事會名錄</a> </li> -->
    </ul>
    <div class="introduce_address" style=" margin-top: 240px;">
        <h4>加拿大潮商会</h4>
        <hr/>
        <dl>
            <dt>地址</dt>
            <dd>250-8260 Granville Avenue,Richmond BC V6Y 1P3</dd>
        </dl>
        <dl>
            <dt>電話：</dt>
            <dd>001-604-370-1828</dd>
        </dl>
        <dl>
            <dt>E-mail:</dt>
            <dd>canadachaoshang@gmail.com</dd>
        </dl>
    </div>
</div>
</html>