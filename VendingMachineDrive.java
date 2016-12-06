import java.util.Scanner;

/**
 * VendingMachineDrive.java - Driver to test the Vending Machine Program. A user
 * enters coins and makes a selection of a product through System.in/System.out.
 *
 * @author Justin Watts
 * @version 10/1/15
 */
public class VendingMachineDrive
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		DisplayMenu menu = new DisplayMenu(console);
		VendingMachineController controller = new VendingMachineController();
		menu.run(controller);
	}
}