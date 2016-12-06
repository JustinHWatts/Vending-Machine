/**
 * MoneyHandler.java - Carries out all money related tasks of Vending Machine through
 * interaction with MoneyStack class.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class MoneyHandler
{
	private MoneyStack<Quarter> quarterStack;
	private MoneyStack<Dime> dimeStack;
	private MoneyStack<Nickel> nickelStack;
	
	private Quarter quarter;
	private Dime dime;
	private Nickel nickel;
	
	/**
	 * Constructor of MoneyHandler class. Handles money storage for instance
	 * of Vending machine.
	 */
	public MoneyHandler()
	{
		quarterStack = new MoneyStack<Quarter>();
		dimeStack = new MoneyStack<Dime>();
		nickelStack = new MoneyStack<Nickel>();
		
		quarter = new Quarter();
		dime = new Dime();
		nickel = new Nickel();
	}
	
	/**
	 * Allows administrator of Vending Machine to collect all inserted money
	 * to a baseline amount used for change.
	 */
	public void collectMoney()
	{
		for (int i = 0; i < 3; i++)
		{
			switch (i)
			{
			case 0:
				while (quarterStack.size() > 5)
					quarterStack.pop();
				break;
			case 1:
				while (dimeStack.size() > 7)
					dimeStack.pop();
				break;
			case 2:
				while (nickelStack.size() > 10)
					nickelStack.pop();
				break;
			}
		}
	}
	
	/**
	 * Sets the baseline amount of money available in the Vending Machine upon startup.
	 */
	public void setBaseMoney()
	{
		for (int i = 0; i < 3; i++)
		{
			switch (i)
			{
			case 0:
				while (quarterStack.size() < 5)
					quarterStack.push(quarter);
				break;
			case 1:
				while (dimeStack.size() < 7)
					dimeStack.push(dime);
				break;
			case 2:
				while (nickelStack.size() < 10)
					nickelStack.push(nickel);
				break;
			}
		}
	}
	
	/**
	 * Makes change based on amount of money entered and cost of selected product.
	 * @param totalEntered total money entered by user
	 * @param cost cost of product selected by user
	 * @return total amount of change being given
	 */
	public double makeChange(double totalEntered, double cost)
	{
		double result = totalEntered - cost;
		double totalChange = totalEntered - cost;
		totalChange = Math.floor(totalChange * 100) / 100;
		
		while (result >= .25)
		{
			quarterStack.pop();
			result = result - .25;
		}
		while (result >= .10)
		{
			dimeStack.pop();
			result = result - .10;
		}
		while (result > 0.0)
		{
			nickelStack.pop();
			result = result - .05;
		}
		
		return totalChange;
	}
	
	/**
	 * Stores the inserted coins from a transaction in money stacks.
	 * @param quarters amount of quarters entered
	 * @param dimes amount of dimes entered
	 * @param nickels amount of nickels entered
	 */
	public void storeCoins(int quarters, int dimes, int nickels)
	{
		for (int i = 0; i < quarters; i++)
			quarterStack.push(quarter);
		for (int i = 0; i < dimes; i++)
			dimeStack.push(dime);
		for (int i = 0; i < nickels; i++)
			nickelStack.push(nickel);
	}
}