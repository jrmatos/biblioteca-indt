(function () {
    'use strict';

    angular.module('library')
    .factory('LibraryService', LibraryService);

    LibraryService.$inject = ['HOST', 'ENDPOINTS', '$http', '$q'];

    function LibraryService(HOST, ENDPOINTS, $http, $q) {

        var _bookFilterToQueryString = function (bookFilter) {
            if(!bookFilter) return '';

            var filters = [];
            Object.keys(bookFilter).forEach(function (attrName) {
                filters.push(attrName + '=' + bookFilter[attrName]);
            });

            return filters.join('&');
        }

        var _findBooks = function (bookFilter) {
            return $http.get(HOST + ENDPOINTS.findBooks + '?' + _bookFilterToQueryString(bookFilter))
                        .then(function (response) {
                            return $q.resolve(response);
                        })
                        .catch(function (e) {
                            console.error(e);
                            return $q.resolve([]);
                        });
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