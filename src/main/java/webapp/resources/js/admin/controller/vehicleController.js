/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

adminApp.controller('vehicleController',function($scope,$http){
     $scope.vehicle={};
    $scope.vehicleHidden = false;
    $scope.hideDialog = function () {
        $scope.vehicleHidden = !$scope.vehicleHidden;
    };

    $scope.insertVehicle = function () {
        $http({
            method: 'POST',
            url: '/ShuttleApp/service/addVehicle',
            data: $scope.vehicle,
            headers: {'Content-Type': 'application/html'}
        })
                .success(function (data) {
                    if (data.errors) {
                        // Showing errors.
                        $scope.errorName = data.errors.name;
                        $scope.errorUserName = data.errors.username;
                        $scope.errorEmail = data.errors.email;
                    } else {
                        $scope.vehicle = data;
                        $scope.message = data.message;

                    }
                });
    }
    });
