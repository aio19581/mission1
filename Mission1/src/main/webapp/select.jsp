<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.IOException"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="db.wifi"%>
<%@page import="db.publicWifi"%>
<%@page import="db.wifiService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<style>
	body {
		text-align:center;	
	}
	p {
		font-size:25px;
		font-weight:bold;
	}
</style>
<body>
		<p>
			<%   
			
			wifiService wfService = new wifiService();
			wfService.wifiInsert();
			
			int result = publicWifi.TotalCnt();
			out.print(result);
			
	        %>
	        
			개의 WIFI 정보를 정상적으로 저장하였습니다.
			
		</p>
		<a href="home.jsp">홈으로 가기</a>
	
</body>
</html>