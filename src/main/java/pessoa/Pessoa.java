package pessoa;

import java.util.Random;

/**
 * Classe abstrata para o tipo Pessoa, onde serão contidos atributos e métodos
 * para o mesmo
 *
 * @author Antonio Gustavo Muniz (22.119.001 - 0)
 * @version 1.0
 */
public abstract class Pessoa {

    private int x;
    private int y;
    private int cor;

    /**
     * Método construtor: o objeto do tipo Pessoa irá iniciar sem atributos
     * definidos
     */
    public Pessoa() {
    }

    /**
     * Método construtor: o objeto do tipo Pessoa irá iniciar com atributos
     * definidos
     *
     * @param x - Posição x na matriz mundo
     * @param y - Posição y na matriz mundo
     * @param cor - Número que representa a cor que o objeto terá na matriz
     * mundo
     */
    public Pessoa(int x, int y, int cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    /**
     * Método para retorno do atributo x da Pessoa
     *
     * @return int - Posição x na matriz mundo
     */
    public int getX() {
        return x;
    }

    /**
     * Método para atribuir novo valor ao atributo x da Pessoa
     *
     * @param x - Novo valor de X
     */
    public void setX(int x) {
        switch (x) {
            case 60:
                this.x = 0;
                break;
            case -1:
                this.x = 59;
                break;
            default:
                this.x = x;
                break;
        }
    }

    /**
     * Método para retorno do atributo y da Pessoa
     *
     * @return int - Posição y na matriz mundo
     */
    public int getY() {
        return y;
    }

    /**
     * Método para atribuir novo valor ao atributo y da Pessoa
     *
     * @param y - Novo valor de Y
     */
    public void setY(int y) {
        switch (y) {
            case 30:
                this.y = 0;
                break;
            case -1:
                this.y = 29;
                break;
            default:
                this.y = y;
                break;
        }
    }

    /**
     * Método para retorno do atributo cor da Pessoa
     *
     * @return int - Número que representa a cor que o objeto terá na matriz
     * mundo
     */
    public int getCor() {
        return cor;
    }

    /**
     * Método para atribuir novo valor ao atributo cor da Pessoa
     *
     * @param cor - Novo valor de cor
     */
    public void setCor(int cor) {
        this.cor = cor;
    }

    /**
     * Método para mover de forma aleatória. Baseia-se num switch case para
     * escolher uma das quatro opções de movimento: cima, baixo, esquerda e
     * direita. O objeto se move com passo um e ao chegar a um extremo da
     * matriz, volta ao extremo oposto. Como é um método inerente a qualquer
     * tipo de pessoa foi declarado na superclasse Pessoa.
     */
    public void mover() {
        Random random = new Random();
        int opcao = random.nextInt(3);

        switch (opcao) {
            case 0:
                setY(++this.y);
                break;
            case 1:
                setY(--this.y);
                break;
            case 2:
                setX(--this.x);
                break;
            case 3:
                setX(++this.x);
                break;
        }
    }
}
