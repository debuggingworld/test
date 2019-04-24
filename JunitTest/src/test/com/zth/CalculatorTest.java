package test.com.zth; 

import com.zth.Calculator;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

@Before
public void before() throws Exception {
    calculator.clear();
}

@Test
public void testAdd() throws Exception {
    calculator.add(2);
    calculator.add(2);
    assertEquals(4,calculator.getResult());
}

@Test
public void testSubstract() throws Exception {
    calculator.add(5);
    calculator.substract(2);
    assertEquals(3,calculator.getResult());
}
@Test
public void testMultiply() throws Exception {
    calculator.add(2);
    calculator.multiply(2);
    assertEquals(4,calculator.getResult());
}
@Test
public void testDivide() throws Exception {
    calculator.add(9);
    calculator.divide(3);
    assertEquals(3,calculator.getResult());
}
} 
