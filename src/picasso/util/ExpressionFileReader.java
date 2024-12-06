/**
 * 
 */
package picasso.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is a class that reads expression from a file and returns it as a string
 * @author Sylvia Agatako
 * 
 */


public class ExpressionFileReader {

 /**
  * Reads the contents of a given expression file and returns it as a string.
  * @param fileName The name of the file to read
  * @return The expression in the file as a string
  */
 public String readExpressionFromFile(String fileName) {
	 
     StringBuilder expression = new StringBuilder();
     
     try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
         String line;
         while ((line = read.readLine()) != null) {
             expression.append(line).append("\n"); // Append each line from the file
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
     return expression.toString();
 }
}


	

