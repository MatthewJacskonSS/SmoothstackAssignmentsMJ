package beans;

public class BookingAgent {
	@Override
	public String toString() {
		return "BookingAgent [booking_id=" + booking_id + ", agent_id=" + agent_id + "]";
	}
	private int booking_id;
	private int agent_id;
	public BookingAgent(int booking_id, int agent_id) {
		super();
		this.booking_id = booking_id;
		this.agent_id = agent_id;
	}
	public BookingAgent() {
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
}
