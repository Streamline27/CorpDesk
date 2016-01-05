/**
 * Created by Aleksej_home on 2016.01.04..
 */
var galleryServices = angular.module('galleryServices', []);

galleryServices.factory('Gallery',['$resource', function($resource) {
    return $resource('http://localhost:8080/gallerycluster/gallery/:id', { id: '@id' }, {
        update: {
            method: 'PUT'
        }
    });
}]);

galleryServices.service('currentGallery',[ function(){
    var local;
    function getGallery() {
        return local;
    }
    function setGallery(gallery) {
        local = gallery;
    }
    return {
        variable: "This is public",
        getGallery: getGallery,
        setGallery: setGallery
    };

    }]);
