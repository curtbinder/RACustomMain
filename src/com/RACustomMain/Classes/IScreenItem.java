package com.RACustomMain.Classes;


public interface IScreenItem
{

	enum ControlType
	{
		Monitor,
		MultiMonitor,
		Outlet,
		DateTime,
		PreBuiltItem
		
	}
	
	void setControlType(ControlType t);
	ControlType getControlType();

}
