package com.vlkan.nullcheck;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.assertTrue;

public class NullMonitorTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testNonnullArg() throws Exception {
		Main.main(new String[] { "Volkan" });
		assertTrue(outputCapture.toString().contains("Hello, Volkan!"));
	}

	@Test
	public void testNullArg() throws Exception {
		try { Main.main(new String[] { "null" }); }
		catch (IllegalStateException ise) {
			Throwable cause = ise.getCause();
			assertTrue("cause is an NPE", cause instanceof NullPointerException);
			assertTrue("expected NPE message", cause.getMessage().contains(
					"public void com.vlkan.nullcheck.service.SampleService.sayHello(java.lang.String): " +
							"argument \"to\" (at position 0) cannot be null"));
		}
	}

}
