import model.Polynomial;
import org.junit.jupiter.api.*;

import java.util.ArrayList;


public class TestPolynomial {

    Polynomial p1;
    Polynomial p2;
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;


    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
    }

    @Test
    public void testAddition(){
        p1 = new Polynomial("4x^5-3x^4+x^2-8x+1");
        p2 = new Polynomial("3x^4-x^3+x^2+2x-1");
        Polynomial addRes = new Polynomial("4x^5-x^3+2x^2-6x");
        Assertions.assertTrue(addRes.equalsP(p1.add(p2)));
        nrTesteCuSucces++;
    }

    @Test
    public void testSubtraction(){
        p1 = new Polynomial("4x^5-3x^4+x^2-8x+1");
        p2 = new Polynomial("3x^4-x^3+x^2+2x-1");
        Polynomial subRes = new Polynomial("4x^5-6x^4+x^3-10x+2");
        Assertions.assertTrue(subRes.equalsP(p1.subtract(p2)));
        nrTesteCuSucces++;
    }

    @Test
    public void testMultiplication(){
        p1 = new Polynomial("3x^2-x+1");
        p2 = new Polynomial("x-2");
        Polynomial mulRes = new Polynomial("3x^3-7x^2+3x-2");
        Assertions.assertTrue(mulRes.equalsP(p1.multiply(p2)));
        nrTesteCuSucces++;
    }

    @Test
    public void testDivision(){
        p1 = new Polynomial("x^3-2x^2+6x-5");
        p2 = new Polynomial("x^2-1");
        ArrayList<Polynomial> results = p1.divide(p2);
        Polynomial quotient = new Polynomial("x-2");
        Polynomial remainder = new Polynomial("7x-7");
        Assertions.assertTrue(results.get(0).equalsP(quotient));
        Assertions.assertTrue(results.get(1).equalsP(remainder));
        nrTesteCuSucces++;
    }

    @Test
    public void testDerivation(){
        p1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial result = new Polynomial("3x^2-4x+6");
        Assertions.assertTrue(p1.derive().equalsP(result));
        nrTesteCuSucces++;
    }

    @Test
    public void testIntegration(){
        p1 = new Polynomial("x^3+4x^2+5");
        String result = "0.25x^4+1.33x^3+5x+C";
        Assertions.assertTrue(p1.integrate().toString1().equals(result));
        nrTesteCuSucces++;
    }
}
