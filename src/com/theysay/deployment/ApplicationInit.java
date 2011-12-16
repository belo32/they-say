package com.theysay.deployment;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.theysay.controller.Controller;
import com.theysay.model.ConfigurationModel;
import com.theysay.tray.MenuTray;
import com.theysay.view.ConfigurationView;
import com.theysay.view.MessageFrame;
/**
 * The ApplicationInit object initializes and setsup the they say application
 * @author Bilal Al-Hajjar
 *
 */
public class ApplicationInit implements Serializable,WindowListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1067317738311140619L;

	
	private MessageFrame msgView;
	private MenuTray menuTray;
	private ConfigurationModel config;
	@SuppressWarnings("unused")
	private Controller controller;
	private ConfigurationView configView;
	
	
	public ApplicationInit(){
		
		//deserialize the ConfigurationModel object
		
		try{
			FileInputStream fileIn = new FileInputStream("theysay.ser");
			ObjectInputStream in  = new ObjectInputStream(fileIn);
			this.config = (ConfigurationModel)in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException e){
			//file doesn't exist instantiate new ConfigurationModel
			this.config = new ConfigurationModel();
			System.out.println("file does not exist instantiating a new object");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.config == null){
			this.config = new ConfigurationModel();
		}
		this.msgView= new MessageFrame(config);
		this.configView = new ConfigurationView(config);
		this.controller = new Controller(config,configView );
		this.msgView.addWindowListener(this);
		menuTray = new MenuTray(configView,config);
		
		
		
		//add observers
		this.config.addObserver(msgView.getMessagePanelObserver());
		this.config.addObserver(msgView);
	}
	
	
	public void start(){
		//msgView.setVisible(true);
		menuTray.createMenuTray();
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//serialize the configuration data on proper exit
		System.out.println("exitting");
		try{
			FileOutputStream fileOut = new FileOutputStream("theysay.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this.config);
			out.close();
			fileOut.close();
		}catch(IOException i){
			//something happened no serializing
			i.printStackTrace();
		}
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
