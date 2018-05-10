package ch.hearc.st.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GrilleADFGVX {

  private String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
  private String example = "c1ofwjymt5b4i7a28sp30qhxkeul6dvrgzn9";

  String[] lettres = {"A", "D", "F", "G", "V", "X"};

  private Map<Character, String> grille;
  private Map<String, Character> grilleInversee;

  public GrilleADFGVX() {

    this.grille = new HashMap<>();
    this.grilleInversee = new HashMap<>();

  }

  public void creer(Boolean random) {

    LinkedList<Character> chars = new LinkedList<>();

    if (random) {
      for (Character c : alphabet.toCharArray()) {
        chars.add(c);
      }
      Collections.shuffle(chars);
    } else {
      for (Character c : example.toCharArray()) {
        chars.add(c);
      }
    }
    for (String ligne : lettres) {
      for (String colonne : lettres) {
        this.grille.put(chars.getFirst(), ligne + colonne);
        this.grilleInversee.put(ligne + colonne, chars.pop());
      }
    }
  }

  public String print() {

    StringBuilder sb = new StringBuilder();
    sb.append("   ");
    for (String colonne : lettres) {
      sb.append(colonne).append("  ");
    }
    sb.append("\n");
    for (String ligne : lettres) {
      sb.append(ligne).append("  ");
      for (String colonne : lettres) {
        grille.get(ligne + colonne);
        sb.append(grilleInversee.get(ligne + colonne)).append("  ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public String chiffrer(String message) {

    StringBuilder sb = new StringBuilder();

    for (Character c : message.toCharArray()) {
      sb.append(grille.get(c));
    }

    return sb.toString();
  }

  public String dechiffrer(String message) {

    StringBuilder sb = new StringBuilder();

    int i = 1;
    String couple = "";

    for (Character c : message.toCharArray()) {
      if (i % 2 == 0) {
        couple = couple + c.toString();
        sb.append(grilleInversee.get(couple));
        couple = "";
      } else {
        couple = c.toString();
      }
      i++;
    }
    return sb.toString();
  }

}
