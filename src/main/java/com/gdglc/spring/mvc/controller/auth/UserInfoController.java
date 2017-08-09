package com.gdglc.spring.mvc.controller.auth;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.bean.auth.vo.ResponeVo;
import com.gdglc.spring.bean.auth.vo.UserInfoVo;
import com.gdglc.spring.biz.auth.IUserBiz;
import com.gdglc.spring.exception.BizException;
import com.gdglc.spring.exception.UpdateException;

@Controller
@RequestMapping("/auth/user")
public class UserInfoController {
	@Resource(name="userBiz")
	private IUserBiz userBiz;

	public IUserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}


	/**
	 * 显示列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(UserInfoVo vo ,Model model){
		try {
			//调用业务方法
			List<UserInfo> userList = userBiz.findByUser(vo);
			//把userList添加到model中，相当于把userList添加到request作用域
			model.addAttribute("userList",userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "auth/user/list";
	}
	@RequestMapping("/del")
	public String delet(Integer id,RedirectAttributes  redirect){
		try {
			userBiz.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("errorMessage", e.getMessage());
		}
		return "redirect:/auth/user/list";
	}
	@RequestMapping("/detail")
	public String detail(Integer id,Model model){
		try {
			UserInfo info = userBiz.show(id);
			model.addAttribute("info", info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "auth/user/detail";
	}
	@RequestMapping("/update")
	public String update(UserInfo info,Model model){
		try {
			userBiz.update(info);
		}catch(UpdateException e){
			model.addAttribute("errorMessage", e.getMessage());
			return "auth/user/detail";
		} catch (Exception e) {
			e.printStackTrace();
			//return "auth/user/detail";
		}
		return "redirect:/auth/user/list";
	}
	
	@RequestMapping("/ajax/update")
	@ResponseBody
	public ResponeVo ajaxUpdate(UserInfo info,String test){
		ResponeVo vo = new ResponeVo();
		try {
			userBiz.update(info);
		}catch(UpdateException e){
			vo.setCode(ResponeVo.ERROR);
			vo.setMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			vo.setCode(ResponeVo.ERROR);
			vo.setMessage("执行失败!");
		}
		return vo;
	}
	
	@RequestMapping("/showAdd")
	public String showAdd(){
		return "auth/user/add";
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public ResponeVo add(UserInfo info,String test){
		ResponeVo vo = new ResponeVo();
		try {
			userBiz.add(info);
		}catch(UpdateException e){
			vo.setCode(ResponeVo.ERROR);
			vo.setMessage(e.getMessage());
		} catch (BizException e) {
			e.printStackTrace();
			vo.setCode(ResponeVo.ERROR);
			vo.setMessage(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
}
