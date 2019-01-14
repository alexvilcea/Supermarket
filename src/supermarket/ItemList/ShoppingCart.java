package supermarket.ItemList;

import supermarket.Item;
import supermarket.department.BookDepartment;
import supermarket.department.MusicDepartment;
import supermarket.department.SoftwareDepartment;
import supermarket.department.VideoDepartment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ShoppingCart extends ItemList implements Visitor{
    private Double budget;
    public ShoppingCart(Double budget){
        this.budget = budget;
    }


    @Override
    public boolean add(Item element) {
//        System.out.println("aici");
//        System.out.println(budget);
        if (element.getPrice()<=budget){
            budget = budget - element.getPrice();
            return super.add(element);
        }
        else
            return false;
    }

    @Override
    public boolean remove(Item item) {
        budget += item.getPrice();
        return super.remove(item);
    }

    //IMPLEMENTED METHODS


    @Override
    public void visit(BookDepartment bookDepartment) {
        Double price;
        ItemIterator it = new ItemIterator();
        while (it.current!= null){
            if(bookDepartment.depContainsItem(it.current.item)){ //MODIFICAT if(bookDepartment.getItems().contains(it.current.item))
                price = it.current.item.getPrice();
                it.current.item.setPrice(price*0.9);
                budget += price*0.1;
            }
            it.next();
        }
    }

    @Override
    public void visit(MusicDepartment musicDepartment) {

        ItemIterator it = new ItemIterator();
        while (it.current!= null){
            if(musicDepartment.depContainsItem(it.current.item)){
                budget += it.current.item.getPrice()*0.1;
            }
            it.next();
        }
    }

    @Override
    public void visit(SoftwareDepartment softwareDepartment) {

        // Aflam produsul cu pretul minim din departament
        Double price;
        List<Item> softItems = softwareDepartment.getItems();
        ListIterator<Item> softIterator = softItems.listIterator();
        Item min = softIterator.next();
        Item current;
        while (softIterator.hasNext()){
            current = softIterator.next();
            if(current.getPrice()<min.getPrice()){
                min = current;
            }
        }

        ItemIterator it = new ItemIterator();
        if(budget<min.getPrice()){
            while (it.current!= null){
                if(softwareDepartment.depContainsItem(it.current.item)){
                    price = it.current.item.getPrice();
                    it.current.item.setPrice(it.current.item.getPrice()*0.8);
                    budget += price*0.2;
                }
                it.next();
            }
        }
    }

    @Override
    public void visit(VideoDepartment videoDepartment) {
        Double price;
        Double totalPrice = 0.0;
        // Aflam produsul cu pretul maxim din departament
        List<Item> softItems = videoDepartment.getItems();
        ListIterator<Item> softIterator = softItems.listIterator();
        Item max = softIterator.next();
        Item current;
        while (softIterator.hasNext()){
            current = softIterator.next();
            if(current.getPrice()>max.getPrice()){
                max = current;
            }
        }
        ItemIterator it = new ItemIterator();
        while (it.current!=null){
            if(videoDepartment.depContainsItem(it.current.item)){
                price = it.current.item.getPrice();
                budget += price*0.05;
                totalPrice += price;
            }
            it.next();
        }


         it = new ItemIterator();
        if(totalPrice>max.getPrice()){
            while (it.current!= null){
                if(videoDepartment.depContainsItem(it.current.item)){
                    price = it.current.item.getPrice();
                    it.current.item.setPrice(it.current.item.getPrice()*0.85);
                    budget += price*0.15;
                }
                it.next();
            }
        }


    }

    @Override
    public void modifyPrice(Item item, Double price) {
        ItemIterator it = new ItemIterator();
        Item x = new Item(null,-1.0,-1.0);
        Double initialBudget = budget;
        while (it.current!= null){
            if(it.current.item.getId().equals(item.getId())){
                Double initialPrice = it.current.item.getPrice();
                super.modifyPrice(item, price);
                budget += initialPrice - price;
                if(budget<0){
                    remove(item);
                    budget = initialBudget+initialPrice;
                }
                return;
            }
            it.next();
        }


    }


    //update budget

    public void updateBudget(){
        budget = 0.0;
        ItemIterator it = new ItemIterator();
        while (it.current!= null){
            budget += it.current.item.getPrice();
            it.next();
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + super.toString() + ' '+
                "budget=" + budget +
                '}';
    }
}
