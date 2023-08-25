<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/register.jsp</title>

</head>

<body>


<div style="text-align:left; overflow-y: pause; height: 800px;" >
<h1 style="font-family: 'TheJamsil5Bold';" align="center">상 품 등 록</h1>
<hr style="border: 0; height: 3px; background-color: black;">

<form action="" method="post" enctype="multipart/form-data">

	<div style="display: flex;">
    <label for="ptype"></label>
		<select name="ptype" id="ptype" required class="form-control" style="width: 122px;">
		    <option value="">카테고리</option>
		    <option value="1">노트북</option>
		    <option value="2">테블릿</option>
		    <option value="3">휴대폰</option>
		</select>
		  
		<select name="pstatus" id="pstatus" required class="form-control" style="width: 122px;">
		    <option value="">상품상태</option>
		    <option value="">판매중</option>
		    <option value="">거래완료</option>
		</select>
	</div>


    <label for="ptitle">제목 : </label>
    <input type="text" placeholder="글 제목을 입력하세요." name="title" id="title"  class="form-control" style="width:400px" maxlength="40" required>
    <i class="fa fa-exclamation-triangle"></i>
    
    <br>      

	<label for="pprice">가격 : </label>
    <input type="text" name="pprice" placeholder="가격을 입력해주세요." id="pprice"  class="form-control" onkeyup="inputNumberFormat(this);"  style="width: 200px" required > 원
     
    <br>

    <label for="pdetail"></label>
    <textarea name="pdetail" placeholder="상품설명을 입력하세요. " id="pdetail"  class="form-control" rows="10" cols="50" style="width: 488px" maxlength="400" required></textarea>
    
    <br><br>
    
    <hr height: 3px; background-color: black;">
    
    <tr>
    <td class="file-input">
		 <i class="fa fa-exclamation-triangle"></i> 상품 이미지 2개 이상 첨부해주세요
		 <br>
	     <input type="file" name="iname1" id="iname1" required>
	     <input type="file" name="iname2" id="iname2" required>
	     <input type="file" name="iname3" id="iname3">
	     <input type="file" name="iname4" id="iname4">
	     <input type="file" name="iname5" id="iname5">
	 </td>
    </tr>

	<hr style="border: 0; height: 3px; background-color: black;">
	
  <button type="submit" class="btn1" style="display: inline-block;">상품 등록</button>
  <button type="reset" class="btn2" style="display: inline-block;">초기화</button>
 

  
</form>

</div>

</body>
</html>