package model;


import model.entity.Alternativa;
import model.entity.Questao;

import java.util.Arrays;
import java.util.List;

//DATA TRANSFER OBJECT
public class QuestaoDTO {

    private String enunciado;
    private List<Alternativa> alternativas;

    public QuestaoDTO(Questao questao) {
        this.enunciado = questao.getEnunciado();
        this.alternativas = Arrays.asList(questao.getAlternativas()) ;
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
