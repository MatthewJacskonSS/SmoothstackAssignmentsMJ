package beans;

public class FlightBookings {
	@Override
	public String toString() {
		return "FlightBookings [flight_id=" + flight_id + ", booking_id=" + booking_id + "]";
	}

	private int flight_id;
	private int booking_id;

	public FlightBookings(int flight_id, int booking_id) {
		super();
		this.flight_id = flight_id;
		this.booking_id = booking_id;
	}

	public FlightBookings() {
		// TODO Auto-generated constructor stub
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
}
