package com.RACustomMain.Classes;

import javax.swing.JPanel;

public class OutletBoxScreenItem extends OnScreenItem implements IOutletBox {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int outletNum;
	public OutletBoxScreenItem(JPanel parentPanel, JPanel propertyPanel) 
	{		
		super(parentPanel,propertyPanel);
		setOutletNumber(1);
	}
	
	@Override
	public int getOutletNumber() {
		return outletNum;
	}

	@Override
	public void setOutletNumber(int outletNumber) {		
		outletNum = outletNumber;
	}
}
