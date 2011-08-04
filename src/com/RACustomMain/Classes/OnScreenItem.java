package com.RACustomMain.Classes;

import java.awt.Component;
import java.awt.event.MouseEvent;



import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;


public class OnScreenItem extends JLabel implements IScreenItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int prevX, prevY, currX, currY;
	MoveIconHandler mouseHandler;
	public OnScreenItem()
	{
		mouseHandler = new MoveIconHandler();
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		
	}
	
	class MoveIconHandler extends MouseInputAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			prevX = e.getX();
			prevY = e.getY();			
		}
		public void mouseDragged(MouseEvent e)
		{
			Component c = e.getComponent();
			currX = c.getX() + e.getX() - prevX;
			currY = c.getY() + e.getY() - prevY;
			
			if(currX < 0)
				currX = 0;
			if(currX + c.getBounds().width > 128)
				currX = 128-c.getBounds().width;
			if(currY < 0)
				currY = 0;
			if(currY + c.getBounds().height > 128)
				currY = 128-c.getBounds().height;
			
			c.setLocation(currX, currY);
			
		}
	}	
}
