import java.util.Scanner;

public class prac22 {
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    // int n=3;
    // int states = 10;
    // int fstates = 3;
    int is = 1;
    int rs = is;
    // int as = 2 + 3 + 4;
    int c;

    System.out.println("Enter a String : ");
    String str = sc.nextLine();

    int arr[][] = {
                    {2,3,4},
                    {2,5,6},
                    {7,3,8},
                    {10,9,4},
                    {2,5,5},
                    {2,6,6},
                    {7,3,7},
                    {7,3,7},
                    {9,9,4},
                    {9,9,4}
    };

    for(int i=0; i<str.length(); i++){
        char ch = str.charAt(i);
        if(ch =='a'){
            c = 0;
        }else if(ch == 'b'){
            c = 1;
        }else if(ch == 'c'){
            c = 2;
        }
        else{
            System.out.println("Invalid string");
            return;
        }

        rs = arr[rs-1][c];
    }

    if(rs == 2 || rs ==3 || rs == 4){
        System.out.println("Valid String");
    }else{
        System.out.println("Invalid String");
    }

}
}