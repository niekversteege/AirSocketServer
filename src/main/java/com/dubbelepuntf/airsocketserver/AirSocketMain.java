package com.dubbelepuntf.airsocketserver;

import com.dubbelepuntf.airsocketserver.cli.Server;

public class AirSocketMain {

	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Server s = new Server();
		s.startCLI();
	}

}
