package Algorithem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * <p>Title: Application Class (Project 1) CS 323<p>
 * 
 * <p>Description: This class is reading a csv file. CSV file conatins 2006-2011 NYS Math Test 
 *                 Results By Grade-Boro- By Race- Ethnicity. Data read from csv file is stored in 
 *                 HashMap who vale is of type Item, AVL tree, Red Black Tree and B Tree.
 *                 From the data stored we have used 4 algorithems to get look up time for different Algorithems
 *                 HashMap        - In which year students score highest mean and what borough and grade scored it?
 *                 AVL Tree       - What is ethnic make up by each grade ?
 *                 Red Black tree - What is is percentage Increase/Decrease of students in grade(user inputs)
 *                              from year(user inputs) to year(user inputs) ? 
 *                 B Tree         - 
 * @author Sulbha Aggarwal 
 */

public class Application 
{

	public static void main(String[] args) throws IOException
	{
		File file = new File( "data.csv" ) ; //pass the file name to File Object
		HashMap<Item> hashMap = new HashMap<Item>() ;
		String str = "\nHash Table:\n\nSearch when the key is present in the Hash Table:\n" ;
		String str1 = "" , str2 = "" , str3= "" , str11 = "" , str12 = "" , str13 = "" , str21 = "" , str22 = "" , str23 = "" ;
		long start = 0 ;
		long end = 0 ;
		int[] array1 = new int [10] , array11 = new int[10] ;
		int[] array2 = new int[100] , array12 = new int[100] ;
		int[] array3 = new int[1000] , array13 = new int[1000] ;
		try 
		{
			Scanner sc = new Scanner(file) ;     
			int i = 0 ;
			String line = sc.nextLine() ;

			while( sc.hasNextLine() && i < 876 )  // scan until i is less than 870
			{
				line = sc.nextLine() ; 

				String[] temp = line.split( "," ) ;   //Splitting an input after , and return a string of arrays

				if( !temp[1].equals("All Grades") && !temp[6].equals("s") )
				{
					//adding items into the list
					hashMap.put(i, new Item( temp[0] ,  temp[1]  , 
							Integer.parseInt( temp[2] )  , temp[3] , Integer.parseInt( temp[4] )
							, Integer.parseInt( temp[5] ) , Integer.parseInt( temp[6] ), 
							Integer.parseInt( temp[8] ) ) );
					if( i < 10 )
					{
						array1[i] = Integer.parseInt( temp[6] ) ;
						array11[i] = Integer.parseInt( temp[5] ) ;
					}
					if( i < 100 )
					{
						array2[i] = Integer.parseInt( temp[6] ) ;
						array12[i] = Integer.parseInt( temp[5] ) ;
					}
					array3[i] = Integer.parseInt( temp[6] ) ;
					array13[i] = Integer.parseInt( temp[5] ) ;
				}
				i++ ;
				
				if( i == 10 )
				{
					str1 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(6) ;
					end = System.currentTimeMillis() ; 
					str1 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					str11 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(2) ;
					end = System.currentTimeMillis() ; 
					str11 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					str21 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(8) ;
					end = System.currentTimeMillis() ; 
					str21 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					start = System.currentTimeMillis() ;
					hashMap.get(880) ;
					end = System.currentTimeMillis() ; 
					str1 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
					start = System.currentTimeMillis() ;
					hashMap.get(882) ;
					end = System.currentTimeMillis() ; 
					str11 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
					start = System.currentTimeMillis() ;
					hashMap.get(884) ;
					end = System.currentTimeMillis() ; 
					str21 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
					
				}
				if( i == 100 )
				{
					str2 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(99) ;
					end = System.currentTimeMillis() ; 
					str2 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					str12 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(87) ;
					end = System.currentTimeMillis() ; 
					str12 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					str22 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(15) ;
					end = System.currentTimeMillis() ; 
					str22 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					start = System.currentTimeMillis() ;
					hashMap.get(950) ;
					end = System.currentTimeMillis() ; 
					str2 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
					start = System.currentTimeMillis() ;
					hashMap.get(902) ;
					end = System.currentTimeMillis() ; 
					str12 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
					start = System.currentTimeMillis() ;
					hashMap.get(966) ;
					end = System.currentTimeMillis() ; 
					str22 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
				}
				if( i == 875 )
				{
					str3 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(789) ;
					end = System.currentTimeMillis() ; 
					str3 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					str13 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(653) ;
					end = System.currentTimeMillis() ; 
					str13 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					str23 = "Run time: " ;
					start = System.currentTimeMillis() ;
					hashMap.get(208) ;
					end = System.currentTimeMillis() ; 
					str23 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n"
							+ "Search for when key is not present within the HashTable:\nRun Time: ";
					
					start = System.currentTimeMillis() ;
					hashMap.get(1249) ;
					end = System.currentTimeMillis() ; 
					str3 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
					start = System.currentTimeMillis() ;
					hashMap.get(1500) ;
					end = System.currentTimeMillis() ; 
					str13 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
					start = System.currentTimeMillis() ;
					hashMap.get(1000) ;
					end = System.currentTimeMillis() ; 
					str23 += (start-end) + " milli seconds\nNumber of Operations: " + hashMap.compare() + " comparisons\n\n" ;
				}
				
					
			}
			sc.close() ;
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		System.out.println( "**********************************************************************************************" ) ;

		int multiple = 1 , j = 0 ; 
		int[] arr , arr1 ;
		while( j < 3 )
		{
			int [] data1 = new int[10 * multiple];

			// Fill the arrays with values
			Random rand = new Random();

			for (int i = 0; i < data1.length; i++) 
			{
				data1[i] = rand.nextInt();
			}
			
			if( j == 0 )
			{
				arr = array1 ;
				arr1 = array11 ;
			}
			else if( j == 1 )
			{
				arr = array2 ;
				arr1 = array12 ;
			}
			else
			{
				arr = array3 ;
				arr1 = array13 ;
			}

			System.out.println( "Testing values on dataset with: " + data1.length + " numbers" ) ;
			// Declaring Search Structures 
			BinarySearchTree BSTtree = new BinarySearchTree();
			AVLTree AVLtree = new AVLTree();
			RedBlackTree RBtree = new RedBlackTree(); 
			
			
			BinarySearchTree BSTtree1 = new BinarySearchTree();
			AVLTree AVLtree1 = new AVLTree();
			RedBlackTree RBtree1 = new RedBlackTree(); 
			
			BinarySearchTree BSTtree2 = new BinarySearchTree();
			AVLTree AVLtree2 = new AVLTree();
			RedBlackTree RBtree2 = new RedBlackTree(); 
			
			for (int i = 0; i < data1.length; i++) 
			{
				BSTtree.insert(data1[i]);
				AVLtree.insert(data1[i]);
				RBtree.insert(data1[i]);
			}
			
			for( int i = 0 ; i < arr.length ; i++ )
			{
				BSTtree1.insert(arr[i]);
				AVLtree1.insert(arr[i]);
				RBtree1.insert(arr[i]);
				BSTtree2.insert(arr1[i]);
				AVLtree2.insert(arr1[i]);
				RBtree2.insert(arr1[i]);
			}
			
			
			
			System.out.println( "**********************************************************************************************\n" ) ;
			
			System.out.println( "Data Source: 1" ) ;
			System.out.println("Binary Search Tree:\n\nSearch when value present within the tree: ");
			start = System.currentTimeMillis();
			BSTtree.search(data1[9]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + BSTtree.getCount() + " comparisons\n");

			System.out.println("\nSearch when value not present within the given tree: ");
			start = System.currentTimeMillis();
			BSTtree.search(-1);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + BSTtree.getCount() + " comparisons\n");
			
			System.out.println( "------------------------------------------------------------------------------\n\nData Source: 2" ) ;
			System.out.println("Binary Search Tree:\n\nSearch when value present within the tree: ");
			start = System.currentTimeMillis();
			BSTtree1.search(arr[7]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + BSTtree1.getCount() + " comparisons\n");

			System.out.println("\nSearch when value not present within the given tree: ");
			start = System.currentTimeMillis();
			BSTtree1.search(1000);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + BSTtree1.getCount() + " comparisons\n");
			
			System.out.println( "------------------------------------------------------------------------------\n\nData Source: 3" ) ;
			System.out.println("Binary Search Tree:\n\nSearch when value present within the tree: ");
			start = System.currentTimeMillis();
			BSTtree2.search(arr1[4]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + BSTtree2.getCount() + " comparisons\n");

			System.out.println("\nSearch when value not present within the given tree: ");
			start = System.currentTimeMillis();
			BSTtree2.search(5000);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + BSTtree2.getCount() + " comparisons\n");

