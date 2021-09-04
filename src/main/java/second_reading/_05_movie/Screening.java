package second_reading._05_movie;

import lombok.Getter;
import lombok.Setter;
import second_reading._02_movie.Money;
import second_reading._04_movie_data_system.Customer;

import java.time.LocalDateTime;

/** Screening 은 영화를 예매할 책임을 맡으며, Reservation 인스턴스를 생성할 책임을 수행한다. */
@Getter
public class Screening {
    //2. 책임을 수행하는데 필요한 인스턴스 변수를 결정

    // movie 에 가격을 계산하라 라는 메시지 전송을 위해
    private Movie movie;

    // 상영 순번
    private int sequence;

    // 상영 시간
    private LocalDateTime whenScreened;


    // 1. 책임이 결정,
    public Reservation reserve(Customer customer, int audienceCount) {

        //3. 영화를 예매하기 위해서는 movie 에게 가격을 계산하라 메시지 전송을 통해 계산된 영화 요금을 반환받아야 한다.
        return new Reservation(customer, this, calculateFee(audienceCount));
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
