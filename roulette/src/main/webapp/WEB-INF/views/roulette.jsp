<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
	margin-top:30px;
	
	border: solid red;
	width: 200px;
	height: 200px;
	display: inline-block;
}

body{
	margin-left: 10%;
	margin-top: 10%;
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
 		
		var view = document.getElementsByClassName("view");
		if (a==b&&b==c){
			view[0].textContent="당첨입니다. +10000"; 
			$.ajax({
				url: "/roulette/money",
				method: 'get',
				data: {
					no: 10000
				},
				success: function(rouletteDto){ 
					$('#view').val(rouletteDto.money);
				},
				error: function(){
					alert("통신실패");
				}
			});
		}else{
			view[0].textContent="당첨이 아닙니다. -100"; 
			$.ajax({
				url: "/roulette/money",
				method: 'get',
				data: {
					no: 100
				},
				success: function(rouletteDto){ 
					$('#view').val(rouletteDto.money);
				},
				error: function(){
					alert("통신실패");
				}
			});
		}
 	}
</script>
<body>
	<div class="header">
		<div class=name><h1>roulette</h1></div>
		<div id = "id" style="width: 500px; margin-left: 22%; text-align: center;"><b>사용자</b>
		<form action="/roulette" style="text-align: center;">
			<input type="text" style="width:150px; height:50px; text-align: center; font-size: 30px;" value="${Dto.name}" name="name">
			<input id="view" type="text" style="width:150px; height:50px; text-align: center; font-size: 30px;" value="${Dto.money }" name="money">
		</form>
		<div class="view" style="width: 100%;height: 50px;text-align: center;margin-top:5%; border: 1px solid red;"></div>
		</div>
		<div style="margin-left: 12%">
		<img class="center" alt="no" src="/resources/img/0.PNG"> 
		<img class="center" alt="no" src="/resources/img/0.PNG"> 
		<img class="center" alt="no" src="/resources/img/0.PNG">
		</div>
		<div ><button onclick="chk()">랜덤선택</button></div>
		<div ><button onclick="location.href='/logout'">로그아웃</button></div>
	</div>
</body>
</html>