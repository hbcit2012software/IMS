package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbcit.dao.CourseDao;
import cn.edu.hbcit.utils.UtilTools;

/**
 * 刘世伟
 * 根据Id删除答疑记录
 * @author Administrator
 *
 */
public class DeleteQAById extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteQAById() {
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
		CourseDao cd = new CourseDao();
		UtilTools ut = new UtilTools();
		boolean flag = false;		
		String id = request.getParameter("id");
		//判断id是不是整数格式，否则会造成异常
		if(ut.isNumeric(id)){
		flag = cd.deleteQA(Integer.parseInt(id));
		}
		if(flag)
		{
			request.setAttribute("msg", "删除成功");
			request.getRequestDispatcher("QAServlet").forward(request, response);
		}
		{
			request.setAttribute("msg", "删除失败");
			request.getRequestDispatcher("QAServlet").forward(request, response);
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
