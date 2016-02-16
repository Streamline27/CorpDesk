'use strict';

var postsConfig = angular.module('postsConfig', [
    'ngRoute',
    'ngResource',
    'postsControllers',
    'postsServices'
]);

postsConfig.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when("/posts", {
            templateUrl: "partials/posts.html",
            controller: "PostListCtrl"
        })
        .when("/posts/:id?", {
            templateUrl: "partials/post.html",
            controller: "PostPageCtrl"
        })
        .when("/postnew", {
            templateUrl: "partials/postnew.html",
            controller: "PostCreationCtrl"
        })
}]);

postsConfig.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);