public class get_a_c_eq {


    public String get_eq_binary(String instruct){

        String eq_binary = "";

        if(instruct.charAt(0) == '@' ) {
            
            eq_binary = get_a(instruct.substring(1));

        }
        else {
            eq_binary = get_c(instruct);
        }

        return eq_binary;
    }


    public String get_c(String instruct) {

        String dest = "null";
        String comp, jump  = "null";
        cal_c_binary _calculate = new cal_c_binary();

        // Case if it is a jump only statement
        if(instruct.indexOf("=") == -1) {
            String[] arr = instruct.split(";");
            comp = arr[0];
            jump = arr[1];
        }
        // Case if it is a only calculatoon
        else if(instruct.indexOf(";") == -1 ){
            String[] arr = instruct.split("=");
            dest = arr[0];
            comp = arr[1];     
        }
        // Case if there is both 
        else {
            String[] arr = instruct.split("=");
            dest = arr[0];
            String[] arr2 = arr[1].split(";");
            comp = arr2[0];
            jump = arr2[1];
         }
         



        return "111" +  _calculate.Cvalue(comp) + _calculate.Dvalue(dest) + _calculate.Jvalue(jump); 

    } 


    public String get_a (String instruct) {

        String binary_value = Integer.toBinaryString(Integer.parseInt(instruct));

        int additional_zero_required = 16-binary_value.length();

        for(int i = 0; i < additional_zero_required; i++) {
            binary_value = 0 + binary_value;
        }

        return binary_value;
    }

    //

}
