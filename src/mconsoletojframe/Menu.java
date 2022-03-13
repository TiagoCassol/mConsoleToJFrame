/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mconsoletojframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import view.IMC;
import view.Vida;
import view.jfPesquisa;

/**
 *
 * @author casso
 */
public class Menu extends JFrame implements ActionListener {

    JTextArea output;
    JScrollPane scrollPane;

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, menuC, subMenu;
        JMenuItem menuItem;
        //cria o menuBAr1
        menuBar = new JMenuBar();

        //construir o MenuBar
        menu = new JMenu("Formularios");
        //criar um atalho na letra f
        menu.setMnemonic(KeyEvent.VK_F);
        //add o menu formulario a barra de menus "menuBar"
        menuBar.add(menu);

        //Criar os itens do menu formulário
        //item CAlc.IMC
        menuItem = new JMenuItem("Calc.IMC", KeyEvent.VK_C);
        menuItem.setActionCommand("mIMC");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.SHIFT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //item Dias de Vidas
        menuItem = new JMenuItem("Dias de Vida", KeyEvent.VK_D);
        menuItem.setActionCommand("mDiasVida");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //item pesquisa
        menuItem = new JMenuItem("Pesquisa", KeyEvent.VK_P);
        menuItem.setActionCommand("mPesquisa");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //teste com outros menus
        menuC = new JMenu("Cadastros");
        menuC.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menuC);

        subMenu = new JMenu("Clientes");
        subMenu.setMnemonic(KeyEvent.VK_C);
        menuC.add(subMenu);

        menuItem = new JMenuItem("Cadastro", KeyEvent.VK_C);
        menuItem.setActionCommand("cadClientes");
        menuItem.addActionListener(this);
        subMenu.add(menuItem);

        menuItem = new JMenuItem("Listar", KeyEvent.VK_L);
        menuItem.setActionCommand("listaClientes");
        menuItem.addActionListener(this);
        subMenu.add(menuItem);

        menuItem = new JMenuItem("Gerenciar", KeyEvent.VK_G);
        menuItem.setActionCommand("gerenciar");
        menuItem.addActionListener(this);
        subMenu.add(menuItem);
        return menuBar;
    }

    public Container createContentPane() {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    private static void createAndShowGUI() {
        JFrame janela = new JFrame("Menu Principal");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Menu menu = new Menu();
        janela.setJMenuBar(menu.createMenuBar());
        janela.setContentPane(menu.createContentPane());

        janela.setSize(450, 260);
        janela.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        createAndShowGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Ação da barra de menus
        if ("mIMC".equals(e.getActionCommand())) {
            IMC janelaIMC = new IMC();
            janelaIMC.setVisible(true);
            janelaIMC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        if ("mDiasVida".equals(e.getActionCommand())) {
            Vida janelaVida = new Vida();
            janelaVida.setVisible(true);
            janelaVida.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        if ("mPesquisa".equals(e.getActionCommand())) {
            jfPesquisa janelaPesq = new jfPesquisa();
            janelaPesq.setVisible(true);
            janelaPesq.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        if ("cadClientes".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "Cadastros clentes");
        }
        if ("listaClientes".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "Listas de Clientes");
        }
        if ("gerenciar".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "Gerenciar clientes");
        }
    }

}
//javax.swing.SwingUtilities.invokeLater(new Runnable() {
//      @Override
//     public void run() {
//             createAndShowGUI();;
//           }
//      });
 //   }
