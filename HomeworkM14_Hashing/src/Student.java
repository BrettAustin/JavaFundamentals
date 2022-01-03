import java.util.Objects;

public class Student {
	
	private int id;
	private String firstName, lastName;
	private boolean paidFees;
	
	public Student(int id, String firstName, String lastName, boolean paidFees) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.paidFees = paidFees;
	}
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public boolean hasPaidFees() {
		return paidFees;
	}
	public String toString() {
		return firstName + " " + lastName + " (ID: " + id + ")" + ( paidFees ? "" : " (Fees Owed)");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Student student = (Student) o;//cast object as student

		return getId() == student.getId()
				&& paidFees == student.paidFees
				&& Objects.equals(getFirstName(), student.getFirstName())
				&& Objects.equals(getLastName(), student.getLastName());

	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), paidFees);
	}
}
