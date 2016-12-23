package com.oracle.course.service;

import java.util.List;

import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.models.BuyRecord;
import com.oracle.course.models.Drug;

public interface DrugService {
	DataWrapper<List<Drug>> getDrugList(String token);
	DataWrapper<Drug> getDrugDetails(Long drugId,String token);
	DataWrapper<Void> buyDrug(Long drugId,Integer amount,String token);
	DataWrapper<List<BuyRecord>> getBuyRecord(String token);

}
