package com.RACustomMain.Classes;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("rawtypes")
public class PropertiesPanel extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	JTextField txtXCoord;
	JTextField txtYCoord;
	OnScreenItem activeScreenItem;
	NumericOnly xNumericDocument;
	NumericOnly yNumericDocument;	
	JComboBox cmbRelayNumber;
	JLabel lblBoxIdentifier;
	
	public PropertiesPanel()
	{
		LoadPanel();				
	}
	
	public void SetActiveItem(OnScreenItem item)
	{
		activeScreenItem = item;
		xNumericDocument.SetOnScreenItem(activeScreenItem);
		yNumericDocument.SetOnScreenItem(activeScreenItem);
		
		if(activeScreenItem instanceof IOutletBox)
			cmbRelayNumber.setSelectedItem(Integer.toString(((IOutletBox)item).getOutletNumber()));
		SetScreenCoords(item.getX(), item.getY());
	}
	
	public void SetScreenCoords(int x, int y)
	{
		this.txtXCoord.setText(x >= 0 ? Integer.toString(x) : "");
		this.txtYCoord.setText(y >= 0 ? Integer.toString(y) : "");		
	}
	
	public void ToggleOutletProperties(Boolean on)
	{
		this.lblBoxIdentifier.setVisible(on);
		this.cmbRelayNumber.setVisible(on);
	}
		
	@SuppressWarnings("unchecked")
	private void LoadPanel()
	{
		xNumericDocument = new NumericOnly("x");
		yNumericDocument = new NumericOnly("y");
		
		JLabel lblX = new JLabel("X:");
		lblX.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblX.setBounds(36, 104, 17, 14);
		this.add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblY.setBounds(36, 129, 17, 14);
		this.add(lblY);
				
		txtXCoord = new JTextField();		
		txtXCoord.setDocument(xNumericDocument.getOnlyNumber());
		txtXCoord.setBounds(52, 100, 38, 20);	
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {//Handles teh backspace event
				if(arg0.getKeyCode() == 8 || arg0.getKeyCode() == 127)				
				{
					if(txtXCoord.getText().equals(""))
						activeScreenItem.SetXCoordinate(0);						
					else
						activeScreenItem.SetXCoordinate(Integer.parseInt(txtXCoord.getText()));
				}
				
			}
		});
		this.add(txtXCoord);
					
		txtYCoord = new JTextField();
		txtYCoord.setDocument(yNumericDocument.getOnlyNumber());		
		txtYCoord.setBounds(52, 126, 38, 20);
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {//Handles teh backspace event
				if(arg0.getKeyCode() == 8 || arg0.getKeyCode() == 127)				
				{
					if(txtYCoord.getText().equals(""))
						activeScreenItem.SetYCoordinate(0);						
					else
						activeScreenItem.SetYCoordinate(Integer.parseInt(txtYCoord.getText()));
				}
				
			}
		});
		this.add(txtYCoord);
		
		cmbRelayNumber = new JComboBox();
		cmbRelayNumber.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cmbRelayNumber.setSelectedIndex(0);
		cmbRelayNumber.setBounds(52, 152, 43, 20);
		cmbRelayNumber.setVisible(false);
		cmbRelayNumber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(activeScreenItem != null)
					((IOutletBox)activeScreenItem).setOutletNumber(Integer.parseInt(cmbRelayNumber.getSelectedItem().toString()));
			}
		});
		this.add(cmbRelayNumber);
		
		
		lblBoxIdentifier = new JLabel("Box #:");
		lblBoxIdentifier.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBoxIdentifier.setBounds(5, 155, 45, 14);
		lblBoxIdentifier.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblBoxIdentifier.setVisible(false);
		this.add(lblBoxIdentifier);
	}	
}
