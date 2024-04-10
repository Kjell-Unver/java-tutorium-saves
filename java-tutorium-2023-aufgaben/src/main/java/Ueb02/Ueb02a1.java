package Ueb02;
import java.util.Scanner;









public class Ueb02a1 {




public static int AnswerVerifier(int x) {
        if(x==121)
        {return(121);}

        else if (x==89)
        {return(121);}

        else if (x==110)
        {return(110);}

        else if (x==78)
        {return(110);}

        else
        {System.out.print("Deine Antwort entspricht nicht der Vorgabe!!");
        return 0;
        }}



public static void main(String[] args) {

        String clear = "\033\143";

        // write your own code here
        Scanner input = new Scanner (System.in);

        System.out.print("Möchtest du etwas in Hamburg machen? (y/n) \n");
        System.out.print("--------------------- \n");

        int AnswerHam = (int) input.next().charAt(0);
        System.out.print(clear);

        System.out.print("\n Möchtest du etwas mit Tieren machen? (y/n) \n");
        System.out.print("--------------------- \n");

        int AnswerAnim = (int) input.next().charAt(0);
        System.out.print(clear);


//        System.out.print(AnswerHam+"\n");
//        System.out.print(AnswerAnim+"\n");
//        System.out.print(AnswerHam+"\n");

        System.out.print("--------------------------------------------- \n");



// Clean Answer is the Answer Char as the number

        int CleanAnswerHam = AnswerVerifier(AnswerHam);
        System.out.print(CleanAnswerHam+"\n");


        int CleanAnswerAnim = AnswerVerifier(AnswerAnim);
        System.out.print(CleanAnswerAnim+"\n");


        //AnswerVerifier(10);








        //y = 121
        //Y = 89
        //
        //x = 110
        //X =78

        // ||












    }


    // So viele "if" Schleifen sind nicht schön aber alle anderen Ansätze sind bei mir gescheitert!
}
