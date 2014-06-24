/**
 * 
 */
package cn.edu.hbcit.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import cn.edu.hbcit.pojo.Course;
import cn.edu.hbcit.pojo.Majors;
import cn.edu.hbcit.servlet.AddMajors;
import cn.edu.hbcit.utils.FileOperate;

/**
 * @author 武佳男
 *
 * 2014-6-21
 */
public class CourseDao {
	protected final Logger log = Logger.getLogger(CourseDao.class.getName());
	/**
	 * 查询用户当历年课程信息
	 * @param username
	 * @return
	 */
	public ArrayList selectMajorCourseTermsByusername(String username){
		ArrayList<Course> list = null;
		try {
			Connection conn = Base.Connect();
			Course course = new Course();
			QueryRunner qr = new QueryRunner();
			String sql = "select * from tb_course inner join tb_terms on FK_terms_course=PK_term inner join tb_majors on PK_majors=FK_majors_course where FK_users_course=?";
		
			list = (ArrayList<Course>)qr.query(conn, sql, new BeanListHandler(Course.class), username);
			
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询用户当前学期的课程名称;
	 * @param username
	 * @return
	 */
	public ArrayList selectCourseByusername(String username,String term){
		ArrayList<Course> list = null;
		try {
			Connection conn = Base.Connect();
			Course course = new Course();
			QueryRunner qr = new QueryRunner();
			String sql = "select * from tb_course inner join tb_terms on FK_terms_course=PK_term inner join tb_majors on PK_majors=FK_majors_course where FK_users_course= ? and term= ? ";
		
			list = (ArrayList<Course>)qr.query(conn, sql, new BeanListHandler(Course.class), username,term);
			
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 上传期初PPT
	 * @param course_id
	 * @param course_ppt
	 * @return
	 */
	public boolean uploadBeginppt(int course_id,String course_ppt ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET begin_term_ppt=? WHERE PK_course=? ";
		
			count = qr.update(conn, sql, course_ppt,course_id);
			
			log.debug("上传PPT：" + count);
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
	 * 删除期初PPT
	 * @param course_id
	 * @return
	 */
	public boolean deleteBeginppt(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET begin_term_ppt=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除PPT：" + count);
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
	 * 上传期初教案
	 * @param course_id
	 * @param begin_term_plan
	 * @return
	 */
	public boolean uploadBeginPlan(int course_id,String begin_term_plan ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET begin_term_plan=? WHERE PK_course=? ";
		
			count = qr.update(conn, sql, begin_term_plan,course_id);
			
			log.debug("上传教案：" + count);
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
	 * 删除期初教案
	 * @param course_id
	 * @return
	 */
	public boolean deleteBeginPlan(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET begin_term_plan=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除教案：" + count);
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
	 * 上传期初教案首页
	 * @param course_id
	 * @param begin_term_plan_index
	 * @return
	 */
	public boolean uploadBeginPlanIndex(int course_id,String begin_term_plan_index ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET begin_term_plan_index=? WHERE PK_course=? ";
		
			count = qr.update(conn, sql, begin_term_plan_index,course_id);
			
			log.debug("上传教案首页：" + count);
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
	 * 删除教案首页
	 * @param course_id
	 * @return
	 */
	public boolean deleteBeginPlanIndex(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET begin_term_plan_index=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除教案首页：" + count);
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
	 * 上传授课计划
	 * @param course_id
	 * @param teach_plan
	 * @return
	 */
	public boolean uploadTeachPlan(int course_id,String teach_plan ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET teach_plan=? WHERE PK_course=? ";
		
			count = qr.update(conn, sql, teach_plan,course_id);
			
			log.debug("上传授课计划：" + count);
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
	public boolean deleteTeachPlan(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET teach_plan=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除授课计划：" + count);
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
}
