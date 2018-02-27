package com.jiantong.controller.admin;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jiantong.controller.admin.base.BaseController;

/**
 * 文件上传Controller
 * <p>Title:FileUploadController</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2018年2月7日 上午10:20:39
 */
@Controller
@RequestMapping(value="/admin/fileUpload")
public class FileUploadController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		String path = "";
		//文件上传存放跟目录
		String videoPath = request.getSession().getServletContext().getRealPath("/upload/video");
		String imgPath = request.getSession().getServletContext().getRealPath("/upload/images");
		String docPath = request.getSession().getServletContext().getRealPath("/upload/doc");
		String rootPath = request.getSession().getServletContext().getRealPath("/upload/system");
		File videoPathDir = new File(videoPath);
		File imgPathDir = new File(imgPath);
		File docPathDir = new File(docPath);
		File rootPathDir = new File(rootPath);
		if (!videoPathDir.exists()) {
			videoPathDir.mkdirs();
		}
		if(!imgPathDir.exists()){
			imgPathDir.mkdirs();
	    }
		if(!docPathDir.exists()){
			docPathDir.mkdirs();
	    }
		if(!rootPathDir.exists()){
			rootPathDir.mkdirs();
	    }
		File targetFile = null;
		Iterator<String> fileNames = request.getFileNames();
		MultipartFile file = request.getFile(fileNames.next());
		String fullFileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    String strName = sdf.format(new Date());
		if(fullFileName.contains(".")) {
			//转义拆分重命名文件
			String extension = fullFileName.substring(fullFileName.lastIndexOf(".")+1, fullFileName.length());
			String fileName = fullFileName.substring(0, fullFileName.lastIndexOf("."));
			if ("avi".equalsIgnoreCase(extension) || "mp4".equalsIgnoreCase(extension) || "mov".equalsIgnoreCase(extension)) {
				fileName = strName + "."+ extension;
				targetFile = new File(videoPath, fileName);
				path = "upload/video/" + fileName;
			} else if("bmp".equalsIgnoreCase(extension) || "jpe".equalsIgnoreCase(extension) || "jpeg".equalsIgnoreCase(extension) || "jpg".equalsIgnoreCase(extension) || "png".equalsIgnoreCase(extension)){
		    	fileName = strName + "."+ extension;
		    	targetFile = new File(imgPath, fileName);
		    	path = "upload/images/" + fileName;
		    }else if("doc".equalsIgnoreCase(extension) || "docx".equalsIgnoreCase(extension)) {
		    	fileName = fileName + "_" + strName + "."+ extension;
		    	targetFile = new File(docPath, fileName);
		    	path = "upload/doc/" + fileName;
		    }else{
		    	//获取文件MD5值
		    	StringBuffer reStr = null;
		    	try {
					byte[] bytes = file.getBytes();
					MessageDigest md5 = MessageDigest.getInstance("MD5");
					byte[] digest = md5.digest(bytes);
					reStr = new StringBuffer();
				      for(int i = 0; i < digest.length ; i ++){
				        reStr.append(byteHEX(digest[i]));
				      }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					logger.info("读取文件异常", e1);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					logger.info("MD5加密异常", e);
				}
		    	
		    	fileName = fileName + "_" + strName + "."+ extension;
		    	targetFile = new File(rootPath, fileName);
		    	path = "upload/system/" + fileName;
		    	
		    	data.put("mdf", reStr);
		    }
		}else {
			//没有后缀名的文件放到system目录下
			String fileName = fullFileName + "_" + strName;
	    	targetFile = new File(docPath, fileName);
	    	path = "upload/system/" + fileName;
		}
		
	    data.put("path", path);
		try {
			file.transferTo(targetFile);
			flag = true;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			logger.error("upload IllegalStateException", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("upload IOException", e);
		}
		if(flag){
			result.put("retcode", SUCCESS);
			result.put("data", data);
		}else{
			result.put("retcode", FAIL);
			result.put("error", "上传失败");
		}
		return result;
	}
	
	private String byteHEX(byte ib) {
        char[] Digit = { '0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
        char [] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
	}
}
