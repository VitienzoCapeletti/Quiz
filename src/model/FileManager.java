package model;

import model.entity.Questao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {

    public List<Questao> buscarQuestoes() {

        String path = "/home/vitienzo/IdeaProjects/Quiz/questoes.csv";

        Stream<String> linhas = CustomFileReader.read(path);

        return linhas
                .map(linha -> linha.split(","))
                .map(pedacos -> new Questao().fromFile(pedacos))
                .collect(Collectors.toList());
    }

    public void adicionarQuestao(Questao questao) {
        String path = "/home/vitienzo/IdeaProjects/Quiz/questoes.csv";

        String[] pedacos = questao.toFile();
        String linha = String.join(",", pedacos);

        CustomFileWriter.write(path, linha);
    }




}
