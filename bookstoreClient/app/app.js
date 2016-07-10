var bookstoreApp = angular.module('bookstoreApp', ['ngRoute', 'ngResource', 'hateoas']);

bookstoreApp.service('customerService', function() {
  this.user = "Jan Kowalski";
})

bookstoreApp.config(function (HateoasInterceptorProvider) {
  HateoasInterceptorProvider.transformAllResponses();
});


bookstoreApp.config(function($routeProvider) {
  $routeProvider
      .when('/', {
        templateUrl: 'pages/home.htm',
        controller: 'customerController'
      })
      .when('/bookstore', {
        templateUrl: 'pages/bookstore.htm',
        controller: 'bookController'
      })
      .when('/order', {
        templateUrl: 'pages/order.htm',
        controller: 'orderController'
      })
      .when('/author', {
        templateUrl: 'pages/author.htm',
        controller: 'authorController'
      });

})

bookstoreApp.directive('bookSelection', function() {
  return {
    restrict: 'E',
    templateUrl: 'directives/bookSelection.html',
    replace:true,
    scope: {
      bookObject: "="
    },
    controller : 'bookSelectionController'
  };
});

bookstoreApp.controller('customerController', ['$scope', 'customerService', function($scope, customerService) {
  $scope.user = customerService.user;
  $scope.$watch('user', function() {
    customerService.user = $scope.user;
  })

}]);

bookstoreApp.controller('bookController', ['$scope', '$resource', 'customerService', function($scope, $resource, customerService) {
  $scope.user = customerService.user;


  $scope.bookListApi = $resource("http://localhost:8080/books", {}, {get: { method:"GET", isArray:true}});
  $scope.bookListResult = $scope.bookListApi.get();
}]);

bookstoreApp.controller('orderController', ['$scope', '$resource', 'customerService', function($scope, $resource, customerService) {
  $scope.orderApi = customerService.lastSelectedBook.resource("order", {}, {post: { method:"POST"}});
  $scope.orderResult = $scope.orderApi.post();
  $scope.customerService = customerService;
}]);

bookstoreApp.controller('authorController', ['$scope', '$routeParams', '$resource', 'customerService', function($scope, $routeParams, $resource, customerService) {
  $scope.authorApi = customerService.lastSelectedBook.resource("author", {}, {get: { method:"GET"}});
  $scope.authorResult = $scope.authorApi.get();
  $scope.customerService = customerService;
}]);

bookstoreApp.controller('bookSelectionController', ['$scope', 'customerService', function ($scope, customerService) {
  $scope.$watch('selectedBook', function(value) {
    customerService.lastSelectedBook = value;
  })
}]);