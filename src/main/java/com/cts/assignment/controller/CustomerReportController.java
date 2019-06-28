package com.cts.assignment.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.assignment.domian.Record;
import com.cts.assignment.domian.Records;
import com.cts.assignment.service.TransactionService;
import com.cts.assignment.util.CommonUtil;

/**
 * Customer Report Rest Controller used for mapping report related requests
 * 
 * @author Ashwarth Gangarapu
 *
 */
@RestController
@RequestMapping("/transaction")
public class CustomerReportController {

	@Autowired
	TransactionService transactionService;

	private static Logger applicationLog = LoggerFactory.getLogger(CustomerReportController.class);

	
	@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Map<String, ArrayList<Record>> singleFileUpload(@RequestParam("file") MultipartFile file)
			throws JAXBException, IOException {

		Map<String, ArrayList<Record>> result = new HashMap<>();
		if (file.isEmpty()) {
			return result;
		}

		try {

			StringReader fileContent = new StringReader(new String(file.getBytes()));

			Records records = null;

			if (file.getOriginalFilename().endsWith(".xml")) {
				records = (Records) CommonUtil.parseXml(fileContent, Records.class);
			} else {
				records = CommonUtil.parseCSV(fileContent);
			}

			applicationLog.info("Transaction Records : {}", records.getRecord());

			result = transactionService.initiateTransaction(records);

			applicationLog.info("Transaction Sucessfully Completed!! ");

		} catch (Exception e) {

			applicationLog.error("Error occured while processing :{}", e.getMessage());
		}

		return result;
	}

}