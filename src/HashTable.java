
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

public class HashTable {
	
	int size;
	int tableSize;
	private Integer[] keys;
	

	public HashTable(){
		tableSize = 10;
		keys = new Integer[tableSize];
		Integer[] ht = keys;
		for(int i = 0; i<tableSize; i ++){
			ht[i]=null;
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public int hashKey(int k){
		return k % (tableSize);
	}
	
	public void insert(int k){
		size++;
		int key = hashKey(k);
		int x = key;
		int t = 0;
		float lf = loadFactor();

		if(lf>=.8){
		resize();
		}
		
		if(keys[key]==null){	
			keys[key] = k;
			
		}
		else{
			do{
			x = ((key + (t * t++)) % keys.length);
		}while(keys[x]!=null);
		keys[x] = k;
		}
	}
	
		
	private void resize() {
		if(loadFactor()>=.8){
			tableSize=(2*keys.length);
			Integer[] tempKeys = keys;
			keys = new Integer[tableSize];
			size = 1;
		for(int i = 0; i<tempKeys.length; i++){
			if(tempKeys[i]!=null){	
				insert(tempKeys[i]);
				}
		}
		}
}
	private void rehash(){
		Integer[] temp = keys;
		keys = new Integer[tableSize];
			size=0;
			for(int i = 0; i<temp.length; i++){
				if(temp[i]!=null){
				insert(temp[i]);
				}
		}
}

	public float loadFactor(){
		float s = (float)getSize();
		float lf = (s/tableSize);
		return lf;
	}
	
	public boolean search(int k){
		int t = 0;
		int key = hashKey(k);
		for(int i = key; keys[i]!=null; i = (((key+ (t * t++)) % tableSize))){
			if(keys[i]==k){
				System.out.println("Key Found: ");
				System.out.println("Index: " + i + " = " + keys[i] + "\n");
				return true;
			}
			else{
				return false;
			}
		}return false;
	}
	
	public boolean delete(int k){
		int t = 0;
		int key = hashKey(k);
		int i = key;
		while(keys[i]!=null){
			if(keys[i]==k){
			System.out.println("Deleting... " + keys[i]);
			i = ((key + (t * t++)) % tableSize);
			keys[i] = null;
			size=size-1;
			rehash();
			return true;
			}
			else{
				return false;
			}
		}
		return false;
		
}
	public void printTable(){
		System.out.println("Hash Table: ");
		for(int i=0; i<keys.length; i++){
			if(keys[i]!=null){
				System.out.println("Index " + i + " = " + keys[i]);
			}
		}
		System.out.println("Array Length: " + keys.length);
		System.out.println("Table Size: " + tableSize);
		System.out.println("# of Elements: " + getSize());
		System.out.println("Load Factor: " + loadFactor());
	}

	
}
