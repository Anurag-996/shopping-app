package Assignment.Services;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Assignment.Repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


     public ResponseEntity<Object> makePayment(Long userId, Long orderId, double amount) {
        try {
            // Mock the payment process and randomly generate a status code
            int statusCode = getRandomStatusCode();

            // Handle different status codes
            switch (statusCode) {
                case 200:
                    // Payment successful
                    String transactionId = generateTransactionId();
                    return ResponseEntity.ok(Map.of(
                            "userId", userId,
                            "orderId", orderId,
                            "transactionId", transactionId,
                            "status", "successful"
                    ));
                case 400:
                    // Payment failed due to various reasons
                    return ResponseEntity.badRequest().body(Map.of(
                            "userId", userId,
                            "orderId", orderId,
                            "status", "failed",
                            "description", getFailureDescription()
                    ));
                case 504:
                    // Payment failed due to no response from the payment server
                    return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(Map.of(
                            "userId", userId,
                            "orderId", orderId,
                            "status", "failed",
                            "description", "No response from payment server"
                    ));
                case 405:
                    // Order is already paid for
                    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(Map.of(
                            "userId", userId,
                            "orderId", orderId,
                            "status", "failed",
                            "description", "Order is already paid for"
                    ));
                default:
                    // // Handle other status codes if needed

                    return new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private int getRandomStatusCode() {
        // Generate a random status code among the specified ones
        Random random = new Random();
        int[] statusCodes = {200, 400, 504, 405}; // Add other status codes if needed
        return statusCodes[random.nextInt(statusCodes.length)];
    }

    private String generateTransactionId() {
        // Generate a transaction ID
        return "tran" + new Random().nextInt(1000000);
    }

    private String getFailureDescription() {
        //return random description for failed payment
        String desc1 = "Payment Failed as amount is invalid";
        String desc2 = "Payment Failed from bank";
        String desc3 = "Payment Failed due to invalid order id";

        String[]result = {desc1,desc2,desc3};
        Random random = new Random();
        return result[random.nextInt(result.length)];
    }
}
