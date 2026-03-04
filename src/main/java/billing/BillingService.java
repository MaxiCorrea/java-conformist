package billing;

public final class BillingService {

	public InvoiceDTO getInvoiceById(
			final String invoiceId) {
		// Simulation
		return new InvoiceDTO(
				invoiceId, 
				"12231313", 
				"A", 
				1_500_000.0, 
				"ARS", //currency
				"02" // pending
				);
	}
	
}
