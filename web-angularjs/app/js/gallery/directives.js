/**
 * Created by Aleksej_home on 2016.02.17..
 */
/*
var galleryDirectives = angular.module('galleryDirectives', []);



galleryDirectives.directive('pageScp',[function(){
    return {
        restrict:'AE',
        scope:{items:"="}, //<-- data bound from parent scope via attribute
        template:'<div><ul><li ng-mouseenter="toggleClass(true)" ng-mouseleave="toggleClass(false)"' +
        ' ng-class="{\'highlight\': action.deleteicon}" ' +
        'ng-repeat="item in items">{{item.name}}</li></ul></div>', //of course in real case it will be use ng-repeat
        link:function(scope,element,attr){
            scope.action = {deleteicon :true};
            scope.toggleClass = function(show){
                scope.action.deleteicon = show;
            }
        }
    }
}]);




galleryDirectives.directive('pageDirective',function(){
    return {
        restrict:'AE',
        scope:{items:"="}, //<-- data bound from parent scope via attribute
        template:'<div><ul><li ng-mouseenter="toggleClass(true)" ng-mouseleave="toggleClass(false)"' +
        ' ng-class="{\'highlight\': action.deleteicon}" ' +
        'ng-repeat="item in items">{{item.name}}</li></ul></div>', //of course in real case it will be use ng-repeat
        link:function(scope,element,attr){
            scope.action = {deleteicon :true};
            scope.toggleClass = function(show){
                scope.action.deleteicon = show;
            }
        }
    }
});

galleryDirectives.directive('pageSelect',function(){
    return {
        restrict:'AE',
        scope:{items:"="}, //<-- data bound from parent scope via attribute
        template:'<div><ul><li ng-mouseenter="toggleClass(true)" ng-mouseleave="toggleClass(false)"' +
        ' ng-class="{\'highlight\': action.deleteicon}" ' +
        'ng-repeat="item in items">{{item.name}}</li></ul></div>', //of course in real case it will be use ng-repeat
        link:function(scope,element,attr){
            scope.action = {deleteicon :true};
            scope.toggleClass = function(show){
                scope.action.deleteicon = show;
            }
        }
    }
});

galleryDirectives.directive('pageControls',[function(){
    return {
        restrict:'AE',
        scope:{items:"="}, //<-- data bound from parent scope via attribute
        template:'<div><ul><li ng-mouseenter="toggleClass(true)" ng-mouseleave="toggleClass(false)"' +
        ' ng-class="{\'highlight\': action.deleteicon}" ' +
        'ng-repeat="item in items">{{item.name}}</li></ul></div>', //of course in real case it will be use ng-repeat
        link:function(scope,element,attr){
            scope.action = {deleteicon :true};
            scope.toggleClass = function(show){
                scope.action.deleteicon = show;
            }
        }
    }
}]);


galleryDirectives.directive('strongPassRequired', function () {
    var isValid = function(s) {
        return s && s.length > 5 && /\D/.test(s) && /\d/.test(s);
    };

    return {
        require:'ngModel',
        link:function (scope, elm, attrs, ngModelCtrl) {

            ngModelCtrl.$parsers.unshift(function (viewValue) {
                ngModelCtrl.$setValidity('strongPass', isValid(viewValue));
                return viewValue;
            });

            ngModelCtrl.$formatters.unshift(function (modelValue) {
                ngModelCtrl.$setValidity('strongPass', isValid(modelValue));
                return modelValue;
            });
        }
    };
});


galleryDirectives.directive('integer', function() {
    var INTEGER_REGEXP = /^\-?\d*$/;
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function(viewValue) {
                if (INTEGER_REGEXP.test(viewValue)) {
                    // it is valid
                    ctrl.$setValidity('integer', true);
                    return viewValue;
                } else {
                    // it is invalid, return undefined (no model update)
                    ctrl.$setValidity('integer', false);
                    return undefined;
                }
            });
        }
    };
});*/