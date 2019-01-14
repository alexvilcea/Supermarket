package supermarket;


import supermarket.ItemList.ItemList;
import supermarket.ItemList.WishList;
import supermarket.customer.Customer;
import supermarket.department.*;
import supermarket.notifictation.Notification;
import supermarket.notifictation.NotificationType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Test {

    public void readStore(File file) {
        try {

            Scanner sc = new Scanner(file);

            String line = sc.nextLine();
            Store.getInstance(line);

            while (sc.hasNextLine()) {
                line = sc.nextLine();

                //parse string with ; save results in result
                //result[0]=name of department
                //result[1]=department id
                String[] result = line.split(";");
                if (result[0].equals("BookDepartment")) {
                    Department bookDepartment = new BookDepartment(result[0], Double.valueOf(result[1]));
                    Store.getInstance().addDepartment(bookDepartment);

                    result = null;
                    //next line contains number of Itmes in each department
                    line = sc.nextLine();
                    Integer number_of_items;
                    number_of_items = Integer.valueOf(line);
                    for (int i = 0; i < number_of_items; i++) {
                        line = sc.nextLine();
                        result = line.split(";");
                        Item item = new Item(result[0], Double.valueOf(result[1]), Double.valueOf(result[2]));
                        bookDepartment.addItem(item);
                    }

                } else if (result[0].equals("MusicDepartment")) {
                    Department musicDepartment = new MusicDepartment(result[0], Double.valueOf(result[1]));
                    Store.getInstance().addDepartment(musicDepartment);


                    result = null;
                    //next line contains number of Itmes in each department
                    line = sc.nextLine();
                    Integer number_of_items;
                    number_of_items = Integer.valueOf(line);
                    for (int i = 0; i < number_of_items; i++) {
                        line = sc.nextLine();
                        result = line.split(";");
                        Item item = new Item(result[0], Double.valueOf(result[1]), Double.valueOf(result[2]));
                        musicDepartment.addItem(item);
                    }
                } else if (result[0].equals("SoftwareDepartment")) {
                    Department softwareDepartment = new SoftwareDepartment(result[0], Double.valueOf(result[1]));
                    Store.getInstance().addDepartment(softwareDepartment);


                    result = null;
                    //next line contains number of Itmes in each department
                    line = sc.nextLine();
                    Integer number_of_items;
                    number_of_items = Integer.valueOf(line);
                    for (int i = 0; i < number_of_items; i++) {
                        line = sc.nextLine();
                        result = line.split(";");
                        Item item = new Item(result[0], Double.valueOf(result[1]), Double.valueOf(result[2]));
                        softwareDepartment.addItem(item);
                    }
                } else if (result[0].equals("VideoDepartment")) {
                    Department videoDepartment = new VideoDepartment(result[0], Double.valueOf(result[1]));
                    Store.getInstance().addDepartment(videoDepartment);


                    result = null;
                    //next line contains number of Itmes in each department
                    line = sc.nextLine();
                    Integer number_of_items;
                    number_of_items = Integer.valueOf(line);
                    for (int i = 0; i < number_of_items; i++) {
                        line = sc.nextLine();
                        result = line.split(";");
                        Item item = new Item(result[0], Double.valueOf(result[1]), Double.valueOf(result[2]));
                        videoDepartment.addItem(item);
                    }
                } else {
                    System.out.println("Wrong Department");
                }

                result = null;

            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readCustomers(File file) {
        try {

            Scanner sc = new Scanner(file);

            String line = sc.nextLine();
            int x = Integer.valueOf(line);

            for (int i = 0; i < x; i++) {
                line = sc.nextLine();

                //parse string with ; save results in result
                //result[0]=name of department
                //result[1]=department id
                String[] result = line.split(";");
                Store.getInstance().enter(new Customer(result[0], Double.valueOf(result[1])));
                //TODO
                //REZULT[2]->STRATEGY
                result = null;

            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readEvents(File file, File resultFile) {
        try {

            Scanner sc = new Scanner(file);

            String line = sc.nextLine();
            int x = Integer.valueOf(line);

            for (int i = 0; i < x; i++) {
                line = sc.nextLine();

                //parse string with ; save results in result
                //result[0]=name of department
                //result[1]=department id
                eventHandler(line,resultFile);


            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void eventHandler(String event,File resultFile) {
        String[] result = event.split(";");
        if (result[0].equals("addItem")) {
            addItem(result[1], result[2], result[3]);
        } else if (result[0].equals("delItem")) {
            delItem(result[1], result[2], result[3]);
        } else if (result[0].equals("addProduct")) {
            addProduct(result[1], result[2], result[3], result[4]);
        } else if (result[0].equals("modifyProduct")) {
            modifyProduct(result[1], result[2], result[3]);
        } else if (result[0].equals("delProduct")) {
            delProduct(result[1]);
        } else if (result[0].equals("getItem")) {
            getItem(result[1]);
        } else if (result[0].equals("getItems")) {
            ItemList list = getItems(result[1], result[2]);
            System.out.println(list);
            writeInFile(resultFile,list.toString()+"\n");
        } else if (result[0].equals("getTotal")) {
            Double x;
            x = getTotal(result[1], result[2]);
            System.out.println(x);
            writeInFile(resultFile,x.toString()+"\n");
        } else if (result[0].equals("accept")) {
            accept(result[1], result[2]);
        } else if (result[0].equals("getObservers")) {
            ArrayList x;
            x = getObservers(result[1]);
            System.out.println(x);
            writeInFile(resultFile,x.toString()+"\n");
        } else if (result[0].equals("getNotifications")) {
            ArrayList x;
            x = getNotifications(result[1]);
            System.out.println(x);
            writeInFile(resultFile,x.toString()+"\n");
        }
        //System.out.println(event);

    }

    public void writeInFile(File file,String outputString){
        FileWriter fr = null;
        try {
            fr = new FileWriter(file,true);
            fr.write(outputString);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void addItem(String itemId, String typeList, String customerName) {
        //Cand se adauga un item nou in SC/WL se intampla urmatoarele lucruri
        //SC: 1.se adauga produsul in SC clientului
        //    2.adaugam clientul in departament deoarece a cumparat un produs
        //WL: 1.se adauga produsul in WL clientului
        //    2.adaugam clientul in lista dep.wishers
        //    3.il adaugam in lista de observatori


        //gasim id-ul si Itemul cu id-ul respectiv
        //in x avem itemul in dep avem departamentul din care face parte
        boolean gasit =false;
        Item x = new Item("",null,null);
        Double idItem = Double.valueOf(itemId);
        ListIterator<Department> itDep = Store.getInstance().getDepartments().listIterator();
        Department dep = new BookDepartment("",null);
        while (itDep.hasNext()){
            dep = itDep.next();

            ListIterator<Item> itItem = dep.getItems().listIterator();
            while (itItem.hasNext()){
                x = itItem.next();
                if(x.getId().equals(idItem)){
                    gasit = true;
                    break;
                }
            }
            if(gasit == true)
                break;

        }
        if(gasit ==false) {
            System.out.println("Event addItem error, wrong ItemID!");
            return;
        }


        //gasim clientul cu numele customername
        gasit = false;
        Customer client = new Customer("",null);
        ListIterator<Customer> it = Store.getInstance().getCustomers().listIterator();
        while (it.hasNext()){
            client = it.next();
            if(client.getName().equals(customerName)){
                gasit = true;
                break;
            }
        }
        if(gasit == false) {
            System.out.println("Event addItem error, wrong CustomerName!");
            return;
        }
        // gasim unde sa adaugam

        if(typeList.equals("ShoppingCart")){
            client.getShoppingCart().add(x);  //se adauga produsul in shopping cartul clientului
            dep.enter(client); //adaugam clientul in departament deoarece a cumparat un produs
        }
        else if(typeList.equals("WishList")){
            client.getWishList().add(x);
            if(!dep.getCustomers_wishers().contains(client))
                dep.getCustomers_wishers().add(client);
            dep.addObserver(client);
        }
        else{
            System.out.println("Event addItem error, wrong Type of List!");
        }

    }

    public void delItem(String itemId, String typeList, String customerName) {
        //Cand se sterge un item  in SC/WL se intampla urmatoarele lucruri
        //SC: 1.se sterge produsul in SC clientului
        //    2.daca nu mai e niciun produs al departamentului se sterge din dep_buyers clientul
        //WL: 1.se sterge produsul in WL clientului
        //    2.daca nu mai e niciun produs al departamentului se sterge din dep_wishers clientul
        //    3.daca nu mai e niciun produs al departamentului se sterge din dep_observers clientul



        //gasim id-ul si Itemul cu id-ul respectiv
        //in x avem itemul in dep avem departamentul din care face parte
        boolean gasit =false;
        Item x = new Item("",null,null);
        Double idItem = Double.valueOf(itemId);
        ListIterator<Department> itDep = Store.getInstance().getDepartments().listIterator();
        Department dep = new BookDepartment("",null);
        while (itDep.hasNext()){
            dep = itDep.next();

            ListIterator<Item> itItem = dep.getItems().listIterator();
            while (itItem.hasNext()){
                x = itItem.next();
                if(x.getId().equals(idItem)){
                    gasit = true;
                    break;
                }
            }
            if(gasit == true)
                break;

        }
        if(gasit ==false) {
            System.out.println("Event addItem error, wrong ItemID!");
            return;
        }

        //gasim clientul cu numele customername
        gasit = false;
        Customer client = new Customer("",null);
        ListIterator<Customer> it = Store.getInstance().getCustomers().listIterator();
        while (it.hasNext()){
            client = it.next();
            if(client.getName().equals(customerName)){
                gasit = true;
                break;
            }
        }
        if(gasit == false) {
            System.out.println("Event addItem error, wrong CustomerName!");
            return;
        }

        if(typeList.equals("ShoppingCart")){
            client.getShoppingCart().remove(x);  //se adauga produsul in shopping cartul clientului


            //verificam daca clientul mai are produse din departament
            boolean ok = false;

            for (int i = 0 ; i<dep.getItems().size() ; i++){
                if(client.getShoppingCart().contains(dep.getItems().get(i))){
                    ok = true;
                }
            }
            if(ok==false){
                dep.exit(client);
            }

        }
        else if(typeList.equals("WishList")){
            client.getWishList().remove(x);

            boolean ok = false;

            for (int i = 0 ; i<dep.getItems().size() ; i++){
                if(client.getWishList().contains(dep.getItems().get(i))){
                    ok = true;
                }
            }
            if(ok==false){
                dep.getCustomers_wishers().remove(client);
                dep.removeObserver(client);
            }

        }
        else{
            System.out.println("Event addItem error, wrong Type of List!");
        }

    }

    public void addProduct(String depId, String itemId, String price, String name) {
        //Cand se adauga un Produs in departament
        //se adauga produsul in departament
        //trebuie notificati toti observatorii departamentului

        Double idDep = Double.valueOf(depId);
        Double idItem = Double.valueOf(itemId);
        Double p = Double.valueOf(price);

        //gasim departamentul in fucntie de id
        boolean gasit = false;
        Department dep = new BookDepartment(null,null);
        ListIterator<Department> itDep = Store.getInstance().getDepartments().listIterator();
        while (itDep.hasNext()){
            dep = itDep.next();
            if(dep.getId().equals(idDep)){
                gasit = true;
                break;
            }
        }
        if(gasit == true){
            dep.addItem(new Item(name,idItem,p));
            dep.notifyAllObservers(new Notification(new Date(),idDep,idItem,NotificationType.ADD));
        }



    }

    public void modifyProduct(String depId, String itemId, String price) {
        //Cand se modifica un Produs in departament
        //se modifica produsul in departament
        //trebuie notificati toti observatorii departamentului
        // se modifica produsul in SC si WL
        Double idDep = Double.valueOf(depId);
        Double idItem = Double.valueOf(itemId);
        Double p = Double.valueOf(price);

        //gasim departamentul in fucntie de id si il salvam in dep
        boolean gasit = false;
        Department dep = new BookDepartment(null,null);
        ListIterator<Department> itDep = Store.getInstance().getDepartments().listIterator();
        while (itDep.hasNext()){
            dep = itDep.next();
            if(dep.getId().equals(idDep)){
                gasit = true;
                break;
            }
        }
        if(gasit == false){
            System.out.println("Event modifyProduct error, wrong depID!");
        }

        //gasim itemul in functie de id
        Item x = new Item("",null,null);
        gasit = false;
        ListIterator<Item> itItem = dep.getItems().listIterator();
        while (itItem.hasNext()){
            x = itItem.next();
            if(x.getId().equals(idItem)){
                gasit = true;
                break;
            }
        }
        if(gasit == false){
            System.out.println("Event modifyProduct error, wrong itemID!");
        }

        //modificam pretul produsului in depratament
        x.setPrice(p);

        // il modificam in WL si SL
        ListIterator<Customer> it1 = dep.getCustomers_wishers().listIterator(); //WL
        ListIterator<Customer> it2 = dep.getCustomers_buyers().listIterator();  //SC
        Customer client;
        while(it1.hasNext()){
            client = it1.next();
            if(client.getWishList().contains(x)){
                //client.getWishList().modifyPrice(x,p); //modific WL clientului
                //TODO
                //Modific produsul cu remove si add pentru a pastra lista sortata
                client.getWishList().remove(x);
                client.getWishList().add(x);

            }
        }
        while(it2.hasNext()){
            client = it2.next();
            if(client.getShoppingCart().contains(x)){
                //client.getShoppingCart().modifyPrice(x,p); //modific SC clientului
                client.getShoppingCart().remove(x);
                client.getShoppingCart().add(x);
            }
        }

        dep.notifyAllObservers(new Notification(new Date(),idDep,idItem,NotificationType.MODIFY));

    }

    public void delProduct(String itemId) {
        //Cand se sterge un Produs in departament
        //se sterge produsul din lista de iteme a dep
        //trebuie notificati toti observatorii departamentului
        //se modifica WL/SL clientilor din acel departament

        //gasim id-ul si Itemul cu id-ul respectiv
        //in x avem itemul in dep avem departamentul din care face parte
        boolean gasit =false;
        Item x = new Item("",null,null);
        Double idItem = Double.valueOf(itemId);
        ListIterator<Department> itDep = Store.getInstance().getDepartments().listIterator();
        Department dep = new BookDepartment("",null);
        while (itDep.hasNext()){
            dep = itDep.next();

            ListIterator<Item> itItem = dep.getItems().listIterator();
            while (itItem.hasNext()){
                x = itItem.next();
                if(x.getId().equals(idItem)){
                    gasit = true;
                    break;
                }
            }
            if(gasit == true)
                break;

        }
        if(gasit ==false) {
            System.out.println("Event addItem error, wrong ItemID!");
            return;
        }

        //Verificam pentru fiecare customer al departamentului daca itemul e in WL/SC
        //PENTRU WL

        boolean ok = false;
        ListIterator<Customer> it1 = dep.getCustomers_wishers().listIterator(); //WL
        ListIterator<Customer> it2 = dep.getCustomers_buyers().listIterator();  //SC
        Customer client;
        while(it1.hasNext()){
            client = it1.next();
            if(client.getWishList().contains(x)){

                client.getWishList().remove(x); //modific WL clientului
                //verific daca are alt item din dep in WL inafara de cel sters

                for (int i = 0 ; i<dep.getItems().size() ; i++){
                    if(client.getWishList().contains(dep.getItems().get(i))){
                        ok = true;
                    }
                }
                if(ok==false){
                    dep.getCustomers_wishers().remove(client);
                    dep.removeObserver(client);
                    // daca a fost exclus clientul din observers nu va
                    // mai primii notificare si o sa trebuiasca sa ii trimitem individual
                    client.addNotification(new Notification(new Date(),dep.getId(),idItem,NotificationType.REMOVE));
                }

            }
        }

        //PENTRU SC

        ok =false;
        while(it2.hasNext()){
            client = it2.next();
            if(client.getShoppingCart().contains(x)){
                client.getShoppingCart().remove(x); //modific SC clientului
                //verific daca are alt item din dep in SC inafara de cel sters

                for (int i = 0 ; i<dep.getItems().size() ; i++){
                    if(client.getShoppingCart().contains(dep.getItems().get(i))){
                        ok = true;
                    }
                }
                if(ok==false){
                    dep.exit(client);

                }

            }
        }

        //Stergem produsul din departament
        dep.getItems().remove(x);
        dep.notifyAllObservers(new Notification(new Date(),dep.getId(),idItem,NotificationType.REMOVE));

    }

    public Item getItem(String customerName) {
        return null;
    }

    public ItemList getItems(String typeList, String customerName) {
        //gasim clientul cu numele customername
        // il vom retine in variabila client
        boolean gasit = false;
        Customer client = new Customer("",null);
        ListIterator<Customer> it = Store.getInstance().getCustomers().listIterator();
        while (it.hasNext()){
            client = it.next();
            if(client.getName().equals(customerName)){
                gasit = true;
                break;
            }
        }
        if(gasit == false) {
            System.out.println("Event addItem error, wrong CustomerName!");
            return null;
        }

        if(typeList.equals("ShoppingCart")){
            return client.getShoppingCart();
        }
        else if(typeList.equals("WishList")){
            return client.getWishList();
        }
        else{
            System.out.println("Event addItem error, wrong Type of List!");
            return null;
        }




    }

    public Double getTotal(String typeList, String customerName) {
        //gasim clientul cu numele customername
        // il vom retine in variabila client
        boolean gasit = false;
        Customer client = new Customer("",null);
        ListIterator<Customer> it = Store.getInstance().getCustomers().listIterator();
        while (it.hasNext()){
            client = it.next();
            if(client.getName().equals(customerName)){
                gasit = true;
                break;
            }
        }
        if(gasit == false) {
            System.out.println("Event addItem error, wrong CustomerName!");
            return null;
        }

        if(typeList.equals("ShoppingCart")){
            return client.getShoppingCart().getTotalPrice();
        }
        else if(typeList.equals("WishList")){
            return client.getWishList().getTotalPrice();
        }
        else{
            System.out.println("Event addItem error, wrong Type of List!");
            return null;
        }

    }

    public void accept(String depId, String customerName) {
        Double idDep = Double.valueOf(depId);

        //gasim departamentul in fucntie de id
        boolean gasit = false;
        Department dep = new BookDepartment(null,null);
        ListIterator<Department> itDep = Store.getInstance().getDepartments().listIterator();
        while (itDep.hasNext()){
            dep = itDep.next();
            if(dep.getId().equals(idDep)){
                gasit = true;
                break;
            }
        }
        if(gasit == false) {
            System.out.println("Invalid depID(accept)");
            return;
        }

        gasit = false;
        Customer client = new Customer("",null);
        ListIterator<Customer> it = Store.getInstance().getCustomers().listIterator();
        while (it.hasNext()){
            client = it.next();
            if(client.getName().equals(customerName)){
                gasit = true;
                break;
            }
        }
        if(gasit == false) {
            System.out.println("Event accept error, wrong CustomerName!");
            return;
        }

        dep.accept(client.getShoppingCart());

    }

    public ArrayList getObservers(String depId) {
        Double idDep = Double.valueOf(depId);

        //gasim departamentul in fucntie de id
        boolean gasit = false;
        Department dep = new BookDepartment(null,null);
        ListIterator<Department> itDep = Store.getInstance().getDepartments().listIterator();
        while (itDep.hasNext()){
            dep = itDep.next();
//            System.out.println("LALA");
//            System.out.println(dep.getId());
//            System.out.println(idDep);
            if(dep.getId().equals(idDep)){
                gasit = true;
                break;
            }
        }
        if(gasit == false)
            System.out.println("Invalid depID(getObservers)");

        return dep.getObservers();
    }

    public ArrayList<Notification> getNotifications(String customerName) {
        boolean gasit = false;
        Customer client = new Customer("",null);
        ListIterator<Customer> it = Store.getInstance().getCustomers().listIterator();
        while (it.hasNext()){
            client = it.next();
            if(client.getName().equals(customerName)){
                gasit = true;
                break;
            }
        }
        if(gasit == false) {
            System.out.println("Event accept error, wrong CustomerName!");
            return null;
        }
        return client.getNotificationCollection();
    }


    public static void main(String[] args) {
        Test test = new Test();
//        File storeFile = new File("D:\\POO_teme\\Teste\\test\\store.txt");
//        File customerFile = new File("D:\\POO_teme\\Teste\\test\\customers.txt");
//        File eventFile = new File("D:\\POO_teme\\Teste\\test\\events.txt");
//        File resultFile = new File("D:\\POO_teme\\Teste\\test\\resultMEU.txt");
        File storeFile = new File(args[1]);
        File customerFile = new File(args[2]);
        File eventFile = new File(args[3]);
        File resultFile = new File("D:\\POO_teme\\Teste\\test\\resultMEU.txt");
        test.readStore(storeFile);
        test.readCustomers(customerFile);
        test.readEvents(eventFile,resultFile);
        System.out.println(Store.getInstance());


        //testare

    }
}
