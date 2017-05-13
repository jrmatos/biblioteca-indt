(function () {
    'use strict';

    angular.module('library')
    .factory('LibraryService', LibraryService);

    LibraryService.$inject = ['HOST', 'ENDPOINTS', '$http'];

    function LibraryService(HOST, ENDPOINTS, $http) {

        var _findBooks = function () {
            return $http.get(HOST + ENDPOINTS.findBooks);
        }

        var _saveBook = function (book) {
            return $http.post(HOST + ENDPOINTS.saveBook, book);
        }

        var _removeBook = function (bookId) {
            return $http.delete(HOST + ENDPOINTS.removeBook + '/' + bookId);
        }

        return {
            findBooks: _findBooks,
            saveBook: _saveBook,
            removeBook: _removeBook
        }
    }

})();