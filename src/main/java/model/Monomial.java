package model;

public class Monomial implements Comparable<Monomial>{
    private int coefficient;
    private float coefI;
    private int exponent;

    public Monomial(float coefI, int exponent){
        this.coefI = coefI;
        this.exponent = exponent;
    }

    public Monomial(int coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public float getCoefI() {
        return coefI;
    }

    public void setCoefI(float coefI) {
        this.coefI = coefI;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public String toString1(){
        String x = "x";
        String pow = "^";
        String exp = String.valueOf(this.exponent);
        String coef;
        if((int)this.coefI == this.coefI){
            coef = String.valueOf((int)this.coefI);
        }else{
            coef = String.valueOf((float) Math.round(this.coefI * 100) / 100);
        }
        if(this.exponent == 0){
            x = "";
            exp = "";
            pow = "";
        }
        if(this.exponent == 1){
            exp = "";
            pow = "";
        }
        if(this.coefI == 1  && x.equals("x")){
            coef = "";
        }
        if(this.coefI == -1 && x.equals("x")){
            coef = "-";
        }
        if(this.coefI == 0){
            coef = "";
            x = "";
            pow = "";
            exp = "";
        }
        return (coef + x + pow + exp);
    }

    public String toString(){
        String x = "x";
        String pow = "^";
        String exp = String.valueOf(this.exponent);
        String coef = String.valueOf(this.coefficient);
        if(this.exponent == 0){
            x = "";
            exp = "";
            pow = "";
        }
        if(this.exponent == 1){
            exp = "";
            pow = "";
        }
        if(this.coefficient == 1 && x.equals("x")){
            coef = "";
        }
        if(this.coefficient == -1 && x.equals("x")){
            coef = "-";
        }
        if(this.coefficient == 0){
            coef = "";
            x = "";
            pow = "";
            exp = "";
        }
        return (coef + x + pow + exp);
    }

    public boolean equalsM(Monomial m2){
        if(this.coefficient == m2.coefficient && this.exponent == m2.exponent)
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Monomial o) {
        return (o.exponent - this.exponent);
    }
}
