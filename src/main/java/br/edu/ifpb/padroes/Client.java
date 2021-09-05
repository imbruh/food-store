package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.payment.CreditCardType;
import br.edu.ifpb.padroes.service.payment.PaymentService;

public class Client {
    public static void main(String[] args) {

        Order order = new Order();
        OrderManager orderManager = new OrderManager(order);
        PaymentService paymentMethodStrategy = new PaymentService(new CreditCardType());
        orderManager.payOrder(PaymentService.PaymentType.CREDIT_CARD, paymentMethodStrategy);
        orderManager.cancelOrder();

    }
}