			System.out.println( "**********************************************************************************************\n" ) ;
			// AVL Tree - Sort and Search

			System.out.println("AVL Tree:\n\nSearch when value present in the AVL Tree: ");
			start = System.currentTimeMillis();
			AVLtree.search(data1[9]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + AVLtree.getCount() + " comparisons\n");

			System.out.println("Search when value is not present in the AVL Tree: ");
			start = System.currentTimeMillis();
			AVLtree.search(-1);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + AVLtree.getCount() + " comparisons\n");
			
			System.out.println( "------------------------------------------------------------------------------\n\nData Source: 2" ) ;
			System.out.println("AVL Tree:\n\nSearch when value present in the AVL Tree: ");
			start = System.currentTimeMillis();
			AVLtree1.search(arr[4]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + AVLtree1.getCount() + " comparisons\n");

			System.out.println("Search when value is not present in the AVL Tree: ");
			start = System.currentTimeMillis();
			AVLtree1.search(-121);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + AVLtree1.getCount() + " comparisons\n");
			
			System.out.println( "------------------------------------------------------------------------------\n\nData Source: 3" ) ;
			System.out.println("AVL Tree:\n\nSearch when value present in the AVL Tree: ");
			start = System.currentTimeMillis();
			AVLtree2.search(arr1[6]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + AVLtree2.getCount() + " comparisons\n");

			System.out.println("Search when value is not present in the AVL Tree: ");
			start = System.currentTimeMillis();
			AVLtree2.search(4000);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + AVLtree2.getCount() + " comparisons\n");

			System.out.println( "**********************************************************************************************\n" ) ;
			// Red Black Tree - Sort and Search


			System.out.println("Red Black Tree:\n\nSearch when value is present in Red Black Tree: " );
			start = System.currentTimeMillis();
			RBtree.search(data1[9]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + RBtree.getCount() + " comparisons\n");

			System.out.println("Search of the given tree, when value not present: ");
			start = System.currentTimeMillis();
			RBtree.search(100);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + RBtree.getCount() + " comparisons\n");
			
			System.out.println( "------------------------------------------------------------------------------\n\nData Source: 2" ) ;
			
			System.out.println("Red Black Tree:\n\nSearch when value is present in Red Black Tree: " );
			start = System.currentTimeMillis();
			RBtree1.search(arr[8]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + RBtree1.getCount() + " comparisons\n");

			System.out.println("Search of the given tree, when value not present: ");
			start = System.currentTimeMillis();
			RBtree1.search(500);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + RBtree1.getCount() + " comparisons\n");
			
			System.out.println( "------------------------------------------------------------------------------\n\nData Source: 3" ) ;
			
			System.out.println("Red Black Tree:\n\nSearch when value is present in Red Black Tree: " );
			start = System.currentTimeMillis();
			RBtree2.search(arr1[8]);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + RBtree2.getCount() + " comparisons\n");

			System.out.println("Search of the given tree, when value not present: ");
			start = System.currentTimeMillis();
			RBtree2.search(5000);
			end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end-start) + " milli seconds");
			System.out.println("Number of Operations: " + RBtree2.getCount() + " comparisons\n");
			
			multiple *= 10 ;
			System.out.println( "**********************************************************************************************" ) ;
			
			if( j == 0 )
			{
				System.out.println( str + str1 ) ;
				System.out.println( "------------------------------------------------------------------------------\n\nData Source: 2" ) ;
				System.out.println( str + str11 ) ;
				System.out.println( "------------------------------------------------------------------------------\n\nData Source: 3" ) ;
				System.out.println( str + str21 ) ;
				
			}
			else if( j == 1 )
			{
				System.out.println( str + str2 ) ;
				System.out.println( "------------------------------------------------------------------------------\n\nData Source: 2" ) ;
				System.out.println( str + str12 ) ;
				System.out.println( "------------------------------------------------------------------------------\n\nData Source: 3" ) ;
				System.out.println( str + str22 ) ;
			}
			else
			{
				System.out.println( str + str3 ) ;
				System.out.println( "------------------------------------------------------------------------------\n\nData Source: 2" ) ;
				System.out.println( str + str13 ) ;
				System.out.println( "------------------------------------------------------------------------------\n\nData Source: 3" ) ;
				System.out.println( str + str23 ) ;
			}
			System.out.println( "**********************************************************************************************" ) ;
			j++ ;
		}


			/**HashMap<Integer> hashMap = new HashMap<Integer>() ;

		hashMap.put( 1 , 1 ) ;
		hashMap.put( 2 , 2 ) ;
		hashMap.put( 3, 3 ) ;
		hashMap.put( 4 , 4 ) ;
		hashMap.put( 1001 , 5 ) ;

		System.out.println( hashMap.toString() ) ;

		hashMap.remove( 1 ) ;

		System.out.println( hashMap.toString() ) ;
		System.out.println( "Value of 1001 is: " + hashMap.get(1001)) ;**/

		}

		//in 2006 which Borough has the highest mean score, which student scored it and which grade
		public static String highestMean( HashMap<Item> map )
		{
			long start = System.currentTimeMillis();
			String str = new String() ;
			int mean = 0 , key = 0 , comp = 0 ;

			for( int i = 0 ; i < map.size() ; i++ )
			{
				Item get = (Item) map.get(i) ;
				if( get.getYear() == 2006 && mean < get.getMean() )
				{
					mean = get.getMean() ;
					key = i ;
					comp++ ;
				}
			}

			long end = System.currentTimeMillis() ;

			str = "In " + ((Item) map.get(key)).getYear() + " " + ((Item) map.get(key)).getBorough() + " has the highest Mean of: " 
					+ ((Item) map.get(key)).getMean() + "\nScored by: " + ((Item) map.get(key)).getGrade() + " Graders" +
					"\nTo find the highest mean took: " + (end-start) + " milliseconds Loop Up time " +
					"\nComparisons: " + comp ;

			return str ;
		}

	}
