package supermarket.department;

import supermarket.ItemList.ShoppingCart;

public class BookDepartment extends Department{
    public BookDepartment(String name,Double id){
        super(name,id);
    }

    @Override
    public void accept(ShoppingCart shoppingCart) {
        shoppingCart.visit(this);
    }
}
