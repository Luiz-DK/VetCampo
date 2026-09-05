/**
 * Superclasse abstrata comum a todo animal atendido pela VetCampo.
 * Concentra os dados de cadastro (código, nome, tutor/fazenda, peso, idade)
 * e as regras que são iguais para qualquer espécie: encapsulamento dos
 * atributos, validação da pesagem e o cálculo do valor da consulta com ou
 * sem plano de saúde (a regra do desconto de 20% mora aqui, uma única vez).
 */
public abstract class Animal {

    private final String codigo;
    private final String nome;
    private final String tutor;
    private double peso;
    private final int idade;

    // Sobrecarga de construtor: cadastro com idade conhecida.
    public Animal(String codigo, String nome, String tutor, double peso, int idade) {
        this.codigo = codigo;
        this.nome = nome;
        this.tutor = tutor;
        this.peso = peso;
        this.idade = idade;
    }

    // Sobrecarga de construtor: cadastro sem idade conhecida (animais
    // resgatados). Reaproveita o construtor acima em vez de repetir a
    // atribuição dos campos, usando idade = 0 como convenção.
    public Animal(String codigo, String nome, String tutor, double peso) {
        this(codigo, nome, tutor, peso, 0);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTutor() {
        return tutor;
    }

    public double getPeso() {
        return peso;
    }

    public int getIdade() {
        return idade;
    }

    public boolean setPeso(double novoPeso) {
        if (novoPeso > 0) {
            this.peso = novoPeso;
            return true;
        }
        System.out.println("Pesagem recusada: o peso informado (" + novoPeso
                + " kg) precisa ser maior que zero.");
        return false;
    }

    /** Nome da espécie, usado na ficha. Só a subclasse sabe responder. */
    public abstract String getEspecie();

    /**
     * Valor cheio da consulta (sem plano), calculado de acordo com a fórmula
     * própria de cada espécie.
     */
    public abstract double calcularValorConsulta();
    public double calcularValorConsulta(boolean comPlano) {
        double valorCheio = calcularValorConsulta();
        return comPlano ? valorCheio * 0.8 : valorCheio;
    }

    /**
     * Ficha com os dados comuns a qualquer animal.
     */
    public String imprimirFicha() {
        return "Código: " + codigo
                + "\nNome: " + nome
                + "\nTutor/Fazenda: " + tutor
                + "\nPeso: " + peso + " kg"
                + "\nIdade: " + idade + " anos"
                + "\nEspécie: " + getEspecie()
                + "\nValor da consulta: R$ " + String.format("%.2f", calcularValorConsulta());
    }
}
