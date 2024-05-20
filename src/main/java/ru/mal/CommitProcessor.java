package ru.mal;

import ru.mal.entity.Commit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.mal.validator.Validator.isValidCommit;

public class CommitProcessor {


    public static List<String> processCommits(List<String> lines) {
        Map<String, Integer> commitCounts = new HashMap<>();

        for (String line : lines) {
            String[] parts = line.split(" ");
            if (parts.length == 3) {
                Commit commit = new Commit(parts[0], parts[1], parts[2]);

                if (isValidCommit(commit)) {
                    commitCounts.put(commit.getNickName(), commitCounts.getOrDefault(commit.getNickName(), 0) + 1);
                }
            }
        }

        return commitCounts.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
