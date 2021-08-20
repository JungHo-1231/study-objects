package first_reading._02_movie;

import java.time.LocalDateTime;

/**
 * 상영
 */
public class Screening {
    /**
     * 상영할 영화
     */
    private Movie movie;
    /**
     * 상영 순번
     */
    private int sequence;
    /**
     * 상영 시작 시간
     */
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    /**
     * 상영 시작 시간을 리턴한다.
     */
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    /**
     * 순번이 일치하면 true 를 리턴한다.
     */
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    /**
     * 기본 요금을 리턴한다.
     */
    public Money getMoveFee() {
        return movie.getFee();
    }

    /**
     * 영화를 예매하고, 예매 정보를 리턴한다.
     *
     * @param customer
     * @return
     */
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount),
                audienceCount);
    }

    /**
     * 전체 애매 요금을 계산해 리턴한다.
     *
     * @param audienceCount 애매 인원 수
     * @return 애매 요금
     */
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}
