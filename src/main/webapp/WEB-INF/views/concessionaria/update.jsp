<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-edit fa-fw"></i> <b> Update Concessionaria</b></h5> 
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/concessionaria/update" method="POST">
                                    <input type="hidden" name="id" value="${CONCESSIONARIA.id}" />
                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input class="form-control" type="text" name="nome"  value="${CONCESSIONARIA.nome}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="cnpj">Cnpj</label>
                                        <input class="form-control" type="text" name="cnpj"  value="${CONCESSIONARIA.cnpj}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="telefone">Telefone</label>
                                        <input class="form-control" type="text" name="telefone"  value="${CONCESSIONARIA.telefone}" />
                                    </div>     
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Update</button>
                                    <a href="${appPath}/concessionaria/list" class="btn btn-default"><i class="fa fa-close fa-fw"></i>Cancel</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--end content--%>
<%@ include file="/webresources/common/footer.jspf"%>
