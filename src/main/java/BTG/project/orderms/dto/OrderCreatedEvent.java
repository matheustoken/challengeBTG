package BTG.project.orderms.dto;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedido,
                                Long codigoCliente,
                                List<OrderItemEvent>itens) {


}
