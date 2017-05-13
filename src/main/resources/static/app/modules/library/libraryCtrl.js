(function () {
    'use strict';

    angular.module('library')
    .controller('LibraryCtrl', LibraryCtrl);

    LibraryCtrl.$inject = ['initialBookList'];

    function LibraryCtrl(initialBookList) {
        var vm = this;

        vm.books = initialBookList.data;


        vm.modal = {
            title: '',
            book: {},
            open: function (book) {
                this.title = (book) ? 'Editar livro' : 'Novo livro'; 
                angular.element('#book-modal').modal('toggle');
            },
            close: function () {
                angular.element('#book-modal').modal('toggle');
            }
        }

    }

})();