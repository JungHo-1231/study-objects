package _10_call;

import _02_movie.Money;
import lombok.Getter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    /** 세금 */
    private double taxRate;
    /** 단위 요금 */
    @Getter
    private Money amount;
    /** 단위 시간 */
    @Getter
    private Duration seconds;
    /**
     * 전체 통화 목록
     */
    @Getter
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds){
        this.amount = amount;
        this.seconds = seconds;
    }

    public Money calculateFee(){
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(
                calculateCallFee(call));
        }
        return result.plus(result.times(taxRate));
    }

    private Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds()/seconds.getSeconds());
    }


}
