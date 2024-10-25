package SetManipulation;

import java.util.HashSet;
import java.util.List;

/**
 * The StandardSets class provides set operations for one or more sets.
 * The set operations in this class include complement, intersect, union, difference, and
 * symmetric difference.
 * @author Armando C.
 */
public class StandardSets {

	/**
	 * Finds the difference of the universal set and the given original set.
	 * @param set
	 * @return complement set
	 */
	public static HashSet<Integer> complement(HashSet<Integer> UniversalSet, HashSet<Integer> originalSet) {
		HashSet<Integer> complementSet = difference(UniversalSet, originalSet);
		return complementSet;
	}
	
	/**
	 * Creates two differenced sets of A-B and B-A. The two sets are then unionized.
	 * @param firstSet
	 * @param secondSet
	 * @return sdSet
	 */
	public static HashSet<Integer> symmetricDifference(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
		HashSet<Integer> firstDifference = difference(firstSet, secondSet);
		HashSet<Integer> secondDifference = difference(secondSet,firstSet);
		HashSet<Integer> sdSet = union(firstDifference,secondDifference);
		return sdSet;
	}
	/**
	 * Finds the intersecting elements of the first and second set,
	 * creates differenced set using a same elements in the first set,
	 * then subtracts the intersecting elements from the first set.
	 * @param firstSet
	 * @param secondSet
	 * @return differencedSet
	 */
	public static HashSet<Integer> difference(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
		HashSet<Integer> differencedSet = new HashSet<Integer>(firstSet);
		HashSet<Integer> intersectingElements = intersect(firstSet, secondSet);
		
		for (Integer i: intersectingElements) {
			differencedSet.remove(i);
		}
		
		return differencedSet;
	}
	
	/**
	 * Searches the two sets for the same elements.
	 * Creates a new set of those intersecting elements.
	 * @param firstSet
	 * @param secondSet
	 * @return intersectSet
	 */
	public static HashSet<Integer> intersect(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
		HashSet<Integer> intersectSet = new HashSet<Integer>();
		for (Integer i: firstSet) {
			for (Integer j: secondSet) {
				if (i == j) {
					intersectSet.add(i);
				}
			}
		}
		return intersectSet;
	}
	
	/**
	 * Creates a unioned set with all the elements found in the two sets.
	 * @param firstSet
	 * @param secondSet
	 * @return unionedSet
	 */
	public static HashSet<Integer> union(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
		HashSet<Integer> unionedSet = new HashSet<Integer>();
		for (Integer i: firstSet) {
			unionedSet.add(i);
		}
		for (Integer i: secondSet) {
			unionedSet.add(i);
		}
		return unionedSet;
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
	}

}
