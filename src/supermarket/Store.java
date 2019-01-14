package supermarket;

import supermarket.ItemList.ShoppingCart;
import supermarket.customer.Customer;
import supermarket.department.Department;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Store {

    //VALUES
    private static Store instance = null;
    private String name;
    private LinkedList<Department> departments;
    private LinkedList<Customer> customers;



    //CONSTRUCTORS
    private Store(){
    }
    private Store(String name){
        this.name = name;
        departments = new LinkedList<Department>();
        customers = new LinkedList<Customer>();
    }


    //GETINSTANCE
    public static Store getInstance(){
        if(instance == null){
            instance = new Store();
        }
        return instance;
    }
    public static Store getInstance(String name){
        if(instance == null){
            instance = new Store(name);
        }
        return instance;
    }


    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartments(LinkedList<Department> departments) {
        this.departments = departments;
    }

    public void setCustomers(LinkedList<Customer> customers) {
        this.customers = customers;
    }



    //METHODS
    public void enter(Customer customer){
        customers.add(customer);
    }

    public void exit(Customer customer){
        customers.remove(customer);
    }

    public ShoppingCart getShopingCart(Double budget){
        return new ShoppingCart(budget);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void  addDepartment(Department department){
        departments.add(department);
    }

    public Department getDepartment(Double id){
        ListIterator<Department> it = departments.listIterator();
        while(it.hasNext()) {
            Department dep = it.next();
            if(dep.getId() == id)
                return dep;
        }
        return null;
    }

    //TO_STRING

    public String toString() {
        return "Store{" +
                "name='" + name + '\'' + "\n" +
                ", departments=" + departments + "\n" +
                ", customers=" + customers +
                '}' ;

    }
}
