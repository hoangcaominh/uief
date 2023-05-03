package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.*;

import uief.Uief;

class UiefTest {
	private Uief testObject;

	@BeforeEach
	void setUp() throws Exception {
		testObject = new Uief();
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testMessage1() {
		String message = "Hello World!";
		BigDecimal result = new BigDecimal("0.072101108108111032087111114108100033");

		assertEquals(testObject.encode(message), result);
		assertEquals(testObject.decode(result), message);
	}
	
	@Test
	void testEmptyMessage() {
		String message = "";
		BigDecimal result = BigDecimal.ZERO;
		
		assertEquals(testObject.encode(message), result);
		assertEquals(testObject.decode(result), message);
	}

}
