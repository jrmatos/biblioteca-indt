(function () {
    'use strict';

    angular.module('app')
    .constant('ENDPOINTS', {
        addBook: '/book/',
        removeBook: '/book/',
        editBook: '/book/',
        listBooks: '/book/find'
    });
    
})();