(function () {
    'use strict';

    angular.module('library')
    .factory('LibraryService', LibraryService);

    LibraryService.$inject = ['HOST', 'ENDPOINTS', '$http'];

    function LibraryService(HOST, ENDPOINTS, $http) {

        var _findBooks = function () {
            return $http.get(HOST + ENDPOINTS.findBooks);
        }

        return {
            findBooks: _findBooks
        }
    }

})();