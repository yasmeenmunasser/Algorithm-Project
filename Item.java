package Algorithem;
/**
 * <p>Title: Item Class</p>
 *
 * <p>Description: This class stores NYS math test result's borough , grade , year , category,
 * mean , level1 , level2 and have mutator method and toString to make analysis easier..</p>
 *
 * @author Sulbha Aggarwal
 */

public class Item  implements Comparable<Object>
{
	private String borough ;          	//is the instance representing borough
	private String grade ;              //is the instance representing grade , ex. 3rd grade, 4th grade
	private int year ;                  //is the instance representing year , ex- In year 2006, 100 students give the NYS test
	private String category ;           //is the instance representing category, ex- black, hispanic, white, asian
	private int numTested ;             /*is the instance representing Number of students tested in which year , 
	                                      grade and ehinicity*/
	private int mean ;                  //is the instance representing mean score of students
	private int level1;                 // is the instance representing how much students score in level 1
	private int level2;                 // is the instance representing how much students score in level 2

	/**
	 * default constructor --
	 * initializes the borough, grade, year, category, mean, level1, level2
	 * for the product to an empty String and 0 respectively.
	 */
	public Item()
	{
		borough = new String() ;
		grade = new String() ;
		year = 0 ;
		category = new String() ;
		mean = 0 ;
		level1 = 0 ;
		level2 = 0 ;
	}

	/**
	 * parameterized constructor --
	 * initializes borough, grade, year, category, numTested, mean, level1, level2 
	 * to user specifield value
	 * @param borough to be stored in borough
	 * @param grade to be stored in grade
	 * @param year to be stores in year
	 * @param category to be stored in category
	 * @param numTested to be stored in numTested
	 * @param mean to be stored in mean
	 * @param level1 to be stored in level1
	 * @param level2 to be stored in level2
	 */
	public Item( String borough , String grade ,int year , String category ,
			int numTested , int mean , int level1 , int level2 )
	{
		this.borough = borough ;
		this.grade = grade ;
		this.year = year ;
		this.category = category ;
		this.numTested = numTested ;
		this.mean = mean ;
		this.level1 = level1 ;
		this.level2 = level2 ;
	}

	/**
	 * getBorough method -- gets the borough
	 * @return the borough
	 */
	public String getBorough() 
	{
		return borough;
	}

	/**
	 * getGrade method -- gets the grade
	 * @return the grade
	 */
	public String getGrade() 
	{
		return grade;
	}

	/**
	 * getYear method -- gets the year
	 * @return the year
	 */
	public int getYear() 
	{
		return year;
	}

	/**
	 * getCategory method -- gets the category
	 * @return the etnicity
	 */
	public String getCategory() 
	{
		return category;
	}

	/**
	 * getNumTested method -- gets the numTested
	 * @return the numTested
	 */
	public int getNumTested() 
	{
		return numTested;
	}

	/**
	 * getMean method -- gets the mean
	 * @return the mean
	 */
	public int getMean()
	{
		return mean;
	}

	/**
	 * getLevel1 method -- gets the level1
	 * @return the level1
	 */
	public int getLevel1()
	{
		return level1;
	}

	/**
	 * getLevel2 method -- gets the level2
	 * @return the level2
	 */
	public int getLevel2()
	{
		return level2;
	}

	/**
	 * equals method --
	 * determines if two Items have the same borough.
	 * @param otherItem is a reference to a Item object
	 * @return true if the two objects contain the same category; false otherwise
	 */
	public boolean equals(Object otherItem)
	{
		return ( borough.equals( ( (Item)otherItem ).borough ) ) ;
	}

	/**
	 * compareTo method --
	 * determines if this Item's grade is greater than , less than or equal to otherItem grade.
	 * @param otherItem is a reference to a Item object
	 * @return a negative value if this Item's grade is less than grade's numTested
	 *         a positive value if this Item's grade is greater than grade's numTested
	 *         0 if this Item's id is equal to otherItem's grade
	 */
	public int compareTo(Object otherItem) 
	{
		return grade.compareTo( ( (Item)otherItem ).grade ) ;
	}

	/* toString method --
	 * creates and returns a String representing the state of the Item.
	 * @return a String containing the current values of borough , grade,
	 *  year , category , number Tested, Level 1 , Level 2
	 */
	public String toString()
	{

		String str = new String();
		str += "\nBorough: " + borough + "\nGrade: " + grade + "\nYear: " + year + "\nRace: " + category + "\nNumber Tested: " 
				+ numTested + "\nLevel 1#: " + level1 + "\nLevel 2#: " + level2 ;
		str += ("\n*********************************************************************************************************");
		return str;

	}

}

