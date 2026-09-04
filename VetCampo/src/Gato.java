/**
 * Gato: R$ 80,00 + R$ 1,50 por quilo. Pode ficar internado (diária de
 * R$ 45,00) e a ficha acrescenta se é castrado.
 */
public class Gato extends Animal implements Internavel {

    private static final double VALOR_BASE = 80.0;
    private static final double VALOR_POR_KG = 1.5;
    private static final double VALOR_DIARIA = 45.0;

    private final boolean castrado;
    private int diariasAcumuladas;

    public Gato(String codigo, String nome, String tutor, double peso, int idade, boolean castrado) {
        super(codigo, nome, tutor, peso, idade);
        this.castrado = castrado;
    }

    // Sobrecarga: cadastro sem idade conhecida.
    public Gato(String codigo, String nome, String tutor, double peso, boolean castrado) {
        super(codigo, nome, tutor, peso);
        this.castrado = castrado;
    }

    public boolean isCastrado() {
        return castrado;
    }

    @Override
    public String getEspecie() {
        return "Gato";
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
        return super.imprimirFicha() + "\nCastrado: " + (castrado ? "Sim" : "Não");
    }
}
