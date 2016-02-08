'use strict';

var postsControllers = angular.module('postsControllers', []);

var apiHost='http://localhost:8080';

postsControllers.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});

postsControllers.controller('PostListCtrl', ['$scope', 'PostsFactory', '$location',
    function($scope, PostsFactory, $location) {

        $scope.posts = PostsFactory.query();

        $scope.openPost = function(postId) {
            $location.path('/posts/' + postId)
        };

    }]);

postsControllers.controller('PostPageCtrl', ['$scope', '$routeParams', 'PostFactory',
    function($scope, $routeParams, PostFactory){

        $scope.post = PostFactory.show({id: $routeParams.id});

    }]);
