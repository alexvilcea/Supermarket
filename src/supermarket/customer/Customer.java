package supermarket.customer;

import supermarket.ItemList.ShoppingCart;
import supermarket.ItemList.WishList;
import supermarket.notifictation.Notification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class Customer implements Observer{
    //VALUES
    private String name;
    private ShoppingCart shoppingCart;
    private WishList wishList;
    private ArrayList<Notification> notificationCollection;

    //CONSTRUCTOR

    public Customer(String name,Double budget) {
        this.name = name;
        shoppingCart = new ShoppingCart(budget);
        wishList = new WishList();
        notificationCollection = new ArrayList();
    }


    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public ArrayList<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(ArrayList<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    //METHODS

    public void addNotification(Notification notification){
        notificationCollection.add(notification);
    }


    public void update(Notification notification) {
        notificationCollection.add(notification);
    }

    //TO_STRING


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
