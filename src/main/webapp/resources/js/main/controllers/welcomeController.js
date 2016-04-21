
shuttleApp.controller('welcomeController', function ($scope) {
    $scope.$on('$viewContentLoaded', function () {
        if (window.location.href.indexOf("login") > -1) {
            $('#loginModal').modal('show');
        } else if (window.location.href.indexOf("forgot") > -1)
        {
            $('#forgotPasswordModal').modal('show');
        }
    });
    $scope.pageClass = 'home';

    $scope.login = function () {
        $('#loginModal').modal('show');
    };
    $scope.forgot = function () {
        $('#forgotPasswordModal').modal('show');
    };

});