/**
 * Copyright(C) 2014
 *
 * 模块名称：     
 * 子模块名称：   
 *
 * 备注：
 *
 * 修改历史：
 * 2014-6-13	1.0		李玮		新建
 */
package cn.edu.hbcit.dao;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.*;

/**
 * 数据库连接基础类 简要说明: 数据库连接、连接池
 * 
 * @author 李玮
 * @version 1.00 2014-6-13下午04:38:38 新建
 */

public class Base {

	protected final static Logger log = Logger.getLogger(Base.class.getName());
	private static String driveClassName = "org.sqlite.JDBC";
	private static DruidDataSource dds ;
	
	public static Connection Connect(){
		Connection conn = null;
		
		//获取sqlite文件地址
		String path = getAbsoluteClassPath("");
		path = path.replace('\\', '/').replace("/classes", "");
		log.debug(path);
		String url = "jdbc:sqlite:/" + path + "/ims.db"; 
		log.debug(url);
		
		try {
			dds = new DruidDataSource();
			dds.setDriverClassName(driveClassName);
			dds.setUrl(url);
			dds.setInitialSize(5);
			dds.setMinIdle(1);
			dds.setMaxActive(20);
			dds.setFilters("stat");
			dds.setPoolPreparedStatements(false);
			dds.setValidationQuery("SELECT 'x'");
		
			conn = dds.getConnection();
		}catch (SQLException e) {
			log.debug("Connect failed! 请检查数据库文件是否配置正确！");
			e.printStackTrace();
		}	
	
		return conn;
	}
	
	/**
	 * 得到classPath绝对路径
	 * 
	 * @param classPath
	 *            相对路径
	 * @return
	 */
	public static String getAbsoluteClassPath(String classPath) {

		String path = null;
		try {
			File file = new File(Thread.currentThread().getContextClassLoader().getResource(classPath).getPath());
			path = URLDecoder.decode(file.getAbsolutePath(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
