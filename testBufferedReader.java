// import necessary packages
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testBufferedReader {
	// to handle exceptions include throws
	public static void main(String[] args)
		throws IOException
	{

		String filename = "deck_DoNotDelete.txt";

		// list that holds strings of a file
		List<String> listOfStrings
			= new ArrayList<String>();
	
		// load data from file
		BufferedReader bf = new BufferedReader(
			new FileReader("decks/" + filename));
	
		// read entire line as string
		String line = bf.readLine();
	
		// checking for end of file
		while (line != null) {
			listOfStrings.add(line);
			line = bf.readLine();
		}
	
		// closing bufferreader object
		bf.close();
	
		// storing the data in arraylist to array
		String[] array
			= listOfStrings.toArray(new String[0]);
	
		// printing each line of file
		// which is stored in array
		for (String str : array) {
			System.out.println(str);
		}
		System.out.println(array[0]);
	}
	
}
