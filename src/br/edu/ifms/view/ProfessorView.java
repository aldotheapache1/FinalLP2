/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.view;

import br.edu.ifms.model.ProfessorModel;
import javax.swing.JOptionPane;


public class ProfessorView {
    public ProfessorModel cadastrar(){
        ProfessorModel professor = new ProfessorModel();
        
        professor.setNome(JOptionPane.showInputDialog(null, "Informe o nome do Professor:"));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a idade do Professor:")));
        professor.setCpf(JOptionPane.showInputDialog(null, "Informe o CPF do Professor:"));
        professor.setSexo(JOptionPane.showInputDialog(null, "Informe o sexo do Professor:"));
        professor.setSiape(Long.parseLong(JOptionPane.showInputDialog(null, "Informe o SIAPE do Professor:")));
        return professor;
    }
    
      public ProfessorModel alterar(ProfessorModel professor){
        professor.setNome(JOptionPane.showInputDialog(null, "Informe o nome do Professor:"));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a idade do Professor:")));
        professor.setCpf(JOptionPane.showInputDialog(null, "Informe o CPF do Professor:"));
        professor.setSexo(JOptionPane.showInputDialog(null, "Informe o sexo do Professor:"));
        return professor;
    }
    
    public long remover(){
        return Long.parseLong(JOptionPane.showInputDialog(null, "Informe o SIAPE do professor:"));
    }
    
    public long buscar(){
        return Long.parseLong(JOptionPane.showInputDialog(null, "Informe o SIAPE do professor:"));
    }
    
    public void exibirDados(ProfessorModel professor){
        JOptionPane.showMessageDialog(null, professor.toString(), "Exibir Professores", JOptionPane.INFORMATION_MESSAGE);
    }
}
   
