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
import cn.edu.hbcit.utils.MD5;
import cn.edu.hbcit.utils.UtilTools;
import cn.edu.hbcit.pojo.Users;
/**
 * 查询用户信息By pk_user类
 * 简要说明:
 * @author 吴明磊
 * @version 1.00  2014-6-21下午02:31:04	新建
 */
public class SelectUsersByName extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectUsersByName() {
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

		RightsDao rd = new RightsDao();
		UtilTools ut = new UtilTools();
		Users user=new Users();
		ArrayList userList = null;
		
		String PK_user = request.getParameter("name");//用户名
		
		userList = rd.selectUsersByName(PK_user);//查询用户信息
		
		request.setAttribute("userList", userList);//用户信息
		request.getRequestDispatcher("/3_4_inner.jsp").forward(request, response);
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
