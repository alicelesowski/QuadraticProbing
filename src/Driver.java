/* Alice Lesowski
 * June 4, 2018
 * CSCI 232
 * Program 3
 * Data Structures and Algorithms
 * 
 * This program uses quadratic probing to take a key and insert it into a hash table
 * The initial capacity of this hash table is 10, but when the capacity reaches
 * 80% the table doubles in size and rehashes all the elements into the new hash table
 * The menu allows the user to insert, delete, and search elements.
 * 
 */

import java.io.IOException;
import java.util.Scanner;
public class Driver {
	 
	public static void main(String[] args) throws IOException {
		HashTable ht = new HashTable();
		Scanner scan = new Scanner(System.in);
		int c;
		boolean found, search;
		do{
		System.out.println("\nHash Table Functions: ");
		System.out.println("1: Insert");
		System.out.println("2: Delete");
		System.out.println("3: Search");
		System.out.println("0: Quit");
		System.out.println("\nChoose a function>> ");
		
		c = scan.nextInt();
		switch(c){
		case 1:
			System.out.println("Enter key to insert>> ");
			ht.insert(scan.nextInt());
			break;
		case 2: 
			System.out.println("Enter key to delete>> ");
			found = ht.delete(scan.nextInt());
			if(found==false){
				System.out.println("Key Not Found");
			}
			break;			
		case 3:
			System.out.println("Enter key to search>> ");
			search = ht.search(scan.nextInt());
			if(search==false){
			System.out.println("Key Not Found\n");
			}
			break;
		default:
			break;
		}
		ht.printTable();
		}while(c!=0);
		
		System.out.println("Thank you! Goodbye.");
	}

}
