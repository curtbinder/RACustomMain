package com.RACustomMain.Classes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.RACustomMain.UI.MainForm;


public class Globals {
	
	
	public static final int HugeControlWidth = 66;
	public static final int HugeControlHeight = 18;
	public static final Color HugeControlBGColor = Color.WHITE;
	public static final Font HugeControllerFont = new Font("Courier New", Font.BOLD, 12);
	
	public static final int LargeControlWidth = 46;
	public static final int LargeControlHeight = 18;
	public static final Color LargeControlBGColor = Color.WHITE;
	public static final Font LargeControllerFont = new Font("Courier New", Font.BOLD, 12);
	
	public static final int NormalControlWidth = 26;
	public static final int NormalControlHeight = 10;
	public static final Color NormalControlBGColor = Color.WHITE;
	public static final Font NormalControllerFont = new Font("Courier New", Font.BOLD, 10);
	
	public static final int DateControlWidth = 112;
	public static final int DateControlHeight = 12;
	public static final Color DateControlBGColor = Color.WHITE;
	public static final Font DateControlFont = new Font("Courrier New", Font.BOLD, 11);
	
	public static final int MonitorControlWidth = 112;
	public static final int MonitorControlHeight = 40;
	public static final Color MonitorControlBGColor = Color.WHITE;
	public static final ImageIcon MonitorControlBGIcon = new ImageIcon(MainForm.class.getResource("/images/Monitors.png"));
	public static final Font MonitorControlFont = new Font("Courrier New", Font.PLAIN, 9);
	
	public static final int OutletControlWidth = 106;
	public static final int OutletControlHeight = 14;
	public static final Color OutletControlBGColor = Color.WHITE;
	public static final ImageIcon OutletControlIcon = new ImageIcon(MainForm.class.getResource("/images/Outlet.png"));
	public static final Font OutletControlFont = new Font("Courrier New",Font.PLAIN,9);
	
	public static final Border SelectedItemBorder = new LineBorder(Color.MAGENTA,1);
}
