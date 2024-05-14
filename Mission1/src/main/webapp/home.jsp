<%@page import="db.wifi"%>
<%@page import="db.wifiService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>
	table {
		width : 100%;
		border : 1px solid gray;
	}
	th {
		background-color : green;
		color : white;
		padding : 10px;
	}
	
</style>
</head>
<body>
<form action="home2.jsp">
<h1>와이파이 정보 구하기</h1>
<p>
<a href="home.jsp">홈</a> | 
<a href="history.jsp">위치 히스토리 목록</a> | 
<a href="select.jsp">Open API 와이파이 정보 가져오기</a>
</p>
<p>
LAT : <input type="text" placeholder="0.0" name="inputLat"> 
, LNT: <input type="text" placeholder="0.0" name="inputLnt">
<button>내 위치 가져오기</button>
<input type="submit" value="근처 WIFI정보 보기">
</p>
</form>
<table>
	<thead>
		<tr>
			<th>거리(Km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan="17" style="text-align: center;">
			위치 정보를 입력한 후에 조회해 주세요.</td>
		</tr>
	</tbody>
</table>
</body>
</html>