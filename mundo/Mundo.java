package mundo;

import java.util.ArrayList;
import hospital.Hospital;
import pessoaDoente.PessoaDoente;
import pessoaSaudavel.PessoaSaudavel;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import virus.Virus;

/**
 * Classe para objetos do tipo Mundo, onde serão contidos atributos e métodos
 * para o mesmo. Tal classe possui uma relação de composição com as classes
 * PessoaDoente, PessoaSaudavel e Hospital
 *
 * @author Antonio Gustavo Muniz (22.119.001 - 0)
 * @version 1.0
 * @see Hospital
 * @see PessoaDoente
 * @see PessoaSaudavel
 * @see Virus
 */
public class Mundo {

    public static final String ANSI_FG_RED = "\u001B[31m";
    public static final String ANSI_FG_BLUE = "\u001B[34m";
    public static final String ANSI_FG_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_FG_WHITE = "\u001B[37m";
    public static final String ANSI_FG_BLACK = "\u001B[30m";
    ArrayList<Hospital> hospitais;
    ArrayList<PessoaDoente> doentes;
    ArrayList<PessoaSaudavel> saudaveis;

    Random random = new Random();
    public double second = 0;

    public int mapa[][]
            = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};

    /**
     * Método construtor: o objeto do tipo Mundo irá inicializar seus atributos,
     * utilizando a relação de composição instancia-se os três atributos de
     * ArrayList.
     */
    public Mundo() {
        hospitais = new ArrayList<>();
        doentes = new ArrayList<>();
        saudaveis = new ArrayList<>();
    }

    /**
     * Método para colorir o mapa. Recebe-se um valor inteiro, que representa um
     * um objeto por meio desse número, cada objeto tem uma numeração e,
     * consequentemente, uma coloração diferente, definida nesta função.
     *
     * @param value - Valor inteiro que representa um objeto do mapa
     */
    public void colorTheMap(int value) {
        switch (value) {
            case 1:
            case 4:
                System.out.print(ANSI_FG_WHITE + "\u2588");
                break;
            case 3:
                System.out.print(ANSI_FG_RED + "\u2588");
                break;
            case 5:
                System.out.print(ANSI_FG_BLUE + "\u2588");
                break;
            case 6:
                System.out.print(ANSI_FG_YELLOW + "\u2588");
                break;
            default:
                System.out.print(ANSI_FG_BLACK + "\u2588");
                break;
        }
    }

    /**
     * Método para preencher o mapa com os hospitais. Recebe-se o mapa e itera
     * cada espaço dessa matriz. Quando chega a um dos três pontos
     * pré-estabelecidos para se construir o hospital, começa a iteração de 5x5
     * da matriz hospital, onde pega-se o valor da cor principal e a parte da
     * cruz é marcada como sendo a cor do hospital somado 1. Isso será útil para
     * diferenciar a parte branca (cruz) da vermelha. Pega-se a cor do primeiro
     * hospital, pois todos são iguais entre si.
     *
     * @param mapa - Mapa que será preenchido com os hospitais
     */
    public void populateWithHospital(int mapa[][]) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if ((i == 5 && j == 5) || (i == 5 && j == 40) || (i == 20 && j == 25)) {

                    for (int linha = 0; linha < 5; linha++) {
                        for (int coluna = 0; coluna < 5; coluna++) {

                            if ((coluna == 2 && (linha >= 1 && linha <= 3)) || (linha == 2 && (coluna >= 1 && coluna <= 3))) {
                                mapa[i + linha][j + coluna] = hospitais.get(0).getCor() + 1;
                            } else {
                                mapa[i + linha][j + coluna] = hospitais.get(0).getCor();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Método para popular um ArrayList de PessoasSaudaveis. Recebe-se o
     * ArrayList e o número de pessoas que se deseja criar, a cor é predefinida
     * como 5 e a posição é gerada de forma randômica.
     *
     * @param saudaveis - ArrayList que será populado
     * @param number - Número de pessoas que se deseja criar
     */
    public void createHealthPeople(ArrayList<PessoaSaudavel> saudaveis, int number) {
        for (int i = 0; i < number; i++) {
            while (true) {
                int x = random.nextInt(60);
                int y = random.nextInt(30);
                if (mapa[y][x] == 2 || mapa[y][x] == 1 || mapa[y][x] == 0) {
                    saudaveis.add(new PessoaSaudavel(random.nextInt(60), random.nextInt(30), 5));
                    break;
                }
            }
        }
    }

    /**
     * Método para popular um ArrayList de PessoasDoentes. Recebe-se o ArrayList
     * e o número de pessoas que se deseja criar, a cor é predefinida como 6 e a
     * posição é gerada de forma randômica. Cria-se um vírus para a PessoaDoente
     * e depois passa por parâmetro para a pessoa criada, também confere se é
     * possível criar uma pessoa no local especificado para que uma pessoa
     * doente não seja criada ao lado de uma saudável e a contamine
     * imediatamente.
     *
     * @param doentes - ArrayList que será populado
     * @param number - Número de pessoas que se deseja criar
     */
    public void createInfectedPeople(ArrayList<PessoaDoente> doentes, int number) {
        for (int i = 0; i < number; i++) {
            Virus virus = new Virus((int) second);
            boolean run = true;

            while (run) {
                int x = random.nextInt(60);
                int y = random.nextInt(30);
                if (mapa[y][x] == 2 || mapa[y][x] == 1 || mapa[y][x] == 0) {
                    for (int j = 0; j < saudaveis.size(); j++) {
                        if ((x == saudaveis.get(j).getX() && y == saudaveis.get(j).getY())
                                || (x + 1 == saudaveis.get(j).getX() && y == saudaveis.get(j).getY())
                                || (x - 1 == saudaveis.get(j).getX() && y == saudaveis.get(j).getY()
                                || (x == saudaveis.get(j).getX() && y + 1 == saudaveis.get(j).getY())
                                || (x == saudaveis.get(j).getX() && y - 1 == saudaveis.get(j).getY()))) {
                            break;
                        } else if (j == saudaveis.size() - 1) {
                            doentes.add(new PessoaDoente(virus, x, y, 6));
                            run = false;
                        }
                    }
                }
            }
        }
    }

    /**
     * Método para popular um ArrayList de Hospitais. Recebe-se o ArrayList e o
     * número de hospitais que se deseja criar, a cor é predefinida como 3.
     *
     * @param hospitais - ArrayList que será populado
     * @param number - Número de hospitais que se deseja criar
     */
    public void createHospital(ArrayList<Hospital> hospitais, int number) {
        for (int i = 0; i < number; i++) {
            hospitais.add(new Hospital(3));
        }
    }

    /**
     * Método para checar se houve colisão entre um doente e um saudável.
     * Recebe-se uma PessoaSaudavel e checa se ela colide com alguma
     * PessoaDoente, caso ela seja contaminada cria-se um novo vírus e também
     * uma nova PessoaDoente. Também remove-se o índice referente aquela
     * PessoaSaudavel que foi contaminada e move a nova PessoaDoente. Além
     * disso, se for contaminada retorna-se um boolean true, caso contrário
     * false.
     *
     * @param indice - Índice da PessoaSaudavel no ArrayList
     * @param saudavel - PessoaSaudavel que será checada se foi contaminada
     * @return boolean - Se houve ou não contaminação
     */
    public boolean checkCollision(int indice, PessoaSaudavel saudavel) {
        boolean state = false;

        for (int i = 0; i < doentes.size(); i++) {
            if ((saudavel.getX() == doentes.get(i).getX() && saudavel.getY() == doentes.get(i).getY())
                    || (saudavel.getX() + 1 == doentes.get(i).getX() && saudavel.getY() == doentes.get(i).getY())
                    || (saudavel.getX() - 1 == doentes.get(i).getX() && saudavel.getY() == doentes.get(i).getY())
                    || (saudavel.getX() == doentes.get(i).getX() && saudavel.getY() + 1 == doentes.get(i).getY())
                    || (saudavel.getX() == doentes.get(i).getX() && saudavel.getY() - 1 == doentes.get(i).getY())) {

                Virus virus = new Virus((int) second);
                doentes.add(new PessoaDoente(virus, saudaveis.get(indice).getX(), saudaveis.get(indice).getY(), 6));

                doentes.get(doentes.size() - 1).mover();
                mapa[doentes.get(doentes.size() - 1).getY()][doentes.get(doentes.size() - 1).getX()] = doentes.get(doentes.size() - 1).getCor();

                saudaveis.remove(indice);
                state = true;
                break;
            }
        }
        if (state == false) {
            saudavel.mover();
            state = false;
        }
        return state;
    }

    /**
     * Método para checar se houve colisão entre um doente e um hospital.
     * Recebe-se uma PessoaDoente e checa se ela colide com algum Hospital, caso
     * ela seja curada cria-se uma nova PessoaSaudavel. Também remove-se o
     * índice referente aquela PessoaDoente que foi curada e move a nova
     * PessoaSaudavel. Além disso, se for curada retorna-se um boolean true,
     * caso contrário false.
     *
     * @param indice - Índice da PessoaDoente no ArrayList
     * @param doente - PessoaDoente que será checada se foi curada
     * @param myStaticMap - Mapa estático que será utilizado para checar se
     * houve colisão com o hospital
     * @return boolean - Se houve ou não cura
     */
    public boolean checkCollisionHospital(int indice, PessoaDoente doente, int[][] myStaticMap) {
        boolean retorno = false;
        int comparationSpace = myStaticMap[doente.getY()][doente.getX()];

        if (comparationSpace == hospitais.get(0).getCor() || comparationSpace == hospitais.get(0).getCor() + 1) {

            saudaveis.add(new PessoaSaudavel(doente.getX(), doente.getY(), 5));
            saudaveis.get(saudaveis.size() - 1).mover();

            mapa[saudaveis.get(saudaveis.size() - 1).getY()][saudaveis.get(saudaveis.size() - 1).getX()] = saudaveis.get(saudaveis.size() - 1).getCor();
            doentes.remove(indice);
            retorno = true;
        } else {
            doente.mover();
            retorno = false;
        }
        return retorno;
    }

    /**
     * Método para checar se a PessoaDoente está contaminada há mais que 30
     * segundos. Se deu o tempo retorna-se um boolean true e remove ela do
     * ArrayList de PessoasDoentes, caso contrário retorna false.
     *
     * @param indice - Índice da PessoaDoente no ArrayList
     * @param doente - PessoaDoente que será checada se morreu
     * @param tempoAtual - Tempo atual da simulação
     * @return boolean - Se a PessoaDoente morreu ou não
     */
    public boolean checkDeath(int indice, PessoaDoente doente, int tempoAtual) {
        boolean state = false;
        if (tempoAtual - doente.virus.getTempoContaminado() >= 30) {
            doentes.remove(indice);
            state = true;
        } else {
            state = false;
        }
        return state;
    }

    /**
     * Método para checar o estado de todas as PessoasSaudaveis e depois
     * move-las. Incialmente, coloca a posição atual da PessoaSaudavel como
     * sendo a que está no mapa estatico (sem pessoas), ou seja, apaga-se a
     * pessoa. Após isso, testa se houve contaminação, caso não tenha sido
     * preenche a nova posição da pessoa após essa ter se movido no metodo de
     * checar colisão com os doentes.
     *
     * @param myStaticMap - Mapa estatico utilizado para retornar ao estado
     * anterior após uma pessoa se mover
     */
    public void checkHealthPeople(int[][] myStaticMap) {
        for (int i = 0; i < saudaveis.size(); i++) {
            mapa[saudaveis.get(i).getY()][saudaveis.get(i).getX()] = myStaticMap[saudaveis.get(i).getY()][saudaveis.get(i).getX()];

            boolean contaminouBoolean = checkCollision(i, saudaveis.get(i));

            if (saudaveis.isEmpty() == false && contaminouBoolean == false) {
                mapa[saudaveis.get(i).getY()][saudaveis.get(i).getX()] = saudaveis.get(i).getCor();
            }
        }
    }

    /**
     * Método para checar o estado de todas as PessoasDoentes e depois move-las.
     * Incialmente, coloca a posição atual da PessoaDoente como sendo a que está
     * no mapa estatico (sem pessoas), ou seja, apaga-se a pessoa. Após isso,
     * testa se ela morreu devido ao tempo de contaminação, caso não tenha sido
     * testa-se também se ela foi curada. Caso não tenha sido nem morta nem
     * curada preenche a nova posição da pessoa apoś essa ter se movido no
     * metodo de checar colisão com o Hospital.
     *
     * @param myStaticMap - Mapa estatico utilizado para retornar ao estado
     * anterior após uma pessoa se mover
     */
    public void checkInfectedPeople(int[][] myStaticMap) {
        for (int i = 0; i < doentes.size(); i++) {
            mapa[doentes.get(i).getY()][doentes.get(i).getX()] = myStaticMap[doentes.get(i).getY()][doentes.get(i).getX()];

            boolean morreuBoolean = checkDeath(i, doentes.get(i), (int) second);

            if (doentes.isEmpty() == false && morreuBoolean == false) {
                boolean curouBoolean = checkCollisionHospital(i, doentes.get(i), myStaticMap);

                if (curouBoolean == false) {
                    mapa[doentes.get(i).getY()][doentes.get(i).getX()] = doentes.get(i).getCor();
                }
            }
        }
    }

    /**
     * Método para criar um mapa estatico a partir do mapa principal, esse será
     * utilizado para fazer comparações de posições, pois não apresenta nenhuma
     * pessoa declarada
     *
     * @return int[][] - Mapa estatico utilizado para retornar ao estado
     * anterior após uma pessoa se mover
     */
    public int[][] createStaticMap() {
        int[][] myStaticMap = new int[mapa.length][];
        for (int i = 0; i < mapa.length; i++) {
            myStaticMap[i] = mapa[i].clone();
        }
        return myStaticMap;
    }

    /**
     * Método para desenhar o mapa principal. Cabe a ele toda a chamada de
     * métodos de criação, bem como apresenta uma função de TimerTask para a
     * cada 1/4 de segundo atualizar o frame e a cada um segundo incrementar o
     * tempo, além de chamar as funções necessárias para atualizar o estado do
     * mapa. A função também leva em conta três condicionais de parada do
     * programa, parq eu não fique em loop infinito.
     *
     */
    public void desenhaMundo() {
        createHospital(hospitais, 3);
        populateWithHospital(mapa);
        createHealthPeople(saudaveis, 10);
        createInfectedPeople(doentes, 1);

        int[][] myStaticMap = createStaticMap();

        Timer timer = new Timer();
        TimerTask task;
        task = new TimerTask() {
            @Override
            public void run() {
                if (doentes.isEmpty()) {
                    System.out.println("                Não há mais pessoas doentes");
                    timer.cancel();
                } else if (saudaveis.isEmpty()) {
                    System.out.println("                Não há mais pessoas saudavéis");
                    timer.cancel();
                } else if (doentes.size() + saudaveis.size() == 0) {
                    System.out.println("                Não há mais pessoas vivas");
                    timer.cancel();
                } else {
                    checkHealthPeople(myStaticMap);
                    checkInfectedPeople(myStaticMap);

                    System.out.println("\n\n             ____                          __     ___                \n"
                            + "            / ___|___  _ __ ___  _ __   __ \\ \\   / (_)_ __ _   _ ___ \n"
                            + "           | |   / _ \\| '__/ _ \\| '_ \\ / _` \\ \\ / /| | '__| | | / __|\n"
                            + "           | |__| (_) | | | (_) | | | | (_| |\\ V / | | |  | |_| \\__ \\\n"
                            + "            \\____\\___/|_|  \\___/|_| |_|\\__,_| \\_/  |_|_|   \\__,_|___/\n"
                            + "                                                                     ");

                    System.out.println("====================================================================================");
                    System.out.printf("                        Tempo de simulação: %d \n\n", (int) second);
                    second += 0.25;
                    System.out.println("                " + ANSI_FG_BLUE + "\u2588 " + "Saudáveis: " + saudaveis.size() + "                " + ANSI_FG_YELLOW + "\u2588 " + "Doentes: " + doentes.size() + ANSI_RESET);
                    System.out.println("                        Total de pessoas: " + (saudaveis.size() + doentes.size()) + "\n");

                    for (int i = 0; i < mapa.length; i++) {
                        System.out.print("        ");
                        for (int j = 0; j < mapa[0].length; j++) {
                            colorTheMap(mapa[i][j]);
                        }
                        System.out.println(ANSI_RESET);
                    }
                }
            }
        };
        long delay = 0; //
        long period = 250;
        timer.schedule(task, delay, period);
    }
}
