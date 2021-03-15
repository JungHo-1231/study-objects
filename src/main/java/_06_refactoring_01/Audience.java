package _06_refactoring_01;

import lombok.Getter;

public class Audience {

    @Getter
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public long setTicket(Ticket ticket){
        return bag.setTicket(ticket);
    }

}
