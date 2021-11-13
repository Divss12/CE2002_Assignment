/**
 * @author Zavier
 * @version 1.0
 * @since 31st October 2021
 */
package Main;

public interface Item {
	/**
	 * 
	 * @return Name
	 */
	public String getName();
	
	/**
	 * 
	 * @return Description
	 */
	public String getDescription();
	
	/**
	 * 
	 * @return Price
	 */
	public double getPrice();
	
	/**
	 * 
	 * @param name set as Name
	 */
	public void setName(String name);
	
	/**
	 * 
	 * @param desc set as Description
	 */
	public void setDescription(String desc);
	
	/**
	 * 
	 * @param price set as Price
	 */
	public void setPrice(double price);
}
