'use strict';

var postsServices = angular.module('postsServices', []);

var apiHost='http://localhost:8080';

postsServices.factory('PostsFactory', function ($resource) {
    return $resource(apiHost + '/posts', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

postsServices.factory('PostFactory', function ($resource) {
    return $resource(apiHost + '/posts/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});

postsServices.factory('CommentsFactory', function($resource) {
    return $resource(apiHost + 'comments')
})
