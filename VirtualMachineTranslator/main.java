import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        
        parserAndCodeWriter translator = new parserAndCodeWriter();

        String FileName = "test.txt";

        translator.writeCode(translator.getFileData(FileName), FileName);


    }

}