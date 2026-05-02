import java.util.Scanner;

public class PremierProgramme {
    public static void main(String[] args) {

        double rayon, prmt, surf;

        Scanner s = new Scanner(System.in);

        System.out.println("Quel est le rayon de votre cercle ?");
        rayon = s.nextDouble();

        prmt = 2 * rayon * Math.PI;
        surf = rayon * rayon * Math.PI;

        System.out.println(
            "Le perimetre est " + prmt +
            " et la surface est " + surf
        );
    }
}
package TP1;

import java.util.Scanner;

public class PremierProgramme {

    public static void main(String[] args) {

        double rayon, prmt, surf;

        Scanner s = new Scanner(System.in);

        System.out.println("Quel est le rayon de votre cercle ?");

        rayon = s.nextDouble();

        prmt = 2 * rayon * Math.PI;
        surf = rayon * rayon * Math.PI;

        System.out.println("Le perimetre est de " + prmt 
                           + " et la surface est de " + surf);
    }
}