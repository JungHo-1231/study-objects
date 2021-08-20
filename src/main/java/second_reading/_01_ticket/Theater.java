package second_reading._01_ticket;

/**
 * 소극장
 */
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    /**
     * 관람객을 맞이한다.
     * @param audience
     */
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
