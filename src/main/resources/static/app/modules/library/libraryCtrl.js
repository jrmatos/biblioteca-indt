(function () {
    'use strict';

    angular.module('library')
    .controller('LibraryCtrl', LibraryCtrl);

    LibraryCtrl.$inject = [];

    function LibraryCtrl() {
         var vm = this;

         vm.text = 'hello world!';
    }

})();