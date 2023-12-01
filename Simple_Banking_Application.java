// completed except file handling.

import java.util.Random;
import java.util.Scanner;

// The functions to be performed  :-->

// 1.) Add account.
// 2.) Show Account details.
// 3.) Widhrawl money.
// 4.) Deposit money. 
// 5.) Create FD (with interest shown).
// 6.) Cash the check.
// 7.) Ask for loan approval.
// 8.) Account updation.
// 9.) Locker.
// 10.) Gold loan.

// Must include inheritance , interfaces , polymorphism .

interface addAccount {
    void customerName(String cusName);

    void customerDOB(int date, int month, int year);

    void customerAddress(String address);

    void customerAadhar(int aadharNum);

    void customerGender(String sex);

    void customerNationality(String nation);

    void customerMaritalStatus(boolean married);

    void customerFamilialInfo(String fatherName, String motherName);

    void customerCategory(String category);

    void customerCheckDetails(String checkSignature);
}

interface accountDetails {
    void typeOfAccount(String currentOrSavings);

    void isFD(int FDorNOT, int interestRate, int duration);

    void moneyInAccount(int money);
}

interface withdrawlMoney {
    void amountToWithdrawl(int total, int toWithdrawl);
}

interface depositMoney {
    void amountToDeposit(int total, int toDeposit);
}

interface cashTheCheck {
    void checkDetails(int checkAmount, int checkAuthenticity);
}

interface loanApproval {
    void loanDetails(int loanAmount, int loanDuration, boolean loanApprovedOrNot, int loanInterestRate);
}

// interface caution {
// int switching();
// }

class account implements addAccount, accountDetails, withdrawlMoney, depositMoney, cashTheCheck, loanApproval {
    Scanner sc = new Scanner(System.in);
    Scanner console = new Scanner(System.in);
    Scanner in = new Scanner(System.in);
    String signatureId;
    public static int money;
    Random randomLoanApproval = new Random();

    // customer details .
    public void customerName(String cusName) {
        System.out.println("Customer name is " + cusName);
    }

    public void customerAddress(String address) {
        System.out.println("Customer address is " + address);
    }

    public void customerDOB(int date, int month, int year) {
        System.out.println("Customer's date of birth is " + date + "/" + month + "/" + year);
    }

    public void customerAadhar(int aadharNum) {
        System.out.println("Customer's aadhar number is " + aadharNum);
    }

    public void customerGender(String sex) {
        System.out.println("Customer's gender is " + sex);
    }

    public void customerNationality(String nation) {
        System.out.println("Customer's nationality is " + nation);
    }

    public void customerMaritalStatus(boolean married) {
        System.out.println("Customer's marital status is " + married);
    }

    public void customerFamilialInfo(String fatherName, String motherName) {
        System.out.println("Customer's father's name is " + fatherName);
        System.out.println("Customer's mother's name is " + motherName);
    }

    public void customerCategory(String category) {
        System.out.println("Customer's category is " + category);
    }

    public void customerCheckDetails(String checkSignature) {
        System.out.println("Customer's signature id is " + checkSignature);
        signatureId = checkSignature;
        // switching();
    }

    void reasoning() {
        System.out.println("Enter your choice sir/madam :  ");
        System.out.println(" 1.) Add Account ");
        System.out.println(" 2.) Account Details ");
        System.out.println(" 3.) Withdrawl Money");
        System.out.println(" 4.) Deposit Money");
        System.out.println(" 5.) Loan Approval");
        System.out.println(" 6.) Cashing the Check");
        System.out.println(" 7.) returning...");
    }

    // Account details

    public void typeOfAccount(String currentOrSavings) {
        System.out.println("Customer's account is " + currentOrSavings);
    }

    public void isFD(int FDorNOT, int interestRate, int duration) {
        if (FDorNOT == 1) {
            System.out
                    .println("Customer's account has a fixed deposit with interest rate of " + interestRate + " % for "
                            + duration + " years.");
        } else {
            System.out.println("Customer's account do not has a fixed deposit.");
        }
    }

    public void moneyInAccount(int money) {
        System.out.println("total money in account is " + money + " rupees.");
        // switching();
    }

    // withdrawl details.

    public void amountToWithdrawl(int total, int toWithdrawl) {
        System.out.println("Amount to withdrawl is " + toWithdrawl);
        System.out.println("Amount of money in account remains: " + (total - toWithdrawl));
        total = total - toWithdrawl;
        System.out.println("Remaining money is: " + total);
        money = total;
        // switching();
    }

    // deposition details.

    public void amountToDeposit(int total, int toDeposit) {
        System.out.println("Money to deposit: " + toDeposit);
        total = total + toDeposit;
        System.out.println("Remaining money is: " + total);
        money = total;
        // switching();
    }

    // loan approval.

    public void loanDetails(int loanAmount, int loanDuration, boolean loanApprovedOrNot, int loanInterestRate) {
        if (loanApprovedOrNot) {
            System.out.println("Loan amount for approval is: " + loanAmount);
            System.out.println("Loan duration is:  " + loanDuration);
            System.out.println("Loan EMI is: " + (((loanAmount / 100) * loanInterestRate) + loanAmount) / loanDuration);

        } else {
            System.out.println("Loan not approved ");
        }
        // switching();

    }

