package _05_movie;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Screening {

    /** 예매하기 위해 필요한 상태 값 */
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    /** 1. 메세지 => 예매 하라. */
    public Reservation reserve(Customer customer, int audienceCount){

        return null;
    }

    /** (애매 하기 위해) movie 에게 가격을 계산하라. */
    public Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
