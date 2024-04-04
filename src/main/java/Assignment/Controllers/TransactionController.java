package Assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Assignment.Services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    // Controller method for making payment
    @PostMapping("/{userId}/{orderId}/pay" )
    public ResponseEntity<Object> makePayment(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId , @RequestParam Long amount) {
        return transactionService.makePayment(userId, orderId,amount);
    }
}
