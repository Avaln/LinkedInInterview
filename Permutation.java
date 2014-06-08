import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// String.subString(start, end) returns from start to end-1
// if start == end, the substring is empty
// You cannot remove element from set or map while you are traversing them
// When a object is passed into a methods, you can modify that object using
// the value copy of its reference, but assigning that value copy of its 
// reference to another object won't change the original object
public class Permutation {

	public static void FindPermutation(int[] A) {
		HashSet<String> h = new HashSet<String>();
		String a = "";
		for (int i = 0; i < A.length; i++)
			a += A[i];

		PermuteRecurse(a, h);
		PrintPermutation(h);

	}

	static void PermuteRecurse(String a, HashSet<String> h) {
		// base case
		if (a.length() == 1) {
			h.add(a);
			return;
		}

		char c = a.charAt(0);
		PermuteRecurse(a.substring(1, a.length()), h);

		HashSet<String> hh = new HashSet<String>();
		for (String s : h) 
			for (int i = 0; i <= s.length(); i++) {
				String t = s.substring(0, i) + c
						+ s.substring(i, s.length());
				hh.add(t);
			}
			
		// h = hh doesn't work here
		h.clear();
		for(String s: hh)
		  h.add(s);	
	}

	static void PrintPermutation(HashSet<String> h) {
		for (String s : h)
			System.out.print(s + " ");
	}

	static void PermutationBottomUp(int[] A){
		  HashSet<String> h = new HashSet<String>();
		  HashSet<String> hh = new HashSet<String>();
		  
		  h.add(Integer.toString(A[0]));
		  for(int i = 1; i < A.length; i++){
		    for(String s: h)
		      for(int j = 0; j <= s.length(); j++){
		        hh.add(s.substring(0, j) + A[i] + s.substring(j, s.length()));
		      }
		      
		    h.clear();
		    for(String s: hh)
		      h.add(s);
		    
		    hh.clear();
		  }
		  
		  for(String s: h){
		    System.out.print(s + " ");
		  }
		  
		}
	
	public static void main(String[] args) {

		Permutation.FindPermutation(new int[] { 1, 2, 3 });
		System.out.println();
		Permutation.PermutationBottomUp(new int[] {1, 2, 3});
		System.out.println();
		
		String s = "12345";
		char c = '#';
		List<String> l = new ArrayList<String>();
		for(int i = 0; i<= s.length(); i++){
	       l.add(s.substring(0, i) + c + s.substring(i, s.length()));
		}
		
		for(String ss: l)
		   System.out.print(ss + " ");
		//String s1 = s.substring(0, 0);
		//String s2 = s.substring(5, 5);
		
		//System.out.println(s1 + " " + s2);
	}

}
