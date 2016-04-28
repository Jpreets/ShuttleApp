/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


adminApp.controller('driverController', function ($scope, $http) {
    $scope.driver={};
    $scope.driverHidden = false;
    $scope.hideDialog = function () {
        $scope.driverHidden = !$scope.driverHidden;
    };

    $scope.insertDriver = function () {
        $http({
            method: 'POST',
            url: '/ShuttleApp/service/addDriver',
            data: $scope.driver,
            headers: {'Content-Type': 'application/html'}
        })
                .success(function (data) {
                    if (data.errors) {
                        // Showing errors.
                        $scope.errorName = data.errors.name;
                        $scope.errorUserName = data.errors.username;
                        $scope.errorEmail = data.errors.email;
                    } else {
                        $scope.driver = data;
                        $scope.message = data.message;

                    }
                });
    }
});