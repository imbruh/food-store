package br.edu.ifpb.padroes.service.payment;

import br.edu.ifpb.padroes.service.payment.PaymentService.PaymentType;

public interface PaymentServiceStrategy {
	String paymentMethod(PaymentType type);
}
