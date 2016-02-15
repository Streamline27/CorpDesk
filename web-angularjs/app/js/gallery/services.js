/**
 * Created by Aleksej_home on 2016.01.04..
 */
var galleryServices = angular.module('galleryServices', []);


/*
galleryServices.factory('Gallery',['$resource', function($resource) {
    return   $resource('http://localhost:8080/gallerycluster/gallery/:id', { id: '@userId' }, {
            update: {
                method: 'PUT'
            }
        });
}]);*/

galleryServices.factory('EntityDefines', ['galleryConfig', function(galleryConfig){
    var entityType = [];

    function define(entity){
        if (notDefined(entity)){
            alert("new def" + entity.item);
            entityType.length = 0;
            entityType.push(entity);
        }
       // alert("defined" + entity.id);
    }
    function getDefines(){
       // return entityType[0];
        return 'zaza';
    }


    function notDefined(entity){
       // return entityType.length < 1 || entityType.length > 0 && entityType[0].id != entity.id
        return true
    }
    return {
        define: define,
        getEntityDefines: getDefines
    }

}]);



galleryServices.factory('Gallery',['$resource', '$cacheFactory', 'galleryConfig',
    function($resource, $cacheFactory, galleryConfig) {
       // var entityType = EntityDefines.getEntityDefines();

   /* var cache = $cacheFactory('resourceCache');
    var interceptor = {
        response: function (response) {
            cache.remove(response.config.url);
            console.log('cache removed', response.config.url);
            return response;
        },
        responseError: function (response) {
            console.log('error in interceptor', data);
            return response;
        }
    };*/


    return {
      //  factory:  $resource('http://localhost:8080/gallerycluster/gallery/:id', { id: '@userId' }, {
        factory:  $resource(galleryConfig.PATHS.ROOT + '/gallery/:id', { id: '@userId' }, {
            update: {method: 'PUT'/*, interceptor: interceptor*/},
            save:   { method: 'POST'/*, interceptor: interceptor*/ },
            remove: { method: 'DELETE'/*, interceptor: interceptor*/ },
            delete: { method: 'DELETE'/*, interceptor: interceptor*/ },
            get: {method: 'GET', cache: false},
            query: {method: 'GET', cache: false, isArray: true}
        }),
       /* options: {
            list: entityType.list,
            item: entityType.item
        }*/
        options: galleryConfig.RESOURCES.GALLERY
    };

}]);

galleryServices.factory('Category',['$resource', '$cacheFactory', 'galleryConfig',
    function($resource, $cacheFactory, galleryConfig) {

        return {
            factory:  $resource(galleryConfig.PATHS.ROOT + '/gallery/category/:id', { id: '@id' }, {
                update: {method: 'PUT'}
            }),
            options: galleryConfig.RESOURCES.CATEGORY
        };

    }]);

/*
galleryServices.service('EntityDefines',['galleryConfig', function(galleryConfig){
    var def;
    function isDefined(){
        return
    }
}]);*/



galleryServices.service('currentGallery',[ function(){
    var local;
    var localList;
    var livetime = new Date().getTime();
    var liveInterval = 1000;
    var state;
    // var d = new Date();

    function getGallery() {
        return local;
    }
    function setGallery(gallery) {
        local = gallery;
    }

    function getGalleryList() {
          if (isTimeOff()){
         localList = null;
         local = null;
         }
        return localList;
    }
    function getState(){

    }

    function setGalleryList(galleries) {
        // timeLock = new Date().getTime();
        livetime = new Date().getTime() + liveInterval;
        localList = galleries;
    }
    function  isTimeOff(){
        return livetime <  new Date().getTime();
    }
    return {
        variable: "This is public",
        getGallery: getGallery,
        setGallery: setGallery,
        getGalleryList: getGalleryList,
        setGalleryList: setGalleryList
    };

}]);



