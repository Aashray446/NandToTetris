import java.io.IOException;
import java.util.Scanner;

public class U4AIE21085 {

    public static void main(String[] args) throws IOException {
       
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the file name: - ");
        String file_name = in.next();

        // Making new object of assembler
        operations assembler = new operations();
        // Removing Spaces
        assembler.remove_spaces("./hackcode/" + file_name, "./Question_no_1_outputs/no_space.asm");

        assembler.convert_data_into_binary("./Question_no_1_outputs/no_space.asm", "./Question_no_1_outputs/binary" + file_name + ".hack");
    
        in.close();
    }

}

