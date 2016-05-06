
adminApp.directive('formmodal', function () {
    return {
        transclude: true,
        replace:true,
        templateUrl: '/ShuttleApp/common/formmodal.html',
        restrict: 'E',
        scope: true,
        link: function (scope, element, attrs) {

            scope.$watch(attrs.visible, function (value) {
             
                if (value == true)
                    $(element).modal('show');
                else
                    $(element).modal('hide');
            });
            
             scope.$watch(attrs.title, function (value) {
                 scope.title = value;
                
            });
            
            $('body').on('visibles.bs.modal', function () {
                scope.$apply(function () {
                    scope.$parent[attrs.visible] = true;
                });
            });

            $('body').on('hidden.bs.modal', function () {
                scope.$apply(function () {
                    scope.$parent[attrs.visible] = false;
                });
            });
        }
    }
});