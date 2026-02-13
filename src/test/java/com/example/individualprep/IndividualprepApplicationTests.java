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
    void TwoNullVectorsDotProduct() {
        VectorUtility vectorUtility = new VectorUtility();
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(null, null));
    }

    @Test
    void OneNullVectorsDotProduct() {
        double[] v1 = {1, 2, 3};

        VectorUtility vectorUtility = new VectorUtility();
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, null));
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(null, v1));
    }

    @Test
    void DifferentLengthDotProduct() {
        double[] v1 = {1, 2, 3};
        double[] v2 = {1, 2, 3, 4};

        VectorUtility vectorUtility = new VectorUtility();
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));
    }

    @Test
    void testDotProducts1() {
        double[] v1 = {6, 7, 6, 7};
        double[] v2 = {2, 5, 7, 3};

        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(110.0, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProducts2() {
        double[] v1 = {1.23, 2.34, 3.45, 4.56};
        double[] v2 = {0.83, 5.81, 4.20, 0.69};

        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(32.2527, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProducts3() {
        double[] v1 = {-1, -9, -8, -7};
        double[] v2 = {2, -3, 5, -8};

        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(41.0, vectorUtility.dotProduct(v1, v2), 0.0001);
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
        double[] vector1 = {1, 2};
        double[] vector2 = {4, 6};
        double[] vector3 = {7, 8, 9};

        double[] normalResult = vectorUtility.add(vector1, vector2);
        double[] abnormalResult = vectorUtility.add(vector2, vector3);

        assertArrayEquals(new double[]{5, 8}, normalResult);
        assertNull(abnormalResult);
    }

    @Test
    void testSubtractVector() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] vector1 = {1, 2};
        double[] vector2 = {4, 6};
        double[] vector3 = {7, 8, 9};

        double[] normalResult1 = vectorUtility.subtract(vector1, vector2);
        double[] normalResult2 = vectorUtility.subtract(vector2, vector1);

        assertArrayEquals(new double[]{-3, -4}, normalResult1);
        assertArrayEquals(new double[]{3, 4}, normalResult2);
        
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.subtract(vector2, vector3));
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.subtract(null, vector1));
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.subtract(vector1, null));
    }

    @Test
    void testSubtract1() {
        double o1 = 6.9;
        double o2 = 6.7;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(0.2, arithmeticUtility.subtract(o1, o2), 0.0001);
    }

    @Test
    void testSubtract2() {
        double o1 = 127346.283;
        double o2 = 127346.283;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(0, arithmeticUtility.subtract(o1, o2), 0.0001);
    }

    @Test
    void testSubtract3() {
        double o1 = 6.7;
        double o2 = 6.9;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(-0.2, arithmeticUtility.subtract(o1, o2), 0.0001);
    }

    @Test
    void testDivideByZero() {
        double o1 = 6.9;
        double o2 = 0.0;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertThrows(ArithmeticException.class, () -> arithmeticUtility.divide(o1, o2));
    }

    @Test
    void testDivide1() {
        double o1 = 6.9;
        double o2 = 2.0;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(3.45, arithmeticUtility.divide(o1, o2), 0.0001);
    }

    @Test
    void testDivide2() {
        double o1 = 127346.283;
        double o2 = 127346.283;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(1.0, arithmeticUtility.divide(o1, o2), 0.0001);
    }

    @Test
    void testDivide3() {
        double o1 = 1.0;
        double o2 = 3.0;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(0.3333, arithmeticUtility.divide(o1, o2), 0.0001);
    }

    @Test
    void testMultiplyVectorByScalar() {
        VectorUtility vectorUtility = new VectorUtility();

        double[] v1 = {1, 2, 3};
        int scalar = 3;
        double[] expected = {3, 6, 9};
        assertArrayEquals(expected, vectorUtility.multiply(v1, scalar), 0.0001);

        double[] v2 = {-1, -2, 5};
        int scalar2 = 2;
        double[] expected2 = {-2, -4, 10};
        assertArrayEquals(expected2, vectorUtility.multiply(v2, scalar2), 0.0001);

        double[] v3 = {0, 4, 5};
        int scalar3 = 0;
        double[] expected3 = {0, 0, 0};
        assertArrayEquals(expected3, vectorUtility.multiply(v3, scalar3), 0.0001);

        double[] v4 = {};
        int scalar4 = 5;
        double[] expected4 = {};
        assertArrayEquals(expected4, vectorUtility.multiply(v4, scalar4), 0.0001);

        assertThrows(IllegalArgumentException.class, () -> vectorUtility.multiply(null, 3));
    }


    @Test
    void testMultiply1() {
        double o1 = 5;
        double o2 = 4;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(20.0, arithmeticUtility.multiply(o1, o2), 0.0001);
    }

    @Test
    void testMultiply2() {
        double o1 = 5;
        double o2 = 0;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(0.0, arithmeticUtility.multiply(o1, o2), 0.0001);
    }

    @Test
    void testMultiply3() {
        double o1 = -3;
        double o2 = 5;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(-15.0, arithmeticUtility.multiply(o1, o2), 0.0001);
    }

    @Test
    void testMultiply4() {
        double o1 = 3.3;
        double o2 = 2.2;
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        assertEquals(7.26, arithmeticUtility.multiply(o1, o2), 0.0001);
    }

    @Test
    void testNorm1() {
        double[] v1 = {3.0, 4.0};
        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(5.0, vectorUtility.norm(v1), 0.0001);
    }

    @Test
    void testNorm2() {
        double[] v1 = {-1.0, -2.0, -2.0};
        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(3.0, vectorUtility.norm(v1), 0.0001);
    }

    @Test
    void testNorm3() {
        double[] v1 = {0.0, 0.0, 0.0};
        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(0.0, vectorUtility.norm(v1), 0.0001);
    }

    @Test
    void testNormDecimal() {
        double[] v1 = {1.2, 3.4, 5.6};
        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(6.6603, vectorUtility.norm(v1), 0.0001);
    }

    @Test
    void testNormNull() {
        VectorUtility vectorUtility = new VectorUtility();
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.norm(null));
    }
}
