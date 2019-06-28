/*
 * package com.cts.assignment.controller;
 * 
 * import static org.junit.Assert.assertNotNull; import static
 * org.mockito.Mockito.when;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Matchers; import
 * org.mockito.Mock; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.cts.assignment.domian.Records; import
 * com.cts.assignment.service.TransactionService;
 * 
 * @RunWith(SpringRunner.class) public class CustomerReportControllerTest {
 * 
 * @InjectMocks CustomerReportController customerReportController;
 * 
 * @Mock private TransactionService transactionService;
 * 
 * @Mock MultipartFile multipartFile;
 * 
 * @Test public void
 * initiateTransaction_withInValidCsvData_WillProcessAndReturnReport() throws
 * Exception {
 * 
 * when(transactionService.initiateTransaction(Matchers.<Records>any(),
 * Matchers.<ModelAndView>any())) .thenReturn(new ModelAndView());
 * when(multipartFile.isEmpty()).thenReturn(false);
 * when(multipartFile.getBytes()).thenReturn(
 * "Reference,AccountNumber,Description,Start Balance,Mutation,End Balance\n194261,NL91RABO0315273637,Clothes from Jan Bakker,21.6,-41.83,-20.23"
 * .getBytes());
 * when(multipartFile.getOriginalFilename()).thenReturn("file.csv");
 * assertNotNull(customerReportController.singleFileUpload(multipartFile)); }
 * 
 * @Test public void
 * initiateTransaction_withInValidXmlData_willProcessAndReturnReport() throws
 * Exception {
 * 
 * when(transactionService.initiateTransaction(Matchers.<Records>any(),
 * Matchers.<ModelAndView>any())) .thenReturn(new ModelAndView());
 * when(multipartFile.isEmpty()).thenReturn(false);
 * when(multipartFile.getBytes()).thenReturn(
 * "<records><record reference=\"130498\"><accountNumber>NL69ABNA0433647324</accountNumber><description>Tickets for Peter Theuß</description><startBalance>26.9</startBalance><mutation>-18.78</mutation><endBalance>8.12</endBalance></record></records>"
 * .getBytes());
 * when(multipartFile.getOriginalFilename()).thenReturn("file.xml");
 * assertNotNull(customerReportController.singleFileUpload(multipartFile)); }
 * 
 * @Test public void
 * initiateTransaction_withInValidCsvData_willReturnErrorReport() throws
 * Exception {
 * 
 * when(transactionService.initiateTransaction(Matchers.<Records>any(),
 * Matchers.<ModelAndView>any())) .thenReturn(new ModelAndView());
 * when(multipartFile.isEmpty()).thenReturn(false);
 * when(multipartFile.getBytes()).thenReturn("InvalidString".getBytes());
 * when(multipartFile.getOriginalFilename()).thenReturn("file.xml");
 * assertNotNull(customerReportController.singleFileUpload(multipartFile)); }
 * 
 * @Test public void
 * initiateTransaction_withEmptyCsvData_willProcessAndReturnErrorReport() throws
 * Exception {
 * 
 * when(transactionService.initiateTransaction(Matchers.<Records>any(),
 * Matchers.<ModelAndView>any())) .thenReturn(new ModelAndView());
 * when(multipartFile.isEmpty()).thenReturn(true);
 * assertNotNull(customerReportController.singleFileUpload(multipartFile)); }
 * 
 * @Test public void callIndex_willReturnIndexPath() throws Exception {
 * 
 * assertNotNull(customerReportController.index()); }
 * 
 * @Test public void getCsvReport_willReturnReportPath() throws Exception {
 * 
 * assertNotNull(customerReportController.getCsvReport()); }
 * 
 * @Test public void getTransactionReport_willReturnReportPath() throws
 * Exception {
 * 
 * assertNotNull(customerReportController.getTransactionReport()); } }
 */