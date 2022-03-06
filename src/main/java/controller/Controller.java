package controller;

import model.Polynomial;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private View view;

    public void resetText(View v){
        v.getRes1Name().setText("");
        v.getRes2Name().setText("");
        v.getRes1().setText("");
        v.getRes2().setText("");
    }

    public Controller(View view){
        this.view = view;

        this.view.newAdditionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText(view);
                String polinom1Value = view.getPolinom1Value();
                String polinom2Value = view.getPolinom2Value();
                if(polinom1Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*") || polinom2Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*")){
                    view.showInputError("Please only use lowercase x as the variable!");
                    return;
                }
                Polynomial polinom1 = new Polynomial(polinom1Value);
                Polynomial polinom2 = new Polynomial(polinom2Value);
               Polynomial addRes = polinom1.add(polinom2);
               view.getRes1Name().setText("Addition result   =");
               view.getRes1().setText(addRes.toString());
            }
        });

        this.view.newSubtractionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText(view);
                String polinom1Value = view.getPolinom1Value();
                String polinom2Value = view.getPolinom2Value();
                Polynomial polinom1 = new Polynomial(polinom1Value);
                Polynomial polinom2 = new Polynomial(polinom2Value);
                if(polinom1Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*") || polinom2Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*")){
                    view.showInputError("Please only use lowercase x as the variable!");
                    return;
                }
                Polynomial subRes = polinom1.subtract(polinom2);
                view.getRes1Name().setText("Subtraction result   =");
                view.getRes1().setText(subRes.toString());
            }
        });

        this.view.newMultiplicationBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText(view);
                String polinom1Value = view.getPolinom1Value();
                String polinom2Value = view.getPolinom2Value();
                if(polinom1Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*") || polinom2Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*")){
                    view.showInputError("Please only use lowercase x as the variable!");
                    return;
                }
                Polynomial polinom1 = new Polynomial(polinom1Value);
                Polynomial polinom2 = new Polynomial(polinom2Value);
                Polynomial mulRes = polinom1.multiply(polinom2);
                view.getRes1Name().setText("Multiplication result   =");
                view.getRes1().setText(mulRes.toString());
            }
        });

        this.view.newDivisionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText(view);
                String p1 = view.getPolinom1Value();
                String p2 = view.getPolinom2Value();
                if(p1.matches(".*[qwertyuiopasdfghjklzcvbnm].*") || p2.matches(".*[qwertyuiopasdfghjklzcvbnm].*")){
                    view.showInputError("Please only use lowercase x as the variable!");
                    return;
                }
                Polynomial polinom1 = new Polynomial(p1);
                Polynomial polinom2 = new Polynomial(p2);
                if(p1.equals("") || p2.equals("") || p1.equals("0") || p2.equals("0")){
                    view.showInputError("Please input 2 valid polynomials!");
                    return;
                }
                ArrayList <Polynomial> results = polinom1.divide(polinom2);
                view.getRes1Name().setText("Quotient  =");
                view.getRes2Name().setText("Remainder   =");
                view.getRes1().setText(results.get(0).toString());
                view.getRes2().setText(results.get(1).toString());
            }
        });

        this.view.newDerivationBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText(view);
                String polinom1Value = view.getPolinom1Value();
                String polinom2Value = view.getPolinom2Value();
                if(polinom1Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*") || polinom2Value.matches(".*[qwertyuiopasdfghjklzcvbnm].*")){
                    view.showInputError("Please only use lowercase x as the variable!");
                    return;
                }
                Polynomial polinom1 = new Polynomial(polinom1Value);
                Polynomial polinom2 = new Polynomial(polinom2Value);
                Polynomial divRes1 = polinom1.derive();
                Polynomial divRes2 = polinom2.derive();
                view.getRes1Name().setText("Derivation result 1   =");
                view.getRes1().setText(divRes1.toString());
                view.getRes2Name().setText("Derivation result 2   =");
                view.getRes2().setText(divRes2.toString());
            }
        });

        this.view.newIntegrationBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText(view);
                String p1 = view.getPolinom1Value();
                String p2 = view.getPolinom2Value();
                if(p1.matches(".*[qwertyuiopasdfghjklzcvbnm].*") || p2.matches(".*[qwertyuiopasdfghjklzcvbnm].*")){
                    view.showInputError("Please only use lowercase x as the variable!");
                    return;
                }
                Polynomial polinom1 = new Polynomial(p1);
                Polynomial polinom2 = new Polynomial(p2);
                Polynomial divRes1 = polinom1.integrate();
                Polynomial divRes2 = polinom2.integrate();
                view.getRes1Name().setText("Integration result 1   =");
                view.getRes1().setText(divRes1.toString1());
                view.getRes2Name().setText("Integration result 2   =");
                view.getRes2().setText(divRes2.toString1());
            }
        });
    }
}
