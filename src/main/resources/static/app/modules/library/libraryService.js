(function () {
    'use strict';

    angular.module('library')
    .factory('LibraryService', LibraryService);

    LibraryService.$inject = [];

    function LibraryService() {
        return {
            // something here
        }
    }

})();