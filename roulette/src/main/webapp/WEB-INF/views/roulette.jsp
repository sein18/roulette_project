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
img{
	margin-left:30px;
	margin-top:200px;
	
	border: solid red;
	width: 200px;
	height: 200px;
	display: inline-block;
	border: solid red;
	
	width: 200px;
	height: 200px;
}
#id{
	position: absolute;
	top:15%;
	left: 10%;
	
}
</style>
<script type="text/javascript">
	function chk(){
		var a = Math.trunc(Math.random() * 9 + 1);
		var b = Math.trunc(Math.random() * 9 + 1);
		var c = Math.trunc(Math.random() * 9 + 1);
		
		var at = document.getElementsByClassName("center");
		at[0].setAttribute("src","/resources/img/"+a+".PNG"); 
		at[1].setAttribute("src","/resources/img/"+b+".PNG"); 
		at[2].setAttribute("src","/resources/img/"+c+".PNG"); 
 		
		if (a==b&&b==c){
			alert("당첨되었습니다.");
		}
 	}
</script>
<body>
	<div class="header">
		<div class=name><h1>roulette</h1></div>
		<img class="center" alt="no" src="/resources/img/0.PNG"> 
		<img class="center" alt="no" src="/resources/img/0.PNG"> 
		<img class="center" alt="no" src="/resources/img/0.PNG">
		<div ><button onclick="chk()">랜덤선택</button></div>
	</div>
	<div id = "id"><b>사용자</b>
		<form action="/roulette">
			<input type="text" value="${rouletteDto.name }" name="name">
			<input type="text" value="${rouletteDto.money }" name="money">
		</form>
	</div>
</body>
</html>