package com.ezen.controller;

import com.ezen.controller.action.Action;
import com.ezen.controller.action.JoinAction;
import com.ezen.controller.action.JoinFormAction;
import com.ezen.controller.action.LoginAction;
import com.ezen.controller.action.LoginFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {return ist;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("loginForm")) ac = new LoginFormAction(); else
		if(command.equals("login")) ac = new LoginAction(); else
		if(command.equals("joinForm")) ac = new JoinFormAction(); else
		if(command.equals("join")) ac = new JoinAction();
		
		return ac;
	}
}
