package BTG.project.orderms.repository;

import BTG.project.orderms.entities.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity,Long> {


}
