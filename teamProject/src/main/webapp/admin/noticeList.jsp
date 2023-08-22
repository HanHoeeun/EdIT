<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/noticeList.jsp</title>
<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/noticeList.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="top">
<!-- ============================== 탑 ==================================-->
<jsp:include page="../top.jsp"></jsp:include>
<hr>

<!-- ============================== 상단네비 ==================================-->
<div class="notice_main">
  <div class="top_nav">
    <div class="top_nav_icon">
      <svg
        class="home_icon"
        width="20"
        height="20"
        viewBox="0 0 20 20"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M11.875 16.2498V12.4998C11.875 12.334 11.8092 12.1751 11.6919 12.0579C11.5747 11.9406 11.4158 11.8748 11.25 11.8748H8.75C8.58424 11.8748 8.42527 11.9406 8.30806 12.0579C8.19085 12.1751 8.125 12.334 8.125 12.4998V16.2498C8.125 16.4156 8.05915 16.5745 7.94194 16.6917C7.82473 16.809 7.66576 16.8748 7.5 16.8748H3.75C3.58424 16.8748 3.42527 16.809 3.30806 16.6917C3.19085 16.5745 3.125 16.4156 3.125 16.2498V9.02324C3.1264 8.93674 3.14509 8.8514 3.17998 8.77224C3.21486 8.69308 3.26523 8.6217 3.32812 8.5623L9.57812 2.88261C9.69334 2.77721 9.84384 2.71875 10 2.71875C10.1562 2.71875 10.3067 2.77721 10.4219 2.88261L16.6719 8.5623C16.7348 8.6217 16.7851 8.69308 16.82 8.77224C16.8549 8.8514 16.8736 8.93674 16.875 9.02324V16.2498C16.875 16.4156 16.8092 16.5745 16.6919 16.6917C16.5747 16.809 16.4158 16.8748 16.25 16.8748H12.5C12.3342 16.8748 12.1753 16.809 12.0581 16.6917C11.9408 16.5745 11.875 16.4156 11.875 16.2498Z"
          stroke="#5F6C72"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="top_nav_home">홈</div>
      <svg
        class="regular-caret-right"
        width="12"
        height="12"
        viewBox="0 0 12 12"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M4.5 2.25L8.25 6L4.5 9.75"
          stroke="#77878F"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="top_nav_notice">공지사항</div>
      <svg
        class="regular-caret-right2"
        width="12"
        height="12"
        viewBox="0 0 12 12"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M4.5 2.25L8.25 6L4.5 9.75"
          stroke="#77878F"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>

      <div class="top_nav_notice2">일반공지</div>
    </div>
  </div>
<!-- ============================== 사이드바 ==================================-->
  <div class="side_menu">
    <div class="side_menu_list">
      <div class="side_menu_name">일반공지</div>
    </div>
    <div class="side_menu_list">
      <div class="side_menu_name">개인정보처리방침 및 이용약관</div>
    </div>
  </div>
<!-- ============================== 본문 헤딩 ==================================-->
 <div class="heading">
    <div class="heading_name">일반공지</div>
  </div>
<!-- ============================== 일반공지 목록 ==================================-->

  
<!-- ============================== 작성 버튼 ==================================-->  
     <div class="btn">
      <div class="write_btn">작성</div>
    </div>
  </div>
</div>


<!--=============================== 푸터 ===================================-->
<jsp:include page="../bottom.jsp"></jsp:include>

</body>
</html>
