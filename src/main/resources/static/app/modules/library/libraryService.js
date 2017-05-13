(function () {
    'use strict';

    angular.module('library')
    .factory('LibraryService', LibraryService);

    LibraryService.$inject = ['HOST', 'ENDPOINTS', '$http'];

    function LibraryService(HOST, ENDPOINTS, $http) {

        var _bookFilterToQueryString = function (bookFilter) {
            if(!bookFilter) return;

            var filters = [];
            Object.keys(bookFilter).forEach(function (attrName) {
                filters.push(attrName + '=' + bookFilter[attrName]);
            });

            return filters.join('&');
        }

        var _findBooks = function (bookFilter) {
            return $http.get(HOST + ENDPOINTS.findBooks + '?' + _bookFilterToQueryString(bookFilter));
        }

        var _saveBook = function (book) {
            return $http.post(HOST + ENDPOINTS.saveBook, book);
        }

        var _updateBook = function (book) {
            var url = HOST + ENDPOINTS.updateBook;
            return $http.put(url, book);
        }

        var _removeBook = function (bookId) {
            return $http.delete(HOST + ENDPOINTS.removeBook + '/' + bookId);
        }

        return {
            findBooks: _findBooks,
            saveBook: _saveBook,
            removeBook: _removeBook,
            updateBook: _updateBook
        }
    }

})();