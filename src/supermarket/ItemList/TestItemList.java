package supermarket.ItemList;

import supermarket.Item;

public class TestItemList {

    public static void main(String[] args) {
        WishList wishList = new WishList();
        Item nou1 = new Item("Amintiri din copilarie",100.0,5.0);
        Item nou2 = new Item("Solenoid",101.0,3.8);
        Item nou3 = new Item("Ochii jupanitei",102.0,28.0);
        Item nou4 = new Item("Legendele Olimpului",103.0,4.5);
        Item nou5 = new Item("Enigma Otiliei",104.0,1.53);
        wishList.add(nou1);
        wishList.add(nou2);
        wishList.add(nou3);
        wishList.add(nou4);
        wishList.add(nou5);
        System.out.println(wishList);


        wishList.remove(nou5);
        boolean i = wishList.contains(nou5);
        System.out.println(wishList);
        System.out.println(i);

    }
}
