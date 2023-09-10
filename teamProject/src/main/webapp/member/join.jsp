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
											<input type="text" placeholder="아이디 (영문/숫자, 6~20자)" id="m_id" name="m_id" class="m_id" >
											<br><div id="id_error_message" class="id_error_message"></div>
										</div>
									</div>
								</td>
							</tr>
						
						
					
<!-- 				----비밀번호----							 -->
							<tr>
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="password" placeholder="비밀번호 (문자+숫자+특수문자, 8~20자)"	id="m_pass" 	name="m_pass">
											<input type="password" placeholder="비밀번호확인" 						id="m_pass2" 	name="m_pass2">
											<br><div id="result"></div>
										</div>
									</div>
								</td>
							</tr>
							
<!-- 				----이름 입력---- -->
							 <tr>
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" placeholder="이름 (최소 2자 이상)" id="m_name" name="m_name">
											<br><div id="name_error_message" class="name_error_message"></div>
										</div>
									</div>
								</td>
							</tr>			
<!-- 				----닉네임 입력---- -->
							 <tr>
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" placeholder="닉네임 (최소 2자 이상)" id="m_nick" name="m_nick">
											<br><div id="nick_error_message" class="nick_error_message"></div>
										</div>
									</div>
								</td>
						
						
						
<!-- 				----이메일---- -->
							<tr>	
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="email" placeholder="이메일" id="m_email" name="m_email">
											<br><div id="email_error_message" class="email_error-message"></div>
										</div>
									</div>
								</td>

<!-- 				----전화번호---- -->
							<tr>	
								<td class="_1qna_board_border2">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="tel" placeholder="전화번호" id="m_phone" name="m_phone" oninput="oninputPhone(this)">
										</div>
									</div>
								</td>
							</tr>
					</table>
				
				
			
			<br><br>
			
			
			
		
<!-- 			----동의체크---- -->
			<div class="register-check-box">
				<div class="check">
					<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>EdIT의 <span>이용약관 동의</span>하기</label>
				</div>
			</div>			
			
			<div>
				<input type="submit" value="회원가입">
			</div>
			</form>
			</div>
			</div>
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


$(document).ready(function() {
    var isFormValid = true;   

    $('#join').submit(function(event) {
        // isFormValid 플래그가 true인 경우에만 폼 제출을 허용합니다.
        if (isFormValid) {
            // isFormValid가 true일 때 폼을 제출합니다.
            alert("회원가입을 축하드립니다"); // 성공 메시지 표시
        } else {
            event.preventDefault(); // 폼 제출 막음
            alert("모든 조건을 만족해야 합니다."); // 선택적으로 오류 메시지 표시
        }
    });
    
    // 아이디 조건 + 중복검사
    $('#m_id').on('input', function() {
        var userId = $(this).val();
        var userIdPattern = /^[a-zA-Z0-9]{6,20}$/;
        var id_error_message = $('#id_error_message');

        if (userId === "") {
            id_error_message.text("아이디를 입력하세요").css("color", "red");
            $('#m_id').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        } else if (!userIdPattern.test(userId)) {
            id_error_message.text("아이디는 영문/숫자 조합이며 6~20자여야 합니다").css("color", "red");
            $('#m_id').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        } 
        // AJAX 요청을 보내서 아이디 중복 여부를 확인합니다.
        $.ajax({
            type: 'POST',
            url: 'idCheck.me',
            data: {'m_id': $('#m_id').val() },
            success: function(result) {
                $('.id_error_message').html(result);
            }
        });
    });

    // 이름 조건
    $('#m_name').on('input', function() {
        var userName = $(this).val();
        var userNamePattern = /^[a-zA-Z0-9ㄱ-힣]{2,}$/;    
        var name_error_message = $('#name_error_message');

        if (userName === "") {
            name_error_message.text("이름을 입력하세요").css("color", "red");
            $('#m_name').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        } else if (!userNamePattern.test(userName)) {
            name_error_message.text("최소 2자 입력하세요").css("color", "red");
            $('#m_name').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        } else {
            // 유효한 경우 에러 메시지를 지웁니다.
            name_error_message.text("");
            isFormValid = true; // 이름 유효성 검사 통과
        }
    });

    // 비밀번호/비밀번호확인 일치
    document.getElementById('m_pass').addEventListener('keyup', validatePassword);
    document.getElementById('m_pass2').addEventListener('keyup', validatePassword);

    function validatePassword() {
        var newPassword = document.getElementById('m_pass').value;
        var confirmPassword = document.getElementById('m_pass2').value;
        var resultDiv = document.getElementById('result');

        var passwordRegex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,16}$/;

        if (passwordRegex.test(newPassword)) {
            if (newPassword === confirmPassword) {
                resultDiv.innerHTML = '';
                isFormValid = true; // 폼 검증 성공
            } else {
                resultDiv.innerHTML = '비밀번호가 일치하지 않습니다.';
                resultDiv.style.color = 'red';
                isFormValid = false; // 폼 검증 실패
            }
        } else {
            resultDiv.innerHTML = '영문+숫자+특수문자 포함 8~16자로 입력해주세요';
            resultDiv.style.color = 'red';
            isFormValid = false; // 폼 검증 실패
        }
    }

    // 닉네임 조건 + 중복검사
    $('#m_nick').on('input', function() {
        var userNick = $(this).val();
        var userNickPattern = /^[a-zA-Z0-9ㄱ-힣]{2,}$/;
        var nick_error_message = $('#nick_error_message');

        if (userNick === "") {
            nick_error_message.text("닉네임을 입력하세요").css("color", "red");
            $('#m_nick').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        } else if (!userNickPattern.test(userNick)) {
            nick_error_message.text("최소 2자 입력하세요").css("color", "red");
            $('#m_nick').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        }

        $.ajax({
            type: 'POST',
            url: 'nickCheck.me',
            data: {'m_nick': $('#m_nick').val() },
            success: function(result) {
                $('.nick_error_message').html(result);
            }
        });
    });

    // 이메일 조건 + 중복검사
    $('#m_email').on('input', function() {
        var userEmail = $(this).val();
        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        var email_error_message = $('#email_error_message');

        if (userEmail === "") {
            email_error_message.text("이메일을 입력하세요").css("color", "red");
            $('#m_email').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        } else if (!emailPattern.test(userEmail)) {
            email_error_message.text("유효한 이메일 형식이 아닙니다").css("color", "red");
            $('#m_email').focus();
            isFormValid = false; // 폼 검증 실패
            return false;
        } else {
            // 유효한 경우 에러 메시지를 지웁니다.
            email_error_message.text("");
            isFormValid = true; // 이메일 유효성 검사 통과
        }

        $.ajax({
            type: 'POST',
            url: 'emailCheck.me',
            data: {'m_email': $('#m_email').val() },
            success: function(result) {
                $('.email_error-message').html(result);
            }
        });
    });



    })






// 전화번호 - 자동 생성 
	function oninputPhone(target) {
	    target.value = target.value
	        .replace(/[^0-9]/g, '')
	        .replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
	}












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