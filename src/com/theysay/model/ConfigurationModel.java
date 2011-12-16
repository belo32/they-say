package com.theysay.model;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;
import java.util.Observable;
/**
 * The Configuration Model contains the configuration for the they say application
 * @author Bilal Al-Hajjar
 *
 */
public class ConfigurationModel extends Observable implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5052115895496981905L;
	public static final String DEFAULT_MESSAGE = "They Say";
	public static final String DEFAULT_CONFIG_TITLE = "They Say Configuration";
	public static final Dimension DEFAULT_SIZE = new Dimension(1,1);
	private Color fontColor;
	private Color backgroundColor;
	private String message;

	private Font font;
	private boolean isHidden;

	/** Dimension of the window holding the message*/
	private Dimension size;

	public ConfigurationModel(){
		this.fontColor = Color.blue;
		this.backgroundColor = Color.WHITE;
		this.font = new Font("Dialog", Font.PLAIN, 12);
		this.message = DEFAULT_MESSAGE;
		this.isHidden = false;
		this.size = DEFAULT_SIZE;
	}
	public void hide(){
		isHidden= true;
		setChanged();
		notifyObservers();
	}
	public void show(){
		isHidden = false;
		setChanged();
		notifyObservers();
	}
	public boolean isHidden(){
		return isHidden;
	}
	public void setFont(String name , int style, int size ){
		this.font = new Font(name,style,size);
		setChanged();
		notifyObservers();
	}
	
	public void setFontColor(Color color){
		this.fontColor = color;
		setChanged();
		notifyObservers();
	}
	public void setBackgroundColor(Color color){
		this.backgroundColor = color;
		setChanged();
		notifyObservers();
	}
	public void setMessage(String msg){
		this.message = new String(msg);
		setChanged();
		notifyObservers();
	}

	public Font getFont(){
		return this.font;
	}
	public Color getFontColor(){
		return this.fontColor;
	}
	public Color getBackgroundColor(){
		return this.backgroundColor;
	}
	public String getMessage(){
		return this.message;
	}

	
	public String toString(){
		return this.message;
	}
	public Dimension getSize(){
		return this.size;
	}
	public void setSize(Dimension size){
		this.size = size;
		setChanged();
		notifyObservers();
	}

	
	public static void main(String[] args){
		
		ConfigurationModel model = new ConfigurationModel();
		System.out.println( "new Configuration model data" + model);
		System.out.println(" the message length is " + model.getMessage().length());

		model.setMessage("this is the new message");
		System.out.println("second message " + model);
	}
	
}
