package com.RACustomMain.Classes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericOnly {

	public NumericOnly() {
	
	}
		
	public PlainDocument getOnlyNumber() 
	{	
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
			}	
		};	
		return filterNumber;	
	}
}
