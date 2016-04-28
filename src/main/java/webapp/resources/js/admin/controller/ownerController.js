/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


adminApp.controller('ownerController', function ($scope, $http) {
    $scope.owner = {};
    $scope.myWelcome = {};
    $scope.ownerHidden = false;
    $scope.hideDialog = function () {
        $scope.ownerHidden = !$scope.ownerHidden;
    };
    $scope.getOwnerList = function () {
        $http({
            method: 'GET',
            url: '/ShuttleApp/service/getOwnerList'
        }).then(function mySuccess(response) {
            $scope.myWelcome = response.data;
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });
    }

    $scope.insertOwner = function () {
        $http({
            method: 'POST',
            url: '/ShuttleApp/service/addOwner',
            data: $scope.owner,
            headers: {'Content-Type': 'application/html'}
        }).then(function mySuccess(response) {
            $scope.hideDialog();
            $scope.getOwnerList();
            $scope.owner={};
        }, function myError(response) {
              response.statusText;
        });
    }


});