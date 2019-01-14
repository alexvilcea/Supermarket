package supermarket.ItemList;

import supermarket.Item;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;



public abstract class ItemList{

    public Node itemList;
    //Inner Classes

    protected static class Node{
        public Node prev;
        public Node next;
        public Item item;

        public Node(){
            this.prev = null;
            this.next = null;
            item = null;
        }

        public Node(Item item){
            this.prev = null;
            this.next = null;
            this.item = item;
        }

        public Node(Node prev,Node next,Item item){
            this.prev = prev;
            this.next = next;
            this.item = item;
        }

    }

    public class ItemIterator implements ListIterator<Item>{
        Node current;
        int index;

        public ItemIterator(){
            current = itemList;
            index = 0;
        }

        public boolean hasNext() {
            if(current == null)
                return false;
            if (current.next == null)
                    return false;
            return true;
        }

        public Item next() {
            if(current != null)
            {
                if(hasNext()) {
                    current = current.next;
                    index++;
                    Item data = (Item) current.item;
                    return data;
                }
            }
            current = null;
            return null;
        }



        public boolean hasPrevious() {
            if(current == null)
                return false;
            if (current.prev == null)
                return false;
            return true;
        }


        public Item previous() {
            if(hasPrevious()) {
                current = current.prev;
                Item data = (Item) current.item;
                index--;
                return data;
            }
            return null;

        }

        @Override
        public int nextIndex() {
            if(hasNext()){
                return index+1;
            }
            return -1;
        }

        @Override
        public int previousIndex() {
            if(hasPrevious()){
                return index-1;
            }
            return -1;
        }

        @Override
        public void remove() {
            if(hasNext() && hasPrevious()) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current = current.next;
            }
            else if(hasNext()){
                current.next.prev = null;
                current = current.next;
            }
            else if(hasPrevious()){
                current.prev.next = null;
                current = current.prev;
            }
            else
                current = null;
        }

        @Override
        public void set(Item t) {
            current.item = t;
        }

        @Override
        public void add(Item t) {
            Node nou = new Node(t);
            if (current == null){
                current = nou;
            }

            else
                if(hasNext()){
                    current.next.prev = nou;
                    nou.next = current.next;
                    nou.prev = current;
                    current.next = nou;
                }
                else
                {
                    current.next = nou;
                    nou.prev = current;
                    nou.next = null;
                }

        }
    }

    class ItemComparator implements Comparator<Item> {

        public int compare(Item first,Item second) {
            double comparator;
            if (first == null)
                return 1;
            if (first.getPrice() == second.getPrice()) {
                return first.getName().compareTo(second.getName());
            }
            else {
                comparator = first.getPrice() - second.getPrice();
                if(comparator>0)
                    return 1;
                return -1;
            }
        }
    }

    //Values



    //Constructor

    public ItemList() {
        itemList = null;
    }

    //Methods

    public boolean add (Item e){
        Item element = new Item(e.getName(),e.getId(),e.getPrice());
        if (isEmpty()){
            itemList = new Node(element);

            return true;
        }

        ItemIterator it = new ItemIterator();
        ItemComparator comparator = new ItemComparator();
        while(it.current != null){
            if(comparator.compare(it.current.item,element)<0){
                if(it.hasNext()){
                    it.next();

                }
                else {
                    it.add(element);
                    return true;
                }
            }
            else{
                if (it.hasPrevious()){
                    it.previous();
                    it.add(element);
                    return true;
                }
                else {

                    Node nou = new Node(null,itemList,element);
                    itemList.prev = nou;
                    itemList = nou;
                    return true;
                }
            }
        }
        return false;

    }

    public Item getItem(int index){
        boolean okiei = false;
        if(isEmpty())
            return null;
        ItemIterator it = new ItemIterator();
        while (it.current != null){
            if (it.index == index){
                okiei = true;
                break;

            }
            it.next();
        }
        if (okiei)
            return it.current.item;
        return null;
    }

    public int indexOf(Item item){
        if(isEmpty())
            return -1;
        ItemIterator it = new ItemIterator();
        while (it.current != null){
            if (it.current.item == item)
                break;
            it.next();
        }
        return it.index;
    }

    public boolean contains(Item item){
        if(isEmpty()) {
            return false;
        }
        ItemIterator it = new ItemIterator();
        while (it.current != null){

            if (it.current.item.getId() == item.getId())
                return true;
            it.next();
        }
        return false;
    }

    public void modifyPrice(Item item, Double price){
        if(isEmpty()) {
            return;
        }
        ItemIterator it = new ItemIterator();
        while (it.current != null){

            if (it.current.item.getId() == item.getId()){
                it.current.item.setPrice(price);
                return;
            }
            it.next();
        }
    }

    public boolean remove(Item item){

        if(isEmpty())
            return false;
        ItemIterator it = new ItemIterator();
        while (it.current != null){

            if (it.current.item.getId() == item.getId()) {
                if(it.hasPrevious()&&it.hasNext()){

                    it.current.prev.next = it.current.next;
                    it.current.next.prev = it.current.prev;
                    it.current = null;
                    return true;
                }else if(it.hasPrevious()){

                    it.current.prev.next = null;
                    it.current =null;
                    return true;
                }else if(it.hasNext()){
                    it.current.next.prev = null;
                    itemList = it.current.next;
                    return true;
                }
                else {
                    itemList = null;
                }

            }
            it.next();
        }


        return false;
    }

    public boolean isEmpty(){
        if (itemList == null)
                return true;
        return false;
    }

    public ItemIterator itemIterator(){
        return new ItemIterator() ;
    }

    public Double getTotalPrice(){
        Double sum = new Double(0);
        ItemIterator it = new ItemIterator();
        while (it.current != null){
            sum = sum + it.current.item.getPrice();
            it.next();
        }
        return sum;
    }


    @Override
    public String toString() {
        String rez = new String();
        ItemIterator it = new ItemIterator();
        Item element;
        if(it.current == null) {
            //System.out.println("Lista goala!");
            return null;
        }
        rez = rez+it.current.item;
        while(it.hasNext()){
            element = it.next();
            rez = rez + element;
        }
        return rez;
    }




}
