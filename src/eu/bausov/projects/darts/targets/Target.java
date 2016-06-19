package eu.bausov.projects.darts.targets;

import eu.bausov.projects.darts.Coordinate;

import javax.swing.*;    // Using Swing's components and containers

/**
 * В программе необходимо определить абстрактный класс Figure - мишень, в котором должен быть объявлен метод,
 * определяющий попадание точки в мишень (true/false) и подсчет количества очков
 */
public abstract class Target extends JPanel {
    public abstract int getScores(Coordinate coordinate);
}
