package supermarket.department;

import supermarket.ItemList.ShoppingCart;

public class VideoDepartment extends Department {

    public VideoDepartment(String name,Double id){
        super(name,id);
    }
    @Override
    public void accept(ShoppingCart shoppingCart) {
        shoppingCart.visit(this);
    }
}
