class UtilsString {
  //Completa o tamanho designado a string com texto em branco.
  static String completarTextoString(String texto, int tamanho,
      {String caracter = ' '}) {
    for (int i = texto.length; i <= tamanho; i++) {
      texto += caracter;
    }
    return texto;
  }

  static removerCaracter(String texto, String caracter) {
    for (int i = 0; i <= texto.length; i++) {}
  }
}
