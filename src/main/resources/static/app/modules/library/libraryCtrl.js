(function () {
    'use strict';

    angular.module('library')
    .controller('LibraryCtrl', LibraryCtrl);

    LibraryCtrl.$inject = ['initialBookList'];

    function LibraryCtrl(initialBookList) {
         var vm = this;

        vm.books = initialBookList.data;

    }

})();