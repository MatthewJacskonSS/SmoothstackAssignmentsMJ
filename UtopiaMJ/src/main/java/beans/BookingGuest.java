package beans;

public class BookingGuest {
	@Override
	public String toString() {
		return "BookingGuest [booking_id=" + booking_id + ", contact_email=" + contact_email + ", contact_phone="
				+ contact_phone + "]";
	}

	private int booking_id;
	private String contact_email;
	private String contact_phone;

	public BookingGuest(int booking_id, String contact_email, String contact_phone) {
		super();
		this.booking_id = booking_id;
		this.contact_email = contact_email;
		this.contact_phone = contact_phone;
	}

	public BookingGuest() {
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
}
