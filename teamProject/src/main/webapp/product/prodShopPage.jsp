<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>prodShopPage.jsp</title>
<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/submenu.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel="stylesheet" type="text/css">

<style type="text/css">
._7_filterOpt {
  padding: 0px 30px 0px 30px;
  background: #ffffff;
  border-radius: 2px;
  border-style: solid;
  border-color: var(--gray-00, #ffffff);
  border-width: 1px;
  display: flex;
  flex-direction: row;
  gap: 8px;
  align-items: flex-start;
  justify-content: flex-end;
  flex-shrink: 0;
  position: relative;
  width: 984.75px;
  position: absolute;
  left: 420px;
  top: 320px;
  
	}
</style>
</head>
<body>

<div id="">
<!-- 헤더 들어가는 곳  -->
<jsp:include page="../top.jsp"></jsp:include>
<!-- 헤더 들어가는 곳  -->
<hr>
<!-- 본문 들어가는 곳  -->


<!-- 서브페이지 메인페이지  -->
<!-- 왼쪽 메뉴  -->
<jsp:include page="../product/subMenu.jsp"></jsp:include>

<!-- 내용  -->
<div class="_7_filterOpt">
<form>
  <select name="filter_option" >
    <option value="none">=== 선택 ===</option>
    <option value="popular" selected>인기순</option>
    <option value="recommended">추천순</option>
    <option value="cheap">최저가순</option>
    <option value="expensive">최고가순</option>
  </select>
</form>
</div>

</div>

<!-- 푸터 들어가는 곳! -->
<jsp:include page="../bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳! -->
</body>
</html>