package com.bytebeats.config.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties工具类
 * @author Ricky Fung
 * @date 2017-02-15 14:27
 */
public class PropertiesUtils {

	public static Properties load(File file) throws IOException{
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			Properties props = new Properties();
			props.load(in);
			return props;
		}finally{
			IoUtils.closeQuietly(in);
		}
	}

	public static Properties load(String filename) throws IOException{
		InputStream in = null;
		try {
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
			Properties props = new Properties();
			props.load(in);
			return props;
		}finally{
			IoUtils.closeQuietly(in);
		}
	}

}
