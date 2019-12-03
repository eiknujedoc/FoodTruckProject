package FoodTruck;

public class FoodTruck { // You will define a FoodTruck class
// F I E L D S

	private String name;
	private int idNumber; // with fields for a unique numeric id, a name ("TacoRific", "Mediterranean
								// Medic", etc.), food type ("Tacos", "Falafel", etc.), and a numeric rating
	private String foodType;
	private double vendorRating	;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public double getVendorRating() {
		return vendorRating;
	}
	public void setVendorRating(double vendorRating) {
		this.vendorRating = vendorRating;
	}

// M E T H O D S

}
