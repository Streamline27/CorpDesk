/**
 * Created by Aleksej_home on 2016.01.04..
 */
'use strict';

/* Controllers */

var apiHost='http://localhost:8080';


var galleryControllers = angular.module('galleryControllers', [
    'galleryServices'
   // 'galleryFilters',
   /* 'galleryDirectives'*/]);



galleryControllers.controller('GalleryListCtrl', ['$scope', '$http', '$route', '$routeParams',
     '$location', 'Gallery', 'GalleryHandler', 'galleryConfig', 'Pagination',
    function($scope, $http, $route,$routeParams, $location, Gallery, GalleryHandler, galleryConfig, Pagination) {
        var self = this;
        var entity, actionState = $route.current.action;
        $scope.model = {};

        entity = GalleryHandler.action({
            state: actionState,
            queryParams: {
                id: $routeParams.id,
                page: Pagination.currentPage()
            }});

        var item;
        while (entity.length) {
            item = entity.pop();

            if (item.options.resource){
                item.value().$promise.then(function(data) {
                    $scope.model[item.key] = data;
                    initPagination(item.key,data);
                },onEntityError);
            }else{
                $scope.model[item.key] = item.value();
            }
        }

        $scope.showThumbs = function(el) {
            if (el.imgCount > 0) {
                Pagination.destroy();
                $location.search({});
                $location.path("/gallery/category/" + el.id + "/thumb");
             }else{
                alert("Category with ID:"+el.id+" is empty.");
            }

        };
        $scope.showMiddles = function(el){
            if (el.imgCount > 0) {
                Pagination.destroy();
                $location.search({});
                $location.path("/gallery/category/" + el.id + "/middle");
            }else {
                alert("Category with ID:" + el.id + " is empty.");
            }
        };
        $scope.showOriginals = function(el){
            if (el.imgCount > 0) {
                Pagination.destroy();
                $location.search({});
                $location.path("/gallery/category/" + el.id + "/orig");
            }else {
                alert("Category with ID:" + el.id + " is empty.");
            }
        };

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

        $scope.pagination = function(direction, num){
           var cur = Pagination.currentPage();
           // alert("Pag: " + Pagination.currentPage());
            if (Pagination[direction](num))
                $location.search('page', Pagination.currentPage());
          //  $location.path("/gallery/"+userId+ "?page=" + Pagination.currentPage());
        };

        function onEntityError(error){
            var err = GalleryHandler.onError(error);
            var item;
            while (err.length){
                item = err.pop();
                $scope.model[item.key] = item.value();
            }
        }
        function initPagination(key,data){
            if(actionState == galleryConfig.CRUDVActions.VIEW_WITH_COLLECTION)
             if (key === galleryConfig.RESOURCES.GALLERY.item){
                 if (data.addition.pageCount > 1){
                   //  var paginator = {};
                     $scope.model.showPagination = true;
                     Pagination.initPage(data.addition.page);
                     Pagination.setPageCount(data.addition.pageCount);
                     $scope.model.prev = Pagination.getModel().prev;
                     $scope.model.next = Pagination.getModel().next;
                     $scope.model.paginator = Pagination.getModel().model();
                 }else {
                     $scope.model.showPagination = false;
                 }
             }

        }

    }]);

galleryControllers.controller('CategoryListCtrl', ['$scope', '$http', '$route', '$routeParams',
    '$location', 'Category', 'CategoryHandler', 'galleryConfig', 'Pagination',
    function($scope, $http, $route,$routeParams, $location, Category, CategoryHandler, galleryConfig, Pagination) {
        var self = this;
        var entity, actionState = $route.current.action;
        $scope.model = {};
        entity = CategoryHandler.action({
            state: actionState,
            queryParams: {
                id: $routeParams.id,
                page: Pagination.currentPage()
            }});

        var item;
        while (entity.length) {
            item = entity.pop();

            if (item.options.resource){
                item.value().$promise.then(function(data) {
                    $scope.model[item.key] = data;
                    initPagination(item.key,data);
                },onEntityError);
            }else{
                $scope.model[item.key] = item.value();
            }
        }

        $scope.showThumbs = function(el){
          //  if (el.imgCount > 0)
             //   $location.path("/gallery/category/" + el.id+ "/thumb");
          //  else
              //  alert("Category with ID:"+el.id+" is empty.");
        };
        $scope.showMiddles = function(el){
          //  if (el.imgCount > 0)
            Pagination.destroy();
            $location.search({});
            $location.path("/gallery/category/" + el.id+ "/middle");
          //  else
              //  alert("Category with ID:"+el.id+" is empty.");
        };
        $scope.showOriginals = function(el){
           // if (el.imgCount > 0)
            alert("ddd: " + el.id);
            Pagination.destroy();
            $location.search({});
                $location.path("/gallery/category/" + el.id + "/orig");
         //   else
            //    alert("Category with ID:"+el.id+" is empty.");
        };

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
                CategoryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'updated',
                    id: data.id
                });
                $scope.showItem(data.userId);
            },onEntityError);

        };
        $scope.createGallery = function(gallery){
            gallery.$save().then(function(data) {
                CategoryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'created',
                    id: data.id
                });
                $scope.showItem(data.userId);
            },onEntityError);
        };

        $scope.deleteItem = function(gallery){
            gallery.$delete().then(function(data) {
                CategoryHandler.setModels(galleryConfig.CRUDVArgs.SUCCESS,{
                    text: 'deleted',
                    id: data.id
                });
                $route.reload();
            }, onEntityError);
        };

        $scope.pagination = function(direction, num){
            var cur = Pagination.currentPage();
            // alert("Pag: " + Pagination.currentPage());
            if (Pagination[direction](num))
                $location.search('page', Pagination.currentPage());
            //  $location.path("/gallery/"+userId+ "?page=" + Pagination.currentPage());
        };

        function onEntityError(error){
            var err = CategoryHandler.onError(error);
            var item;
            while (err.length){
                item = err.pop();
                $scope.model[item.key] = item.value();
            }
        }
        function initPagination(key,data){
            if(actionState === galleryConfig.CRUDVActions.VIEW_WITH_THUMB)
                if (key === galleryConfig.RESOURCES.CATEGORY.item){
                    if (data.addition.pageCount > 1){
                        //  var paginator = {};
                        $scope.model.showPagination = true;
                        Pagination.initPage(data.addition.page);
                        Pagination.setPageCount(data.addition.pageCount);
                        $scope.model.prev = Pagination.getModel().prev;
                        $scope.model.next = Pagination.getModel().next;
                        $scope.model.paginator = Pagination.getModel().model();
                    }else {
                        $scope.model.showPagination = actionState === galleryConfig.CRUDVActions.VIEW_WITH_MIDDLE||
                                                        actionState === galleryConfig.CRUDVActions.VIEW_WITH_ORIG;

                    }
                }

        }

    }]);
