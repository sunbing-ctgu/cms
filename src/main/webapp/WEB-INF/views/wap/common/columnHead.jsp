<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="introduce_banner">
    <img src="${rootColumn.img}">
    <div class="banner_introduce_text">
        <hr />
        <h2>${rootColumn.name}</h2>
        <p>${rootColumn.rename}</p>
    </div>
</div>
<div class="introduce_position">
    <a href="">首页</a>  <a href="wap/${rootColumn.path}">${rootColumn.name} </a>   <a href="wap/${column.path}">${column.name}</a>
</div>
</html>