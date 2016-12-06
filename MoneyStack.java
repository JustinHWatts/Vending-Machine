import java.util.*;

/**
 * MoneyStack.java - Handles a single stack of coins for the Vending Machine.
 * Keeps track of money that has been stored.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class MoneyStack<T>
{
	private Stack<T> stack;
	
	/**
	 * Constructor for the MoneyStack class. Sets up a stack for a set of coins.
	 */
	public MoneyStack()
	{
		stack = new Stack<T>();
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
	 * Pushes a new coin onto the stack.
	 * @param t a generic representation of a coin to be placed on the stack
	 */
	public void push(T t)
	{
		stack.push(t);
	}
	
	/**
	 * Pops the top generic representation of a coin off the top of the stack.
	 * @return a generic representation of a coin to be removed from the stack
	 */
	public T pop()
	{
		return stack.pop();
	}
	
	/**
	 * Determines whether or not the selected stack is empty.
	 * @return a boolean value detailing whether or not the stack is empty
	 */
	public boolean isEmpty()
	{
		return stack.empty();
	}
}