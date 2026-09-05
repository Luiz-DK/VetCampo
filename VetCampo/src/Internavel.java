/**
 * Contrato assinado apenas pelas espécies que podem ficar internadas na
 * clínica (Cão e Gato). O Bovino não implementa esta interface porque é
 * atendido na própria fazenda.
 */
public interface Internavel {

    void internar(int diarias);

    int getDiariasAcumuladas();

    double getValorInternacao();
}
