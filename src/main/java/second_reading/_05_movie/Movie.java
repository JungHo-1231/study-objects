package second_reading._05_movie;

import second_reading._02_movie.Money;

import java.time.Duration;
import java.util.List;

public abstract class Movie {

    private String title;
    private Duration duration;
    /** 기본 금액 */
    private Money fee;
    /** 할인 조건 */
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration duration, Money fee, List<DiscountCondition> discountConditions) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.discountConditions = discountConditions;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    protected Money getFee(){
        return fee;
    }
    abstract protected Money calculateDiscountAmount();
}
