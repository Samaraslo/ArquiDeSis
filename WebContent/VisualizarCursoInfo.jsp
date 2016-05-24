<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Visualizar Curso Infomática</title>

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
                                <h4 class="modal-title" id="modalLabel">Excluir curso</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir este curso?
                            </div>
                            <div class="modal-footer">
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="id" value="${info.id }" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirCursoInfo">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <!-- Barra superior com os menus de navegação -->
                <c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Visualizar Curso #${info.id}</h3>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Nome</strong>
                            </p>
                            <p>
                                ${info.nome }
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Data início</strong>
                            </p>
                            <p>
                                ${info.dataInicio }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Data Término</strong>
                            </p>
                            <p>
                                ${info.dataTermino }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Horário</strong>
                            </p>
                            <p>
                                ${info.horario }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Número de vagas</strong>
                            </p>
                            <p>
                                ${info.numeroVagas }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Valor</strong>
                            </p>
                            <p>
                                ${info.valor }
                            </p>
                        </div>
                         <div class="col-md-6">
                            <p><strong>Descrição do software</strong>
                            </p>
                            <p>
                                ${info.descricaoSoft }
                            </p>
                        </div>
                         <div class="col-md-6">
                            <p><strong>Número do laboratório</strong>
                            </p>
                            <p>
                                ${info.numeroLab }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Disponibilidade</strong>
                            </p>
                            <p>
                                ${info.disponibilidade }
                            </p>
                        </div>
                    </div>
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EditarCursoInfo&id=${info.id }" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="ListarCursoInfo.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>