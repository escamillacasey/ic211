import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame{
  private JTextField loanAmountField;
  private JComboBox<Double> interestRateField;
  private JTextField monthlyPaymentField;

  private JTextField monthsToPayField;
  private JTextField costField;

  private JButton aButton;

  private final Double[] interestRates =
  {3.5,3.75,4.0,4.25,4.5,4.75,5.0,5.25,5.5,5.75,6.,6.25,6.5,6.75,7.};

  private FinanceCalculator fc;

  public CalcFrame(){
    JPanel p = new JPanel(new FlowLayout());
    JLabel loanAmountLabel = new JLabel("loan amount");
    JLabel interestRateLabel = new JLabel("interest rate");
    JLabel monthlyPaymentLabel = new JLabel("monthly payment");
    JLabel monthsToPayLabel = new JLabel("months to payoff");
    JLabel costLabel = new JLabel("cost");

    loanAmountField = new JTextField("10000.00",10);
    interestRateField = new JComboBox<Double>(interestRates);
    monthlyPaymentField = new JTextField("250",10);

    monthsToPayField = new JTextField(10);
    monthsToPayField.setEditable(false);
    costField = new JTextField(10);
    costField.setEditable(false);

    aButton = new JButton("calculate");
    


    Responder r = new Responder(this);

    //loanAmountField.addActionListener(r);
    //interestRateField.addActionListener(r);
    //monthlyPaymentField.addActionListener(r);
    aButton.addActionListener(r);

    add(p, BorderLayout.CENTER);
    p.add(loanAmountLabel);
    p.add(loanAmountField);
    p.add(interestRateLabel);
    p.add(interestRateField);
    p.add(monthlyPaymentLabel);
    p.add(monthlyPaymentField);
    p.add(monthsToPayLabel);
    p.add(monthsToPayField);
    p.add(costLabel);
    p.add(costField);
    p.add(aButton);
    // Financial Stuff
    fc = new FinanceCalculator(Double.parseDouble(loanAmountField.getText()),
                               (double)interestRateField.getSelectedItem(),
                               Double.parseDouble(monthlyPaymentField.getText()));
    try{
      recalculate();
    }catch(Exception e){
      
    }
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
  }

  public void recalculate(){
    // set loan amount
    fc.setLoanAmount(Double.parseDouble(loanAmountField.getText()));
    // set interest rate
    fc.setInterestRate((double)interestRateField.getSelectedItem());
    // set monthly payment
    fc.setMonthlyPayment(Double.parseDouble(monthlyPaymentField.getText()));
    // update months to payoff
    
    try{
      fc.calculate();
    }catch(Exception e){
      e.printStackTrace();
    }
    // update cost
    costField.setText("" + Math.round(fc.getCost()*100)/100.00);
    monthsToPayField.setText("" + fc.getMonthsToPayoff());
  }
}
