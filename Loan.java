import java.util.Date;
import java.lang.Math;
import java.util.Scanner;

class Loan{
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example , 8.25: ");
        String interest  = input.nextLine();
        Loan currLoan;
        if(interest == "") {
            currLoan = new Loan();
        }
        else{
            
            System.out.print("Enter number of years as an integer: ");
            int years = input.nextInt();
            System.out.print("Enter loan amount, for example, 120000.95: ");
            double amount = input.nextDouble();
            currLoan = new Loan(Double.parseDouble(interest),years,amount);            
        }

        System.out.println("The loan was created on " + currLoan.getLoanDate());
        System.out.printf("The monthly payment is %.2f", currLoan.getMonthlyPayment());
        System.out.printf("\nThe total payment is %.2f", currLoan.getTotalPayment());
    }

    public Loan(){
        this.loanAmount = 1000;
        this.numberOfYears = 1;
        this.annualInterestRate = 2.5/100;
        this.loanDate = new Date();
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate/100;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    
    public double getMonthlyPayment(){
        double monthlyPayment = this.loanAmount *( this.annualInterestRate / 12.0 );
        monthlyPayment /= 1 - 1 /Math.pow( 1 + (this.annualInterestRate/12.0) , this.numberOfYears * 12);
        return monthlyPayment; 
    }
    
    public double getTotalPayment(){
        double totalPayment = getMonthlyPayment() * this.numberOfYears * 12;
        return totalPayment;
    }
}   