package com.RACustomMain.Classes;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import com.RACustomMain.UI.MainForm;

public class OnScreenItem extends JButton implements IScreenItem{

	
	private static final long serialVersionUID = 1L;
	protected int prevX, prevY, currX, currY;
	MoveIconHandler mouseHandler;	
	Border origBorder;
	ScreenPanel parentPanel;
	PropertiesPanel propPanel;	
	ControlType thisControlType;	

	public OnScreenItem(JPanel parent, JPanel propertiesPanel)
	{
		mouseHandler = new MoveIconHandler();		
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		
		parentPanel = (ScreenPanel) parent;	
		this.propPanel = (PropertiesPanel)propertiesPanel;
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {//Handles the backspace event
				if(arg0.getKeyCode() == 127)				
				{
					RemoveThisItem();
					return;
				}
				else if(arg0.getKeyCode() == 38)//Up arrow
					OnScreenItem.this.SetYCoordinate(OnScreenItem.this.currY -1);
				else if(arg0.getKeyCode()==40)//down arrow
					OnScreenItem.this.SetYCoordinate(OnScreenItem.this.currY + 1);
				else if(arg0.getKeyCode()==37)//left arrow
					OnScreenItem.this.SetXCoordinate(OnScreenItem.this.currX -1);
				else if(arg0.getKeyCode() == 39)//right arrow
					OnScreenItem.this.SetXCoordinate(OnScreenItem.this.currX +1);
				propPanel.SetScreenCoords(OnScreenItem.this.currX,OnScreenItem.this.currY);
			}
		});
	}
	
	public void setControlType(ControlType t)
	{
		thisControlType = t;
	}
	public ControlType getControlType()
	{
		return thisControlType;
	}
	
	private void RemoveThisItem()
	{
		parentPanel.remove(this);		
		parentPanel.repaint();
		propPanel.activeScreenItem = null;
		propPanel.SetScreenCoords(-1,-1);
		if(this instanceof IOutletBox)
			propPanel.ToggleOutletProperties(false);
	}
	
	public void SetXCoordinate(int x)
	{
		if(x < 0)
			x = 0;
		if(x + this.getBounds().width > 129)
			x = 129-this.getBounds().width;
		
		currX= x;
		this.setLocation(x, currY);
	}
	public void SetYCoordinate(int y)
	{		
		if(y < 0)
			y = 0;
		if(y + this.getBounds().height > 129)
			y = 129-this.getBounds().height;
		currY = y;
		this.setLocation(currX, y);
	}
	
	
	public void SelectThisItem()
	{
		origBorder = this.getBorder();
		this.setBorder(Globals.SelectedItemBorder);				
		propPanel.SetActiveItem(this);				
		propPanel.ToggleOutletProperties(this instanceof IOutletBox);
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