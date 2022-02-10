import java.util.*;

public class FinanceCalculator{
  private double loanAmount;
  private double interestRate;
  private double monthlyPayment;

  private int monthsToPayoff;
  private double cost;

  public void calculate() throws Exception{
    double amtOverPaid = 0.;
    double loanBalance = this.loanAmount;
    double interestAmt = 0.;
    int monthsPaid = 0;
    // while loanAmount > 0
    while(loanBalance > 0){
      //  calc interest amount
      interestAmt = loanBalance * this.interestRate / 1200;
      loanBalance += interestAmt;
      //  subtract payment
      loanBalance -= this.monthlyPayment;
      monthsPaid++;
      if(loanBalance >= loanAmount)
        throw new Exception("Monthly Payment Too Low");
    }
    // return cost = total amount paid
    this.cost =  monthsPaid*this.monthlyPayment + loanBalance - this.loanAmount;
    this.monthsToPayoff = monthsPaid;
  }

  public void setLoanAmount(double amount){
    this.loanAmount = amount;
  }

  public void setInterestRate(double rate){
    this.interestRate = rate;
  }

  public void setMonthlyPayment(double payment){
    this.monthlyPayment = payment;
  }

  public int getMonthsToPayoff(){
    return this.monthsToPayoff;
  }

  public double getCost(){
    return this.cost;
  }

  public FinanceCalculator(double amount, double rate, double payment){
    this.loanAmount = amount;
    this.interestRate = rate;
    this.monthlyPayment = payment;
    //this.calculate();
  }

  public static void main(String[] args){
    FinanceCalculator fc = new FinanceCalculator(10000.00, 5.75, 250.);
    System.out.println("Cost: " + fc.getCost() + "\nMonths to Payoff: " + fc.getMonthsToPayoff());
  }
}
