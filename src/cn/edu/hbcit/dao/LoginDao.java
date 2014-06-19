/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-6-16	1.0		李玮		新建
*/
package cn.edu.hbcit.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import cn.edu.hbcit.pojo.*;
import cn.edu.hbcit.utils.CalenderUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

/**
 * 登录类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-6-16下午09:29:40	新建
 */

public class LoginDao {

	protected final Logger log = Logger.getLogger(LoginDao.class.getName());
	
	public boolean isLogin(String username, String password){
		boolean flag = false;
		
		return flag;
	}
	
	/**
	 * 根据当前学期，查询开学日期
	 * @return
	 */
	public String selectBeginDate(){
		String result = "";
		CalenderUtil cu = new CalenderUtil();
		String nowTerm = cu.getSemester();
		ArrayList<Terms> list = null;
		try {
			Connection conn = Base.Connect();
			Terms t = new Terms();
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT begin_date FROM tb_terms where term=?";
		
			list = (ArrayList<Terms>)qr.query(conn, sql, new BeanListHandler(Terms.class),nowTerm);
			for(Terms term:list){
				result=term.getBegin_date();
			}
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
