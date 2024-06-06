/*7. Create a program with multi-dimensional List to store customer details (customerId,
customerName, customerCity).
This program to search the customer based on the customerName from a given array.
Note: use Binary search and Insertion sort algorithm.
 Create a constructor to initialize size of customer details for five customers.
 Create customer method which takes the array of customer elements (sorted as a
customerName).
 Create a method to getCustomer(customerId) method which will return the customer
details as a List.
 Create a method to sortCustomer() method which will return the array in a sorted
order based on customer city. */


import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    public List<Customer> customers;

    
    public CustomerManager() {
        this.customers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customers.add(new Customer());
        }
    }

    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

   
    public Customer getCustomer(String customerName) {
        int left = 0;
        int right = customers.size() - 1;
        // for(int i =0;i<customers.size();i++){
        //     System.out.println(customers.get(i));
        // }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = customers.get(mid).getCustomerName().compareTo(customerName);
            if (cmp == 0) {
                return customers.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

   
    public void sortCustomers() {
        for (int i = 1; i < customers.size(); i++) {
            Customer key = customers.get(i);
            int j = i - 1;
            while (j >= 0 && customers.get(j).getCustomerCity().compareTo(key.getCustomerCity()) > 0) {
                customers.set(j + 1, customers.get(j));
                j = j - 1;
            }
            customers.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();

      
        manager.addCustomer(new Customer("101", "Alice", "New York"));
        manager.addCustomer(new Customer("102", "Bob", "Los Angeles"));
        manager.addCustomer(new Customer("103", "Charlie", "Chicago"));
        manager.addCustomer(new Customer("104", "David", "Boston"));
        manager.addCustomer(new Customer("105", "Emma", "San Francisco"));

       
        manager.sortCustomers();

       
        Customer foundCustomer = manager.getCustomer("David");
        if (foundCustomer != null) {
            System.out.println("Customer found: " + foundCustomer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}

class Customer {
    private String customerId;
    private String customerName;
    private String customerCity;

    public Customer() {
        this.customerId = "";
        this.customerName = "";
        this.customerCity = "";
    }

    public Customer(String customerId, String customerName, String customerCity) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerCity = customerCity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCity='" + customerCity + '\'' +
                '}';
    }
}

