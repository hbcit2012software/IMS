package cn.edu.hbcit.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.jspsmart.upload.*;

public class UploadTools {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletConfig config;

	protected final Logger log = Logger.getLogger(UploadTools.class.getName());

	/**
	 * 上传文件
	 * @param request
	 * @param response
	 * @param config
	 * @param params 前台表单的name属性列表，字符串数组
	 * @return 返回ArrayList
	 * ArrayList的第一个元素，存放hash map
	 * ArrayList的第二个元素，存放path
	 */
	public ArrayList upload(HttpServletRequest request,
			HttpServletResponse response, ServletConfig config ,String[] params) {

		HashMap<String, String> map = new HashMap<String, String>(); 
		ArrayList list = new ArrayList();
		String path = "";
		String realPathAccessories = "";
		String nameAccessories = "";
		String parameter = null;

		try {
			SmartUpload su = new SmartUpload(); // 实例化jspSmartUpload
			su.initialize(config, request, response);// 初始化SmartUpload
			su.setAllowedFilesList("gif,jpg,jpeg,png,doc,xls,ppt,pdf,txt,rar,zip,vsd"); // 允许上传的文件类型(中间用,隔开)
			su.setMaxFileSize(100 * 1024 * 1024); // 声明上传文件最大容量
			log.debug("File Uploading...");

			su.upload();

			com.jspsmart.upload.File accessories = su.getFiles().getFile(0);

			for(String t : params){
				map.put(t, su.getRequest().getParameter(t));
				log.debug("获取的参数名:" + t + "\t 获取的参数值:" + map.get(t));
			}
			
			list.add(map);
			// parameter = su.getRequest().getParameter("kcid");
			// log.debug("获取的参数:" + parameter);

			FileOperate fo = new FileOperate();

			if (!accessories.isMissing()) {
				realPathAccessories = request.getRealPath("/") + "userfiles\\";// 存放文件附件
				nameAccessories = fo.generateRandomFilename()
						+ accessories.getFileExt();// 生成随机文件名+原扩展名
				realPathAccessories += nameAccessories;// 绝对路径+文件名
				log.debug("当前路径是：" + realPathAccessories);
				accessories.saveAs(realPathAccessories, su.SAVE_PHYSICAL);
				log.debug("上传文件大小：" + accessories.getSize());

				path = "userfiles/" + nameAccessories;
				list.add(path);
			}

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取jspSmartUpload的request参数
	 * 
	 * @param request
	 * @param response
	 * @param config
	 * @param paramName
	 * @return
	 */
	public String getFileParameter(HttpServletRequest request,
			HttpServletResponse response, ServletConfig config, String paramName) {
		String parameter = null;
		SmartUpload su = new SmartUpload(); // 实例化jspSmartUpload
		try {
			su.initialize(config, request, response);// 初始化SmartUpload
//			su.upload();
			parameter = su.getRequest().getParameter(paramName);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parameter;
	}
}
