package ru.mal.validator;

import ru.mal.entity.Commit;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Validator {

    private static final String NICK_NAME_PATTERN = "^[a-zA-Z_][a-zA-Z0-9_]*$";
    private static final String HASH_PATTERN = "^[a-z0-9]{7}$";

    public static boolean isValidNickname(String nickname){
        if (nickname == null) {
            return false;
        } else {
            return nickname.matches(NICK_NAME_PATTERN);
        }
    }

    public static boolean isValidHash(String hash){
        if (hash == null) {
            return false;

        } else {
            return hash.matches(HASH_PATTERN);
        }
    }

    public static boolean isValidCommit(Commit commit){
        return isValidNickname(commit.getNickName()) &&
                isValidHash(commit.getHash()) &&
                isValidDateTime(commit.getDateTime());
    }

    public static boolean isValidDateTime(String dTime){
        try {
            String[] split = dTime.split("[.\\-T:]");
            int[] dTimeNumbers = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            LocalDateTime.of(dTimeNumbers[0], dTimeNumbers[1], dTimeNumbers[2], dTimeNumbers[3], dTimeNumbers[4], dTimeNumbers[5]);
            return true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | DateTimeException e) {
            return false;
        }
    }

}
