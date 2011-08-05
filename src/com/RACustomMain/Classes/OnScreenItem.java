package com.RACustomMain.Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;



import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

import com.RACustomMain.UI.MainForm;


public class OnScreenItem extends JButton implements IScreenItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int prevX, prevY, currX, currY;
	MoveIconHandler mouseHandler;
	//FocusHandler focusHandler;
	Border origBorder;
	ScreenPanel parentPanel;
	PropertiesPanel propPanel;
	public OnScreenItem(JPanel parent, JPanel propertiesPanel)
	{
		mouseHandler = new MoveIconHandler();
		//focusHandler = new FocusHandler();
		
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		//this.addFocusListener(focusHandler);
		parentPanel = (ScreenPanel) parent;	
		this.propPanel = (PropertiesPanel)propertiesPanel;
	}
	
	public void SetLocation(int x, int y) throws OutOfBoundsException
	{
		if(x < 0)
			x = 0;
		if(x + this.getBounds().width > 129)
			x = 129-this.getBounds().width;
		if(y < 0)
			y = 0;
		if(y + this.getBounds().height > 129)
			y = 129-this.getBounds().height;
		
		this.setLocation(currX, currY);
	}
	
	public void SelectThisItem()
	{
		origBorder = this.getBorder();
		this.setBorder(Globals.SelectedItemBorder);
		
		propPanel.SetScreenCoords(this.getX(), this.getY());
	}
	public void DeselectThisItem()
	{
		if(origBorder != null)
			this.setBorder(origBorder);
	}
			
	class MoveIconHandler extends MouseInputAdapter
	{
		public void mouseReleased(MouseEvent e)
		{
			MainForm.clearScreenCoords();
		}
		public void mousePressed(MouseEvent e)
		{
			prevX = e.getX();
			prevY = e.getY();			
			parentPanel.DeselectAllItems();
			SelectThisItem();
		}
		public void mouseDragged(MouseEvent e)
		{
			Component c = e.getComponent();
			currX = c.getX() + e.getX() - prevX;
			currY = c.getY() + e.getY() - prevY;
			
			if(currX < 0)
				currX = 0;
			if(currX + c.getBounds().width > 129)
				currX = 129-c.getBounds().width;
			if(currY < 0)
				currY = 0;
			if(currY + c.getBounds().height > 129)
				currY = 129-c.getBounds().height;
			
			c.setLocation(currX, currY);
			OnScreenItem.this.propPanel.SetScreenCoords(currX, currY);
			
		}
	}
}