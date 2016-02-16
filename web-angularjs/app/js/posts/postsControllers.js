'use strict';

var postsControllers = angular.module('postsControllers', []);

var apiHost='http://localhost:8080';

postsControllers.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});

postsControllers.controller('PostListCtrl', ['$scope', 'PostsPageFactory', '$location',
    function($scope, PostsPageFactory, $location) {

        var page = 1;
        var size = 10;

        $scope.posts = PostsPageFactory.page({page: page, size: size});

        $scope.openPost = function(postId) {
            $location.path('/posts/' + postId)
        };

        $scope.newPost = function() {
            $location.path('/postnew')
        };

    }]);

postsControllers.controller('PostPageCtrl', ['$scope', '$routeParams', 'PostFactory',
    function($scope, $routeParams, PostFactory) {

        var postId = $routeParams.id;

        $scope.post = PostFactory.show({id: postId});

    }]);

postsControllers.controller('PostCreationCtrl', ['$scope', 'PostsFactory', '$location',
    function($scope, PostsFactory, $location) {

        $scope.post = {};
        $scope.post.createdDate = Date.now();

        $scope.createNewPost = function() {
            PostsFactory.create($scope.post);
            $location.path('/posts')
        }

    }]);
