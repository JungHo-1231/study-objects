package second_reading._05_movie;

import second_reading._02_movie.Money;

import java.time.Duration;
import java.util.List;

public class AmountDiscountMovie extends Movie {

    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration duration, Money fee, List<DiscountCondition> discountConditions, Money discountAmount) {
        super(title, duration, fee, discountConditions);
        this.discountAmount = discountAmount;
    }


    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
