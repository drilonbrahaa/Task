package com.example.task.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Invoice {
    private String invoiceId;
    private List<Map<String, Object>> items;
    private double subTotal;
    private double vat;
    private double total;


    public Invoice() { }
    public Invoice(int id) {
        this.invoiceId = "Invoice " + id;
        this.items = new ArrayList<>();
        this.subTotal = 0;
        this.vat = 0;
        this.total = 0;
    }

    public String getInvoiceId() {
        return this.invoiceId;
    }
    public void setInvoiceId(int id) {
        this.invoiceId = "Invoice " + id;
    }

    public List<Map<String, Object>> getItems() {
        return this.items;
    }
    public void addItem(Map<String, Object> item) {
        this.items.add(item);
    }

    public double getSubTotal() {
        return this.subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal += subTotal;
    }

    public double getVat() {
        return vat;
    }
    public void setVat(double vat) {
        this.vat += vat;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total += total;
    }

}
