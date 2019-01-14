package supermarket;

public class Item {
    //VALUES
    private String name;
    private Double id;
    private Double price;


    //CONSTRUCTOR

    public Item(String name, Double id, Double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }


    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    //METHODS

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ']';
    }
}
