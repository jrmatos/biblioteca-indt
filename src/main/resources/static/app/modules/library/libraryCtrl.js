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
            editingBookIndex: null,
            open: function (book, editingBookIndex) {  

                // editing
                if(book) {
                    this.title = 'Editar livro';
                    this.book = angular.copy(book);
                    this.editingBookIndex = editingBookIndex;
                }
                // creating
                else {
                    this.title = 'Novo livro';
                    this.book = {};
                     this.editingBookIndex = null;
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
                var promise = null;
                var successMessage = '';
                var self = this;

                if(this.book.id) {
                    promise = LibraryService.updateBook(this.book);
                    successMessage = 'Livro editado com sucesso!';
                }
                else {
                    promise = LibraryService.saveBook(this.book);
                    successMessage = 'Livro salvo com sucesso!';
                }

                promise
                    .then(function (response) {
                        if(typeof self.editingBookIndex === 'number') {
                            vm.books[self.editingBookIndex] = response.data;
                        }
                        else {
                            vm.books.unshift(response.data);
                        }
                        ngToast.create(successMessage);
                    })
                    .catch(function (e) {
                        console.error(e);
                        ngToast.create('Oops! Ocorreu um erro inesperado :(');
                    })
                    .finally(function () {
                        vm.isLoading = false;
                        angular.element('#book-modal').modal('toggle');
                    });
            }
        }


        vm.removeBook = function (bookId, $index) {
            if(confirm('Deseja mesmo remover esse livro?')) {
                LibraryService.removeBook(bookId)
                .then(function (response){
                    vm.books.splice($index, 1);
                    ngToast.create('Livro removido com sucesso!');
                })
                .catch(function (e) {
                    console.log(e)
                });
            }
        }


    }

})();