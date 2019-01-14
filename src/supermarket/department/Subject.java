package supermarket.department;

import supermarket.customer.Customer;
import supermarket.notifictation.Notification;

import java.util.Observer;

public interface Subject {
    public void addObserver(Customer c);
    public void removeObserver(Customer c);
    public void notifyAllObservers(Notification notify);
}
