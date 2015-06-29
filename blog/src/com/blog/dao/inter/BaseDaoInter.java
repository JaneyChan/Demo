package com.blog.dao.inter;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
/**
 * 基本的增删改查类
 * @since 2014-7-14
 */
@Service("baseDaoInter")
public interface BaseDaoInter {
	/**
	 * 数据库查询语句
	 * @param hql    hibernate查询语句
	 * @param params 携带的参数，诺无则置空
	 * @return		   查询结果
	 */
	public List<?> getResult(String hql,Object[] params);
	/**
	 * 得到查询结果记录
	 * @param hql		查询语句
	 * @return			返回结果记录
	 */
	public int getResultCount(String hql,Object[] params);
	/**
	 * 按照分页的形式获取结果
	 * @param hql			// 查询语句
	 * @param start		// start 
	 * @param max		// max 
	 * @return				// 返回指定的结果
	 */
	public List<?> getResultByPage(String hql, int offset, int pagesize, Object[] params) ;
	/**
	 * 保存执行对象
	 * @param obj	 要保存的对象
	 * @return		 返回 true,执行成功，返回false，执行失败
	 */
	public boolean save(Object obj);
	/**
	 * 删除执行对象
	 * @param obj	 要删除的对象
	 * @return		 返回 true,执行成功，返回false，执行失败
	 */
	public boolean delete(Object obj);
	/**
	 * 更新执行对象
	 * @param obj	 要更新的对象
	 * @return		 返回 true,执行成功，返回false，执行失败
	 */
	public boolean update(Object obj);
	/**
	 * 根据Id返回指定的对象
	 * @param clazz	返回的对象类
	 * @param id	id
	 * @return		对象
	 */
	public Object findById(@SuppressWarnings("rawtypes") Class clazz,Serializable id);
	/**
	 * 根据参数查询返回唯一的一个对象
	 * @param hql		查询语句
	 * @param params	对应的参数
	 * @return			查询对象
	 */
	public Object getResultOne(String hql, Object[] params);
}
