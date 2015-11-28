package bean;

public class Dog extends Animal {
	
	private String name;
	private int age;
	
	public Dog(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + " age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object o){
		if(o != null && o instanceof Dog){
			return this.name.equals(((Dog)o).getName());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}

}
