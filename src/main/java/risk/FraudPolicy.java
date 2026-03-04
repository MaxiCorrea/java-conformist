package risk;

import billing.InvoiceDTO;

public class FraudPolicy {

	public FraudeResult evaluate(
			final InvoiceDTO dto) {
		
		// adapt status code
		boolean isPending = dto.getStatusCode().equals("02");
		boolean isHighAmount = dto.getTotalAmount() != null && dto.getTotalAmount() > 1_000_000;
		
		if(isPending && isHighAmount)
			return FraudeResult.HIGH_RISK;
		
		return FraudeResult.LOW_RISK;
	}
	
}
