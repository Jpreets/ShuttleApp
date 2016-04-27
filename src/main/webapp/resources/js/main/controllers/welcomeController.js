
shuttleApp.controller('welcomeController', function ($scope) {
    $scope.$on('$viewContentLoaded', function () {
        if (window.location.href.indexOf("login") > -1) {
            $('#loginModal').modal('show');
        } else if (window.location.href.indexOf("forgot") > -1)
        {
            $('#forgotPasswordModal').modal('show');
        } else if (window.location.href.indexOf("error") > -1)
        {
            $('#errorModal').modal('show');
            $('<p>' + getURLParameter("errorMsg") + '</p>').appendTo('#errorBody');

        } else if (window.location.href.indexOf("changePassword") > -1) {
            $('#changePasswordModal').modal('show');
            document.getElementById("email").value = getURLParameter("email");
            document.getElementById("key").value = getURLParameter("id");
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
function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [, ""])[1].replace(/\+/g, '%20')) || null;
}


