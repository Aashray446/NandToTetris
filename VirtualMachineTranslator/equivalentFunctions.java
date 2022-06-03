public class equivalentFunctions {

    public String ch_local(String arr[]){

        StringBuilder sb = new StringBuilder();

        sb.append("@"+arr[2]+"\n");
        sb.append("D=A\n");

        if(arr[1].equals("local")){
            sb.append("@LCL\n"); 
        }
        else if(arr[1].equals("argument")){
            sb.append("@ARG\n");
        }
        else if(arr[1].equals("this")){
            sb.append("@THIS\n");
        }
        else if(arr[1].equals("that")){
            sb.append("@THAT\n");
        }
        else if(arr[1].equals("temp")){
            sb.append("@5");
        }
        if(arr[0].equals("push")){

            sb.append("D=D+M\n");
            sb.append("A=D\n");
            sb.append("D=M\n");
            sb.append("@SP\n");
            sb.append("A=M\n");
            sb.append("M=D\n");
            sb.append("@SP\n");
            sb.append("M=M+1\n");

        }

        else if(arr[0].equals("push")){
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
    public String ch_constant(String[] parsed){
        StringBuilder sb = new StringBuilder();
        //*sp=i
        //sp++
        String i = parsed[2];
        sb.append("@"+i+"\n");
        sb.append("D=A"+"\n");
        sb.append("@SP"+"\n");
        sb.append("A=M"+"\n");
        sb.append("M=D"+"\n");
        sb.append("@SP"+"\n");
        sb.append("M=M+1"+"\n");

        return sb.toString();
        
    }

    public String ch_pointer(String[] parsed){
        StringBuilder sb = new StringBuilder();
        if(parsed[2].equals("0")){
            //sp--
            //*THIS= *sp
            sb.append("@SP"+"\n");
            sb.append("AM=M-1"+"\n");
            sb.append("D+M"+"\n");
            sb.append("@THIS"+"\n");
            sb.append("M=D"+"\n");

        }
        if(parsed[2].equals("1")){
            //sp--
            //*THAT= *sp
            sb.append("@SP"+"\n");
            sb.append("AM=M-1"+"\n");
            sb.append("D+M"+"\n");
            sb.append("@THAT"+"\n");
            sb.append("M=D"+"\n");

        }
        return sb.toString();
    }

    public String ch_static(String[] parsed,String filename){
        StringBuilder sb = new StringBuilder();
        if(parsed[0].equals("push")){
            sb.append("@"+filename+"."+parsed[2]+"\n");
            sb.append("D=M\n");
            sb.append("@SP\n");
            sb.append("A=M\n");
            sb.append("M=D\n");
            sb.append("@SP\n");
            sb.append("M=M+1\n");
        }
        if(parsed[0].equals("pop")){
            sb.append("@SP\n");
            sb.append("AM=M-1\n");
            sb.append("D=M\n");
            sb.append("@"+filename+"."+parsed[2]+"\n");
            sb.append("M=D\n");
        }
        return sb.toString();
    }
    

    public String ch_add_sub(String arr[]){

        StringBuilder sb = new StringBuilder();
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        if(arr[0].equals("add")){
            sb.append("M=M+D\n");
        }
        else if (arr[0].equals("sub")){
            sb.append("M=M-D\n");
        }
        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }

    

}
