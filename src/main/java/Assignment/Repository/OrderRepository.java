package Assignment.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Assignment.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
