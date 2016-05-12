
adminApp.controller('vehicleController', function ($scope, $http) {
    $scope.vehicle = {};
    $scope.vehicles = {};
    $scope.form = {};
    $scope.vehicleHidden = false;
    $scope.titleName = "Add Vehicle";
    $scope.vehicleOwners = {};
$scope.getOwnerList = function () {
    $http({
        method: 'GET',
        url: '/ShuttleApp/service/admin/getOwnerList'
    }).then(function mySuccess(response) {

        $scope.vehicleOwners = response.data;
    }, function myError(response) {

        $scope.vehicleOwners = response.statusText;
    });

};

    $scope.hideDialog = function (vehicle, isEdit) {
        $('#datetimepicker1').datetimepicker(
                {   format: 'DD-MMM-YYYY',
                    minDate:new Date(),
                    ignoreReadonly: true,
                    useCurrent: false});
                 $("#datetimepicker1").on("dp.change", function() {
        $scope.selecteddate1 = $("#datetimepicker1").val();
        $scope.vehicle.vehiclePermitEndTime=$scope.selecteddate1;
    });
     $('#datetimepicker2').datetimepicker(
                {   format: 'DD-MMM-YYYY',
                    minDate:new Date(),
                    ignoreReadonly: true,
                    useCurrent: false});
                 $("#datetimepicker2").on("dp.change", function() {
        $scope.selecteddate2 = $("#datetimepicker2").val();
        $scope.vehicle.vehicleInsuranceExpiry=$scope.selecteddate2;
    });

        $scope.vehicleHidden = !$scope.vehicleHidden;
        $scope.vehicle = angular.copy(vehicle);
        $scope.titleName = isEdit ? "Edit Vehicle" : "Add Vehicle";
    };

    $scope.getVehicleList = function () {
        $http({
            method: 'GET',
            url: '/ShuttleApp/service/admin/getVehicleList'
        }).then(function mySuccess(response) {

            $scope.vehicles = response.data;
        }, function myError(response) {

            $scope.vehicles = response.statusText;
        });
    };

    $scope.insertVehicle = function () {
        $http({
            method: 'POST',
            url: '/ShuttleApp/service/addVehicle',
            data: $scope.vehicle,
            headers: {'Content-Type': 'application/html'}
        }).then(function mySuccess(response) {
            
            $scope.vehicle = {};
            $scope.form.vehicleForm.$setPristine();
            $scope.hideDialog();
            $scope.getVehicleList();
        }, function myError(response) {

            response.statusText;
        });
    };
});