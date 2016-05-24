<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Alterar Curso Artes</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>
		 <body>
                <!-- Barra superior com os menus de navega��o -->
				
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Curso Artes #${artes.id }</h3>
                    <!-- Formulario para altera��o de clientes -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${artes.id }" />
                       <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome do curso" value=${artes.nome }>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Data in�cio</label>
                    <input type="text" class="form-control" name="dataInicio" id="dataInicio" value=${artes.dataInicio }>
                </div>
           </div>
			<div class="row">
                <div class="form-group col-md-6">
                    <label for="telefone">Data T�rmino</label>
                    <input type="tel" class="form-control" name="dataTermino" id="dataTermino" required value=${artes.dataTermino }>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="cpf">Hor�rio</label>
                    <input type="text" class="form-control" name="horario" id="horario" required value=${artes.horario }>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="email">N�mero de vagas</label>
                    <input type="text" class="form-control" name="numVagas" id="numVagas" required value=${artes.numeroVagas }>
                </div>
            </div>
           
             <div class="row">
                <div class="form-group col-md-6">
                    <label for="rg">Valor</label>
                    <input type="text" class="form-control" name="valor" id="valor" required value=${artes.valor }>
                </div>
            </div>
            
              <div class="row">
                <div class="form-group col-md-6">
                    <label for="login">Descri��o do material</label>
                    <input type="text" class="form-control" name="descMaterial" id="descMaterial" required value=${artes.descricaoMaterial }>
                </div>
            </div>
             <div class="row">
                <div class="form-group col-md-6">
                    <label for="senha">Livros utilizados</label>
                    <input type="text" class="form-control" name="livrosUtilizados" id="livrosUtilizados" value=${artes.descricaoMaterial } >
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="senha">Disponibilidade</label>
                    <input type="text" class="form-control" name="disponibilidade" id="disponibilidade" required value=${artes.disponibilidade }>
                </div>
            </div>

                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarCursoArtes">Salvar</button>
                                <a href="ListarCursoArtes.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>