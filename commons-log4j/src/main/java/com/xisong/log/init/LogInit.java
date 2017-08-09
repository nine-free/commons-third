package com.xisong.log.init;


import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author zhangjf
 * 
 *
 */
public class LogInit {
	public static void init(){
		PropertyConfigurator.configure("/Users/jifuzhang/work/github/commons-third/commons-log4j/target/classes/log4j.properties");
	}
}
