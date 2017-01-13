<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

	<section class="food-info">
		<div class="food-info-wrp pricing-tables">
			<div class="pricing-tables pure-g">
			<div class="pure-u-1 pure-u-md-1-1">
				<div class="pricing-table pricing-table-free">
	                <div class="pricing-table-header">
	                	<img src="../img/640.jpeg">
	                </div>
	
	                <ul class="pricing-table-list">
	                    <li>${item.name}</li>
	                    <li>${item.price}</li>
	                </ul>
	                <button class="button-choose pure-button">来一发</button>
	            </div>
	            </div>
            </div>
		</div>
	</section>
	
<%@include file="footer.jsp" %>
