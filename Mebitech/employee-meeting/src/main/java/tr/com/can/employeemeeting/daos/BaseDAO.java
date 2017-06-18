package tr.com.can.employeemeeting.daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tr.com.can.employeemeeting.tools.HibernateUtil;



public abstract class BaseDAO<ID extends Serializable,T>  {

	private final Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDAO(){
		this.entityClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	//private Session session;
	
	
	protected Session getSession() {
		//session = HibernateUtil.getSessionFactory().getCurrentSession();
		//return session;
		return sessionFactory.getCurrentSession();
		
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(this.entityClass);
	}

	public T getByID(ID id) {
		try {
			//getSession().getTransaction().begin();
			T result = (T) getSession().get(entityClass, id);
			//getSession().getTransaction().commit();
			//getSession().close();
			return result;
		} catch (HibernateException e) {
			
			return null;
		}    	
	}
 
    public Boolean create(T entity) {
    	try {
    		//getSession().getTransaction().begin();
    		getSession().persist(entity);
    		//getSession().getTransaction().commit();
    		//getSession().close();
    		return true;
		} catch (HibernateException e) {
			
			return false;
		}
    }
    
    public Boolean update(T entity) {
    	try {
    		//getSession().getTransaction().begin();
    		getSession().update(entity);
    		//getSession().getTransaction().commit();
    		//getSession().close();
    		return true;
		} catch (HibernateException e) {
			
			return false;
		}        
    }
    
    public Boolean delete(T entity) {
    	try {
    		//getSession().getTransaction().begin();
    		getSession().delete(entity);
    		//getSession().getTransaction().commit();
    		//getSession().close();
    		return true;
		} catch (HibernateException e) {
			
			return false;
		}    
    }
    
    
    public List<T> list() {
    	try {
    		//getSession().getTransaction().begin();
    		@SuppressWarnings("unchecked")
			List<T> list = this.createEntityCriteria().list();
    		//getSession().getTransaction().commit();
    		//getSession().close();
    		return list;
		} catch (HibernateException e) {
			
			return null;
		}
    }

}
