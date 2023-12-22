package Lesson10;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    int keyLeft = 37;
    int keyUp = 38;
    int keyRight = 39;
    int keuDown = 40;

    public void main(String[] args) {
        JFrame frame = new JFrame();
        frame.addKeyListener(new KeyboardHandler());

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Обработка нажатия клавиши без учета комбинаций
        System.out.println("Key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Обработка удерживания клавиши
        System.out.println("Key pressed: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Обработка отпускания клавиши
        System.out.println("Key released: " + e.getKeyCode());
    }
}

