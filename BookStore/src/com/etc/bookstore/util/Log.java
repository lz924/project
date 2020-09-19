package com.etc.bookstore.util;

import org.apache.log4j.Logger;

public class Log {
    public static Logger mylog;
    static {
        mylog = Logger.getLogger(Log.class);
    }
}
