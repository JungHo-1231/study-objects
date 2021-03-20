package _06_refactoring_01;

import java.time.Duration;
import java.time.LocalDateTime;

/** 이벤트 */
public class Event {

    /** 주제 */
    private String subject;

    /** 시작 일시 */
    private LocalDateTime from;

    /** 소요 시간 */
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    /** 쿼리 메소드 */
    public boolean isSatisfied(RecurringSchedule schedule){
        if (from.getDayOfWeek() != schedule.getDayOfWeek()
                || !from.toLocalDate().equals(schedule.getFrom())
                || !duration.equals(schedule.getDuration())) {
            return false;
        }

        return true;
    }

    /** 명령 메소드 */
    private void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
