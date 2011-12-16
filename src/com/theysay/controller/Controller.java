package com.theysay.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.theysay.model.ConfigurationModel;
import com.theysay.view.ConfigurationView;

/**
 * The Controller object handles the communication between the configuration model and the Message panel1
 * @author Bilal Al-Hajjar
 *
 */
public class Controller {

	private ConfigurationModel configModel;
	private ConfigurationView configView;
	
	
	public Controller(ConfigurationModel model, ConfigurationView configView){
		this.configModel = model;
		this.configView = configView;
		
		
		
		//add listeners
		configView.addMessageInputListener(new MessageInputListener());
		ConfigButtonsListener cbListener = new ConfigButtonsListener();
		configView.addOkButtonListener(cbListener);
		configView.addCancelButtonListener(cbListener);
		
		
	}
	class ConfigButtonsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(configView.getOkButton())){
				try{
					FileOutputStream fileOut = new FileOutputStream("theysay.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(configModel);
					out.close();
					fileOut.close();
				}catch(IOException i){
					//something happened no serializing
					i.printStackTrace();
				}
				configView.setVisible(false);
			}else if(e.getSource().equals(configView.getCancelButton())){
				configView.setVisible(false);
			}
		}
		
	}
	class MessageInputListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			//do nothing
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			configModel.setMessage(configView.getMessageFieldInput());
		
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			//do nothing
			
		}

		
		
	}
	
	
}
