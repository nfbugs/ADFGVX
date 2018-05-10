package ch.hearc.st.app;

import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    GrilleADFGVX grilleADFGVX = new GrilleADFGVX();

    System.out.println("Message à chiffrer :");
    String message = scanner.nextLine();

    grilleADFGVX.creer(false);
    System.out.println("---Grille ADFGVX---");
    System.out.println(grilleADFGVX.print());
    System.out.println("-------------------");
    System.out.println("");

    System.out.println("Message chiffré avant permutation : ");
    String messageAvantPermutation = grilleADFGVX.chiffrer(message.toLowerCase());
    System.out.println(messageAvantPermutation);
    System.out.println("");

    System.out.println("Code :");
    String code = scanner.nextLine();

    System.out.println("Grille 1");
    String[][] grille1 = Utils.generer(code, messageAvantPermutation);
    System.out.println(Utils.print(grille1));
    System.out.println("");

    String permutation = Utils.calculPermutation(code);
    System.out.println("Code permutation : " +permutation);
    System.out.println("");

    System.out.println("Grille 2");
    String[][] grille2 = Utils.permuter(grille1, permutation, messageAvantPermutation);
    System.out.println(Utils.print(grille2));
    System.out.println("");

    System.out.println("Message chiffré :");
    System.out.println(Utils.lire(grille2));

  }

}
