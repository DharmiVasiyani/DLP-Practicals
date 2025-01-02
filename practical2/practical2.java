import java.util.Scanner;

public class practical2
{
public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=2;
    int states = 4;
    int initial = 1;
    int temp = initial;
    int fin = 2;
    int x;

    System.out.println("Enter a String : ");
    String str = sc.nextLine();

    int arr[][] = {
                    {2,3},
                    {1,4},
                    {4,1},
                    {3,2}
    };

    for(int i=0; i<str.length(); i++){
        char ch = str.charAt(i);
        if(ch =='a'){
            x = 0;
        }else if(ch == 'b'){
            x = 1;
        }else{
            System.out.println("Invalid string");
            return;
        }

        temp = arr[temp-1][x];
    }

    if(temp == 2){
        System.out.println("Valid String");
    }else{
        System.out.println("Invalid String");
}

}
}
