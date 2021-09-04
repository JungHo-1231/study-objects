package second_reading._04_movie_data_system;


import first_reading._02_movie.Money;
import first_reading._04_movie_data_system.DiscountConditionType;
import first_reading._04_movie_data_system.MovieType;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Movie {
    /**
     * 기존과 동일
     */
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    /**
     * 할인이라는 역할(책임)이 movie 객체 안으로 들어왔다.
     */
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateAmountDiscountedFee() throws IllegalAccessException {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalAccessException();
        }

        return fee.minus(discountAmount);
    }


    public Money calculatePercentDiscountedFee() throws IllegalAccessException {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalAccessException();
        }

        return fee.minus(fee.times(discountPercent));
    }


    public Money calculateNoneDiscountedFee() throws IllegalAccessException {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalAccessException();
        }

        return fee;
    }

    /**
     * 할인 조건을 하나씩 훑어 가면서 할인 조건의 타입을 체크한 다음, 할인 가능 여부를 리턴한다.
     * @param whenScreened 상영 일시
     * @param sequence     상영 순번
     * @return 할인 가능하다면 true
     */
    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) throws IllegalAccessException {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }
        return false;
    }
}
