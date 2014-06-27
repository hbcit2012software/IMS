package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.edu.hbcit.dao.ListenreportDao;
import cn.edu.hbcit.utils.FileOperate;
import cn.edu.hbcit.utils.UtilTools;
/**
 * @author 杜金萍
 *
 * 2014-6-24
 */
public class DeletePaperById extends HttpServlet {
	protected final Logger log = Logger.getLogger(DeletePaperById.class.getName());
	/**
	 * Constructor of the object.
	 */
	public DeletePaperById() {
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
		ListenreportDao cd = new ListenreportDao();
		UtilTools util = new UtilTools();
		boolean flag = false;		
		String id = request.getParameter("id");
		String fileName= request.getParameter("filename");
		log.debug(fileName);
		log.debug(id);
		boolean fileFlag=false;
		
		//删除文件
		FileOperate fo = new FileOperate();
		fileFlag = fo.deleteFile(request.getRealPath(fileName));
		//判断是否删除文件
				if(fileFlag){
					//判断id是不是整数格式，否则会造成异常
					if(util.isNumeric(id)){
					flag = cd.deletePaper(Integer.parseInt(id));
					}
					if(flag)
					{
						request.setAttribute("msg", "删除成功");
						request.getRequestDispatcher("PaperServlet").forward(request, response);
					}
					else
					{
						request.setAttribute("msg", "删除失败");
						request.getRequestDispatcher("PaperServlet").forward(request, response);
					}
				}
				else{
					request.setAttribute("msg", "删除失败");
					request.getRequestDispatcher("PaperServlet").forward(request, response);
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
