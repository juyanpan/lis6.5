package com.icbc.controller;

import com.icbc.gui.Main;

public class DepositUIController implements ICBCController {
	
	
	private Main main;
	public DepositUIController(Main main) {
		this.main = main;
	}

	@Override
	public void proccessMessage() {
		main.show("deposit");
	}

}
