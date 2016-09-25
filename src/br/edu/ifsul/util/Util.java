
package br.edu.ifsul.util;


public class Util {

    public static String getMensagemErro(Exception e){
        while(e.getCause() != null){
            e = (Exception) e.getCause();
        }
        String retorno = e.getMessage();
        if (retorno.contains("viola restrição de chave estrangeira")){
            retorno = "Registro não pode ser excluido por possuir referência "
                    + "em outros objetos";
        }
        return retorno;
    }
}
