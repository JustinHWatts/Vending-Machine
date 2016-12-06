/**
 * Product.java - Holds the information for a product of the Vending Machine.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class Product
{
	private String itemName;
	
	/**
	 * Constructor of the Product class. Sets up a product for the Vending Machine.
	 * @param _itemName the name of a product for the Vending Machine
	 */
	public Product(String _itemName)
	{
		itemName = _itemName;
	}
	
	/**
	 * Gets the name of a product of the Vending Machine
	 * @return the name of a product
	 */
	public String getItemName()
	{
		return this.itemName;
	}
}