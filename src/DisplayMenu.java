import java.util.Scanner;

/**
 * DisplayMenu.java - Displays the user interface for the Vending Machine program.
 * Takes user input and sends instructions to VendingMachineController class.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class DisplayMenu
{
	private Scanner scan;
	
	/**
	 * Constructor of the DisplayMenu class. Sets up scanner to receive
	 * user input for instance of Vending Machine.
	 * @param _scan scanner which receives user input
	 */
	public DisplayMenu(Scanner _scan)
	{
		scan = _scan;
	}
	
	/**
	 * Displays the Vending Machine products along with their prices and selection codes
	 * @param products an array of Strings containing the names of all products
	 */
	public void display(String[] products)
	{
		System.out.println("--------------------------------------------------------------");
		System.out.println("|                                                            |");
		System.out.println("|    " + products[0] + "          " + products[1] + "            "
				+ products[2] + "             |");
		System.out.println("|    ------A1------     ------B2------     ------C3------    |");
		System.out.println("|         $.35               $.35               $.35         |");
		System.out.println("|                                                            |");
		System.out.println("|    " + products[3] + "       " + products[4] + "        "
				+ products[5] + "          |");
		System.out.println("|    ------D4------     ------E5------     ------F6------    |");
		System.out.println("|         $.50               $.50               $.50         |");
		System.out.println("|                                                            |");
		System.out.println("|    " + products[6] + "       " + products[7] + "       "
				+ products[8] + "           |");
		System.out.println("|    ------G7------     ------H8------     ------I9------    |");
		System.out.println("|         $.75               $.75               $.75         |");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Please type 25 for quarter, 10 for dime, 5 for nickel,\n"
				+ "refund to refund money already inserted, or q to quit");
	}
	
	/**
	 * Displays the administrator menu for the Vending Machine
	 * @param controller the instance of the VendingMachineController
	 */
	public void displayAdmin(VendingMachineController controller)
	{
		boolean done = false;
		while (!done)
		{
			System.out.println("Please select administrative option:\n"
					+ "Type r to restock product\n"
					+ "Type c to collect money\n"
					+ "Type q to return to buy menu");
			String input = scan.nextLine();
			
			if (input.equals("r"))
			{
				controller.restock();
				System.out.println("Product restocked\n");
				done = true;
			}
			else if (input.equals("c"))
			{
				controller.collect();
				System.out.println("Money collected\n");
				done = true;
			}
			else if (input.equals("q"))
				done = true;
			else
				System.out.println("Incorrect input, please try again\n");
		}
	}
	
	/**
	 * The cycle of displaying the Vending Machine and retrieving user input for
	 * an instance of the Vending Machine.
	 * @param controller the instance of the VendingMachineController
	 */
	public void run(VendingMachineController controller)
	{
		boolean done = false;
		String[] products = controller.getItemList();
		String output;
		this.display(products);
		
		while (!done)
		{
			String input = scan.nextLine();
			
			switch (input)
			{
				case "25":
					output = controller.add(.25);
					System.out.println(output);
					break;
				case "10":
					output = controller.add(.10);
					System.out.println(output);
					break;
				case "5":
					output = controller.add(.05);
					System.out.println(output);
					break;
				case "A1": case "B2": case "C3":
				case "D4": case "E5": case "F6":
				case "G7": case "H8": case "I9":
					output = controller.makePurchase(input);
					System.out.println(output);
					this.display(products);
					break;
				case "admin":
					this.displayAdmin(controller);
					this.display(products);
					break;
				case "refund":
					output = controller.refund();
					System.out.println(output);
					this.display(products);
					break;
				case "q":
					done = true;
					break;
				default:
					System.out.println("Incorrect input, please try again\n");
			}
		}
	}
}