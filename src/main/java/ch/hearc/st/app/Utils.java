package ch.hearc.st.app;

import java.util.ArrayList;

public class Utils {

  public Utils() {
  }

  public static String[][] generer(String code, String messageChiffre) {

    Double d1 = Double.parseDouble(String.valueOf(messageChiffre.length()));
    Double d2 = Double.parseDouble(String.valueOf(code.length()));
    int taillelig = (int) Math.ceil(d1/d2);
    System.out.println(taillelig);
    int taillecol = code.length();

    String[][] grille = new String[taillelig][taillecol];

    int i = 0;
    int j = 0;
    int count = 0;

    for (i = 0; i < grille.length; i++) {

      for (j = 0; j < grille[i].length; j++) {
        if (count < messageChiffre.length()) {
          Character cc = messageChiffre.charAt(count);
          grille[i][j] = cc.toString();
        } else {
          grille[i][j] = "X";
        }
        count++;
      }

    }
    return grille;
  }


  public static String[][] permuter(String[][] grille, String permutation) {
    String[] split = permutation.split(",");
    ArrayList<Integer> l = new ArrayList<>();
    for(String s : split){
      l.add(Integer.parseInt(s));
    }

    String[][] grillePermute= new String[grille.length][grille[0].length];

    for(int i = 0;i<grille.length;i++){
      for(int j = 0;j<grille[i].length;j++){
        grillePermute[i][l.indexOf(j+1)] = grille[i][j];
      }
    }

    return grillePermute;

  }

  public static String lirecol(String[][] grille) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;
    int count = 0;
    for (j = 0; j < grille[0].length; j++){
      for (i = 0; i < grille.length; i++) {
        if(!grille[i][j].equals("")) {
          count++;
          sb.append(grille[i][j]);
          if(count%5==0){
            sb.append(" ");
          }
        }
      }
    }
    return sb.toString();
  }

  public static String lirelig(String[][] grille){
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;
    int count = 1;
    for(i=0;i<grille.length;i++){
      for(j=0;j<grille[i].length;j++){
        sb.append(grille[i][j]);
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
    int i;
    int j;
    for(i=0;i<grille.length;i++){
      for(j=0;j<grille[i].length;j++){
        sb.append(grille[i][j]).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  private static int[] tabIndicesPermutation(String reference, String code) {
    int[] tab = new int[code.length()];
    code = code.toUpperCase();
    reference = reference.toUpperCase();
    int nbiter = code.length();
    int k = 0;

    for (int m = 0; m < nbiter; m++) {
      int rang = 1000;
      for (int n = 0; n < nbiter; n++) {
        char ch = code.charAt(n);
        if (reference.indexOf(ch) < rang) {
          int j = n + 1;
          boolean ok = true;
          for (int r = 0; r < m; r++) {
            ok = ok && (j != tab[r]);
          }
          if (ok) {
            rang = reference.indexOf(ch);
            k = j;
          }
        }
      }
      tab[m] = k;
    }

    return tab;
  }

  private static String getMotPermutation(int[] tab, String code) {
    StringBuilder codeOrd = new StringBuilder();
    Integer index = 0;
    do {
      codeOrd.append(code.charAt((tab[index] - 1)));
      index++;
    } while (index < tab.length);

    return codeOrd.toString();
  }

  private static String getIndicePermutation(int[] tab) {
    StringBuilder perm = new StringBuilder();
    int nbiter = tab.length;

    for (int m = 0; m < nbiter; m++) {
      perm.append(tab[m]);
      if (m < nbiter - 1) {
        perm.append(",");
      }
    }

    return perm.toString();
  }

  public static String indicePermutation(String reference, String code) {
    int index[] = tabIndicesPermutation(reference, code);

    return getIndicePermutation(index);


  }

  public static String motPermutation(String reference, String code) {
    int index[] = tabIndicesPermutation(reference, code);

    return getMotPermutation(index, code);


  }
}


