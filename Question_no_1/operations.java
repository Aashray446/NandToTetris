import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class operations {

    HashMap<String, Integer> record_table = new HashMap<>();

    void print() {
        System.out.println(record_table);
        
        }
    //Starting Hashmap Values initially 
    void generate_initial_hasp() {
        String [] pre_defined_symbol = new String[] {"R0=0","R1=1","R2=2","R3=3","R4=4","R5=5","R6=6","R7=7","R8=8",
        "R9=9","R10=10","R11=11","R12=12","R13=13","R14=14","R15=15","SCREEN=16384","KBD=24576","SP=0","LCL=1","ARG=2","THIS=3",
        "THAT=4"};

        for (int i=0;i < pre_defined_symbol.length;i++) 
        {
            String x = pre_defined_symbol[i].split("=")[0];
            int y =  Integer.parseInt(pre_defined_symbol[i].split("=")[1]);
            record_table.put(x, y);
        }
            
    }

    // Removing spaces 
    void remove_spaces(String input_file_name, String output_file_name) throws IOException {
        File fp = new File(input_file_name);
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
        
        FileWriter fw = new FileWriter(output_file_name);
        
      
        String line;
        while((line = br.readLine()) != null) { 
            // Checking For Empty Line
            if( !(line.isEmpty() ) ) {
                // Checking for comments
                if(!(line.charAt(0)=='/')) {

                    // To remove inline comments 
                    String[] split_line = line.split("/");

                    String tmp = split_line[0];
                    StringBuilder new_line = new StringBuilder();
                    // Now need to remove spaces
                    for(int i = 0; i < tmp.length(); i++) {
                        if(tmp.charAt(i) != ' ') {
                            new_line.append(tmp.charAt(i));
                        }
                    }

                    fw.write(new_line.toString());               
                    fw.write('\n');
                }
            }

        }
        br.close();
        fw.close();

    }



    // Calculating the positions of labels 

    void make_memory_table(String input_file_name) throws IOException {

        File fp = new File(input_file_name);
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
        
       //FileWriter fw = new FileWriter("Aashraya_21085_no_whitespace.asm");
        
       //Hashtables to record the postions of lables
       

        String line;
        // Pointer to replace labels with address
        int current_line = 0;
        while((line = br.readLine()) != null) { 

            //Checking for the labels() 
            
            if(line.charAt(0) == '(' ) {
                String label_name;

                //Extracting the label name 
                label_name =  line.substring(1, line.length()-1);
                record_table.put(label_name, current_line);
                current_line = current_line-1;
                }
                current_line += 1;

            }       
                    
              
        br.close();
        fr.close();

    }


    void remove_labels(String input_file_name, String output_file_name) throws IOException {
        File  no_space_file = new File(input_file_name);
        FileReader fre = new FileReader(no_space_file);
        BufferedReader br = new BufferedReader(fre);
        FileWriter fw = new FileWriter(output_file_name);

        String line;

        while((line = br.readLine()) != null) {
            if(!(line.charAt(0) == '(') ) {

                fw.write(line);
                fw.write("\n");

            }           
                    

        }
        br.close();
        fre.close();
        fw.close();

        
    } 


void replace_symbols_with_address(String input_file_name, String output_file_name) throws IOException {
    File  no_space_file = new File(input_file_name);
        FileReader fre = new FileReader(no_space_file);
        BufferedReader br = new BufferedReader(fre);
        FileWriter fw = new FileWriter(output_file_name);

        String line;

        String key;

        while((line = br.readLine()) != null) {
            if((line.charAt(0) == '@') ) {
            
                key = line.substring(1, line.length());
                if( record_table.containsKey(key) ) {
                    fw.write("@" + record_table.get(key));
                    fw.write("\n");
                }
                else{
                    fw.write(line);
                    fw.write("\n");
                }

            } 
            else{
                fw.write(line);
                fw.write("\n");
            }          
                    

        }
        br.close();
        fre.close();
        fw.close();

}

void convert_data_into_binary(String input_file_name, String output_file_name) throws IOException {

    File  asmFile = new File(input_file_name);
    FileReader fre = new FileReader(asmFile);
    BufferedReader br = new BufferedReader(fre);
    FileWriter fw = new FileWriter(output_file_name);

    get_a_c_eq _calculate = new get_a_c_eq();

    String line;


    while((line = br.readLine()) != null) {
        fw.write( _calculate.get_eq_binary(line) );
        fw.write("\n");
    }
    br.close();
    fre.close();
    fw.close();


    


}

void add_unkown_label(String input_file_name) throws IOException {
    File new_file = new File(input_file_name);
    FileReader fr = new FileReader(new_file);
    BufferedReader br = new BufferedReader(fr);

    String line;
    int var_count = 16;
    while((line = br.readLine()) != null) {
        if(line.charAt(0) == '@') {

            String a_var = line.split("@")[1];
            if(!record_table.containsKey(a_var) && !a_var.matches("[0-9]") ) {
            
                record_table.put(a_var, var_count);
                var_count += 1;
            }
        }
    }
    br.close();
    fr.close();

}


}