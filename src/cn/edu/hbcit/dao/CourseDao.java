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

/**
 * @author 武佳男
 *
 * 2014-6-21
 */
public class CourseDao {
	protected final Logger log = Logger.getLogger(CourseDao.class.getName());
	public ArrayList selectCourse(){
		ArrayList<Course> list = null;
		try {
			Connection conn = Base.Connect();
			Majors majors = new Majors();
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT * from tb_course ";
		
			list = (ArrayList<Course>)qr.query(conn, sql, new BeanListHandler(Course.class));
			
			DbUtils.closeQuietly(conn);//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
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
}
