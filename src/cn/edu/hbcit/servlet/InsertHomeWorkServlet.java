package cn.edu.hbcit.servlet;

import java.io.IOException;
/**
 * 修改交作业的情况
 * 简要说明:
 * @author 杜金萍
 * @version 1.00  2014-6-23下午01:31:04	新建
 */
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import cn.edu.hbcit.dao.CourseDao;
import cn.edu.hbcit.dao.HomeWorkDao;
import cn.edu.hbcit.pojo.Course;

public class InsertHomeWorkServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertHomeWorkServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String coursename=request.getParameter("selectkcid");
		
		String homeworked=request.getParameter("homeworked");
		out.println(coursename);
		out.println(homeworked);
		

		
		 int homework; 
		 if (homeworked!=null) 
		 { homework=1; } 
		 else {
		 homework=0;
		
		 }
		 HomeWorkDao srb=new HomeWorkDao(); boolean flag;
		 flag=srb.UpdateByHomeWork(coursename, homework); 
		 if(flag) {
		 
			 JOptionPane.showMessageDialog(null,"提交成功");
		 request.getRequestDispatcher("HomeWorkServlet").forward(request,
		 response);
		  
		 } else { JOptionPane.showMessageDialog(null,"提交失败");
		 request.getRequestDispatcher("HomeWorkServlet").forward(request,
		 response);
		
		}
		 
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
