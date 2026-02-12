package com.example.individualprep;

import com.example.individualprep.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IndividualprepApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testExponentArithmetic() {
		ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
		double a = 5;
		int b = 2;

		double result = arithmeticUtility.exponent(a, b);
		assertEquals(25, result);
	}
}
