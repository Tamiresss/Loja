/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoLoja;
import javax.swing.JOptionPane;
import modelo.Loja;
import tela.manutencao.ManutencaoLoja;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class ControladorLoja {

    public static void inserir(ManutencaoLoja man){
        Loja objeto = new Loja();
        objeto.setNome(man.jtfNome.getText());
        objeto.setNrfuncionarios(Integer.parseInt(man.jtfNrfuncionarios.getText()));
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setValorbolsa(Double.parseDouble(man.jtfValorbolsa.getText()));
        
        boolean resultado = DaoLoja.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoLoja man){
        Loja objeto = new Loja();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setNrfuncionarios(Integer.parseInt(man.jtfNrfuncionarios.getText()));
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setValorbolsa(Double.parseDouble(man.jtfValorbolsa.getText()));
        
        boolean resultado = DaoLoja.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(ManutencaoLoja man){
        Loja objeto = new Loja();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoLoja.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Número de funcionários");
        modelo.addColumn("Data");
        modelo.addColumn("Valor na bolsa");
        List<Loja> resultados = DaoLoja.consultar();
        for (Loja objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getNrfuncionarios());
            linha.add(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getValorbolsa());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoLoja man, int pk){ 
        Loja objeto = DaoLoja.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNome.setText(objeto.getNome());
        man.jtfNrfuncionarios.setText(objeto.getNrfuncionarios().toString());
        man.jtfData.setText(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfValorbolsa.setText(objeto.getValorbolsa().toString());
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
}
