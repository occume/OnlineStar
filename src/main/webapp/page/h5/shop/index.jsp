<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp" %>

	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<section class="food-list main-wrap">
		<div class="food-list-wrp">
		<c:forEach var="item" items="${items}" varStatus="StatusName">
			<div class="pure-g f-item">
				<div class="pure-u-1-5 f-item-1">
					<img src="img/111.jpeg"
						alt="Tilo Mitra's avatar">
				</div>
				<div class="pure-u-3-5 f-item-2">
				<a href="food/${item.id}">
				   <span class="food-name">${item.name}</span>
				   <span class="food-price">￥${item.price}</span></a>
				</div>
				<div class="pure-u-1-5 f-item-3" 
				data-item-id="${item.id}" 
				data-item-name="${item.name}" 
				data-item-price="${item.price}">
				<i class="fa fa-cart-plus fa-lg"></i></div>
			</div>
		</c:forEach>
		</div>
	</section>
	<div id="temp_food_list_item" style="display:none;">
		<div class="pure-g f-item">
				<div class="pure-u-1-5 f-item-1">
					<img src="img/111.jpeg"
						alt="Tilo Mitra's avatar">
				</div>
				<div class="pure-u-3-5 f-item-2">
				<a href="food/2">
				   <span class="food-name">{name}</span>
				   <span class="food-price">¥{price}</span></a>
				</div>
				<div class="pure-u-1-5 f-item-3">
				<i class="fa fa-cart-plus fa-lg"></i></div>
			</div>
	</div>
	<script src="js/wx-h5.js" type="text/javascript"></script>
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" type="text/javascript"></script>

<%@include file="footer.jsp" %>
