package com.oracle.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.models.BuyRecord;
import com.oracle.course.models.Drug;
import com.oracle.course.service.DrugService;

@Controller
@RequestMapping(value="v1/api/drug")
public class DrugController {
	
	@Autowired
	DrugService drugService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<Drug>> getDrugList(
    		@RequestParam(value = "token", required = true) String token) {
        return drugService.getDrugList(token);
    }
	
	@RequestMapping(value="/{drugId}", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<Drug> details(
    		@PathVariable(value="drugId") Long drugId,
    		@RequestParam(value = "token", required = true) String token) {
        return drugService.getDrugDetails(drugId, token);
    }

	@RequestMapping(value="/{drugId}", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> buyDrug(
    		@PathVariable(value="drugId") Long drugId,
    		@RequestParam(value = "amount", required = true) Integer amount,
    		@RequestParam(value = "token", required = true) String token) {
        return drugService.buyDrug(drugId, amount, token);
    }
	
	@RequestMapping(value="/buy_record", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<BuyRecord>> getBuyRecord(
    		@RequestParam(value = "token", required = true) String token) {
        return drugService.getBuyRecord(token);
    }
}
