<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/wishlist.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel= "stylesheet" type="text/css">
</head>


<body>
<!— 헤더 들어가는 곳  —>
<jsp:include page="../top.jsp"></jsp:include>
<!— 헤더 들어가는 곳  —>

<div class="wishlist">
<!- 제목 ->
  <div class="heading">
    <div class="wishlist2">Wishlist</div>
  </div>
  
  <!- 젤위 가로줄 ->
  <div class="sub-heading">
    <div class="products">상품</div>
    <div class="title">제목</div>
    <div class="price">가격</div>
    <div class="stock-status">상품 상태</div>
  </div>
  
  
  <div class="products2">
  	
  	<!- 1번 상품 ->
    <div class="product">
      <div class="product2">
        <img class="image" src="image.png" />
        <div
          class="bose-sport-earbuds-wireless-earphones-bluetooth-in-ear-headphones-for-workouts-and-running-triple-black"
        >
          Bose Sport Earbuds - Wireless Earphones - Bluetooth In Ear Headphones
          for Workouts and Running, Triple Black
        </div>
      </div>
      <div class="frame-411">
        <div class="_999">90만원</div>
      </div>
      <div class="in-stock">판매중</div>
    </div>
    
    <!- 2번 상품 ->
    <div class="product">
      <div class="product2">
        <img class="image" src="image.png" />
        <div class="simple-mobile-5-g-lte-galexy-12-mini-512-gb-gaming-phone">
          Simple Mobile 5G LTE Galexy 12 Mini 512GB Gaming Phone
        </div>
      </div>
      <div class="_2-300-00">200만원</div>
      <div class="in-stock">판매중</div>
    </div>
    
    <!- 3번 상품 ->
    <div class="product">
      <div class="product2">
        <img class="image" src="image.png" />
        <div class="portable-wshing-machine-11-lbs-capacity-model-18-nmfiam">
          Portable Wshing Machine, 11lbs capacity Model 18NMFIAM
        </div>
      </div>
      <div class="_70-00">15만원</div>
      <div class="in-stock">판매중</div>
    </div>
    
    <!- 4번 상품 ->
    <div class="product">
      <div class="product2">
        <img class="image" src="image.png" />
        <div
          class="tozo-t-6-true-wireless-earbuds-bluetooth-headphones-touch-control-with-wireless-charging-case-ipx-8-waterproof-stereo-earphones-in-ear"
        >
          TOZO T6 True Wireless Earbuds Bluetooth Headphones Touch Control with
          Wireless Charging Case IPX8 Waterproof Stereo Earphones in-Ear
        </div>
      </div>
      <div class="frame-411">
        <div class="_220-00">200만원</div>
      </div>
      <div class="out-of-stock">거래 완료</div>
    </div>
    
    <!- 5번 상품 ->
    <div class="product">
      <div class="product2">
        <img class="image" src="image.png" />
        <div
          class="wyze-cam-pan-v-2-1080-p-pan-tilt-zoom-wi-fi-indoor-smart-home-camera-with-color-night-vision-2-way-audio"
        >
          Wyze Cam Pan v2 1080p Pan/Tilt/Zoom Wi-Fi Indoor Smart Home Camera
          with Color Night Vision, 2-Way Audio
        </div>
      </div>
      <div class="_1-499-99">400만원</div>
      <div class="in-stock">판매중</div>
    </div>
    
  </div>
  
</div>


<!- 푸터 ->
<jsp:include page="../bottom.jsp"></jsp:include>

</body>
</html>