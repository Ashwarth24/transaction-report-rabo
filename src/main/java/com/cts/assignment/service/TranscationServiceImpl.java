package com.cts.assignment.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;

import com.cts.assignment.domian.Record;
import com.cts.assignment.domian.Records;

@Service
public class TranscationServiceImpl implements TransactionService {

	@Override
	public Map<String, ArrayList<Record>> initiateTransaction(Records records) throws JAXBException {

		Map<String, ArrayList<Record>> result = new HashMap<>();
		ArrayList<Record> validRecords = new ArrayList<>();
		ArrayList<Record> inValidRecords = new ArrayList<>();

		records.getRecord().forEach(record ->

		{

			double endBalence = Double.parseDouble(record.getStartBalance()) + Double.parseDouble(record.getMutation());

			// precession conververion for accurate value
			endBalence = BigDecimal.valueOf(endBalence).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

			boolean isReferenceExists = validRecords.stream()
					.anyMatch(validRecord -> validRecord.getReference().equals(record.getReference()));

			if (endBalence == Double.parseDouble(record.getEndBalance()) && !isReferenceExists) {
				validRecords.add(record);
			}

			else {
				inValidRecords.add(record);
			}

		});

		result.put("validTransactions", validRecords);
		result.put("inValidTransactions", inValidRecords);

		return result;
	}

	/**
	 * This method is used to validate the transaction
	 * 
	 * @param record
	 *//*
		 * private void validateTransaction(Record record) {
		 * 
		 * List<Record> validRecords = new ArrayList<>(); List<Record> inValidRecords =
		 * new ArrayList<>();
		 * 
		 * inValidRecords = new ArrayList<>();
		 * 
		 * double endBalence = Double.parseDouble(record.getStartBalance()) +
		 * Double.parseDouble(record.getMutation());
		 * 
		 * //precession conververion for accurate value endBalence =
		 * BigDecimal.valueOf(endBalence).setScale(2,
		 * BigDecimal.ROUND_HALF_UP).doubleValue();
		 * 
		 * boolean isReferenceExists = validRecords.stream() .anyMatch(validRecord ->
		 * validRecord.getReference().equals(record.getReference()));
		 * 
		 * if (endBalence == Double.parseDouble(record.getEndBalance()) &&
		 * !isReferenceExists) { validRecords.add(record); }
		 * 
		 * else { inValidRecords.add(record); } }
		 */
}
