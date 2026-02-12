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
	void TwoNullVectorsDotProduct(){
		VectorUtility vectorUtility = new VectorUtility();
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(null, null));
	}

	@Test
	void OneNullVectorsDotProduct(){
		double[] v1 = {1, 2, 3};

		VectorUtility vectorUtility = new VectorUtility();
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, null));
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(null, v1));
	}

	@Test
	void DifferentLengthDotProduct(){
		double[] v1 = {1, 2, 3};
		double[] v2 = {1, 2, 3, 4};

		VectorUtility vectorUtility = new VectorUtility();
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));
	}

	@Test
	void testDotProducts1(){
		double[] v1 = {6, 7, 6, 7};
		double[] v2 = {2, 5, 7, 3};

		VectorUtility vectorUtility = new VectorUtility();
		assertEquals(110.0, vectorUtility.dotProduct(v1,v2), 0.0001);
	}

	@Test
	void testDotProducts2(){
		double[] v1 = {1.23, 2.34, 3.45, 4.56};
		double[] v2 = {0.83, 5.81, 4.20, 0.69};

		VectorUtility vectorUtility = new VectorUtility();
		assertEquals(32.2527, vectorUtility.dotProduct(v1,v2), 0.0001);
	}

	@Test
	void testDotProducts3(){
		double[] v1 = {-1, -9, -8, -7};
		double[] v2 = {2, -3, 5, -8};

		VectorUtility vectorUtility = new VectorUtility();
		assertEquals(41.0, vectorUtility.dotProduct(v1,v2), 0.0001);
	}

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

	@Test
	void testSubtract1() {
		double o1 = 6.9;
		double o2 = 6.7;
		ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
		assertEquals(0.2, arithmeticUtility.subtract(o1,o2), 0.0001);
	}

	@Test
	void testSubtract2() {
		double o1 = 127346.283;
		double o2 = 127346.283;
		ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
		assertEquals(0, arithmeticUtility.subtract(o1,o2), 0.0001);
	}

	@Test
	void testSubtract3() {
		double o1 = 6.7;
		double o2 = 6.9;
		ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
		assertEquals(-0.2, arithmeticUtility.subtract(o1,o2), 0.0001);
	}
}
