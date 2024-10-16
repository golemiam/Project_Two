package SetManipulation;


import java.util.ArrayList;
import java.util.List;

public class BasicSets {
	
	/**
	 * The complement method gives the expected output, but the process is different from the textbook.
	 * Loops through the original set and creates a complement/negated set.
	 * If an element in the original set is 1, a 0 is added to the complement set.
	 * If an element in the original set is 0, a 1 is added to the complement set.
	 * @param set
	 * @return
	 */
	public static List<Integer> complement(List<Integer> originalSet) {
		List<Integer> complementSet = new ArrayList<Integer>();
		for (Integer i: originalSet) {
			if (i == 1) {
				complementSet.add(0);
			}
			else {
				complementSet.add(1);
			}
		}
		return complementSet;
	}
	
	/**
	 * Searches the two sets and checks if an element is in either sets.
	 * If either set contains a 1 for an elements, a 1 is added to the unioned Set.
	 * @param firstSet
	 * @param secondSet
	 * @return
	 */
	public static List<Integer> union(List<Integer> firstSet, List<Integer> secondSet) {
		List<Integer> unionedSet = new ArrayList<Integer>();
		for (int i = 0; i < firstSet.size(); i++) {
			if (firstSet.get(i) == 1 || secondSet.get(i) == 1) {
				unionedSet.add(1);
			}
			else unionedSet.add(0);
		}
		
		return unionedSet;
	}
	
	/**
	 * Searches the two sets and checks if an element is in both sets.
	 * If both sets contains a 1 for an element, a 1 is added to the intersected set.
	 * @param firstSet
	 * @param secondSet
	 * @return
	 */
	public static List<Integer> intersect(List<Integer> firstSet, List<Integer> secondSet) {
		List<Integer> unionedSet = new ArrayList<Integer>();
		for (int i = 0; i < firstSet.size(); i++) {
			if (firstSet.get(i) == 1 && secondSet.get(i) == 1) {
				unionedSet.add(1);
			}
			else unionedSet.add(0);
		}
		return unionedSet;
	}

	/**
	 * Test driver with hard coded data.
	 * @param args
	 */
	public static void main(String[] args) {
	 List<Integer> UniversalSet = new ArrayList<Integer>();
	 UniversalSet.add(0);
	 UniversalSet.add(1);
	 UniversalSet.add(2);
	 UniversalSet.add(3);
	 UniversalSet.add(4);
	 UniversalSet.add(5);
	 UniversalSet.add(6);
	 UniversalSet.add(7);
	 UniversalSet.add(8);
	 UniversalSet.add(9);
	 System.out.println(UniversalSet);
	 
	 //Every element in Set A and B are in the Universal Set. Therefore A and B are a subset of U.
	 
	 //A : {0,1,2,3,4,5,6}
	 List<Integer> SetA = new ArrayList<Integer>();
	 //B : {3,4,5,6,7,8,9}
	 List<Integer> SetB = new ArrayList<Integer>();
	 
	 for (int i = 0; i < 3; i++) {
		 SetA.add(1);
		 SetB.add(0);
	 }
	 for (int i = 3; i < 7; i++) {
		 SetA.add(1);
		 SetB.add(1);
	 }
	 for (int i = 7; i < 10; i++) {
		 SetA.add(0);
		 SetB.add(1);
	 }
	 
	 //A : {0,1,2,3,4,5,6}
	 System.out.println("A : " + SetA);
	 //B : {3,4,5,6,7,8,9}
	 System.out.println("B : " + SetB);
	 System.out.println();
	 
	 //Not(A) : {7,8,9}
	 System.out.println("not(A) : " + complement(SetA));
	 //A U B : {0,1,2,3,4,5,6,7,8,9}
	 System.out.println("A U B : " + union(SetA, SetB));
	 //A Interset B : {3,4,5,6}
	 System.out.println("A Interset B : " + intersect(SetA, SetB));
	}

}
