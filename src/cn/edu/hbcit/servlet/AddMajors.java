/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-6-19	1.0		李玮		新建
*/
package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.edu.hbcit.dao.MajorDao;

/**
 * 新增专业类
 * 简要说明:
 * @author Administrator
 * @version 1.00  2014-6-19上午11:45:49	新建
 */

public class AddMajors extends HttpServlet {

	protected final Logger log = Logger.getLogger(AddMajors.class.getName());
	/**
	 * Constructor of the object.
	 */
	public AddMajors() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		boolean flag = false;
		MajorDao md = new MajorDao();
		
		String major_code = request.getParameter("zybh");// 专业编号
		String major_name = request.getParameter("zymc");//专业名称
		String years = request.getParameter("xz");//学制
		String FK_users_majors = request.getParameter("zyfzr");//专业负责人ID
		log.debug("major_code:" + major_code);
		log.debug("major_name:" + major_name);
		log.debug("years:" + years);
		log.debug("FK_users_majors:" + FK_users_majors);
		
		flag = md.addMajors(major_name, major_code, years, FK_users_majors);
		
		if(flag){
			out.print("success");
		}else{
			out.print("fail");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
