package BTG.project.orderms.listener;

import BTG.project.orderms.dto.OrderCreatedEvent;

import BTG.project.orderms.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;



import static BTG.project.orderms.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {

    @Autowired
    OrderService service;

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    @RabbitListener( queues =ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {
        logger.info("Message consumed: {} ",message);

        service.save(message.getPayload());

    }

}
