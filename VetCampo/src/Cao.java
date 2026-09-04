/**
 * Cão: R$ 90,00 + R$ 2,00 por quilo. Pode ficar internado (diária de
 * R$ 60,00) e a ficha acrescenta a raça.
 */
public class Cao extends Animal implements Internavel {

    private static final double VALOR_BASE = 90.0;
    private static final double VALOR_POR_KG = 2.0;
    private static final double VALOR_DIARIA = 60.0;

    private final String raca;
    private int diariasAcumuladas;

    public Cao(String codigo, String nome, String tutor, double peso, int idade, String raca) {
        super(codigo, nome, tutor, peso, idade);
        this.raca = raca;
    }

    // Sobrecarga: cadastro sem idade conhecida, delega para o construtor
    // acima com idade = 0 via super(...).
    public Cao(String codigo, String nome, String tutor, double peso, String raca) {
        super(codigo, nome, tutor, peso);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String getEspecie() {
        return "Cão";
    }

    @Override
    public double calcularValorConsulta() {
        return VALOR_BASE + VALOR_POR_KG * getPeso();
    }

    @Override
    public void internar(int diarias) {
        diariasAcumuladas += diarias;
    }

    @Override
    public int getDiariasAcumuladas() {
        return diariasAcumuladas;
    }

    @Override
    public double getValorInternacao() {
        return diariasAcumuladas * VALOR_DIARIA;
    }

    @Override
    public String imprimirFicha() {
        return super.imprimirFicha() + "\nRaça: " + raca;
    }
}
