package second_reading._05_movie;

import second_reading._02_movie.Money;

import java.time.Duration;
import java.util.List;

public class PercentDiscountMovie extends Movie {
    private double percent;

    public PercentDiscountMovie(String title, Duration duration, Money fee, List<DiscountCondition> discountConditions, double percent) {
        super(title, duration, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent) ;
    }
}
