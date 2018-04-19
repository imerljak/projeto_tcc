<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-edit fa-fw"></i> <b> Update Denuncia</b></h5> 
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/denuncia/update" method="POST">
                                    <input type="hidden" name="id" value="${DENUNCIA.id}" />
                                    <div class="form-group">
                                        <label for="reclamacao">Reclamacao</label>
                                        <input class="form-control" type="text" name="reclamacao"  value="${DENUNCIA.reclamacao}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="ocorrencia">Ocorrencia</label>
                                        <input class="form-control" type="text" name="ocorrencia"  value="${DENUNCIA.ocorrencia}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="dataOcorrencia">Data Ocorrencia</label>
                                        <input class="form-control" type="text" name="dataOcorrencia"  value="${DENUNCIA.dataOcorrencia}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="localOcorrencia">Local Ocorrencia</label>
                                        <input class="form-control" type="text" name="localOcorrencia"  value="${DENUNCIA.localOcorrencia}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="sugestao">Sugestao</label>
                                        <input class="form-control" type="text" name="sugestao"  value="${DENUNCIA.sugestao}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="providencia">Providencia</label>
                                        <input class="form-control" type="text" name="providencia"  value="${DENUNCIA.providencia}" />
                                    </div>     
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Update</button>
                                    <a href="${appPath}/denuncia/list" class="btn btn-default"><i class="fa fa-close fa-fw"></i>Cancel</a>
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
