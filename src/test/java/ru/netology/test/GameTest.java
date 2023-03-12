package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Game;
import ru.netology.domain.NotFoundIdException;
import ru.netology.domain.Player;


class GameTest {
    Game game = new Game();

    @Test
    public void testWhenHeFirstPlayerStrength() {
        Player one = new Player(1, "Александр", 105);
        Player two = new Player(2, "Виктор", 160);

        game.resister(one);
        game.resister(two);
        int actual = game.round("Виктор", "Александр");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenHeSecondPlayerStrength() {
        Player one = new Player(1, "Александр", 105);
        Player two = new Player(2, "Виктор", 160);

        game.resister(one);
        game.resister(two);
        int actual = game.round("Александр", "Виктор");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenTheStrengthOfThePlayersEqual() {
        Player one = new Player(1, "Александр", 200);
        Player two = new Player(2, "Виктор", 200);

        game.resister(one);
        game.resister(two);
        int actual = game.round("Виктор", "Александр");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotThrowExceptionOnePlayer() {
        Player one = new Player(1, "Александр", 105);
        Player two = new Player(2, "Виктор", 160);
        game.resister(one);
        game.resister(two);

        Assertions.assertThrows(NotFoundIdException.class,
                () -> {
                    game.round("Антон", "Александр");
                });
    }

    @Test
    public void shouldNotThrowExceptionTwoPlayer() {
        Player one = new Player(1, "Александр", 105);
        Player two = new Player(2, "Виктор", 160);
        game.resister(one);
        game.resister(two);

        Assertions.assertThrows(NotFoundIdException.class,
                () -> {
                    game.round("Александр", "Павел");
                });
    }

    @Test
    public void shouldNotThrowExceptionAllPlayers() {
        Player one = new Player(1, "Александр", 105);
        Player two = new Player(2, "Виктор", 160);
        game.resister(one);
        game.resister(two);

        Assertions.assertThrows(NotFoundIdException.class,
                () -> {
                    game.round("Джон", "Степан");
                });
    }


}