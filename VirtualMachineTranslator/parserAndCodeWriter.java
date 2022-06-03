import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
            if(!(line.isEmpty())){
            if(line.charAt(0)!='/'){
            arr = line.split(" ");
            fileData.add(arr);
            }
        }
        }

        br.close();
        fr.close();
        return fileData;
    }


    public void writeCode(ArrayList<String[]> fileData, String fileName) throws IOException{

        equivalentFunctions operation = new equivalentFunctions();
        String[] file = fileName.split("\\.(?=[^\\.]+$)");
        FileWriter fw = new FileWriter(file[0] + ".asm");

        for (String[] line : fileData) {
        if(line[0].equals("add")||line[0].equals("sub")){
            fw.append(operation.ch_add_sub(line));
        }
            
        if(line[0].equals("push")||line[0].equals("pop")){
            switch(line[1]) {

                case "static":
                    // Changing Static
                    fw.append(  operation.ch_static(line, fileName) );

                    break;
                case "pointer":
                    //Changing Pointer

                    fw.append(  operation.ch_pointer(line) );
                    
                    break;
                case "constant":
                    //Getting constant

                    fw.append(  operation.ch_constant(line) );

                    break;

                case "local":
                case "argument":
                case "temp":
                case "this":
                case "that":
                    //Changing which have common ways 

                    fw.append(  operation.ch_local(line) );

                    break;
                default:
                    System.out.println("Unexpected Commands");
                    System.exit(0);
            }

        }
    }

        //File Writer Closing
        fw.close();

    }

}
