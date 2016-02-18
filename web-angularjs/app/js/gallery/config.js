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
    PAGINATION: {
         LIMIT: 4
    },
    VERBS:{
        INDEX: 'index',
        THUMB: 'thumb',
        MIDDLE: 'middle',
        ORIG: 'orig',
        TEST: 'test'
    },

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
        ROOT: 'http://localhost:8080',
        ROOT_OLD: 'http://localhost:8080/gallerycluster'
    },
    CRUDVActions: {
        CREATE: 'cr',
        UPDATE:  'upd',
        DELETE: 'del',
        VIEW:  'vw',
        LIST:  'lt',
        EDIT:  'ed',
        VIEW_WITH_COLLECTION:  'vwcol',
        VIEW_WITH_THUMB: 'vwth',
        VIEW_WITH_MIDDLE: 'vwmd',
        VIEW_WITH_ORIG: 'vwor'
    },
  /*  CRUDVActions: {
        CREATE: {
            NAME: 'cr',
            QUERY_PARAMS: {}
        },
        UPDATE: {
            NAME: 'upd',
            QUERY_PARAMS: {
                id: id,
                page: pg
            }
        },
        DELETE: {
            NAME: 'del',
            QUERY_PARAMS: {}
        },
        VIEW: {
            NAME: 'vw',
            QUERY_PARAMS: {
                id: id,
                page: pg
            }
        },
        LIST: {
            NAME: 'lt',
            QUERY_PARAMS: {}
        },
        EDIT: {
            NAME: 'ed',
            QUERY_PARAMS: {
                id: id
            }
        },
        VIEW_WITH_COLLECTION: {
            NAME: 'vwcol',
            QUERY_PARAMS: {}
        }
    },*/
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
            action: galleryConfig.CRUDVActions.VIEW_WITH_COLLECTION
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
    })
        .when("/gallery/category/:id/thumb", {
            templateUrl: "partials"+galleryConfig.PATHS.SUB+"/thumb.html",
            controller: "CategoryListCtrl",
            controllerAs: "CategoryListCtrl",
            action: galleryConfig.CRUDVActions.VIEW_WITH_THUMB
        })
        .when("/gallery/category/:id/middle", {
            templateUrl: "partials"+galleryConfig.PATHS.SUB+"/middle.html",
            controller: "CategoryListCtrl",
            controllerAs: "CategoryListCtrl",
            action: galleryConfig.CRUDVActions.VIEW_WITH_MIDDLE
        })
        .when("/gallery/category/:id/orig", {
            templateUrl: "partials"+galleryConfig.PATHS.SUB+"/orig.html",
            controller: "CategoryListCtrl",
            controllerAs: "CategoryListCtrl",
            action: galleryConfig.CRUDVActions.VIEW_WITH_ORIG
        });

}]);

gconf.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);