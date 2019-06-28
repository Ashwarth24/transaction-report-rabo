<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

    <title>Rabobank Customer Transaction Report</title>

    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <c:url value="/css/main.css" var="jstlCss" />
    <c:url value="/js/angular.min.js" var="angular" />
    <c:url value="/js/ng-file-upload.min.js" var="fileUpload" />
    <c:url value="/js/transactionReportApp.js" var="app" />
    <link href="${jstlCss}" rel="stylesheet" />
    <script src="${angular}"></script>
    <script src="${fileUpload}"></script>
    <script src="${app}"></script>

</head>

<body>

    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="transactionReport">Rabo Bank</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="transactionReport">Transaction Report</a></li>
                    <li><a href="CSVReport">CSV Report</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <h2>Rabobank Customer Transaction Report</h2><br />

        <div id="records" ng-app="transactionReportApp" ng-controller="transactionReportCtrl">

            <form method="POST" action="/upload" enctype="multipart/form-data">
                <input type="text" placeholder='Please select a file....' class="btn btn-default" value="{{SelectedFile.name.toLowerCase()}}" disabled />
                <span class="btn btn-primary btn-file"> Browse <input type="file" name="file" ngf-select="SelectFile($file)"> </span>
                <input type="submit" class="btn btn-primary" value="Upload" ng-click="Upload()" ng-disabled="!uploadStatus" />
            </form>
            <hr />
            <c:if test="${validTransactions.size() > 0}">
                <h4>Valid Tansactions :</h4>
                <table align="center">
                    <tr>
                        <th>Account Number</th>
                        <th>Reference</th>
                        <th>Start Balance</th>
                        <th>Mutation</th>
                        <th>End Balance</th>
                        <th>Description</th>

                    </tr>
                    <c:forEach items="${validTransactions}" var="record">
                        <tr>
                            <td>
                                <c:out value="${record.getAccountNumber()}" />
                            </td>
                            <td>
                                <c:out value="${record.getReference()}" />
                            </td>
                            <td>
                                <c:out value="${record.getStartBalance()}" />
                            </td>
                            <td>
                                <c:out value="${record.getMutation()}" />
                            </td>
                            <td>
                                <c:out value="${record.getEndBalance()}" />
                            </td>
                            <td>
                                <c:out value="${record.getDescription()}" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${inValidTransactions.size() > 0}">
                <h4>InValid Tansactions :</h4>
                <table align="center">
                    <tr>
                        <th>Account Number</th>
                        <th>Reference</th>
                        <th>Start Balance</th>
                        <th>Mutation</th>
                        <th>End Balance</th>
                        <th>Description</th>

                    </tr>
                    <c:forEach items="${inValidTransactions}" var="record">
                        <tr>
                            <td>
                                <c:out value="${record.getAccountNumber()}" />
                            </td>
                            <td>
                                <c:out value="${record.getReference()}" />
                            </td>
                            <td>
                                <c:out value="${record.getStartBalance()}" />
                            </td>
                            <td>
                                <c:out value="${record.getMutation()}" />
                            </td>
                            <td>
                                <c:out value="${record.getEndBalance()}" />
                            </td>
                            <td>
                                <c:out value="${record.getDescription()}" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${errorMessage != null}">
                <span style="color:red">Invalid data. Please upload a valid XML/CSV file!!!!</span>
            </c:if>
        </div>

    </div>
    <!-- /.container -->

    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
<br />

</html>
