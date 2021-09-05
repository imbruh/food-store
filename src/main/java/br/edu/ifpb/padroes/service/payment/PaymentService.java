package br.edu.ifpb.padroes.service.payment;

public class PaymentService {

    public enum PaymentType {
        CREDIT_CARD, DEBIT, BILLET, PAYPAL
    }
    
    PaymentServiceStrategy strategy;
    
    public PaymentService(PaymentServiceStrategy strategy) {
    	this.strategy = strategy;
    }

    public void doPayment(PaymentType type) throws Exception {
    	System.out.println(strategy.paymentMethod(type)); 
    
    }

}
