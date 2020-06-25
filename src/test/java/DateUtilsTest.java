import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DateUtils;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {
    @Test
    public void DateUtilsTest() {
        DateUtilsTest t = new DateUtilsTest();
        assertTrue(DateUtils.month(1) == "January");
        assertFalse(DateUtils.month(1) == "February");
    }
}