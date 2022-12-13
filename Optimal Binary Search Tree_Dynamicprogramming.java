public class dynamicprogramming {
	    public static void main(String[] args) {
	    	String[] words = {"apple","egg","grape","juice","melon","orange","pear"};
	    	int[] freq = {6,1,3,8,4,10,2};
	    	String[][] startWord = new String [words.length + 1][words.length + 1];
	    	String[][] endWord = new String [words.length + 1][words.length + 1];
	    	String[][] rootWord = new String [words.length +1][words.length + 1];
	    	int[][] weight = new int [words.length +1][words.length +2];
	    	
	    	//first line
	    	for (int j=1 ; j <= words.length; j++) {
	    		startWord [ 1 ][ j ] = words [ j - 1 ];
	    		endWord [ 1 ][j ] = words [ j - 1 ] ;
	    		rootWord [ 1 ][ j ] = words [ j - 1 ] ;
	    		weight [ 1 ][ j ] = freq [ j - 1 ] ;
	    	}
	    	
	    	//other lines
	    	for ( int i = 2 ; i <= words.length ; i++) {
	    		for ( int j = 1 ; j <= words.length - i + 1 ; j++) {
		    		startWord [ i ] [ j ] = words [ j - 1 ] ;
		    		endWord [ i ] [j ] = words [ j + i - 2] ;
		    		int bestScore = Integer.MAX_VALUE;
		    		int sumWeight = 0 ;
		    		int bestPos = j ;
		    		for ( int k = j ; k < j + i ; k++) {
		    			sumWeight += freq [ k - 1 ] ;
			    		int leftWeight = weight [ k - j ] [ j ] ;
			    		int rightWeight = weight [ j + i - k - 1 ] [ k + 1 ] ;
			    		if ( leftWeight + rightWeight < bestScore )
			    		{
			    			bestPos = k ;
			    			bestScore = leftWeight + rightWeight;
			    		}
		    		}
		    		rootWord [ i ] [ j ] = words [ bestPos - 1 ] ;
		    		weight [ i ] [ j ] = bestScore + sumWeight ;
		    		}
	    	}
	    	// print table
	    	for ( int i = 1 ; i <= words . length ; i++) {
		    	for ( int j = 1 ; j <= words . length - i + 1 ; j++) {
		    	System.out.print ( startWord [ i ] [ j ] + ". ."  + endWord [ i ] [ j ] + "\t" ) ;
		    	}
		    	System.out.println ( "  " ) ;
		    	for ( int j = 1 ; j <= words . length - i + 1 ; j++) {
		    		System.out.print ( weight [ i ] [ j ] + "\t" + rootWord [ i ] [ j ] + "\t" ) ;
		    	}
		    	System.out.println ( "  " ) ;
	    	}

	    	
	  }
}

