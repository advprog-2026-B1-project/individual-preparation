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

	@Test
	void testAddVector() {
		VectorUtility vectorUtility = new VectorUtility();
		double[] vector1 = {1,2};
		double[] vector2 = {4,6};
		double[] vector3 = {7,8,9};

		double[] normalResult = vectorUtility.add(vector1, vector2);
		double[] abnormalResult = vectorUtility.add(vector2, vector3);

		assertArrayEquals(new double[]{5,8}, normalResult);
		assertNull(abnormalResult);
	}
}
