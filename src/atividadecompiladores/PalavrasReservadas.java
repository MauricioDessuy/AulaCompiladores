package atividadecompiladores;

import java.util.HashMap;

/**
 *
 * @author mauricio
 */
public enum PalavrasReservadas {
    SE("se"),
    ENTAO("entao"),
    PARA("para"),
    FACA("faca"),
    FIMSE("fimse"),
    LEFT_PARENTESES("("),
    RIGHT_PARENTESES(")"),
    MAIOR(">"),
    MENOR("<"),
    ENQUANTO("enquanto"),
    DOISPONTOS_IGUAL(":="),
    ESCREVA("escreva"),
    LEIA("leia");
    
    public String palavra;
    
    PalavrasReservadas(String palavra) {
        this.palavra = palavra;
    }
    
    public void adicionarPalavras(String codigo, HashMap<String, Integer> mapaPalavras) {
        String[] palavras = codigo.split(" ");
        for (String palavra : palavras) {
            for (PalavrasReservadas value : values()) {
                if (value.palavra.equals(palavra)) {
                    if (mapaPalavras.containsKey(value.palavra)) {
                        mapaPalavras.replace(value.palavra, mapaPalavras.get(value.palavra) + 1);
                    } else {
                        mapaPalavras.put(value.palavra, 1);
                    }
                }
            }
        }
    }
}
