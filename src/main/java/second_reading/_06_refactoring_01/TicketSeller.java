package second_reading._06_refactoring_01;

import lombok.Getter;

/** 티켓 판매원 */
public class TicketSeller {
    @Getter
    private TicketOffice ticketOffice;

    /** 티켓 판매원은 자신이 일하는 매표소를 알고 있어야 한다. */
    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void setTicket(Audience audience) {
        ticketOffice.plusAmount(
                audience.setTicket(ticketOffice.getTicket())
        );

//        if (audience.getBag().hasInvitation()) {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().setTicket(ticket);
//        } else {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketOffice.plusAmount(ticket.getFee());
//        }
    }

}
