package virus;

/**
 * Classe para objetos do tipo Virus, onde serão contidos atributos e métodos
 * para o mesmo
 *
 * @author Antonio Gustavo Muniz (22.119.001 - 0)
 * @version 1.0
 */
public class Virus {

    private int tempoContaminado;

    /**
     * Método construtor: o objeto do tipo Virus irá iniciar sem atributos
     * definidos
     */
    public Virus() {
    }

    /**
     * Método construtor: o objeto do tipo Virus irá iniciar com atributo
     * definido
     *
     * @param tempoContaminado - Valor do tempo no instante em que o Virus foi
     * criado
     */
    public Virus(int tempoContaminado) {
        this.tempoContaminado = tempoContaminado;
    }

    /**
     * Método para retorno do atributo tempoContaminado do Virus
     *
     * @return int - Valor do tempo no instante em que o Virus foi criado
     */
    public int getTempoContaminado() {
        return tempoContaminado;
    }

    /**
     * Método para atribuir novo valor ao atributo tempoContaminado do Virus
     *
     * @param tempoContaminado - Novo valor do tempo para o instante em que o
     * Virus foi criado
     */
    public void setTempoContaminado(int tempoContaminado) {
        this.tempoContaminado = tempoContaminado;
    }

}
