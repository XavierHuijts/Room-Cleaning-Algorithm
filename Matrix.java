package Main;
import java.util.ArrayList;

/// See the Python notebooks for more detailed notes!

public class Matrix {
	
	/// Declare the input matrix and several properties of the matrix
	/// Char is used since its more memory efficient than strings
	public char[][] matrix;
	public int n_rows;
	public int n_cols;
	
	/// They variables belong to the unique instance
	public Matrix(char[][] matrix) {
		this.matrix = matrix;
		this.n_rows = matrix.length;
		this.n_cols = matrix[0].length;
	}
	
	/// Return bool whether a certain char is a wall or not
	private boolean is_wall(char[][] X, int i, int j){
		
		char single_cell = X[i][j];
		char wall = '#';
		
		if(single_cell == wall) {
			return true;}
		else {
			return false;}
	}
	
	/// Convert matrix to arraylist of coordinates (excl. walls)
	private ArrayList<int[]> clean_coordinates(){

		ArrayList<int[]> coordinates = new ArrayList<>();

		for(int i = 0; i < n_cols; i++) {
			for(int j = 0; j < n_rows; j++) {
				if(is_wall(matrix, i, j) == true) {				
					continue;}
				else {
					int[] cor = {i, j};
					coordinates.add(cor);}}}
		
		return coordinates;
	}
	
	/// Return bool whether two rooms are neighbours
	private boolean detect_neighbour(int[] cor, int[] cor2){
		
		int i = cor[0];
		int j = cor[1];
		int i2 = cor2[0];
		int j2 = cor2[1];
		
		int absolute_diff = Math.abs(i - i2) + Math.abs(j - j2); 
		
		if (absolute_diff == 1) {
			return true;}
		else {
			return false;}		
	}
	
	/// Find (and return) one local area at the time
	private ArrayList<int[]> find_local_area(ArrayList<int[]> coordinates){
		
		ArrayList<int[]> local_area = new ArrayList<>();
		int[] first_cor = coordinates.get(0);
		local_area.add(first_cor);

		boolean neighbouring = true;
		
		while(neighbouring) {
			neighbouring = false;
			for(int cor_index = 1; cor_index < coordinates.size(); cor_index++){
				for(int cor2_index = 0; cor2_index <  local_area.size(); cor2_index++){
					int[] cor = coordinates.get(cor_index);
					int[] cor2 = local_area.get(cor2_index);

					if(detect_neighbour(cor, cor2) && !local_area.contains(cor)){
						local_area.add(cor);
						neighbouring = true;
						break;}}}}
		
		return local_area;
	}
		
	
	private ArrayList<int[]> remove_array(ArrayList<int[]> coordinates, int[] cor_to_remove){

		ArrayList<int[]> new_array_list = new ArrayList<>();
		
		for(int cor_index = 0; cor_index < coordinates.size(); cor_index++){
			int[] cor = coordinates.get(cor_index);

			if(cor == cor_to_remove){
				continue;}
			else {
				new_array_list.add(cor);}}
		
		return new_array_list;
	}
	
	/// Import the clean coordinates, and find local areas until all are retrieved
	private ArrayList<ArrayList<int[]>> find_all_local_areas(){

		ArrayList<int[]> clean_cors = clean_coordinates();
		ArrayList<ArrayList<int[]>> local_areas = new ArrayList<>();
		
		while(clean_cors.size() > 0){

			ArrayList<int[]> local_area = find_local_area(clean_cors); 

			local_areas.add(local_area);

			for(int cor_index = 0; cor_index < local_area.size(); cor_index++){
				int[] cor = local_area.get(cor_index);

				clean_cors = remove_array(clean_cors, cor);}}  

		return local_areas;
	}
	
	/// Return bool whether a certain room is dirty (or not)
	private boolean is_dirty(int i, int j){
		
		char single_position = matrix[i][j];
		
		if(single_position == '1'){
			return true;}
		else {
			return false;}	
	}	
	
	/// Import all local areas, and return the number of local areas and cleaning sessions required
	private int[] n_local_areas_and_cleans_required(){
			
		// Main function: returning number of local areas and cleans required
			
		ArrayList<ArrayList<int[]>> local_areas = find_all_local_areas();
		int n_local_areas = local_areas.size();
		int n_cleans = 0;
			
		for(int local_area_i = 0; local_area_i < n_local_areas; local_area_i++){
			ArrayList<int[]> local_area = local_areas.get(local_area_i); 
			int n_rooms = local_area.size();

			for(int room_i = 0; room_i < n_rooms; room_i++){
				int[] room_cors = local_area.get(room_i);
				int i = room_cors[0];
				int j = room_cors[1];

				if(is_dirty(i, j)){
					n_cleans = n_cleans + 1;
					break;}}}
		
		return new int[] {n_local_areas, n_cleans};
		}			
		
	/// Print out the results for a given matrix
	public void results(){
			
		int[] results = n_local_areas_and_cleans_required();
			
		System.out.println("\n\tNumber of local areas: " + results[0] + "\n\tNumber of cleans required: " + results[1] + "\n");
		};			 
}
		

