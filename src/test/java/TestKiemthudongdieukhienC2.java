import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKiemthudongdieukhienC2 {
    @Test
    void testCase149() {
        int result = ShippingFeeCalculator.calculateFee(-1, -1, false);
        assertEquals(-1, result);
    }

    @Test
    void testCase150() {
        int result = ShippingFeeCalculator.calculateFee(41, 41, false);
        assertEquals(0, result);
    }

    @Test
    void testCase151() {
        int result = ShippingFeeCalculator.calculateFee(2, 21, false);
        assertEquals(16800, result);
    }

    @Test
    void testCase152() {
        int result = ShippingFeeCalculator.calculateFee(10, 15, false);
        assertEquals(41250, result);
    }

    @Test
    void testCase153() {
        int result = ShippingFeeCalculator.calculateFee(20, 2, true);
        assertEquals(88000, result);
    }
}
