/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.view;

import br.edu.ifms.controller.CursoController;
import br.edu.ifms.dao.CursoDao;
import br.edu.ifms.model.AlunoModel;
import javax.swing.JOptionPane;


public class AlunoView {
    public AlunoModel cadastrar(){
        AlunoModel aluno = new AlunoModel();

        
        aluno.setNome(JOptionPane.showInputDialog(null, "Informe o nome do aluno:"));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a idade do aluno:")));
        aluno.setCpf(JOptionPane.showInputDialog(null, "Informe o CPF do aluno:"));
        aluno.setSexo(JOptionPane.showInputDialog(null, "Informe o sexo do aluno:"));
        aluno.setRa(Long.parseLong(JOptionPane.showInputDialog(null, "Informe o RA do aluno:")));
        return aluno;
    }
    
     public AlunoModel alterar(AlunoModel aluno){
        aluno.setNome(JOptionPane.showInputDialog(null, "Informe o nome do aluno:"));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a idade do aluno:")));
        aluno.setCpf(JOptionPane.showInputDialog(null, "Informe o CPF do aluno:"));
        aluno.setSexo(JOptionPane.showInputDialog(null, "Informe o sexo do aluno:"));
        
        return aluno;
    }
    
    public long remover(){
        return Long.parseLong(JOptionPane.showInputDialog(null, "Informe o RA do aluno:"));
    }
    
    public long buscar(){
        return Long.parseLong(JOptionPane.showInputDialog(null, "Informe o RA do aluno:"));
    }
    
    public void exibirDados(AlunoModel aluno){
        JOptionPane.showMessageDialog(null, aluno.toString(), "Exibir Alunos", JOptionPane.INFORMATION_MESSAGE);
    }
    
     public void erro(Exception mensagem){
        JOptionPane.showMessageDialog(null, mensagem.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
