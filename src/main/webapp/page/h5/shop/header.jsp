<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="baseUrl"/>
<!DOCTYPE html>
<html>
<head>
<title>吾城-兰州</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A set of small, responsive CSS modules that you can use in every web project.">
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${baseUrl}css/pure-min.css">
<link rel="stylesheet" href="${baseUrl}css/test.css">
<script src="${baseUrl}js/underscore.min.js" type="text/javascript"></script>
<script src="${baseUrl}js/zepto.js" type="text/javascript"></script>
<script src="${baseUrl}js/common.js" type="text/javascript"></script>

</head>
<body>
	<header>
		<div class="title pure-g">
			<div class="pure-u">
				<a href="/" class="logo"> <img src="${baseUrl}img/logo.png">
				</a>
			</div>
			<div class="pure-u curr-location">
				<p>${locationName}</p>
			</div>
		</div>
	</header>
