<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <title>Rabobank Customer Transaction Report</title>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

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
                    <li><a href="transactionReport">Transaction Report</a></li>
                    <li class="active"><a href="CSVReport">CSV Report</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <h2>Rabobank Customer Transaction Report</h2><br />
        <div id="records" ng-app="transactionReportApp" ng-controller="CSVReportCtrl">
            <input type="text" placeholder='Please select a file....' class="btn btn-default" value="{{SelectedFile.name.toLowerCase()}}" disabled />

            <span class="btn btn-primary btn-file"> Browse <input type="file" ngf-select="SelectFile($file)">
            </span>
            <input type="button" class="btn btn-primary" value="Upload" ng-click="Upload()" ng-disabled="!uploadStatus" />
            <hr />
            <table id="tblRecords" cellpadding="0" cellspacing="0" align="center" ng-show="IsVisible">
                <tr>
                    <th class ng-repeat="(header,value) in data[0]" ng-click="sort(header)">{{header}} <span class="fa fa-sort"></span></th>
                </tr>
                <tbody>
                    <tr ng-repeat="row in data">
                        <td ng-repeat="cell in row">{{cell}}</td>
                    </tr>
                </tbody>
            </table>
            <span style="color:red" ng-show="isError">Please upload a valid CSV file!!!!</span>
        </div>
    </div>
    <!-- /.container -->
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
