package model;

import java.util.List;

public class Invoice_formatting{
	private String message;
	
	public Invoice_formatting(Invoice invoice) {
		StringBuilder formattedInvoice = new StringBuilder("Invoice for " + invoice.getCustomer() + "\n");
        List<Item> items = invoice.getItems();
        
        for (Item item : items) {
            formattedInvoice.append(item.getName())
                            .append(": ")
                            .append(item.getQuantity())
                            .append(" x ")
                            .append(item.getPrice())
                            .append(" = ")
                            .append(item.getQuantity() * item.getPrice())
                            .append("\n");
        }
        
        formattedInvoice.append("Total: ").append(invoice.calculateTotal());
        
        this.message =  formattedInvoice.toString();
    }
	
	public String getInvoice_formatting() {
		return this.message;
	}
}
