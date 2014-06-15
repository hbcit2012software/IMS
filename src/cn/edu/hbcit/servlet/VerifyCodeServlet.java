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
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.color.ColorFactory;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.filter.predefined.DiffuseRippleFilterFactory;
import org.patchca.filter.predefined.DoubleRippleFilterFactory;
import org.patchca.filter.predefined.MarbleRippleFilterFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.font.FontFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.text.renderer.BestFitTextRenderer;
import org.patchca.text.renderer.RandomYBestFitTextRenderer;
import org.patchca.text.renderer.SimpleTextRenderer;
import org.patchca.text.renderer.TextRenderer;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

/**
 * 验证码类
 * 本类的简要描述：
 * 使用开源验证码项目patchca生成
 * jar包：patchca-0.5.0.jar
 * 项目网址：https://code.google.com/p/patchca/
 * 项目中文介绍：http://baike.baidu.com/view/6925997.htm?fromTaglist
 * @author 李玮
 * @version 1.00  2014-6-16上午12:03:48	新建
 */

public class VerifyCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 3796351198097771007L; 
	private static ConfigurableCaptchaService ccs = null;
	private static ColorFactory cf = null;
	private static TextRenderer tr = null;
	private static RandomFontFactory ff = null;
	private static RandomWordFactory rwf = null;
	private static Random r = new Random();
	//private static CurvesRippleFilterFactory crff = null;  //干扰线波纹
	//private static MarbleRippleFilterFactory mrff = null;  //大理石波纹
	//private static DoubleRippleFilterFactory drff = null;  //双波纹
	private static WobbleRippleFilterFactory wrff = null;   //摆波纹
	//private static DiffuseRippleFilterFactory dirff = null;  //漫波纹
	/**
	 * Constructor of the object.
	 */
	public VerifyCodeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		rwf = null;
		cf = null;
		ccs = null;
		ff = null;
		super.destroy();
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

		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");
		rwf.setMaxLength(4);
		rwf.setMinLength(4);
		HttpSession session = request.getSession(true);
		OutputStream os = response.getOutputStream();
		ccs.setFilterFactory(wrff);
		/*switch (r.nextInt(5)) {
		case 0:
			ccs.setFilterFactory(drff);
			break;
		case 1:
			ccs.setFilterFactory(mrff);
			break;
		case 2:
			ccs.setFilterFactory(drff);
			break;
		case 3:
			ccs.setFilterFactory(wrff);
			break;
		case 4:
			ccs.setFilterFactory(dirff);
			break;
		}*/
		String captcha = EncoderHelper.getChallangeAndWriteImage(ccs, "png", os);
		session.setAttribute("captcha", captcha);
		os.flush();
		os.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		super.init();
		ccs = new ConfigurableCaptchaService();
		cf = new SingleColorFactory(new Color(25, 60, 170));
		ff = new RandomFontFactory();
		rwf = new RandomWordFactory();
		tr = new BestFitTextRenderer();
		//crff = new CurvesRippleFilterFactory(ccs.getColorFactory());
		//drff = new DoubleRippleFilterFactory();
		wrff = new WobbleRippleFilterFactory();
		//dirff = new DiffuseRippleFilterFactory();
		//mrff = new MarbleRippleFilterFactory();
		rwf.setCharacters("123456789");
		ff.setRandomStyle(false);
		ff.setMaxSize(16);
		ff.setMinSize(12);
		ccs.setTextRenderer(tr);
		ccs.setFontFactory(ff);
		ccs.setWordFactory(rwf);
		ccs.setColorFactory(cf);
		ccs.setWidth(50);
		ccs.setHeight(20);
	}

}
