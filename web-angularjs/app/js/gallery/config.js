/**
 * Created by Aleksej_home on 2016.01.04..
 */
var gconf = angular.module('galleryConfigApp', [
    'ngRoute',
    'ngResource',
    'galleryControllers'
]);

gconf.constant('galleryConfig', {
    INFO: "none",
    RESOURCES: {
        GALLERY: {
            list: 'galleries',
            item: 'gallery'
        },
        CATEGORY: {
            list: 'categories',
            item: 'category'
        },
        IMAGE: {
            list: 'images',
            item: 'image'
        },
        REWARD: {
            list: 'rewards',
            item: 'reward'
        }
    },
    PATHS:{
        SUB: '/gallery',
        PREFIX: {
            NEW: '/new',
            EDIT: '/edit',
            VIEW: '/view'
        },
        ROOT: 'http://localhost:8080/gallerycluster'
    },
    CRUDVActions: {
        CREATE: 'cr',
        UPDATE: 'upd',
        DELETE: 'del',
        VIEW: 'vw',
        LIST: 'lt',
        EDIT: 'ed',
        VIEW_WITH_COLLECTION: 'vwcol'
    },
    CRUDVArgs: {
        ERROR: 'error',
        SUCCESS: 'success',
        WARNING: 'warning',
        INFO: 'info',
        ERROR_DATA: 'errorText',
        SUCCESS_DATA: 'successText',
        SUCCESS_ID: 'successID',
        WARNING_DATA: 'warningText',
        INFO_DATA: 'infoText'
    }

});


gconf.config(['$routeProvider', 'galleryConfig',  function ($routeProvider, galleryConfig) {
    $routeProvider
        // Pages

        .when("/gallery", {
            templateUrl: "partials"+galleryConfig.PATHS.SUB+"/galleries.html",
            controller: "GalleryListCtrl",
            controllerAs: "GalleryListCtrl",
            action: galleryConfig.CRUDVActions.LIST
        })
    .when("/gallery/:id"+galleryConfig.PATHS.PREFIX.VIEW, {
        templateUrl: "partials"+galleryConfig.PATHS.SUB+"/gallery-view.html",
        controller: "GalleryListCtrl",
        controllerAs: "GalleryListCtrl",
        action: galleryConfig.CRUDVActions.VIEW
    })
        .when("/gallery/:id", {
            templateUrl: "partials"+galleryConfig.PATHS.SUB+"/index.html",
            controller: "GalleryListCtrl",
            controllerAs: "GalleryListCtrl",
            action: galleryConfig.CRUDVActions.VIEW
        })
     .when("/gallery/:id"+galleryConfig.PATHS.PREFIX.EDIT, {
            templateUrl: "partials"+galleryConfig.PATHS.SUB+"/gallery-edit.html",
            controller: "GalleryListCtrl",
            controllerAs: "GalleryListCtrl",
            action: galleryConfig.CRUDVActions.EDIT
        })
    .when("/gallery"+galleryConfig.PATHS.PREFIX.NEW, {
        templateUrl: "partials"+galleryConfig.PATHS.SUB+"/gallery-add.html",
        controller: "GalleryListCtrl",
        controllerAs: "GalleryListCtrl",
        action: galleryConfig.CRUDVActions.CREATE
    });

}]);

gconf.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);