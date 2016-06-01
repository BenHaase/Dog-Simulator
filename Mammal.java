//class mammal all public so can be accessed by subclasses
public class Mammal {
	private String name;
	private int weight;
	private double hunger;
	private char sex;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getHunger() {
		return hunger;
	}

	public void setHunger(double hunger) {
		this.hunger = hunger;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
}
