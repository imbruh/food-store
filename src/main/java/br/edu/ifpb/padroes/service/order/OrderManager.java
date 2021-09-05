package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.log.LogHandler;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.payment.PaymentService;
import br.edu.ifpb.padroes.service.mail.EmailNotification;

public class OrderManager {

    public OrderManager(Order order) {
        this.order = order;
    }

    private Order order;

    private EmailNotification emailNotification = new EmailNotification();

    private PaymentService paymentService = new PaymentService(null);

    private LogService logService = new LogService(new LogHandler(LogHandler.LogHandlerType.FILE));
    
    private OrderStatusEnum orderStatus = new OrderStatusEnum();
    

    public void payOrder(PaymentService.PaymentType paymentType, PaymentService paymentMethodStrategy) {
        order.setStatus(Order.OrderStatus.IN_PROGRESS);
        try {
        	paymentService = paymentMethodStrategy;
            paymentService.doPayment(paymentType);
            
            order.setStatus(Order.OrderStatus.PAYMENT_SUCCESS);
            orderStatus.paymentSuccess(emailNotification, logService, order);
            
        } catch (Exception e) {
        	 order.setStatus(Order.OrderStatus.PAYMENT_REFUSED);
        	 orderStatus.paymentRefuse(emailNotification, logService, order);
        }
    }

    public void cancelOrder() {
    	  order.setStatus(Order.OrderStatus.CANCELED);
    	  orderStatus.cancelled(emailNotification, logService, order);
    }

}
