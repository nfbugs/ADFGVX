package ch.hearc.st.app;

import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    GrilleADFGVX grilleADFGVX = new GrilleADFGVX();
    System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    System.out.println("PREPARATION POUR LE CHIFFREMENT");
    System.out.println();
    System.out.println("Message à chiffrer :");
    String message = scanner.nextLine();

    grilleADFGVX.creer(false);
    System.out.println("---Grille ADFGVX---");
    System.out.println(grilleADFGVX.print());
    System.out.println("-------------------");
    System.out.println();
    System.out.println("Ceci est une grille ADFGVX généré de manière aléatoire");
    System.out.println();


    String messageAvantPermutation = grilleADFGVX.chiffrer(message.toLowerCase());
    System.out.println("Message chiffré avant permutation : ");
    System.out.println(messageAvantPermutation);
    System.out.println();

    System.out.println("Code :");
    String code = scanner.nextLine();

    System.out.println("Grille 1");
    String[][] grille1 = Utils.generer(code, messageAvantPermutation);
    System.out.println(Utils.print(grille1));
    System.out.println();

    System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    System.out.println("CHIFFREMENT");
    System.out.println();
    System.out.println("Le message chiffré a été placé dans une grille, chaque lettre dans une "
        + "case. Le nombre de colonne est défini par la longeur du code, soit dans notre exemple : "
        + code.length());
    System.out.println();

    String codeOrd = Utils.motPermutation(alphabet, code);
    String permutation = Utils.indicePermutation(alphabet, code);
    System.out.println("La grille va alors être permuté selon l'arrangement des lettres du code "
        + "par ordre alphabétique");
    System.out.println("Les colonnes ont permutées comme le code qui est passé de " + code +
        " à " + codeOrd + " selon le code de permutation " + permutation);
    System.out
        .println("Pour notre code " + code + " la lettre " + codeOrd.charAt(0) + " devra passé de "
            + "la colonne " + permutation.charAt(0) + " à la colonne 1");
    System.out.println();


    System.out.println("Grille 2");
    String[][] grille2 = Utils.permuter(grille1, permutation, messageAvantPermutation);
    System.out.println(Utils.print(grille2));
    System.out.println();

    System.out.println("Le message a donc été chiffré et il suffit de reprendre les lettres"
        + " une par une ");
    System.out.println("Message chiffré :");
    String messageChiffreCrypte = Utils.lirecol(grille2);
    System.out.println(messageChiffreCrypte);

    messageChiffreCrypte = messageChiffreCrypte.replaceAll(" ", "");
    System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    System.out.println("DECHIFFREMENT");
    System.out.println();

    String newpermutation = Utils.indicePermutation(code, codeOrd);

    System.out.println("La première étape est de remettre les colonne dans le bon ordre");
    System.out.println("Il faudra faire la permutation de " + codeOrd + " pour arriver à " + code);
    System.out
        .println("Les colonnes sont permutées selon le code de permutation " + newpermutation);

    System.out.println();
    System.out.println("Grille 3");

    String[][] grille3 = Utils.permuter(grille2, newpermutation,
        messageChiffreCrypte);

    System.out.println(Utils.print(grille3));
    System.out.println();
    System.out.println("La grille contient les éléments dans le bon ordre, il suffit maintenant "
        + "de reprendre les lettres de grille afin de dechiffrer le message");

    String messageDechiffreCrypte = Utils.lirelig(grille3);
    System.out.println(messageDechiffreCrypte);
    messageDechiffreCrypte = messageDechiffreCrypte.replaceAll(" ", "");
    String messageDechiffre = grilleADFGVX.dechiffrer(messageDechiffreCrypte);

    System.out.println("Message déchiffré :");
    System.out.println(messageDechiffre);

  }

}
