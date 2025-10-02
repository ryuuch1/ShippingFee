public class ShippingFeeCalculator {
    public static int calculateFee(float x, float y, boolean a) {
        // Kiểm tra input không hợp lệ
        if (x <= 0 || y <= 0) {
            return -1;
        }

        // Kiểm tra điều kiện khoảng cách
        if (x > 40 || y > 70) {
            return 0;
        }

        double fee = 10000;

        if (x <= 5) {
            fee += 2000 * x;
        } else if (x <= 15) {
            fee += 2000 * 5 + 3500 * (x - 5);
        } else { // 15 < x <= 40
            fee += 2000 * 5 + 3500 * 10 + 5000 * (x - 15);
        }

        if (y <= 5) {}
        else if (y <= 20) {
            fee *= 1.1;
        } else { // 20 < y <= 70
            fee *= 1.2;
        }

        if (a) {
            fee *= 1.1;
        }

        return (int)fee;
    }
}
