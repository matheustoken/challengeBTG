package BTG.project.orderms.service;


import BTG.project.orderms.dto.OrderCreatedEvent;
import BTG.project.orderms.entities.OrderEntity;
import BTG.project.orderms.entities.OrderItem;
import BTG.project.orderms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public void save(OrderCreatedEvent event){
        var entity = new OrderEntity();
        entity.setOrderId(event.codigoPedido());

        entity.setCustomerId(event.codigoCliente());
        entity.setItens(getOrderItems(event));
        entity.setTotal(getTotal(event));

        repository.save(entity);
}
    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> i.preco() != null ? i.preco().multiply(BigDecimal.valueOf(i.quantidade())) : BigDecimal.ZERO)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> new OrderItem(
                        i.produto(),
                        i.quantidade(),
                        i.preco() != null ? i.preco() : BigDecimal.ZERO
                ))
                .toList();
    }



}
