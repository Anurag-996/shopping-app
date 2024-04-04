package Assignment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Assignment.Services.OrderService;
import Assignment.Services.UserService;
import Assignment.Entities.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/order")
    public ResponseEntity<Object> placeOrder(
        @PathVariable("userId") Long userId,
        @RequestParam("qty") int quantity,
        @RequestParam("coupon") String couponCode) {

        try {
            // Fetch the user from the database based on userId
            User user = userService.getUserById(userId);

            // Create the order
            Order order = orderService.placeOrder(userId, quantity, couponCode);

            // Set the user for the order
            order.setUser(user);

            Order savedOrder = orderService.saveOrder(order);

            // Here you can save the order to the database if needed

            // Return the order response
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{userId}/orders")
    public ResponseEntity<Object> getUserOrders(@PathVariable Long userId) {
        // Assuming you have a method in your service layer to fetch orders by user ID
        try {
            List<Order> orders = orderService.getOrdersByUserId(userId);
            return new ResponseEntity<>(orders,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    

    @GetMapping("/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long userId, @PathVariable Long orderId) {
        try {
            // Retrieve the order and associated user
            Order order = orderService.getOrderById(orderId);
            User user = userService.getUserById(userId);

            if (order != null && user != null && order.getUser().getId().equals(userId)) {
                // Combine data from order and user entities into a custom response object
                CustomOrderResponse response = new CustomOrderResponse(
                    order.getOrderId(), 
                    order.getAmount(), 
                    order.getDate(), 
                    order.getCoupon(), 
                    "tran010100002", 
                    200, 
                    user.getUserName(), 
                    user.getEmail()
                );
                return new ResponseEntity<>(response,HttpStatus.OK);
            } else {
                // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                //         new ErrorResponse(orderId, "Order not found"));

                throw new Exception("Invalid detail");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    

}
