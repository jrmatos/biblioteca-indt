(function () {
    'use strict';

    angular.module('library')
    .factory('LibraryService', LibraryService);

    LibraryService.$inject = ['ENDPOINTS', '$http'];

    function LibraryService(ENDPOINTS, $http) {

        var _getBooks = function () {
            return $http.get(ENDPOINTS.listBooks);
        }

        return {
            getBooks: _getBooks
        }
    }

})();