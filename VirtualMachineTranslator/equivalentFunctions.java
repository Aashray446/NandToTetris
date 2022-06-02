public class equivalentFunctions {

    public String lcl(String arr[]){

        StringBuilder sb = new StringBuilder();

        //for push
        //addr = segement(arr[1]) + i(arr[2])
        //*SP = *addr
        //SP++
        //for push
        //addr = segement(arr[1]) + i(arr[2])
        //SP++
        //*addr=*SP  

        
        sb.append("@"+arr[2]+"\n");
        sb.append("D=A");

        if(arr[1]=="local"){
            sb.append("@LCL\n"); 
        }
        else if(arr[1]=="argument"){
            sb.append("@ARG\n");
        }
        else if(arr[1]=="this"){
            sb.append("@THIS\n");
        }
        else if(arr[1]=="that"){
            sb.append("@THAT\n");
        }
        else if(arr[1]=="temp"){
            sb.append("@5");
        }
        if(arr[0]=="push"){

            sb.append("D=D+M\n");
            sb.append("A=D\n");
            sb.append("D=M\n");
            sb.append("@SP\n");
            sb.append("A=M\n");
            sb.append("M=D\n");
            sb.append("@SP\n");
            sb.append("M=M+1\n");

        }

        else if(arr[0]=="push"){
            sb.append("@R13\n");
            sb.append("M=D\n");
            sb.append("@SP\n");
            sb.append("AM=M-1\n");
            sb.append("D=M\n");
            sb.append("@R13\n");
            sb.append("A=M\n");
            sb.append("M=D\n");
        }


        return sb.toString();

    }
    
}
