<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/prodDetail.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel= "stylesheet" type="text/css">



</head>

<body>
                                    <!-- 구매자용 -->

<!-- 헤더 들어가는 곳! -->
<jsp:include page="../top.jsp"></jsp:include>
<!-- 헤더 들어가는 곳! -->

<hr>

<!-- 본문 -->
<div class="_2product-detail">

  <div class="_2product-preview">
  
  <!-- 큰이미지 -->
    <img class="_2main-image" src="main-image.png" />
    
    <div class="_2images">
    
      <div class="_2photo">
    
    <!-- 작은이미지 -->  
        <img class="_2_01" src="_01.png" /><img class="_2_05" src="_05.png" /><img
          class="_2_03"
          src="_03.png"
        /><img class="_2_04" src="_04.png" /><img class="_2_02" src="_02.png" /><img
          class="_2_06"
          src="_06.png"
        />
        
      </div>
      
    </div>
    
  </div> 
  
<!--   --------------------------------------------------------------------------------- -->
  
  <div class="_2product-detail2">
  
    <div class="_2product-detail3">
    
    <!-- 오른쪽 본문 -->
    <div class="_2category">카테고리</div>
    
    
      <div class="_2product-content">
        <div class="_2heading">
          <div class="_2_2020">제목</div>
        </div>
      </div>
      
      <div class="_2prices">
        <div class="_2price">
          <div class="_2_80">가격</div>
        </div>
      </div>
      <div class="_2devider"></div>
      <div class="_2form">
        <div class="_2row">
        </div>
      </div>
      
      <div>상품상태</div>
      <div>판매자ID</div>
      <div>등록날짜</div>
      
      
      
      <div class="_2buttons">
        <div class="_2button">
			<a class="_2label" href="">1:1 chat</a>
        </div>
      </div>
         
      <!--  버튼 -->
      <div class="_2content">
          <a href="" class="_2add-to-wishlist2">wishlist 추가</a>
          <a href="" class="_2commit">구매확정</a>
          <a href="" class="_2report">신고</a>
          <a href="" class="_2list">목록</a>
      </div>
      
    </div>
    <div class="_2form2"></div>
    
  </div>
  
</div>

<!-- 상품설명 -->
<h2>상품설명</h2>
<div class="product-information">
    <div class="desciption">상품상세 설명............
    </div>
</div>


<!-- 푸터 들어가는 곳! -->
<jsp:include page="../bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳! -->

</body>
</html>