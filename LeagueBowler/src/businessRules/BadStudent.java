package businessRules;

public class BadStudent extends Person implements Knowledgeable{
	private String major;
	private String level;
	
	public BadStudent(String lastName, String firstName, String city, String major, String level) {
		super(lastName, firstName, city);
		this.major = major;
		this.level = level;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n\tStudent [major = " + major + ", level = " + level + "]";
	}
	
	@Override
	public void someMethod() {
		System.out.println("This action comes from someMethod(GoodStudent).");	
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}

	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public void StudyHours() {
		System.out.println(super.getFirstName() + " spends little time studying.");
	}

	@Override
	public void readBook() {
		System.out.println(super.getFirstName() + " reads few books.");
	}

	@Override
	public void classParticipation() {
		System.out.println(super.getFirstName() + " never attends class.");
	}

}
