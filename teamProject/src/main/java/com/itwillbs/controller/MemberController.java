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
import com.itwillbs.domain.AdminPageDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ProductPageDTO;
import com.itwillbs.domain.ReportDTO;
import com.itwillbs.domain.WishListDTO;
import com.itwillbs.service.AdminService;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.ProductService;

public class MemberController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	MemberService memberService = null;
	ProductService productService = null; 
	
	
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
				request.setAttribute("msg", "아이디와 비밀번호가 다릅니다.");
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
			
			request.setCharacterEncoding("utf-8"); 
			
			HttpSession session = request.getSession();
			String m_id = (String)session.getAttribute("m_id");
			

			memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(m_id);
			
			request.setAttribute("memberDTO", memberDTO);
			
			dispatcher = request.getRequestDispatcher("member/mypage_3.jsp");
			dispatcher.forward(request, response);	
		}
			
		
		
// 마이페이지에서 admin팀의 신고내역 가져오기 & 내 신고내역만 볼 수 있게
			if(sPath.equals("/m_adminpage.me")) {
				request.setCharacterEncoding("utf-8");
				
				HttpSession session = request.getSession();
				String m_id = (String)session.getAttribute("m_id");
		
			int pageSize =10;
			String pageNum=request.getParameter("pageNum");
			if(pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			
			AdminPageDTO pageDTO = new AdminPageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
			pageDTO.setSearch(m_id);
			// MemberService 객체생성
			memberService = new MemberService();

			List<ReportDTO> reportList = memberService.getReportList(pageDTO);
			
//			게시판 전체 글 개수 구하기
			int count = memberService.getReportCount(pageDTO);
			System.out.println(count);
//			한화면에 보여줄 페이지 개수 설정
			int pageBlock =10;
			int startPage = (currentPage-1)/pageBlock*pageBlock+1;
			int endPage = startPage + pageBlock -1;
			
			int pageCount = count%pageBlock == 0 ? count/pageBlock : count/pageBlock+1 ;
			if(endPage > pageCount ) {
				endPage = pageCount;
			}
			
			// 페이징
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);	
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			request.setAttribute("pageDTO", pageDTO);
			
			// request에 "adminList",adminList 저장
			request.setAttribute("reportList", reportList);
			// 주소변경없이 이동
			dispatcher = request.getRequestDispatcher("member/m_adminpage.jsp");
			dispatcher.forward(request, response);	
		}
		
			// 마이페이지에서 product팀의 찜리스트 가져오기 & 내 찜리스트만 볼 수 있게
			if (sPath.equals("/m_wishlist.me")) {
				System.out.println("뽑은 가상주소 비교 : /m_wishlist.me");
				
				System.out.println("뽑은 가상주소 비교222 : /wishlist.po");
				
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("m_id");
				
				MemberService memberService = new MemberService();
				MemberDTO memberDTO =  memberService.getMember(id);
				
				//ProductService productService = new ProductService();
				//ProductDTO productDTO = productService.getproduct(request);
			
				int p_pageSize=10;
				System.out.println("size"+p_pageSize);
				String p_pageNum=request.getParameter("p_pageNum");
				if(p_pageNum == null) {
					p_pageNum = "1";
				}
				int p_currentPage = Integer.parseInt(p_pageNum);
				ProductPageDTO ppageDTO = new ProductPageDTO();
				ppageDTO.setP_pageSize(p_pageSize);
				ppageDTO.setP_pageNum(p_pageNum);
				ppageDTO.setP_currentPage(p_currentPage);
				ppageDTO.setM_id(id);
				productService = new ProductService();
				List<WishListDTO> wishList=productService.getWishList(ppageDTO);
//				String orderBy = request.getParameter("ord");
//			    System.out.println("orderBy"+ orderBy);
//			    if(orderBy != null) {
//			    	if ("wishSell".equals(orderBy)) {
//				    	wishList = productService.getWishSellProducts(ppageDTO);
//				    } else if ("wishSold".equals(orderBy)) {
//				    	wishList = productService.getWishSoldProducts(ppageDTO);
//				    	
//				    } else {
//				        // 디폴트로 판매중으로 정렬
//				    	wishList = productService.getWishSellProducts(ppageDTO);
//				    }
//			    }	
			    int p_count = productService.getProductCount();
			    int p_pageBlock = 2;
			    int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
			    int p_endPage=p_startPage+p_pageBlock-1;
			    int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
				if(p_endPage > p_pageCount) {
					p_endPage = p_pageCount;
				}
				ppageDTO.setP_count(p_count);
				ppageDTO.setP_pageBlock(p_pageBlock);
				ppageDTO.setP_startPage(p_startPage);
				ppageDTO.setP_endPage(p_endPage);
				ppageDTO.setP_pageCount(p_pageCount);
				
				System.out.println("스타트페이지 =" + p_startPage +", 페이지 블럭 = "+ p_pageBlock);
				System.out.println("현재페이지 =" + p_currentPage);
				request.setAttribute("wishList", wishList);
				request.setAttribute("ppageDTO", ppageDTO);
				//request.setAttribute("orderBy", orderBy);
				//request.setAttribute("productDTO", productDTO);
				request.setAttribute("memberDTO", memberDTO);
				
				dispatcher 
			    = request.getRequestDispatcher("member/m_wishlist.jsp");
			dispatcher.forward(request, response);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
//				HttpSession session = request.getSession();
//				String id = (String)session.getAttribute("m_id");
//				
//				MemberService memberService = new MemberService();
//				MemberDTO memberDTO =  memberService.getMember(id);
//				
//				int p_pageSize=10;
//				System.out.println("size"+p_pageSize);
//				String p_pageNum=request.getParameter("p_pageNum");
//				if(p_pageNum == null) {
//					p_pageNum = "1";
//				}
//				int p_currentPage = Integer.parseInt(p_pageNum);
//				ProductPageDTO ppageDTO = new ProductPageDTO();
//				ppageDTO.setP_pageSize(p_pageSize);
//				ppageDTO.setP_pageNum(p_pageNum);
//				ppageDTO.setP_currentPage(p_currentPage);
//				ppageDTO.setM_id(id);
//				
//				List<WishListDTO> wishList=memberService.getWishList(ppageDTO);
//
//			    int p_count = memberService.getProductCount();
//			    int p_pageBlock = 2;
//			    int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
//			    int p_endPage=p_startPage+p_pageBlock-1;
//			    int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
//				if(p_endPage > p_pageCount) {
//					p_endPage = p_pageCount;
//				}
//				ppageDTO.setP_count(p_count);
//				ppageDTO.setP_pageBlock(p_pageBlock);
//				ppageDTO.setP_startPage(p_startPage);
//				ppageDTO.setP_endPage(p_endPage);
//				ppageDTO.setP_pageCount(p_pageCount);
//				
//				System.out.println("스타트페이지 =" + p_startPage +", 페이지 블럭 = "+ p_pageBlock);
//				System.out.println("현재페이지 =" + p_currentPage);
//				request.setAttribute("wishList", wishList);
//				request.setAttribute("ppageDTO", ppageDTO);
//				request.setAttribute("memberDTO", memberDTO);
//				System.out.println("wishlist출력"+wishList );
//				
//				dispatcher 
//			    = request.getRequestDispatcher("member/m_wishlist.jsp");
//			dispatcher.forward(request, response);
			}//
			
			
			
			
			
			
			
			
			
			
		
