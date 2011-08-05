package com.RACustomMain.Classes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import javax.swing.event.MouseInputAdapter;
@SuppressWarnings("unused")
public class ScreenPanel extends JPanel
{			
	
	private static final long serialVersionUID = 1L;
	private MouseHandler mAdapter;
	private PropertiesPanel propPanel;
	
	public ScreenPanel()
	{
		mAdapter = new MouseHandler();
		this.setBackground(SystemColor.inactiveCaption);
		this.addMouseMotionListener(mAdapter);		
		new ScreenDropTargetListener(this);			
	}
	
	public void DeselectAllItems()
	{
		for (Component c : this.getComponents()) {
			if(c instanceof OnScreenItem)
			   ((OnScreenItem)c).DeselectThisItem();
		}	
	}
	
	public PropertiesPanel getPropertiesPanel()
	{
		return this.propPanel;
	}
	public void setPropertiesPanel(PropertiesPanel value)
	{
		this.propPanel = value;
	}
	
	
	class MouseHandler extends MouseInputAdapter
	{
		public void mouseMoved(MouseEvent e)
		{
			ScreenPanel.this.setToolTipText(e.getX()+"," + e.getY());			
		}		
	}
	
	class ScreenDropTargetListener extends DropTargetAdapter
	{		
		private DropTarget target;
		private ScreenPanel pnl;
		
		public ScreenDropTargetListener(ScreenPanel panel)
		{
			pnl = panel;
			target = new DropTarget(pnl,DnDConstants.ACTION_COPY,this,true,null);
		}
		
		@Override
		public void drop(DropTargetDropEvent evnt) 
		{
			try 
			{

		          Transferable tr = evnt.getTransferable();		          
		          ScreenItem item  = (ScreenItem) tr.getTransferData(ScreenItem.screenItemFlavor);

		            if (evnt.isDataFlavorSupported(ScreenItem.screenItemFlavor)) 
		            {
		              evnt.acceptDrop(DnDConstants.ACTION_COPY);
		              
		              OnScreenItem itemToPlace = new OnScreenItem(pnl,ScreenPanel.this.getPropertiesPanel());
		              itemToPlace.setText(item.getText());
		              itemToPlace.setBackground(item.getBackground());
		              itemToPlace.setOpaque(item.isOpaque());
		              itemToPlace.setBorder(item.getBorder());
		              itemToPlace.setHorizontalAlignment(item.getHorizontalAlignment());
		              itemToPlace.setFont(item.getFont());
		              itemToPlace.setBounds(evnt.getLocation().x, evnt.getLocation().y, item.getWidth(), item.getHeight());
		              itemToPlace.currX = evnt.getLocation().x;
		              itemToPlace.currY = evnt.getLocation().y;
		              itemToPlace.setPreferredSize(new Dimension(item.getWidth(), item.getHeight()));
		              pnl.add(itemToPlace);
		              pnl.repaint();
		              (pnl).DeselectAllItems();
		              itemToPlace.SelectThisItem();
		              return;		              
		            }
		          evnt.rejectDrop();
		     } 
			catch (Exception e) 
			{
				e.printStackTrace();
		        evnt.rejectDrop();
		    }
		}			
	}		
}
	
