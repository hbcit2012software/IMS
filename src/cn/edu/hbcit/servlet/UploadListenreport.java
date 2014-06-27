package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.edu.hbcit.dao.ListenreportDao;
import cn.edu.hbcit.utils.UploadTools;
import cn.edu.hbcit.utils.UtilTools;
/**
 * @author吴雅君
 *
 * 2014-6-22
 */
public class UploadListenreport extends HttpServlet {
	protected final Logger log = Logger.getLogger(UploadListenreport.class.getName());
	private ServletConfig config;
	/**
	 * Constructor of the object.
	 */
	public UploadListenreport() {
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
//		PrintWriter out = response.getWriter();
		boolean flag = false;
		int PK_listen_record = 0;
		ListenreportDao cd = new ListenreportDao();
		UploadTools ut = new UploadTools();
		UtilTools util = new UtilTools();
		HashMap map = new HashMap(); 
		ArrayList list = new ArrayList();
		String path = "";
		
		String[] params = {"kcid"}; 
		list = ut.upload(request, response, config, params);
		map = (HashMap)list.get(0);//获取参数值map
		path = (String)list.get(1);//获取上传路径
		
		
		log.debug("上传成功kcid：" + (String)map.get("kcid"));
		log.debug("上传成功path：" + path);
		//转换成整型之前一定要进行格式检查
		if(util.isNumeric((String)map.get("kcid"))){
			PK_listen_record=Integer.parseInt((String)map.get("kcid")); 
		}
		
		log.debug("major_name:" + path);
		flag = cd.uploadlisten_record(PK_listen_record, path);
		if(flag){
		request.setAttribute("msg", "上传成功");
		request.getRequestDispatcher("ListenreportServlet").forward(request, response);
		}
		else{
			request.setAttribute("msg", "上传失败");
			request.getRequestDispatcher("ListenreportServlet").forward(request, response);
		}
		}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

}
