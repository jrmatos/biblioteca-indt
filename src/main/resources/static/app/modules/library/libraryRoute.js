(function () {
    'use strict';

    angular.module('library')
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $stateProvider.state({
            name: 'library',
            url:'/biblioteca',
            templateUrl: 'app/modules/library/library.html',
            controller: 'LibraryCtrl',
            controllerAs: 'vm'
        });

        $urlRouterProvider.otherwise('/biblioteca');

    }]);

})();

