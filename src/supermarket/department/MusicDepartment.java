package supermarket.department;

import supermarket.ItemList.ShoppingCart;

public class MusicDepartment extends Department{
    public MusicDepartment(String name,Double id){
        super(name,id);
    }

    @Override
    public void accept(ShoppingCart shoppingCart) {
        shoppingCart.visit(this);
    }
}
