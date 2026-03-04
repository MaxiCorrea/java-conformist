package billing;

public final class InvoiceDTO {

	private String invoiceId;
	private String customerDocument;
	private String invoiceType; // A, B, C
	private Double totalAmount;
	private String currencyCode;
	private String statusCode; // 01 = Paid, 02 = Pending

	public InvoiceDTO(
			String invoiceId, 
			String customerDocument, 
			String invoiceType, 
			Double totalAmount,
			String currencyCode, 
			String statusCode) {
		
		this.invoiceId = invoiceId;
		this.customerDocument = customerDocument;
		this.invoiceType = invoiceType;
		this.totalAmount = totalAmount;
		this.currencyCode = currencyCode;
		this.statusCode = statusCode;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public String getCustomerDocument() {
		return customerDocument;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getStatusCode() {
		return statusCode;
	}
	
}
