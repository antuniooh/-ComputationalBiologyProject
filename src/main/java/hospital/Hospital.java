package hospital;
/**
 * Classe para objetos do tipo Hospital,
 * onde serão contidos atributos e métodos para o mesmo
 * 
 * @author Antonio Gustavo Muniz (22.119.001 - 0)
 * @version 1.0
 */
public class Hospital {
    private int cor;

    /**
     * Método construtor: 
     * o objeto do tipo Hospital irá iniciar sem atributos definidos
     */
    public Hospital(){
    }

    /**
     * Método construtor:
     * o objeto do tipo Hospital irá iniciar com atributo definido
     * @param cor - Número que representa a cor que o objeto terá na matriz mundo
     */
    public Hospital(int cor) {
        this.cor = cor;
    }
    
    /**
     * Método para retorno do atributo cor do Hospital
     * @return int - Número que representa a cor que o objeto terá na matriz mundo
     */
    public int getCor() {
        return cor;
    }

    /**
     * Método para atribuir novo valor ao atributo cor do Hospital
     * @param cor - Novo valor do número que representa a cor que o objeto terá na matriz mundo
     */
    public void setCor(int cor) {
        this.cor = cor;
    }

}
