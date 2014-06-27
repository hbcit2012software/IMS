package cn.edu.hbcit.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import cn.edu.hbcit.pojo.Course;
import cn.edu.hbcit.pojo.Listen_record;

public class ListenreportDao {
	protected final Logger log = Logger.getLogger(ListenreportDao.class.getName());
	/**
	 * 根据用户查询听课记录和课程名称
	 * **/
	public ArrayList selectCourseListen_recordByusername(String username){
		ArrayList<Listen_record> list = null;
		try {
			Connection conn = Base.Connect();
			Listen_record listen_record = new Listen_record();
			QueryRunner qr = new QueryRunner();
			String sql = "select PK_listen_record,listen_record,true_name,FK_terms_listenrec,course_name from tb_course,tb_listen_record,tb_users where  tb_listen_record.FK_users_listenrec=tb_users.PK_users and tb_users.true_name=tb_course.FK_users_course and tb_listen_record.FK_users_listenrec=?";
		
			list = (ArrayList<Listen_record>)qr.query(conn, sql, new BeanListHandler(Listen_record.class), username);
			
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询用户当历年实训信息
	 * @param username
	 * @return
	 */
	public ArrayList selectMajorCourseTermsByusername(String username){
		ArrayList<Course> list = null;
		try {
			Connection conn = Base.Connect();
			Course course = new Course();
			QueryRunner qr = new QueryRunner();
			String sql = "select * from tb_course inner join tb_terms on FK_terms_course=PK_term inner join tb_majors on PK_majors=FK_majors_course where FK_users_course=? and is_practice=1";
		
			list = (ArrayList<Course>)qr.query(conn, sql, new BeanListHandler(Course.class), username);
			
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 上传听课记录
	 * @param course_id
	 * @param course_ppt
	 * @return
	 */
	public boolean uploadlisten_record(int PK_listen_record,String listen_record ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_listen_record SET listen_record=? WHERE PK_listen_record=? ";
			count = qr.update(conn, sql, listen_record,PK_listen_record);
			log.debug("PK_listen_record：" + PK_listen_record);
			log.debug("上传听课记录：" + count);
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
	 * 上传实践指导书
	 * @param course_id
	 * @param practice_note
	 * @return
	 */
	public boolean uploadPractice_note(int course_id,String practice_note ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET practice_note=? WHERE PK_course=? and is_practice=1 ";
		
			count = qr.update(conn, sql, practice_note,course_id);
			
			log.debug("上传实践指导书：" + count);
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
	 * 上传实践任务书
	 * @param course_id
	 * @param practice_mission_note 
	 * @return
	 */
	public boolean uploadPractice_mission_note(int course_id,String practice_mission_note ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET practice_mission_note =? WHERE PK_course=? and is_practice=1";
		
			count = qr.update(conn, sql, practice_mission_note ,course_id);
			
			log.debug("上传实践任务书：" + count);
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
	 * 上传实践教学计划
	 * @param course_id
	 * @param pracitce_plan 
	 * @return
	 */
	public boolean uploadPracitce_plan(int course_id,String pracitce_plan ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET pracitce_plan=? WHERE PK_course=? and is_practice=1";
		
			count = qr.update(conn, sql,pracitce_plan ,course_id);
			
			log.debug("上传实践教学计划：" + count);
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
	 * 上传期末试卷
	 * @param course_id
	 * @param paper 
	 * @return
	 */
	public boolean uploadPaper(int course_id,String paper ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET paper=? WHERE PK_course=? ";
		
			count = qr.update(conn, sql,paper ,course_id);
			
			log.debug("上传期末试卷：" + count);
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
	 * 上传期末成绩
	 * @param course_id
	 * @param score 
	 * @return
	 */
	public boolean uploadScore(int course_id,String score ){
		int count = 0;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET score=? WHERE PK_course=? ";
		
			count = qr.update(conn, sql,score ,course_id);
			
			log.debug("上传期末成绩：" + count);
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
	 * 删除听课记录
	 * @param PK_listen_record
	 * @return
	 */
	public boolean deletelisten_record(int PK_listen_record){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_listen_record SET listen_record=? WHERE PK_listen_record=? ";
			count = qr.update(conn, sql,string,PK_listen_record);
			log.debug("PK_listen_record：" + PK_listen_record);
			log.debug("删除记录：" + count);
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
	 * 删除实践指导书
	 * @param course_id
	 * @return
	 */
	public boolean deletePractice_note(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET practice_note=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除实践指导书：" + count);
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
	 * 删除实践任务书
	 * @param course_id
	 * @return
	 */
	public boolean deletePractice_mission_note(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET practice_mission_note=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除实践任务书：" + count);
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
	 * 删除期末试卷
	 * @param course_id
	 * @return
	 */
	public boolean deletePaper(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET paper=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除期末试卷：" + count);
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
	 * 删除期末成绩
	 * @param course_id
	 * @return
	 */
	public boolean deleteScore(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET score=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除期末成绩：" + count);
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
	 * 删除实践教学计划
	 * @param course_id
	 * @return
	 */
	public boolean deletePracitce_plan(int course_id){
		int count = 0;
		String string=null;
		boolean flag = false;
		try {
			Connection conn = Base.Connect();
			QueryRunner qr = new QueryRunner();
			String sql = "UPDATE tb_course SET pracitce_plan=? WHERE PK_course=? ";
			count = qr.update(conn, sql,string,course_id);
			log.debug("删除实践教学计划：" + count);
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
