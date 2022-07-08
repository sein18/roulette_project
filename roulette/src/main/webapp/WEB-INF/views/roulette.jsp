<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.header {
	border: solid red;
	width: 1000px;
	height: 700px
}
.name {
	border: solid red;
	width: auto;
	height: 100px;
}
.center{
	margin-left:30px;
	margin-top:200px;
	
	border: solid red;
	width: 200px;
	height: 200px;
	display: inline-block;
}
</style>
<script type="text/javascript">
	function chk(){
		var a = Math.trunc(Math.random() * 10 + 1);
		var b = Math.trunc(Math.random() * 10 + 1);
		var c = Math.trunc(Math.random() * 10 + 1);
		
		var at = document.getElementsByClassName("center");
		
		at[0].innerHTML=a
		at[1].innerHTML=b
		at[2].innerHTML=c
 	}
</script>
<body>
	<div class="header">
		<div class=name><h1>roulette</h1></div>
		<div class="center"></div>
		<div class="center"></div>
		<div class="center"></div>
		<div class="center"><button onclick="chk()">랜덤선택</button></div>
	</div>
</body>
</html>