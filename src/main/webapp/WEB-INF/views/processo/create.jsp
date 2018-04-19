<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-plus-square fa-fw"></i> <b> Create a new Processo </b></h5>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/processo/new" method="POST">
                                    <div class="form-group">
                                        <label for="protocolo">Protocolo</label>
                                        <input class="form-control" type="text" name="protocolo" path="protocolo"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input class="form-control" type="text" name="nome" path="nome"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="observacoes">Observacoes</label>
                                        <input class="form-control" type="text" name="observacoes" path="observacoes"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="status">Status</label>
                                        <input class="form-control" type="text" name="status" path="status"  />
                                    </div>
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Submit</button>
                                    <a href="${appPath}/processo/list" class="btn btn-default"><i class="fa fa-close fa-fw"></i>Cancel</a>
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
