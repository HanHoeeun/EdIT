package com.itwillbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.CallSite;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

public class MemberController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	MemberService memberService = null;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController doGet()");
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController doPost()");
		doProcess(request, response);
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController doProcess()");
		
//		가상주소 뽑아오기
		String sPath = request.getServletPath();
		System.out.println("뽑은 가상주소 : " + sPath);
		

		
//		---------------------------------------------------------------------------------------
		
		
//		회원가입 화면	--성공	
		if (sPath.equals("/insert.me")) {
			System.out.println("뽑은 가상주소 비교 : " + sPath);
			
			dispatcher = request.getRequestDispatcher("member/join.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
//		회원가입		--보류
		if (sPath.equals("/insertPro.me")) {
			System.out.println("뽑은 가상주소 비교 : insertPro.me");

			memberService = new MemberService();
			memberService.insertMember(request);
			
			response.sendRedirect("login.me");
			
		}
		
		
//		로그인 화면		--성공
		if (sPath.equals("/login.me")) {
		System.out.println("뽑은 가상주소 비교 : login.me");
		
		
		dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
		
	}
			
		
		
//		로그인 하기		--성공
		if (sPath.equals("/loginPro.me")) {
			System.out.println("뽑은 가상주소 비교 : loginPro.me");
			
			memberService = new MemberService();
			
			MemberDTO memberDTO = memberService.userCheck(request);
			
			if (memberDTO != null) {
				// m_level 추가
				HttpSession session = request.getSession();
				session.setAttribute("m_id", memberDTO.getM_id());
				session.setAttribute("m_level", memberDTO.getM_level());
				
				response.sendRedirect("main.me");
				
			} else {
				// 아이디와 비밀번호 다르면 메세지 뜨게 수정해봤음.  "member/login.jsp" -> "member/msg.jsp" 수정
				request.setAttribute("error", "아이디와 비밀번호가 다릅니다.");
				dispatcher = request.getRequestDispatcher("member/msg.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		

//		메인
		if (sPath.equals("/main.me")) {
			System.out.println("뽑은 가상주소 비교 : main.me");
			
			dispatcher = request.getRequestDispatcher("main/main3.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
//		로그아웃		--성공
		if (sPath.equals("/logout.me")) {
			System.out.println("뽑은 가상주소 비교 : logout.me");
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("main.me");
			
		}
		
		
		
//		회원정보확인		--보류
//		if (sPath.equals("/mypage.me")) {
//			System.out.println("뽑은 가상주소 비교 : mypage.me");
//		
//			HttpSession session = request.getSession();
//			String m_id = (String)session.getAttribute("m_id");
//			
//
//			memberService = new MemberService();
//			MemberDTO memberDTO =  memberService.getMember(m_id);
//			
//			request.setAttribute("memberDTO", memberDTO);
//			
//			
//			dispatcher = request.getRequestDispatcher("member/mypage_3.jsp");
//			dispatcher.forward(request, response);
//			
//		}
		
		
		
//		회원정보수정 화면	
		if (sPath.equals("/update.me")) {
			System.out.println("뽑은 가상주소 비교 : update.me");
			
			HttpSession session = request.getSession();
			String m_id = (String)session.getAttribute("m_id");
			

			memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(m_id);
			
			request.setAttribute("memberDTO", memberDTO);
			
			
			dispatcher = request.getRequestDispatcher("member/mypage_3.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
//		회원정보 수정	--보류 (닉네임에 포린키 걸려있어서 닉네임은 변경 불가!)
		if (sPath.equals("/updatePro.me")) {
			System.out.println("뽑은 가상주소 비교 : updatePro.me");

			memberService = new MemberService();
			
//			아이디, 비밀번호 일치하는지 확인
			MemberDTO memberDTO = memberService.userCheck(request);
			
			
//			일치하면 updateMember 호출
			if (memberDTO != null) {
				
				memberService.updateMember(request);
				
//				성공하면 마이페이지 창으로 이동해서 나의 정보 확인
				response.sendRedirect("update.me?tab=tab-1");
				
			} else {
//				불일치면 경고 메시지 화면에 띄우기--------인데 걍.............
				dispatcher = request.getRequestDispatcher("member/msg.jsp");
				dispatcher.forward(request, response);
				
			}
			
		}
		
		
//		회원탈퇴화면		--보류
//		if (sPath.equals("/delete.me")) {
//			System.out.println("뽑은 가상주소 비교 : delete.me");
//			
//			dispatcher = request.getRequestDispatcher("member/delete.jsp");
//			dispatcher.forward(request, response);
//			
//		}
		
		
//		회원탈퇴하기		--보류
		if (sPath.equals("/deletePro.me")) {
			System.out.println("뽑은 가상주소 비교 : deletePro.me");
			
			memberService = new MemberService();
			
			MemberDTO memberDTO = memberService.userCheck(request);
					
			if (memberDTO != null) {
				memberService.deleteMember(request);
				
				HttpSession session = request.getSession();
				session.invalidate();
				
				
				response.sendRedirect("main.me");
				
			} else {
//				비밀번호 불일치 -> 경고 메시지다 -------------------------------수정
				dispatcher = request.getRequestDispatcher("member/msg.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		
		
		
		
		if (sPath.equals("/list.me")) {
			System.out.println("뽑은 가상주소 비교 : list.me");
			
			memberService = new MemberService();
			List<MemberDTO> memberList = memberService.getMemberList();
			
			request.setAttribute("memberList", memberList);			
			
			dispatcher = request.getRequestDispatcher("member/memberlist.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
		
		
//		회원리스트
		if (sPath.equals("listjson.me")) {
			System.out.println("뽑은 가상주소 비교 : listjson.me");
			
			memberService = new MemberService();
			
			List<MemberDTO> memberList = memberService.getMemberList();
			
			JSONArray arr = new JSONArray();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
			
			
			for (int i=0; i<memberList.size(); i++) {
				MemberDTO memberDTO = memberList.get(i);
				
				JSONObject object = new JSONObject();
				object.put("m_num", memberDTO.getM_num());
				object.put("m_id", memberDTO.getM_id());
				object.put("m_pass", memberDTO.getM_pass());
				object.put("m_name", memberDTO.getM_name());
				object.put("m_nick", memberDTO.getM_nick());
				object.put("m_email", memberDTO.getM_email());
				object.put("m_phone", memberDTO.getM_phone());
				object.put("m_date", memberDTO.getM_date());
				
				
//				배열 한칸에 저장
				arr.add(object);
				
			}
			
		}
		
	
		
//		아이디 중복체크
		if (sPath.equals("/idCheck.me")) {
			System.out.println("뽑은 가상주소 비교 : idCheck.me");
			
			
			String m_id = request.getParameter("m_id");
			System.out.println("받은 아이디 : " + m_id);
			
			memberService = new MemberService();
			memberService.getIdCheck(m_id);
			
			MemberDTO memberDTO = memberService.getIdCheck(m_id);
			
			String result = "";
			if (memberDTO != null) {
				System.out.println("아이디 중복");
				result = "중복된 아이디입니다";
			} else {
				System.out.println("아이디 사용가능!");
				result = "<span style='color: green;'>사용가능한 아이디입니다</span>";
			}
			
//			이동하지 않고 결과를 웹 화면에 출력
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(result);
			printWriter.close();
			
		}
		
		
//		닉네임 중복체크
		if (sPath.equals("/nickCheck.me")) {
			System.out.println("뽑은 가상주소 비교 : nickCheck.me");
			
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			String m_nick = request.getParameter("m_nick");
			System.out.println("받은 아이디 : " + m_nick);
			
			memberService = new MemberService();
			memberService.getNickCheck(m_nick);
			
			MemberDTO memberDTO = memberService.getNickCheck(m_nick);
			
			String result = "";
			if (memberDTO != null) {
				System.out.println("닉네임 중복");
				result = "중복된 닉네임입니다";
			} else {
				System.out.println("닉네임 사용가능!");
				result = "<span style='color: green;'>사용가능한 닉네임입니다</span>";
			}
			
//			이동하지 않고 결과를 웹 화면에 출력
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(result);
			printWriter.close();
			
		}	
		
		
		
//		이메일 중복체크
		if (sPath.equals("/emailCheck.me")) {
			System.out.println("뽑은 가상주소 비교 : emailCheck.me");
			
			
			String m_email = request.getParameter("m_email");
			System.out.println("받은 아이디 : " + m_email);
			
			memberService = new MemberService();
			memberService.getEmailCheck(m_email);
			
			MemberDTO memberDTO = memberService.getEmailCheck(m_email);
			
			String result = "";
			if (memberDTO != null) {
				System.out.println("이메일 중복");
				result = "중복된 이메일입니다";
			} else {
				System.out.println("이메일 사용가능!");
				result = "<span style='color: green;'>사용가능한 이메일입니다</span>";
			}
			
//			이동하지 않고 결과를 웹 화면에 출력
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(result);
			printWriter.close();
			
		}	
		
		
		
		
		
		
		
		
	

//		진유정 - 아이디찾기 화면
		if(sPath.equals("/findid.me")) {
		   System.out.println("뽑은 가상주소 비교 : findid.me" );
		   // member/findid_3.jsp 주소변경 없이 연결
		   dispatcher = request.getRequestDispatcher("member/findid_3.jsp");
		   dispatcher.forward(request, response);
		} // 
		
		
//		8.31 오후 12시 진유정 - 아이디찾기(수정중...) -> 되긴되는데 수정 필요..? 
		if(sPath.equals("/findidPro.me")) {
			System.out.println("뽑은 가상주소 비교 : findidPro.me"); 
			
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("m_name");
			String email = request.getParameter("m_email");
			
		    MemberService memberService = new MemberService();
			
			 // 이름과 이메일을 이용하여 아이디 찾기 작동
		    String foundid = memberService.findidmember(name, email);

		    if (foundid != null) {
		        // 아이디를 찾은 경우
		        request.setAttribute("foundid", foundid);
		        dispatcher = request.getRequestDispatcher("member/findid_result.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        // 아이디를 찾지 못한 경우
		        request.setAttribute("error", "이름과 이메일이 다릅니다.");
		        // member/findid.jsp 주소변경 없이 연결
		        dispatcher = request.getRequestDispatcher("member/msg.jsp");
		        dispatcher.forward(request, response);
		    }
		} //

		
		
		// 9.5 수정함
		// 로그인화면에서  <a href="findpw.me">비밀번호 찾기</a>를 누르면 연결되는 화면임
//		진유정 - 비밀번호찾기 화면
		// findpw.me
		if(sPath.equals("/findpw.me")) {
		   System.out.println("뽑은 가상주소 비교 : findpw.me" );
		   // member/findid_3.jsp 주소변경 없이 연결
//		   dispatcher = request.getRequestDispatcher("member/findpw_3.jsp");
		   dispatcher = request.getRequestDispatcher("member/forgotPassword.jsp");
		   dispatcher.forward(request, response);
		} //		
		// 9.5 수정
		
		
//		진 - 메일로 OTP 전송 -> 주석처리...??
		// 비밀번호찾기 수정 -> 아이디와 이메일이 일치할 경우 , 입력한 이메일로 임시 번호(OTP) 발송
//		if(sPath.equals("/findpwPro.me")) {
//			System.out.println("뽑은 가상주소 비교 : findpwPro.me"); 
//			
//			request.setCharacterEncoding("utf-8");
//			
//			String id = request.getParameter("m_id");
//			String email = request.getParameter("m_email");
//			
//		    MemberService memberService = new MemberService();
//			
//			 // 아이디와 이메일을 이용하여 비밀번호 찾기 작동
//		     // 아이디와 비밀번호가 일치하면 해당 이메일로 OTP발송
//		    String foundpw = memberService.findpwmember(id, email);
//
//		    if (foundpw != null) {
//		        // 비밀번호를 찾은 경우 
//		        request.setAttribute("foundpw", foundpw);
//		        dispatcher = request.getRequestDispatcher("member/forgotPassword.jsp");
//		        dispatcher.forward(request, response);
//		    } else {
//		        // 비밀번호를 찾지 못한 경우
//		    	// 아이디나 이메일을 잘못적었거나(DB에 있는 값과 다른경우), 아이디와 비밀번호가 맞지 않은 경우
//		        request.setAttribute("error", "비밀번호를 찾을 수 없습니다.");
//		        // member/findid.jsp 주소변경 없이 연결
//		        dispatcher = request.getRequestDispatcher("member/msg.jsp");
//		        dispatcher.forward(request, response);
//		    }
//		} //	
		
		
		// 9.5 
		// forgotPassword.me 아이디와 이메일이 일치하면 입력한 이메일로 OTP 발송
		// 아이디와 비밀번호가 다르면 에러 메세지
		
		if (sPath.equals("/forgotPassword.me")) {
			
			String m_id = request.getParameter("m_id");
			String m_email = request.getParameter("m_email");
			
	        RequestDispatcher dispatcher = null;
	        int otpvalue = 0;
	        HttpSession mySession = request.getSession();

	        if (m_email != null && !m_email.isEmpty()) {
	      
		      	memberService = new MemberService();
	        	
	        	MemberDTO memberDTO = memberService.IdAndEmailMatch(m_id, m_email);
	            if (memberDTO != null) {
	            	System.out.println("일치");
	                Random rand = new Random();
	                otpvalue = rand.nextInt(1255650);

	                // 이메일 전송 코드
	                String to = m_email;// change accordingly
					// Get the session object
					Properties props = new Properties();
					
					props.put("mail.smtp.host", "smtp.gmail.com");
					// 이메일 발송을 처리해줄 SMTP서버
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					// SMTP 서버의 인증을 사용한다는 의미
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.port", "465");
					Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							// 본인 메일 주소, 앱비밀번호(띄어쓰기 없이) 입력
							// 앱비밀번호 생성 방법 : 구글 - 계정관리 - 보안 - 2단계 인증  - 앱비밀번호 - 기타(website입력)
							return new PasswordAuthentication("Edit.ADMR@gmail.com", "lcreakptorofatyr");
						}
					});
					// 메세지 작성
					try {
						request.setCharacterEncoding("utf-8");
						
						MimeMessage message = new MimeMessage(session);
						message.setFrom(new InternetAddress(m_email));// change accordingly
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						// 메일 제목
						message.setSubject("EdIT의 OTP입니다.");
						// 메일 내용
						message.setText("귀하의 OTP는: " + otpvalue);
						// send message
						Transport.send(message);
						System.out.println("message sent successfully");
					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}


	                

	                dispatcher = request.getRequestDispatcher("member/EnterOtp.jsp");
	                request.setAttribute("message", "귀하의 이메일로 OTP가 발송되었습니다.<br>정확한 OTP를 입력해주세요.");
	                mySession.setAttribute("otp", otpvalue);
	                mySession.setAttribute("email", m_email);
	            } else {
	                // 아이디와 이메일이 일치하지 않을 때 에러 메시지 표시
	                dispatcher = request.getRequestDispatcher("member/ErrorPage.jsp");
	                request.setAttribute("errorMessage", "아이디와 이메일이 일치하지 않습니다.");
	            }
	        } else {
	            // 이메일이 입력되지 않았을 때 에러 메시지 표시
	            dispatcher = request.getRequestDispatcher("member/ErrorPage.jsp");
	            request.setAttribute("errorMessage", "이메일을 입력해주세요.");
	        }

	      
	            dispatcher.forward(request, response);
	        
	    }

	
		// 테스트 중입니다....//
		
		
		
		
		
		
		// 9월 5일
		// 이메일을 입력해서 새비밀번호받기 버튼을 누르면 -> otp가 입력된 메일로 발송 됨 -> 아이디와 이메일이 일치하면 입력한 이메일로 OTP 발송되게 수정하고싶음.
		// 아이디와 비밀번호가 다르면 
		// 메일 입력하고 새 비밀번호 받기 버튼을 눌렀을때의 액션
		// forgotPassword.me
//		if(sPath.equals("/forgotPassword.me")) {
//			
//			String email = request.getParameter("email");
//			RequestDispatcher dispatcher = null;
//			int otpvalue = 0;
//			HttpSession mySession = request.getSession();
//			
//			if(email!=null || !email.equals("")) {
//				// email 변수가 null이 아니고 빈 문자열이 아닐 때만 아래의 코드 실행
//				// sending OTP
//				Random rand = new Random();
//				// 랜덤 숫자 생성
//				otpvalue = rand.nextInt(1255650);
//
//				String to = email;// change accordingly
//				// Get the session object
//				Properties props = new Properties();
//				
//				props.put("mail.smtp.host", "smtp.gmail.com");
//				// 이메일 발송을 처리해줄 SMTP서버
//				props.put("mail.smtp.host", "smtp.gmail.com");
//				props.put("mail.smtp.socketFactory.port", "465");
//				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//				// SMTP 서버의 인증을 사용한다는 의미
//				props.put("mail.smtp.auth", "true");
//				props.put("mail.smtp.port", "465");
//				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//					protected PasswordAuthentication getPasswordAuthentication() {
//						// 본인 메일 주소, 앱비밀번호(띄어쓰기 없이) 입력
//						// 앱비밀번호 생성 방법 : 구글 - 계정관리 - 보안 - 2단계 인증  - 앱비밀번호 - 기타(website입력)
//						return new PasswordAuthentication("Edit.ADMR@gmail.com", "lcreakptorofatyr");
//					}
//				});
//				// 메세지 작성
//				try {
//					request.setCharacterEncoding("utf-8");
//					
//					MimeMessage message = new MimeMessage(session);
//					message.setFrom(new InternetAddress(email));// change accordingly
//					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//					// 메일 제목
//					message.setSubject("EdIT의 OTP입니다.");
//					// 메일 내용
//					message.setText("귀하의 OTP는: " + otpvalue);
//					// send message
//					Transport.send(message);
//					System.out.println("message sent successfully");
//				} catch (MessagingException e) {
//					throw new RuntimeException(e);
//				}
//				dispatcher = request.getRequestDispatcher("member/EnterOtp.jsp");
//				request.setAttribute("message","귀하의 이메일로 OTP가 발송되었습니다.<br>정확한 OTP를 입력해주세요.");
//				//request.setAttribute("connection", con);
//				mySession.setAttribute("otp",otpvalue); 
//				mySession.setAttribute("email",email); 
//				dispatcher.forward(request, response);
//				//request.setAttribute("status", "success");
//			}
//			
//		}
		
		
		// 9월 5일
		// ValidateOtp.me
		if(sPath.equals("/ValidateOtp.me")) {
			int value=Integer.parseInt(request.getParameter("otp"));
			HttpSession session=request.getSession();
			int otp=(int)session.getAttribute("otp");
			
			RequestDispatcher dispatcher=null;
			
			// otp 숫자가 일치할 경우 newPassword.jsp로 이동
			if (value==otp) {
		
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("status", "success");
			dispatcher=request.getRequestDispatcher("member/newPassword.jsp");
			dispatcher.forward(request, response);	
			
			// otp 숫자가 일치하지 않을 경우 메세지
			} else {
				request.setAttribute("message","OTP가 일치하지 않습니다. <br> 다시 입력해주세요.");
				
			   dispatcher=request.getRequestDispatcher("member/EnterOtp.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		// 9월 5일
		// 새비밀번호 설정
		// DB 연동
		// newPassword.me
		if(sPath.equals("/newPassword.me")) {
			String newPassword = request.getParameter("newPassword");
			String confirmPassword = request.getParameter("confirmPassword");
			

			
			if(newPassword.equals(confirmPassword)) {
				memberService = new MemberService();
				int result = memberService.newPassword(request);
				
				if (result > 0) {
					dispatcher = request.getRequestDispatcher("member/login.jsp");
				} else {
	
				request.setAttribute("error", "업데이트에 실패했습니다.");
				dispatcher=request.getRequestDispatcher("member/msg.jsp"); 
				}
			} else { 
				request.setAttribute("error", "일치하지 않습니다.");
				   dispatcher=request.getRequestDispatcher("member/msg.jsp");
				  
			}
			 dispatcher.forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// doProcess()
	
	
}	// MemberController()
