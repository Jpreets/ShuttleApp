
adminApp.controller('driverController', function ($scope, $http) {
    $scope.driver={};
    $scope.driverHidden = false;
    $scope.hideDialog = function () {
        $scope.driverHidden = !$scope.driverHidden;
    };

    $scope.insertDriver = function () {
        $http({
            method: 'POST',
            url: '/ShuttleApp/service/admin/addDriver',
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
    };
});