'use strict';

/**
 * Main AngularJS Web Application
 */
var app = angular.module('corpDeskApp', [
  'ngRoute',
  'corpdeskControllers'
]);

app.run(
    function($rootScope) {
        $rootScope.loginContext = {
            //loggedin: false
            loggedin: true,
            user: "aaa"
        };
    });

/**
 * Configure the Routes
 */
app.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
      // Pages
      .when("/",{
          templateUrl: "partials/home.html",
          controller: "PageCtrl"
      })
    .when("/login", {
          templateUrl: "partials/login.html",
          controller: "LoginCtrl",
          controllerAs: "LoginCtrl"
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

app.controller('MainController', function($scope, $rootScope) {
    $scope.userName=$rootScope.loginContext.user;

})

app.controller('LoginController', function($scope, $rootScope) {


})