//		회원정보 수정	-- 비밀번호 빼고
		if (sPath.equals("/updatePro.me")) {
			System.out.println("뽑은 가상주소 비교 : updatePro.me");

			memberService = new MemberService();
			

			MemberDTO memberDTO = memberService.userCheck2(request);
			
			
//			일치하면 updateMember 호출
			if (memberDTO != null) {
				
				memberService.updateMember(request);
				
//				성공하면 마이페이지 창으로 이동해서 나의 정보 확인
				response.sendRedirect("update.me");
				
			} else {
//				불일치면 경고 메시지 화면에 띄우기
				request.setAttribute("msg", "경고");
				dispatcher = request.getRequestDispatcher("member/msg.jsp");
				dispatcher.forward(request, response);
				
			}
			
		}
		
		
		
//		비밀번호수정 화면	
		if (sPath.equals("/pwupdate.me")) {
			System.out.println("뽑은 가상주소 비교 : pwupdate.me");
			
			HttpSession session = request.getSession();
			String m_id = (String)session.getAttribute("m_id");
			
			
			memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(m_id);
			
			request.setAttribute("memberDTO", memberDTO);
			
			
			dispatcher = request.getRequestDispatcher("member/pwupdate.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
//		비밀번호수정...
		if (sPath.equals("/pwupdatePro.me")) {
			System.out.println("뽑은 가상주소 비교 : pwupdatePro.me");
			
			memberService = new MemberService();
			
			
			MemberDTO memberDTO = memberService.userCheck(request);
			
			
//			일치하면 updateMember 호출
			if (memberDTO != null) {
				
				memberService.updatePass(request);
				
//				성공하면 마이페이지 창으로 이동해서 나의 정보 확인
				response.sendRedirect("pwupdate.me");
				
			} else {
//				불일치면 경고 메시지 화면에 띄우기
				request.setAttribute("msg", "경고");
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


//		아이디찾기
		if(sPath.equals("/findid.me")) {
		   System.out.println("뽑은 가상주소 비교 : findid.me" );
		   // member/findid_3.jsp 주소변경 없이 연결
		   dispatcher = request.getRequestDispatcher("member/findid_3.jsp");
		   dispatcher.forward(request, response);
		} // 
		
		if(sPath.equals("/findidPro.me")) {
			System.out.println("뽑은 가상주소 비교 : findidPro.me"); 
			
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("m_name");
			String email = request.getParameter("m_email");
			
		    MemberService memberService = new MemberService();
			
			 // 이름과 이메일을 이용하여 아이디 찾기 작동
		    String foundid = memberService.findidmember(name, email);
		    
//			9.6 - 아이디 찾기 메세지 --------------------------- 수정 완
		    if (foundid != null) {
		        // 아이디를 찾은 경우
//		        request.setAttribute("foundid", foundid);
		        request.setAttribute("msg", name + "님의 아이디는 " + foundid + "입니다.");
		        dispatcher = request.getRequestDispatcher("member/msg.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        // 아이디를 찾지 못한 경우
		        request.setAttribute("msg", "이름과 이메일이 일치하지 않습니다.");
		        // member/msg.jsp로 주소변경 없이 연결
		        dispatcher = request.getRequestDispatcher("member/msg.jsp");
		        dispatcher.forward(request, response);
		    }
		} //

		
//		비밀번호찾기
		if(sPath.equals("/findpw.me")) {
		   System.out.println("뽑은 가상주소 비교 : findpw.me" );

		   dispatcher = request.getRequestDispatcher("member/forgotPassword.jsp");
		   dispatcher.forward(request, response);
		} //		
		// 인증번호 메일 발송
		// 아이디와 이메일이 일치 -> 이메일로 인증번호 발송, 아이디와 비밀번호 불일치 -> 에러 메세지
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
	            	
	            	// 메세지를 뿌려서 시간을 벌고 싶었으나 이 또 한 속도가 너무 너무 느림
//	                request.setAttribute("msg", "메일전송"); 
//	    	        dispatcher = request.getRequestDispatcher("member/msg.jsp");
//	    	        dispatcher.forward(request, response);

	                Random rand = new Random();
	                otpvalue = rand.nextInt(1255650);

	                // 이메일 전송 코드
	                String to = m_email;// change accordingly
					
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
						message.setSubject("EdIT 인증번호");
						// 메일 내용
						message.setText("귀하의 인증번호는 : " + otpvalue + "입니다.");
						// send message
						Transport.send(message);
						System.out.println("이메일 보내기 성공!!");
	
					} catch (MessagingException e) {
						throw new RuntimeException(e);
					} // catch

	                dispatcher = request.getRequestDispatcher("member/EnterOtp.jsp");
	                request.setAttribute("message", "귀하의 이메일로 인증번호가 발송되었습니다.<br>정확한 인증번호를 입력해주세요.");
	                mySession.setAttribute("otp", otpvalue);
	                mySession.setAttribute("email", m_email);
	            } else {
	                // 아이디와 이메일이 일치하지 않는 경우 메세지
	    	        request.setAttribute("msg", "아이디와 이메일이 일치하지 않습니다.");
	    	        // member/msg.jsp로 주소변경 없이 연결
	    	        dispatcher = request.getRequestDispatcher("member/msg.jsp");
	    	        dispatcher.forward(request, response);
	            } // else
	        } // if
	            dispatcher.forward(request, response);
	    } // if


		// 인증번호 입력
		if(sPath.equals("/ValidateOtp.me")) {
			int value=Integer.parseInt(request.getParameter("otp"));
			HttpSession session=request.getSession();
			int otp=(int)session.getAttribute("otp");
			
			RequestDispatcher dispatcher=null;
			
			// 인증번호가 일치할 경우 newPassword.jsp로 이동
			if (value==otp) {
		
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("status", "success");
			dispatcher=request.getRequestDispatcher("member/newPassword.jsp");
			dispatcher.forward(request, response);	
			
			// otp 숫자가 일치하지 않을 경우 메세지
			} else {
				request.setAttribute("message","인증번호가 일치하지 않습니다. <br> 다시 입력해주세요.");
				
			   dispatcher=request.getRequestDispatcher("member/EnterOtp.jsp");
				dispatcher.forward(request, response);
			}
		}
		

		// 새비밀번호 설정
		// DB 연동
		// 
		if (sPath.equals("/newPassword.me")) {
		   String newPassword = request.getParameter("newPassword");
	       String confirmPassword = request.getParameter("confirmPassword");
		   // 비밀번호 조건을 검사하는 정규 표현식(영문, 숫자, 특수문자를 포함하고 8~16자.)
		   String passwordRegex = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,16}$";

		   if (newPassword.equals(confirmPassword)) {
			  if (newPassword.matches(passwordRegex)) {
				  // 조건을 만족하는 경우 비밀번호 업데이트 시도
				  memberService = new MemberService();
				  int result = memberService.newPassword(request);

				  if (result > 0) {
				  dispatcher = request.getRequestDispatcher("member/login.jsp");
				  } else {
				  request.setAttribute("msg", "업데이트에 실패했습니다.");
				  dispatcher = request.getRequestDispatcher("member/msg.jsp");
				  }
				   } else {
				      request.setAttribute("msg", "비밀번호는 영문, 숫자, 특수문자를 포함하고 8~16자여야 합니다.");
				      dispatcher = request.getRequestDispatcher("member/msg.jsp");
				   }
				    } else {
				        request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
				        dispatcher = request.getRequestDispatcher("member/msg.jsp");
				    }

				    dispatcher.forward(request, response);
				}

		
		
		
		
		
		
	
		
		
	}	// doProcess()
	
	
}	// MemberController()
