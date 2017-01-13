<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp" %>

	<section class="cart-info main-wrap">
		<div class="pure-g">
			<div class="pure-u-1-1">
				<table id="mc-cart" class="pure-table">
				    <thead>
				        <tr>
				            <th>名称</th>
				            <th>单价</th>
				            <th>数量</th>
				        </tr>
				    </thead>
				    <tbody>
				    </tbody>
				</table>
				<div class="pure-g">
					<div class="pure-u-1-1 cart-summary">共 <span id="cart-total-count">3</span>份美食 应付 <span id="cart-total-price">￥100</span></div>
				</div>
				<button class="button-choose pure-button clean-btn">清空</button>
				<button class="button-choose pure-button done-btn">确认下单</button>
			</div>
		</div>
	</section>
	<div id="temp_cart_item" style="display:none;">
		<table>
				    <tbody>
				        <tr class='{clazz}'>
				            <td>{name}</td>
				            <td>{price}</td>
				            <td class="cart-item-count"><div class="pure-g" data-item-id="{id}">
							    <div class="pure-u-1-3 cart-inc">+</div>
							    <div class="pure-u-1-3">{count}</div>
							    <div class="pure-u-1-3 cart-dec">-</div>
							</div></td>
				       </tr>
				    </tbody>
				</table>
	</div>
	<script src="js/wx-cart.js" type="text/javascript"></script>
<%@include file="footer.jsp" %>