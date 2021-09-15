package second_reading._06_command_query;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@Getter
public class RecurringSchedule {
    private String subject;
    private DayOfWeek dayOfWeek;
    private LocalTime from;
    private Duration duration;

}
