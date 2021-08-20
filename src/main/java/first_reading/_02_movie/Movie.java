package first_reading._02_movie;

import java.time.Duration;

/** 영화 */
public class Movie {

    private String title;
    private Duration runningTime;

    /** 기본 요금 */
    private Money fee;

    /** 할인 정책 */
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }



    public Money getFee() {
        return fee;
    }

    /**
     * 할인된 금액을 계산해 리턴한다.
     */
    public Money calculateMovieFee(Screening screening) {

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
