package br.edu.ifpb.padroes.service.payment;

import br.edu.ifpb.padroes.service.payment.PaymentService.PaymentType;

public class DebitType implements PaymentServiceStrategy{
	
	public String paymentMethod(PaymentType type) {
		 return "Do debit payment!";
	}
	
}
