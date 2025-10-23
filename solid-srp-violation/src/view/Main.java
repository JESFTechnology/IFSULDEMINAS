package view;

import model.Invoice;
import model.Invoice_formatting;
import model.Item;
import model.Notification;

public class Main {
    public static void main(String[] args) {
        
        Invoice invoice = new Invoice("Emerson Carvalho");
        invoice.addItem(new Item("Produto A", 2, 50));
        invoice.addItem(new Item("Produto B", 3, 30));
        
        Invoice_formatting invoice_formatting = new Invoice_formatting(invoice);
        Notification notification = new Notification(invoice_formatting.getInvoice_formatting());
        String message = notification.sendEmail("emerson@email.com");
        notification.sendSerial(message);
    }
}