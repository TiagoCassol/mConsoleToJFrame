/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mconsoletojframe;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;//import do JFrame
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.IMC;
import view.Vida;
import view.jfPesquisa;

//import javax.swing.*;//copia tudo que esta no swing
/**
 *
 * @author casso
 */
public class MConsoleToJFrame implements ActionListener {

    JFrame janela = new JFrame();
    //criando painel/container para add os objetos
    JPanel painel = new JPanel();
    JLabel jlNome = new JLabel("seu nome: ");
    //vamos criar um input/JTField
    JTextField jtfsNome = new JTextField(5);
    JButton btnOK = new JButton("ok");
    JButton btnIMC = new JButton("IMC");
    JButton btnPesq = new JButton("Form. Pesq.");
    JButton btnVida = new JButton("Vida");
    JComboBox cbLinguagens = new JComboBox();
    JCheckBox chkJava = new JCheckBox("Java");
    JCheckBox chkPHP = new JCheckBox("PHP");
    JCheckBox chkPy = new JCheckBox("Python");
    JCheckBox chkCobol = new JCheckBox("Cobol");
    JButton btnChk = new JButton("Check's?");
    JLabel jlCheckBox = new JLabel("Qual linguagem já programou?");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new MConsoleToJFrame();
    }

    private MConsoleToJFrame() {
        janela.setTitle("Janela Principal");
        janela.setSize(450, 250);
        janela.setLocation(50, 50);
        //define a exibição do botão fechar
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        //add label ao painel
        painel.add(jlNome);
        painel.add(jtfsNome);
        //add ComboBox ao painel
        painel.add(cbLinguagens);
        //add botão ao painel
        painel.add(btnOK);
        //add botão IMC ao painel
        painel.add(btnIMC);
        painel.add(btnVida);
        //add label de check
        painel.add(jlCheckBox);
        //Add checks aos painel
        painel.add(chkJava);
        painel.add(chkCobol);
        painel.add(chkPHP);
        painel.add(chkPy);
        //add btnCheks ao painel
        painel.add(btnChk);
        //add btnPesq ao painel para abrir o form pesq
        painel.add(btnPesq);
        //add o painel na janela
        janela.add(painel);
        //defini que o JFrame vao ser carregado
        janela.setVisible(true);
        //Registrando o botão no Lisener
        btnOK.addActionListener(this);
        btnIMC.addActionListener(this);
        btnVida.addActionListener(this);
        btnChk.addActionListener(this);
        btnPesq.addActionListener(this);

        //Add itens no combo
        cbLinguagens.addItem("");
        cbLinguagens.addItem("java");
        cbLinguagens.addItem("php");
        cbLinguagens.addItem("C#");
        cbLinguagens.addItem("c++");
        cbLinguagens.addItem("ruby");
        cbLinguagens.addItem("Python");
        cbLinguagens.addItem("pascal");
        cbLinguagens.addItem("Cobol");
        cbLinguagens.addItem("Fortrean");
        cbLinguagens.addItem("Delphi");
        cbLinguagens.addItem("Kotlin");
        cbLinguagens.addItem("Go");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOK) {
            if (!jtfsNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "voce digitou " + jtfsNome.getText());
            } else if (!cbLinguagens.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "linguagem de programação selecionada foi: " + cbLinguagens.getSelectedItem());
            } else {
                JOptionPane.showMessageDialog(null, "digitar nome ou selecione uma linguagem");
            }
        }
        if (e.getSource() == btnIMC) {
            IMC janelaIMC = new IMC();
            janelaIMC.setVisible(true);
            janelaIMC.jtfSNome.setText(jtfsNome.getText());
            janelaIMC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        if (e.getSource() == btnVida) {
            Vida janelaVida = new Vida();
            janelaVida.setVisible(true);
            janelaVida.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        if (e.getSource() == btnChk) {
            verChk();
            limparChk();
        }
        if (e.getSource() == btnPesq){
        jfPesquisa janelaPesq = new jfPesquisa();//cria o obj jframe
        janelaPesq.setVisible(true);//seta que este Jframe agora é visivel
        janelaPesq.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        }
    }
    private void verChk() {
        String msg = "Linguagens: \n";
        int countChk = 0;
        if (chkCobol.isSelected()) {
            msg = msg + chkCobol.getText() + "\n";
            countChk++;
        }
        if (chkJava.isSelected()) {
            msg = msg + chkJava.getText() + "\n";
            countChk++;
        }
        if (chkPHP.isSelected()) {
            msg = msg + chkPHP.getText() + "\n";
            countChk++;
        }
        if (chkPy.isSelected()) {
            msg = msg + chkPy.getText() + "\n";
            countChk++;
        }
        if (countChk > 0) {
            JOptionPane.showMessageDialog(null, msg);
        } else {
            JOptionPane.showMessageDialog(null, "nenhuma linguagem selecionada", ".:Linguagens:.", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limparChk(){
        chkCobol.setSelected(false);
        chkJava.setSelected(false);
        chkPHP.setSelected(false);
        chkPy.setSelected(false);
    }
}
