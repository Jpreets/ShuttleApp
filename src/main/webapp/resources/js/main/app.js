/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var shuttleApp = angular.module('mainApp', ['ngRoute', 'ngAnimate']);

shuttleApp.config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'welcome.html',
                controller: 'welcomeController'
            })
            .when('/login', {
                templateUrl: 'common/login.html',
                controller: 'welcomeController'
            })
            .when('/forgetpassword', {
                templateUrl: 'common/forgetPassword.html',
                controller: 'welcomeController'
            })
            .when('/invalidAccess', {
                templateUrl: 'invalidAccess.html',
                controller: 'errorController'
            })
            .otherwise({
                redirectTo: '/invalidAccess'
            });
    ;

});