package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

public class LoginAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달 받은 로그인 정보로 유효 로그인 동작에 관한 검증
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		String url = "member/loginForm.jsp"; // 로그인 실패시 이동 주소
		
		if(mdto == null) {
			request.setAttribute("message", "아이디가 없습니다.");
		}else if(mdto.getUserpwd() == null) {
			request.setAttribute("message", "회원정보 오류입니다.");
		}else if(mdto.getUserpwd().equals(userpwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
			url = "main.jsp";
		}else if(!mdto.getUserpwd().equals(userpwd)) {
			request.setAttribute("message", "비밀번호를 확인하세요.");
		}else {
			request.setAttribute("message", "기타 오류로 로그인 실패입니다.");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		
	}

}
