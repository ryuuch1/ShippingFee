import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBangquyetdinh {

    static Stream<Arguments> provideTestCases() throws Exception {
        List<Arguments> args = new ArrayList<>();

        try (InputStream is = TestBangquyetdinh.class.getClassLoader()
                .getResourceAsStream("TestcaseBangQuyetDinh.xlsx")) {
            if (is == null) {
                throw new RuntimeException("Không tìm thấy file TestcaseBangQuyetDinh.xlsx trong resources");
            }
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheet("TestCases");

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // bỏ header

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                float x = (float) row.getCell(0).getNumericCellValue();
                float y = (float) row.getCell(1).getNumericCellValue();
                int fragileInt = (int) row.getCell(2).getNumericCellValue();
                boolean a = fragileInt == 1;
                int expected = (int) row.getCell(3).getNumericCellValue();
                args.add(Arguments.of(x, y, a, expected));
            }
            workbook.close();
        }
        return args.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testCalculateFee(float x, float y, boolean a, int expected) {
        int result = ShippingFeeCalculator.calculateFee(x, y, a);
        assertEquals(expected, result,
                "Failed for input: distance=" + x + ", weight=" + y + ", fragile=" + a);
    }
}
