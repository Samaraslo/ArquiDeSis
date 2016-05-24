<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Criar Curso Artes</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />
    
</head>
<body>
<c:import url="Menu.jsp"/>
<div id="imagemArtes" class="col-md-3 imagem"></div>
	<div id="main" class="container">
        <h3 class="titlePageIncluir">Incluir Curso</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome do curso">
                </div>
                <div class="form-group col-md-6">
                    <label for="rg">Valor</label>
                    <input type="text" class="form-control" name="valor" id="valor" required maxlength="60">
                </div>
            </div>         
              <div class="row">
                <div class="form-group col-md-6">
                    <label for="login">Descrição do material</label>
                    <textarea class="form-control" name="descMaterial" id="descMaterial"></textarea>
                </div>
                <div class="form-group col-md-6">
                    <label for="senha">Livros utilizados</label>
                    <textarea class="form-control" name="livrosUtilizados" id="livrosUtilizados" ></textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="endereco">Data início</label>
                    <div id="datetimepicker1" class="input-append date">
                    	<input data-format="dd/MM/yyyy hh:mm:ss" type="text" class="form-control" name="dataInicio" id="dataInicio">
                    	<span class="add-on">
     						<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
    					</span>
                    </div>
                </div>
                <div class="form-group col-md-4">
                    <label for="telefone">Data Término</label>
                    <input type="tel" class="form-control" name="dataTermino" id="dataTermino" required maxlength="60">
                </div>
                 <div class="form-group col-md-4">
                    <label for="cpf">Horário</label>
                    <input type="text" class="form-control" name="horario" id="horario" required maxlength="60">
                </div>
           </div>
            <div class="row">
            	<div class="form-group col-md-6">
                    <label for="email">Número de vagas</label>
                    <input type="text" class="form-control" name="numVagas" id="numVagas" required maxlength="60">
                </div>
                <div class="form-group col-md-6">
                    <label for="senha">Disponibilidade</label>
                    <input type="text" class="form-control" name="disponibilidade" id="disponibilidade" required >
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarCursoArtes">Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>  
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
	    $('#datetimepicker1').datetimepicker({
	    	format: 'dd/mm/yyyy',
	      language: 'pt-BR'
	    });
	  });
	</script>
</body>
</html>