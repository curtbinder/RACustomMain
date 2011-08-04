package com.RACustomMain.Classes;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import javax.swing.JPanel;
@SuppressWarnings("unused")
public class ScreenPanel extends JPanel
{	
		
	
	private static final long serialVersionUID = 1L;

	public ScreenPanel()
	{
		this.setBackground(SystemColor.inactiveCaption);
		new ScreenDropTargetListener(this);		
	}
	
	class ScreenDropTargetListener extends DropTargetAdapter
	{		
		private DropTarget target;
		private JPanel pnl;
		
		public ScreenDropTargetListener(JPanel panel)
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
		              
		              OnScreenItem itemToPlace = new OnScreenItem();
		              itemToPlace.setText(item.getText());
		              itemToPlace.setBackground(item.getBackground());
		              itemToPlace.setOpaque(item.isOpaque());
		              itemToPlace.setBorder(item.getBorder());
		              itemToPlace.setHorizontalAlignment(item.getHorizontalAlignment());
		              itemToPlace.setFont(item.getFont());
		              itemToPlace.setBounds(evnt.getLocation().x, evnt.getLocation().y, item.getWidth(), item.getHeight());
		              itemToPlace.setPreferredSize(new Dimension(item.getWidth(), item.getHeight()));
		              pnl.add(itemToPlace);
		              pnl.repaint();
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
	
