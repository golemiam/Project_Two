package SetManipulation;


import java.util.ArrayList;
import java.util.List;

public class BasicSets {
	
	/**
	 * Creates differenced sets of A-B and B-A, then Unionizes the two differenced sets.
	 * @param firstSet
	 * @param secondSet
	 * @return
	 */
	public static List<Integer> symmetricDifference(List<Integer> firstSet, List<Integer> secondSet) {
		List<Integer> firstDifference = difference(firstSet, secondSet);
		List<Integer> secondDifference = difference(secondSet,firstSet);
		List<Integer> sdSet = union(firstDifference,secondDifference);
		return sdSet;
	}
	
	/**
	 * Finds the intersecting elements of the first and second set,
	 * then subtracts the intersecting elements from the first set.
	 * 
	 * If an element exists in both sets,
	 * A 0 is added to the differenced set.
	 * A 1 is added to the differenced set if the element only exists in the first set.
	 * @param firstSet
	 * @param secondSet
	 * @return
	 */
	public static List<Integer> difference(List<Integer> firstSet, List<Integer> secondSet) {
		List<Integer> differencedSet = new ArrayList<Integer>();
		List<Integer> intersectingElements = intersect(firstSet, secondSet);
		for (int i = 0; i < firstSet.size(); i++) {
			if (firstSet.get(i) == intersectingElements.get(i)) {
				differencedSet.add(0);
			}
			else {
				differencedSet.add(1);
			}
		}
		return differencedSet;
	}
	
	
	/**
	 * Complement method now aligns with textbook definition of complement sets.
	 * Finds the difference of the universal set and the original set.
	 * @param set
	 * @return
	 */
	public static List<Integer> complement(List<Integer> UniversalSet, List<Integer> originalSet) {
		List<Integer> complementSet = difference(UniversalSet, originalSet);
		return complementSet;
		
//		Old complement code - just in case
//		List<Integer> complementSet = new ArrayList<Integer>();
//		for (Integer i: originalSet) {
//			if (i == 1) {
//				complementSet.add(0);
//			}
//			else {
//				complementSet.add(1);
//			}
//		}
//		return complementSet;
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
	 List<Integer> originalSet = new ArrayList<Integer>();
	 originalSet.add(0);
	 originalSet.add(1);
	 originalSet.add(2);
	 originalSet.add(3);
	 originalSet.add(4);
	 originalSet.add(5);
	 originalSet.add(6);
	 originalSet.add(7);
	 originalSet.add(8);
	 originalSet.add(9);
	 System.out.println(originalSet);
	 
	 //U set: {1,1,1,1,1,1,1,1,1,1}
	 List<Integer> universalSet = new ArrayList<Integer>();
	 
	 for (Integer i: originalSet) {
		 universalSet.add(1);
	 }
	 
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
	 System.out.println("not(A) : " + complement(universalSet, SetA));
	 //A U B : {0,1,2,3,4,5,6,7,8,9}
	 System.out.println("A U B : " + union(SetA, SetB));
	 //A Interset B : {3,4,5,6}
	 System.out.println("A Interset B : " + intersect(SetA, SetB));
	 //A Difference B: {0,1,2}
	 System.out.println("A difference B: " + difference(SetA, SetB));
	 // A SymmetricDifference B: {0,1,2,7,8,9}
	 System.out.println("A SymmetricDifference B: " + symmetricDifference(SetA, SetB));
	}

}
