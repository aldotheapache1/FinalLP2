/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.view;

import br.edu.ifms.model.CursoModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian
 */
public class CursoView {
    public CursoModel cadastrar(){
        CursoModel curso = new CursoModel();
        
        curso.setTitulo(JOptionPane.showInputDialog("Informe o curso: "));
        curso.setDescricao(JOptionPane.showInputDialog("Informe a descrição: "));
        curso.setQuantidadeDeVagas(Integer.parseInt(JOptionPane.showInputDialog( "Informe a quantidade de vagas:")));
        
        return curso;
    }
    
    public CursoModel alterar(CursoModel curso){
        curso.setTitulo(JOptionPane.showInputDialog("Informe o curso: " ));
        curso.setDescricao(JOptionPane.showInputDialog("Informe a descrição: "));
        curso.setQuantidadeDeVagas(Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vagas:")));
        
        return curso;
    }
    
    public long remover(){
        return Long.parseLong(JOptionPane.showInputDialog( "Informe o id do Curso:"));
    }
    
    public long buscar(){
        return Long.parseLong(JOptionPane.showInputDialog( "Informe o id do Curso:"));
    }
    
    public void exibirDados(CursoModel curso){
        JOptionPane.showMessageDialog(null, curso.toString(), "Exibir Cursos", JOptionPane.INFORMATION_MESSAGE);
    }
}
