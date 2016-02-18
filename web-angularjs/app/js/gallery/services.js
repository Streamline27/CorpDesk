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

    return {
      //  factory:  $resource('http://localhost:8080/gallerycluster/gallery/:id', { id: '@userId' }, {
        factory:  $resource(galleryConfig.PATHS.ROOT + '/gallery/:id/:verb', { id: '@userId' }, {
            update: {method: 'PUT'/*, interceptor: interceptor*/},
            save:   { method: 'POST'/*, interceptor: interceptor*/ },
            remove: { method: 'DELETE'/*, interceptor: interceptor*/ },
            delete: { method: 'DELETE'/*, interceptor: interceptor*/ },
            get: {method: 'GET', cache: false},
            query: {method: 'GET', cache: false, isArray: true}
        }),
        options: galleryConfig.RESOURCES.GALLERY
    };

}]);

galleryServices.factory('Category',['$resource', '$cacheFactory', 'galleryConfig',
    function($resource, $cacheFactory, galleryConfig) {

        return {
            factory:  $resource(galleryConfig.PATHS.ROOT + '/gallery/category/:id/:verb', { id: '@userId' }, {
                update: {method: 'PUT'/*, interceptor: interceptor*/},
                save:   { method: 'POST'/*, interceptor: interceptor*/ },
                remove: { method: 'DELETE'/*, interceptor: interceptor*/ },
                delete: { method: 'DELETE'/*, interceptor: interceptor*/ },
                get: {method: 'GET', cache: false},
                query: {method: 'GET', cache: false, isArray: true}
            }),
            options: galleryConfig.RESOURCES.CATEGORY
        };

    }]);



galleryServices.service('Pagination',['galleryConfig', function(galleryConfig){
    var page,
        pagecount, // Server side total pages
        model,
        pageQueue = [],
        LEN = 3,// default queue model length, do not change it
        PAGE_SIZE = 4; // Server side defaults


    function first(){
        return page < 2;
    }
    function last(){
        return page == pagecount;
    }

    function validPage(pg){
        return pg > 0 && pg <= pagecount;
    }


    function setPageCount(pcount){
        pagecount = pcount;
        model = pageModelBuild();
    }
    function getModel(){
        return model;
      //  return PAGE_SIZE;
    }
    function initPage(cpage){
        page = cpage;
    }

    function getPageCount(){
        return pagecount;
    }

    function pageModelBuild(){
        var p, n;
        if (first())
            p = 'disabled';
        if (last())
            n = 'disabled';

        function checkOffset(){
            var offset = 0;
            if (first()){
             //   alert('first');
               return offset;
            }else if (last()){
             //   alert('last');
                return offset -=2;
            }else{
               // alert('usual');
                return --offset;
            }
        }

        function outOfBounds(){
             return pagecount < LEN;
        }

        function current(i,offset){
            return (page + i + offset) == page;
        }

        function generateQueue(i,offset){
         //  alert("i: " + i+ " >page: "+ page+ " >offset: " +offset);
            return page + i + offset;
        }

        function buildModel(){
            var arr = [],
                tmp;
            for(var i = 0;i<LEN;i++){
                if (!outOfBounds()){
                    tmp = current(i,checkOffset());
                    arr[i] = {
                        id: generateQueue(i,checkOffset()),
                        state: tmp?'active':
                               !validPage(tmp)?'disabled':''
                    }
                }else{
                    arr[i] = {
                        id: i + 1,
                        state: ((i + 1) == page)?'active':
                               !validPage(i + 1)?'disabled':''
                    }
                }

            }
            return arr;
        }

        return {
            prev: p,
            next: n,
            model: buildModel
        }
    }

    function setPage(cpage){
       if(!validPage(cpage))
           return false;
        page = cpage;
        return true;
    }
    function next(){
        if (last())
             return false;
        ++page;
        return true;
    }
    function prev(){
        if (first())
             return false;
        --page;
        return true;
    }
    function currentPage(){
       // alert("Page: " + page);
        return page;
    }

    function destroy(){
        page = undefined;
        pagecount = 0;
        model = null;
    }

    return {
        setPage: setPage,
        initPage: initPage,
        setPageCount: setPageCount,
        getPageCount: getPageCount,
        next: next,
        prev: prev,
        currentPage: currentPage,
        getModel: getModel,
        destroy: destroy

    }

}]);



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
                return  _onViewCRUD(options.queryParams);
            case galleryConfig.CRUDVActions.LIST:
                return  _onListCRUD();
            case galleryConfig.CRUDVActions.EDIT:
                return  _onEditCRUD(options.queryParams);
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

    function testClass(){
        console.log('parent class');
    }


    function _onViewCRUD(queryParams) {
        return resourceWrapper(entity.options.item, entity.factory.get(queryParams), true);
    }
  /*  this._onViewCRUD = function(id) {
        return resourceWrapper(entity.options.item, entity.factory.get({ id: id }), true);
    };*/

    function _onListCRUD(){
        return resourceWrapper(entity.options.list, entity.factory.query(), true);
    }

    function _onEditCRUD (queryParams){
        return resourceWrapper(entity.options.item, entity.factory.get(queryParams), true);
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

    return {
        testClass: testClass,
        resourceWrapper: resourceWrapper,
        onViewCRUD: _onViewCRUD,
        onListCRUD: _onListCRUD,
        onEditCRUD: _onEditCRUD,
        onCreateCRUD: _onCreateCRUD,
        onUpdateCRUD: _onUpdateCRUD,
        onDeleteCRUD: _onDeleteCRUD

    };

}



var GalleryInstance = function(entity,galleryConfig){
    var parent = CRUDService.apply(this, arguments);

    var parentCurState = this._curState;
    var _curState = function(options) {
        var local = parentCurState.apply(this, arguments);
        if (local)
            return local;
        switch (options.state) {
            case galleryConfig.CRUDVActions.VIEW_WITH_COLLECTION:
               // return  this._onViewCRUD.apply(this, arguments);
                console.log(galleryConfig.CRUDVActions.VIEW_WITH_COLLECTION);
                options.queryParams.verb = galleryConfig.VERBS.INDEX;
                return parent.onViewCRUD(options.queryParams);
               // return locTest.testClass();
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


var CategoryInstance = function(entity,galleryConfig){
    var parent = CRUDService.apply(this, arguments);

    var parentCurState = this._curState;
    var _curState = function(options) {
        var local = parentCurState.apply(this, arguments);
        if (local)
            return local;
        switch (options.state) {
            case galleryConfig.CRUDVActions.VIEW_WITH_THUMB:
                options.queryParams.verb = galleryConfig.VERBS.THUMB;
                return parent.onViewCRUD(options.queryParams);
            case galleryConfig.CRUDVActions.VIEW_WITH_MIDDLE:
                options.queryParams.verb = galleryConfig.VERBS.MIDDLE;
                return parent.onViewCRUD(options.queryParams);
            case galleryConfig.CRUDVActions.VIEW_WITH_ORIG:
                options.queryParams.verb = galleryConfig.VERBS.ORIG;
                return parent.onViewCRUD(options.queryParams);
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

CategoryInstance.$inject = ['Category', 'galleryConfig'];
galleryServices.factory('CategoryHandler',CategoryInstance);


