package com.example.task.models;

import java.util.List;

public class Order {
    private String orderId;
    private double subTotal;
    private double vat;
    private double total;
    private List<Invoice> invoices;

    public Order() { }
    public Order(int orderId, double subTotal, double vat, double total, List<Invoice> invoices) {
        this.orderId = "Order " + orderId;
        this.subTotal = subTotal;
        this.vat = vat;
        this.total = total;
        this.invoices = invoices;
    }

    public String getOrderId() {
        return this.orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = "Order " + orderId;
    }

    public double getSubTotal() {
        return this.subTotal;
    }
    public void setSubtTotal(double subTotal) {
        this.subTotal += subTotal;
    }

    public double getVat() {
        return this.vat;
    }
    public void setVat(double vat) {
        this.vat += vat;
    }

    public double getTotal() {
        return this.total;
    }
    public void setTotal(double total) {
        this.total += total;
    }

    public List<Invoice> getInvoices() {
        return this.invoices;
    }
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

}
