package Assignment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Assignment.Entities.Order;
import Assignment.Entities.User;
import Assignment.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private CouponService couponService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public Order placeOrder(Long userId, int quantity, String couponCode) throws Exception {
        // Get the discount for the provided coupon code
        int discount = couponService.getDiscount(couponCode);

        int availableQuantity = productService.getInventory().getAvailable();

        if(quantity<0 || quantity>availableQuantity){
            throw new Exception("Invalid Quantity");
        }

        // Calculate the amount after applying the discount
        double price = 100; // Assuming fixed price for the product
        double amount = quantity * price * (1 - discount / 100.0);

        // Generate order and return it
        Order order = new Order();
        order.setQuantity(quantity);
        order.setAmount(amount);
        order.setCoupon(couponCode);

        return order;

    }



    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }



    public List<Order> getOrdersByUserId(Long userId) throws Exception{
        try {
            User user = userService.getUserById(userId);
            List<Order> orders = user.getOrders();
            return orders;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    public Order getOrderById(Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderById'");
    }


}
