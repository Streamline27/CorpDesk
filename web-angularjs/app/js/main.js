'use strict';

/**
 * Main AngularJS Web Application
 */
var app = angular.module('corpDeskApp', [
  'ngRoute',
  'galleryConfigApp',
  'corpdeskControllers',
  'postsConfig',
  'mailConfig'
]);

app.run(
    function($rootScope, $http) {
        $rootScope.loginContext = {
            authenticated: false
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

app.factory('httpRequestInterceptor', function ($rootScope, $location, $q) {
    return {
        request: function (config) {
            if ($rootScope.loginContext.authenticated) {
                var authdata = Base64.encode($rootScope.loginContext.user + ':' + $rootScope.loginContext.password);
                config.headers['Authorization'] = 'Basic ' + authdata;
            }
            return config;
        },
        responseError: function(errorResponse) {
            switch (errorResponse.status) {
                case 403:
                    alert("Fobidden! User is not authenticated.");
                    $location.path("/login");
                    break;
            }
            return $q.reject(errorResponse);
        }
    };
});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('httpRequestInterceptor');
});


app.controller('MainController', function($scope, $rootScope, $window, $location) {
    $scope.reload = function() {
        $rootScope.loginContext.authenticated = false;
        $rootScope.loginContext.user = undefined;
        $rootScope.loginContext.password = undefined;
        $location.path("/login");
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
                $rootScope.loginContext.password = credentials.password;
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
                $location.path("/");
                $scope.error = false;
            } else {
                $location.path("/login");
                $scope.error = true;
            }
        });
    };

    $scope.logout = function() {
        $scope.credentials = {};
        $rootScope.loginContext.authenticated = false;
        $rootScope.loginContext.user = undefined;
        $rootScope.loginContext.password = undefined;
        $location.path("/login");
    }
});

/**
 *
 *  Base64 encode / decode
 *  http://www.webtoolkit.info/
 *
 **/
var Base64 = {

// private property
    _keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",

// public method for encoding
    encode : function (input) {
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;

        input = Base64._utf8_encode(input);

        while (i < input.length) {

            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);

            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;

            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }

            output = output +
                this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
                this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);

        }

        return output;
    },

// private method for UTF-8 encoding
    _utf8_encode : function (string) {
        string = string.replace(/\r\n/g,"\n");
        var utftext = "";

        for (var n = 0; n < string.length; n++) {

            var c = string.charCodeAt(n);

            if (c < 128) {
                utftext += String.fromCharCode(c);
            }
            else if((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            }
            else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }

        }

        return utftext;
    }
}