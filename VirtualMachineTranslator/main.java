import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        
        parserAndCodeWriter translator = new parserAndCodeWriter();

        String FileName = "StaticTest.vm";

        translator.writeCode(translator.getFileData(FileName), FileName);


    }

}