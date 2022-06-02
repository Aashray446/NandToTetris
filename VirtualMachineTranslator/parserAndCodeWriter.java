import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class parserAndCodeWriter {
    
    public ArrayList<String[]> getNextLine(String fileName) throws IOException {

        ArrayList<String[]> fileData = new ArrayList<String[]>();
        String[] arr;
        FileReader fr;
        BufferedReader br;

            fr = new FileReader(fileName);
            br = new BufferedReader(fr) ;

    

        String line;
        while(   (line = br.readLine()) != null )  {

            arr = line.split(" ");
            fileData.add(arr);

        }

        br.close();
        fr.close();
        return fileData;
    }

}
