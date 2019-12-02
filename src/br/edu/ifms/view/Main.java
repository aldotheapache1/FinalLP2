/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.view;

import br.edu.ifms.controller.AlunoController;
import br.edu.ifms.controller.AreaController;
import br.edu.ifms.controller.CursoController;
import br.edu.ifms.controller.ProfessorController;
import br.edu.ifms.dao.AlunoDao;
import br.edu.ifms.dao.AreaDao;
import br.edu.ifms.dao.CursoDao;
import br.edu.ifms.dao.ProfessorDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) throws SQLException {
        AlunoDao alunoDao = new AlunoDao();
        AlunoView alunoView = new AlunoView();
        AlunoController  alunoController = new AlunoController();
        
        ProfessorDao professorDao = new ProfessorDao();
        ProfessorView professorView = new ProfessorView();
        ProfessorController professorController = new ProfessorController();
        
        CursoDao cursoDao = new CursoDao();
        CursoView cursoView = new CursoView();
        CursoController cursoController = new CursoController();
        
        AreaDao areaDao = new AreaDao();
        AreaView areaView = new AreaView();
        AreaController areaController = new AreaController();
        
        String cpf = "";
        int opcao = 1;
        
   
        
        
        
        while(opcao !=0){
               opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcão desejada:\n "
                        + "1- para salvar;\n 2- para exibir todos;\n 3- remover;\n 4- buscar pelo Nome da pessoa ou id da area;\n 5- editar pelo RA/Siape/ID;\n 0-Parar programa."));
                
                switch (opcao) {

                case 1:
                    int opcao1 = 0;
                     opcao1 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcão desejada: \n"
                        + "1- Aluno; \n2- Professor; \n3- Area; \n4- Curso."));
                    switch (opcao1) {
                        case 1: 
                                alunoDao.salvarBD(alunoView.cadastrar());
                             break;
                        case 2:  
                                professorDao.salvarBD(professorView.cadastrar());
                             break;
                             
                        case 3:
                            areaDao.salvarBD(areaView.inserirDadosArea());
                         
                        case 4:
                            cursoDao.salvarBD(cursoView.cadastrar());
                        default:  //voltar atrás
                             break;
                    }
                    
                break;

                case 2:
                     int opcao2 = 0;
                     opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcão desejada:\n "
                        + "1- Aluno; \n2- Professor; \n3- Area; \n4- Curso."));
                    switch (opcao2) {
                        case 1:
                            alunoController.exibirTodos();
                             break;
                        case 2:  
                             professorController.exibirTodos();
                             break;
                        case 3:
                          areaController.exibirTodos();
                         
                        case 4:
                          cursoController.exibirTodos();
                        default:  //voltar atrás
                             break;
                    }

                break;

                case 3:
                     int opcao3 = 0;
                     opcao3 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcão desejada:\n "
                        + "1- Aluno; \n2- Professor; \n3- Area; \n4- Curso."));
                    switch (opcao3) {
                        case 1: 
                            alunoController.remover();
                             break;
                        case 2: 
                            professorController.remover();
                             break;
                        case 3:
                          areaController.remover();
                         
                        case 4:
                          cursoController.remover();
                             
                        default:  //voltar atrás
                             break;
                    }
                break;
                
                 case 4:
                    int opcao4 = 0;
                     opcao4 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcão desejada: \n"
                        + "1- Aluno; \n2- Professor; \n3- Area; \n4- Curso."));
                    switch (opcao4) {
                        case 1: 
                              
                                alunoController.exibirAluno();
                             break;
                        case 2:  
                            
                                professorController.exibirProfessor();
                             break;
                        case 3:
                          areaController.exibirArea();
                         
                        case 4:
                          cursoController.exibirCurso();
                        default:  //voltar atrás
                             break;
                    }
                    
                break;

                case 5:
                    int opcao5 = 0;
                    int cod = 0;
                     opcao5 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcão desejada: \n"
                        + "1- Aluno; \n2- Professor; \n3- Area; \n4- Curso."));
                    switch (opcao5) {
                        case 1: 
                              
                              alunoController.alterar();
                             break;
                        case 2:  
                           professorController.alterar();
                             break;
                             
                          case 3:
                          areaController.alterar();
                         
                        case 4:
                          cursoController.alterar();
                        default:  //voltar atrás
                             break;
                    }
                    
                break;    
                
                case 0: //parar programa
                    
                break;
            }
        }
  }  
}