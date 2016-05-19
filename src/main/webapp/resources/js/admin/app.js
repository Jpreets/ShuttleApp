var adminApp = angular.module('adminApp', ['ngRoute']);
adminApp.config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'report.html'

            })
            .when('/vehicles', {
                templateUrl: 'vehicles.html',
                controller: 'vehicleController'
            })
            .when('/owner', {
                templateUrl: 'owner.html',
                controller: 'ownerController'
            })
            .when('/routes', {
                templateUrl: 'routes.html',
                controller: 'routeController'
            })
            .when('/transaction', {
                templateUrl: 'transaction.html'
            })
            .when('/drivers', {
                templateUrl: 'drivers.html',
                controller: 'driverController'
            })
            .when('/customers', {
                templateUrl: 'customers.html',
                controller: 'customerController'
            })
            .otherwise({
                redirectTo: '/ShuttleApp/admin/dashboard.html'
            });

});
