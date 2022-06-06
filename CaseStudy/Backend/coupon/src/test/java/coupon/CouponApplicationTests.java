package coupon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import coupon.controller.CouponController;
import coupon.model.Coupon;
import coupon.repo.CouponRepository;


@SpringBootTest
class CouponApplicationTests {

    @MockBean
    CouponRepository couponRepository;

    @Autowired
    CouponController couponController;


    @Test
    public void getAllCouponsTest() {
        when(couponRepository.findAll()).thenReturn(   //return the list of records
                Stream.of(new Coupon("", "amazon", "amaz12", "10", "10% offer","12-10-2022")).collect(Collectors.toList()));
        assertEquals(1, couponController.getAllCoupons().size());//we comparing it with the size
    }

    @Test
    public void addCouponTest() {
        Coupon coupon = new Coupon("2", "amazon", "ama12", "mobiles", "10% offer","");
        
        when(couponRepository.save(coupon)).thenReturn(coupon);
        assertEquals(coupon, couponController.addCoupon(coupon));
    }

    @Test
    public void deleteDealTest() {
        String couponId = "21";
        Coupon coupon = new Coupon("5","amazon","ama12", "mobiles", "10% offer","12-10-22");
        couponRepository.deleteById(couponId);
        //verify(couponRepository).deleteById(couponId);
    }
}