package supermarket.department;

import supermarket.Item;
import supermarket.ItemList.ShoppingCart;
import supermarket.ItemList.Visitor;
import supermarket.customer.Customer;
import supermarket.notifictation.Notification;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Observer;


public abstract class Department implements Subject {
    //VALUES
    private String name;
    private LinkedList<Item> items;
    private LinkedList<Customer> customers_buyers;
    private LinkedList<Customer> customers_wishers;
    private Double id;
    private ArrayList<Customer> observers;
    //CONSTRUCTOR


    public Department(String name, Double id){
        this.name = name;
        this.id = id;
        items = new LinkedList<Item>();
        customers_buyers = new LinkedList<Customer>();
        customers_wishers = new LinkedList<Customer>();
        observers = new ArrayList<Customer>();
    }

    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }

    public LinkedList<Customer> getCustomers_buyers() {
        return customers_buyers;
    }

    public void setCustomers_buyers(LinkedList<Customer> customers_buyers) {
        this.customers_buyers = customers_buyers;
    }

    public LinkedList<Customer> getCustomers_wishers() {
        return customers_wishers;
    }

    public void setCustomers_wishers(LinkedList<Customer> customers_wishers) {
        this.customers_wishers = customers_wishers;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public ArrayList<Customer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Customer> observers) {
        this.observers = observers;
    }
//METHODS

    public void enter(Customer customer){
        if (customers_buyers.contains(customer))
            return;
        customers_buyers.add(customer);
    }
    public void exit(Customer customer){
        customers_buyers.remove(customer);
    }
    public void addItem(Item item){
        if(items.contains(item))
            return;
        items.add(item);
    }
    public void addObserver(Customer customer){
        if(observers.contains(customer))
            return;
        observers.add(customer);
    }
    public void removeObserver(Customer customer){
        observers.remove(customer);
    }
    public void notifyAllObservers(Notification notification){

        for(Customer customer : observers){
            customer.addNotification(notification);
        }
    }

    abstract public void accept(ShoppingCart shoppingCart);

    public boolean depContainsItem(Item item){
        Item x;
        ListIterator<Item> it = items.listIterator();
        while(it.hasNext()){
            x = it.next();
            if(x.getId() == item.getId()){
                return true;
            }
        }
        return false;
    }



    //TOSTRING
    @Override

    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", items=" + items + "\n" +
                ", customers_buyers=" + customers_buyers + "\n" +
                ", customers_wishers=" + customers_wishers + "\n" +
                ", id=" + id + "\n" +
                ", observers=" + observers + "\n" +
                '}'+ "\n" ;
    }
}
