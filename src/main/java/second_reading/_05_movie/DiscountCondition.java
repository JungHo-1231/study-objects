package second_reading._05_movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
//    /** 할인 조건의 종류 */
//    private DiscountConditionType type;
//    /** 상영 순번 */
//    private int sequence;
//
//    /** 요일 */
//    private DayOfWeek dayOfWeek;
//    /** 시작 시간 */
//    private LocalTime startTime;
//    /** 종료 시간 */
//    private LocalTime endTime;
//
//    public boolean isSatisfiedBy(Screening screening) {
//        if (type == DiscountConditionType.PERIOD) {
//            return isSatisfiedByPeriod(screening);
//        }
//
//        return isSatisfiedBySequence(screening);
//    }
//
//    private boolean isSatisfiedBySequence(Screening screening) {
//        return screening.getSequence() == sequence;
//    }
//
//    private boolean isSatisfiedByPeriod(Screening screening) {
//        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
//                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
//                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0 ;
//    }
}
