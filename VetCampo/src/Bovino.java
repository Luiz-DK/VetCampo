/**
 * Bovino: R$ 150,00 de taxa de deslocamento até a fazenda + R$ 0,80 por
 * quilo. Não implementa Internavel porque é atendido na própria fazenda,
 * nunca fica internado na clínica. A ficha acrescenta o número do brinco e
 * a finalidade do rebanho.
 */
public class Bovino extends Animal {

    private static final double TAXA_DESLOCAMENTO = 150.0;
    private static final double VALOR_POR_KG = 0.8;

    private final String numeroBrinco;
    private final String finalidade;

    public Bovino(String codigo, String nome, String tutor, double peso, int idade,
                  String numeroBrinco, String finalidade) {
        super(codigo, nome, tutor, peso, idade);
        this.numeroBrinco = numeroBrinco;
        this.finalidade = finalidade;
    }

    // Sobrecarga: cadastro sem idade conhecida.
    public Bovino(String codigo, String nome, String tutor, double peso,
                  String numeroBrinco, String finalidade) {
        super(codigo, nome, tutor, peso);
        this.numeroBrinco = numeroBrinco;
        this.finalidade = finalidade;
    }

    public String getNumeroBrinco() {
        return numeroBrinco;
    }

    public String getFinalidade() {
        return finalidade;
    }

    @Override
    public String getEspecie() {
        return "Bovino";
    }

    @Override
    public double calcularValorConsulta() {
        return TAXA_DESLOCAMENTO + VALOR_POR_KG * getPeso();
    }

    @Override
    public String imprimirFicha() {
        return super.imprimirFicha()
                + "\nBrinco: " + numeroBrinco
                + "\nFinalidade do rebanho: " + finalidade;
    }
}
