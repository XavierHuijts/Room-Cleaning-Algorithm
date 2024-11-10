package Main;

public class Algorithm_test_Java {
	
	public static void main(String[] args) {	
		
		/// It was not necessary to create the Matrix class, but I did this for own OOP practise 
		/// Four different matrices are used to test the algorithm
		/// Chars are used (instead of Strings) for memory efficiency purposes
		
		/// Test 1
		char[][] matrix_1 =  {{'0', '0', '0', '0', '1', '1', '0'},
				      {'0', '0', '0', '0', '1', '1', '0'},
		  		      {'0', '0', '0', '0', '1', '1', '0'},
				      {'0', '0', '0', '0', '1', '1', '0'},
		    		      {'0', '0', '0', '0', '1', '1', '0'},
		  		      {'0', '0', '0', '0', '1', '1', '0'},
				      {'0', '0', '0', '0', '1', '1', '0'}};
		
		System.out.println("Result for test 1");
		Matrix test_1 = new Matrix(matrix_1);
		test_1.results();	
	
		
		/// Test 2
		char[][] matrix_2 = {{'0', '#', '0', '0', '1', '1', '0'},
				     {'0', '0', '#', '0', '0', '0', '0'},
			   	     {'0', '0', '#', '1', '#', '#', '#'},
				     {'0', '#', '0', '0', '#', '0', '0'},
				     {'0', '0', '#', '#', '#', '0', '0'},
			   	     {'0', '1', '0', '0', '#', '0', '1'},
			  	     {'0', '1', '0', '0', '#', '0', '0'}};
		
		System.out.println("Result for test 2");
		Matrix test_2 = new Matrix(matrix_2);
		test_2.results();	

		
		/// Test 3
		char[][] matrix_3 = {{'0', '0', '#', '0', '0', '0', '0'},
	                             {'0', '0', '#', '0', '0', '0', '0'},
	                             {'0', '0', '#', '#', '#', '#', '0'},
	                             {'0', '0', '#', '0', '0', '#', '#'},
	                             {'0', '0', '#', '0', '0', '0', '0'},
	                             {'0', '1', '0', '#', '0', '0', '0'},
	                             {'0', '1', '0', '#', '0', '0', '0'}};
	
		System.out.println("Result for test 3");
		Matrix test_3 = new Matrix(matrix_3);
		test_3.results();	
	
		
		/// Test 4
		char[][] matrix_4 = {{'0', '0', '#', '0', '0', '0', '0'},
		            	     {'0', '1', '#', '0', '0', '0', '0'},
		            	     {'0', '0', '#', '#', '#', '#', '0'},
		        	     {'#', '#', '#', '0', '0', '#', '#'},
		            	     {'0', '0', '#', '0', '0', '0', '0'},
		            	     {'0', '1', '0', '#', '0', '0', '0'},
		            	     {'0', '1', '0', '#', '0', '0', '0'}};

		System.out.println("Result for test 4");
		Matrix test_4 = new Matrix(matrix_4);
		test_4.results();	

	}
}

