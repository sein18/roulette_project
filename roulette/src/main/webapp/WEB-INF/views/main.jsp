<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
	let n = ${num};
	console.log(n);
	if(n==1){
		alert("아이디, 비밀번호가 존재하지 않습니다.");
	}
</script>
<style>

</style>
<body>

<form action="/login" method="post">
	<label>id:</label>
	<input type="text" name="id"><br>
	<label>pw:</label>
	<input type="password" name="pw">
	<br><br>
	<input type="submit" value="로그인">
</form>
	<button	value="회원가입" onclick="location.href='/regist'">회원가입</button> 

 
</body>
</html>