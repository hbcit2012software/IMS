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

import java.sql.Connection;
import java.util.ArrayList;
import cn.edu.hbcit.pojo.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

/**
 * 测试类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-6-13下午04:57:57	新建
 */

public class TestDao {

	protected final Logger log = Logger.getLogger(TestDao.class.getName());
	
	/**
	 * 测试类
	 * @return
	 */
	public void testByJSON(){
		JSONArray finalJson = new JSONArray();
		ArrayList<Books> list = null;
		try {
			Connection conn = Base.Connect();
			Books book = new Books();
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT * FROM tb_books";
			
			list = (ArrayList<Books>)qr.query(conn, sql, new BeanListHandler(Books.class));
			
			for(Books a : list){
				JSONObject json = new JSONObject();
				json.element("PK_books", a.getPK_books());
				json.element("book_name", a.getBook_name());
				json.element("author", a.getAuthor());
				json.element("press", a.getPress());
				json.element("isbn", a.getIsbn());
				finalJson.add(json);
			}
			DbUtils.closeQuietly(conn);//关闭连接
			log.debug(finalJson.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return finalJson;
	}
}
