package com.oracle.course.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Repository;

import com.oracle.course.dao.BaseDao;
import com.oracle.course.dao.UserDao;
import com.oracle.course.models.User;


@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return save(user);
	}

	@Override
	public String getUserToken(String userName, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT drug_admin.IDRUG.login_get_token(?,?) token FROM DUAL";
		List<String> ret = null;
		
        Session session = getSession();
        
        try {
            Query query = session.createSQLQuery(sql);
            query.setString(0, userName);
            query.setString(1, password);
            ret = query.list();
          
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ret != null && ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByToken(String token) {
		// TODO Auto-generated method stub
		List<User> ret = null;
		
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("token", token));
        try {
            ret = criteria.list();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ret != null && ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public Integer updateUser(Date birthday, String email, String token) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Integer flag = null;
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall("drug_admin.IDRUG.change_user_details");
			procedureCall.registerParameter("in_birthday", Date.class,ParameterMode.IN).bindValue(birthday);
			procedureCall.registerParameter("in_eamil", String.class,ParameterMode.IN).bindValue(email);
			procedureCall.registerParameter("in_token", String.class,ParameterMode.IN).bindValue(token);
			procedureCall.registerParameter("flag", Integer.class,ParameterMode.OUT);
			flag = (Integer) procedureCall.getOutputs().getOutputParameterValue("flag");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

}
