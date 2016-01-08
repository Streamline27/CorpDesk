/**
 * Created by Aleksej_home on 2016.01.04..
 */
'use strict';

/* Controllers */

var apiHost='http://localhost:8080';

var galleryControllers = angular.module('galleryControllers', ['galleryServices']);



galleryControllers.controller('GalleryListCtrl', ['$scope', '$http', 'currentGallery', '$location', 'Gallery',
    function($scope, $http, currentGallery, $location, Gallery) {
        var ctrl = this;
        $scope.galleries = Gallery.query();

      /*  ctrl.showList = function(){
           // $scope.moduleState = 'list';
            return  Gallery.query();
        };*/

        ctrl.showItem = function(gallery){
          //  $scope.moduleState = 'item';
          //  alert('Stuff');
          //  $ccope.currentGallery = gallery;
            currentGallery.setGallery(gallery);
            $location.path("/gallery/gallery");
        };

        ctrl.updateItem = function(gallery){
          //  $scope.moduleState = 'update';
            currentGallery.setGallery(gallery);
            $location.path("/gallery/gallery/edit");
        };

        ctrl.deleteItem = function(gallery){
           // $scope.moduleState = 'delete';
            alert('deleted');
          //  $location.path("/gallery/gallery-d")
        };

      // $scope.galleries = Gallery.query();
      //  var ctrl = this;

    /*    $http({
            method: 'GET',
            url: apiHost + '/gallerycluster/gallery'
        }).success(function (data) {
            // ctrl.gallery = data;
            $scope.galleries = data;

        }).catch(function(err){
            alert(err.data);
        });*/

    }]);
galleryControllers.controller('GalleryViewCtrl', ['$scope',  '$routeParams', 'currentGallery', '$location', 'Gallery',
    function($scope, $routeParams, currentGallery, $location, Gallery) {
       // var ctrl = this;

      //  $scope.gallery = Gallery.get({ id: $routeParams.userId });

        $scope.gallery = currentGallery.getGallery();




      //  $scope.galleries = Gallery.query();
       /* ctrl.viewGallery=function(gallery){
            $location.path("/user/")
        };*/
      //  $scope.gallery = gallery;
      //  $scope.viewGallery = function(gallery){
       //     $location.path(id); // path not hash
       // }
       // $scope.gallery = Gallery.get({ id: Gallery.id });
        //  var ctrl = this;
      //  alert('Controller');
        /*    $http({
         method: 'GET',
         url: apiHost + '/gallerycluster/gallery'
         }).success(function (data) {
         // ctrl.gallery = data;
         $scope.galleries = data;

         }).catch(function(err){
         alert(err.data);
         });*/

    }]);
galleryControllers.controller('GalleryEditCtrl', ['$scope', '$http',  'currentGallery', '$location', 'Gallery',
    function($scope, $http, currentGallery, $location, Gallery) {
     //   $scope.galleries = Gallery.query();
          var ctrl = this;
        $scope.gallery = currentGallery.getGallery();


        ctrl.updateGallery = function(gallery){
            //  $scope.moduleState = 'update';
            currentGallery.setGallery(gallery);
           // $location.path("/gallery/gallery/edit");
        };
        /*    $http({
         method: 'GET',
         url: apiHost + '/gallerycluster/gallery'
         }).success(function (data) {
         // ctrl.gallery = data;
         $scope.galleries = data;
         updateGallery
         }).catch(function(err){
         alert(err.data);
         });*/

    }]);

