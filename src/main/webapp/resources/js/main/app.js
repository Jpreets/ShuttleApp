var shuttleApp = angular.module('mainApp', ['ngRoute', 'ngAnimate','ui.bootstrap']);

shuttleApp.config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'welcome.html',
                controller: 'welcomeController'
            })
            .when('/invalidAccess', {
                templateUrl: 'invalidAccess.html',
                controller: 'errorController'
            })
            .otherwise({
                redirectTo: '/invalidAccess'
            });
}); 