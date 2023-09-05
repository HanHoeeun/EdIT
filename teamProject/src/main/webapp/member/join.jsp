<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EdIT join</title>
<!-- <link href= "../css/join.css" rel= "stylesheet" type="text/css"> -->
<!-- <link href= "../css/style.css" rel= "stylesheet" type="text/css"> -->
<!-- <link href="../css/faq_1_9.css" rel="stylesheet">  -->
<link href="./css/join.css" rel="stylesheet"> 


</head>
<body>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>   
<html>
<head>
<title>register_3.jsp</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Super Market Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="../css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>
	
<body>
<!-- header -->
		<jsp:include page="/inc/top.jsp"></jsp:include>
<!-- header -->

<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">회원가입</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->

<!-----------------------------------------------------------회원가입 시작------------------------------------------------------------------ -->
	<div class="register">
		<div class="container">
			<h2>회원가입</h2>
			
			<div class="join-form-grids">
				<div class="container_3_1">
					<div class="tab-content current">
					<form action="insertPro.me" method="post" id="join">
					
						<table class="mypage-board">
<!-- 				----아이디입력---- -->
							 <tr>
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" placeholder="아이디 (영문/숫자, 6~20자)" required=" " id="m_id" name="m_id" >
											<br><div class="divdub"></div>
										</div>
									</div>
								</td>
<!-- 				-----중복버튼----							 -->
								<td class="_1qna_board_border3" width="10">
									<div class="up-button">
										<input type="button" class="checkDuplicateID" value="중복확인"><br><br>
									</div>
								</td>
							</tr>
						
						
					
<!-- 				----비밀번호----							 -->
							<tr>
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="password" placeholder="비밀번호 (문자+숫자+특수문자, 8~20자)"	id="m_pass" 	name="m_pass" required=" ">
											<input type="password" placeholder="비밀번호확인" 						id="m_pass2" 	name="m_pass2" required=" ">
											<br><div id="result"></div>
										</div>
									</div>
								</td>
							</tr>
							
<!-- 				----이름입력---- -->
							 <tr>
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" placeholder="이름 (최소 2자 이상)" id="m_name" name="m_name" required=" ">
										</div>
									</div>
								</td>
							</tr>			
<!-- 				----닉네임 입력---- -->
							 <tr>
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" placeholder="닉네임 (최소 2자 이상)" id="m_nick" name="m_nick" required=" ">
										</div>
									</div>
								</td>
<!-- 				----중복확인----	 -->
								<td class="_1qna_board_border3" width="10">
									<div class="up-button">
										<input type="button" class="up-button" value="중복확인">
									</div>
								</td>
							</tr>
						
						
						
<!-- 				----이메일---- -->
							<tr>	
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="email" placeholder="이메일" id="m_email" name="m_email" required=" ">
										</div>
									</div>
								</td>
<!-- 				----중복확인----						 -->
								<td class="_1qna_board_border3" width="10">
									<div class="up-button">
										<input type="button" class="up-button" value="중복확인">
									</div>
								</td>
							</tr>
						
						
<!-- 				----전화번호---- -->
							<tr>	
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="tel" placeholder="전화번호" id="m_phone" name="m_phone" required=" ">
										</div>
									</div>
								</td>
							</tr>
					</table>
				
				</div>
			
			</div><br><br><br>
			
			
			
			
			<div class="register-check-box">
				<div class="check">
					<label class="checkbox"><input type="checkbox" name="m_event"><i> </i>이메일</label>
				</div>
			</div>	<br>		
			<div class="register-check-box">
				<div class="check">
					<label class="checkbox"><input type="checkbox" name="m_event"><i> </i>SMS</label>
				</div>
			</div><br>			
<!-- 			----동의체크---- -->
			<div class="register-check-box">
				<div class="check">
					<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>EdIT의 <span>이용약관 동의</span>하기</label>
				</div>
			</div>			
			
			<div>
				<input type="submit" value="회원가입" onclick="validatePassword()">
			</div>
			</form>
		</div>
			<div class="register-home">
				<a href="main.me">Home</a>
			</div>
		</div>
	</div>
	
<!-----------------------------------------------------------회원가입 끝------------------------------------------------------------------ -->


<!-- --------------------------->
<script type="text/javascript" src="script/jquery-3.7.0.js"></script>
<script type="text/javascript">
//	비밀번호/비밀번호확인 일치
function validatePassword() {
	var newPassword = document.getElementById('m_pass').value;
	var confirmPassword = document.getElementById('m_pass2').value;
	var resultDiv = document.getElementById('result');

	var passwordRegex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,16}$/;

	if (passwordRegex.test(newPassword)) {
		if (newPassword === confirmPassword) {
			resultDiv.innerHTML = '비밀번호 일치';
			resultDiv.style.color = 'green';
			window.location.href = 'login.me';
		}else{
			resultDiv.innerHTML = '비밀번호가 일치하지 않습니다.';
			resultDiv.style.color = 'red';
			return false;
		}
	}else{
		resultDiv.innerHTML = '영문+숫자+특수문자 포함 8~20자로 입력해주세요';
		resultDiv.style.color = 'red';
		return false;
	}
	
}




//	아이디 중복체크
$(document).ready(function (){	
	$('.up-button-button').click(function() {
		$.ajax ({
			url:'idCheck.me',
			data:{'m_id':$('.m_id').val()},
			success:function(result){
				$('.divdub').html(result);
			}
		})	// ajax
	})	// up-button
})	// document
</script>







<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- // 푸터 들어가는 곳! -->

</body>
</html>
</body>
</html>