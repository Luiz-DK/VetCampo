/**
 * Superclasse abstrata comum a todo animal atendido pela VetCampo.
 * Concentra os dados de cadastro (código, nome, tutor/fazenda, peso, idade)
 * e as regras que são iguais para qualquer espécie: encapsulamento dos
 * atributos, validação da pesagem e o cálculo do valor da consulta com ou
 * sem plano de saúde (a regra do desconto de 20% mora aqui, uma única vez).
 *
 * Não pode ser instanciada diretamente: não existe "animal genérico" na
 * clínica, todo animal é obrigatoriamente de uma espécie concreta, por isso
 * esta classe é abstract e declara o método calcularValorConsulta() sem
 * corpo — só cada espécie sabe responder pela sua própria fórmula.
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

    /**
     * Único ponto onde o peso pode mudar depois do cadastro (o animal é
     * pesado a cada retorno). Só aceita o novo valor se for maior que zero;
     * caso contrário a pesagem é recusada e o peso anterior é mantido.
     */
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
     * própria de cada espécie. Método abstrato: a superclasse não tem como
     * implementá-lo sozinha.
     */
    public abstract double calcularValorConsulta();

    /**
     * Sobrecarga do cálculo da consulta, agora considerando o plano de saúde
     * animal. Implementada aqui, uma única vez, reaproveitando
     * calcularValorConsulta() — assim a regra dos 20% de desconto não fica
     * duplicada em cada espécie.
     */
    public double calcularValorConsulta(boolean comPlano) {
        double valorCheio = calcularValorConsulta();
        return comPlano ? valorCheio * 0.8 : valorCheio;
    }

    /**
     * Ficha com os dados comuns a qualquer animal. Cada subclasse sobrepõe
     * este método para acrescentar a sua informação própria, sempre
     * chamando super.imprimirFicha() em vez de reescrever estas linhas.
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
