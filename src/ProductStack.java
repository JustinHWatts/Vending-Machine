import java.util.*;

/**
 * ProductStack.java - Handles a single stack of products for the Vending Machine.
 * Keeps track of inventory.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class ProductStack
{
	private Stack<Product> stack;
	
	/**
	 * Constructor of the ProductStack class. Sets up a stack for a set of products.
	 */
	public ProductStack()
	{
		stack = new Stack<Product>();
	}
	
	/**
	 * Retrieves the size of selected stack.
	 * @return the size of the stack as an integer
	 */
	public int size()
	{
		return stack.size();
	}
	
	/**
	 * Pushes a new product onto the stack.
	 * @param newProduct the new product to be placed on the stack
	 */
	public void push(Product newProduct)
	{
		stack.push(newProduct);
	}
	
	/**
	 * Pops the top product off of selected stack.
	 * @return the product being removed from the stack
	 */
	public Product pop()
	{
		return stack.pop();
	}
	
	/**
	 * Checks to see if the selected stack is empty.
	 * @return a boolean value detailing whether or not the stack is empty
	 */
	public boolean isEmpty()
	{
		return stack.empty();
	}
}