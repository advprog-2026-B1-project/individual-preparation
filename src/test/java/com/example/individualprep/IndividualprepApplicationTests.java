package com.example.individualprep;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.individualprep.service.VectorUtility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
