package _01_ticket;

/** 티켓 판매원 */
public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    /** 티켓을 관람객에게 판매한다. */
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
