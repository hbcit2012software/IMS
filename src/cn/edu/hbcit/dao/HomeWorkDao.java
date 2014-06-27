package cn.edu.hbcit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.apache.log4j.Logger;

import cn.edu.hbcit.dao.Base;
public class HomeWorkDao {
	protected final Logger log = Logger.getLogger(HomeWorkDao.class.getName());
	private Connection conn;
	private PreparedStatement ps;
	
	/**
	 * 根据课程号修改交作业情况
	 * @param classname
	 * @param homework
	 * @return
	 */
	public boolean UpdateByHomeWork(String classname,int homework){
		boolean flag = false;
		int res = 0;
	
			conn = Base.Connect();
			String sql = "update tb_course set  homework=? where PK_course=?"; 
			log.debug(sql);
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, homework);
				ps.setString(2, classname);
			
			res=ps.executeUpdate();
				if(res>0)
				{
					flag=true;
					
				}
				else
				{flag=false;}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
//				e.printStackTrace();
			}
			return flag;
		}
	/**
	 * 首选判断该课程号的作业情况，如果是交改成不交，如果是交了则改成没交
	 * @param id
	 * @param hw
	 * @return
	 */
	public boolean updateHomeWork(int id,int hw){
		boolean flag = false;
		int res = 0;
	String sql=null;
			conn = Base.Connect();
			if(hw==0)
			
			{
				 sql = "update tb_course set  homework=1 where PK_course=?"; 
				 
				
				}
			else if(hw==1)
			{
				 sql = "update tb_course set  homework=0 where PK_course=?"; 
				
			}
				
			try {
				ps = conn.prepareStatement(sql);
				
			ps.setInt(1,id);
			
			res=ps.executeUpdate();
				if(res>0)
				{
					flag=true;
					
				}
				else
				{flag=false;}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
//				e.printStackTrace();
			}
			return flag;
		}
	
	
}
