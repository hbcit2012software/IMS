package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.edu.hbcit.utils.UploadTools;

public class DemoUploadServlet extends HttpServlet {

	private ServletConfig config;
	protected final Logger log = Logger.getLogger(DemoUploadServlet.class.getName());
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

		request.setCharacterEncoding("UTF-8");
		UploadTools ut = new UploadTools();
		String savePath = ut.upload(request, response, config);
		log.debug("上传成功：" + savePath);
	}

	/**
	 * Servlet初始化
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
}
