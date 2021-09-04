package second_reading._04_movie_data_system;

import first_reading._02_movie.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) throws IllegalAccessException {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
