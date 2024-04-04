package Assignment.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Assignment.Entities.InventoryStatus;
import Assignment.Repository.InventoryRepository;
import Assignment.Repository.OrderRepository;

@Service
public class ProductService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    public InventoryStatus getInventory() throws Exception{
        int totalOrdered = orderRepository.findAll().size();// this will get inventory quantity
        int availableQuantity = 100 - totalOrdered; //setting fixed quantity for now
        double price = 100; // Assuming the price is fixed
        return new InventoryStatus(totalOrdered, price, availableQuantity);
    }

}
