import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class csvReader {
    public csvReader() {
    }
    public List<pair<String,String>> read(String fileName) throws IOException {
        List<pair<String,String>> airportCodesAndLocation = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        String location;
        String code;
        while((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            location = tokens[0] + ", " + tokens[1];
            code = tokens[2];
            airportCodesAndLocation.add(new pair<String,String>(code, location));
        }
        return airportCodesAndLocation;
    }
}
