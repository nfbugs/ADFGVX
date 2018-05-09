package ch.hearc.st.app;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

    String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
    String example = "c1ofwjymt5b4i7a28sp30qhxkeul6dvrgzn9";

    /**
    LinkedList<Character> chars = new LinkedList<>();
    for(Character c : alphabet.toCharArray()) {
      chars.add(c);
    }
    Collections.shuffle(chars);
    **/

    LinkedList<Character> chars = new LinkedList<>();
    for(Character c : example.toCharArray()) {
      chars.add(c);
    }

  Map<Character, String> carte = new HashMap<>();
  Map<String, Character> carteInversee = new HashMap<>();

  String[] m = {"A","D","F","G","V","X"};
  for(String ligne : m){
    for(String colonne : m) {
      carte.put(chars.getFirst(), ligne+colonne);
      carteInversee.put(ligne+colonne, chars.pop());
    }
  }

  String messageClair = "objectifarras15hobjectifarras15h";
    System.out.println(messageClair);

  StringBuilder sb = new StringBuilder();
    for(Character c : messageClair.toCharArray()) {
      sb.append(carte.get(c));
    }
  String messageChiffre = sb.toString();
    System.out.println(messageChiffre);

    //print
    sb = new StringBuilder();
    sb.append("   ");
    for(String colonne : m){
      sb.append(colonne).append("  ");
    }
    System.out.println(sb.toString());
    for(String ligne : m){
      sb = new StringBuilder();
      sb.append(ligne).append("  ");
      for(String colonne : m) {
        carteInversee.get(ligne+colonne);
        sb.append(carteInversee.get(ligne+colonne)).append("  ");
      }
      System.out.println(sb.toString());
    }



    String code = "DEMAIN";



    int ii = 0;
    int jj = 0;
    for(Character c : messageChiffre.toCharArray()) {
      jj++;
      if(jj==code.length()){
        jj=0;
        ii++;
      }
    }

    int len = ii+1;

    //générer grille 1
    String[][] grille = new String[len][code.length()];
    int i = 0;
    int j = 0;


    /**
    for(Character c : messageChiffre.toCharArray()) {

      grille[i][j] = c.toString();
      j++;

      if(j==code.length()){
        j=0;
        i++;
      }

    }**/


    int count = 0;

    for(i=0;i<grille.length;i++){

      for(j=0;j<grille[i].length;j++){
        if(count<messageChiffre.length()) {
          Character cc = messageChiffre.charAt(count);
          grille[i][j] = cc.toString();
        }else{
          grille[i][j] = "";
        }
        count++;
      }

    }


    System.out.println("grille1");
    for(i=0;i<grille.length;i++){
      sb = new StringBuilder();
      for(j=0;j<grille[i].length;j++){
        sb.append(grille[i][j]).append(" ");
      }
      System.out.println(sb.toString());
    }



  }

}
