
var adminApp = angular.module('adminApp', ['ngRoute']);

adminApp.config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'vehicles.html'
            })
            .when('/vehicles', {
                templateUrl: 'vehicles.html'
            })
            .when('/owner', {
                templateUrl: 'owner.html',
                controller: 'ownerController'
            })
            .when('/routes', {
                templateUrl: 'routes.html'
            })
            .when('/transaction', {
                templateUrl: 'transaction.html'
            })
            .when('/drivers', {
                templateUrl: 'drivers.html',
                controller: 'driverController'
            })
            .otherwise({
                redirectTo: '/ShuttleApp/admin/dashboard.html'
            });

});
