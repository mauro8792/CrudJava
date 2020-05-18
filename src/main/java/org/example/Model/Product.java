package org.example.Model;


public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String brand;
    private Integer unit;
    private Integer quantity;
    private Float discount;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getUnit() {
        return unit;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public Float getDiscount() {
        return discount;
    }

    public static class BuilderProduct{
        private Integer id;
        private String name;
        private Double price;
        private String brand;
        private Integer unit;
        private Integer quantity;
        private Float discount;

        public BuilderProduct id (Integer id){
            this.id = id;
            return this;
        }

        public BuilderProduct name(String name){
            this.name = name;
            return this;
        }
        public BuilderProduct price(Double price){
            this.price = price;
            return this;
        }
        public BuilderProduct brand(String brand){
            this.brand = brand;
            return this;
        }
        public BuilderProduct unit(Integer unit){
            this.unit = unit;
            return this;
        }
        public BuilderProduct quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        public BuilderProduct discount(Float discount){
            this.discount = discount;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
    private Product(BuilderProduct b){
        this.id = b.id;
        this.name = b.name;
        this.brand = b.brand;
        this.price = b.price;
        this.unit = b.unit;
        this.quantity = b.quantity;
        this.discount = b.discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
