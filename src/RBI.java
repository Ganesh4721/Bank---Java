import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom; 
public class RBI {

	public static void main(String[] args) {
		System.out.println("........Welcome to the Bank Portal........");
		System.out.println("\n Do you want to open an account. 1. Yes 2.No");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		if(choice.equals("Yes"))
		{
			OpenAccount obj = new OpenAccount();
			obj.createAccount();
		}
		if(choice.equals("No"))
		{
			System.out.println("........Thank you for visiting the Bank page........");
		}
	}
}
	class OpenAccount{
		String HolderName;
		String TypeOfAccount;
		String DOB;
		int AccountNumber;
		String Bank;
		void createAccount() {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n From which Bank you want to open a account. 1.HDFC 2.Axis 3.SBI");
			int Bankchoice = sc.nextInt();
			if(Bankchoice==1) {
				Bank = "HDFC";
			}
			if(Bankchoice==2) {
				Bank = "Axis";
			}
			if(Bankchoice==3) {
				Bank = "SBI";
			}
			
			System.out.println("...........Kindly fill the required Details..........");
			System.out.println("\nEnter your Full Name");
			sc.nextLine();
			HolderName = sc.nextLine();
			
			
			System.out.println("\nEnter your DOB");
			sc.nextLine();
			DOB = sc.nextLine();
			
			System.out.println("\n What type of account do you want? 1. Savings 2. current");
			int TypeOfAccountchoice = sc.nextInt();
			if(TypeOfAccountchoice == 1) {
				TypeOfAccount = "Savings";
			}
			if(TypeOfAccountchoice == 2) {
				TypeOfAccount = "current";
			}
			
			System.out.println("\n Your Account has been opened with the following Details");
			System.out.println(" Bank Name:" + Bank);
			System.out.println(" Account Holder Name :" + HolderName );
			System.out.println(" DOB :" + DOB);
			System.out.println(" Type of Account :" + TypeOfAccount);
			System.out.println(" Account Number :" + ThreadLocalRandom.current().nextInt());
			
			System.out.println("\n");
			BankAccount obj1 = new BankAccount();
			obj1.showDetails();
		}
	}
	
	class BankAccount {
		int balance;
		String CustomerName;
		String CustomerId;
		String TypeOfAccount;
		double totalinterest;
		void calculateInterest(double balance) {
			System.out.println("\n What type of account do you have? 1. Savings 2. current");
			Scanner sc = new Scanner(System.in);
			int TypeOfAccountchoice = sc.nextInt();
			if(TypeOfAccountchoice == 1) {
				TypeOfAccount = "Savings";
				int r = 5;
				System.out.println("\n Enter the year for calculating the interest?");
				int t = sc.nextInt();
				double totalinterest = (balance*r*t)/100;
				double totalAmount = totalinterest+balance;
				System.out.println("\n Total Interest in the span of "+ t +"years " + "is " + totalinterest);	
				
			}
			if(TypeOfAccountchoice == 2) {
				TypeOfAccount = "current";
				int r = 8;
				System.out.println("\n Enter the year for calculating the interest?");
				int t = sc.nextInt();
				double totalinterest = (balance*r*t)/100;
				double totalAmount = totalinterest+balance;
				System.out.println("\n Total Interest in the span of "+ t +"years " + "is " + totalinterest);	
			}
		}
		void deposit(int amount) {
			if(amount >0) {
				balance = balance + amount;
				System.out.println("Balnace in Your Account is "+ amount );
			}
		}
		void withdraw(int amount) {
			if(amount >0) {
				balance = balance - amount;
				System.out.println("After withdraw "+ amount );
			}
			else {
				System.out.println("Your Transiction has been Failed" );
			}
	}
		void showDetails() {
			char option = '\0';
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome to the Menu");
			System.out.println("\nA.Check Balance");
			System.out.println("B.Deposit Amount");
			System.out.println("C.Withdraw Amount");
			System.out.println("D.calculate Interest");
			System.out.println("E.Exit");
			
			do {
				System.out.println("Enter an option");
				option = scanner.next().charAt(0);
				switch(option) {
				case 'A':
					System.out.println("\n Balance : " + balance);
					break;
				case 'B':
					System.out.println("\n Enter an amount to deposit in your account : " );
					int amount = scanner.nextInt();
					deposit(amount);
					if(amount >1000000) {
						System.out.println("\n Sorry your transaction has been failed " );
						System.out.println("\n Please update your PAN details for deposit more than 1 Million " );
					}
					else
						System.out.println("\n Amount has been credited your account: " );
					
					break;
				case 'C':
					System.out.println("\n Enter an amount to withdraw : " );
					int amount1 = scanner.nextInt();
					withdraw(amount1);
					if(amount1 >1000000) {
						System.out.println("\n Sorry your transaction has been failed " );
						System.out.println("\n Please update your PAN details for withdraw more than 1 Million " );
					}
					else
						System.out.println("\n Amount has been Debited from your account " );
					break;
				case 'D':
					calculateInterest(balance);
					System.out.println("\n" );
					break;	
				default:
					System.out.println("\n Invalid option, Try again! " );
					break;	
				}		
			}while(option != 'E');
			System.out.println("Thank you for using our services........" );
			System.out.println("\n....Visit our Bank for any loan purposes...." );
		}
}
