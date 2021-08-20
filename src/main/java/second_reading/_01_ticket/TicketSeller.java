package second_reading._01_ticket;

import lombok.Getter;

/**
 * 티켓 판매원
 */
public class TicketSeller {
    @Getter
    private TicketOffice ticketOffice;

    /**
     * 티켓 판매원은 자신이 일하는 매표소를 알고 있어야 한다.
     */
    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }


    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }

}
