package com.icbc.controller;

import com.icbc.gui.Main;
import com.icbc.service.AccountService;
import com.icbc.service.AccountServiceImpl;

public class DepositController implements ICBCController {
	
	private double money;
	
	private Main main;
	public DepositController(Main main) {
		this.main = main;
	}

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}


	@Override
	public void proccessMessage() {
		AccountService accountService = new AccountServiceImpl();
		accountService.deposit(main.getCurrentAccount().getId(), money);
		
		main.show("menu");
	}

}
