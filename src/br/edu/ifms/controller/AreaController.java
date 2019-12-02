/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;


import br.edu.ifms.dao.AreaDao;
import br.edu.ifms.model.AreaModel;


import br.edu.ifms.view.AreaView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian
 */
public class AreaController {
    AreaDao area = new AreaDao();
    AreaView areaView = new AreaView();
    
    public void salvar() throws SQLException{
       try{
           area.salvarBD(areaView.inserirDadosArea());
           sucesso("Área salva");
        }catch(Exception erro){
            erro(erro);
        }
    }
    
    public void exibirTodos() throws SQLException{
        List<AreaModel> lista = area.buscarTodosBD();
        for(AreaModel area : lista){
            areaView.exibirDados(area);
        }
    }
    
    public void alterar(){
        try{
            area.alterarBD(areaView.alterar(area.buscarAreaPorIdBD(areaView.insereID())));
            sucesso("Área alterada");
        }catch(Exception erro){
            erro(erro);
        }
    }
    
    public void exibirArea() throws SQLException{
        areaView.exibirDados(area.buscarAreaPorIdBD(areaView.insereID()));
    }
    
    public void remover() throws SQLException{
        try{
        area.removerBD(area.buscarAreaPorIdBD(areaView.remover()));
         sucesso("Área removida");
        }catch(Exception erro){
            erro(erro);
        }
    }
        
    
     public void erro(Exception mensagem){
        JOptionPane.showMessageDialog(null, mensagem.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}

