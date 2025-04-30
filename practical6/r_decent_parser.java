public class r_decent_parser{
    static int count = 0;
    static int bracket = 0;

    public static boolean  S(String input,String grammar[][],int len) {
        if(count<len && input.charAt(count)==grammar[0][1].charAt(0)){
            count++;
            bracket++;

            if(L(input,grammar,len))
            {
                if(count<len && input.charAt(count)==grammar[0][1].charAt(2))
                {
                    count++;
                    bracket--;
                    if(bracket==0 && count<len)
                    {
                        return false;
                    }
                    return true;
                }
            }
        }
        else if(count<len && input.charAt(count)==grammar[0][2].charAt(0))
            {
                count++;
                if(count==1 && len>1)
                {
                    return false;
                }
                return true;
            }
        return false;
        
    }

    public static boolean L(String input,String grammar[][],int len)
    {
        if(S(input,grammar,len))
        {
            if(M(input,grammar,len))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean M(String input,String grammar[][],int len)
    {
        if(count<len && input.charAt(count)==grammar[2][1].charAt(0))
        {
            count++;
            if(S(input,grammar,len))
            {
                if(M(input,grammar,len))
                {
                    return true;
                }
            }
        }
        else 
        {
            //count++;
            return true;
        }
        return false;
    }
    public static void main(String []args)
    {
        String grammar[][] = {
            {"S","(L)","a"},
            {"L","SM",""},
            {"M",",SM","@"}
        };

            String input = "(a,a),a";
            int len = input.length();

            System.out.print(S(input,grammar,len));
        
    }
}
