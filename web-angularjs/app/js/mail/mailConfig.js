'use strict';

var mailConfig = angular.module('mailConfig', [
    'ngRoute',
    'ngResource',
    'mailControllers',
    'mailServices'
]);

mailConfig.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when("/mail", {
            templateUrl: "partials/mail/mail.html",
            controller: "FolderListCtrl",
            controllerAs: "FolderListCtrl"
        })
        .when("/mail/message/:id?", {
            templateUrl: "partials/mail/messageRead.html",
            controller: "MessageReadCtrl",
            controllerAs: "MessageReadCtrl"
        })
        .when("mail/compose", {
            templateUrl: "partials/mail/messageCompose.html",
            controller: "MessageComposeCtrl",
            controllerAs: "MessageComposeCtrl"
        })
}]);

mailConfig.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);