function CRUDService(entity, galleryConfig) {
    if (this.constructor === CRUDService) {
        throw new Error("Can't instantiate abstract class!");
    }

    var localStack = {
         action: [],
         models: []
    };


    this._curState = function(options) {

       // switch (localState.length != 0?localState.pop():state) {
        switch (options.state) {
            case galleryConfig.CRUDVActions.VIEW:
                return  _onViewCRUD(options.id);
            case galleryConfig.CRUDVActions.LIST:
                return  _onListCRUD();
            case galleryConfig.CRUDVActions.EDIT:
                return  _onEditCRUD(options.id);
            case galleryConfig.CRUDVActions.CREATE:
                return  _onCreateCRUD();
            case galleryConfig.CRUDVActions.UPDATE:
                return  _onUpdateCRUD();
            case galleryConfig.CRUDVActions.DELETE:
                return  _onDeleteCRUD();
            default:
                return false;
        }
    };

    this.setAction = function(action){
        localStack.action.push(action);
    };

    this.setModels = function(state, options){
        switch (state) {
            case galleryConfig.CRUDVArgs.SUCCESS:
                localStack.models.push(onEntitySuccess(options));
                break;
            default:
                return false;
        }

    };
  /*  this.methods = {
        onViewCRUD: _onViewCRUD,
        onListCRUD: _onListCRUD,
        onEditCRUD: _onEditCRUD,
        onCreateCRUD: _onCreateCRUD,
        onUpdateCRUD: _onUpdateCRUD,
        onDeleteCRUD: _onDeleteCRUD

    };*/

    this.onEntityError = function(error){
        return wrapperModel(galleryConfig.CRUDVArgs.ERROR, true, false)
            .concat(wrapperModel(galleryConfig.CRUDVArgs.ERROR_DATA, error.statusText + ' '
            + (error.status !== -1)? error.status:'Connection lost', false));
    };

    function onEntitySuccess(options){
       return wrapperModel(galleryConfig.CRUDVArgs.SUCCESS, true, false)
            .concat(wrapperModel(galleryConfig.CRUDVArgs.SUCCESS_DATA, options.text, false))
            .concat(wrapperModel(galleryConfig.CRUDVArgs.SUCCESS_ID, options.id, false));

    }


    function _onViewCRUD(id) {
        return resourceWrapper(entity.options.item, entity.factory.get({ id: id }), true);
    }
  /*  this._onViewCRUD = function(id) {
        return resourceWrapper(entity.options.item, entity.factory.get({ id: id }), true);
    };*/

    function _onListCRUD(){
        return resourceWrapper(entity.options.list, entity.factory.query(), true);
    }

    function _onEditCRUD (id){
        return resourceWrapper(entity.options.item, entity.factory.get({ id: id }), true);
    }
    function _onCreateCRUD (){
        return resourceWrapper(entity.options.item, new entity.factory(), false);
    }
    function _onUpdateCRUD (){}
    function _onDeleteCRUD (){}

    function resourceWrapper(key, value, status){
        return collectModels(wrapperModel(key, value, status));
    }
    function wrapperModel(key, value, status){
       return [{
           key : key,
           value : function(){
               return value;
           },
           options: {
               resource: status
           }
       }];
    }

    function collectModels(models){
        return localStack.models.length > 0? models.concat(localStack.models.pop()): models;
    }

}



var GalleryInstance = function(entity,galleryConfig){
    CRUDService.apply(this, arguments);

    var parentCurState = this._curState;
    var _curState = function(options) {
        var local = parentCurState.apply(this, arguments);
        if (local)
            return local;
        switch (options.state) {
            case galleryConfig.CRUDVActions.VIEW_WITH_COLLECTION:
                return  this._onViewCRUD.apply(this, arguments);
            default:
                throw new Error("No action with type of: " + state);
        }
    };

    return {
        action: _curState,
        onError: this.onEntityError,
        setModels: this.setModels,
        setAction: this.setAction
    }
};

GalleryInstance.$inject = ['Gallery', 'galleryConfig'];
galleryServices.factory('GalleryHandler',GalleryInstance);


galleryServices.directive('strongPassRequired', function () {
    var isValid = function(s) {
        return s && s.length > 5 && /\D/.test(s) && /\d/.test(s);
    };

    return {
        require:'ngModel',
        link:function (scope, elm, attrs, ngModelCtrl) {

            ngModelCtrl.$parsers.unshift(function (viewValue) {
                ngModelCtrl.$setValidity('strongPass', isValid(viewValue));
                return viewValue;
            });

            ngModelCtrl.$formatters.unshift(function (modelValue) {
                ngModelCtrl.$setValidity('strongPass', isValid(modelValue));
                return modelValue;
            });
        }
    };
});


galleryServices.directive('integer', function() {
    var INTEGER_REGEXP = /^\-?\d*$/;
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function(viewValue) {
                if (INTEGER_REGEXP.test(viewValue)) {
                    // it is valid
                    ctrl.$setValidity('integer', true);
                    return viewValue;
                } else {
                    // it is invalid, return undefined (no model update)
                    ctrl.$setValidity('integer', false);
                    return undefined;
                }
            });
        }
    };
});
