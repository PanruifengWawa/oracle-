package com.oracle.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.course.dao.DrugDao;
import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.enums.CodeEnum;
import com.oracle.course.models.BuyRecord;
import com.oracle.course.models.Drug;
import com.oracle.course.service.DrugService;

@Service("drugService")
public class DrugServiceImpl implements DrugService {
	@Autowired
	DrugDao drugDao;

	@Override
	public DataWrapper<List<Drug>> getDrugList(String token) {
		// TODO Auto-generated method stub
		return drugDao.getDrugList();
	}

	@Override
	public DataWrapper<Drug> getDrugDetails(Long drugId, String token) {
		// TODO Auto-generated method stub
		return drugDao.getDrugDetails(drugId);
	}

	@Override
	public DataWrapper<Void> buyDrug(Long drugId, Integer amount, String token) {
		// TODO Auto-generated method stub
		Integer flag = drugDao.buyDrug(drugId, amount, token);
		DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
		if (flag == 0) {
			dataWrapper.setCode(CodeEnum.Fail.getCode());
		}
		return dataWrapper;
	}

	@Override
	public DataWrapper<List<BuyRecord>> getBuyRecord(String token) {
		// TODO Auto-generated method stub
		return drugDao.getBuyRecord(token);
	}

}
