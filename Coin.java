/**
 * Coin.java - Holds the basic information for one of three coins which may
 * be inserted into the Vending Machine.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public abstract class Coin
{
	private String coinName;
	private double amount;
	
	/**
	 * Constructor of the Coin class. Sets up a coin for the Vending Machine.
	 * @param _name name of the coin to be inserted into the Vending Machine
	 * @param _amount amount which the coin is worth
	 */
	public Coin(String _name, double _amount)
	{
		coinName = _name;
		amount = _amount;
	}
	
	/**
	 * Gets the monetary worth of selected coin.
	 * @return amount of money the coin is worth as a double
	 */
	public double getAmount()
	{
		return this.amount;
	}
	
	/**
	 * Gets the name of the selected coin.
	 * @return the coin's name
	 */
	public String getCoinName()
	{
		return this.coinName;
	}
}