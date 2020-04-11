package pessoaDoente;

import pessoa.Pessoa;
import virus.Virus;

/**
 * Classe para objetos do tipo Pessoa Doente, onde serão contidos atributos e
 * métodos para o mesmo. Tal classe possui uma relação com a superclasse
 * abstrata Pessoa e, além disso, apresenta uma agregação para com a classe
 * Virus
 *
 * @author Antonio Gustavo Muniz (22.119.001 - 0)
 * @version 1.0
 * @see Virus
 * @see Pessoa
 */
public class PessoaDoente extends Pessoa {

    public Virus virus;

    /**
     * Método construtor: o objeto do tipo PessoaDoente irá iniciar sem
     * atributos definidos
     */
    public PessoaDoente() {
    }

    /**
     * Método construtor: o objeto do tipo PessoaDoente irá iniciar com
     * atributos definidos, sendo eles herdados da classe abstrata Pessoa, com
     * exceção do atributo virus, que é originado da relação com a classe Virus
     *
     * @param virus - Objeto Virus criado para essa PessoaDoente
     * @param x - Posição x na matriz mundo
     * @param y - Posição y na matriz mundo
     * @param cor - Número que representa a cor que o objeto terá na matriz
     * mundo
     */
    public PessoaDoente(Virus virus, int x, int y, int cor) {
        super(x, y, cor);
        this.virus = virus;
    }

    /**
     * Método para retorno do atributo virus da PessoaDoente
     *
     * @return Virus - Objeto Virus criado no instante de criação da
     * PessoaDoente
     */
    public Virus getVirus() {
        return virus;
    }

    /**
     * Método para atribuir novo objeto ao atributo virus da PessoaDoente
     *
     * @param virus - Novo objeto Virus
     */
    public void setVirus(Virus virus) {
        this.virus = virus;
    }

}
