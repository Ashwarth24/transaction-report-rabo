package com.cts.assignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomerTransactionReportTest {

	@InjectMocks
	CustomerTransactionReport customerTransactionReport;

	@Mock
	SpringApplicationBuilder springApplicationBuilder;

	@Test
	public void configure() {
		customerTransactionReport.configure(springApplicationBuilder);
	}

	@Test
	public void main() throws Exception {
		CustomerTransactionReport.main(new String[] {});
	}
}
