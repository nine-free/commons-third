package com.soft1010.commons.log4j2.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by jifuzhang on 17/8/10.
 */
public class ApplicationEntry {

    private static final Logger logger = LogManager.getLogger(ApplicationEntry.class);

    public static void main(String[] args) {
        logger.debug("debug--------");
        logger.info("info---------");
        logger.error("error--------");
    }
}
