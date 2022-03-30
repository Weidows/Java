package prodsmile.coding.java8plus;

import org.junit.Test;

import java.time.*;

public class Local {

    @Test
    public void test_date(){
        // 2022年2月22日
        var date = LocalDate.of(2022, 2, 22);

        // 10:55:59
        var time = LocalTime.of(10, 55, 59);

        // 当前时间
        var datetime = LocalDateTime.of(date, time);

        var zoneDT = ZonedDateTime.of(datetime, ZoneId.of("Asia/Shanghai"));
    }
}
