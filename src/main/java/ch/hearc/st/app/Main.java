package ch.hearc.st.app;

public class Main {

  public static void main(String[] args) {

  GrilleADFGVX g = new GrilleADFGVX();

  g.create(false);
  System.out.println(g.print());

  String message = "objectifarras15h";
  String messageChiffre = g.chiffrer(message);

    System.out.println(messageChiffre);

    System.out.println(g.dechiffrer(messageChiffre));


  }

}
