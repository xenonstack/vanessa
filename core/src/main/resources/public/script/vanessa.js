/**
	vanessa.js
	XenonStack LLP.
 */

vanessa = angular.module("vanessa", ["ngRoute"]);

vanessa.config(function($routeProvider, $locationProvider) {
	$routeProvider
		.when('/search', {
			templateUrl : 'search.html',
			controller  : 'searchControl'
		}).when('/crawl', {
			templateUrl : 'crawl.html',
			controller  : 'crawlControl'
		}).when('/stats', {
			templateUrl : 'stats.html',
			controller  : 'statsControl'
		}).when('/admin', {
			templateUrl : 'admin.html',
			controller  : 'adminControl'
		}).otherwise({
			redirectTo : '/search'
		});
});

vanessa.controller('searchControl', function($scope){

});

vanessa.controller('crawlControl', function($scope){

});

vanessa.controller('statsControl', function($scope){

});

vanessa.controller('adminControl', function($scope){

});

$(document).ready(function(){
	$('#nav-collapse li').click(function(){
		$('#nav-collapse li').removeClass('active');
		this.setAttribute('class','active');
	});
});

/** EOF */