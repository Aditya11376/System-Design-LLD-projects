import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Persistence{

    @Override
    public void save(String data) {
        try{
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("\nDocument saved to 'document.txt'.");
        } catch (IOException e) {
            throw new RuntimeException("Error: Unable to open file for writing.");
        }
    }

}
