adminApp.controller('ownerController', function ($scope, $http) {
    $scope.owner = {};
    $scope.myWelcome = {};
    $scope.ownerHidden = false;
    $scope.titleName = "Add Owner";


    $scope.hideDialog = function (owner,isEdit) {

        $scope.ownerHidden = !$scope.ownerHidden;
        $scope.owner = owner;

        if (isEdit)
            $scope.titleName = "Edit Owner";
        else
            $scope.titleName = "Add Owner";
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
    };

    $scope.insertOwner = function () {
        $http({
            method: 'POST',
            url: '/ShuttleApp/service/addOwner',
            data: $scope.owner,
            headers: {'Content-Type': 'application/html'}
        }).then(function mySuccess(response) {
            
            $scope.hideDialog();
            $scope.getOwnerList();
            $scope.owner = {};
        }, function myError(response) {
            
            response.statusText;
        });
    };
});