import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvReader {
    public static void main(String[] args) {
        // Path to the input CSV file
        String inputFilePath = "data/mydata.csv";
        // Path to the output file
        String outputFilePath = "data/converted.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
             
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                // Write each line of the CSV file to the output file
                bw.write(line);
                bw.newLine(); // Add a newline after each line
                
                // Debugging: Print the number of lines processed
                lineCount++;
                
                if (lineCount % 100 == 0) {
                    System.out.println("Processed " + lineCount + " lines...");
                }
            }
            
            System.out.println("Data successfully written to " + outputFilePath);
            System.out.println("Total lines processed: " + lineCount);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}