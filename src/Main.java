import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Marina on 11.12.2015.
 */
public class Main {

    private static int n;
    private static double[] mass = new double[2*n];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter n = ");
        n = Integer.parseInt(br.readLine());
        mass = generateMass();
        out();
        for(int i=0; i<n; i++){
            mass[i] = mass[i] + mass[2*n - i-1];
        }
        out();
        double max = mass[0];
        for(int i=0; i<n; i++){
            if(max < mass[i])
                max = mass[i];
        }
        System.out.println("Max = " + max);
    }

    private static double[] generateMass(){
        Random rand = new Random();
        double[] mass = new double[2*n];
        for(int i=0; i<2*n; i++){
            mass[i] = rand.nextDouble()*50;
        }
        return mass;
    }

    private static void out(){
        for(int i=0; i<2*n; i++)
            System.out.print(Math.round(mass[i]*100)/100.0 + " ");
        System.out.println();
    }
}
