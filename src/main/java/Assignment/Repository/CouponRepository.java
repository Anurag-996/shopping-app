package Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Assignment.Entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long>{

}
