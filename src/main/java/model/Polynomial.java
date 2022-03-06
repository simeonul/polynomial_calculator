package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> polynomial = new ArrayList<Monomial>();

    public Polynomial(ArrayList<Monomial> list) {
        this.polynomial = list;
    }

    public Polynomial(String input) {
        Pattern polynomePattern = Pattern.compile("(?=.+)([+-]?[0-9]*(?:\\*?x(?:\\^[0-9]+)?)?)");
        Matcher polynomeMatcher = polynomePattern.matcher(input);
        while (polynomeMatcher.find()) {
            //System.out.println("Poly : " + polynomeMatcher.group());
            Pattern monomePattern = Pattern.compile("(?=.+)([+-]?[0-9]*)(x?)(?:\\^?)([0-9]*?)");
            Matcher monomeMatcher = monomePattern.matcher(polynomeMatcher.group());
            if (monomeMatcher.matches()) {
                int exponent = 0;
                int coefficient = 1;
                if (monomeMatcher.group(1).equals("-")) {
                    coefficient = -1;
                }
                if (monomeMatcher.group(1).length() >= 2 ||
                        (monomeMatcher.group(1).length() == 1 && !monomeMatcher.group(1).equals("-") && !monomeMatcher.group(1).equals("+"))) {
                    coefficient = Integer.parseInt(monomeMatcher.group(1));
                }
                if (monomeMatcher.group(2).equals("x") && monomeMatcher.group(3).equals("")) {
                    exponent = 1;
                }
                if (!monomeMatcher.group(3).equals("")) {
                    exponent = Integer.valueOf(monomeMatcher.group(3));
                }
                Monomial newMonomial = new Monomial(coefficient, exponent);
                this.polynomial.add(newMonomial);
                Collections.sort(this.polynomial);
                //System.out.println("Coeficient : " + coefficient + " " + monomeMatcher.group(2) + " Exponent : " + exponent);
            }
        }
    }

    public ArrayList<Monomial> getPolynomial() {
        return polynomial;
    }

    public Polynomial add(Polynomial p) {
        int thisIt = 0;
        int pIt = 0;
        int exp = 0;
        int coef = 0;
        ArrayList<Monomial> newPolynomial = new ArrayList<Monomial>();
        while (thisIt < this.polynomial.size() && pIt < p.polynomial.size()) {
            if (this.polynomial.get(thisIt).getExponent() > p.polynomial.get(pIt).getExponent()) {
                exp = this.polynomial.get(thisIt).getExponent();
                coef = this.polynomial.get(thisIt).getCoefficient();
                thisIt++;
            } else if (this.polynomial.get(thisIt).getExponent() < p.polynomial.get(pIt).getExponent()) {
                exp = p.polynomial.get(pIt).getExponent();
                coef = p.polynomial.get(pIt).getCoefficient();
                pIt++;
            } else {
                exp = this.polynomial.get(thisIt).getExponent();
                coef = this.polynomial.get(thisIt).getCoefficient() + p.polynomial.get(pIt).getCoefficient();
                thisIt++;
                pIt++;
            }
            if(coef != 0){
                Monomial newMonomial = new Monomial(coef, exp);
                newPolynomial.add(newMonomial);
            }
        }
        while (thisIt < this.polynomial.size()) {
            Monomial newMonomial = new Monomial(this.polynomial.get(thisIt).getCoefficient(), this.polynomial.get(thisIt).getExponent());
            newPolynomial.add(newMonomial);
            thisIt++;
        }
        while (pIt < p.polynomial.size()) {
            Monomial newMonomial = new Monomial(p.polynomial.get(pIt).getCoefficient(), p.polynomial.get(pIt).getExponent());
            newPolynomial.add(newMonomial);
            pIt++;
        }
        Collections.sort(newPolynomial);
        Polynomial addResult = new Polynomial(newPolynomial);
        return addResult;
    }

    public Polynomial subtract(Polynomial p) {
        int thisIt = 0;
        int pIt = 0;
        int exp = 0;
        int coef = 0;
        ArrayList<Monomial> newPolynomial = new ArrayList<Monomial>();
        while (thisIt < this.polynomial.size() && pIt < p.polynomial.size()) {
            if (this.polynomial.get(thisIt).getExponent() > p.polynomial.get(pIt).getExponent()) {
                exp = this.polynomial.get(thisIt).getExponent();
                coef = this.polynomial.get(thisIt).getCoefficient();
                thisIt++;
            } else if (this.polynomial.get(thisIt).getExponent() < p.polynomial.get(pIt).getExponent()) {
                exp = p.polynomial.get(pIt).getExponent();
                coef = -p.polynomial.get(pIt).getCoefficient();
                pIt++;
            } else {
                exp = this.polynomial.get(thisIt).getExponent();
                coef = this.polynomial.get(thisIt).getCoefficient() - p.polynomial.get(pIt).getCoefficient();
                thisIt++;
                pIt++;
            }
            if(coef != 0){
                Monomial newMonomial = new Monomial(coef, exp);
                newPolynomial.add(newMonomial);
            }
        }
        while (thisIt < this.polynomial.size()) {
            Monomial newMonomial = new Monomial(this.polynomial.get(thisIt).getCoefficient(), this.polynomial.get(thisIt).getExponent());
            newPolynomial.add(newMonomial);
            thisIt++;
        }
        while (pIt < p.polynomial.size()) {
            Monomial newMonomial = new Monomial(p.polynomial.get(pIt).getCoefficient(), p.polynomial.get(pIt).getExponent());
            newPolynomial.add(newMonomial);
            pIt++;
        }
        Collections.sort(newPolynomial);
        Polynomial subResult = new Polynomial(newPolynomial);
        return subResult;
    }

    public Polynomial multiply(Polynomial p) {
        ArrayList<Monomial> mons = new ArrayList<Monomial>();
        for (Monomial mon1 : this.polynomial) {
            for (Monomial mon2 : p.polynomial) {
                int coef = mon1.getCoefficient() * mon2.getCoefficient();
                int exp = mon1.getExponent() + mon2.getExponent();
                if(coef != 0){
                    Monomial newMon = new Monomial(coef, exp);
                    mons.add(newMon);
                }
            }
        }
        int i, j;
        for (i = 0; i < mons.size(); i++) {
            for (j = i + 1; j < mons.size(); j++) {
                if (mons.get(i).getExponent() == mons.get(j).getExponent()) {
                    mons.get(i).setCoefficient(mons.get(i).getCoefficient() + mons.get(j).getCoefficient());
                    mons.remove(mons.get(j));
                }
            }
        }
        Collections.sort(mons);
        Polynomial multResult = new Polynomial(mons);
        return multResult;
    }

    public Polynomial derive() {
        ArrayList<Monomial> res = new ArrayList<Monomial>();
        for (Monomial mon : this.polynomial) {
            int coef = mon.getCoefficient() * mon.getExponent();
            int exp = mon.getExponent() - 1;
            if(coef != 0){
                Monomial newMon = new Monomial(coef, exp);
                res.add(newMon);
            }
        }
        Collections.sort(res);
        Polynomial derResult = new Polynomial(res);
        return derResult;
    }

        public ArrayList<Polynomial> divide(Polynomial p){
        Polynomial big;
        Polynomial small;
        if (this.polynomial.get(0).getExponent() >= p.polynomial.get(0).getExponent()) {
            big = this;
            small = p;
        } else {
            big = p;
            small = this;
        }
        Polynomial quotient = new Polynomial("0");
        Polynomial remainder = big;
        ArrayList<Polynomial> result = new ArrayList<Polynomial>();
        while(remainder.polynomial.size() > 0 && remainder.polynomial.get(0).getExponent() >= small.polynomial.get(0).getExponent()){
            int exp = remainder.getPolynomial().get(0).getExponent() - small.getPolynomial().get(0).getExponent();
            int coef = remainder.getPolynomial().get(0).getCoefficient() / small.polynomial.get(0).getCoefficient();
            Monomial newMonomial = new Monomial(coef, exp);
            ArrayList<Monomial> tArr = new ArrayList<Monomial>();
            if(coef != 0){
                tArr.add(newMonomial);
            }
            Polynomial t = new Polynomial(tArr);
            quotient = quotient.add(t);
            Collections.sort(quotient.polynomial);
            Polynomial mulRes = t.multiply(small);
            remainder = remainder.subtract(mulRes);
        }
        result.add(quotient);
        result.add(remainder);
        return result;
    }


    public Polynomial integrate() {
        ArrayList<Monomial> res = new ArrayList<Monomial>();
        if(this.polynomial.size() == 0 || this.polynomial.get(0).getCoefficient()==0){
            Polynomial integResult = new Polynomial("0");
            return integResult;
        }
        for (Monomial mon : this.polynomial) {
            int numarator = mon.getCoefficient();
            int numitor = mon.getExponent() + 1;
            float coef = (float) numarator / numitor;
            int exp = mon.getExponent() + 1;
            if(coef != 0){
                Monomial newMon = new Monomial(coef, exp);
                res.add(newMon);
            }
        }
        Collections.sort(res);
        Polynomial integResult = new Polynomial(res);
        return integResult;
    }

    public String toString() {
        String res = "";
        if (this.polynomial.size() > 0)
            res += this.polynomial.get(0).toString();
        for (int i = 1; i < this.polynomial.size(); i++) {
            String mon = this.polynomial.get(i).toString();
            if (this.polynomial.get(i).getCoefficient() > 0) {
                res += "+" + mon;
            } else
                res += mon;
        }
        if (res.equals(""))
            res = "0";
        return res;
    }

    public String toString1() {
        String res = "";
        if (this.polynomial.size() > 0)
            res += this.polynomial.get(0).toString();
        res += this.polynomial.get(0).toString1();
        for (int i = 1; i < this.polynomial.size(); i++) {
            String mon = this.polynomial.get(i).toString1();
            if (this.polynomial.get(i).getCoefI() > 0) {
                res += "+" + mon;
            } else
                res += mon;
        }
        res += "+C";
        if (res.equals(""))
            res = "0";
        return res;
    }

    public boolean equalsP(Polynomial p2) {
        if (this.polynomial.size() != p2.polynomial.size()) {
            return false;
        } else {
            int i = 0;
            while (i < this.polynomial.size()) {
                if (!(this.polynomial.get(i)).equalsM(p2.polynomial.get(i)))
                    return false;
                else
                    i++;
            }
        }
        return true;
    }
}
