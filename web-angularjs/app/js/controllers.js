'use strict';

/* Controllers */

var apiHost='http://localhost:8080';

var corpdeskControllers = angular.module('corpdeskControllers', []);

/*
    USERS
 */
corpdeskControllers.controller('UserListCtrl', ['$scope', '$http', '$location',
    function($scope, $http, $location) {
        var ctrl = this;

        $http({
            method: 'GET',
            url: apiHost + '/user'
        }).success(function (data) {
            ctrl.users = data;
        });


        ctrl.editUser=function(user){
            $location.path("/user/"+user.id)
        };

        ctrl.deleteUser=function(user){
            $http({
                method: 'DELETE',
                url: apiHost + '/user',
                params: {userId: user.id}
            }).success(function (data) {
                var index = ctrl.users.indexOf(user);
                if (index > -1) {
                    ctrl.users.splice(index, 1);
                }
            });
        };
  }]);

corpdeskControllers.controller('UserEditCtrl', ['$scope', '$http', '$routeParams',
    function($scope, $http, $routeParams) {
        var ctrl = this;
        ctrl.userId=$routeParams.id


            $http({
                method: 'GET',
                url: apiHost + '/user',
                params: {userId: ctrl.userId}
            }).success(function (data) {
                $scope.user = data[0];
            });


        $scope.saveUser=function(){

            $http({
                method: 'PUT',
                url: apiHost + '/user',
                data: $scope.user
            }).success(function (data) {
                $scope.user = data;
            });
        };
    }]);









/**
 * Controls the Blog
 */
app.controller('BlogCtrl', function (/* $scope, $location, $http */) {
    console.log("Blog Controller reporting for duty.");
});

/**
 * Controls all other Pages
 */
app.controller('PageCtrl', function (/* $scope, $location, $http */) {
    console.log("Page Controller reporting for duty.");

    // Activates the Carousel
    $('.carousel').carousel({
        interval: 5000
    });

    // Activates Tooltips for Social Links
    $('.tooltip-social').tooltip({
        selector: "a[data-toggle=tooltip]"
    })
});