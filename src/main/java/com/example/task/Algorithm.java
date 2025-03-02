package com.example.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.task.models.Invoice;
import com.example.task.models.Order;
import com.example.task.models.Product;

@Service
public class Algorithm {
    private static final double MAX_PRICE = 500;
    private int orderId = 1;
    private double orderSubTotal = 0;
    private double orderVat = 0;
    private double orderTotal = 0;
    private List<Invoice> invoices = new ArrayList<>();

    public Order generateInvoices(List<Product> products) {
        int invoiceId = 1;
        Invoice invoice = new Invoice(invoiceId++);

        for(Product product : products) {
            Map<String, Object> invoiceLine;
            double subTotalPrice = product.getPrice() - product.getDiscount();
            double vatPrice = subTotalPrice * product.getVat() / 100;
            double totalPrice = subTotalPrice + vatPrice;
            int remQuantity = product.getQuantity();

            if(totalPrice > MAX_PRICE) {
                while (remQuantity > 0) {
                    invoiceLine = makeInvoiceLine(product.getProduct(), 1, product.getPrice(), product.getDiscount(), product.getVat(), subTotalPrice, totalPrice);
                    invoice.addItem(invoiceLine);
                    invoice.setSubTotal(subTotalPrice);
                    invoice.setVat(vatPrice);
                    invoice.setTotal(totalPrice);
                    invoices.add(invoice);
                    invoice = new Invoice(invoiceId++);
                    remQuantity --;
                }
                continue;
            }

            while (remQuantity > 0) {
                for(Invoice i : invoices) {
                    if(!productCap(i, product.getProduct())) {
                        double priceLeft = MAX_PRICE - i.getTotal();
                        if(priceLeft >= totalPrice) {
                            int placesLeft = (int) Math.floor(priceLeft / totalPrice);
                            if((placesLeft >= 50) && (remQuantity >= 50)) {
                                invoiceLine = makeInvoiceLine(product.getProduct(), 50, product.getPrice(), product.getDiscount(), product.getVat(), subTotalPrice, totalPrice);
                                i.addItem(invoiceLine);
                                remQuantity -= 50;
                                i.setSubTotal(50 * subTotalPrice);
                                i.setVat(50 * vatPrice);
                                i.setTotal(50 * totalPrice);
                                if (remQuantity == 0) break;
                            } else {
                                int productsAdded = Math.min(remQuantity, placesLeft);
                                invoiceLine = makeInvoiceLine(product.getProduct(), productsAdded, product.getPrice(), product.getDiscount(), product.getVat(), subTotalPrice, totalPrice);
                                i.addItem(invoiceLine);
                                remQuantity -= productsAdded;
                                i.setSubTotal(productsAdded * subTotalPrice);
                                i.setVat(productsAdded * vatPrice);
                                i.setTotal(productsAdded * totalPrice);
                                if (remQuantity == 0) break;
                            }
                        }
                    }
                }

                if (remQuantity > 0) {
                    if(remQuantity >= 50 && (50 * totalPrice) <= MAX_PRICE) {
                        int batches = (int) Math.floor(remQuantity / 50);
                        for (int i=0; i<batches; i++) {
                            invoiceLine = makeInvoiceLine(product.getProduct(), 50, product.getPrice(), product.getDiscount(), product.getVat(), subTotalPrice, totalPrice);
                            invoice.addItem(invoiceLine);
                            remQuantity -= 50;
                            invoice.setSubTotal(50 * subTotalPrice);
                            invoice.setVat(50 * vatPrice);
                            invoice.setTotal(50 * totalPrice);
                            invoices.add(invoice);
                            invoice = new Invoice(invoiceId++);
                        }
                    }
                    int placesByPrice = (int) Math.floor(MAX_PRICE / totalPrice);
                    int productsAdded = Math.min(remQuantity, placesByPrice);
                    invoiceLine = makeInvoiceLine(product.getProduct(), productsAdded, product.getPrice(), product.getDiscount(), product.getVat(), subTotalPrice, totalPrice);
                    invoice.addItem(invoiceLine);
                    remQuantity -= productsAdded;
                    invoice.setSubTotal(productsAdded * subTotalPrice);
                    invoice.setVat(productsAdded * vatPrice);
                    invoice.setTotal(productsAdded * totalPrice);
                    invoices.add(invoice);
                    invoice = new Invoice(invoiceId++);
                    if (remQuantity == 0) break;
                }

            }

        }

        for(Invoice i : invoices) {
            orderSubTotal += i.getSubTotal();
            orderVat += i.getVat();
            orderTotal += i.getTotal();
        }

        return new Order(orderId, orderSubTotal, orderVat, orderTotal, invoices);

    }

    private Map<String, Object> makeInvoiceLine(String product, int quantity, double price, double discount, int vat, double subTotalPrice, double totalPrice) {
        Map<String, Object> invoiceLine = new HashMap<>();
        double vatPrice = subTotalPrice * vat/100;

        invoiceLine.put("Description", product);
        invoiceLine.put("Quantity", (Integer) quantity);
        invoiceLine.put("Price", (Double) price);
        invoiceLine.put("Discount", (Double) discount);
        invoiceLine.put("VAT", (Integer) vat);
        invoiceLine.put("Total", ((quantity*subTotalPrice) + " + " + (quantity*vatPrice) + " = " + (quantity*totalPrice)));

        return invoiceLine;
    }

    private boolean productCap(Invoice invoice, String product) {
        for (Map<String, Object> invoiceLine : invoice.getItems()) {
            if(product.equals(invoiceLine.get("Description")) && ((int) invoiceLine.get("Quantity")==50)) {
                return true;
            }
        }
        return false;
    }

}
