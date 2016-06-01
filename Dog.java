
public class Dog extends Mammal{
	private double fun;
	private double cleanliness;
	private double loyalty;

	Dog(String n){ //random initialization, constructor only called from human class
		this.setName(n);
		this.setWeight((int)Math.ceil(Math.random()*100));
		this.setHunger((int)Math.ceil(Math.random()*100));
		if(Math.random()>.5) this.setSex('m');
		else this.setSex('f');
		this.setFun((int)Math.ceil(Math.random()*100));
		this.setCleanliness((int)Math.ceil(Math.random()*100));
		this.setLoyalty();
	}
	
	//dog specialized set functions and methods
	private double range(double a, double b){ //keeps values from going over 100 and adds to current value, used in several methods
		double c = a+b;
		if(c<0)return 0;
		else if(c<100)return c;
		else return 100;
	}
	
	private double max(double a, double b){ //returns the max value of the two input values
		if(a>b) return a;
		else return b;
	}

	public void sHunger(double h) { //this is used to set the hunger and is called from the human class, a separate method was needed to correctly set this
		this.setHunger(range(this.getHunger(), h));
		this.setLoyalty(); //update loyalty
	}

	public double getFun() {
		return fun;
	}

	public void setFun(double fun) {
		this.fun = range(this.fun, fun);
		this.setLoyalty(); //update loyalty
	}

	public double getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(double cleanliness) {
		this.cleanliness = range(this.cleanliness, cleanliness);
	}

	public double getLoyalty() {
		return loyalty;
	}

	private void setLoyalty() { //function to update loyalty, private so only accessible from dog class
		this.loyalty = max(this.fun, 100-this.getHunger()); //take max
		if(this.loyalty==0){System.out.println("Your dog hates you, game over."); //exit if loyalty is 0
		System.exit(0);;
		}
	}
	
	//toString for dog, called from human toString method
	@Override public String toString(){
		StringBuilder s = new StringBuilder();
		String nl = System.getProperty("line.separator");
		s.append("Dog: " + this.getName() + nl);
		s.append("Hunger: "+ this.getHunger() + nl);
		s.append("Fun: "+ this.getFun() + nl);
		s.append("Cleanliness: "+ this.getCleanliness() + nl);
		s.append("Loyalty: "+ this.getLoyalty() + nl);
		return s.toString();
	}
}
