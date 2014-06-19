/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-6-18	1.0		李玮		新建
*/
package cn.edu.hbcit.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import cn.edu.hbcit.pojo.Majors;
import cn.edu.hbcit.pojo.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 专业操作类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-6-18下午09:47:44	新建
 */

public class MajorDao {

	protected final Logger log = Logger.getLogger(MajorDao.class.getName());
	/**
	 * 查询所有专业信息
	 * @return
	 */
	public ArrayList selectMajors(){
		ArrayList<Majors> list = null;
		try {
			Connection conn = Base.Connect();
			Majors majors = new Majors();
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT tb_majors.PK_majors,tb_majors.major_name,tb_majors.major_code,tb_majors.years,tb_majors.FK_users_majors,tb_users.true_name FROM tb_majors INNER JOIN tb_users ON tb_majors.FK_users_majors = tb_users.PK_users";
		
			list = (ArrayList<Majors>)qr.query(conn, sql, new BeanListHandler(Majors.class));
			
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 新增专业
	 * @param major_name
	 * @param major_code
	 * @param years
	 * @param FK_users_majors
	 * @return
	 */
	public boolean addMajors(String major_name, String major_code, String years, String FK_users_majors){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "INSERT INTO tb_majors (major_name, major_code, years, FK_users_majors) values (?, ?, ?, ?)";
		
			count = qr.update(conn, sql, major_name, major_code, years, FK_users_majors);
			
			log.debug("新增专业数量：" + count);
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据id查询专业信息
	 * @param id
	 * @return
	 */
	public ArrayList selectMajorsById(int id){
		ArrayList<Majors> list = null;
		try {
			Connection conn = Base.Connect();
			Majors majors = new Majors();
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT tb_majors.PK_majors,tb_majors.major_name,tb_majors.major_code,tb_majors.years,tb_majors.FK_users_majors,tb_users.true_name FROM tb_majors INNER JOIN tb_users ON tb_majors.FK_users_majors = tb_users.PK_users WHERE tb_majors.PK_majors = ?";
		
			list = (ArrayList<Majors>)qr.query(conn, sql, new BeanListHandler(Majors.class), id);
			
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
