/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.dao.AlunoDao;
import br.edu.ifms.model.AlunoModel;
import br.edu.ifms.view.AlunoView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class AlunoController {
    AlunoDao alunos = new AlunoDao();
    AlunoView alunoView = new AlunoView();
    
    public void salvar() throws SQLException{
        try{
        alunos.salvarBD(alunoView.cadastrar());
        sucesso("Aluno Salvo");
        }catch(Exception erro){
            erro(erro);
        }
    }
    
    public void exibirTodos() throws SQLException{
        List<AlunoModel> lista = alunos.buscarTodosBD();
        for(AlunoModel aluno : lista){
            alunoView.exibirDados(aluno);
        }
    }
    
    public void exibirAluno() throws SQLException{
        alunoView.exibirDados(alunos.buscarAlunoPorRaBD(alunoView.buscar()));
    }
    
    public void remover() throws SQLException{
        try{
            alunos.removerBD(alunoView.remover());
            sucesso("Aluno Removido");
        }catch(Exception e){
            erro(e);
        }
    }
    
    public void alterar(){
        try{
            alunos.alterarBD(alunoView.alterar(alunos.buscarAlunoPorRaBD(alunoView.buscar())));
            sucesso("Aluno alterado");
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
