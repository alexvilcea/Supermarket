package supermarket.department;

import supermarket.ItemList.ShoppingCart;

public class SoftwareDepartment extends Department {
    public SoftwareDepartment(String name,Double id){
        super(name,id);
    }

    @Override
    public void accept(ShoppingCart shoppingCart) {
        shoppingCart.visit(this);
    }
}
