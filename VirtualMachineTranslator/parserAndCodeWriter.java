import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class parserAndCodeWriter {
    
    public ArrayList<String[]> getFileData(String fileName) throws IOException {

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


    public void writeCode(ArrayList<String[]> fileData){

        for (String[] line : fileData) {
            
            switch(line[1]) {

                case "static":
                    //Todo Something
                    break;
                case "pointer":
                    //Todo Something
                    break;
                case "constant":
                    //Todo Something
                    break;
                case "local":
                    //Todo Something
                    break;
                default:
                    System.out.println("Unexpected Commands");
                    System.exit(0);
            }

        }

    }

}
