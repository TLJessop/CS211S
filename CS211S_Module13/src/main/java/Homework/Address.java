package Homework;

import java.lang.reflect.*;

public class Address {


	@ProperLength()
	private String street;

	private String street2;

	@ProperLength(max_length = 40)
	private String city;

	@ProperLength(min_length = 2,
			max_length = 2)
	private String state;

	@ProperLength(min_length = 5,
				max_length = 5)
	private String zip;

	public Address(String street, String street2, String city, String state, String zip) throws IllegalArgumentException  {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		validateLengths();
	}

	private void validateLengths() throws IllegalArgumentException {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field: fields){
			ProperLength  lengthAnnotation = field.getAnnotation(ProperLength.class);

			if(lengthAnnotation != null){
				String  testedField = null;
				try {
					testedField	= (String) field.get(this);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

				if (testedField.length() > lengthAnnotation.max_length()){
					throw new IllegalArgumentException("IllegalArgumentException: Invalid address value [" +field.getName() +"=" + testedField + "] max length "
							+ lengthAnnotation.max_length());
				}
				if (testedField.length() < lengthAnnotation.min_length()){
					throw new IllegalArgumentException("IllegalArgumentException: Invalid address value [" +field.getName() +"=" + testedField + "] min length "
							+ lengthAnnotation.min_length());
				}

			}
		}
	}
	
	@Override
	public String toString() {
		String s = street + (street2.length()>0 ? "\t"+street2 : "") +
				"\t" + city + ", " + state + " " + zip;
		return s;
				
	}

	
	

}
