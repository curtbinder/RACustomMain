package com.RACustomMain.Classes;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PropertiesPanel extends JPanel {
	
	JTextField txtXCoord;
	JTextField txtYCoord;
	OnScreenItem activeScreenItem;
	
	public PropertiesPanel()
	{
		LoadPanel();		
	}
	
	public void SetActiveItem(OnScreenItem item)
	{
		activeScreenItem = item;
	}

	public void SetScreenCoords(int x, int y)
	{
		this.txtXCoord.setText(Integer.toString(x));
		this.txtYCoord.setText(Integer.toString(y));
	}
	
	private void LoadPanel()
	{
		JLabel lblX = new JLabel("X:");
		lblX.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblX.setBounds(32, 121, 17, 14);
		this.add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblY.setBounds(32, 146, 17, 14);
		this.add(lblY);
				
		txtXCoord = new JTextField();		
		txtXCoord.setDocument(new NumericOnly().getOnlyNumber());
		txtXCoord.setBounds(46, 117, 38, 20);
		this.add(txtXCoord);
			
		
		txtYCoord = new JTextField();
		txtYCoord.setDocument(new NumericOnly().getOnlyNumber());		
		txtYCoord.setBounds(46, 142, 38, 20);
		this.add(txtYCoord);
	}
}
