package com.theysay.view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.theysay.model.ConfigurationModel;
/**
 * The Message Panel contains the Message label for the window
 * @author Bilal Al-Hajjar
 *
 */
public class MessagePanel extends JPanel implements Observer{

	ConfigurationModel config;
	private JLabel msgLabel;
	//private Font font;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8690276708300802719L;

	public MessagePanel(){
		super(new BorderLayout());
		msgLabel = new JLabel(ConfigurationModel.DEFAULT_MESSAGE);
		msgLabel.setForeground(Color.BLUE);
		setBackground(Color.WHITE);
		add(msgLabel,BorderLayout.CENTER);
	
	}
	public MessagePanel(ConfigurationModel config){
		super(new BorderLayout());
		this.config = config;
		msgLabel = new JLabel(config.getMessage());
		msgLabel.setFont(config.getFont());
		msgLabel.setForeground(config.getFontColor());
		setBackground(config.getBackgroundColor());
		add(msgLabel,BorderLayout.CENTER);
	}
	@Override
	public void update(Observable observable, Object object) {
		//msgLabel.setFont(config.getFont());
		msgLabel.setText(config.getMessage());
		msgLabel.setForeground(config.getFontColor());
		setBackground(config.getBackgroundColor());
	}
	
}
