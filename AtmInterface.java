import java.util.*;

public class AtmInterface {

int balance = 10000;
 int transaction=0;
String transactionHistory;
String username,password;

public static void main(String[] args) {


Scanner sc = new Scanner(System.in);




AtmInterface obj=new AtmInterface();
if(obj.login()){
while (true) {
System.out.println("\n\nATM Interface");
System.out.println("1: transaction history");
System.out.println("2: Withdraw");
System.out.println("3: deposit");
System.out.println("4: transfer");
System.out.println("5: Exit");

System.out.print("\nEnter your choice: ");
int choice = sc.nextInt();

switch (choice) {
	case 1:
		obj.transHistory();
		 break;
	case 2:
		obj.withdraw();
		break;
	case 3:
		obj.deposit();
		break;
	case 4:
		 obj.transfer();
		break;					 
	case 5: 
		System.out.println("\nThank you for using our ATM!");
		System.exit(0);
	default:
		System.out.println("\nInvalid choice. Please try again.\n");
}
}
}


  
  
}

boolean login() {
   Scanner sc = new Scanner(System.in);
   boolean islogin=false;
   
  System.out.println("enter your username: ");
  this.username=sc.nextLine();
  System.out.println("enter your password(pin):");
  this.password=sc.nextLine();
   while(!islogin)
   { System.out.print("\nEnter Your Username - ");
		String Username = sc.nextLine();
		if ( Username.equals(username) ) {
			while (!islogin) {
				System.out.print("\nEnter Your Password - ");
				String Password = sc.nextLine();
				if ( Password.equals(password) ) {
					System.out.print("\nLogin successful!!");
					islogin=true;
				}
				
			   else 
				System.out.println("please enter correct password");
			}
			
		}
	   else 
		System.out.println("please enter correct username");
		
   }
   return islogin;

}				
void withdraw() {
  Scanner sc = new Scanner(System.in);
  System.out.print("\nEnter amount to withdraw: ");
  int withdrawAmount = sc.nextInt();
  try{

   if (withdrawAmount <= balance) {
	transaction++;
	balance =balance-withdrawAmount;
	System.out.println("\nPlease collect your cash.\n");
	transactionHistory=(withdrawAmount +"is withdrawed");
	 } 
   else {
		System.out.println("\nInsufficient balance. Please try again.\n");
	   
		}
} catch (Exception e){
}
}

	void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter amount to deposit: ");
		int depositAmount = sc.nextInt();
		try{
		balance =balance+depositAmount;
		transactionHistory=(depositAmount + "is deposited" );
		System.out.println("\nYour new balance is: " + balance + "\n");
	}
	catch (Exception e){
	}
	}
	
void transfer() {
Scanner sc = new Scanner(System.in);
System.out.print("\nEnter Recipient Name : ");
String recipient = sc.nextLine();
System.out.print("\nEnter amount to transfer : ");
int amount = sc.nextInt();
try{
if ( balance >= amount ) { 
if ( amount <= 50000 ) {
	transaction++;
	balance =balance-amount;
	System.out.println("Successfully Transfered to " +recipient +"\n");
	transactionHistory=(amount + " transfered to " + recipient + "\n");
	}
else {
		System.out.println("\nSorry...Limit is 50000");
	 }
}

  
else 
{
	System.out.println("\nInsufficient Balance");
}
}
catch (Exception e){
}
}

public void transHistory() {
	if ( transaction == 0 ) {
		System.out.println("\navailabel balance is " + balance + "Rs");
	}
	else {
		System.out.println("\n" + transactionHistory);
	}
}
}



