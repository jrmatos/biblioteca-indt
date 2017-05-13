(function () {
    'use strict';

    angular.module('library')
    .controller('LibraryCtrl', LibraryCtrl);

    LibraryCtrl.$inject = ['initialBookList', 'LibraryService', 'ngToast'];

    function LibraryCtrl(initialBookList, LibraryService, ngToast) {
        var vm = this;

        vm.books = initialBookList.data;

        vm.modal = {
            title: '',
            book: {},
            form: null,
            open: function (book) {  

                // editing
                if(book) {
                    this.title = 'Editar livro';
                    this.book = angular.copy(book);
                }
                // creating
                else {
                    this.title = 'Novo livro';
                    this.book = {};
                } 

                // it was submitted at least once
                if(this.form) {
                    this.form.$setUntouched();
                }

                // open modal
                angular.element('#book-modal').modal('toggle');
            },
            save: function (bookForm) {
                // save form reference
                this.form = bookForm;

                vm.isLoading = true;
                LibraryService.saveBook(this.book)
                    .then(function (response) {
                        vm.books.unshift(response.data);
                        ngToast.create('Livro salvo com sucesso!');
                    })
                    .catch(function (e) {
                        ngToast.create('Oops! Ocorreu um erro inesperado :(');
                    })
                    .finally(function () {
                        vm.isLoading = false;
                        angular.element('#book-modal').modal('toggle');
                    });
            }
        }


    }

})();