package bean;

import java.util.Date;

public class Person implements Comparable<Person> {

	private String name;
	private Date birthDate;
	
	public Person(String name, Date birthDate){
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int compareTo(Person p) {
		if(p != null && this.getBirthDate() != null){
			if(this.getBirthDate().after(p.getBirthDate()) ){
				return 1;
			}else{
				return -1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", birthDate=")
				.append(birthDate).append("]");
		return builder.toString();
	}
	
}
