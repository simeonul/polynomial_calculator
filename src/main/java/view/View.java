package view;

import java.awt.event.*;

import javax.swing.*;
import java.awt.Font;

public class View {

    private JFrame frame;
    private JTextField polinom1TxtField;
    private JTextField polinom2TxtField;
    private JLabel titleLabel;
    private JLabel polinom1Label;
    private JLabel polinom2Label;
    private JButton additionBtn;
    private JButton subtractionBtn;
    private JButton multiplicationBtn;
    private JButton divisionBtn;
    private JButton derivationBtn;
    private JButton integrationBtn;
    private JLabel res1Name;
    private JLabel res2Name;
    private JLabel res1;
    private JLabel res2;

    public View() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 510, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        titleLabel.setBounds(125, 30, 250, 25);
        frame.getContentPane().add(titleLabel);

        polinom1Label = new JLabel("First Polynomial  = ");
        polinom1Label.setHorizontalAlignment(SwingConstants.CENTER);
        polinom1Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        polinom1Label.setBounds(20, 90, 200, 25);
        frame.getContentPane().add(polinom1Label);

        polinom2Label = new JLabel("Second Polynomial  = ");
        polinom2Label.setHorizontalAlignment(SwingConstants.CENTER);
        polinom2Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        polinom2Label.setBounds(20, 130, 200, 25);
        frame.getContentPane().add(polinom2Label);

        polinom1TxtField = new JTextField();
        polinom1TxtField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        polinom1TxtField.setBounds(230, 90, 250, 25);
        frame.getContentPane().add(polinom1TxtField);
        polinom1TxtField.setColumns(10);

        polinom2TxtField = new JTextField();
        polinom2TxtField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        polinom2TxtField.setColumns(10);
        polinom2TxtField.setBounds(230, 130, 250, 25);
        frame.getContentPane().add(polinom2TxtField);

        additionBtn = new JButton("Addition");
        additionBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        additionBtn.setBounds(40, 200, 200, 50);
        frame.getContentPane().add(additionBtn);

        subtractionBtn = new JButton("Subtraction");
        subtractionBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        subtractionBtn.setBounds(260, 200, 200, 50);
        frame.getContentPane().add(subtractionBtn);

        multiplicationBtn = new JButton("Multiplication");
        multiplicationBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        multiplicationBtn.setBounds(40, 270, 200, 50);
        frame.getContentPane().add(multiplicationBtn);

        divisionBtn = new JButton("Division");
        divisionBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        divisionBtn.setBounds(260, 270, 200, 50);
        frame.getContentPane().add(divisionBtn);

        derivationBtn = new JButton("Derivation");
        derivationBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        derivationBtn.setBounds(40, 340, 200, 50);
        frame.getContentPane().add(derivationBtn);

        integrationBtn = new JButton("Integration");
        integrationBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        integrationBtn.setBounds(260, 340, 200, 50);
        frame.getContentPane().add(integrationBtn);

        res1Name = new JLabel("");
        res1Name.setHorizontalAlignment(SwingConstants.CENTER);
        res1Name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        res1Name.setBounds(25, 420, 200, 20);
        frame.getContentPane().add(res1Name);

        res2Name = new JLabel("");
        res2Name.setHorizontalAlignment(SwingConstants.CENTER);
        res2Name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        res2Name.setBounds(25, 465, 200, 20);
        frame.getContentPane().add(res2Name);

        res1 = new JLabel("");
        res1.setHorizontalAlignment(SwingConstants.CENTER);
        res1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        res1.setBounds(275, 420, 200, 20);
        frame.getContentPane().add(res1);

        res2 = new JLabel("");
        res2.setHorizontalAlignment(SwingConstants.CENTER);
        res2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        res2.setBounds(275, 465, 200, 20);
        frame.getContentPane().add(res2);
    }

    public void newAdditionBtnListener(ActionListener l) {
        this.additionBtn.addActionListener(l);
    }
    public void newSubtractionBtnListener(ActionListener l) {
        this.subtractionBtn.addActionListener(l);
    }
    public void newMultiplicationBtnListener(ActionListener l) {
        this.multiplicationBtn.addActionListener(l);
    }
    public void newDivisionBtnListener(ActionListener l) {
        this.divisionBtn.addActionListener(l);
    }
    public void newDerivationBtnListener(ActionListener l) {
        this.derivationBtn.addActionListener(l);
    }
    public void newIntegrationBtnListener(ActionListener l) {
        this.integrationBtn.addActionListener(l);
    }
    public String getPolinom1Value() {
        return this.polinom1TxtField.getText();
    }
    public String getPolinom2Value() {
        return this.polinom2TxtField.getText();
    }
    public JLabel getRes1Name(){
        return this.res1Name;
    }
    public JLabel getRes2Name(){
        return this.res2Name;
    }
    public JLabel getRes1(){
        return this.res1;
    }
    public JLabel getRes2(){
        return this.res2;
    }
    public JFrame getFrame(){
        return this.frame;
    }
    public void showInputError(String error) {
        JOptionPane.showMessageDialog(this.frame, error);
    }
}
