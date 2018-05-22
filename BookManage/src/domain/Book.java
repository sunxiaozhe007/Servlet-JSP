package domain;

import java.io.Serializable;

public class Book implements Serializable {
    private String id;
    private String name;
    private double price;
    private double pnum;
    private String category;
    private String desciption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public double getPnum() {
        return pnum;
    }

    public void setPnum(double pnum) {
        this.pnum = pnum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pnum=" + pnum +
                ", category='" + category + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }
}
