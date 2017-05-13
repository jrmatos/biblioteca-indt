(function () {
    'use strict';

    angular.module('library')
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $stateProvider.state({
            name: 'library',
            url:'/biblioteca',
            templateUrl: 'app/modules/library/library.html',
            controller: 'LibraryCtrl',
            controllerAs: 'vm',
            resolve: {
                initialBookList: ['LibraryService', function (LibraryService) {
                    return LibraryService.findBooks();
                }]
            }
        });

        $urlRouterProvider.otherwise('/biblioteca');

    }]);

})();

