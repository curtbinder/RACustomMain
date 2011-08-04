package com.RACustomMain.Classes;

import java.awt.Cursor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import javax.swing.JLabel;


public class ScreenItem extends JLabel implements IScreenItem, Transferable, DragGestureListener
{
		
	private static final long serialVersionUID = 1L;
	public static DataFlavor screenItemFlavor = new DataFlavor(IScreenItem.class, "Custom Screen Item");
	protected static DataFlavor[] acceptedFlavors = {screenItemFlavor};
	
	DragSource ds = new DragSource();
	
	public ScreenItem()
	{		
		ds.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY,this);
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