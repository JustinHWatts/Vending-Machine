/**
 * Stock.java - Handles all tasks related to inventory of Vending Machine through
 * interaction with ProductStack class.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class Stock
{
	private Product productOne;
	private Product productTwo;
	private Product productThree;
	private Product productFour;
	private Product productFive;
	private Product productSix;
	private Product productSeven;
	private Product productEight;
	private Product productNine;
	
	private ProductStack productStackOne;
	private ProductStack productStackTwo;
	private ProductStack productStackThree;
	private ProductStack productStackFour;
	private ProductStack productStackFive;
	private ProductStack productStackSix;
	private ProductStack productStackSeven;
	private ProductStack productStackEight;
	private ProductStack productStackNine;
	
	/**
	 * Constructor of Stock class. Handles products and their respective stock
	 * amounts for an instance of Vending Machine.
	 */
	public Stock()
	{
		productOne = new Product("Boomerang");
		productTwo = new Product("Lantern");
		productThree = new Product("Bombs");
		productFour = new Product("Magic Mirror");
		productFive = new Product("Bow & Arrow");
		productSix = new Product("Hookshot");
		productSeven = new Product("Fire/Ice Rod");
		productEight = new Product("Master Sword");
		productNine = new Product("Ocarina");
		
		productStackOne = new ProductStack();
		productStackTwo = new ProductStack();
		productStackThree = new ProductStack();
		productStackFour = new ProductStack();
		productStackFive = new ProductStack();
		productStackSix = new ProductStack();
		productStackSeven = new ProductStack();
		productStackEight = new ProductStack();
		productStackNine = new ProductStack();
	}
	
	/**
	 * Allows an administrator of Vending Machine to restore stock amount of all
	 * products to full.
	 */
	public void restockProduct()
	{
		for (int i = 0; i < 9; i++)
		{
			switch (i)
			{
			case 0:
				while (productStackOne.size() < 5)
					productStackOne.push(productOne);
				break;
			case 1:
				while (productStackTwo.size() < 5)
					productStackTwo.push(productTwo);
				break;
			case 2:
				while (productStackThree.size() < 5)
					productStackThree.push(productThree);
				break;
			case 3:
				while (productStackFour.size() < 5)
					productStackFour.push(productFour);
				break;
			case 4:
				while (productStackFive.size() < 5)
					productStackFive.push(productFive);
				break;
			case 5:
				while (productStackSix.size() < 5)
					productStackSix.push(productSix);
				break;
			case 6:
				while (productStackSeven.size() < 5)
					productStackSeven.push(productSeven);
				break;
			case 7:
				while (productStackEight.size() < 5)
					productStackEight.push(productEight);
				break;
			case 8:
				while (productStackNine.size() < 5)
					productStackNine.push(productNine);
				break;
			}
		}
	}
	
	/**
	 * Checks to see if a selected product is sold out.
	 * @param selection product selected by user
	 * @return a boolean value stating whether or not the item is sold out
	 */
	public boolean isSoldOut(String selection)
	{
		boolean soldOut = false;
		switch (selection)
		{
		case "A1":
			soldOut = productStackOne.isEmpty();
			break;
		case "B2":
			soldOut = productStackTwo.isEmpty();
			break;
		case "C3":
			soldOut = productStackThree.isEmpty();
			break;
		case "D4":
			soldOut = productStackFour.isEmpty();
			break;
		case "E5":
			soldOut = productStackFive.isEmpty();
			break;
		case "F6":
			soldOut = productStackSix.isEmpty();
			break;
		case "G7":
			soldOut = productStackSeven.isEmpty();
			break;
		case "H8":
			soldOut = productStackEight.isEmpty();
			break;
		case "I9":
			soldOut = productStackNine.isEmpty();
			break;
		}
		
		return soldOut;
	}
	
	/**
	 * Handles the process of purchasing a product through the removal of said
	 * product from the inventory of the Vending Machine.
	 * @param selection product selected by user
	 * @return message stating the transaction was successful
	 */
	public String purchase(String selection)
	{
		String message = "\nThank you for your purchase";
		
		switch (selection)
		{
		case "A1":
			productStackOne.pop();
			break;
		case "B2":
			productStackTwo.pop();
			break;
		case "C3":
			productStackThree.pop();
			break;
		case "D4":
			productStackFour.pop();
			break;
		case "E5":
			productStackFive.pop();
			break;
		case "F6":
			productStackSix.pop();
			break;
		case "G7":
			productStackSeven.pop();
			break;
		case "H8":
			productStackEight.pop();
			break;
		case "I9":
			productStackNine.pop();
			break;
		}
		
		return message;
	}
	
	/**
	 * Gets the names of all nine products in Vending Machine and places them in
	 * an array of Strings.
	 * @return array of Strings containing names of products
	 */
	public String[] getProductNames()
	{
		String[] productNames = new String[9];
		
		for (int i = 0; i < 9; i++)
		{
			switch (i)
			{
			case 0:
				productNames[0] = productOne.getItemName();
				break;
			case 1:
				productNames[1] = productTwo.getItemName();
				break;
			case 2:
				productNames[2] = productThree.getItemName();
				break;
			case 3:
				productNames[3] = productFour.getItemName();
				break;
			case 4:
				productNames[4] = productFive.getItemName();
				break;
			case 5:
				productNames[5] = productSix.getItemName();
				break;
			case 6:
				productNames[6] = productSeven.getItemName();
				break;
			case 7:
				productNames[7] = productEight.getItemName();
				break;
			case 8:
				productNames[8] = productNine.getItemName();
				break;
			}
		}
		
		return productNames;
	}
}