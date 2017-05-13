(function () {
    'use strict';

    angular.module('app')
    .constant('HOST', 'http://localhost:8090')
    .constant('ENDPOINTS', {
        addBook: '/book/',
        removeBook: '/book/',
        editBook: '/book/',
        findBooks: '/book/find'
    });
    
})();