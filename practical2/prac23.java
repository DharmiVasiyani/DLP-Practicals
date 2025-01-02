//FA => first character should be character

import java.util.Scanner;

public class prac23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    // int states = 3;
    // int fstates = 1;
    int is = 1; //initial state
    int rs = is; //running state
    // int as = 3 accepting sate
    int c;

    System.out.println("Enter a String : ");
    String str = sc.nextLine();

    int arr[][] = {//A,D
                    {3,2}, //1
                    {2,2}, //2
                    {3,3}, //3
    };

    for(int i=0; i<str.length(); i++){
        char ch = str.charAt(i);
        if((ch >='a' && ch<= 'z') || (ch >= 'A' && ch <= 'Z')){
            c = 0;
        }else if(ch >= '0' && ch <= '9'){
            c = 1;
        }
        else{
            System.out.println("Invalid string");
            return;
        }

        rs = arr[rs-1][c];
    }

    if(rs == 3){
        System.out.println("Valid String");
    }else{
        System.out.println("Invalid String");
    }
    }
}