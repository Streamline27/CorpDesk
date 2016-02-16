'use strict';

var apiHost='http://localhost:8080';

var mailControllers = angular.module('mailControllers', []);

mailControllers.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});

mailControllers.controller('FolderListCtrl', ['$scope', '$http', '$location',
    function($scope, $http, $location) {
        var ctrl = this;

        $http({
            method: 'GET',
            url: apiHost + '/mail/folder/list'
        }).success(function (data) {
            ctrl.folders = data;
            // load right after folder load first folder messages
            if (ctrl.folders && ctrl.folders.length > 0)
                ctrl.viewFolder(ctrl.folders[0]);
        }).catch(function (err) {
            alert(err.data);
        });

        $scope.selectedRecipient = null;
        $scope.messageRecipients = [];
        $http({
            method: 'GET',
            url: apiHost + '/user'
        }).success(function (data) {
            $scope.messageRecipients = data;
        }).catch(function (err) {
            alert(err.data);
        })

        ctrl.viewFolder = function (folder) {
            $scope.folder = folder;
            /*ctrl.folder2 = folder;*/

            $http({
                method: 'GET',
                url: apiHost + '/mail/message/list?folderId=' + $scope.folder.id
            }).success(function (data) {
                ctrl.messages = data;
            }).catch(function (err) {
                alert(err.data);
            });
        }

        ctrl.viewMessage = function (message) {
            $scope.messageId = message.messageId;

            $http({
                method: 'GET',
                url: apiHost + '/mail/message?messageId=' + $scope.messageId
            }).success(function (data) {
                /* ctrl.message = data; */
                $scope.messageTitle = data.title;
                $scope.messageBody = data.body;
                $scope.messageIsImportant = data.isImportant;
            }).catch(function (err) {
                alert(err.data);
            });
        }

        ctrl.clearMessage = function () {
            $scope.messageTitle = "";
            $scope.messageBody = "";
            $scope.messageIsImportant = false;
            $scope.selectedRecipient = null;
        }

        ctrl.sendMessage = function () {
            var message;
            var recipientList = [];

            recipientList.push($scope.selectedRecipient);
            message = {
                sender: {
                    id: $scope.loginContext.user.id
                },
                recipients: recipientList,
                title: $scope.messageTitle,
                body: $scope.messageBody,
                isImportant: $scope.messageIsImportant
            };

            $http({
                method: 'POST',
                url: apiHost + '/mail/message/send',
                data: message
            }).success(function () {
                alert("Message sent");
            }).catch(function (err) {
                if (err.data) {
                    alert(err.data);
                }
            })
        }

    }]);


mailControllers.controller('MessageComposeCtrl', ['$scope', '$http', '$location',
    function($scope, $http, $location) {
        var ctrl = this;

        $http({
            method: 'GET',
            url: apiHost + '/mail/compose'
        }).success(function(data) {
            ctrl.message = data;
        }).catch(function(err) {
            alert(err.data);
        });
    }]);