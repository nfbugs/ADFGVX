package ch.hearc.st.app;

import java.util.ArrayList;

public class Utils {

  public Utils() {
  }

  public static String[][] generer(String code, String messageChiffre) {

    int taillelig = (int) Math.ceil(messageChiffre.length() / code.length());
    int taillecol = code.length();

    String[][] grille = new String[taillelig+1][taillecol];

    int i = 0;
    int j = 0;
    int count = 0;

    for (i = 0; i < grille.length; i++) {

      for (j = 0; j < grille[i].length; j++) {
        if (count < messageChiffre.length()) {
          Character cc = messageChiffre.charAt(count);
          grille[i][j] = cc.toString();
        } else {
          grille[i][j] = "";
        }
        count++;
      }

    }
    return grille;
  }

  public static String calculPermutation(String code){

    String permutation = "2,4,5,6,1,3";

    //TODO:générer code permutation selon code (exemple DEMAIN)

    return permutation;

  }

  public static String[][] permuter(String[][] grille, String permutation, String messageAvantPermutation){
    ArrayList<Integer> l = new ArrayList<>();
    l.add(1);
    l.add(3);
    l.add(4);
    l.add(5);
    l.add(0);
    l.add(2);
    //A effacer après implémentation calculPermutation

    int taillelig = (int) Math.ceil(messageAvantPermutation.length() / l.size());
    int taillecol = l.size();
    String[][] grillePermute= new String [taillelig+1][taillecol];
    int colGrillePermutation;
    int indexPermutation = 0;
    int colGrille = 0;

    do{

      colGrillePermutation = l.get(indexPermutation);

      for(int j = 0; j <= taillelig; j++) {
        grillePermute[j][colGrillePermutation] = grille[j][colGrille];

      }
      colGrille++;
      indexPermutation++;

    } while (colGrille<=l.size()-1);

    return grillePermute;

  }

  public static String lire(String[][] grille){
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;
    int count = 1;
    for(i=0;i<grille.length;i++){
      for(j=0;j<grille[i].length;j++){
        sb.append(grille[i][j]).append("");
        if(count%5==0){
          sb.append(" ");
        }
        count++;
      }
    }
    return sb.toString();
  }

  public static String print(String[][] grille){
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;
    for(i=0;i<grille.length;i++){
      for(j=0;j<grille[i].length;j++){
        sb.append(grille[i][j]).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }



}
