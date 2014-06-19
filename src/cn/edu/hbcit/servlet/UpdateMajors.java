package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.edu.hbcit.dao.MajorDao;
import cn.edu.hbcit.utils.UtilTools;

public class UpdateMajors extends HttpServlet {

	protected final Logger log = Logger.getLogger(UpdateMajors.class.getName());
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		MajorDao md = new MajorDao();
		UtilTools ut = new UtilTools();
		boolean flag = false;
		
		String pk = request.getParameter("pk"); //专业主键
		String major_code = request.getParameter("zybh");// 专业编号
		String major_name = request.getParameter("zymc");//专业名称
		String years = request.getParameter("xz");//学制
		String FK_users_majors = request.getParameter("zyfzr");//专业负责人ID
		
		log.debug("major_code:" + major_code);
		log.debug("major_name:" + major_name);
		log.debug("years:" + years);
		log.debug("FK_users_majors:" + FK_users_majors);
		log.debug("PK:" + pk);
		
		if(ut.isNumeric(pk)){
			flag = md.updateMajors(major_name, major_code, years, FK_users_majors, Integer.parseInt(pk));
		}
		if(flag){
			out.print("success");
		}else{
			out.print("fail");
		}
		out.flush();
		out.close();
	}

}
