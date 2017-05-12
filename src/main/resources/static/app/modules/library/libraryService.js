(function () {
    'use strict';

    angular.module('library')
    .factory('LibraryService', LibraryService);

    LibraryService.$inject = [];

    function LibraryService() {

        var _getBooks = function () {
            return [
                {
                    name: 'O melhor do JavaScript',
                    author: 'Douglas Crockford',
                    publisher: "O'Reilly",
                    year: 2008,
                    pages: 170,
                    isbn: 564891223
                },
                {
                    name: 'PHP. Programando com Orientação a Objetos',
                    author: "Pablo Dall'Oglio",
                    publisher: "Novatec",
                    year: 2015,
                    pages: 552 ,
                    isbn: 8575224654
                }
            ];
        }

        return {
            getBooks: _getBooks
        }
    }

})();