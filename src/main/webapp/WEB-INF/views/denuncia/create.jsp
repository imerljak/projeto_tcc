<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-plus-square fa-fw"></i> <b> Create a new Denuncia </b></h5>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/denuncia/new" method="POST">
                                    <div class="form-group">
                                        <label for="reclamacao">Reclamacao</label>
                                        <input class="form-control" type="text" name="reclamacao" path="reclamacao"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="ocorrencia">Ocorrencia</label>
                                        <input class="form-control" type="text" name="ocorrencia" path="ocorrencia"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="dataOcorrencia">Data Ocorrencia</label>
                                        <input class="form-control" type="text" name="dataOcorrencia" path="dataOcorrencia"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="localOcorrencia">Local Ocorrencia</label>
                                        <input class="form-control" type="text" name="localOcorrencia" path="localOcorrencia"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="sugestao">Sugestao</label>
                                        <input class="form-control" type="text" name="sugestao" path="sugestao"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="providencia">Providencia</label>
                                        <input class="form-control" type="text" name="providencia" path="providencia"  />
                                    </div>
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Submit</button>
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
