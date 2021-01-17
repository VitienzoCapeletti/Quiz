package controller;

import model.QuestaoDTO;
import model.entity.Questao;

public interface Quiz {

    QuestaoDTO proximaQuestao();

    Boolean validarResposta(String codigo);

    Integer resultadoFinal();

    void adicionarQuestao(Questao questao);

}
