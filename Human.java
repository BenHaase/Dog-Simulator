//human class, contains 1 or more dog class
public class Human extends Mammal {
	private int money;
	private int dogFood;
	private Dog[] dogs;
	
	Human(int d, String pn, String[] dn){ //initializing human class, randomized with necessary input
		dogs = new Dog[d];
		this.setName(pn);
		this.setWeight((int)Math.ceil(Math.random()*100));
		this.setHunger((int)Math.ceil(Math.random()*100));
		if(Math.random()>.5) this.setSex('m');
		else this.setSex('f');
		this.setMoney(0);
		this.setDogFood(10);
		for(int i=0; i<d; i++) dogs[i] = new Dog(dn[i]); //creating dogs
	}
	
	//base human get and sets
	private int getMoney() {
		return money;
	}

	private void setMoney(int money) {
		this.money = money;
	}

	private int getDogFood() {
		return dogFood;
	}

	private void setDogFood(int dogFood) {
		this.dogFood = dogFood;
	}
	
	//human methods to interact with dog class
	public void walks(){
		for(int i=0; i<this.dogs.length; i++){
			this.dogs[i].setFun(50);
			this.dogs[i].setCleanliness(-.1 * dogs[i].getCleanliness());
			this.dogs[i].sHunger(-.1 * dogs[i].getHunger());
		}
	}
	
	public void feeds(){
		for(int i=0; i<this.dogs.length; i++){
			this.dogs[i].sHunger(50);
			this.dogs[i].setCleanliness(.1 * this.dogs[i].getCleanliness());
			this.dogs[i].setFun(.1 * this.dogs[i].getFun());
			this.setDogFood(this.getDogFood()-1);
		}
	}
	
	public void bathes(){
		for(int i=0; i<this.dogs.length; i++){
			this.dogs[i].setFun(-.1 * this.dogs[i].getFun());
			this.dogs[i].setCleanliness(100);
		}
	}
	
	public void passTheTime(){
		for(int i=0; i<this.dogs.length; i++){
			this.dogs[i].setFun(this.dogs[i].getFun()-1);
		}
		this.setMoney(this.getMoney()+10);
	}
	
	public void buysFood(){
		this.setDogFood(this.getDogFood()+50);
		this.setMoney(this.getMoney()-10);
	}
	
	//toString method for human, builds a string, and uses call to dog's toString() method
	@Override public String toString(){
		StringBuilder s = new StringBuilder();
		String nl = System.getProperty("line.separator");
		s.append("Player: " + this.getName() + nl);
		s.append("Money: " + this.getMoney() + nl);
		s.append("Dog Food: " + this.getDogFood() + nl + nl);
		for(int i=0; i<this.dogs.length; i++) s.append(this.dogs[i].toString() + nl);
		s.append(nl);
		return s.toString();
	}
}
