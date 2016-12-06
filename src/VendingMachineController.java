/**
 * VendingMachineController.java - Connects the user interface and input from the user
 * to the Stock and MoneyHandler classes, allowing actions to take place based on user
 * input. Holds current coins placed in machine until a purchase is made or coins are
 * refunded.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class VendingMachineController
{
	private Stock stock;
	private MoneyHandler moneyHandler;
	
	private double totalInserted;
	private int totalQuarters;
	private int totalDimes;
	private int totalNickels;
	
	/**
	 * Constructor of VendingMachineController class. Begins a new instance of
	 * the Vending Machine program.
	 */
	public VendingMachineController()
	{
		stock = new Stock();
		this.restock();
		moneyHandler = new MoneyHandler();
		moneyHandler.setBaseMoney();
		
		totalInserted = 0.0;
		totalQuarters = 0;
		totalDimes = 0;
		totalNickels = 0;
	}
	
	/**
	 * Obtains product names in order to populate Vending Machine display.
	 * @return names of all nine products in an array of Strings
	 */
	public String[] getItemList()
	{
		String[] productNames = new String[9];
		productNames = stock.getProductNames();
		return productNames;
	}
	
	/**
	 * Monitors the amount of money inserted into Vending Machine both in
	 * total and in amount of each individual coin.
	 * @param coin monetary amount of coin inserted as a double
	 * @return message detailing amount of money entered
	 */
	public String add(double coin)
	{
		this.totalInserted += coin;
		if (coin == .25)
			this.totalQuarters++;
		else if (coin == .10)
			this.totalDimes++;
		else if (coin == .05)
			this.totalNickels++;
		
		String message = "\nTotal amount entered: $" + this.totalInserted
				+ "\nPlease make selection or insert more coins\n";
		return message;
	}
	
	/**
	 * Returns all money inserted into Vending Machine.
	 * @return message to user that all money has been refunded
	 */
	public String refund()
	{
		this.totalInserted = 0.0;
		String message = "\nMoney refunded\nTotal amount entered: $" + this.totalInserted
				+ "\nPlease insert more coins before making selection\n";
		return message;
	}
	
	/**
	 * Handles purchase by user through checking if product is sold out and proceeding
	 * to send instructions to both Stock and MoneyHandler classes to remove the
	 * product and store the coins inserted for payment respectively. Also handles
	 * making change and checking to make sure enough money was inserted.
	 * @param selection which product the user is attempting to purchase
	 * @return message that product is sold out, user transaction was successful,
	 * or not enough money was inserted
	 */
	public String makePurchase(String selection)
	{
		String message = "";
		
		if (stock.isSoldOut(selection))
		{
			message = "\nProduct is sold out\nTotal amount entered: $" + this.totalInserted
					+ "\nPlease make a different selection\n";
		}
		else if (selection.equals("A1") || selection.equals("B2") || selection.equals("C3"))
		{
			if (totalInserted >= 0.35)
			{
				message = stock.purchase(selection) + "\nYour change is: $"
						+ moneyHandler.makeChange(totalInserted, .35);
				moneyHandler.storeCoins(totalQuarters, totalDimes, totalNickels);
				
				totalInserted = 0.0;
				totalQuarters = 0;
				totalDimes = 0;
				totalNickels = 0;
			}
			else
			{
				message = "\nNot enough money inserted\nTotal amount entered: $" + this.totalInserted
						+ "\nPlease insert more coins before making this selection\n";
			}
		}
		else if (selection.equals("D4") || selection.equals("E5") || selection.equals("F6"))
		{
			if (totalInserted >= 0.50)
			{
				message = stock.purchase(selection) + "\nYour change is: $"
						+ moneyHandler.makeChange(totalInserted, .50);
				moneyHandler.storeCoins(totalQuarters, totalDimes, totalNickels);
					
				totalInserted = 0.0;
				totalQuarters = 0;
				totalDimes = 0;
				totalNickels = 0;
			}
			else
			{
				message = "\nNot enough money inserted\nTotal amount entered: $" + this.totalInserted
						+ "\nPlease insert more coins before making this selection\n";
			}
		}
		else if (selection.equals("G7") || selection.equals("H8") || selection.equals("I9"))
		{
			if (totalInserted >= 0.75)
			{
				message = stock.purchase(selection) + "\nYour change is: $"
						+ moneyHandler.makeChange(totalInserted, .75);
				moneyHandler.storeCoins(totalQuarters, totalDimes, totalNickels);
				
				totalInserted = 0.0;
				totalQuarters = 0;
				totalDimes = 0;
				totalNickels = 0;
			}
			else
			{
				message = "\nNot enough money inserted\nTotal amount entered: $" + this.totalInserted
						+ "\nPlease insert more coins before making this selection\n";
			}
		}
		
		return message;
	}
	/**
	 * Returns all products to full stock
	 */
	public void restock()
	{
		stock.restockProduct();
	}
	/**
	 * Removes all coins inserted into machine except for baseline amount
	 */
	public void collect()
	{
		moneyHandler.collectMoney();
	}
}