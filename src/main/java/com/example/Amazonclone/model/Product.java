//Create a endpoint that will create products to be added to the database.The below is the data that must be added when a product is created:
//        Product name,
//        Product price,
//        Product description or details,
//        Product category
//        Product quantity
//        A value that will indicate if the product is a  bestseller product (or not).
//        Upload a photo of the product (to keep the project simple, only upload one image per product).


package com.example.Amazonclone.model;
import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private String id;
    private  String name;
    private float price;
    private String desc;
    private String category;
    private int qty;
    private boolean bestSeller;
    private String img;
    public Product() {
    }

    public Product(String id, String name, float price, String desc, String category, int qty, boolean bestSeller, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.category = category;
        this.qty = qty;
        this.bestSeller = bestSeller;
        this.img = img;
    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", category='" + category + '\'' +
                ", qty=" + qty +
                ", bestSeller=" + bestSeller +
                ", img='" + img + '\'' +
                '}';
    }
}
