/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


adminApp.controller('selectedFilter',function($scope){
    $scope.selected='dashboard';
    $scope.select=function(index){
        $scope.selected=index;
    }
});