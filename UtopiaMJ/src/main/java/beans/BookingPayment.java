package beans;

public class BookingPayment {
	@Override
	public String toString() {
		return "BookingPayment [booking_id=" + booking_id + ", stripe_id=" + stripe_id + ", refunded=" + refunded + "]";
	}

	private int booking_id;
	private String stripe_id;

	public BookingPayment(int booking_id, String stripe_id, boolean refunded) {
		super();
		this.booking_id = booking_id;
		this.stripe_id = stripe_id;
		this.refunded = refunded;
	}

	public BookingPayment() {
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getStripe_id() {
		return stripe_id;
	}

	public void setStripe_id(String stripe_id) {
		this.stripe_id = stripe_id;
	}

	public boolean isRefunded() {
		return refunded;
	}

	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}

	private boolean refunded;
}
