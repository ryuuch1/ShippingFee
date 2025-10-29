import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKiemthudongdieukhienalluse {

    @Test
    void testCase154() { // Path 1
        int result = ShippingFeeCalculator.calculateFee(20, 25, false);
        assertEquals(96000, result);
    }

    @Test
    void testCase155() { // Path 2
        int result = ShippingFeeCalculator.calculateFee(3, 10, true);
        assertEquals(19360, result);
    }

    @Test
    void testCase156() { // Path 3
        int result = ShippingFeeCalculator.calculateFee(10, 25, false);
        assertEquals(45000, result);
    }

    @Test
    void testCase157() { // Path 4
        int result = ShippingFeeCalculator.calculateFee(4, 25, true);
        assertEquals(23760, result);
    }

    @Test
    void testCase158() { // Path 5
        int result = ShippingFeeCalculator.calculateFee(10, 10, false);
        assertEquals(41250, result);
    }

    @Test
    void testCase159() { // Path 6
        int result = ShippingFeeCalculator.calculateFee(10, 3, false);
        assertEquals(37500, result);
    }

    @Test
    void testCase160() { // Path 7
        int result = ShippingFeeCalculator.calculateFee(20, 10, false);
        assertEquals(88000, result);
    }

    @Test
    void testCase161() { // Path 8
        int result = ShippingFeeCalculator.calculateFee(20, 3, false);
        assertEquals(80000, result);
    }

    @Test
    void testCase162() { // Path 9
        int result = ShippingFeeCalculator.calculateFee(3, 3, true);
        assertEquals(17600, result);
    }
}
