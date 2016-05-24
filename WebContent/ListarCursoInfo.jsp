<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Curso de Informática</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

        </head>
        
        <body>
            <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Curso de Informática</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este curso?
                        </div>
                        <div class="modal-footer">
                            <form action="controller.do" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-primary" name="command" value="ExcluirCursoInfo">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <c:import url="Menu.jsp"/>
            <div id="main" class="container-fluid">
                <form action="controller.do" method="post">
                    <div id="top" class="row">
                        <div id="imagemInformatica" class="col-md-3 imagem"></div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar cursos (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="command" value="ListarCursoInfoBuscar">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="CriarCursoInfo.jsp" class="btn btn-primary pull-right h2">Novo Curso de Informática</a>
                        </div>
                    </div>
                    <h2>Informática</h2>
                    <!-- /#top -->
                </form>
                <hr />
                <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Data de início</th>
                                    <th>Data Final</th>
                                    <th>Horário</th>
                                    <th>Número de vagas</th>
                                    <th>Valor</th>
                                    <th>Descrição do software</th>
                                    <th>Nº Lab</th>
                                    <th>Disponibilidade</th>
                                    
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                            
                            	<c:forEach var="info" items="${lista}">
                                       <tr>
                                            <td>
                                               ${info.id}
                                            </td>
                                            <td>
                                                ${info.nome}
                                            </td>
                                            <td>
                                                ${info.dataInicio}
                                            </td>
                                            <td>
                                                ${info.dataTermino}
                                            </td>
                                            
                                            <td>
                                                ${info.horario}
                                            </td>
                                            <td>
                                                ${info.numeroVagas}
                                            </td>
                                            <td>
                                                ${info.valor}
                                            </td>
                                            <td>
                                                ${info.descricaoSoft}
                                            </td>
                                            <td>
                                                ${info.numeroLab}
                                            </td>
                                            <td>
                                                ${info.disponibilidade}
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs glyphicon glyphicon-search" title="Visualizar" href="controller.do?command=VisualizarCursoInfo&id=${info.id }"></a>
                                                <a class="btn btn-warning btn-xs glyphicon glyphicon-pencil" title="Editar" href="controller.do?command=EditarCursoInfo&id=${info.id }"></a>
                                                <button id="btn${info.id}%>" type="button" title="Excluir" class="btn btn-danger btn-xs glyphicon glyphicon-remove" data-toggle="modal" data-target="#delete-modal" data-cliente="${info.id }"></button>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                	<div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
                </c:if>
              </div>
        </html>
        