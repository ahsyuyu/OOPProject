package coen275project;

public class TestDriver {
	public static void main(String[] args) {
		System.out.println("test");
		
		/***************************create FoodStores and FoodStoreList**************/
		FoodStore foodstore1 = new FoodStore("The White Elephant", 1, "1190 Lexington St, Santa Clara");
	    FoodStore foodstore2 = new FoodStore("Tago", 2, "119 Washington St, Santa Clara");
	    FoodStore foodstore3 = new FoodStore("Mountain", 3, "113 Lafayttte St, Santa Clara");
	    
	    FoodStoreList foodstorelist = new FoodStoreList();
	    foodstorelist.addFoodStore(foodstore1);
	    foodstorelist.addFoodStore(foodstore2);
	    foodstorelist.addFoodStore(foodstore3);
	    
	    
	}

}
