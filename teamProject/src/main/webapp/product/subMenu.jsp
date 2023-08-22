<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subMebu.jsp</title>
<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/submenu.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel="stylesheet" type="text/css">


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

<div class="filter">
  <div class="category">
    <div class="category2">Category</div>
    <div class="radio">
      <div class="category3">
        <div class="from-elements"></div>
        <div class="computer-laptop">Computer &amp; Laptop</div>
      </div>
      <div class="category3">
        <div class="from-elements"></div>
        <div class="smart-phone">SmartPhone</div>
      </div>
      <div class="category3">
        <div class="from-elements"></div>
        <div class="tablet">Tablet</div>
      </div>
    </div>
  </div>
  <div class="line-13"></div>
  <div class="price-range">
    <div class="price-range2">Price Range</div>
    <svg
      class="price-range3"
      width="313"
      height="12"
      viewBox="0 0 313 12"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <line
        x1="1.5"
        y1="6"
        x2="311.5"
        y2="6"
        stroke="#E4E7E9"
        stroke-width="2"
        stroke-linecap="round"
      />
      <line
        x1="48.5"
        y1="6"
        x2="200.5"
        y2="5.99999"
        stroke="#FA8232"
        stroke-width="2"
      />
      <circle
        cx="49.5"
        cy="6"
        r="6"
        fill="white"
        stroke="#FA8232"
        stroke-width="2"
      />
      <circle
        cx="200.5"
        cy="6"
        r="6"
        fill="white"
        stroke="#FA8232"
        stroke-width="2"
      />
    </svg>

    <div class="input-field">
      <div class="min-price">
        <div class="">최저가</div>
      </div>
      <div class="max-price">
        <div class="">최고가</div>
      </div>
    </div>
    <div class="radio">
      <div class="category3">
        <div class="from-elements"></div>
        <div class="all-price">All Price</div>
      </div>
      <div class="category3">
        <div class="from-elements"></div>
        <div class="_0">0원</div>
      </div>
      <div class="category3">
        <div class="from-elements"></div>
        <div class="_5-10">5만원 ~ 10만원</div>
      </div>
      <div class="category3">
        <div class="from-elements"></div>
        <div class="_10-20">10만원 ~ 20만원</div>
      </div>
      <div class="category3">
        <div class="from-elements2"></div>
        <div class="_20-30">20만원 ~ 30만원</div>
      </div>
      <div class="category3">
        <div class="from-elements"></div>
        <div class="_30-50">30만원 ~ 50만원</div>
      </div>
      <div class="category3">
        <div class="from-elements"></div>
        <div class="_50-100">50만원 ~ 100만원</div>
      </div>
    </div>
  </div>
  <div class="line-15"></div>
  <div class="popular-brands">
    <div class="2">제조사</div>
    <div class="check-box">
      <div class="row">
        <div class="checkbox">
          <div class="from-elements3">
            <svg
              class="duotone-check"
              width="15"
              height="14"
              viewBox="0 0 15 14"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M12.3125 3.9375L6.1875 10.0625L3.125 7"
                stroke="white"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="apple">Apple</div>
        </div>
      </div>
      <div class="row">
        <div class="checkbox">
          <div class="from-elements4"></div>
          <div class="xiaomi">Xiaomi</div>
        </div>
      </div>
      <div class="row">
        <div class="checkbox">
          <div class="from-elements3">
            <svg
              class="duotone-check2"
              width="15"
              height="14"
              viewBox="0 0 15 14"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M12.3125 3.9375L6.1875 10.0625L3.125 7"
                stroke="white"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="hp">HP</div>
        </div>
      </div>
      <div class="row">
        <div class="checkbox">
          <div class="from-elements5"></div>
          <div class="sony">Sony</div>
        </div>
      </div>
      <div class="row">
        <div class="checkbox">
          <div class="from-elements3">
            <svg
              class="duotone-check3"
              width="15"
              height="14"
              viewBox="0 0 15 14"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M12.3125 3.9375L6.1875 10.0625L3.125 7"
                stroke="white"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="microsoft">Microsoft</div>
        </div>
      </div>
      <div class="row">
        <div class="checkbox">
          <div class="from-elements3">
            <svg
              class="duotone-check4"
              width="15"
              height="14"
              viewBox="0 0 15 14"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M12.3125 3.9375L6.1875 10.0625L3.125 7"
                stroke="white"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="lg">LG</div>
        </div>
      </div>
    </div>
    <div class="checkbox">
      <div class="from-elements4"></div>
      <div class="intel">Intel</div>
    </div>
    <div class="checkbox">
      <div class="from-elements4"></div>
      <div class="samsung">Samsung</div>
    </div>
    <div class="checkbox">
      <div class="from-elements3">
        <svg
          class="duotone-check5"
          width="15"
          height="14"
          viewBox="0 0 15 14"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M12.3125 3.9375L6.1875 10.0625L3.125 7"
            stroke="white"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
          />
        </svg>
      </div>
      <div class="panasonic">Panasonic</div>
    </div>
  </div>
  <div class="line-16"></div>
  <div class="popular-tag">
    <div class="2">인기 태그</div>
    <div class="tag">
      <div class="row">
        <div class="tag2">
          <div class="cooking">Game</div>
        </div>
        <div class="tag2">
          <div class="cooking">iPhone</div>
        </div>
        <div class="tag2">
          <div class="cooking">TV</div>
        </div>
        <div class="tag2">
          <div class="cooking">Asus Laptops</div>
        </div>
      </div>
      <div class="row">
        <div class="tag2">
          <div class="cooking">Macbook</div>
        </div>
        <div class="tag2">
          <div class="cooking">SSD</div>
        </div>
        <div class="tag3">
          <div class="cooking2">Graphics Card</div>
        </div>
      </div>
      <div class="row">
        <div class="tag2">
          <div class="cooking">Power Bank</div>
        </div>
        <div class="tag2">
          <div class="cooking">Smart TV</div>
        </div>
        <div class="tag2">
          <div class="cooking">Speaker</div>
        </div>
      </div>
      <div class="row">
        <div class="tag2">
          <div class="cooking">Tablet</div>
        </div>
        <div class="tag2">
          <div class="cooking">Microwave</div>
        </div>
        <div class="tag2">
          <div class="cooking">Samsung</div>
        </div>
      </div>
    </div>
  </div>
  <div class="banner">
    <img class="image1" src="../img/img1.png" />
    <div class="content">
      <div class="content2">
        <div class="info">
          <div class="3">안쓰는 애플워치 팝니다!!</div>
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
      <div class="button2">
        <div class="label">WishList에 추가하기</div>
      </div>
      <div class="button3">
        <div class="label2">1:1 채팅하기</div>
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