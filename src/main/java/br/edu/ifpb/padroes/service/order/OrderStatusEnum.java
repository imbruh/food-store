package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.mail.EmailNotification;

public class OrderStatusEnum implements OrderStatusState{
	
			public void paymentSuccess(EmailNotification emailNotification, LogService logService, Order order) {
				emailNotification.sendMailNotification(String.format("Order %d completed successfully", order.getId()));
	            logService.info("payment finished");
			}
			
			public void paymentRefuse(EmailNotification emailNotification, LogService logService, Order order) {			 
		         emailNotification.sendMailNotification(String.format("Order %d refused", order.getId()));
		         logService.error("payment refused");
			}
			
			public void cancelled(EmailNotification emailNotification, LogService logService, Order order) {
		        emailNotification.sendMailNotification(String.format("Order %d canceled", order.getId()));
		        logService.debug(String.format("order %d canceled", order.getId()));
			}
}
