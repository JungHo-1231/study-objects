package first_reading._05_movie;

import java.time.Duration;

public class DiscountAmountMovie extends Movie {
    private Money discountAmount;

    public DiscountAmountMovie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);

    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }

}
