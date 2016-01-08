/**
 * Created by Aleksej_home on 2016.01.04..
 */
var gconf = angular.module('galleryConfigApp', [
    'ngRoute',
    'ngResource',
    'galleryControllers'
]);

gconf.constant('galleryConfig', {
    subPath: '/gallery',
    info: "none"

});

/*
gconf.config(function($stateProvider) {
    var subpath = '/gallery';
    $stateProvider.state('gallery', { // state for showing all movies
        url: '/gallery',
        templateUrl: 'partials'+ subpath + '/galleries.html',
        controller: 'GalleryListController'
    }).state('viewGallery', { //state for showing single movie
        url: '/gallery/:id/view',
        templateUrl: 'partials'+ subpath + '/gallery-view.html',
        controller: 'GalleryViewController'
    }).state('newGallery', { //state for adding a new movie
        url: '/gallery/new',
        templateUrl: 'partials'+ subpath + '/gallery-add.html',
        controller: 'GalleryCreateController'
    }).state('editGallery', { //state for updating a movie
        url: '/gallery/:id/edit',
        templateUrl: 'partials'+ subpath + '/gallery-edit.html',
        controller: 'GalleryEditController'
    });
}).run(function($state) {
    $state.go('gallery'); //make a transition to movies state when app starts
});*/
/*
gconf.config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('allGallery', {
        url: '/galllerycluster/gallery',
        templateUrl: 'partials/gallery/galleries.html',
        controller: 'GalleryListCtrl'
    });.state('viewGallery', {
        url: '/gallery/:id/view',
        templateUrl: 'partials/gallery/gallery-view.html',
        controller: 'GalleryViewController'
    }).state('newGallery', {
        url: '/gallery/new',
        templateUrl: 'partials/gallery/gallery-add.html',
        controller: 'GalleryCreateController'
    }).state('editGallery', {
        url: '/gallery/:id/edit',
        templateUrl: 'partials/gallery/gallery-edit.html',
        controller: 'GalleryEditController'
    });
}]);*/

gconf.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        // Pages

        .when("/gallery/galleries", {
            templateUrl: "partials/gallery/galleries.html",
            controller: "GalleryListCtrl",
            controllerAs: "GalleryListCtrl"
        })

    .when("/gallery/gallery", {
        templateUrl: "partials/gallery/gallery-view.html",
        controller: "GalleryViewCtrl",
        controllerAs: "GalleryViewCtrl"
    })
     .when("/gallery/gallery/edit", {
            templateUrl: "partials/gallery/gallery-edit.html",
            controller: "GalleryEditCtrl",
            controllerAs: "GalleryEditCtrl"
        });
   /* .when("/gallery/gallery/:id", {
        templateUrl: "partials/gallery/gallery-view.html",
        controller: "GalleryViewCtrl",
        controllerAs: "GalleryViewtCtrl"
    })
        .when("/gallery/gallery/", {
            templateUrl: "partials/gallery/gallery-view.html",
            controller: "GalleryViewCtrl",
            controllerAs: "GalleryViewCtrl"
        });*/
       /* .when("/users", {
            templateUrl: "partials/users.html",
            controller: "UserListCtrl",
            controllerAs: "UserListCtrl"
        })
        .when("/user/:id?", {
            templateUrl: "partials/user.html",
            controller: "UserEditCtrl",
            controllerAs: "UserEditCtrl"
        })

        .otherwise("/404", {templateUrl: "partials/404.html", controller: "PageCtrl"});*/
}]);

gconf.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);