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
package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cn.edu.hbcit.dao.RightsDao;
import cn.edu.hbcit.utils.*;

/**
 * 登录servlet类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-6-16下午10:05:02	新建
 */

public class LoginServlet extends HttpServlet {
	protected final Logger log = Logger.getLogger(LoginServlet.class.getName());

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		
		boolean flag = false;
		MD5 md5 = new MD5();
		RightsDao rd = new RightsDao();
		CalenderUtil cu = new CalenderUtil();
		
		String chknumber = request.getParameter("vcode");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String captcha = (String)session.getAttribute("captcha");
		if(captcha!= null && chknumber != null){
			if(captcha.equals(chknumber)){
				log.debug(md5.MD5Encode(password));
				if(flag){
					//获取权限，是否专业负责人
					session.setAttribute("MajorsManager", rd.isMajorsManager(username));
					log.debug(rd.isMajorsManager(username));
					//获取权限，是否系主任
					session.setAttribute("DepartmentManager", rd.isDepartmentManager(username));
					log.debug(rd.isDepartmentManager(username));
					//获取学期名称
					session.setAttribute("Semester", cu.getSemester());
					log.debug(cu.getSemester());
				}
			}
		}
		
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
