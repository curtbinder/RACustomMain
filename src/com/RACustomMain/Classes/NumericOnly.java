package com.RACustomMain.Classes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericOnly {

	OnScreenItem itemBeingModified;
	String xory = "";
	public NumericOnly() {
	
	}
	
	public NumericOnly(String XorY)
	{
		xory = XorY;
	}
	
	public void SetOnScreenItem(OnScreenItem item)
	{
		itemBeingModified = item;
	}
		
	public PlainDocument getOnlyNumber() 
	{	
		@SuppressWarnings("serial")
		PlainDocument filterNumber = new PlainDocument() 
		{	
			@Override	
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {	
				StringBuffer buffer = new StringBuffer();	
				int s = 0;	
				char[] dataInput = str.toCharArray();	
	
				for (int i = 0; i < dataInput.length; i++) {
					boolean isOnlyDigit = Character.isDigit(dataInput[i]);
	
					
					if (isOnlyDigit == true && super.getLength()<=2) {	
						dataInput[s] = dataInput[i];	
						s++;	
					}	
				}	
				buffer.append(dataInput, 0, s);	
				super.insertString(offs, new String(buffer), a);
				if(itemBeingModified != null && xory != "")
				{
					if(xory == "x")
						itemBeingModified.SetXCoordinate(Integer.parseInt(super.getText(0, super.getLength())));
					else if (xory == "y") 
						itemBeingModified.SetYCoordinate(Integer.parseInt(super.getText(0,super.getLength())));					
				}
			}	
		};	
		return filterNumber;	
	}
}
