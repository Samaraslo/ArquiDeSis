<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Alterar Aluno</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>
		 <body>
                <!-- Barra superior com os menus de navegação -->
				
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Aluno #${aluno.id }</h3>
                    <!-- Formulario para alteração de clientes -->
                    <form action="ManterAluno.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${aluno.id }" />
                        <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value=${aluno.nome }>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Endereco</label>
                    <input type="text" class="form-control" name="endereco" id="endereco" value=${aluno.endereco }>
                </div>
           </div>
			<div class="row">
                <div class="form-group col-md-6">
                    <label for="telefone">Telefone</label>
                    <input type="tel" class="form-control" name="telefone" id="telefone" required maxlength="60" placeholder="telefone obrigatório" value=${aluno.telefone }>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control" name="cpf" id="cpf" required maxlength="60" placeholder="cpf obrigatório" value=${aluno.cpf }>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="email">E-mail</label>
                    <input type="text" class="form-control" name="email" id="email" required maxlength="60" placeholder="email obrigatório" value=${aluno.email }>
                </div>
            </div>
           
             <div class="row">
                <div class="form-group col-md-6">
                    <label for="rg">RG</label>
                    <input type="text" class="form-control" name="rg" id="rg" required maxlength="60" placeholder="rg obrigatório" value=${aluno.rg }>
                </div>
            </div>
            
              <div class="row">
                <div class="form-group col-md-6">
                    <label for="login">LOGIN</label>
                    <input type="text" class="form-control" name="login" id="login" required maxlength="60" placeholder="login obrigatório" value=${aluno.login }>
                </div>
            </div>
             <div class="row">
                <div class="form-group col-md-6">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" name="senha" id="senha" required value=${aluno.senha }>
                </div>
            </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="acao" value="Alterar">Salvar</button>
                                <a href="ListarAlunos.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>