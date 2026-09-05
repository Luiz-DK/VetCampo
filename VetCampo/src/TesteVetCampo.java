import java.util.ArrayList;
import java.util.List;

/*
 * ===================== MODELAGEM DA SOLUÇÃO =====================
 *
 * Animal (classe abstrata) — superclasse comum às três espécies.
 *   Atributos (privados): codigo, nome, tutor, peso, idade.
 *   Métodos concretos: getCodigo, getNome, getTutor, getPeso, getIdade,
 *     setPeso(double) [única forma de alterar dado após o cadastro, valida
 *     peso > 0], calcularValorConsulta(boolean comPlano) [aplica o
 *     desconto de 20% reaproveitando o cálculo abstrato — a regra do
 *     plano existe uma única vez no programa], imprimirFicha() [dados
 *     comuns de cadastro].
 *   Métodos abstratos: getEspecie(), calcularValorConsulta() — só a
 *     espécie sabe responder sua fórmula de preço e seu nome.
 *   Construtores sobrecarregados: com idade e sem idade (idade = 0),
 *     o segundo delega ao primeiro via this(...).
 *   Não pode ser instanciada: não existe "animal genérico" na clínica.
 *
 * Internavel (interface) — contrato de "pode ser internado".
 *   Métodos: internar(int diarias), getDiariasAcumuladas(),
 *     getValorInternacao(). Implementada apenas por Cao e Gato.
 *
 * Cao extends Animal implements Internavel
 *   Atributo próprio: raca. Fórmula: 90 + 2 * peso. Diária: R$ 60,00.
 *   Sobrepõe calcularValorConsulta(), getEspecie() e imprimirFicha()
 *
 * Gato extends Animal implements Internavel
 *   Atributo próprio: castrado. Fórmula: 80 + 1.5 * peso. Diária: R$ 45,00.
 *   Mesmas sobreposições que Cao, acrescentando se é castrado.
 *
 * Bovino extends Animal
 *   Atributos próprios: numeroBrinco, finalidade. Fórmula:
 *     150 (taxa de deslocamento) + 0.8 * peso. Não implementa Internavel.
 *   Sobrepõe calcularValorConsulta(), getEspecie() e imprimirFicha(),
 *     acrescentando brinco e finalidade.
 *
 * TesteVetCampo — classe de teste com o método main, descrita abaixo.
 * ==================================================================
 */
public class TesteVetCampo {

    public static void main(String[] args) {

        Cao thor = new Cao("A001", "Thor", "Marcos Andrade", 32, 4, "Labrador");
        Gato mel = new Gato("A002", "Mel", "Joana Ribeiro", 5, true);
        Bovino estrela = new Bovino("A003", "Estrela", "Fazenda Boa Vista", 480, 6, "1187", "leite");

        Animal[] animais = { thor, mel, estrela };

        System.out.println("===== FICHAS =====");
        for (int i = 0; i < animais.length; i++) {
            System.out.println(animais[i].imprimirFicha());
            System.out.println("-------------------");
        }

        System.out.println("===== VALORES DE CONSULTA =====");
        for (int i = 0; i < animais.length; i++) {
            Animal a = animais[i];
            System.out.printf("%s - sem plano: R$ %.2f | com plano: R$ %.2f%n",
                    a.getNome(), a.calcularValorConsulta(), a.calcularValorConsulta(true));
        }

        thor.internar(3);
        mel.internar(4);
        thor.internar(2);

        List<Internavel> internaveis = new ArrayList<>();
        internaveis.add(thor);
        internaveis.add(mel);

        System.out.println("===== INTERNAÇÕES =====");
        for (Internavel internavel : internaveis) {
            Animal a = (Animal) internavel;
            System.out.printf("%s - %d diárias - R$ %.2f%n",
                    a.getNome(), internavel.getDiariasAcumuladas(), internavel.getValorInternacao());
        }

        // 6) Nova pesagem do Thor (35 kg) e nova consulta, que deve mudar.
        thor.setPeso(35);
        System.out.printf("Consulta do Thor após a pesagem de 35 kg: R$ %.2f%n", thor.calcularValorConsulta());

    }
}
