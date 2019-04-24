package test.com.zth;

import com.zth.Triangle;

import static org.junit.Assert.*;

public class TriangleTest
{
    public static void test1()
    {
        Triangle triangle = new Triangle(2, 3, 6);
        String actualType = triangle.getType(triangle);
        String expectedType = "Illegal";
        assertEquals(expectedType, actualType);
    }

    public static void test2()
    {
        Triangle triangle = new Triangle(3, 3, 3);
        String actualType = triangle.getType(triangle);
        String expectedType = "Regular";
        assertEquals(expectedType, actualType);
    }

    public static void test3()
    {
        Triangle triangle = new Triangle(2, 3, 4);
        String actualType = triangle.getType(triangle);
        String expectedType = "Scalene";
        assertEquals(expectedType, actualType);
    }

    public static void test4()
    {
        Triangle triangle = new Triangle(3, 3, 4);
        String actualType = triangle.getType(triangle);
        String expectedType = "Isosceles";
        assertEquals(expectedType, actualType);
    }

    public static void test5()
    {
        Triangle triangle = new Triangle(-1, 3, 4);
        String actualType = triangle.getType(triangle);
        String expectedType = "Illegal";
        assertEquals(expectedType, actualType);
    }
    public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		
	}
}
