package second_reading._05_movie;

public class SequenceDiscountCondition implements DiscountCondition {

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }
}
