/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.view;


import br.edu.ifms.model.AreaModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian
 */
public class AreaView {
   public AreaModel inserirDadosArea(){
         AreaModel area = new AreaModel();
        
        area.setDescricao(JOptionPane.showInputDialog("Informe a área: "));
        
        return area;
     }
   
   public void exibirDados(AreaModel area){
        JOptionPane.showMessageDialog(null, area.toString(), "Exibir Áreas", JOptionPane.INFORMATION_MESSAGE);
    }

      public long remover(){
        return Long.parseLong(JOptionPane.showInputDialog( "Informe o id da Área:"));
    }
     
      public Long insereID(){
       
        return  Long.parseLong(JOptionPane.showInputDialog("Informe o ID da area que você deseja buscar"));
        }
      
     public AreaModel alterar(AreaModel area){
        area.setDescricao(JOptionPane.showInputDialog(null, "Informe a descricao da área: "));
        
        return area;
    }
}