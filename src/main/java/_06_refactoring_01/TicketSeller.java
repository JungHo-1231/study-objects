package _06_refactoring_01;

import lombok.Getter;

/** 티켓 판매원 */
public class TicketSeller {

    @Getter
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void setTicket(Audience audience){
       ticketOffice.plusAmount(audience.setTicket(
               ticketOffice.getTicket()
       ));
    }

}
