import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private BufferedReader bufferedReader;

    public CsvReader(String pathFile) {
        try{
            this.bufferedReader = new BufferedReader(new FileReader(pathFile));
        }catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    public List<String> readFromCsv() {
        String row;
        List<String> rows = new ArrayList<>();
        try{
            while ((row = bufferedReader.readLine()) != null) {
            rows.add(row);
            }
            this.bufferedReader.close();
        } catch(IOException exc) {
            System.out.println("File reading error");
        }
        return rows;
    }
}