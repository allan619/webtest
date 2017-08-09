package com.gdglc.spring.biz.impl.auth;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.bean.auth.vo.UserInfoVo;
import com.gdglc.spring.biz.auth.IUserBiz;
import com.gdglc.spring.dao.auth.UserInfoMapper;
import com.gdglc.spring.exception.BizException;
import com.gdglc.spring.exception.UpdateException;

public class UserBizImpl implements IUserBiz{
	private UserInfoMapper mapper;
	
	public UserInfoMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserInfoMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void add(UserInfo user) throws BizException {
		user.setCreateDate(new Date());
		try{
			mapper.add(user);
		}catch(Exception e){
			throw new BizException("添加失败",e);
		}
		
	}

	@Override
	public List<UserInfo> findAll() throws BizException {
		return mapper.findAll();
	}

	@Override
	public void delete(Integer id) throws BizException{
		if(null == id||id==0){
			throw new BizException("删除错误，请指定需要删除的记录");
		}
		try{
			mapper.delete(id);
		}catch(Exception e){
			throw new BizException("删除失败",e);
		}
		
	}

	@Override
	public void update(UserInfo userInfo) throws BizException {
		userInfo.setCreateDate(new Date());
		int i = 0;
		try{
			i = mapper.update(userInfo);
		}catch(Exception e){
			throw new BizException("修改失败",e);
		}
		if(i==0){
			throw new UpdateException("您修改的记录已经不存在");
		}
	}

	@Override
	public UserInfo show(Integer id) throws BizException {
		if(null == id||id==0){
			throw new BizException("指定需要修改的记录");
		}
		//测试如果给一个不存在的id，userInfo是null还是一个新对象
		UserInfo userInfo = mapper.findById(id);
		if(null==userInfo||userInfo.getId()!=id){
			throw new BizException("获取不到指定记录的信息，请确认是否已经被删除");
		}
		return userInfo;
	}

	@Override
	public List<UserInfo> findByUser(UserInfoVo vo) throws BizException {
		try{
			List<UserInfo> userList = mapper.findByUser(vo);
			if(null==userList){
				userList = new ArrayList<UserInfo>();
			}
			return userList;
		}catch(Exception e){
			throw new BizException("查询失败");
		}
	}

}
