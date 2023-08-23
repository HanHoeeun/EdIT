<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/qna_write.css">
<link rel="stylesheet" href="../css/top.css">
<link rel="stylesheet" href="../css/bottom.css">
</head>
<body>
<header id="header">
<!-- 액션태그 : jsp문법, 태그처럼 사용, 웹의 경로 지정 -->
<!-- include 액션태그 : 반복되는 화면을 파일로 만들고 파일을 가져다가 사요 -->
<jsp:include page="../inc/top.jsp"></jsp:include>
</header>
<!-- 헤더 -->
<div class="_1q_writer">
<!-- 	홈 > 고객센터 현재 위치 -->
	<div class="_1line">
		<img class="_1line_img" src="../img/home.png" width="25px" height="25px"> 
		<p>></p>
		<p>고객센터</p>
	</div>
	<div class="_1q_subpage">
		<table>
			<tr><td><a href="test.jsp">자주 묻는 질문</a></td></tr>
			<tr><td><a href="test.jsp">1:1 상담</a></td></tr>
		</table>
	</div>
		<div class="_1q_query">
		<h1>1:1 문의</h1>
		<form action="writePro.bo" method="post" enctype="multipart/form-data">
			<table class="_1q_query_tab">
				<tr class="_1q_query_tab_top_radius">
				<td class="_1q_query_tab_1">
					<select class="_1q_query_tab_sel" style="border:none;">
						<option value="">문의선택</option>
						<option value="">계정</option>
						<option value="">중고거래</option>
						<option value="">기타</option>
					</select>
				</td>
				<td class="_1q_query_tab_2"><input type="text" name="id" value="작성자" style="border:none;" readonly="readonly"></td>
				</tr>
				<tr>
				<td class="_1q_query_tab_3" colspan="2">제목</td>
				</tr>
				<tr>
				<td class="_1q_query_tab_4" colspan="2" ><input type="text" name="subject" placeholder="제목을 적어주세요" style="border:none;"></td>
				</tr>
				<tr>
				<td class="_1q_query_tab_5">내용</td>
				<td>
					<div class="_1q_query_tab_10"><label for="imgfile"><img src="../img/picture.png" width="25px" height="25px">파일 업로드</label></div>
					<input type="file" name="imgfile" id="imgfile" accept="image/*">
				</td>
				</tr>
				<tr>
				<td class="_1q_query_tab_6" colspan="2"><textarea name="content" style="border:none;" cols="110" rows="20" class="noresize" ></textarea></td>
				</tr>
				<tr>
				<td class="_1q_query_tab_7"colspan="2">답변</td>
				</tr>
				<tr class="_1q_query_tab_bottom_radius">
				<td class="_1q_query_tab_8" colspan="2"><textarea name="content" style="border:none;" cols="110" rows="20" readonly="readonly" class="noresize" ></textarea></td>
				</tr>
			</table>
			<div class="_1q_query_btn">
					<button type="submit">작성</button>
					<button type="reset">취소</button>
			</div>
		</form>
	</div>


</div>

<div class="clear">
<br>
<br>
<br>
</div>
<!-- 푸터 -->
<footer>
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</footer>
</body>
</html>