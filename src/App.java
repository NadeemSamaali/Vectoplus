import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class App {

    public static class Vector
    {
        //Creating private doubles of length and angle
        private double length = 0;
        private double angle = 0;

        //Creating doubles for components A and B
        double A;
        double B;

        //Method setting the value of length
        public void setLength(double LENGTH){
            this.length = LENGTH;
        }

        //Method setting the value of angle
        public void setAngle(double ANGLE){
            this.angle = ANGLE;
        }
            
        //Method returning the value of the horizontal component of the vector
        public double getComponentA(){
            A = Math.cos(angle) * length;
            return A;
        }

        //Method returning the value of the vertical component of the vector
        public double getComponentB(){
            B = Math.sin(angle) * length;
            return B;
        }
    }

    /**
     * Class containing the caractersitics of a vector
     * @author Nadeem Imam Samaali
     * @version 1.0
     */
        
    static String ans1 = "";
    static String ans2 = "";

    //Method that will reset the answer inputs
    public static void resetAnswers()
    {
        ans1 = "";
        ans2 = "";
    }

    public static void main(String[] args)
    {
        //Welcome message
        System.out.println("=========================================");
        System.out.println("Welcome to vectoplus by Nadeem I. Samaali");
        System.out.println("=========================================");

        //Inputing the amount of vectors to create
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println(">>Insert amount of vectors to create : " + ans1);
        ans1 = input.nextLine();
        int num = Integer.parseInt(ans1);

        //Creating the vectors
        Vector[] vector = new Vector[num];

        //Inputting length and angle of each vector
        for(int i = 0; i < num; i++){
            resetAnswers();
            vector[i] = new Vector();
            System.out.println();
            System.out.println("#Vector " + (i + 1) + " :");

            //Setting length of vector
            System.out.print(".Length :" + ans1);
            ans1 = input.nextLine();
            vector[i].setLength(Double.parseDouble(ans1));

            //Setting angle of vector in radiants
            System.out.print(".Angle :" + ans2);
            ans2 = input.nextLine();
            vector[i].setAngle((Double.parseDouble(ans2)*Math.PI)/180);
        }

        double sumA = 0;
        double sumB = 0;

        //Calculating the sum of A and B components
        for(int j = 0; j < num; j++){
            sumA = vector[j].getComponentA() + sumA;
            sumB = vector[j].getComponentB() + sumB;
        }

        //Generating decimal format
        DecimalFormat df = new DecimalFormat("0.000");

        //Calculating the length of resulting vector
        double rLength = Math.sqrt(Math.pow(sumA, 2) + Math.pow(sumB, 2));

        //Calculating the angle of the resulting vector
        double rAngle;
        if(Math.round(rLength) == 0){
            rAngle = 0;
        }else{
            rAngle = Math.abs((Math.atan(sumB/sumA)*180)/Math.PI);
        }

        if(sumA < 0 && sumB > 0 && Math.round(rLength) > 0)
            rAngle = 180 - rAngle;
        if(sumA < 0 && sumB < 0 && Math.round(rLength) > 0)
            rAngle = 180 + rAngle;
        if(sumA > 0 && sumB < 0 && Math.round(rLength) > 0)
            rAngle = 360 - rAngle;

        //Printing results
        System.out.println();
        System.out.println("# # # Resulting component data # # #");
        System.out.println("\n> Components : \n  A : " + df.format(Math.abs(sumA)) + "\n  B : " + df.format(Math.abs(sumB)));
        System.out.println("> Length = " + df.format(rLength) + " u");
        System.out.println("> Angle = " + df.format(rAngle) + " deg");
        System.out.println();
    }
}