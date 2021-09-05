package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.mail.EmailNotification;

public interface OrderStatusState {
	void paymentSuccess(EmailNotification emailNotification, LogService logService, Order order);
	void paymentRefuse(EmailNotification emailNotification, LogService logService, Order order);
	void cancelled(EmailNotification emailNotification, LogService logService, Order order);
}
