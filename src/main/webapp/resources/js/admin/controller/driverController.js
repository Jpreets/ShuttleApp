adminApp.controller('driverController', ['$scope', '$http', 'fileUpload', function ($scope, $http, fileUpload) {
        $scope.driver = {};
        $scope.driverList = {};
        $scope.form = {};
        $scope.driverHidden = false;
        $scope.titleName = "Add Driver";
        $scope.driver.userId=0;
        $scope.hideDialog = function (driver, isEdit) {
            
            $scope.driverHidden = !$scope.driverHidden;
            $scope.driver = angular.copy(driver);
            $scope.titleName = isEdit ? "Edit Driver" : "Add Driver";
            $scope.driver.userId=isEdit? $scope.driver.userId:0;
        };

        $scope.toggleImage = function (image, title) {
            if (title === 'License') {
                $scope.imageName = 'driverLicense/' + image;
            } else if (title === 'Photo') {
                $scope.imageName = 'driverPhoto/' + image;
            } else {
                $scope.imageName = 'driverIdProof/' + image;
            }

            $scope.imageHidden = !$scope.imageHidden;
            $scope.titleName = title;
        };

        $scope.toggleResult = function (result) {
            $scope.result = result;
            $scope.resultHidden = !$scope.resultHidden;
            $scope.titleName = "";
        };

        $scope.getDriverList = function () {
            $http({
                method: 'GET',
                url: '/ShuttleApp/service/admin/getDriverList'
            }).then(function mySuccess(response) {

                $scope.driverList = response.data;
            }, function myError(response) {

                $scope.driverList = response.statusText;
            });
        };

        $scope.insertDriver = function () {
            var fd = new FormData();
            var license = $scope.driver.license;
            var idProof = $scope.driver.idProof;
            var photo = $scope.driver.photo;
            var userName = $scope.driver.userName;
            var userEmail = $scope.driver.userEmail;
            var userAddress = $scope.driver.userAddress;
            var userCity = $scope.driver.userCity;
            var userCountry = $scope.driver.userCountry;
            var userState = $scope.driver.userState;
            var userContact = $scope.driver.userContact;
            var userId=$scope.driver.userId;

            fd.append('license', license);
            fd.append('idProof', idProof);
            fd.append('photo', photo);
            fd.append('userName', userName);
            fd.append('userEmail', userEmail);
            fd.append('userAddress', userAddress);
            fd.append('userContact', userContact);
            fd.append('userCity', userCity);
            fd.append('userCountry', userCountry);
            fd.append('userState', userState);
            fd.append('userId', userId);

            var uploadUrl = '/ShuttleApp/service/addDriver';
            var resp = fileUpload.uploadFileToUrl(fd, uploadUrl);
            resp.then(function (result) {
                if (result.data === 'success') {
                    $scope.driver = {};
                    angular.element("input[type='file']").val(null);
                    $scope.form.driverForm.$setPristine();
                    $scope.hideDialog();
                    $scope.getDriverList();
                } else {
                    $scope.result = result.data;
                }

            }), function myError(response) {
                response.statusText;
            };

        };
    }]);