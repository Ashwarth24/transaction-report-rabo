package com.cts.assignment.service;

import java.util.ArrayList;
import java.util.Map;

import javax.xml.bind.JAXBException;

import com.cts.assignment.domian.Record;
import com.cts.assignment.domian.Records;

/**
 * Interface for TransactionService
 * 
 * @author Ashwarth Gangarapu
 *
 */
public interface TransactionService {

	/**
	 * This method is used to perform the transaction
	 *  
	 * @param records
	 * @param modelAndView
	 * @return ModelAndView
	 * @throws JAXBException
	 */
	public Map<String, ArrayList<Record>> initiateTransaction(Records records) throws JAXBException;
}
