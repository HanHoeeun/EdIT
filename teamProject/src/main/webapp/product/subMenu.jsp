<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subMebu.jsp</title>

<link href= "../css/submenu.css" rel= "stylesheet" type="text/css">



</head>
<body>


<!-- 왼쪽 메뉴  -->

<div class="filter">
  <div class="category">
    <div class="category2">Category</div>
         <div> <input type="radio" value="computer&laptop" name="category"> Computer &amp; Laptop <br>
        </div>
        <div>
        <input type="radio" value="smart-phone" name="category"> SmartPhone<br>
        </div>
        <div>
        <input type="radio" value="tablet" name="category"> Tablet</div>
      </div>
  
  <div class="line-13"></div>
      
  <div class="price-range">
    <div class="price-range2">Price Range</div>
 
    <div class="input-field">
      <div class="min-price">
        <div class="">최저가</div>
      </div>
      <div class="max-price">
        <div class="">최고가</div>
      </div>
    </div>
		<div class="all-price">

        <input type="radio" name="priceRange" value="all-price" >전체 보기

        </div>
        <div class="_0">
        <input type="radio" value="_0" name="priceRange">0원 ~ 5만원
        </div>
        <div class="_5-10">
		<input type="radio" value="_5-10" name="priceRange">5만원 ~ 10만원
		</div>
        <div class="_10-20">
		<input type="radio" value="_10-20" name="priceRange">10만원 ~ 20만원
		</div>
        <div class="_20-30">
        <input type="radio" value="_20-30" name="priceRange">20만원 ~ 30만원
        </div>
        <div class="_30-50">
        <input type="radio" value="_30-50" name="priceRange">30만원 ~ 50만원
        </div>
        <div class="_50-100">
        <input type="radio" value="_50-100" name="priceRange">50만원 ~ 100만원
        </div>
        <div class="_over-100">
        <input type="radio" value="_over-100" name="priceRange">100만원 이상
        </div>
        </div>
    </div>
    <br>
  <div class="line-15"></div>
  <br>
  <div class="popular-brands">
    <div class="_2">제조사</div>
   </div>
          <div class="apple">
          <input type="checkbox" name="apple" value="brandfrom">Apple
          </div>
          <div class="xiaomi">
          <input type="checkbox" name="xiaomi" value="brandfrom">Xiaomi
          </div>
          <div class="hp">
          <input type="checkbox" name="HP" value="brandfrom">HP
          </div>
          <div class="sony">
          <input type="checkbox" name="sony" value="brandfrom">Sony
          </div>
          <div class="microsoft">
          <input type="checkbox" name="Microsoft" value="brandfrom">Microsoft
          </div>
          <div class="lg">
          <input type="checkbox" name="LG" value="brandfrom">LG
          </div>
      	  <div class="intel">
      	  <input type="checkbox" name="intel" value="brandfrom">Intel
      	  </div>
          <div class="samsung">
          <input type="checkbox" name="samsung" value="brandfrom">Samsung
          </div>
      	  <div class="panasonic">
      	  <input type="checkbox" name="panasonic" value="brandfrom">Panasonic
      	  </div>
 <br>
  <div class="line-16"></div>
<br>
  <div class="banner">
    <img class="image1" src="../img/img1.png" />
    <div class="content">
      <div class="content2">
        <div class="info">
          <div class="_3">안쓰는 애플워치 팝니다!!</div>
        </div>
        <div class="prices">
          <div class="4">네고 가능!</div>
          <div class="prices2">
            <div class="_20">20만원</div>
          </div>
        </div>
      </div>
    </div>
    <div class="button">
        <div class="label">
        <button class="button2"><a href="">WishList에 추가하기</a> </button>
        </div>
      </div>
      <div>
        <div class="label2">
        <button class="button3"><a href="">1:1 채팅하기</a></button></div>
        <svg
          class="regular-arrow-right"
          width="21"
          height="20"
          viewBox="0 0 21 20"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M3.625 10H17.375"
            stroke="#FA8232"
            stroke-width="1.8"
            stroke-linecap="round"
            stroke-linejoin="round"
          />
          <path
            d="M11.75 4.375L17.375 10L11.75 15.625"
            stroke="#FA8232"
            stroke-width="1.8"
            stroke-linecap="round"
            stroke-linejoin="round"
          />
        </svg>
      </div>
    </div>
  </div>
</div>

</div>



</body>
</html>