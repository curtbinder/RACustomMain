package com.RACustomMain.Classes;

import java.awt.Cursor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import javax.swing.JButton;

public class ScreenItem extends JButton implements IScreenItem, Transferable, DragGestureListener
{
		
	private static final long serialVersionUID = 1L;
	public static DataFlavor screenItemFlavor = new DataFlavor(IScreenItem.class, "Custom Screen Item");
	protected static DataFlavor[] acceptedFlavors = {screenItemFlavor};
	
	DragSource ds = new DragSource();
	ControlType thisControlType;
	
	public ScreenItem()
	{		
		ds.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY,this);
	}

	//IScreenItem implementation methods
	public void setControlType(ControlType t)
	{
		thisControlType = t;
	}
	public ControlType getControlType()
	{
		return thisControlType;
	}
	
	
	//Transferable implementation methods
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
	{	
		if(flavor.equals(screenItemFlavor))
			return this;
		else
			throw new UnsupportedFlavorException(flavor);
		
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {		
		return acceptedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if (flavor.equals(screenItemFlavor)) return true;
		    return false;
	}


	@Override
	public void dragGestureRecognized(DragGestureEvent evnt) {
		Cursor cursor = null;
		ScreenItem item = (ScreenItem)evnt.getComponent();
		if(evnt.getDragAction() == DnDConstants.ACTION_COPY)
		{
			cursor = DragSource.DefaultCopyDrop;
		}
		evnt.startDrag(cursor, item);
		
	}
}