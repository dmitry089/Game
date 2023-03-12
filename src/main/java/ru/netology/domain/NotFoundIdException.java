package ru.netology.domain;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException(String playerName) {
        super(" Игрок с данным именем " + playerName + " не найден ");
    }

}

