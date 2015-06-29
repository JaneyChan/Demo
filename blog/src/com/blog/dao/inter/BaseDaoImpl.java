package com.blog.dao.inter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


/**
 * 基本的增删改查类
 * @author Babylon babylon2014@outlook.com
 * @since 2014-7-14
 */
@Transactional
public abstract class BaseDaoImpl implements BaseDaoInter {
	@Autowired
	@Qualifier("sessionFactory")
	protected SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 原生sql语句获得查询对象列表
	 * @param sql		查询语句
	 * @param clazz	对象类型
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<?> createSQLQueryList(String sql,Class clazz,Object[] params){
		Session session= getSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		query.setResultTransformer(Transformers.aliasToBean(clazz));
		List<?> list = query.list();
		clearSession(session);
		return list;
	}
	/**
	 * 创建SQL查询对象语句
	 * @param sql		
	 * @param clazz
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object createSQLQueryOne(String sql,Class clazz,Object[] params,Map<String,?> transform){
		
		Session session= sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		if(transform != null){
			for(String key : transform.keySet()){
				query.addScalar(key,(Type) transform.get(key));
			}
		}
		Object object = query.setResultTransformer(Transformers.aliasToBean(clazz)).uniqueResult();
		clearSession(session);
		return object;
	}
	/**
	 * 创建sql原生查询
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> createNativeSQLQuery(String sql){
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		clearSession(session);
		return list;
	}
	/**
	 *	Hibernate 删除语句
	 * @param sql
	 * @return
	 */
	public Integer deleteSQLUpdate(String sql){
		Session session= sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		Integer colunms = query.executeUpdate();
		clearSession(session);
		return colunms;
	}
	
	/**
	 * 执行原生SQL语句更新
	 * @return
	 */
	public Integer nativeUpdate(String sql){
		Session session= sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		Integer colunms = query.executeUpdate();
		clearSession(session);
		return colunms;
	}
	
	@Override
	public List<?> getResult(String hql, Object[] params) {
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		List<?> list = query.list();
		clearSession(session);
		return list;
	}
	
	/**
	 * 模糊查询
	 * @return
	 */
	public List<?> fuzzyQuery(String hql, Object[] params) {
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length-1; i++){
				query.setParameter(i, params[i]);
			}
			System.out.println(params[params.length-1]);
			query.setString("value", "%" + params[params.length-1] + "%");
		}
		List<?> list = query.list();
		clearSession(session);
		return list;
	}
	/**
	 * 分页模糊查询
	 * @return
	 */
	public List<?> fuzzyQueryByPage(String hql, Object[] params,int offset,int pagesize) {
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length-1; i++){
				query.setParameter(i, params[i]);
			}
			query.setString("value", "%" + params[params.length-1] + "%");
		}
		query.setFirstResult((offset - 1) * pagesize);
		query.setMaxResults(pagesize);
		List<?> list = query.list();
		clearSession(session);
		return list;
	}

	@Override
	public List<?> getResultByPage(String hql, int offset, int pagesize, Object[] params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult((offset - 1) * pagesize);
		query.setMaxResults(pagesize);
		List<?> list = query.list();
		clearSession(session);
		return list;
	}
	/**
	 * 模糊查询记录数
	 * @return
	 */
	public int fuzzyResultCount(String hql,Object[] params){
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length - 1; i++) {
				query.setParameter(i, params[i]);
			}
			query.setString("value", "%" + params[params.length-1] + "%");
		}
		int count = ((Long)query.uniqueResult()).intValue();
		clearSession(session);;
		return count;
	}
	
	/**
	 * 模糊查询记录数
	 */
	public int getResultCount(String hql,Object[] params){
		
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		int count = ((Long)query.uniqueResult()).intValue();
		clearSession(session);;
		return count;
	}
	
	@Override
	public Object getResultOne(String hql, Object[] params) {
		
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		Object obj = query.uniqueResult();
		clearSession(session);
		return obj;
	}

	@Override
	public Object findById(@SuppressWarnings("rawtypes") Class clazz, Serializable id) {
		Session session= sessionFactory.getCurrentSession();
		Object obj = session.load(clazz, id);
		clearSession(session);
		return obj;
	}

	@Override
	public boolean save(Object obj) {
		
		boolean flag = true;
		Session session= sessionFactory.getCurrentSession();
		try {
			session.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}
	
	public boolean saveOrUpdate(Object obj){
		
		boolean flag = true;
		Session session= sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(obj);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		clearSession(session);
		return flag;
	}

	@Override
	public boolean delete(Object obj) {
		boolean flag = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}
	
	@Override
	public boolean update(Object obj) {
		boolean flag = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}
	
	public void updateByParam(String sql,String[] params){
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		query.executeUpdate();
		clearSession(session);
	}
	
	public void update_sql(String sql) {
		Session session= sessionFactory.getCurrentSession();
		session.createSQLQuery(sql).executeUpdate();
		clearSession(session);
	}
	
	public boolean merge(Object obj) {
		boolean flag = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.merge(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}
	
	public void clearSession(Session session){
		session.flush();
		session.clear();
		//session.close();
	}
}
