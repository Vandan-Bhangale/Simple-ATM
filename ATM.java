import java.util.Scanner;

class AtmMachine {
    float Balance;
    int Pin = 5674;

    public void CheckPin() {
        System.out.println("Enter the pin");

        int attempts = 3;

        for (int i = 0; i < attempts; i++) {
            Scanner Sc = new Scanner(System.in);
            int EnteredPin = Sc.nextInt();
            if (EnteredPin == Pin) {
                menu();
                return;
            } else {
                System.out.println("Invalid pin.");
                if (i < attempts - 1) {
                    System.out.println(attempts - 1 - i + " " + "Attempts left.");
                }
            }
        }
        System.out.println("Too many attempts,Access denied.");
    }

    public void menu() {
        Scanner choice = new Scanner(System.in);
        while (true) {
            System.out.println("\n menu");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Exiting....");

            int Choice = choice.nextInt();

            switch (Choice) {

                case 1:
                    Deposit();
                    break;

                case 2:
                    Withdraw();
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting....");
                    return;

                default:
                    System.out.println("Wrong choice.");
            }
        }
    }

    public void checkBalance() {
        System.out.println("balance" + Balance);
        menu();
    }

    public void Deposit() {
        System.out.println("Enter the amount to deposit.");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        Balance = Balance + amount;
        System.out.println("Amount is deposited.");
    }

    public void Withdraw() {
        System.out.println("Enter the amount to withdraw.");
        Scanner Wd = new Scanner(System.in);
        float Amount = Wd.nextFloat();

        if (Amount > Balance) {
            System.out.println("Not enough money in account.");
        } else {
            Balance = Balance - Amount;
            System.out.println("Amount withrawed form account.");
        }
    }

}

public class ATM {
    public static void main(String[] args) {
        AtmMachine obj = new AtmMachine();

        obj.CheckPin();
    }
}
