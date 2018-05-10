package ch.hearc.st.app;

public class Crypto {

  String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public String creerPermut(String motclef) {
    int[] tab = new int[motclef.length()];
    motclef = motclef.toUpperCase();
    String perm = "";
    int nbiter = motclef.length();
    int k = 0;

    for (int m = 0; m < nbiter; m++) {
      int rang = 1000;
      for (int n = 0; n < nbiter; n++) {
        char ch = motclef.charAt(n);
        if (alphabet.indexOf(ch) < rang) {
          int j = n + 1;
          boolean ok = true;
          for (int r = 0; r < m; r++) {
            ok = ok && (j != tab[r]);
          }
          if (ok) {
            rang = alphabet.indexOf(ch);
            k = j;
          }
        }
      }
      tab[m] = k;
    }
    for (int m = 0; m < nbiter; m++) {
      perm += tab[m];
      if (m < nbiter - 1) {
        perm += ",";
      }
    }
    return perm;
  }
}
