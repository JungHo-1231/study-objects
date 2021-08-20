package first_reading._01_ticket;

/** 관람객이 소지품을 보관할 가방 */
public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    /**
     * 이벤트에 당첨되지 않은 관람객. 초대징이 없다.
     * @param amount
     *
     */
    public Bag(Long amount){
        this.amount = amount;
    }

    /**
     * 이벤트에 당참된 관람객. 현금과 초대장이 있다.
     * @param amount
     * @param invitation
     *
     */
    public Bag(Long amount, Invitation invitation){
        this.amount = amount;
        this.invitation =invitation;
    }

    /** 관람객이 초대장을 갖고 있다면 true 를 리턴한다.*/
    private boolean hasInvitation(){
        return invitation != null;
    }

    public boolean hasTicket(){
        return ticket != null;
    }


    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /** 현금을 감소시킨다. */
    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    /** 현금을 증가시킨다. */
    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

}
