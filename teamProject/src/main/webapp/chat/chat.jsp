<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%
		String m_id = null;
		if(session.getAttribute("m_id")!=null){
			m_id = (String)session.getAttribute("m_id");
		}
		String ch_toID = null;
		if(request.getParameter("ch_toID") != null){
			ch_toID = (String)request.getParameter("ch_toID");
		}
		if(m_id == null){
			response.sendRedirect("index.html");
			return;
		}
		if(ch_toID == null){
			response.sendRedirect("index.html");
			return;
		}
		if(m_id.equals(URLDecoder.decode(ch_toID, "utf-8"))){
			response.sendRedirect("index.html");
			return;
		}
	%>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap_1.css">
	<link rel="stylesheet" href="css/custom_1.css">
	<title>Edit 채팅</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript">
		function submitFunction(){
			var ch_fromID = '<%=m_id %>';
			var ch_toID = '<%=ch_toID %>';
			var ch_content = $('#ch_content').val();
			$.ajax({
				type: 'post',
				url:'chatSubmit.ch',
				data:{
					ch_fromID: encodeURIComponent(ch_fromID), 
					ch_toID: encodeURIComponent(ch_toID), 
					ch_content: encodeURIComponent(ch_content)},
				success:function(result){
					if(result == 1){
						chatListFunction(lastID)
					}
				}
			});
			$('#ch_content').val('');
		}
		var lastID = 0; // 가장 마지막 챗아이디
		function chatListFunction(type){
			var ch_fromID = '<%= m_id%>';
			var ch_toID = '<%= ch_toID%>';
			$.ajax({
				type:'post',
				url:'chatList.ch',
				data:{
					ch_fromID: encodeURIComponent(ch_fromID), 
					ch_toID: encodeURIComponent(ch_toID), 
					listType: type					
				},
				success: function(data){
					if(data == ''){
						return
					}
					console.log(data);
					var parsed = JSON.parse(data);
					var result = parsed.result;
					for(var i = 0; i<result.length; i++){
						if(result[i][0].value == ch_fromID){
							result[i][0].value = '나';
						}
						addChat(result[i][0].value, result[i][2].value, result[i][3].value);
					}
// 					가장마지막에 전달받은 id 
					lastID = Number(parsed.last);
				}
			});
		}
		function addChat(chatName, chatContent, chatTime){
			$('#chatList').append('<div class="row">' + 
					'<div class="col-lg-12">' +
					'<div class="media">' +
					'<a class="pull-left" href="#">' +
					'<img class="media-objext img-circle" style="width:30px; height:30px" src="images/user1.png" alt="">'+
					'</a>' +
					'<div class="media-body">' +
					'<h4 class="media-heading">' +
					chatName + 
					'<span class="small pull-right">' +
					chatTime + 
					'</span>' +
					'</h4>' +
					'<p>' +
					chatContent + 
					'</P>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'<hr>');
			$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
		}
// 		몇초간격으로 메시지를 가져올건지
		function getInfiniteChat(){
			setInterval(function(){
				chatListFunction(lastID);
			}, 3000);
		}
		function getInfiniteUnread(){
			setInterval(function(){
				getUnread();
			}, 4000);
		}
	</script>
</head>
<body>
	<div class="container bootstrap snippet">
		<div class="row">
			<div class="col-xs-12">
				<div class="portlet portlet-default">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4><i class="fa fa-circle text-green"></i>실시간 채팅창</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="chat" class="panel-collapse collapse in">
						<div id="chatList" class="portlet-body chat-widget" style="overflow-y:auto; width:auto; height:600px;">
						</div>
						<div class="portlet-footer">
							<div class="row" style="height:90px;">
								<div class="form-group col-xs-10">
									<textarea style="height:80px; resize:none;" id="ch_content" class="form-control" placeholder="메시지를 입력하세요" maxlength="100"></textarea>
								</div>	
								<div class="form-group col-xs-2">
									<button type="button" class="btn btn-info pull-right" id="chatbtn" onclick="submitFunction();">전송</button>
									<div class="clearfix"></div>
									<button type="button" class="btn btn-info pull-right" id="chatbtn" style="margin-top: 10px;" onclick="location.href='box.ch'">목록</button>
								</div>						
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		document.getElementById("ch_content").addEventListener("keydown", function (e) {
		    if (e.keyCode === 13 && !e.shiftKey) { // Enter 키를 눌렀고 Shift 키를 누르지 않은 경우
		        e.preventDefault(); // 엔터 키의 기본 동작(새 줄 추가)을 막음
		        submitFunction(); // 전송 함수 호출 (여기에서는 submitFunction을 호출합니다)
		    }
		});
   		$(document).ready(function(){
      			chatListFunction('0');
      			getInfiniteChat(); // 새로운 채팅을 가져오는 함수를 호출
  			 });
	</script>
		
</body>
</html>