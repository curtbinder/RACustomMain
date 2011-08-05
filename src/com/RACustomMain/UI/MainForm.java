package com.RACustomMain.UI;

import java.awt.EventQueue;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import com.RACustomMain.Classes.*;

import java.awt.event.MouseAdapter;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MainForm extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private ScreenPanel pnlScreen;
    private JButton lblT1Huge;    
    private static JLabel lblScreenCoords;
 
    JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {

		setResizable(false);
		setMinimumSize(new Dimension(520, 440));
		setPreferredSize(new Dimension(520, 440));
		setMaximumSize(new Dimension(525, 445));
		setTitle("RAGen Custom Main");
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ToolTipManager.sharedInstance().setInitialDelay(0);
		
		JPanel pnlPreBuiltItems = new JPanel();
		pnlPreBuiltItems.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlPreBuiltItems.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.controlShadow, null, null, null));
		pnlPreBuiltItems.setBounds(10, 327, 466, 98);
		contentPane.add(pnlPreBuiltItems);
		pnlPreBuiltItems.setLayout(null);
		
	
		
		lblT1Huge = new ScreenItem();
		lblT1Huge.setOpaque(true);
		lblT1Huge.setBackground(Globals.HugeControlBGColor);
		lblT1Huge.setHorizontalAlignment(SwingConstants.CENTER);
		lblT1Huge.setBorder(new LineBorder(new Color(0, 0, 0)));		
		lblT1Huge.setFont(Globals.HugeControllerFont);
		lblT1Huge.setText("T1");
		lblT1Huge.setBounds(7, 7, Globals.HugeControlWidth, Globals.HugeControlHeight);		
		lblT1Huge.setPreferredSize(new Dimension(Globals.HugeControlWidth, Globals.HugeControlHeight));
		lblT1Huge.setToolTipText("Temp1 Huge 16x16");		
		pnlPreBuiltItems.add(lblT1Huge);
		
		JButton lblT1Large = new ScreenItem();
		lblT1Large.setHorizontalAlignment(SwingConstants.CENTER);
		lblT1Large.setBounds(17, 36, Globals.LargeControlWidth, Globals.LargeControlHeight);
		lblT1Large.setOpaque(true);
		lblT1Large.setBackground(Globals.LargeControlBGColor);
		lblT1Large.setBorder(new LineBorder(new Color(0,0,0)));
		lblT1Large.setFont(Globals.LargeControllerFont);
		lblT1Large.setText("T1");
		lblT1Large.setPreferredSize(new Dimension(Globals.LargeControlWidth, Globals.LargeControlHeight));
		lblT1Large.setToolTipText("Temp1 Large 8x16");		
		pnlPreBuiltItems.add(lblT1Large);
		
		
		JButton lblT1Normal= new ScreenItem();
		lblT1Normal.setHorizontalAlignment(SwingConstants.CENTER);
		lblT1Normal.setBounds(27, 65, Globals.NormalControlWidth, Globals.NormalControlHeight);
		lblT1Normal.setOpaque(true);
		lblT1Normal.setBackground(Globals.NormalControlBGColor);
		lblT1Normal.setBorder(new LineBorder(new Color(0,0,0)));
		lblT1Normal.setFont(Globals.NormalControllerFont);
		lblT1Normal.setText("T1");
		lblT1Normal.setPreferredSize(new Dimension(Globals.NormalControlWidth, Globals.NormalControlHeight));
		lblT1Normal.setToolTipText("Temp1 Normal 8x8");
		pnlPreBuiltItems.add(lblT1Normal);
		
		
		JButton lblT2Huge = new ScreenItem();
		lblT2Huge.setOpaque(true);
		lblT2Huge.setBackground(Globals.HugeControlBGColor);
		lblT2Huge.setHorizontalAlignment(SwingConstants.CENTER);
		lblT2Huge.setBorder(new LineBorder(new Color(0, 0, 0)));		
		lblT2Huge.setFont(Globals.HugeControllerFont);
		lblT2Huge.setText("T2");
		lblT2Huge.setBounds(83, 7, Globals.HugeControlWidth, Globals.HugeControlHeight);		
		lblT2Huge.setPreferredSize(new Dimension(Globals.HugeControlWidth, Globals.HugeControlHeight));
		lblT2Huge.setToolTipText("Temp2 Huge 16x16");		
		pnlPreBuiltItems.add(lblT2Huge);
		
		JButton lblT2Large = new ScreenItem();
		lblT2Large.setHorizontalAlignment(SwingConstants.CENTER);
		lblT2Large.setBounds(93, 36, Globals.LargeControlWidth, Globals.LargeControlHeight);
		lblT2Large.setOpaque(true);
		lblT2Large.setBackground(Globals.LargeControlBGColor);
		lblT2Large.setBorder(new LineBorder(new Color(0,0,0)));
		lblT2Large.setFont(Globals.LargeControllerFont);
		lblT2Large.setText("T2");
		lblT2Large.setPreferredSize(new Dimension(Globals.LargeControlWidth, Globals.LargeControlHeight));
		lblT2Large.setToolTipText("Temp2 Large 8x16");		
		pnlPreBuiltItems.add(lblT2Large);
		
		
		JButton lblT2Normal= new ScreenItem();
		lblT2Normal.setHorizontalAlignment(SwingConstants.CENTER);
		lblT2Normal.setBounds(103, 65, Globals.NormalControlWidth, Globals.NormalControlHeight);
		lblT2Normal.setOpaque(true);
		lblT2Normal.setBackground(Globals.NormalControlBGColor);
		lblT2Normal.setBorder(new LineBorder(new Color(0,0,0)));
		lblT2Normal.setFont(Globals.NormalControllerFont);
		lblT2Normal.setText("T2");
		lblT2Normal.setPreferredSize(new Dimension(Globals.NormalControlWidth, Globals.NormalControlHeight));
		lblT2Normal.setToolTipText("Temp2 Normal 8x8");
		pnlPreBuiltItems.add(lblT2Normal);
				
	
		JButton lblT3Huge = new ScreenItem();
		lblT3Huge.setOpaque(true);
		lblT3Huge.setBackground(Globals.HugeControlBGColor);
		lblT3Huge.setHorizontalAlignment(SwingConstants.CENTER);
		lblT3Huge.setBorder(new LineBorder(new Color(0, 0, 0)));		
		lblT3Huge.setFont(Globals.HugeControllerFont);
		lblT3Huge.setText("T3");
		lblT3Huge.setBounds(159, 7, Globals.HugeControlWidth, Globals.HugeControlHeight);		
		lblT3Huge.setPreferredSize(new Dimension(Globals.HugeControlWidth, Globals.HugeControlHeight));
		lblT3Huge.setToolTipText("Temp3 Huge 16x16");		
		pnlPreBuiltItems.add(lblT3Huge);
		
		JButton lblT3Large = new ScreenItem();
		lblT3Large.setHorizontalAlignment(SwingConstants.CENTER);
		lblT3Large.setBounds(169, 36, 46, 18);
		lblT3Large.setOpaque(true);
		lblT3Large.setBackground(Globals.LargeControlBGColor);
		lblT3Large.setBorder(new LineBorder(new Color(0,0,0)));
		lblT3Large.setFont(Globals.LargeControllerFont);
		lblT3Large.setText("T3");
		lblT3Large.setPreferredSize(new Dimension(Globals.LargeControlWidth, Globals.LargeControlHeight));
		lblT3Large.setToolTipText("Temp3 Large 8x16");		
		pnlPreBuiltItems.add(lblT3Large);
		
		
		JButton lblT3Normal= new ScreenItem();
		lblT3Normal.setHorizontalAlignment(SwingConstants.CENTER);
		lblT3Normal.setBounds(179, 65, 26, 10);
		lblT3Normal.setOpaque(true);
		lblT3Normal.setBackground(Globals.NormalControlBGColor);
		lblT3Normal.setBorder(new LineBorder(new Color(0,0,0)));
		lblT3Normal.setFont(Globals.NormalControllerFont);
		lblT3Normal.setText("T3");
		lblT3Normal.setPreferredSize(new Dimension(Globals.NormalControlWidth, Globals.NormalControlHeight));
		lblT3Normal.setToolTipText("Temp3 Normal 8x8");
		pnlPreBuiltItems.add(lblT3Normal);
		
		
		
		JButton lblPhHuge = new ScreenItem();
		lblPhHuge.setOpaque(true);
		lblPhHuge.setBackground(Globals.HugeControlBGColor);
		lblPhHuge.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhHuge.setBorder(new LineBorder(new Color(0, 0, 0)));		
		lblPhHuge.setFont(Globals.HugeControllerFont);
		lblPhHuge.setText("pH");
		lblPhHuge.setBounds(235, 7, Globals.HugeControlWidth, Globals.HugeControlHeight);		
		lblPhHuge.setPreferredSize(new Dimension(Globals.HugeControlWidth, Globals.HugeControlHeight));
		lblPhHuge.setToolTipText("pH Huge 16x16");		
		pnlPreBuiltItems.add(lblPhHuge);
		
		JButton lblPhLarge = new ScreenItem();
		lblPhLarge.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhLarge.setBounds(245, 36,Globals.LargeControlWidth, Globals.LargeControlHeight);
		lblPhLarge.setOpaque(true);
		lblPhLarge.setBackground(Globals.LargeControlBGColor);
		lblPhLarge.setBorder(new LineBorder(new Color(0,0,0)));
		lblPhLarge.setFont(Globals.LargeControllerFont);
		lblPhLarge.setText("pH");
		lblPhLarge.setPreferredSize(new Dimension(Globals.LargeControlWidth, Globals.LargeControlHeight));
		lblPhLarge.setToolTipText("pH Large 8x16");		
		pnlPreBuiltItems.add(lblPhLarge);
		
		
		JButton lblPhNormal= new ScreenItem();
		lblPhNormal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhNormal.setBounds(255, 65, Globals.NormalControlWidth, Globals.NormalControlHeight);
		lblPhNormal.setOpaque(true);
		lblPhNormal.setBackground(Globals.NormalControlBGColor);
		lblPhNormal.setBorder(new LineBorder(new Color(0,0,0)));
		lblPhNormal.setFont(Globals.NormalControllerFont);
		lblPhNormal.setText("pH");
		lblPhNormal.setPreferredSize(new Dimension(Globals.NormalControlWidth, Globals.NormalControlHeight));
		lblPhNormal.setToolTipText("pH Normal 8x8");
		pnlPreBuiltItems.add(lblPhNormal);
		
		
		
		
		JPanel pnlProperties = new PropertiesPanel();
		pnlProperties.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlProperties.setBounds(348, 31, 128, 264);
		pnlProperties.setLayout(null);
		
		contentPane.add(pnlProperties);
		
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBorder(new LineBorder(new Color(255, 0, 0)));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlScreen.removeAll();
				pnlScreen.repaint();
			}
		});
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnClear.setBounds(165, 285, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblRAHeader = new JLabel("");
		lblRAHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblRAHeader.setIcon(new ImageIcon(MainForm.class.getResource("/images/RAHeader.png")));
		lblRAHeader.setBounds(10, 11, 298, 86);
		contentPane.add(lblRAHeader);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setBorder(new LineBorder(new Color(0, 255, 0)));
		btnNewButton.setBounds(66, 285, 89, 23);
		contentPane.add(btnNewButton);
		
		lblScreenCoords = new JLabel("");
		lblScreenCoords.setBounds(37, 133, 46, 14);
		contentPane.add(lblScreenCoords);
		
		JPanel pnlScreenHolder = new JPanel();
		pnlScreenHolder.setBackground(new Color(0, 123, 149));
		pnlScreenHolder.setBounds(93, 108, 137, 137);
		contentPane.add(pnlScreenHolder);
		pnlScreenHolder.setLayout(null);
		pnlScreen = new ScreenPanel();
		pnlScreen.setBounds(4, 4, 129, 129);
		pnlScreenHolder.add(pnlScreen);
		pnlScreen.setBorder(new LineBorder(new Color(0, 123, 149), 0));
		pnlScreen.setLayout(null);
		pnlScreen.setPropertiesPanel((PropertiesPanel)pnlProperties);
	}	
	

	public static void clearScreenCoords()
	{
		lblScreenCoords.setText("");
	}
}
