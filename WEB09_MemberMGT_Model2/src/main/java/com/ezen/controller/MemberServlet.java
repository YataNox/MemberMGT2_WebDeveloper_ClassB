package com.ezen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.action.Action;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 전달된 파라미터 command 값을 추출합니다.
		String command = request.getParameter("command");
		System.out.println(command);
		// command에 전달된 값에 따라 어떤 작업을 할지가 결정이 되어 실행합니다.
		
		// 각 command 별 실행할 작업들은 해당 실행코드가 들어있는 클래스에 있습니다.
		// 클래스 내부 중에서도 execute 메소드안에 있습니다.
		// Model2 방식은 각 기능별로 클래스가 제작되어 실행되기를 기다리고, command
		// 값에 따라 선택되어 실행되는 형식입니다.
		
		/*
		 * if(command.equals("loginForm")) ac = new LoginFormAction(); else
		 * if(command.equals("login")) ac = new LoginAction(); else
		 * if(command.equals("joinForm")) ac = new JoinFormAction(); else
		 * if(command.equals("join")) ac = new JoinAction();
		 */
		ActionFactory af = ActionFactory.getInstance();
		Action ac = af.getAction(command);
		
		if(ac != null)
			ac.execute(request, response);
		else
			System.out.println("command를 확인하세요.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
