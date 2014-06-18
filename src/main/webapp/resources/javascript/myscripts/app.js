angular.module('forum', [
        'ngRoute',
        'ngSanitize',
        'forumControllers'
    ]).config(
    [
        '$routeProvider',

        function($routeProvider) {
            $routeProvider.
                when(
                '/',
                {
                    templateUrl: '/html/main.html',
                    controller: 'MainCtrl'
                }
            )

            $routeProvider.
                when(
                '/add_topic',
                {
                    templateUrl: '/html/add_topic.html',
                    controller: 'AddTopicCtrl'
                }
            )

            $routeProvider.
                when(
                '/topic_page/:param',
                {
                    templateUrl: '/html/topic_page.html',
                    controller: 'TopicPageCtrl'
                }
            )
        }
    ]
);
