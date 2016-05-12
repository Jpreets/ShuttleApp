adminApp.service('fileUpload', ['$http', function ($http) {
        this.uploadFileToUrl = function (fd, uploadUrl) {
            return $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}});
        };
    }]);