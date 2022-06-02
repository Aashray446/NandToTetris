public class equivalentFunctions {

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
        if(parsed[2]=="0"){
            //sp--
            //*THIS= *sp
            sb.append("@SP"+"\n");
            sb.append("AM=M-1"+"\n");
            sb.append("D+M"+"\n");
            sb.append("@THIS"+"\n");
            sb.append("M=D"+"\n");

        }
        if(parsed[2]=="1"){
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
        if(parsed[0]=="push"){
            sb.append("@"+filename+"."+parsed[2]+"\n");
            sb.append("D=M\n");
            sb.append("@SP\n");
            sb.append("A=M\n");
            sb.append("M=D\n");
            sb.append("@SP\n");
            sb.append("M=M+1\n");
        }
        if(parsed[0]=="pop"){
            sb.append("@SP\n");
            sb.append("AM=M-1\n");
            sb.append("D=M\n");
            sb.append("@"+filename+"."+parsed[2]+"\n");
            sb.append("M=D");
        }
        return sb.toString();
    }
    
}
