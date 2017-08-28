package com.gdglc.spring.struts.controller.auth;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.apache.struts2.json.annotations.JSON;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.bean.other.vo.PointVo;
import com.gdglc.spring.biz.auth.IUserBiz;
import com.gdglc.spring.exception.BizException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;


public class UserAction{
	private String name;
	private File file;
	private String fileContentType;
	private String fileFileName;
	private InputStream inputStream;
	private String downFileName;
	private IUserBiz myUserBiz;
	private UserInfo info;
	private PointVo point;
	private List<PointVo> pointList;
	private List<UserInfo> userList;
	
	public List<PointVo> getPointList() {
		return pointList;
	}

	public void setPointList(List<PointVo> pointList) {
		this.pointList = pointList;
	}

	public PointVo getPoint() {
		return point;
	}

	public void setPoint(PointVo point) {
		this.point = point;
	}

	public IUserBiz getMyUserBiz() {
		return myUserBiz;
	}

	public void setMyUserBiz(IUserBiz myUserBiz) {
		this.myUserBiz = myUserBiz;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		//org.apache.struts2.spring.StrutsSpringObjectFactory
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getDownFileName() {
		return downFileName;
	}

	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}
	@JSON(name="rows")
	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	public String showList() {
		System.out.println("---UserAction showList---" + this.name);
		return "list";
	}

	public String add() {
		System.out.println("---UserAction add---");
		return "add";
	}

	public String delete() {
		System.out.println("---UserAction delete---");
		return "test";
	}

	public String update() {
		return "update";
	}

	public String showInfo() {
		System.out.println("showInfo="+this);
		return "info";
	}
	
	public String json(){
		name = "test";
		downFileName="test.jpg";
		info = new UserInfo();
		info.setId(1);
		info.setCreateDate(new Date());
		info.setUserName("accp");
		userList = new ArrayList<UserInfo>();
		userList.add(info);
		return "json";
	}

	public String upload() {
		System.out.println(this.file);
		System.out.println(getFileContentType());
		System.out.println(getFileFileName());
		System.out.println(getPoint());
		System.out.println(this.pointList);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		UserInfo userInfo = new UserInfo();
		userInfo.setId(100);
		userInfo.setUserName("valueStack");
		valueStack.push(userInfo);
		String test = "test";
		valueStack.push(test);
		System.out.println(ServletActionContext.getRequest().getClass());
		try {
			uploadFile(file, fileFileName, "/upload/", "test");
		} catch (BizException e) {
			e.printStackTrace();
		}
		return "ognl";
	}
	
	public String down(){
		String filePath = "";
		// 获取项目真实路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		filePath= realPath+File.separator+"upload"+File.separator+"test.jpg";		
		try {
			inputStream = new BufferedInputStream(new FileInputStream(filePath));
			this.setDownFileName(URLEncoder.encode("测试.jpg","utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("不存在该文件");
			//你们应该自己去决定如何提示用户，这里的none只是测试使用
			return "none";
		}
		return "down";
	}

	private String uploadFile(File file, String fileFileName, String path,String fileName) throws BizException {
		// 获取项目真实路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		System.out.println(realPath);
		String fileType = "";
		if (StringUtils.isBlank(fileFileName)) {
			return null;
		}
		BufferedInputStream bs = null;
		BufferedOutputStream bos = null;
		// 获取文件后缀 a.txt.xml jpg
		fileType = fileFileName.substring(fileFileName.lastIndexOf('.')).toLowerCase();
		// 判断文件格式
		fileName = fileName + fileType;// 文件名小写处理
		try {
			File pathFile = new File(realPath + path);
			if (!pathFile.exists() || !pathFile.isDirectory()) {
				pathFile.mkdirs();
			}
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(new File(realPath + path+ fileName));
			bs = new BufferedInputStream(in);
			bos = new BufferedOutputStream(out);
			byte[] buffer = new byte[2048];
			while ((bs.read(buffer)) != -1) {
				bos.write(buffer);
				bos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new BizException("保存文件失败!");
		} finally {
			if (bs != null) {
				try {
					bs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					bs = null;
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					bos = null;
				}
			}
		}
		return fileType;
	}
	public static void main(String[] args) {
		System.out.println(File.separator);
	}
}
