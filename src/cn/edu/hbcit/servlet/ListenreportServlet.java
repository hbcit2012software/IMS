package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cn.edu.hbcit.dao.CourseDao;
import cn.edu.hbcit.dao.ListenreportDao;
import cn.edu.hbcit.dao.MajorDao;

public class ListenreportServlet extends HttpServlet {
	protected final Logger log = Logger.getLogger(ListenreportServlet.class.getName());
	/**
	 * Constructor of the object.
	 */
	public ListenreportServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
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
		ListenreportDao ld = new ListenreportDao();
		MajorDao md=new MajorDao();
		CourseDao cd=new CourseDao();
		ArrayList MajorsCourseTerms=null;
		ArrayList majorList=null;
		ArrayList courseList=null;
		log.debug((String)session.getAttribute("username"));
		log.debug((String)session.getAttribute("Semester"));
		majorList=	md.selectMajorByUser((String)session.getAttribute("username"),(String)session.getAttribute("Semester"));
		MajorsCourseTerms=ld.selectCourseListen_recordByusername((String)session.getAttribute("username"));
		courseList=cd.selectCourseByusername((String)session.getAttribute("username"),(String)session.getAttribute("Semester"));
		
		request.setAttribute("MajorCourseTerms", MajorsCourseTerms);//课程信息
		request.setAttribute("majorList", majorList);//专业信息
		request.setAttribute("courseList", courseList);//当前用户课程表信息
		request.getRequestDispatcher("/2_2_5.jsp").forward(request, response);
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
