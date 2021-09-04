package second_reading._05_movie;

import second_reading._02_movie.Money;

import java.time.Duration;
import java.util.List;

public class NoneDiscountMovie extends Movie {
    public NoneDiscountMovie(String title, Duration duration, Money fee, List<DiscountCondition> discountConditions) {
        super(title, duration, fee, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
