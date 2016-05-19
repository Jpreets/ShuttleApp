adminApp.controller('customerController', function ($scope, $http) {
    $scope.customer = {};
    $scope.customerList = {};

    $scope.getCustomerList = function () {
        $http({
            method: 'GET',
            url: '/ShuttleApp/service/admin/getCustomerList'
        }).then(function mySuccess(response) {

            $scope.customerList = response.data;
        }, function myError(response) {

            $scope.customerList = response.statusText;
        });
    };
});