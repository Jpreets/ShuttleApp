/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var adminApp = angular.module('adminApp', ['ngRoute']);

adminApp.config(function ($routeProvider, $locationProvider) {
    $routeProvider
            .when('/ShuttleApp/admin/vehicles', {
                templateUrl: 'vehicles.html'
            })
            .when('/ShuttleApp/admin/owner', {
                templateUrl: 'owner.html',
                controller:'ownerController'
            })
            .when('/ShuttleApp/admin/routes', {
                templateUrl: 'routes.html'
            })
            .when('/ShuttleApp/admin/transaction', {
                templateUrl: 'transaction.html'
            })
            .when('/ShuttleApp/admin/drivers', {
                templateUrl: 'drivers.html',
                controller:'driverController'
            })
            .otherwise({
                redirectTo: '/ShuttleApp/admin/dashboard.html'
            });
    $locationProvider.html5Mode({
            enabled: false,
            requireBase: true
        });

});