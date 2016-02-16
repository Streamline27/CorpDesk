'use strict';

var postsServices = angular.module('postsServices', []);

var apiHost='http://localhost:8080';

postsServices.factory('PostsPageFactory', function ($resource) {
    return $resource(apiHost + '/posts/:page&:size', {}, {
        page: {method: 'GET', isArray: true, params: {page: '@page', size: '@size'}},
    })
});

postsServices.factory('PostsFactory', function ($resource) {
    return $resource(apiHost + '/posts', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' },
        update: { method: 'PUT' }
    })
});

postsServices.factory('PostFactory', function ($resource) {
    return $resource(apiHost + '/posts/:id', {}, {
        show: { method: 'GET' },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});

postsServices.factory('CommentsFactory', function($resource) {
    return $resource(apiHost + 'comments')
});
