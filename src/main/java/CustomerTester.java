import java.util.List;
import controller.CustomerHelper;
import model.Customer;

/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 13, 2021
 */

public class CustomerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer jane = new Customer("Jane");
		
		CustomerHelper ch = new CustomerHelper();
		
		ch.insertCustomer(jane);
		
		List<Customer> allCustomers = ch.showAllCustomers();
		for(Customer c: allCustomers) {
			System.out.println(c.toString());
		}
		
	}

}
