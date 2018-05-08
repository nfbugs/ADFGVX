package ch.hearc.st.app;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

  LinkedList<Character> chars = new LinkedList<>();

  for(int i = 97;i<=122;i++){
    chars.add(Character.valueOf((char)i));
  }
  for(int i = 48;i<=57;i++){
    chars.add(Character.valueOf((char)i));
  }

  Collections.shuffle(chars);

  Map<Character, String> map = new HashMap<>();

  BiMap<Character, String> myBiMap = HashBiMap.create();

  String[] m = {"A","D","F","G","V","X"};
  for(String s1 : m){
    for(String s2 : m) {
      myBiMap.put(chars.pop(), s1+s2);
    }
  }

  BiMap<String, Character> myBiMapInversed = myBiMap.inverse();

  String texte = "objectifarras15h28";
    System.out.println(texte);

  StringBuilder sb = new StringBuilder();
    for(Character c : texte.toCharArray()) {
      sb.append(myBiMap.get(c));
    }

    System.out.println(sb.toString());

    String textec = sb.toString();


    String code = "MARCEL";


    String[][] matrice = new String[6][6];
    for(int i = 0; i < matrice.length; i++){
      matrice[i] = new String[6];
    }
    int count = 0;
    for(int i = 0; i < matrice.length; i++){
      for(int j = 0; j < matrice[i].length; j++){
        // On appelle la méthode nextInt() de l'objet scanner, qui retourne l'entier que l'on frappe au clavier.
        Character ce = textec.charAt(count);
        count++;
        matrice[i][j] = ce.toString();
      }
    }
    System.out.println("matrice 1");
    for(int i = 0; i < matrice.length; i++) {
      for (int j = 0; j < matrice[i].length; j++) {
        System.out.print(matrice[i][j] + " ");
      }
      System.out.println();
    }
      ArrayList <Integer> l = new ArrayList<>();
      l.add(1);
      l.add(3);
      l.add(4);
      l.add(5);
      l.add(0);
      l.add(2);
      int index=0;
      int colMatrice2;
      int colMatrice1= 0;
      String[][] matrice2 = new String[6][6];
      for(int iz = 0; iz < matrice2.length; iz++){
        matrice2[iz] = new String[6];
      }
      do{

        colMatrice2 = l.get(index);
        for(int jr = 0; jr < l.size(); jr++) {
          matrice2[jr][colMatrice2] = matrice[jr][colMatrice1];

        }
        colMatrice1++;
        index++;

        } while (colMatrice1<=l.size()-1);
    System.out.println("matrice 2");
      for(int ic = 0; ic < matrice2.length; ic++){
        for(int jc = 0; jc < matrice2[ic].length; jc++){
          System.out.print(matrice2[ic][jc] + " ");
        }
        System.out.println("");
      }



      }








  }


