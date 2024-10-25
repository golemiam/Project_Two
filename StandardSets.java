package projectTwo;

import java.util.HashSet;
import java.util.List;

/**
 * The StandardSets class provides set operations for one or more sets.
 * The set operations in this class include complement, intersect, union, difference, and
 * symmetric difference.
 * @author Armando C. + Martin Allen
 */
public class StandardSets {

	/**
	 * Calculates the complement of the subset relative to the universal set.
	 * The complement consists of all elements in the universal set that are not in the subset.
	 * 
	 * @param universalSet the set containing all possible elements
	 * @param subset the set whose elements will be excluded from the complement set
	 * @return a new set containing all elements in the universal set except those in the subset
	 */
	public static HashSet<Integer> complement(HashSet<Integer> universalSet, HashSet<Integer> subset) {
		HashSet<Integer> complementSet = difference(universalSet, subset);
		return complementSet;
	}
	
	/**
	 * Calculates the symmetric difference between two sets and returns it.
	 * The symmetric difference is a set of elements that are in either set, but not in both.
	 * 
	 * @param firstSet the first set of elements
	 * @param secondSet the second set of elements
	 * @return a new set containing the symmetric difference of firstSet and secondSet
	 */
	public static HashSet<Integer> symmetricDifference(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
		HashSet<Integer> firstDifference = difference(firstSet, secondSet);
		HashSet<Integer> secondDifference = difference(secondSet,firstSet);
		HashSet<Integer> sdSet = union(firstDifference,secondDifference);
		return sdSet;
	}
	
	/**
	 * Calculates the difference between two sets by removing
	 * elements from the first set that are present in the second set.
	 * 
	 * @param primarySet the set from which elements will be removed
	 * @param exclusionSet the set containing elements to be excluded from the primary set
	 * @return a new set containing the elements of primarySet that exclude the elements in exclusionSet
	 */
	public static HashSet<Integer> difference(HashSet<Integer> primarySet, HashSet<Integer> exclusionSet) {
		HashSet<Integer> differencedSet = new HashSet<>(primarySet);
		HashSet<Integer> intersectingElements = intersect(primarySet, exclusionSet);
		
		for (Integer i : intersectingElements)
			differencedSet.remove(i);
		
		return differencedSet;
	}
	
	/**
	 * Calculates the intersection of two sets, returning a set 
	 * containing all elements that are shared by both sets.
	 * 
	 * @param firstSet the first set of elements
	 * @param secondSet the second set of elements
	 * @return a new set that contains elements that are present in both firstSet and secondSet
	 */
	public static HashSet<Integer> intersect(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
		HashSet<Integer> intersectSet = new HashSet<>();
		for (Integer i : firstSet)
			if (secondSet.contains(i))
				intersectSet.add(i);
		
		return intersectSet;
	}
	
	/**
	 * Calculates the union of two sets, combining all unique elements 
	 * from both sets into a new set.
	 * 
	 * @param firstSet the first set of elements
	 * @param secondSet the second set of elements
	 * @return a new set containing all unique elements of firstSet and secondSet
	 */
	public static HashSet<Integer> union(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
		HashSet<Integer> unionedSet = new HashSet<>(firstSet);
	    unionedSet.addAll(secondSet);
	    return unionedSet;
	}

	/**
	 * Creates a bit string for a set to display which elements it has from the universal set.
	 * '1' corresponds to the presence of an element in the subset, 
	 * while '0' indicates the absence of an element.
	 * 
	 * @param USet the set containing all possible elements
	 * @param set the subset for which the bit string is generated
	 * @return a string of '1's and '0's representing the presence of elements
	 *  	   from the subset in the universal set
	 */
	private static String bitString (HashSet<Integer> USet, HashSet<Integer> set) {
		HashSet<Integer> subset = new HashSet<>(set);
		HashSet<Integer> universalSet = new HashSet<>(USet);
		StringBuilder bitString = new StringBuilder();
		for (Integer i : universalSet) {
			if (subset.contains(i)) {
				bitString.append(1);
			}
			else {
				bitString.append(0);
			}
		}
		
		return bitString.toString();
	}

	/**
	 * Creates the Universal Set, Set A, Set B, and prints the results of the operations.
	 * @param args
	 */
	public static void main(String[] args) {
		 HashSet<Integer> universalSet = new HashSet<Integer>();
		 universalSet.add(0);
		 universalSet.add(1);
		 universalSet.add(2);
		 universalSet.add(3);
		 universalSet.add(4);
		 universalSet.add(5);
		 universalSet.add(6);
		 universalSet.add(7);
		 universalSet.add(8);
		 universalSet.add(9);
		 System.out.println("Universal Set: " + universalSet);
		 
		 //A : {0,1,2,3,4,5,6}
		 HashSet<Integer> setA = new HashSet<Integer>();
		 //B : {3,4,5,6,7,8,9}
		 HashSet<Integer> setB = new HashSet<Integer>();
		 //Hard codes set A and set b with elements from the universal set.
		 for (int i = 0; i < 3; i++) {
			 setA.add(i);
		 }
		 for (int i = 3; i < 7; i++) {
			 setA.add(i);
			 setB.add(i);
		 }
		 for (int i = 7; i < 10; i++) {
			 setB.add(i);
		 }
		 
		 //Set A: {0,1,2,3,4,5,6}
		 System.out.println("SetA: " + setA);
		 //Set B: {3,5,6,7,8,9}
		 System.out.println("setB: " + setB);
		 //Not(A): {7,8,9}
		 System.out.println("---------------------------------------------" + "\n");
		 System.out.println("Not(A): " + complement(universalSet,setA));
		 //A U B: {0,1,2,3,4,5,6,7,8,9}
		 System.out.println("A U B: " + union(setA,setB));
		 //A Intersect B: {3,4,5,6}
		 System.out.println("A intersect B: " + intersect(setA,setB));
		 //B Intersect A: {3,4,5,6}
		 System.out.println("B intersect A: " + intersect(setB,setA));
		 
		 //A - B: {0,1,2}
		 System.out.println("A - B: " + difference(setA,setB));
		 //B -A: {7,8,9}
		 System.out.println("B - A: " + difference(setB,setA));
		 //A SD B: {0,1,2,7,8,9}
		 System.out.println("A SymmetricDifference B: " + symmetricDifference(setA, setB));

		 System.out.println("BitString of Set B: " + bitString(universalSet,setB));
	}

}
