package com.theysay.tray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.IOException;


import javax.imageio.ImageIO;


import com.theysay.model.ConfigurationModel;
import com.theysay.view.ConfigurationView;
import com.theysay.view.MessageFrame;

public class MenuTray implements MouseListener, ActionListener{
	
	
	private TrayIcon trayIcon;
	private PopupMenu popupMenu;
	private MenuItem configItem;
	private MenuItem setToFront;
	private MenuItem quitItem;
	private Image icon;
	private ConfigurationView configView;
	
	@SuppressWarnings("unused")
	private ConfigurationModel config;
	@SuppressWarnings("unused")
	private MessageFrame msgView;
	
	public MenuTray(ConfigurationView configView){
		this.configView = configView;
		
	}
	
	public MenuTray(ConfigurationView  configView, MessageFrame msgView){
		this.configView = configView;
		this.msgView = msgView;
	}
	public MenuTray(ConfigurationView configView, ConfigurationModel config){
		this.configView = configView;
		this.config = config;
	}
	
	public boolean createMenuTray(){
		try {
			icon = ImageIO.read(this.getClass().getResource("/resources/idle.png"));
		}catch(IOException e){
			System.out.println("could not load image icon");
			return false;
		}catch(Exception e){
			System.out.println("Not proper image format");
			return false;
		}
		popupMenu = new PopupMenu();
		configItem = new MenuItem("Configuration");
		configItem.addActionListener(this);
		setToFront = new MenuItem("Set To Front");
		setToFront.addActionListener(this);
		quitItem = new MenuItem("Quit");
		quitItem.addActionListener(this);
		popupMenu.add(configItem);
		popupMenu.add(setToFront);
		popupMenu.add(quitItem); 
		
		trayIcon = new TrayIcon(icon, "They Say",null);
		trayIcon.addMouseListener(this);
		trayIcon.setImageAutoSize(true);
		trayIcon.setPopupMenu(popupMenu);
		
		try{
			SystemTray systemTray = SystemTray.getSystemTray();
			systemTray.add(trayIcon);
		}catch(AWTException e){
			return false;
		}
		//configView = new ConfigurationView();
		return true;
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseExited(MouseEvent event) {}

	@Override
	public void mousePressed(MouseEvent event) {}

	@Override
	public void mouseReleased(MouseEvent event) {}

	@Override
	public void actionPerformed(ActionEvent event) {
		//TODO: move so that is saves when the user clicks ok button from the configuration menu
	if(event.getSource().equals(this.quitItem)){
			System.out.println("exitting");
		//commented out the serialization code
			/*	try{
				FileOutputStream fileOut = new FileOutputStream("theysay.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(this.config);
				out.close();
				fileOut.close();
			}catch(IOException i){
				//something happened no serializing
				i.printStackTrace();
			}*/
			System.exit(0);
		}
		else if(event.getSource().equals(this.configItem)){
			configView.setVisible(true);
			configView.setAlwaysOnTop(true);
		}else if(event.getSource().equals(this.setToFront)){
			configView.setAlwaysOnTop(true);
		}
	}

}
