package registro;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner teclat = new Scanner(System.in);
    String usuario;
    String correo;
    String password;
    boolean correcto;

    do {
      System.out.println("introduce nombre");
      usuario = teclat.next();
      System.out.println("introduce correo");
      correo = teclat.next();
      System.out.println("introduce password");
      password = teclat.next();
      correcto = ValidarCampos.validarCampos(usuario, correo, password);
    } while (!correcto);
    System.out.println(
      "usuario:" + usuario + " correo:" + correo + " password:" + password
    );
    System.out.println("El registro se ha realizado con éxito");
    teclat.close();
  }
}
