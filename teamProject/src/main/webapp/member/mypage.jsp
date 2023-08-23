<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage.jsp</title>

<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/mypage.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel="stylesheet" type="text/css">

</head>
<body>
<!-- 헤더 들어가는 곳  -->
<jsp:include page="../top.jsp"></jsp:include>
<!-- 헤더 들어가는 곳  -->

<div class="dashboard">
  <div class="navigation-side-bar">
    <div class="dashboard-nav-item">
      <svg
        class="duotone-stack"
        width="20"
        height="20"
        viewBox="0 0 20 20"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          opacity="0.2"
          d="M2.5 6.25L10 10.625L17.5 6.25L10 1.875L2.5 6.25Z"
          fill="white"
        />
        <path
          d="M2.5 13.75L10 18.125L17.5 13.75"
          stroke="white"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M2.5 10L10 14.375L17.5 10"
          stroke="white"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M2.5 6.25L10 10.625L17.5 6.25L10 1.875L2.5 6.25Z"
          stroke="white"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="dashboard2">마이페이지</div>
    </div>
    <div class="dashboard-nav-item2">
      <svg
        class="regular-storefront"
        width="20"
        height="20"
        viewBox="0 0 20 20"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M3.75 10.9062V16.25C3.75 16.4158 3.81585 16.5747 3.93306 16.6919C4.05027 16.8092 4.20924 16.875 4.375 16.875H15.625C15.7908 16.875 15.9497 16.8092 16.0669 16.6919C16.1842 16.5747 16.25 16.4158 16.25 16.25V10.9062"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M4.21875 3.125H15.7812C15.9168 3.12612 16.0485 3.17075 16.1568 3.25233C16.2651 3.33391 16.3443 3.44812 16.3828 3.57812L17.5 7.5H2.5L3.61719 3.57812C3.65568 3.44812 3.73492 3.33391 3.84322 3.25233C3.95152 3.17075 4.08317 3.12612 4.21875 3.125V3.125Z"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M7.5 7.5V8.75C7.5 9.41304 7.23661 10.0489 6.76777 10.5178C6.29893 10.9866 5.66304 11.25 5 11.25C4.33696 11.25 3.70107 10.9866 3.23223 10.5178C2.76339 10.0489 2.5 9.41304 2.5 8.75V7.5"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M12.5 7.5V8.75C12.5 9.41304 12.2366 10.0489 11.7678 10.5178C11.2989 10.9866 10.663 11.25 10 11.25C9.33696 11.25 8.70107 10.9866 8.23223 10.5178C7.76339 10.0489 7.5 9.41304 7.5 8.75V7.5"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M17.5 7.5V8.75C17.5 9.41304 17.2366 10.0489 16.7678 10.5178C16.2989 10.9866 15.663 11.25 15 11.25C14.337 11.25 13.7011 10.9866 13.2322 10.5178C12.7634 10.0489 12.5 9.41304 12.5 8.75V7.5"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="dashboard3">구매/판매 내역</div>
    </div>
    <div class="dashboard-nav-item2">
      <svg
        class="heart"
        width="20"
        height="20"
        viewBox="0 0 20 20"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M10 16.875C10 16.875 2.1875 12.5 2.1875 7.18751C2.1875 6.24836 2.51289 5.33821 3.1083 4.61193C3.70371 3.88564 4.53236 3.38808 5.45328 3.2039C6.37419 3.01971 7.33047 3.16029 8.15943 3.6017C8.98838 4.04311 9.63879 4.7581 10 5.62501C10.3612 4.7581 11.0116 4.04311 11.8406 3.6017C12.6695 3.16029 13.6258 3.01971 14.5467 3.2039C15.4676 3.38808 16.2963 3.88564 16.8917 4.61193C17.4871 5.33821 17.8125 6.24836 17.8125 7.18751C17.8125 12.5 10 16.875 10 16.875Z"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="dashboard3">찜</div>
    </div>
    <div class="dashboard-nav-item2">
      <svg
        class="regular-arrows-counter-clockwise"
        width="20"
        height="20"
        viewBox="0 0 20 20"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M6.23438 7.78906H2.48438V4.03906"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M14.8594 5.14087C14.2216 4.50213 13.4641 3.9954 12.6303 3.64967C11.7965 3.30393 10.9027 3.12598 10 3.12598C9.09735 3.12598 8.20355 3.30393 7.36973 3.64967C6.53591 3.9954 5.77843 4.50213 5.14063 5.14087L2.48438 7.78931"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M13.7656 12.2109H17.5156V15.9609"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M5.14062 14.8594C5.77843 15.4981 6.53591 16.0048 7.36973 16.3506C8.20355 16.6963 9.09734 16.8743 10 16.8743C10.9027 16.8743 11.7965 16.6963 12.6303 16.3506C13.4641 16.0048 14.2216 15.4981 14.8594 14.8594L17.5156 12.2109"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="dashboard3">가격 비교하기</div>
    </div>
    <div class="dashboard-nav-item2">
      <svg
        class="regular-sign-out"
        width="20"
        height="20"
        viewBox="0 0 20 20"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M13.5938 6.71875L16.875 10L13.5938 13.2812"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M8.125 10H16.875"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M8.125 16.875H3.75C3.58424 16.875 3.42527 16.8092 3.30806 16.6919C3.19085 16.5747 3.125 16.4158 3.125 16.25V3.75C3.125 3.58424 3.19085 3.42527 3.30806 3.30806C3.42527 3.19085 3.58424 3.125 3.75 3.125H8.125"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="dashboard3">로그아웃</div>
    </div>
  </div>
  <div class="setting">
    <div class="account-setting">
      <div class="heading">
        <div class="billing-address">마이페이지</div>
      </div>
      <div class="input-field">
        <div class="display-user-name">
          <div class="display-name">
            <div class="lv-3">닉네임 (Lv.3)</div>
            <div class="input-field2">
              <div class="email-address">Kevin</div>
            </div>
          </div>
        </div>
      </div>
      <div class="full-name-email">
        <div class="full-name">
          <div class="phone">
            <div class="sul">현재비밀번호</div>
            <div class="input-field2">
              <div class="email-address"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="full-name-email2">
        <div class="full-name">
          <div class="phone">
            <div class="sul">새비밀번호 설정</div>
            <div class="input-field2">
              <div class="email-address"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="display-user-name2"></div>
      <div class="display-name2">
        <div class="sul">이름</div>
        <div class="input-field2">
          <div class="email-address">Kevin</div>
        </div>
      </div>
      <div class="full-name-email3"></div>
      <div class="full-name2">
        <div class="phone">
          <div class="sul">새비밀번호 확인</div>
          <div class="input-field2"></div>
        </div>
      </div>
      <div class="phone2">
        <div class="sul">전화번호</div>
        <div class="input-field2">
          <div class="email-address">+1-202-555-0118</div>
        </div>
      </div>
      <div class="full-name-email4"></div>
      <div class="full-name3">
        <div class="email">
          <div class="sul">이메일</div>
          <div class="input-field2">
            <div class="email-address">Kevin.gilbert@gmail.com</div>
          </div>
        </div>
      </div>
      <div class="full-name-email5">
        <div class="email2"></div>
      </div>
      <div class="group-24">
        <div class="full-name-email6">
          <div class="full-name">
            <div class="phone">
              <div class="sul">주소</div>
              <div class="input-field2"></div>
            </div>
          </div>
        </div>
        <div class="full-name4">
          <div class="input-field2">
            <div class="email-address">나머지주소</div>
          </div>
        </div>
        <div class="phone3">
          <div class="input-field2">
            <div class="email-address">기본주소</div>
          </div>
        </div>
      </div>
      <div class="button">
        <div class="label">회원정보 수정</div>
      </div>
      <div class="button2">
        <div class="label">우편번호</div>
      </div>
      <div class="sul2">
        <span
          ><span class="_2-span">ㅌ</span><span class="_2-span2">회원탈퇴</span
          ><span class="_2-span3">정</span></span>
      </div>
      <div class="group-5">
        <div class="sul3">마케팅 수신동의</div>
        <div class="group-3">
          <div class="sul4">이메일</div>
          <div class="from-elements"></div>
        </div>
        <div class="group-4">
          <div class="sms">SMS</div>
          <div class="from-elements2"></div>
        </div>
      </div>
    </div>
  </div>
</div>














</body>
</html>