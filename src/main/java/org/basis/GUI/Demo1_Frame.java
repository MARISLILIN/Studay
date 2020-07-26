package org.basis.GUI;

import java.awt.*;
import java.awt.event.*;

public class Demo1_Frame {
  public static void main(String[] args) {
      Frame f = new Frame("我的第一个窗口");
      f.setSize(400,600);
      f.setLocation(400,50);
      f.setIconImage(Toolkit.getDefaultToolkit().createImage("Capture001.png"));
      Button b1 = new Button("按钮一");
      Button b2 = new Button("按钮二");
      f.add(b1);
      f.add(b2);
      f.setLayout(new FlowLayout());
//      f.addWindowListener(new MyWindowsAdapter());
      f.addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
      });

      b1.addMouseListener(new MouseAdapter() {
          /*@Override
          public void mouseClicked(MouseEvent e) {
              System.exit(0);
          }*/

          @Override
          public void mouseReleased(MouseEvent e) {
              System.exit(0);
          }
      });

    b1.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                System.exit(0);
            }
          }
        });

    b2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
      f.setVisible(true);
  }
}
/*

class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Colsed");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}*/

class MyWindowsAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}