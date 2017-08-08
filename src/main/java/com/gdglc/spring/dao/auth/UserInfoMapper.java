package com.gdglc.spring.dao.auth;

import java.util.List;

import com.gdglc.spring.bean.auth.model.UserInfo;
import com.gdglc.spring.bean.auth.vo.UserInfoVo;

/**
 * 
 * 用户表的数据库操作
 * @author allan
 * @version $Date: 2017年8月1日 $
 */
public interface UserInfoMapper {
	/**
	 * 查询全部用户，按createDate降序
	 * @return
	 */
	public List<UserInfo> findAll();
	/**
	 * 添加用户
	 * @param userInfo 用户对象
	 * @return
	 */
	public int add(UserInfo userInfo);
	/**
	 * 删除指定的用户信息，物理删除
	 * @param id 用户标识
	 * @return
	 */
	public int delete(int id);
	
	/**
	 * 修改用户信息
	 * @param userInfo 需要需改的用户信息对象
	 * @return
	 */
	public int update(UserInfo userInfo);
	
	public UserInfo findById(int id);
	
	/**
	 * 按条件查询用户信息，按用户名模糊匹配，按创建时间区间查询
	 * @param vo
	 * @return
	 */
	public List<UserInfo> findByUser(UserInfoVo vo);
}
