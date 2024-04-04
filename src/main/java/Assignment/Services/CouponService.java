package Assignment.Services;

import java.util.HashMap;
import java.util.Map;


public class CouponService {

    public Map<String, Integer> fetchCoupons() {
        Map<String, Integer> coupons = new HashMap<>();
        coupons.put("OFF5", 5);
        coupons.put("OFF10", 10);
        return coupons;
    }
    
    public int getDiscount(String couponCode) throws Exception{
        Map<String, Integer> coupons = new HashMap<>();
        coupons.put("OFF5", 5);
        coupons.put("OFF10", 10);
    
        // Get the discount percentage for the given coupon code
        Integer discount = coupons.get(couponCode);
        
        // Check if the coupon code exists in the map
        if (discount != null) {
            return discount;
        } else {
            // Handle the case where the coupon code is not found
             throw new Exception("Invalid Coupon"); // or throw an exception
        }
    }
    
}
