
adminApp.controller('routeController', ['$scope', '$http', 'fileUpload', function ($scope, $http, fileUpload) {
        $scope.route = {};
        $scope.routes = {};
        $scope.form = {};
        $scope.imageName = {};
        $scope.routeHidden = false;
        $scope.imageHidden = false;
        $scope.titleName = "Add Route";

        $scope.hideDialog = function (route, isEdit) {
            $scope.routeHidden = !$scope.routeHidden;
            $scope.route = angular.copy(route);
            var i = 0;
            $scope.choices = [];
            $scope.titleName = isEdit ? "Edit Route" : "Add Route";
            if(isEdit){
            
            while (i < route.routeStopsBean.length) {
                $scope.choices.push({'routeStop': route.routeStopsBean[i].routeStop, 'routePrice': route.routeStopsBean[i].routePrice});
                i++;
            }}
        };
        $scope.toggleImage = function (image) {
            $scope.imageName = image;
            $scope.imageHidden = !$scope.imageHidden;
            $scope.titleName = "Route Map";
        };

        $scope.getRouteList = function () {
            $http({
                method: 'GET',
                url: '/ShuttleApp/service/admin/getRouteList'
            }).then(function mySuccess(response) {

                $scope.routes = response.data;
            }, function myError(response) {

                $scope.routes = response.statusText;
            });
        };

        $scope.insertRoute = function () {
            var fd = new FormData();
            var file = $scope.route.myFile;
            var routeCity = $scope.route.routeCity;
            var routeCountry = $scope.route.routeCountry;
            var routeEndLocation = $scope.route.routeEndLocation;
            var routeStartLocation = $scope.route.routeStartLocation;
            var routeState = $scope.route.routeState;
            var routeZone = $scope.route.routeZone;
            var routeStop = angular.toJson($scope.choices);
            fd.append('file', file);
            fd.append('routeCity', routeCity);
            fd.append('routeCountry', routeCountry);
            fd.append('routeEndLocation', routeEndLocation);
            fd.append('routeStartLocation', routeStartLocation);
            fd.append('routeState', routeState);
            fd.append('routeZone', routeZone);
            fd.append('routeStop1', routeStop);
            var uploadUrl = '/ShuttleApp/service/addRoute';
            var resp = fileUpload.uploadFileToUrl(fd, uploadUrl);
            resp.then(function (result) {
                $scope.route = {};
                angular.element("input[type='file']").val(null);
                $scope.form.routeForm.$setPristine();
                $scope.hideDialog();
                $scope.getRouteList();
            }), function myError(response) {
                response.statusText;
            };

        };
        $scope.choices = [];
        $scope.addNewChoice = function () {
            $scope.choices.push({});
        };
        $scope.removeChoice = function (index) {
            $scope.choices.splice(index, 1);
        };
    }]);