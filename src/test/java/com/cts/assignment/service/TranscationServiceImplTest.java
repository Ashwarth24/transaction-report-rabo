/*
 * package com.cts.assignment.service;
 * 
 * import static org.junit.Assert.assertNotNull;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import javax.xml.bind.JAXBException;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.cts.assignment.domian.Record; import
 * com.cts.assignment.domian.Records;
 * 
 *//**
	 * Unit test for {@link TranscationServiceImpl}
	 * 
	 * @author Ashwarth Gangarapu
	 *//*
		 * @RunWith(SpringRunner.class) public class TranscationServiceImplTest {
		 * 
		 * @InjectMocks TranscationServiceImpl transcationServiceImpl;
		 * 
		 * @Test public void test_withValidRecords_willReturnInValidTransactionReport()
		 * throws JAXBException {
		 * 
		 * Records records = new Records(); List<Record> transactionRecords = new
		 * ArrayList<Record>(); transactionRecords.add(new Record("123",
		 * "accountNumber", "description", "5", "15", "10")); transactionRecords.add(new
		 * Record("123", "accountNumber", "description", "5", "15", "10"));
		 * records.setRecord(transactionRecords); ModelAndView modelAndView = new
		 * ModelAndView(); modelAndView =
		 * transcationServiceImpl.initiateTransaction(records, modelAndView);
		 * assertNotNull(modelAndView.getModel().get("inValidTransactions")); }
		 * 
		 * @Test public void test_withValidRecords_willReturnTransactionReport() throws
		 * JAXBException {
		 * 
		 * Records records = new Records();
		 * 
		 * Record record = new Record();
		 * 
		 * record.setAccountNumber("accountNumber"); record.setReference("121");
		 * record.setDescription("description"); record.setMutation("5");
		 * record.setStartBalance("10"); record.setEndBalance("15"); List<Record>
		 * transactionRecords = new ArrayList<Record>(); transactionRecords.add(record);
		 * records.setRecord(transactionRecords); ModelAndView modelAndView = new
		 * ModelAndView(); modelAndView =
		 * transcationServiceImpl.initiateTransaction(records, modelAndView);
		 * assertNotNull(modelAndView.getModel().get("validTransactions")); } }
		 */