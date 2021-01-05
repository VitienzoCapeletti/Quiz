package program.objetos;

import java.util.List;

public class QuestaoDTO {

    private String enunciado;
    private List<Alternativa> alternativas;

    public QuestaoDTO(Questao questao) {
        this.enunciado = questao.getEnunciado();
        this.alternativas = questao.getAlternativas();
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
}
