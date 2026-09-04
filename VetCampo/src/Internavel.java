/**
 * Contrato assinado apenas pelas espécies que podem ficar internadas na
 * clínica (Cão e Gato). O Bovino não implementa esta interface porque é
 * atendido na própria fazenda.
 */
public interface Internavel {

    /** Registra uma nova internação, acumulando diárias às já existentes. */
    void internar(int diarias);

    /** Total de diárias acumuladas por este animal (internações somadas). */
    int getDiariasAcumuladas();

    /** Valor total em reais correspondente às diárias acumuladas. */
    double getValorInternacao();
}
