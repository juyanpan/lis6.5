package com.icbc.controller;

import javax.swing.JOptionPane;

import com.icbc.domain.Account;
import com.icbc.exception.LoginException;
import com.icbc.gui.LoginPanel;
import com.icbc.gui.Main;
import com.icbc.service.AccountService;
import com.icbc.service.AccountServiceImpl;

public class LoginController implements ICBCController{
	
	private long id;
	private String password;
	
	private Main main;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public LoginController(Main main) {
		this.main = main;
	}

	@Override
	public void proccessMessage() {
		AccountService accountService = new AccountServiceImpl();
		try {
			Account account = accountService.login(id, password);
			main.setCurrentAccount(account);
			//
			main.show("menu");
		} catch (LoginException e) {
//			main.show("login");
			JOptionPane.showMessageDialog(null, "´íÎó´úÂë:"+e.getCode(), "alert", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
