package com.example.task.models;

public class Product {
    private String product;
    private int quantity;
    private double price;
    private double discount;
    private int vat;

    public Product(){ }
    public Product(String product, int quantity, double price, double discount, int vat) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.vat = vat;
    }

    public String getProduct(){
        return this.product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return this.discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getVat() {
        return this.vat;
    }
    public void setVat(int vat) {
        this.vat = vat;
    }

}
