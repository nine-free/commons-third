package com.xisong.log.test;

import org.apache.log4j.Logger;

import com.xisong.log.init.LogInit;

/**
 * 
 * @author zhangjf
 *
 */
public class LogDemo {
	private static Logger logger = Logger.getLogger(LogDemo.class);
	public static void main(String[] args) {
		
		logger.debug("........................start.........................................");
		logger.debug(".........................end..........................................");
//		LogInit.init();
		
		
	}
}
