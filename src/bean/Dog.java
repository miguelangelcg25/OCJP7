package bean;

public class Dog extends Animal {
	
	private String name;
	
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

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object o){
		if(o != null && o instanceof Dog){
			return this.name.equals((Dog)o);
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}

}
