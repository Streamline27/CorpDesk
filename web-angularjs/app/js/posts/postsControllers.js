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
        var size = 5;

        $scope.posts = PostsPageFactory.page({page: page, size: size});

        $scope.openPost = function(postId) {
            $location.path('/posts/' + postId)
        };

        $scope.newPost = function() {
            $location.path('/postnew')
        };

        $scope.editPost = function(postId) {
            $location.path('/postedit/' + postId)
        };

        $scope.firstPage = function() {
            page = 1;
            $scope.posts = PostsPageFactory.page({page: page, size: size});
        };

        $scope.previousPage = function() {
            page = page - 1;
            $scope.posts = PostsPageFactory.page({page: page, size: size});
        };

        $scope.nextPage = function() {
            page = page + 1;
            $scope.posts = PostsPageFactory.page({page: page, size: size});
        }

    }]);

postsControllers.controller('PostPageCtrl', ['$scope', '$routeParams', 'PostFactory',
    function($scope, $routeParams, PostFactory) {

        var postId = $routeParams.id;

        $scope.post = PostFactory.show({id: postId});

    }]);

postsControllers.controller('PostCreationCtrl', ['$scope', 'PostsFactory', '$location',
    function($scope, PostsFactory, $location) {

        $scope.post = {};
        $scope.post.userId = 1;
        $scope.post.groupId = 1;
        $scope.post.createdDate = Date.now();

        $scope.createNewPost = function() {
            PostsFactory.create($scope.post);
            $location.path('/posts')
        }

    }]);

postsControllers.controller('PostEditCtrl', ['$scope', '$routeParams', 'PostFactory', 'PostsFactory', '$location',
    function($scope, $routeParams, PostFactory, PostsFactory, $location) {

        var postId = $routeParams.id;

        $scope.post = PostFactory.show({id: postId});

        $scope.post.modifiedDate = Date.now();

        $scope.updatePost = function() {
            PostsFactory.update($scope.post);
            $location.path('/posts')
        };

        $scope.deletePost = function() {
            PostFactory.delete({id: postId});
            $location.path('/posts')
        }

    }]);
