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
package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbcit.dao.MajorDao;
import cn.edu.hbcit.dao.RightsDao;
import cn.edu.hbcit.pojo.Majors;

/**
 * 查询专业信息类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-6-18下午09:31:17	新建
 */

public class SelectMajors extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectMajors() {
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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		String majorCode = request.getParameter("zybh");
		String majorName = request.getParameter("zymc");
		String years = request.getParameter("xz");
		String leader = request.getParameter("zyfzr");
		
		MajorDao md = new MajorDao();
		RightsDao rd = new RightsDao();
		ArrayList majorList = null;
		ArrayList leaderList = null;
		
		majorList = md.selectMajors();
		leaderList = rd.selectLeaders();
		
		request.setAttribute("majorList", majorList);//专业信息
		request.setAttribute("leaderList", leaderList);//教师姓名
		request.getRequestDispatcher("/3_1.jsp").forward(request, response);
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

		this.doGet(request, response);
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
