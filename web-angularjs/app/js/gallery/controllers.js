/**
 * Created by Aleksej_home on 2016.01.04..
 */
'use strict';

/* Controllers */

var apiHost='http://localhost:8080';


var galleryControllers = angular.module('galleryControllers', ['galleryServices']);



galleryControllers.controller('GalleryListCtrl', ['$scope', '$http', '$route', '$routeParams',
     '$location', 'Gallery', 'GalleryHandler', 'galleryConfig', 'EntityDefines',
    function($scope, $http, $route,$routeParams, $location, Gallery, GalleryHandler, galleryConfig, EntityDefines) {
        var self = this;
        var entity;
        $scope.model = {};

        entity = GalleryHandler.action({
            state: $route.current.action,
            id: $routeParams.id});

        var item;
        while (entity.length) {
            item = entity.pop();

            if (item.options.resource){
                item.value().$promise.then(function(data) {
                    $scope.model[item.key] = data;
                },onEntityError);
            }else{
                $scope.model[item.key] = item.value();
            }
        }

        $scope.addItem = function(){
            $location.path("/gallery/new");
        };

        $scope.showItem = function(userId){
            $location.path("/gallery/" + userId+ "/view");
        };

        $scope.editItem = function(userId){
            $location.path("/gallery/"+userId+"/edit");
        };

        $scope.updateGallery = function(gallery){
            gallery.$update().then(function(data) {
                GalleryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'updated',
                    id: data.userId
                });
                $scope.showItem(data.userId);
            },onEntityError);

        };
        $scope.createGallery = function(gallery){
            gallery.$save().then(function(data) {
                GalleryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'created',
                    id: data.userId
                });
                $scope.showItem(data.userId);
            },onEntityError);
        };

        $scope.deleteItem = function(gallery){
            gallery.$delete().then(function(data) {
                GalleryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'deleted',
                    id: data.userId
                });
                $route.reload();
            }, onEntityError);
        };

        function onEntityError(error){
            var err = GalleryHandler.onError(error);
            var item;
            while (err.length){
                item = err.pop();
                $scope.model[item.key] = item.value();
            }
        }

    }]);

galleryControllers.controller('CategoryCtrl', ['$scope', '$http', '$route', '$routeParams',
    '$location', 'Gallery', 'GalleryHandler', 'galleryConfig',
    function($scope, $http, $route,$routeParams, $location, Gallery, GalleryHandler, galleryConfig) {
        var self = this;
        var entity;
        $scope.model = {};

        entity = GalleryHandler.action({
            state: $route.current.action,
            id: $routeParams.id});

        var item;
        while (entity.length) {
            item = entity.pop();

            if (item.options.resource){
                item.value().$promise.then(function(data) {
                    $scope.model[item.key] = data;
                },onEntityError);
            }else{
                $scope.model[item.key] = item.value();
            }
        }

        $scope.addItem = function(){
            $location.path("/gallery/new");
        };

        $scope.showItem = function(userId){
            $location.path("/gallery/" + userId+ "/view");
        };

        $scope.editItem = function(userId){
            $location.path("/gallery/"+userId+"/edit");
        };

        $scope.updateGallery = function(gallery){
            gallery.$update().then(function(data) {
                GalleryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'updated',
                    id: data.userId
                });
                $scope.showItem(data.userId);
            },onEntityError);

        };
        $scope.createGallery = function(gallery){
            gallery.$save().then(function(data) {
                GalleryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'created',
                    id: data.userId
                });
                $scope.showItem(data.userId);
            },onEntityError);
        };

        $scope.deleteItem = function(gallery){
            gallery.$delete().then(function(data) {
                GalleryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'deleted',
                    id: data.userId
                });
                $route.reload();
            }, onEntityError);
        };

        function onEntityError(error){
            var err = GalleryHandler.onError(error);
            var item;
            while (err.length){
                item = err.pop();
                $scope.model[item.key] = item.value();
            }
        }

    }]);

