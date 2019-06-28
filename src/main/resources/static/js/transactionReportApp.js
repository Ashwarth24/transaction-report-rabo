
/* Application Module */
var transactionReportApp = angular.module('transactionReportApp', ['ngFileUpload', 'ngRoute']);

transactionReportApp.config(['$routeProvider',

	function ($routeProvider) {

	$routeProvider.when('/frontend', {

	templateUrl: 'frontend1.html',

	controller: 'CSVReportCtrl'

	}).

	when('/backend', {

	templateUrl: 'backend1.html',

	controller: 'transactionReportCtrl'

	}).

	otherwise({

	redirectTo: '/frontend'

	});

	}

	]);

/* This Controller is used to parse the csv data and sort data based on selected colomn */
transactionReportApp.controller('CSVReportCtrl', function($scope, $window, $filter) {

    var sortFlag = false;

    $scope.Upload = function() {
        try {
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv)$/;
            if (regex.test($scope.SelectedFile.name.toLowerCase())) {
                if (typeof(FileReader) != "undefined") {
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        var data = parseCSVData(e.target.result);
                        $scope.$apply(function() {
                            $scope.data = data;
                            $scope.IsVisible = true;
                            $scope.isError = false;
                        });
                    }
                    reader.readAsText($scope.SelectedFile);
                } else {
                    $window.alert("This browser does not support HTML5.");
                }
            } else {
                $window.alert("Please upload a valid CSV file!!!");
                $scope.isError = true;
            }
        } catch (err) {
            $window.alert("Error While Parsing the file : " + err.message);
            $scope.isError = true;
        }
    }

    
    // This method is used to filter the table data by the selected colomn
    $scope.sort = function(sortBy) {
        sortFlag = !sortFlag;
        $scope.data = $filter('orderBy')($scope.data, sortBy, sortFlag);
    }

    $scope.SelectFile = function(file) {
        $scope.SelectedFile = file;
        $scope.uploadStatus = true;
    };

    //This method Parses csv data into an array
    function parseCSVData(csvData) {

        var resultArray = [];
        try {
            var lines = csvData.split("\n");
            var headers = lines[0].split(",");
            for (var i = 1; i < lines.length; i++) {
                var obj = {};
                var currentline = lines[i].split(",");
                for (var j = 0; j < headers.length; j++) {
                    if (currentline.length > 1) {
                        obj[headers[j].split('"').join('').trim().replace(/\s/g, '_')] = currentline[j].split('"').join('');
                    }
                }
                resultArray.push(obj);
            }
        } catch (err) {
            $window.alert("Error While Parsing the file : " + err.message);
            $scope.isError = true;
        }
        return resultArray;
    }
});




/* This Controller is used to validate the file type */
transactionReportApp.controller('transactionReportCtrl', function($scope, $window,  $http) {
	 
	    
	$scope.Upload = function($files) {
        var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.xml)$/;
        if (!regex.test($scope.SelectedFile.name.toLowerCase())) {
            $window.alert("Please upload a valid CSV or XML file!!!");
        }
         else{
        	var fd = new FormData();
            fd.append("file", $scope.SelectedFile["constructor"]);

        /*    $http.post("http://localhost:8080/transaction/report", fd, {
                headers: {'Content-Type': 'multipart/form-data' },
                transformRequest: angular.identity
            })*/
            
            $http.post('http://localhost:8080/transaction/report', fd, {
        transformRequest: function(data, headersGetterFunction) {
            return data;
        },
        headers: { 'Content-Type': 'multipart/form-data' }
        }).then( _success, _error );
        }
    }

	  $scope.SelectFile = function(file) {
	        $scope.SelectedFile = file;
	        $scope.uploadStatus = true;
	    };
    
    function _success(response) {
    	console.log(response.data);
    }

    function _error(response) {
        console.log(response.statusText);
    }
});
