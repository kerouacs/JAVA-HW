/**
 * @author <Ruopeng Jiang> This class contains the solution for Worksheet1
 */

 public class Worksheet1 {

	// Exercise 1

	 static int power(int m, int n) {
		if(n==1) {
			return m;
		}
		return m*power(m,n-1);
	}

	 static int fastPower(int m, int n) {
		if(n==0) {
			return 0;
		}
		else if (n==1) {
			return m;
		}
		else {
		    if(n%2==0) {
		    	return fastPower(m,n/2)*fastPower(m,n/2);
		}
		    else  
		    	return m*fastPower(m,n-1);
		}
	}

	// Exercise 2

	 static List<Integer> negateAll(List<Integer> a) {
		 
		 if (a.isEmpty()) {
			 return a;
		 }
		 else {			 
			 return new List<Integer>(a.head*-1, negateAll(a.getTail())) ;		 
		 }		 
	 }

	// Exercise 3

	 static int find(int x, List<Integer> a) {
		 if (a.isEmpty()) {
		        throw new IllegalArgumentException("No this number in List");
		      }
		 else {
			    if (a.getHead()!=x) {
			    	return find(x,a.getTail())+1;
			    }
			    else 
			    	return 0;
		 }
	 }
	// Exercise 4

	 static boolean allEven(List<Integer> a) {
		if (a.isEmpty()) {
			return true;
		}
		else {
		    if (a.getHead()%2==0) {
		    	return allEven(a.getTail());
		    }
		    else
		    	return false;
		}
	}

	// Exercise 5

	 static List<Integer> evenNumbers(List<Integer> a) {
		if (a.isEmpty()) {
			return a;
		}
		else {
			return a.getHead()%2==0 ? new List<Integer> (a.getHead(),evenNumbers(a.getTail())) : 
									  evenNumbers(a.getTail());
		}
	}

	// Exercise 6

	 static boolean sorted(List<Integer> a) {
		if (a.isEmpty()||a.getTail().isEmpty()) {
			return true;
		}
		else {
			if (a.getHead()<a.getTail().getHead()) {
				return false;
			}
			else
				return sorted(a.getTail());
		}
	}

	// Exercise 7

	 static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if(a.isEmpty()) {
			return b;
		}
		if(b.isEmpty()) {
			return a;
		}
		else 
			return a.getHead()>=b.getHead()? new List<Integer> (a.getHead(),merge(a.getTail(),b)) :
											 new List<Integer> (b.getHead(),merge(a,b.getTail()));
		
	}

	// Exercise 8

	static List<Integer> removeDuplicates(List<Integer> a) {
		if (a.isEmpty()||a.getTail().isEmpty()) {
			return a;
		}
		else
			return new List<Integer>(notDuplicates(a).getHead(), removeDuplicates(notDuplicates(a).getTail()));
	}
	
	static List<Integer> notDuplicates(List<Integer> a) { 
		if(a.isEmpty()||a.getTail().isEmpty()) {
			return a;
		}
		else if (a.getHead()==a.getTail().getHead()) {
			return notDuplicates(a.getTail());
		}
		else 
			return a;
	}
	 
	
	static void printList (List <Integer> L) {
		  if (L.isEmpty())
		  return;
		  else {
		  System.out.println(L.getHead());
		  printList(L.getTail());
		  }
	}

	 public static void main(String args[]) {

		 List L = new List(9, new List(8, new List(8,
	  			  new List(4, new List()))));
		 List L1 = new List(8, new List(8, new List(2,
	  			  new List(1, new List()))));
		 printList(removeDuplicates(L));
//		 System.out.println(sorted(L));

	 }
}
