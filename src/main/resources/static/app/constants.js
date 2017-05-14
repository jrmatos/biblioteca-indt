(function () {
    'use strict';

    angular.module('app')
    .constant('ENDPOINTS', {
        saveBook: '/book/',
        removeBook: '/book/',
        updateBook: '/book/',
        findBooks: '/book/find'
    });
    
})();