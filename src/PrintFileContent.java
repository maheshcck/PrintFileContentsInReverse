import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*The application prints the characters from the files in the opposite order they appear.*/

public class PrintFileContent {

	public static void main(String[] args) {
		if(args.length>0){
			new  PrintFileContent().printFileContentsInReverse(args);
		}else{
			System.out.println("Please provide the arguments (file names) and try again");
		}		
	}
	
	
	/*Method to print file data in reverse order*/
	public void printFileContentsInReverse(String[] args){
		String currLine;
		BufferedReader reader;
		List<String> fileLines;
		
		for (int i = args.length - 1; i >= 0; i--) {
			try {
				reader = new BufferedReader(new FileReader("src/" + args[i]));
				// read all the lines into list
				fileLines = new ArrayList<String>();
				while ((currLine = reader.readLine()) != null) {
					fileLines.add(currLine);
				}
				// print the lines in the reverse order
				for (int j = fileLines.size() - 1; j >= 0; j--) {
					//using the StringBuilder - reverse method 
					System.out.println(new StringBuilder(fileLines.get(j)).reverse().toString());
				}

			} catch (IOException e) {
				// prints exception message if exception is caught
				System.out.println(e.getMessage());
			}

		}
	}
	

}
