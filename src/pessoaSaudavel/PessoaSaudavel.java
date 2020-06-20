package pessoaSaudavel;

import pessoa.Pessoa;

/**
 * Classe para objetos do tipo Pessoa Saudavel, onde serão contidos atributos e
 * métodos para o mesmo. Tal classe possui uma relação com a superclasse
 * abstrata Pessoa
 *
 * @author Antonio Gustavo Muniz (22.119.001 - 0)
 * @version 1.0
 * @see Pessoa
 */
public class PessoaSaudavel extends Pessoa {

    /**
     * Método construtor: o objeto do tipo PessoaSaudavel irá iniciar sem
     * atributos definidos
     */
    public PessoaSaudavel() {
    }

    /**
     * Método construtor: o objeto do tipo PessoaSaudavel irá iniciar com
     * atributos definidos, sendo eles herdados da classe abstrata Pessoa
     *
     * @param x - Posição x na matriz mundo
     * @param y - Posição y na matriz mundo
     * @param cor - Número que representa a cor que o objeto terá na matriz
     * mundo
     */
    public PessoaSaudavel(int x, int y, int cor) {
        super(x, y, cor);
    }
}
