
var forumControllers = angular.module('forumControllers', []);

forumControllers.service('TopicService', ['$http', function($http){
        return {
            add: function (topic) {
                return $http.post('/topic/new', topic);
            },
            get: function () {
                return $http.get('/get_topics');
            },
            delete: function (id) {
                return $http.get('/topic/' + id + '/delete');
            }
        };
    }]
);

forumControllers.service('PostService', ['$http', function ($http) {
    return {
        get: function (id) {
            return $http.get('/get_posts/' + id);
        },
        add: function (id, text) {
            return $http.post('/topic/posts/new', text);
        },
        delete: function (id) {
            return $http.get('topic/posts/' +id + '/delete')
        }
    };
}]);

forumControllers.controller('MainCtrl', ['TopicService', '$scope', '$rootScope', function (TopicService, $scope, $rootScope) {

    TopicService.get().success(function (data) {
        $rootScope.topics = data;
        console.log($rootScope.topics)
    });


    $scope.delete = function(id) {
        TopicService.delete(id).success(function () {
            var find = false;
            for (var i = 0, len = $rootScope.topics.length; i < len && !find; i++) {
                if ($rootScope.topics[i].id == id) {
                    $rootScope.topics.splice(i,1);
                    find = true;
                }
            }
        });
    }
}]);

forumControllers.controller('AddTopicCtrl', ['TopicService', '$scope', function (TopicService, $scope) {
    $scope.addTopic = function () {
        TopicService.add($scope.text).success(function () {
            location.href = '/';
        });
    }
}]);

forumControllers.controller('TopicPageCtrl', ['$scope', '$routeParams', 'PostService', function ($scope, $routeParams, PostService) {
    $scope.this_id  = $routeParams.param;
    $scope.add = function() {
        PostService.add($scope.this_id, $scope.post);
    }
}]);