<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%
		String m_id = null;
		if(session.getAttribute("m_id")!=null){
			m_id = (String)session.getAttribute("m_id");
		}
		if(m_id == null){
			response.sendRedirect("index.html");
			return;
		}
	%>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap_1.css">
	<link rel="stylesheet" href="css/custom_1.css">
	<title>JSP Ajax 실시간 회원제 채팅 서비스</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript">

		function getUnread(){
			$.ajax({
				type:'post',
				url: 'chatUnread.ch',
				data:{
					m_id : encodeURIComponent('<%=m_id%>')
				},
				success: function(result){
					if(result >= 1){
						showUnread(result);
					}else{
						showUnread('');
					}
				}
			});
		}
		function getInfiniteUnread(){
			setInterval(function(){
				getUnread();
			}, 4000);
		}
		function showUnread(result){
			$('#unread').html(result);
		}
		function chatBoxFunction(){
			var m_id = '<%=m_id%>';
			$.ajax({
				type:'post',
				url: 'chatBox.ch',
				data:{
					m_id : encodeURIComponent(m_id)
				},
				success: function(data){
					if(data == ""){
						return;
					}else{
						$('#boxTable').html('');
						var parsed = JSON.parse(data);
						var result = parsed.result;
						for(var i = 0; i < result.length; i++){
							if(result[i][0].value == m_id){				//내가 보낸 사람이면 
								result[i][0].value = result[i][1].value;	//보낸 사람 <= 받는사람
							}else{											//내가 받는 사람
								result[i][1].value = result[i][0].value;    //받는사람 <= 보낸사람  
							}												//addbox에서 내가 어떤 상황이든 박스에 표시하기 위해서
							
							addBox(result[i][0].value, result[i][1].value, result[i][2].value, result[i][3].value, result[i][4].value)
						}
					}
				}
			});
		}
		
		function addBox(ch_fromID, ch_toID, ch_content, ch_date, unread){
			  $('#boxTable').append('<tr>' +
					    '<td style="width:150px;"><h5>' + ch_toID + '</h5>' +
					    '<button type="button" class="btn btn-sm btn-default" id="chatbtn" onclick="deleteFuntion('+ ch_fromID +')";">삭제</button></td>' +
					    '<td onclick="location.href=\'chat.ch?ch_toID=' + encodeURIComponent(ch_fromID) + '\'">' +
					    '<h5>' + ch_content +
					    '<span id="unread" class="label label-info">' + unread + '</span></h5>' +
					    '<div class="pull-right">' +
					    ch_date +
					    '</div>' +
					    '</td>' +
					    '</tr>');
			  
		}
		function getInfiniteBox(){
			setInterval(function() {
				chatBoxFunction();
			}, 3000);
		}
		
		function deleteFuntion(ch_toID){
			var m_id = <%=m_id%>;
			
			$.ajax({
				type:'post',
				url:'chatDelete.ch',
				data:{
					m_id : encodeURIComponent(m_id),
					ch_toID : encodeURIComponent(ch_toID)
				},
				success: function(data){
					console.log(data);
					if(data > 0){
						window.location.reload();
					}
				}
			});
		}
		
	</script>
</head>
<body>
	<div class="container">
		<table class="table" style="margin: 0 auto;">
			<thead>
				<tr>
					<th><h4>주고받은 메시지 목록</h4></th>
				</tr>
			</thead>
			<div style="overflow-y: auto; width: 100%; max-height: 450px">
				<table class="table table-bordered table-hover" style="text-align:center; border: 1px solid #ddd; margin: 0 auto;">
					<tbody id = "boxTable">
					</tbody>
				</table>
			</div>
		</table>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			getInfiniteUnread();
			getUnread();
			chatBoxFunction();
			getInfiniteBox();
		});
	</script>
		
</body>
</html>