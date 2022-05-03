import java.util.HashMap;

public class cal_c_binary {
    public String Cvalue(String a) 
    {
        String [] op1 = new String[]{"null=0000000","0=0101010","1=0111111","-1=0111010","D=0001100","A=0110000","!D=0001101","!A=0110011",
        "D+1=0011111","A+1=0110111","D-1=0001110","A-1=0110010","D+A=0000010","D-A=0010011","A-D=0000111","D&A=0000000",
        "D|A=0010101","M=1110000", "!M=1110011","M+1=1110111","M-1=1110010","D+M=1000010","D-M=1010011","M-D=1000111",
        "D&M=1000000","D|M=1010101", "-D=0001111" , "-A=0110011", "-M=1110011"};

        HashMap <String,String> cmap = new HashMap <String,String>();

        for (int i=0 ; i< op1.length;i++)
        {
            String x = op1[i].split("=")[0];
            String y = op1[i].split("=")[1];
            cmap.put(x, y);
        }

           return cmap.get(a);
        }

        public String Dvalue( String a )
        {
            String[] dest = new String[]{"null=000","M=001","D=010","MD=011","A=100","AM=101","AD=110","AMD=111"};
            HashMap <String,String> Dmap = new HashMap <String,String>();
            for (int i=0 ; i< dest.length;i++)
        {
            String x = dest[i].split("=")[0];
            String y = dest[i].split("=")[1];
            Dmap.put(x, y);
        }
          return Dmap.get(a);
          

        }


        //Function for the jump Hashmap
        public String Jvalue( String a )
        {
            String[] jmp = new String[]{"null=000","JGT=001","JEQ=010","JGE=011","JLT=100","JNE=101","JLE=110","JMP=111"};
            HashMap <String,String> Jmap = new HashMap <String,String>();
            for (int i=0 ; i< jmp.length;i++)
        {
            String x = jmp[i].split("=")[0];
            String y = jmp[i].split("=")[1];
            Jmap.put(x, y);
        }
          return Jmap.get(a);

        }

        };






