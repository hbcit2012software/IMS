package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbcit.dao.RightsDao;
import cn.edu.hbcit.utils.MD5;
/**
 * 修改用户密码类
 * 简要说明:
 * @author 吴明磊
 * @version 1.00  2014-6-22下午08:31:24	新建
 */
public class UpdateUsersInPasswd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateUsersInPasswd() {
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String pk_user=request.getParameter("user");//用户名
		String password=request.getParameter("password");//密码
		String md5Password=MD5.MD5Encode(password);
		boolean flag = false;
		RightsDao rd= new RightsDao();

flag = rd.reSetPassword(md5Password, pk_user);
		
		if(flag){
			out.print("success");
		}else{
			out.print("fail");
		}
		out.flush();
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
