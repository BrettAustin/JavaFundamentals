public class Fraction {
    private int numerator, denominator;
    public static final int DEFAULT_NUMERATOR = 1;

    public Fraction(int numParam, int denomParam){
        numerator = numParam;
        denominator = denomParam;
    }

    public Fraction(int denomParam){
        this(DEFAULT_NUMERATOR,denomParam);
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public void setNumerator(int numParam){
        numerator = numParam;
    }

    public void setDenominator(int denomParam){
        if (denomParam !=0) {
            denominator = denomParam;
        } else {
            System.out.println("Invalid input - denominator cannot be zero");
        }
    }

    public String toString(){
        return numerator +"/" + denominator;
    }

    public double getValue(){
        return (float)numerator/denominator;
    }

    public boolean isReduced(){
        return findGreatestCommonFactor(numerator, denominator) ==1;
    }

    private int findGreatestCommonFactor(int num1, int num2){
        int greatestCommonFactor = 1;
        int maxFactorToCheck = findSmaller(num1, num2);

        for(int possibleFactor = 2;possibleFactor <= greatestCommonFactor; possibleFactor++){
            if(num1%possibleFactor == 0 && num2%possibleFactor ==0){
                greatestCommonFactor = possibleFactor;
            }
        }

        return  greatestCommonFactor;
    }

    private int findSmaller (int num1, int num2){
        if (num1 < num2){
            return num1;
        }else { //num2 is smaller or they are the same
            return num2;
        }
    }

    public void reduce(){
        if(!isReduced()){
            int greatestCommonFactor = findGreatestCommonFactor(numerator, denominator);
            this.numerator = numerator/greatestCommonFactor;
            this.denominator = denominator/greatestCommonFactor;
        }
    }

    public int findLeastCommonDenominator(Fraction otherFraction){
        int leastCommonDenominatorTop = this.denominator * otherFraction.denominator;
        int leastCommonDenominatorBottom = findGreatestCommonFactor(this.denominator,otherFraction.denominator);
        return  leastCommonDenominatorTop/leastCommonDenominatorBottom;
    }

    public static Fraction reducedFraction(Fraction fraction){
        Fraction reducedFraction = new Fraction(fraction.numerator, fraction.denominator);
        reducedFraction.reduce();
        return reducedFraction;
    }

}
