package com.theysay.deployment;



import javax.swing.SwingUtilities;



public class Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705438752571039224L;


	public Application(){
		
	}
	public static void main(String args[]){
		//determine if graphic device supports transluceny
		//with java jdk 7 it will support translucent swing components
		SwingUtilities.invokeLater(new Runnable(){
		

			@Override
			public void run() {
				
				ApplicationInit init = new ApplicationInit();
				init.start();
				
			}
		});
		
		
	}
}
