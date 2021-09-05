package br.edu.ifpb.padroes.service.payment;

import br.edu.ifpb.padroes.service.payment.PaymentService.PaymentType;

public class BilletType implements PaymentServiceStrategy{

	public String paymentMethod(PaymentType type) {
		 return "Do billet payment!";
	}
	
}
