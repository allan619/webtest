package com.gdglc.spring.biz.auth;

import java.util.List;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.bean.auth.vo.UserInfoVo;
import com.gdglc.spring.exception.BizException;

public interface IUserBiz {
	//所有的业务方法都应该抛出异常
	/**
	 * 查询全部用户，按createDate降序
	 * @return
	 */
	public List<UserInfo> findAll() throws BizException;
	/**
	 * 添加用户
	 * @param userInfo 用户对象
	 * @return
	 */
	public void add(UserInfo userInfo) throws BizException;
	/**
	 * 删除指定的用户信息，物理删除
	 * @param id 用户标识
	 * @return
	 */
	public void delete(Integer id) throws BizException;
	
	/**
	 * 修改用户信息
	 * @param userInfo 需要需改的用户信息对象
	 * @return
	 */
	public void update(UserInfo userInfo) throws BizException;
	
	/**
	 * 获取指定编号的用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserInfo show(Integer id)throws BizException;
	
	/**
	 * 按条件查询用户信息，按用户名模糊匹配，按创建时间区间查询
	 * @param vo
	 * @return 如果查询不到相关记录，返回一个空的List
	 */
	public List<UserInfo> findByUser(UserInfoVo vo) throws BizException;
}