    // cash the check details .

    public void checkDetails(int checkAmount, int checkAuthenticity) {
        if (money == 0) {
            System.out.println("Access denied 0 balance");
        } else {
            if (checkAuthenticity == 1) {
                if (checkAmount > money) {
                    System.out.println("Check money exceeded the current amount in account ;;)");
                } else {
                    System.out.println("Desired check amount is: " + checkAmount);
                    System.out.println("Giving the amount...");
                    money = money - checkAmount;
                    System.out.println("Remaining money in the account is: " + money);
                }
            } else {
                System.out.println("Check not authentic ");
                System.out.println("The total amount of money in account is: " + money);
            }
        }
        // switching();

    }

    public int switching() {
        reasoning();
        int c = console.nextInt();
        switch (c) {
            case 1:
                System.out.print("Enter Customer's name: ");
                String cusName = sc.nextLine();
                System.out.print("Enter Customer's address: ");
                String address = sc.nextLine();
                System.out.println("Enter Customer's DOB: ");
                System.out.print("Enter date: ");
                int date = console.nextInt();
                System.out.print("Enter month: ");
                int month = console.nextInt();
                System.out.print("Enter year: ");
                int year = console.nextInt();
                System.out.print("Enter aadhar number: ");
                int aadharNum = console.nextInt();
                System.out.print("Enter Customer's gender: ");
                String sex = sc.next();
                System.out.print("Enter Customer's nationality: ");
                String nation = sc.next();
                System.out.print("Enter Customer's marital status (t/f): ");
                boolean married = in.hasNext();
                System.out.print("Enter Customer's father's name: ");
                String fatherName = sc.next();
                System.out.print("Enter Customer's mother's name: ");
                String motherName = sc.next();
                System.out.print("Enter Customer's category: ");
                String category = sc.next();
                System.out.print("Enter Customer's signature ID (string): ");
                String checkSignatureId = sc.next();
                System.out.println("\n");

                customerName(cusName);
                customerAddress(address);
                customerDOB(date, month, year);
                customerAadhar(aadharNum);
                customerGender(sex);
                customerNationality(nation);
                customerMaritalStatus(married);
                customerFamilialInfo(fatherName, motherName);
                customerCategory(category);
                customerCheckDetails(checkSignatureId);
                switching();

                break;
            case 2:
                System.out.print("Enter account type- savings or current:  ");
                String currentOrSavings = sc.next();

                System.out.println(
                        "Enter FD conformation : 1 - have / 0 - not have , inetest rate you get , duration of FD (if not conformed enter 0 , 0 , 0) in respective order: ");
                int FDorNOT = console.nextInt();
                int interestRate = console.nextInt();
                int duration = console.nextInt();
                System.out.print("Enter amount of money have in account: ");
                money = console.nextInt();
                System.out.println("\n");

                typeOfAccount(currentOrSavings);
                isFD(FDorNOT, interestRate, duration);
                moneyInAccount(money);
                switching();
                break;

            case 3:
                System.out.print("Enter money to withdrawl: ");
                int toWithdrawl = console.nextInt();

                amountToWithdrawl(money, toWithdrawl);
                switching();
                break;

            case 4:
                System.out.print("Enter money to deposit: ");
                int toDeposit = console.nextInt();

                amountToDeposit(money, toDeposit);
                switching();
                break;

            case 5:
                System.out.print("Enter Loan amount you desire: ");
                int loanAmount = console.nextInt();
                int loanInterestRate = randomLoanApproval.nextInt(7, 15);
                System.out.println("Loan interest rate you are offered: " + loanInterestRate);
                System.out.print("Enter your desired loan duration: ");
                int loanDuration = console.nextInt();
                int LA = randomLoanApproval.nextInt(1);
                boolean loanApprovedOrNot;
                if (LA == 0) {
                    loanApprovedOrNot = true;
                } else {
                    loanApprovedOrNot = false;
                }
                loanDetails(loanAmount, loanDuration, loanApprovedOrNot, loanInterestRate);
                switching();

                break;

            case 6:
                int checkAuthenticityOf;
                System.out.print("Enter the check amount: ");
                int checkAmount = console.nextInt();
                System.out.print("Enter check authentication ID: ");
                String checkAuthenticationID = sc.next();
                if (checkAuthenticationID.equals(signatureId)) {
                    checkAuthenticityOf = 1;
                } else {
                    checkAuthenticityOf = 0;
                }

                checkDetails(checkAmount, checkAuthenticityOf);
                switching();
                break;
            default:
                System.out.println("Thanks for lodging ^^)  ");
                break;
        }
        return 0;
    }

}

public class Simple_Banking_Application {
    public static void main(String[] args) {
        account obj = new account();
        int m = obj.switching();
        if (m == 0) {
            System.out.println("program ended ^^ ");
        }

    }
}
