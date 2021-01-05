package data;

import program.objetos.Alternativa;
import program.objetos.Questao;

import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public List<Questao> buscarQuestoes() {
        List<String> linhas = CustomFileReader.read("C:\\temp\\questoes.csv");

        List<Questao> questoes = new ArrayList<>();

        for (String linha : linhas) {
            Questao questao = new Questao();
            //separa em pedaços o conteúdo do arquivo
            String[] pedaco = linha.split(",");
            //Captura o pedaço zero para Enunciado
            questao.setEnunciado(pedaco[0]);
            //Captura o pedaço 1 para Código
            questao.setCodigo(pedaco[1]);

            List<Alternativa> alternativas = new ArrayList<>();
            for (int i = 2; i < pedaco.length; i++) {
                String[] pedacoAlternativa = pedaco[i].split("\\|");
                Alternativa alternativa = new Alternativa();
                alternativa.setEnunciado(pedacoAlternativa[1]);
                alternativa.setCodigo(pedacoAlternativa[0]);

                alternativas.add(alternativa);
            }
            questao.setAlternativas(alternativas);
            questoes.add(questao);
        }
        return questoes;
    }
}
