package second_reading._06_refactoring_01;

import lombok.Getter;

/** 관람객이 소지품을 보관할 가방 */
public class Bag {

    @Getter
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    /**
     * 이벤트에 당첨되지 않은 관람객, 초대장이 없다.
     * @param amount 현금
     */
    public Bag(Long amount) {
        this.amount = amount;
    }

    /**
     * 이벤트에 당첨된 관람객. 현금과 초대장이 있다
     * @param amount        현금
     * @param invitation    초대장
     */
    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    /** 관람객이 초대장을 가지고 있다면 true 를 리턴한다. */
    public boolean hasInvitation(){
        return invitation != null;
    }

    /** 관람객이 티켓을 갖고 있다면 ture 를 리턴한다. */
    public boolean hasTicket(){
        return ticket != null;
    }

    /** 현금을 감소시킨다. */
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    /** 현금을 증가시킨다. */
    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public long hold(Ticket ticket) {
        if (hasInvitation()) {
            this.ticket = ticket;
            return 0L;
        } else {
            this.ticket = ticket;
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
