package Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Assignment.Entities.Inventory;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long>{

}
