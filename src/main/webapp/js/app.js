angular.module("getstudentlist.services", ["ngResource"]).
    factory('Student', function ($resource) {
        var Student = $resource('/api/v1/students/:studentId', {studentId: '@id'});
        Student.prototype.isNew = function(){
            return (typeof(this.id) === 'undefined');
        }
        return Student;
    });

angular.module("getstudentlist", ["getstudentlist.services"]).
    config(function ($routeProvider) {
        $routeProvider
            .when('/', {templateUrl: 'views/students/list.html', controller: StoryListController})
            .when('/students/new', {templateUrl: 'views/students/create.html', controller: StoryCreateController})
            .when('/students/:studentId', {templateUrl: 'views/students/detail.html', controller: StoryDetailController});
    });
    
 
function StoryListController($scope, Student) {
    $scope.students = Student.query();
    
   $scope.delete = function (id) {

        $scope.student = Student.delete({studentId: id});
    };
  
}

function StoryCreateController($scope, $routeParams, $location, Student) {

    $scope.student = new Student();

    $scope.save = function () {
    	$scope.student.$save(function (student, headers) {
    		toastr.success("Submitted New Story");
            $location.path('/');
        });
    };
}


function StoryDetailController($scope, $routeParams, $location, Student) {
    var studentId = $routeParams.studentId;
    $scope.student = Student.get({studentId: studentId});
    
    $scope.save = function () {
    	$scope.student.$save(function (student, headers) {
    		toastr.success("Updated the Student Details..");
            $location.path('/');
        });
    };
    
     $scope.delete = function (id) {
        $scope.student = Student.get({studentId: studentId});
    	$scope.student.$delete(function (student, headers) {
    		toastr.success("Deleted..");
            $location.path('/');
        });
    };
  }
  


