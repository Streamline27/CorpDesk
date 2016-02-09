'use strict';

/**
 * Main AngularJS Web Application
 */
var app = angular.module('corpDeskApp', [
  'ngRoute',
  'galleryConfigApp',
  'corpdeskControllers',
    'postsConfig'
]);

app.run(
    function($rootScope) {
        $rootScope.loginContext = {
            autheniticated: false
        };
    });

/**
 * Configure the Routes
 */
app.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
      // Pages
      .when("/",{
          templateUrl: "partials/posts.html",
          controller: "PostListCtrl"
      })
    .when("/login", {
          templateUrl: "partials/login.html",
          controller: "LoginController",
          controllerAs: "LoginController"
      })
      .when("/users", {
          templateUrl: "partials/users.html",
          controller: "UserListCtrl",
          controllerAs: "UserListCtrl"
      })
    .when("/user/:id?", {
          templateUrl: "partials/user.html",
          controller: "UserEditCtrl",
          controllerAs: "UserEditCtrl"
      })
      .when("/user/", {
          templateUrl: "partials/user.html",
          controller: "UserEditCtrl",
          controllerAs: "UserEditCtrl"
      })
      .when("/group/", {
          templateUrl: "partials/group.html",
          controller: "GroupEditCtrl",
          controllerAs: "GroupEditCtrl"
      })
      .when("/group/:id?", {
          templateUrl: "partials/group.html",
          controller: "GroupEditCtrl",
          controllerAs: "GroupEditCtrl"
      })
      .when("/changepassword", {
          templateUrl: "partials/change_password.html",
          controller: "PasswordCtrl",
          controllerAs: "PasswordCtrl"
      })
      .when("/mail", {
          templateUrl: "partials/mail.html",
          controller: "FolderListCtrl",
          controllerAs: "FolderListCtrl"
      })


      // todo must be removed, for example only
    // templates
    .when("/about", {templateUrl: "partials/about.html", controller: "PageCtrl"})
    .when("/faq", {templateUrl: "partials/faq.html", controller: "PageCtrl"})
    .when("/pricing", {templateUrl: "partials/pricing.html", controller: "PageCtrl"})
    .when("/services", {templateUrl: "partials/services.html", controller: "PageCtrl"})
    .when("/contact", {templateUrl: "partials/contact.html", controller: "PageCtrl"})
    // Blog
    .when("/blog", {templateUrl: "partials/blog.html", controller: "BlogCtrl"})
    .when("/blog/post", {templateUrl: "partials/blog_item.html", controller: "BlogCtrl"})
    // else 404
    .otherwise("/404", {templateUrl: "partials/404.html", controller: "PageCtrl"});
}]);


app.config(['$httpProvider', function($httpProvider) {
  //Reset headers to avoid OPTIONS request (aka preflight)
    $httpProvider.defaults.headers.common["Accept"] = "application/json";
    $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    delete $httpProvider.defaults.headers.common["X-Requested-With"];
    $httpProvider.defaults.useXDomain = true;
}]);

app.controller('MainController', function($scope, $rootScope, $window) {
    $scope.reload = function() {
        $window.location.reload();
    }
});

// https://spring.io/blog/2015/01/12/the-login-page-angular-js-and-spring-security-part-ii
app.controller('LoginController', function($scope, $rootScope, $http, $location) {
    var authenticate = function(credentials, callback) {
        if (credentials) {
            var user = {};
            user.login = credentials.username;
            user.password = credentials.password;

            $http({
                method: 'POST',
                url: apiHost + '/user/authorize',
                data: user
            }).success(function (data) {
                $rootScope.loginContext.authenticated = true;
                $rootScope.loginContext.user = credentials.username;
                callback && callback();
            }).catch(function (err) {
                if (err && err.status===-1){
                    alert("Server not active!");
                }
                $rootScope.loginContext.authenticated = false;
                $scope.errorText = err.data;
                callback && callback();
            });
        }
    }

    authenticate();

    $scope.credentials = {};
    $scope.login = function() {
        authenticate($scope.credentials, function() {
            if ($rootScope.loginContext.authenticated) {
               // $location.path("/");
                $scope.error = false;
            } else {
               // $location.path("/login");
                $scope.error = true;
            }
        });
    };

    $scope.logout = function() {
        $scope.credentials = {};
        $rootScope.loginContext.authenticated = false;
        $rootScope.loginContext.user = undefined;
        $location.path("/login");
    }
});