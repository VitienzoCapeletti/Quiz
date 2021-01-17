package controller;

import model.FileManager;
import model.entity.Questao;
import model.QuestaoDTO;

import java.util.List;

public class QuizController implements Quiz {

    private int pontosTotais;
    private int pontosRodada;
    private int proximaQuestao;
    private final List<Questao> questoes;
    private final FileManager fileManager;

    public QuizController() {
        this.fileManager = new FileManager();
        this.questoes = fileManager.buscarQuestoes();
    }

    @Override
    public QuestaoDTO proximaQuestao() {
        if (proximaQuestao < questoes.size()) {
            Questao questao = questoes.get(proximaQuestao);
            proximaQuestao++;
            pontosRodada = 5;

            return new QuestaoDTO(questao);
        }
        return null;
    }

    @Override
    public Boolean validarResposta(String codigo) {
        int questaoAtual = proximaQuestao - 1;
        if (questaoAtual < questoes.size()) {
            Questao questao = questoes.get(questaoAtual);
            if (questao.getCodigo().equals(codigo)) {
                pontosTotais += pontosRodada;
                return true;
            } else {
                pontosTotais--;
                return false;
            }
        }
        return null;
    }

    @Override
    public Integer resultadoFinal() {
        return pontosTotais;
    }


    public void adicionarQuestao(Questao questao){
        fileManager.adicionarQuestao(questao);
        questoes.add(questao);
    }

}
