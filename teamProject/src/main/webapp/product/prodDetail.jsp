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

<div class="ptop">
<!— 헤더 들어가는 곳  —>
<jsp:include page="../top.jsp"></jsp:include>
<!— 헤더 들어가는 곳  —>
</div>

<hr>


<div class="product-detail">
  <div class="product-preview">
    <img class="main-image" src="main-image.png" />
    <div class="images">
      <div class="photo">
        <img class="_01" src="_01.png" /><img class="_05" src="_05.png" /><img
          class="_03"
          src="_03.png"
        /><img class="_04" src="_04.png" /><img class="_02" src="_02.png" /><img
          class="_06"
          src="_06.png"
        />
      </div>
      <div class="arrow">
        <div class="arrow-button">
          <svg
            class="regular-arrow-left"
            width="25"
            height="24"
            viewBox="0 0 25 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M20.75 12H4.25"
              stroke="white"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M11 5.25L4.25 12L11 18.75"
              stroke="white"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
        </div>
        <div class="arrow-button">
          <svg
            class="regular-arrow-right"
            width="25"
            height="24"
            viewBox="0 0 25 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M4.25 12H20.75"
              stroke="white"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M14 5.25L20.75 12L14 18.75"
              stroke="white"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
        </div>
      </div>
    </div>
  </div>
  <div class="product-detail2">
    <div class="product-detail3">
      <div class="product-content">
        <div class="heading">
          <div class="stars">
            <div class="star">
              <svg
                class="regular-star"
                width="21"
                height="20"
                viewBox="0 0 21 20"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M10.8439 14.8985L14.7814 17.3985C15.2892 17.7188 15.9142 17.2422 15.7657 16.6563L14.6251 12.1719C14.5943 12.0476 14.5992 11.9171 14.6393 11.7955C14.6793 11.6738 14.753 11.566 14.8517 11.4844L18.3829 8.53908C18.8439 8.15627 18.6095 7.38283 18.0079 7.34377L13.3986 7.04689C13.2728 7.03958 13.1519 6.99578 13.0506 6.92086C12.9493 6.84594 12.872 6.74314 12.8282 6.62502L11.1095 2.29689C11.064 2.17182 10.9811 2.06377 10.8721 1.98742C10.7631 1.91107 10.6332 1.87012 10.5001 1.87012C10.367 1.87012 10.2372 1.91107 10.1281 1.98742C10.0191 2.06377 9.93624 2.17182 9.89074 2.29689L8.17199 6.62502C8.12819 6.74314 8.05092 6.84594 7.94964 6.92086C7.84836 6.99578 7.72745 7.03958 7.60168 7.04689L2.99231 7.34377C2.39074 7.38283 2.15637 8.15627 2.61731 8.53908L6.14856 11.4844C6.24726 11.566 6.32089 11.6738 6.36097 11.7955C6.40106 11.9171 6.40596 12.0476 6.37512 12.1719L5.32043 16.3281C5.14074 17.0313 5.89074 17.6016 6.49231 17.2188L10.1564 14.8985C10.2591 14.8331 10.3784 14.7984 10.5001 14.7984C10.6219 14.7984 10.7411 14.8331 10.8439 14.8985Z"
                  fill="#FA8232"
                />
              </svg>

              <svg
                class="regular-star2"
                width="21"
                height="20"
                viewBox="0 0 21 20"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M10.8439 14.8985L14.7814 17.3985C15.2892 17.7188 15.9142 17.2422 15.7657 16.6563L14.6251 12.1719C14.5943 12.0476 14.5992 11.9171 14.6393 11.7955C14.6793 11.6738 14.753 11.566 14.8517 11.4844L18.3829 8.53908C18.8439 8.15627 18.6095 7.38283 18.0079 7.34377L13.3986 7.04689C13.2728 7.03958 13.1519 6.99578 13.0506 6.92086C12.9493 6.84594 12.872 6.74314 12.8282 6.62502L11.1095 2.29689C11.064 2.17182 10.9811 2.06377 10.8721 1.98742C10.7631 1.91107 10.6332 1.87012 10.5001 1.87012C10.367 1.87012 10.2372 1.91107 10.1281 1.98742C10.0191 2.06377 9.93624 2.17182 9.89074 2.29689L8.17199 6.62502C8.12819 6.74314 8.05092 6.84594 7.94964 6.92086C7.84836 6.99578 7.72745 7.03958 7.60168 7.04689L2.99231 7.34377C2.39074 7.38283 2.15637 8.15627 2.61731 8.53908L6.14856 11.4844C6.24726 11.566 6.32089 11.6738 6.36097 11.7955C6.40106 11.9171 6.40596 12.0476 6.37512 12.1719L5.32043 16.3281C5.14074 17.0313 5.89074 17.6016 6.49231 17.2188L10.1564 14.8985C10.2591 14.8331 10.3784 14.7984 10.5001 14.7984C10.6219 14.7984 10.7411 14.8331 10.8439 14.8985Z"
                  fill="#FA8232"
                />
              </svg>

              <svg
                class="regular-star3"
                width="21"
                height="20"
                viewBox="0 0 21 20"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M10.8439 14.8985L14.7814 17.3985C15.2892 17.7188 15.9142 17.2422 15.7657 16.6563L14.6251 12.1719C14.5943 12.0476 14.5992 11.9171 14.6393 11.7955C14.6793 11.6738 14.753 11.566 14.8517 11.4844L18.3829 8.53908C18.8439 8.15627 18.6095 7.38283 18.0079 7.34377L13.3986 7.04689C13.2728 7.03958 13.1519 6.99578 13.0506 6.92086C12.9493 6.84594 12.872 6.74314 12.8282 6.62502L11.1095 2.29689C11.064 2.17182 10.9811 2.06377 10.8721 1.98742C10.7631 1.91107 10.6332 1.87012 10.5001 1.87012C10.367 1.87012 10.2372 1.91107 10.1281 1.98742C10.0191 2.06377 9.93624 2.17182 9.89074 2.29689L8.17199 6.62502C8.12819 6.74314 8.05092 6.84594 7.94964 6.92086C7.84836 6.99578 7.72745 7.03958 7.60168 7.04689L2.99231 7.34377C2.39074 7.38283 2.15637 8.15627 2.61731 8.53908L6.14856 11.4844C6.24726 11.566 6.32089 11.6738 6.36097 11.7955C6.40106 11.9171 6.40596 12.0476 6.37512 12.1719L5.32043 16.3281C5.14074 17.0313 5.89074 17.6016 6.49231 17.2188L10.1564 14.8985C10.2591 14.8331 10.3784 14.7984 10.5001 14.7984C10.6219 14.7984 10.7411 14.8331 10.8439 14.8985Z"
                  fill="#FA8232"
                />
              </svg>

              <svg
                class="regular-star4"
                width="21"
                height="20"
                viewBox="0 0 21 20"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M10.8439 14.8985L14.7814 17.3985C15.2892 17.7188 15.9142 17.2422 15.7657 16.6563L14.6251 12.1719C14.5943 12.0476 14.5992 11.9171 14.6393 11.7955C14.6793 11.6738 14.753 11.566 14.8517 11.4844L18.3829 8.53908C18.8439 8.15627 18.6095 7.38283 18.0079 7.34377L13.3986 7.04689C13.2728 7.03958 13.1519 6.99578 13.0506 6.92086C12.9493 6.84594 12.872 6.74314 12.8282 6.62502L11.1095 2.29689C11.064 2.17182 10.9811 2.06377 10.8721 1.98742C10.7631 1.91107 10.6332 1.87012 10.5001 1.87012C10.367 1.87012 10.2372 1.91107 10.1281 1.98742C10.0191 2.06377 9.93624 2.17182 9.89074 2.29689L8.17199 6.62502C8.12819 6.74314 8.05092 6.84594 7.94964 6.92086C7.84836 6.99578 7.72745 7.03958 7.60168 7.04689L2.99231 7.34377C2.39074 7.38283 2.15637 8.15627 2.61731 8.53908L6.14856 11.4844C6.24726 11.566 6.32089 11.6738 6.36097 11.7955C6.40106 11.9171 6.40596 12.0476 6.37512 12.1719L5.32043 16.3281C5.14074 17.0313 5.89074 17.6016 6.49231 17.2188L10.1564 14.8985C10.2591 14.8331 10.3784 14.7984 10.5001 14.7984C10.6219 14.7984 10.7411 14.8331 10.8439 14.8985Z"
                  fill="#FA8232"
                />
              </svg>

              <svg
                class="regular-star5"
                width="21"
                height="20"
                viewBox="0 0 21 20"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M10.8439 14.8985L14.7814 17.3985C15.2892 17.7188 15.9142 17.2422 15.7657 16.6563L14.6251 12.1719C14.5943 12.0476 14.5992 11.9171 14.6393 11.7955C14.6793 11.6738 14.753 11.566 14.8517 11.4844L18.3829 8.53908C18.8439 8.15627 18.6095 7.38283 18.0079 7.34377L13.3986 7.04689C13.2728 7.03958 13.1519 6.99578 13.0506 6.92086C12.9493 6.84594 12.872 6.74314 12.8282 6.62502L11.1095 2.29689C11.064 2.17182 10.9811 2.06377 10.8721 1.98742C10.7631 1.91107 10.6332 1.87012 10.5001 1.87012C10.367 1.87012 10.2372 1.91107 10.1281 1.98742C10.0191 2.06377 9.93624 2.17182 9.89074 2.29689L8.17199 6.62502C8.12819 6.74314 8.05092 6.84594 7.94964 6.92086C7.84836 6.99578 7.72745 7.03958 7.60168 7.04689L2.99231 7.34377C2.39074 7.38283 2.15637 8.15627 2.61731 8.53908L6.14856 11.4844C6.24726 11.566 6.32089 11.6738 6.36097 11.7955C6.40106 11.9171 6.40596 12.0476 6.37512 12.1719L5.32043 16.3281C5.14074 17.0313 5.89074 17.6016 6.49231 17.2188L10.1564 14.8985C10.2591 14.8331 10.3784 14.7984 10.5001 14.7984C10.6219 14.7984 10.7411 14.8331 10.8439 14.8985Z"
                  fill="#FA8232"
                />
              </svg>
            </div>
            <div class="_4-7-star-rating">4.7 Star Rating</div>
            <div class="_21-671-user-feedback">(21,671 User feedback)</div>
          </div>
          <div class="_2020">2020 맥북</div>
        </div>
        <div class="fun-fact">
          <div class="row">
            <div class="">제조사 : 삼성</div>
            <div class="category-laptop">Category: laptop</div>
          </div>
        </div>
      </div>
      <div class="prices">
        <div class="price">
          <div class="_80">80만원</div>
        </div>
      </div>
      <div class="devider"></div>
      <div class="form">
        <div class="row">
          <div class="size">
            <div class="size2">Size</div>
            <div class="dropdown">
              <div class="good-morning">14inch<br /></div>
              <svg
                class="regular-caret-down"
                width="17"
                height="16"
                viewBox="0 0 17 16"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M13.5 6L8.5 11L3.5 6"
                  stroke="#ADB7BC"
                  stroke-width="1.5"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="size">
            <div class="memory">Memory</div>
            <div class="dropdown">
              <div class="good-morning">16GB unified memory</div>
              <svg
                class="regular-caret-down2"
                width="17"
                height="16"
                viewBox="0 0 17 16"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M13.5 6L8.5 11L3.5 6"
                  stroke="#ADB7BC"
                  stroke-width="1.5"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
          <div class="size">
            <div class="storage">Storage</div>
            <div class="dropdown">
              <div class="good-morning">1TV SSD Storage</div>
              <svg
                class="regular-caret-down3"
                width="17"
                height="16"
                viewBox="0 0 17 16"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M13.5 6L8.5 11L3.5 6"
                  stroke="#ADB7BC"
                  stroke-width="1.5"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
        </div>
      </div>
      <div class="buttons">
        <div class="button">
          <div class="label">1:1 chat</div>
        </div>
      </div>
      <div class="content">
        <div class="add-to-wishlist">
          <svg
            class="heart"
            width="25"
            height="24"
            viewBox="0 0 25 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M12.5 20.25C12.5 20.25 3.125 15 3.125 8.62501C3.125 7.49803 3.51546 6.40585 4.22996 5.53431C4.94445 4.66277 5.93884 4.0657 7.04393 3.84468C8.14903 3.62366 9.29657 3.79235 10.2913 4.32204C11.2861 4.85174 12.0665 5.70972 12.5 6.75001C12.9335 5.70972 13.7139 4.85174 14.7087 4.32204C15.7034 3.79235 16.851 3.62366 17.9561 3.84468C19.0612 4.0657 20.0555 4.66277 20.77 5.53431C21.4845 6.40585 21.875 7.49803 21.875 8.62501C21.875 15 12.5 20.25 12.5 20.25Z"
              stroke="#475156"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>

          <div class="add-to-wishlist2">wishlist에 추가하기</div>
        </div>
        <div class="button2">
          <div class="add-to-wishlist">
            <svg
              class="duotone-arrows-clockwise"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M16.5186 9.34668H21.0186V4.84668"
                stroke="#475156"
                stroke-width="1.5"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M6.16895 6.16885C6.93431 5.40236 7.84329 4.79429 8.84387 4.37941C9.84445 3.96453 10.917 3.75098 12.0002 3.75098C13.0834 3.75098 14.1559 3.96453 15.1565 4.37941C16.1571 4.79429 17.0661 5.40236 17.8314 6.16885L21.0189 9.34698"
                stroke="#475156"
                stroke-width="1.5"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M7.48145 14.6533H2.98145V19.1533"
                stroke="#475156"
                stroke-width="1.5"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M17.8314 17.8314C17.0661 18.5979 16.1571 19.206 15.1565 19.6209C14.1559 20.0358 13.0834 20.2493 12.0002 20.2493C10.917 20.2493 9.84445 20.0358 8.84387 19.6209C7.84329 19.206 6.93431 18.5979 6.16895 17.8314L2.98145 14.6533"
                stroke="#475156"
                stroke-width="1.5"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>

            <div class="add-to-wishlist2">Add to Compare</div>
          </div>
        </div>
        <div class="share-product">
          <div class="share-product2">Share product:</div>
          <div class="social-icon">
            <svg
              class="regular-copy"
              width="25"
              height="24"
              viewBox="0 0 25 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M16.25 15.75H20.75V3.75H8.75V8.25"
                stroke="#5F6C72"
                stroke-width="1.5"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M16.25 8.25H4.25V20.25H16.25V8.25Z"
                stroke="#5F6C72"
                stroke-width="1.5"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>

            <svg
              class="facebook"
              width="17"
              height="16"
              viewBox="0 0 17 16"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g clip-path="url(#clip0_2620_6552)">
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M8.5 0C12.9183 0 16.5 3.58173 16.5 8C16.5 12.4183 12.9183 16 8.5 16C4.08173 16 0.5 12.4183 0.5 8C0.5 3.58173 4.08173 0 8.5 0Z"
                  fill="#FA8232"
                />
                <path
                  d="M9.54168 15.933V9.75237H11.2851L11.5163 7.5771H9.54168L9.54461 6.48827C9.54461 5.92091 9.59854 5.61705 10.414 5.61705H11.504V3.44141H9.76017C7.66548 3.44141 6.92832 4.4966 6.92832 6.27136V7.57726H5.62256V9.75274H6.92832V15.8453C7.43701 15.9466 7.96292 16.0001 8.50138 16.0001C8.84923 16.0001 9.19672 15.9777 9.54168 15.933Z"
                  fill="white"
                />
              </g>
              <defs>
                <clipPath id="clip0_2620_6552">
                  <rect
                    width="16"
                    height="16"
                    fill="white"
                    transform="translate(0.5)"
                  />
                </clipPath>
              </defs>
            </svg>

            <svg
              class="twitter"
              width="17"
              height="16"
              viewBox="0 0 17 16"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g clip-path="url(#clip0_2620_6555)">
                <path
                  d="M5.53184 14.5024C11.5699 14.5024 14.8718 9.49713 14.8718 5.15673C14.8718 5.01458 14.8689 4.87308 14.8625 4.73217C15.505 4.26699 16.0595 3.69103 16.5 3.03128C15.9118 3.29294 15.2789 3.46904 14.6149 3.54844C15.2926 3.14181 15.8129 2.49851 16.0584 1.73169C15.414 2.11419 14.7091 2.38382 13.9739 2.52898C13.3749 1.89052 12.5221 1.49121 11.5778 1.49121C9.76494 1.49121 8.29489 2.96219 8.29489 4.7754C8.29489 5.03319 8.32374 5.28385 8.38006 5.52436C5.65177 5.38699 3.23252 4.07995 1.61343 2.09252C1.32182 2.59379 1.16843 3.16349 1.16894 3.74345C1.16894 4.88304 1.74846 5.88903 2.62976 6.47759C2.10846 6.46166 1.5986 6.32077 1.14306 6.06676C1.14257 6.08055 1.14257 6.09399 1.14257 6.10872C1.14257 7.69944 2.27408 9.02759 3.77613 9.32854C3.49402 9.40542 3.20292 9.44428 2.91054 9.44411C2.69938 9.44411 2.49359 9.42333 2.29359 9.38491C2.71151 10.69 3.92335 11.6397 5.36013 11.6663C4.23659 12.5474 2.82127 13.0723 1.28302 13.0723C1.02135 13.0725 0.759888 13.0573 0.5 13.0267C1.95281 13.9585 3.67789 14.5022 5.532 14.5022"
                  fill="#5F6C72"
                />
              </g>
              <defs>
                <clipPath id="clip0_2620_6555">
                  <rect
                    width="16"
                    height="16"
                    fill="white"
                    transform="translate(0.5)"
                  />
                </clipPath>
              </defs>
            </svg>

            <svg
              class="pinterest"
              width="17"
              height="16"
              viewBox="0 0 17 16"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g clip-path="url(#clip0_2620_6557)">
                <path
                  d="M7.52406 0.0530204C4.8652 0.349837 2.21572 2.50098 2.10636 5.57382C2.03762 7.45001 2.57033 8.85755 4.35592 9.25278C5.13077 7.88586 4.10597 7.58436 3.94663 6.59549C3.29207 2.54316 8.62072 -0.220364 11.4092 2.60877C13.3386 4.56776 12.0685 10.5947 8.95659 9.96827C5.97592 9.36995 10.4157 4.57245 8.03646 3.63045C6.10246 2.86497 5.07453 5.97218 5.99154 7.51563C5.45415 10.1698 4.29656 12.6709 4.76522 15.9999C6.28524 14.897 6.79764 12.7849 7.21787 10.5822C7.98178 11.0462 8.38951 11.5289 9.36432 11.6039C12.9589 11.882 14.9664 8.01553 14.4758 4.44904C14.04 1.28715 10.8843 -0.321906 7.52406 0.0530204Z"
                  fill="#5F6C72"
                />
              </g>
              <defs>
                <clipPath id="clip0_2620_6557">
                  <rect
                    width="16"
                    height="16"
                    fill="white"
                    transform="translate(0.5)"
                  />
                </clipPath>
              </defs>
            </svg>
          </div>
        </div>
      </div>
    </div>
    <div class="form2"></div>
  </div>
</div>


<!-- 푸터 들어가는 곳! -->
<jsp:include page="../bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳! -->

</body>
</html>