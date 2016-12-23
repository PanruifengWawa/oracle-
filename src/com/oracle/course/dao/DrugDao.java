package com.oracle.course.dao;

import java.util.List;

import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.models.BuyRecord;
import com.oracle.course.models.Drug;

public interface DrugDao {
	DataWrapper<List<Drug>> getDrugList();
	DataWrapper<Drug> getDrugDetails(Long drugId);
	Integer buyDrug(Long drugId, Integer amount, String token);
	DataWrapper<List<BuyRecord>> getBuyRecord(String token);
}
