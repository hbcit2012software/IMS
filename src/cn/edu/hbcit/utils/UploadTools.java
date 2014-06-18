package cn.edu.hbcit.utils;

import java.io.IOException;

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
	 * @return
	 */
	public String upload(HttpServletRequest request, HttpServletResponse response, ServletConfig config){

		String path = "";
		String realPathAccessories = "";
		String nameAccessories = "";
		
		try {
			SmartUpload su = new SmartUpload(); //实例化jspSmartUpload
			su.initialize(config, request, response);// 初始化SmartUpload
			su.setAllowedFilesList("gif,jpg,jpeg,png,doc,xls,ppt,pdf,txt,rar,zip,vsd"); //允许上传的文件类型(中间用,隔开)
			su.setMaxFileSize(100 * 1024 * 1024); //声明上传文件最大容量
			log.debug("Uploading...");
			
			su.upload();
//			com.jspsmart.upload.File file = su.getFiles().getFile(0);
			com.jspsmart.upload.File accessories = su.getFiles().getFile(0);
			
			FileOperate fo = new FileOperate();
			
			if(!accessories.isMissing()){
				realPathAccessories = request.getRealPath("/")+"userfiles\\";//存放文件附件
				nameAccessories = fo.generateRandomFilename()+accessories.getFileExt();//生成随机文件名+原扩展名
				realPathAccessories += nameAccessories;//绝对路径+文件名
				log.debug("当前路径是：" + realPathAccessories);
				accessories.saveAs(realPathAccessories, su.SAVE_PHYSICAL);
				log.debug("上传文件大小："+accessories.getSize());
				
				path = "userfiles/" + nameAccessories;
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
		return path;
	}
}
