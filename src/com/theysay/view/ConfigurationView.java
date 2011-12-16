package com.theysay.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.theysay.model.ConfigurationModel;

/**
 * The Configuration View is the primary configuration window for the they say application
 * @author Bilal Al-Hajjar
 *
 */
public class ConfigurationView extends JFrame{

	private static final String MESSAGE_LABEL="Enter message to display";
	private static final String OK_LABEL = "Ok";
	private static final String CANCEL_LABEL = "Cancel";
	private static final int WIDTH = 250;
	private static final int HEIGHT = 100;
	private JLabel messageLabel;
	private JTextField messageField;
	private JButton okButton;
	private JButton cancelButton;
	
	//test
	/**
	 * 
	 */
	private static final long serialVersionUID = -2638296548444416776L;
	
	public ConfigurationView (){
		this(new ConfigurationModel());
	}
	
	public ConfigurationView(ConfigurationModel config){
		super(ConfigurationModel.DEFAULT_CONFIG_TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(WIDTH, HEIGHT);
		
		//instantiate the configuration view components
		this.messageLabel 	= new JLabel(MESSAGE_LABEL);
		this.messageField 	= new JTextField(config.getMessage());
		this.messageField.setMaximumSize(new Dimension(400, 30));
		this.okButton 		= new JButton(OK_LABEL);
		this.cancelButton 	= new JButton(CANCEL_LABEL);
		
		
		//instantiate the configuration pane that will contain all the configuration fields and buttons
		JPanel configurationPane = new JPanel();
		configurationPane.setLayout(new BoxLayout(configurationPane, BoxLayout.PAGE_AXIS));
		configurationPane.add(this.messageLabel);
		configurationPane.add(Box.createRigidArea(new Dimension(0,5)));
		configurationPane.add(this.messageField);
		
		//instantiate the button pane that will contain the ok and cancel buttons
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(this.okButton);
		buttonPane.add(Box.createRigidArea(new Dimension(5,0)));
		buttonPane.add(this.cancelButton);
		
		configurationPane.add(Box.createRigidArea(new Dimension(0,5)));
		configurationPane.add(buttonPane);
		
		//adds the configuration pane to the this configuration frame
		this.add(configurationPane, BorderLayout.CENTER);
	}
	/**
	 * This method returns the text from the message field text box
	 *  and returns  an empty string if no text is availalbe
	 * @return returns the string within the message field text box or returns an emptyr string if text box is empty
	 */
	public String getMessageFieldInput(){
		try{
		return this.messageField.getText();
		}catch(NullPointerException e){
			return ""; //catch
		}
		
	}
	
	public JButton getOkButton(){
		return this.okButton;
	}
	
	public JButton getCancelButton(){
		return this.cancelButton;
	}
	
	/**
	 * This method adds a listener to the message input field to listen for character input
	 * @param listener
	 */
	public void addMessageInputListener(KeyListener listener){
		messageField.addKeyListener(listener);
	}
	
	public void addOkButtonListener(ActionListener listener){
		this.okButton.addActionListener(listener);
	}
	public void addCancelButtonListener(ActionListener listener){
		this.cancelButton.addActionListener(listener);
	}

	

	
	
}
