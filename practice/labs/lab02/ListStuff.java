public class ListStuff{
	public static StringNode addToFront(String s, StringNode Nold){
		//if(Nold == null){
		//	Nold = new StringNode();
		//	Nold.data = s;
		//	return Nold;
    //}
		StringNode Nnew = new StringNode();
		Nnew.data = s;
		Nnew.next = Nold;
		return Nnew;
	}

	public static String[] listToArray(StringNode N){
		// get length of list
		StringNode copyOfN = N;
		int lengthOfN = 0;
		while(copyOfN != null){
			lengthOfN++;
			copyOfN = copyOfN.next;
		}
		String[] retval = new String[lengthOfN];
		int index = 0;
		while(N != null){
			retval[index] = N.data;
			N = N.next;
			index++;
		}
		return retval;
	}

  public static StringNode reverse(StringNode front){
    StringNode newf = null;
    while(front != null){
      newf = addToFront(front.data, newf);
      front = front.next;
    }
    return newf;
  }

	public static void main(String[] args){
		
		StringNode N = null;      // at this point N *is* an empty list
		N = addToFront("rat",N);  // at this point N *is* the list ("rat")
		N = addToFront("dog",N);  // at this point N *is* the list ("dog","rat")
		N = addToFront("pig",N);  // at this point N *is* the list ("pig","dog","rat
		String[] A = listToArray(N);
		for(int i=0; i<A.length; i++){
			System.out.println(A[i]);
		}
	}
}

