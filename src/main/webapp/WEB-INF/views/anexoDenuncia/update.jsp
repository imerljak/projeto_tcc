<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-edit fa-fw"></i> <b> Update Anexo Denuncia</b></h5> 
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/anexoDenuncia/update" method="POST">
                                    <input type="hidden" name="id" value="${ANEXO_DENUNCIA.id}" />
                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input class="form-control" type="text" name="nome"  value="${ANEXO_DENUNCIA.nome}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="caminho">Caminho</label>
                                        <input class="form-control" type="text" name="caminho"  value="${ANEXO_DENUNCIA.caminho}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="extencao">Extencao</label>
                                        <input class="form-control" type="text" name="extencao"  value="${ANEXO_DENUNCIA.extencao}" />
                                    </div>     
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Update</button>
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
