package ru.mal;

import java.io.IOException;
import java.util.List;

import static ru.mal.PropertiesReader.getProperty;

public class TopContributorsReport {

    public static void generateReport() {
        try {
            // Считываем строки из входного файла
            List<String> lines = FileReader.readLines(getProperty("inputFile"));

            // Обрабатываем коммиты и получаем топ-3 контрибьютеров
            List<String> top3Contributors = CommitProcessor.processCommits(lines);

            // Записываем результат в выходной файл
            FileWriter.writeLines(getProperty("outputFile"), top3Contributors);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateReport();
    }

}
