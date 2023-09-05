<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>member/forgotPassword.jsp</title>
<link
	href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
	rel='stylesheet'>
<link href='' rel='stylesheet'>
<script type='text/javascript'
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<style>
body {
	background-position: center;
	background-color: #eee;
	background-repeat: no-repeat;
	background-size: cover;
	color: #505050;
	font-family: "Rubik", Helvetica, Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.5;
	text-transform: none
}

.forgot {
	background-color: #fff;
	padding: 12px;
	border: 1px solid #dfdfdf
}

.padding-bottom-3x {
	padding-bottom: 72px !important
}

.card-footer {
	background-color: #fff
}

.btn {
	font-size: 13px
}

.form-control:focus {
	color: #495057;
	background-color: #fff;
	border-color: #76b7e9;
	outline: 0;
	box-shadow: 0 0 0 0px #28a745
}
</style>
</head>
<body oncontextmenu='return false' class='snippet-body'>
	<div class="container padding-bottom-3x mb-2 mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h2>비밀번호를 잊으셨나요?</h2>
					<p>간단한 3단계로 비밀번호를 변경하세요. 이는 귀하의 비밀번호를 보호하는 데 도움이 될 것입니다!</p>
					<ol class="list-unstyled">
						<li><span class="text-primary text-medium">1. </span>아래에 이메일 주소를 입력하세요.</li>
						<li><span class="text-primary text-medium">2. </span>시스템은 이메일로 OTP(일회용 비밀번호)를 보내드립니다.</li>
						<li><span class="text-primary text-medium">3. </span>다음 페이지에서 OTP를 입력하세요.</li>
					</ol>
				</div>
				
				
				
				<form class="card mt-4" action="forgotPassword.me" method="POST">
					<div class="card-body">
						<div class="form-group">
							<label for="email-for-pass">이메일 주소를 입력하세요.</label> <input
								class="form-control" type="text" name="email" id="email-for-pass" required=""><small
								class="form-text text-muted">등록된 이메일 주소를 입력하세요. 그러면 이 주소로 OTP를 이메일로 보내드리겠습니다.</small>
						</div>
					</div>
					<div class="card-footer">
<!-- 					새 비밀번호 받기 누르면 -> 멤버컨트롤단에 forgotPassword.me가 작동 -->
						<button class="btn btn-success" type="submit">새 비밀번호 받기</button>
						
						<button class="btn btn-danger" type="submit">로그인으로 돌아가기</button>
					</div>
				</form>
				
				
				
			</div>
		</div>
	</div>
	<script type='text/javascript'
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
	<script type='text/javascript' src=''></script>
	<script type='text/javascript' src=''></script>
	<script type='text/Javascript'></script>
</body>
</html>