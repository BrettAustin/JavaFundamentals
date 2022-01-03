import org.w3c.dom.ls.LSOutput;

public class FractionTester {
    public static void main(String[] args) {

        Fraction frac1 = new Fraction(2);
        Fraction frac2 = new Fraction(2,3);
        Fraction frac3 = new Fraction(2,5);

/*
        System.out.println(frac1.getNumerator());
        System.out.println(frac2.getNumerator());
        System.out.println(frac3.getNumerator());
        System.out.println(frac1.getDenominator());
        System.out.println(frac2.getDenominator());
        System.out.println(frac3.getDenominator());

 */

        frac3.setDenominator(10);
        System.out.println(frac3.getDenominator());
        System.out.println(frac3);
        System.out.println(frac3.getValue());
    }
}
