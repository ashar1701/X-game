import java.util.*;
public class HashDictionary implements DictionaryADT {
	private LinkedList<Data>[] hashTable;
	private int tableSize;
	//constructor method to initialize hashdictionary
	public HashDictionary(int size) {
		this.tableSize=size;
		hashTable=new LinkedList[size];
		//initializing linked list in each element of the dictionary
		for (int i=0;i<size;i++) {
			hashTable[i]=new LinkedList<Data>();
		}
		
		
	}
	//private function to calculate the hashcode
	private int hashCode(String config) {
		int val=(int)config.charAt(config.length()-1);
		for (int i=config.length()-2;i>=0;i--) {
			val=(val*11+(int)config.charAt(i))%tableSize;
			
		}
		return val;
	}
	
	//function to add data to the hash dictionary
	public int put(Data record) throws DictionaryException {
		int hashCode=hashCode(record.getConfiguration());
		LinkedList<Data>list=hashTable[hashCode];   //matches the list pointer to the linked list of keys using hash function
		//checks for collisions, if collisions exist then return 0 else return 1
		if (list.size()==0) {
			Iterator<Data>iterator=list.iterator();    //iterator() method to initialize an iterator to iterate through the linked list
			while(iterator.hasNext()) {
				Data r=iterator.next();
				if (r.getConfiguration().equals(record.getConfiguration())) {
					throw new DictionaryException();
				}
			}
			list.add(record);
			return 0;
		}
		else {
			Iterator<Data> iterator=list.iterator();     //iterator() method to initializa an iterator to iterate through the linked list
			while(iterator.hasNext()) {
				Data r=iterator.next();
				if(r.getConfiguration().equals(record.getConfiguration())) {
					throw new DictionaryException();
				}
			}
			list.add(record);
			return 1;
		}
	}
	//remove method to remove an element from the dictionary given the configuration 
	public void remove(String config) throws DictionaryException{
		
		LinkedList<Data>list=hashTable[hashCode(config)]; //matches the list pointer to the linked list of keys using hash function
		Iterator<Data>iterator=list.iterator();    //iterator() method to initialize an iterator to iterate through the linked list
		while (iterator.hasNext()){
			Data r =iterator.next();
			if(r.getConfiguration().equals(config)) {
				list.remove(r);
				return;
			}
		}
		throw new DictionaryException();
	}
	//get method to get the score of a configuration from the dictionary
	public int get(String config) {
		LinkedList<Data> list=hashTable[hashCode(config)];  //matches the list pointer to the linked list of keys using hash function
		Iterator<Data>iterator=list.iterator();    //iterator() method to initialize an iterator to iterate through the linked list
		while (iterator.hasNext()) {
			Data r=iterator.next();
			if (r.getConfiguration().equals(config)) {
				return r.getScore();
			}
		}
		return -1;
	}
	//count the total number of records in the dictionary
	public int numRecords() {
		int count=0;
		for (int i=0;i<tableSize;i++) {
			LinkedList<Data>list=hashTable[i];
			for (int j=0;j<list.size();j++) {
				count+=1;
			}
		}
		return count;
	}
}
