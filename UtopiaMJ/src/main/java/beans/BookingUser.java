package beans;

public class BookingUser {
	private int booking_id;
	private int user_id;

	public BookingUser(int booking_id, int user_id) {
		super();
		this.booking_id = booking_id;
		this.user_id = user_id;
	}

	public BookingUser() {
		// TODO Auto-generated constructor stub
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "BookingUser [booking_id=" + booking_id + ", user_id=" + user_id + "]";
	}

}
