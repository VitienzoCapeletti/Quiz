package program;

import data.FileManager;
import program.objetos.Questao;
import program.objetos.QuestaoDTO;

import java.util.List;

public class Program implements Quiz {

    private int pontosTotais;
    private int pontosRodada;
    private int proximaQuestao;
    private List<Questao> questoes;
    private FileManager fileManager;

    public Program() {
        this.fileManager = new FileManager();
        this.questoes = fileManager.buscarQuestoes();
    }

    @Override
    public QuestaoDTO proximaQuestao() {
        if (proximaQuestao < questoes.size()) {
            Questao questao = questoes.get(proximaQuestao);
            proximaQuestao++;
            pontosRodada = 5;
            QuestaoDTO dto = new QuestaoDTO(questao);

            return dto;
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
}
