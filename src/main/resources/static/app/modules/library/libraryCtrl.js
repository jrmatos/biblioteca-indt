(function () {
    'use strict';

    angular.module('library')
    .controller('LibraryCtrl', LibraryCtrl);

    LibraryCtrl.$inject = ['LibraryService', 'ngToast', '$scope'];

    function LibraryCtrl(LibraryService, ngToast, $scope) {
        var vm = this;

        vm.books = [];
        vm.bookFilter = {};
        vm.page = 1;

        vm.findBooks = function () {
            LibraryService.findBooks(vm.bookFilter, vm.page)
                .then(function (response) {
                    vm.page = response.data.page;
                    vm.books[vm.page - 1] = response.data.books;
                    vm.totalBooks = response.data.totalBooks;
                    vm.pageSize = response.data.pageSize;
                    createPagination(vm.page, calculateTotalPages());
                })
                .catch(function (e) {
                    console.error(e);
                });
        }

        vm.clearBookFilter = function () {
            vm.bookFilter = {};
            vm.findBooks();
        }

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
                        vm.findBooks(); // reload books
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
                    vm.findBooks(); // reload books
                    ngToast.create('Livro removido com sucesso!');
                })
                .catch(function (e) {
                    console.log(e)
                });
            }
        }

        function createPagination (page, totalPages) {
            angular.element('#page-selection').bootpag({
                total: totalPages,
                page: page,
                maxVisible: 5,
                leaps: true,
                firstLastUse: true,
                first: '←',
                last: '→',
                wrapClass: 'pagination',
                activeClass: 'active',
                disabledClass: 'disabled',
                nextClass: 'next',
                prevClass: 'prev',
                lastClass: 'last',
                firstClass: 'first'
            }).on("page", function(event, num){
                vm.page = num;
                $scope.$apply();
                vm.findBooks();
            }); 
        }

        function calculateTotalPages() {
            return Math.ceil(vm.totalBooks / vm.pageSize);
        }

        vm.findBooks();


    }

})();