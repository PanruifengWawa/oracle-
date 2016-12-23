package com.oracle.course.dao.impl;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.xml.crypto.dsig.Transform;

import org.hibernate.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.oracle.course.dao.BaseDao;
import com.oracle.course.dao.DrugDao;
import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.models.BuyRecord;
import com.oracle.course.models.Drug;

@Repository
public class DrugDaoImpl extends BaseDao<Drug> implements DrugDao {

	@Override
	public DataWrapper<List<Drug>> getDrugList() {
		// TODO Auto-generated method stub
		DataWrapper<List<Drug>> dataWrapper = new DataWrapper<List<Drug>>();
		List<Drug> list = null;
		Session session = getSession();
		Criteria criteria = session.createCriteria(Drug.class);
		try {
			list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		dataWrapper.setData(list);
		return dataWrapper;
	}

	@Override
	public DataWrapper<Drug> getDrugDetails(Long drugId) {
		// TODO Auto-generated method stub
		DataWrapper<Drug> dataWrapper = new DataWrapper<Drug>();
		List<Drug> list = null;
		Session session = getSession();
		Criteria criteria = session.createCriteria(Drug.class);
		criteria.add(Restrictions.eq("id", drugId));
		try {
			list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (list != null && list.size() > 0) {
			dataWrapper.setData(list.get(0));
		}
		
		return dataWrapper;
	}

	@Override
	public Integer buyDrug(Long drugId, Integer amount, String token) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Integer flag = null;
		try {
			ProcedureCall procedureCall = session.createStoredProcedureCall("drug_admin.IDRUG.bug_drug");
			procedureCall.registerParameter("in_drug_id", Long.class,ParameterMode.IN).bindValue(drugId);
			procedureCall.registerParameter("in_amount", Integer.class,ParameterMode.IN).bindValue(amount);
			procedureCall.registerParameter("in_token", String.class,ParameterMode.IN).bindValue(token);
			procedureCall.registerParameter("flag", Integer.class,ParameterMode.OUT);
			flag = (Integer) procedureCall.getOutputs().getOutputParameterValue("flag");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public DataWrapper<List<BuyRecord>> getBuyRecord(String token) {
		// TODO Auto-generated method stub
		DataWrapper<List<BuyRecord>> dataWrapper = new DataWrapper<List<BuyRecord>>();
		List<BuyRecord> list = null;
		String sql = "select drug_name name,idate idate,price price,amount amount from drug_admin.user_buy_record where token = ?";
		Session session = getSession();
		Query query = session.createSQLQuery(sql)
				.addScalar("name", StandardBasicTypes.STRING)
				.addScalar("idate", StandardBasicTypes.DATE)
				.addScalar("price", StandardBasicTypes.DOUBLE)
				.addScalar("amount", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(BuyRecord.class));
		query.setString(0, token);
		try {
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		dataWrapper.setData(list);
		return dataWrapper;
	}

}
