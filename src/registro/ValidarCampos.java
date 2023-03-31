import java.util.Random;
import java.util.Scanner;

public class ValidarCampos {
	
	private String nombreUsuario;
	private String email;
	private String password;

  public static boolean validarCampos(
    String nombreUsuario,
    String email,
    String password
  ) {
    if (nombreUsuario.length() > 16) {
      System.out.println("el nombre no puede tener mas de 16 carácteres"); // ok
      return false;
    }
    if (!Character.isUpperCase(nombreUsuario.charAt(0))) { // ok
      System.out.println("el nombre tiene que empezar por mayúsculas");
      return false;
    }
    for (int i = 1; i < nombreUsuario.length() - 4; i++) {
      if (Character.isUpperCase(nombreUsuario.charAt(i))) {
        System.out.println("solo la primera letra del nombre en mayúsculas"); // ok
        return false;
      }
    }
    if (
      nombreUsuario.charAt(nombreUsuario.length() - 4) != '_' && // ok
      nombreUsuario.charAt(nombreUsuario.length() - 4) != '-'
    ) {
      System.out.println(
        "Falta el guión o no esta en la cuarta posicion contando desde el final"
      );
      return false;
    }
    for (int i = nombreUsuario.length() - 3; i < nombreUsuario.length(); i++) { // ok
      if (!Character.isDigit(nombreUsuario.charAt(i))) {
        System.out.println("El nombre tiene que terminar con tres dígitos");
        return false;
      }
    }
    String[] dominiosPermitidos = {
      "paucasesnovescifp",
      "yahoo",
      "gmail",
      "hotmail",
    };
    boolean dominioValido = false;
    if (!email.contains("@")) {
      System.out.println("falta @"); // ok
      return false;
    }

    for (String dominio : dominiosPermitidos) {
      if (email.contains("@" + dominio)) {
        dominioValido = true; // ok
        break;
      }
    }
    if (!dominioValido) {
      System.out.println("error dominio");
      return false; // ok
    }

    if (
      !(
        email.endsWith(".com") ||
        email.endsWith(".es") ||
        email.endsWith(".cat")
      )
    ) {
      System.out.println("error de extensión"); // ok
      return false;
    }
    if (password.length() != 8) {
      System.out.println("introduce password de 8 caracteres"); // ok
      return false;
    }
    if (!Character.isUpperCase(password.charAt(0))) {
      System.out.println("el password debe empezar con mayúsculas");
      return false; // OK
    }
    if (
      !(
        password.contains("@") ||
        password.contains("-") ||
        password.contains("#") ||
        password.contains("_")
      )
    ) {
      System.out.println("introduce uno de los siguientes símbolos @,#,-, _");
      return false; // ok
    }
    if (
      !Character.isDigit(password.charAt(password.length() - 1)) ||
      !Character.isDigit(password.charAt(password.length() - 2))
    ) {
      System.out.println("el password debe terminar en dos dígitos");
      return false; // ok
    }

    StringBuilder codigo = new StringBuilder();
    Random random = new Random();
    String caracteres =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#@-_";
    for (int i = 0; i < 8; i++) {
      int index = random.nextInt(caracteres.length());
      codigo.append(caracteres.charAt(index));
    }

    // Mostrar código de seguridad por pantalla
    System.out.println("El código de seguridad es: " + codigo);

    // Pedir al usuario que escriba el código de seguridad
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce el código de seguridad: ");
    String codigoUsuario = scanner.nextLine();
    scanner.close();

    // Comprobar si el código de seguridad introducido es correcto
    if (codigo.toString().equals(codigoUsuario)) {
      return true;
    } else {
      System.out.println("error");
      return false;
    }
  }
}
