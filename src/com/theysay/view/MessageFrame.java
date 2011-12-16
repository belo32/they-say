package com.theysay.view;


import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JWindow;

import com.theysay.model.ComponentMover;
import com.theysay.model.ConfigurationModel;
/**
 * The MessageFrame is a custom frame with no additional icons or window features. 
 * it is the bare bone frame
 * @author Bilal Al-Hajjar
 *
 */
public class MessageFrame extends JWindow  implements Observer{

	public static final int HEIGHT = 17;
	public static final int WIDTH 	= 130;
	private MessagePanel msgPanel;
	private ConfigurationModel config;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5585644259444757459L;
	public MessageFrame(){
		super();
		
		this.msgPanel = new MessagePanel();
		getContentPane().add(msgPanel,BorderLayout.CENTER);
		//setBackground(Color.white);
		//this moves the component window using a the ComponentMover class
		@SuppressWarnings("unused")
		ComponentMover cm = new ComponentMover(this,msgPanel);
		setAlwaysOnTop(true);
		
	}
	public MessageFrame(ConfigurationModel config){
		super();
		this.config = config;
		setSize(config.getSize());
		this.msgPanel = new MessagePanel(config);
		getContentPane().add(msgPanel,BorderLayout.CENTER);
		@SuppressWarnings("unused")
		ComponentMover cm = new ComponentMover(this,msgPanel);
		setAlwaysOnTop(true);
		this.setVisible(true);
		this.setSize(this.calculateWindowSize(config.getMessage(), config.getFont()));
		
	}
	/**
	 * This method calculates the window size depending on the size of the string message and font style
	 * @param text
	 * @param font
	 * @return
	 */
	public Dimension calculateWindowSize(String text, Font font){		
		 //this is the only way I can find to get a graphics object
		
		 Graphics graphics = this.getGraphics();//app.getGraphics();
	
		 //get metrics from graphics object
		FontMetrics metrics =graphics.getFontMetrics(font);
		//get height for the type of font
		int height =metrics.getHeight();
		//get the width of the string
		int width = metrics.stringWidth(text);
		//instantiate the new frame dimensions
		Dimension size = new Dimension(width+2, height +2);
		
		return size;
	}
	
	public Observer getMessagePanelObserver(){
		return this.msgPanel;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		this.setSize(this.calculateWindowSize(config.getMessage(), config.getFont()));
	}


}
