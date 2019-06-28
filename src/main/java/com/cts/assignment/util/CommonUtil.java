package com.cts.assignment.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import com.cts.assignment.domian.Record;
import com.cts.assignment.domian.Records;

/**
 * This is common utility class for reusable methods
 * 
 * @author Ashwarth Gangarapu
 * 
 */
public class CommonUtil {

	private CommonUtil() {

	}

	/**
	 * Generic method to unmarshall the xml
	 * 
	 * @param fileContent
	 * @param clazz
	 * @return Object of type clazz
	 * @throws JAXBException
	 */
	public static <T> Object parseXml(StringReader fileContent, Class<T> clazz) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return jaxbUnmarshaller.unmarshal(fileContent);
	}

	/**
	 * This method parses the csv data to {@link Records}
	 * 
	 * @param inputData
	 * @return {@link Record}
	 * @throws IOException
	 */
	public static Records parseCSV(StringReader inputData) throws IOException {

		Records records = new Records();

		try (CSVParser csvParser = new CSVParser(inputData,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Record> record = new ArrayList<>();
			csvParser.forEach(csvRecord -> record.add(
					new Record(csvRecord.get("Reference"), csvRecord.get("AccountNumber"), csvRecord.get("Description"),
							csvRecord.get("Mutation"), csvRecord.get("End Balance"), csvRecord.get("Start Balance"))));
			records.setRecord(record);
		}

		return records;
	}

}
