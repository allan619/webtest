package com.gdglc.spring.mvc.controller.auth;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Locale.Category;

import javax.annotation.Resource;
import javax.lang.model.type.PrimitiveType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.alibaba.fastjson.JSON;
import com.gdglc.spring.bean.auth.model.DeptInfo;
import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.bean.auth.model.UserInfoDemo;
import com.gdglc.spring.biz.auth.IUserBiz;
import com.gdglc.spring.mvc.controller.BaseController;

@Controller
@RequestMapping("/user")
public class UserControllerDemo extends BaseController{
	//@Autowired
	//@Qualifier("biz")
	@Resource(name="userBiz")
	private IUserBiz biz;
	
	public IUserBiz getBiz() {
		return biz;
	}
	public void setBiz(IUserBiz biz) {
		this.biz = biz;
	}
	public UserControllerDemo(){
		//ContentNegotiatingViewResolver
		System.out.println("---create UserController---");
	}
	@RequestMapping("/show")
	public String show(@RequestParam(required=false,value="name") String name,int age,Model model){
		System.out.println("-----UserController-----");
		Class x = int.class;
		System.out.println(model);
		model.addAttribute("name", "T10");
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(@Valid @ModelAttribute("user") UserInfoDemo user,BindingResult result,RedirectAttributes model,Model request) {
		System.out.println("-----UserController-----");
		//如果有验证错误
		if(result.hasErrors()){
			List<FieldError> fieldErrors = result.getFieldErrors();
			//直接添加到model中，在页面使用requestScope作用域获取
			for (FieldError error : fieldErrors) {
				String field = error.getField();
				String message = error.getDefaultMessage();
				//key建议使用 模块名称_error_字段名称
				request.addAttribute(field, message);
			}
			return "/user/add";
		}
		if(user.getAge()==10){
			//throw new RuntimeException("异常测试");
		}
//		try {
//			biz.add(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//使用addAttribute是在请求url后面添加请求参数
		//model.addAttribute("name", "T10");
		model.addFlashAttribute("name", "accp");
		return "redirect:/user/list";
		
	}
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("name") String name,Model model){
		System.out.println(name);
		return "list";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Map<String, String> paramMap,Model model){
		System.out.println("-----update-----");
		System.out.println(model);
		model.addAttribute("name", "T10");
		return "/index.jsp";
	}
	
	@RequestMapping(value="/ajax")
	@ResponseBody
	public UserInfoDemo ajax(){
		
		UserInfoDemo user = new UserInfoDemo();
		user.setName("测试");
		user.setAge(10);
		DeptInfo dept = new DeptInfo();
		dept.setName("deptOne");
		user.setDept(dept);
		user.setCreateDate(new Date());
		
		return user;
	}
	
	//知道就好，用不上
	//@ExceptionHandler(RuntimeException.class)
	public String handleError(RuntimeException e,HttpServletRequest request){
		System.out.println("处理异常");
		request.setAttribute("error", e.getMessage());
		return "index";
	}
	
	@RequestMapping(value="/showAdd")
	public String showAdd(Model model){
		//org.springframework.web.servlet.config.MvcNamespaceHandler
		//DefaultFormattingConversionService
		UserInfoDemo userInfo = new UserInfoDemo();
		userInfo.setName("请输入用户名");
		userInfo.setAge(100);
		model.addAttribute("user", userInfo);
		return "/user/add";
	}
	
	@RequestMapping("/upload")
	public String upload(HttpSession session, UserInfoDemo user,MultipartFile file,MultipartFile file2){
		System.out.println("------upload-----");
		String pathName = session.getServletContext().getRealPath("/resource");
		//获取上传文件名称
		String fileName = file.getOriginalFilename();
		//获取上传文件的文件类型，以供后面判断是否可以上传使用
		String extension = FilenameUtils.getExtension(fileName);
		pathName= pathName+File.separator+"images"+File.separator+fileName ;
		File dest = new File(pathName);
		if(!dest.exists()){
			dest.mkdirs();
		}
		try {
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/fastJson",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String fastJson(){
		UserInfoDemo user = new UserInfoDemo();
		user.setName("测试");
		user.setAge(10);
		DeptInfo dept = new DeptInfo();
		dept.setName("deptOne");
		user.setDept(dept);
		user.setCreateDate(new Date());
		return JSON.toJSONString(user);
	}
	@RequestMapping("/content")
	public ModelAndView content(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");	
		UserInfoDemo user = new UserInfoDemo();
		user.setName("测试");
		user.setAge(10);
		DeptInfo dept = new DeptInfo();
		dept.setName("deptOne");
		user.setDept(dept);
		user.setCreateDate(new Date());
		modelAndView.getModel().put("user", user);
		return modelAndView;
	}
	
	@RequestMapping("/detail/{id}/create/{date}")
	public String rest(@PathVariable("id") int id,@PathVariable Date date,@MatrixVariable(value="name",pathVar="id",required=false) String name){
		System.out.println("id="+id);
		return null;
	}
	
	
}
