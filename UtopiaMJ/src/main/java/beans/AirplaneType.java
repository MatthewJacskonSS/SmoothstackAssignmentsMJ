package beans;

public class AirplaneType {
	@Override
	public String toString() {
		return "AirplaneType [id=" + id + ", max_capacity=" + max_capacity + "]";
	}

	private int id;

	public AirplaneType(int id, int max_capacity) {
		super();
		this.id = id;
		this.max_capacity = max_capacity;
	}

	public AirplaneType() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}

	private int max_capacity;
}
