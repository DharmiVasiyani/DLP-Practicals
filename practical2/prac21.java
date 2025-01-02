//FA => 0 followed by 11

import java.util.Scanner;

public class prac21 {
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=2;
    int states = 5;
    int is = 1;
    int rs = is;
    int as = 4;
    int c;

    System.out.println("Enter a String : ");
    String str = sc.nextLine();

    int arr[][] = {
                    {2,5},
                    {5,3},
                    {5,4},
                    {2,4},
                    {5,5}
    };

    for(int i=0; i<str.length(); i++){
        char ch = str.charAt(i);
        if(ch =='0'){
            c = 0;
        }else if(ch == '1'){
            c = 1;
        }else{
            System.out.println("Invalid string");
            return;
        }

        rs = arr[rs-1][c];
    }

    if(rs == 4){
        System.out.println("Valid String");
    }else{
        System.out.println("Invalid String");
    }

}
}