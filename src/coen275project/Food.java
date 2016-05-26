package coen275project;

public class Food {
    private String foodName;
    private double foodPrice;
    private int foodCalorie;
    private String foodNitrition;
    public Food(String n, double p, int c){
		this.foodName = n;
		this.foodPrice = p;
		this.foodCalorie = c;
	}
	
	public String getName(){
		return foodName;
	}
	public double getPrice(){
		return foodPrice;
	}
	public int getCalories(){
		return foodCalorie;
	}
    
}
