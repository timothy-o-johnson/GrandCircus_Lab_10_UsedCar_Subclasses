
public class UsedCar extends Car {
	double mileage;
	boolean waterDamage;
	boolean carAccidents;

	
	
	public UsedCar() {
		super();
		this.mileage = 1;
		this.waterDamage = false;
		this.carAccidents = false;
	}



	public UsedCar(String make, String model, int year, double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage;
		this.waterDamage = false;
		this.carAccidents = false;

	}

	public UsedCar(String make, String model, int year, double price, double mileage, boolean waterDamage, boolean carAccidents) {
		super(make, model, year, price);
		this.mileage = mileage;
		this.waterDamage = false;
		this.carAccidents = false;

	}


	public double getMileage() {
		return mileage;
	}



	public void setMileage(double mileage) {
		this.mileage = mileage;
	}



	public boolean isWaterDamage() {
		return waterDamage;
	}



	public void setWaterDamage(boolean waterDamage) {
		this.waterDamage = waterDamage;
	}



	public boolean isCarAccidents() {
		return carAccidents;
	}



	public void setCarAccidents(boolean carAccidents) {
		this.carAccidents = carAccidents;
	}


	private String convertBooleanToYesOrNo (boolean bool) {
		if(bool) {
			return "yes";
		} else {
			return "no";
		}
	}

	@Override
	public String toString() {
		String waterDamageString = convertBooleanToYesOrNo(waterDamage);
		String carAccidentsString = convertBooleanToYesOrNo(carAccidents);
		
		return String.format("%-20s %-20s %-20d $%-20.0f %-20.0f %-20s %-20s", 
							super.getMake(), 
							super.getModel(), 
							super.getYear(), 
							super.getPrice(),
							this.mileage,
							waterDamageString,
							carAccidentsString);
	}
	
	
	
	

}
