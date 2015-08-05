var coffeeApp = angular.module("coffeeApp",['ngResource']);

 coffeeApp.factory('CoffeeOrder',function ($resource){
    return $resource('/service/coffeeshop/:id/order/',
                {id:'@coffeeShopId'},{}
                );

});
coffeeApp.controller('DrinksController',function ($scope,CoffeeOrder){
    $scope.types =[{name:'Americano',family:'coffee'},
                    {name:'Latte',family:'coffee'},
                    {name:'Tea',family:'other'}
                    ]

    $scope.sizes = ['Small','Medium','Large']
    $scope.giveMeCoffee = function(){
        CoffeeOrder.save({$id:1},$scope.drink)}      })