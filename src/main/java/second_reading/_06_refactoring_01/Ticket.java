package second_reading._06_refactoring_01;

import lombok.Getter;

public class Ticket {
    @Getter
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }
}
