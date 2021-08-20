package first_reading._01_ticket;

import lombok.Getter;

public class Audience {

    @Getter
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
       return bag.hold(ticket);
    }
}
