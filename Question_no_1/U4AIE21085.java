import java.io.IOException;
import java.util.Scanner;

public class U4AIE21085 {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
       
        // Making new object of assembler
        operations assembler = new operations();

        String file_name = in.next();
        // Removing Spaces
        assembler.remove_spaces("./hackcode/" + file_name , "./Question_no_1_outputs/no_space.asm");
        // Generating required initial hasmap
        ///assembler.generate_initial_hasp();
        //Generating Labels table
        //assembler.make_memory_table("./no_space.asm");

        // Removing lables 
        //assembler.remove_labels("./no_space.asm", "./no_space_label.asm");

        // Handling unknown variables
        //assembler.add_unkown_label("./no_space_label.asm");
        //Replacing @tables to its values
        //assembler.replace_symbols_with_address("./no_space_label.asm", "@convert_to_binary.asm");
        
        assembler.convert_data_into_binary("./Question_no_1_outputs/no_space.asm", "./Question_no_1_outputs/binary"  + file_name + ".hack");
        in.close();        
    }

}

