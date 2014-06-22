/**
 * 
 */
package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hbcit.dao.CourseDao;
import cn.edu.hbcit.dao.MajorDao;
//import cn.edu.hbcit.dao.TermsDao;

/**
 * @author 武佳男
 *
 * 2014-6-21
 */
public class BeginPPTServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BeginPPTServlet() {
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
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
		CourseDao cd = new CourseDao();
		MajorDao md=new MajorDao();
		ArrayList MajorsCourseTerms=null;
		ArrayList majorList=null;
		majorList=	md.selectMajorByUser((String)session.getAttribute("username"));
		MajorsCourseTerms=cd.selectMajorCourseTermsByusername((String)session.getAttribute("username"));
		request.setAttribute("MajorCourseTerms", MajorsCourseTerms);//课程信息
		request.setAttribute("majorList", majorList);//专业信息
		request.getRequestDispatcher("/2_1_1.jsp").forward(request, response);
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
