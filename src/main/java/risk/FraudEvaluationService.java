package risk;

import billing.BillingService;
import billing.InvoiceDTO;

public final class FraudEvaluationService {

	private final BillingService billingService;
	private final FraudPolicy fraudPolicy;
	
	public FraudEvaluationService(
			final BillingService billingService,
			final FraudPolicy fraudPolicy) {
		
		this.billingService = billingService;
		this.fraudPolicy = fraudPolicy;
	}
	
	public FraudeResult evaluateInvoice(
			final String invoiceId) {
		InvoiceDTO dto = billingService.getInvoiceById(invoiceId);
		return fraudPolicy.evaluate(dto);
	}
	
}
