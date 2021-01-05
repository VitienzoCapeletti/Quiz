package program;

import program.objetos.QuestaoDTO;

public interface Quiz {

    QuestaoDTO proximaQuestao();
    Boolean validarResposta(String codigo);
    Integer resultadoFinal();

}
