<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-plus-square fa-fw"></i> <b> Create a new Anexo Denuncia </b></h5>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/anexoDenuncia/new" method="POST">
                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input class="form-control" type="text" name="nome" path="nome"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="caminho">Caminho</label>
                                        <input class="form-control" type="text" name="caminho" path="caminho"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="extencao">Extencao</label>
                                        <input class="form-control" type="text" name="extencao" path="extencao"  />
                                    </div>
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Submit</button>
                                    <a href="${appPath}/anexoDenuncia/list" class="btn btn-default"><i class="fa fa-close fa-fw"></i>Cancel</a>
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