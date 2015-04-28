function isInArray(x, arr) {
    
    for (var i = 0, l = arr.length; i < l; i++) {
        if ( x == arr[i] ) {
            return true;
        }
    }
    
    return false;
    
}
function loadValues() {
  var questions = [];
  var categories = []; var categoriesIndex = 0;
  var classes = []; var classesIndex = 0;
  var categoriesWithQuestions = [];
  var classesWithQuestions = [];
  for (var i = 0, l = server_questions.length; i < l; i ++) {
    var q = server_questions[i];
    categoriesWithQuestions[categoriesWithQuestions.length] = q.fkCategory;
    questions[questions.length] = new Question(q.id, q.question, q.answer, q.level, q.fkCategory, q.fkClass);
  }
  for (var i = 0, l = server_categories.length; i < l; i ++) {
    var c = server_categories[i];
    if (isInArray(c.id, categoriesWithQuestions)){
        categories[categories.length] = new Category(c.id, c.name, c.fkClass);
        classesWithQuestions[classesWithQuestions.length] = c.fkClass;
    }
  }
  for (var i = 0, l = server_classes.length; i < l; i ++) {
    var c = server_classes[i];
    if (isInArray(c.id, classesWithQuestions))
        classes[classes.length] = new Class(c.id, c.name);
  }
  profileVM.questions(questions);
  profileVM.categories(categories);
  profileVM.classes(classes);
}

function Question(id, question, answer, level, fkCategory, fkClass) {
  var self = this;

  self.id = id;
  self.question = question;
  self.answer = answer;
  self.level = level;
  self.fkCategory = fkCategory;
  self.fkClass = fkClass;
}
function Category(id, name, fkClass) {
  var self = this;

  self.id = id;
  self.name = name;
  self.fkClass = fkClass;
}
function Class(id, name) {
  var self = this;

  self.id = id;
  self.name = name;
}

function GameProfileViewModel() {
  var self = this;

  // defaults
  self.defaultQuestion = {
    id: -1,
    answer: 'What is the answer?',
    question: 'Give a clue to the answer.',
    level: 0,
    fkCategory: -1,
    fkClass: -1
  };
  self.defaultCategory = {
    id: -1,
    name: 'Category name',
    fkClass: -1
  };
  self.defaultClass = {
    id: -1,
    name: 'Class name',
  };

  self.name = ko.observable("No name");

  self.selectedCategory1 = ko.observable().extend( { clearArrayOnChange: {'arrayParent': self, 'array': 'selectedQuestions1' }} );
  self.selectedClass1 = ko.observable();
  self.categories1 = ko.computed(function() {
    if (self.selectedClass1()){
      return ko.utils.arrayFilter( self.categories(), function(category) {
        return category.fkClass == self.selectedClass1();
      });
     }else {
       return [];
     }
  }, self);
  self.questions1 = ko.computed(function() {
    if (self.selectedClass1() && self.selectedCategory1()){
      return ko.utils.arrayFilter( self.questions(), function(question) {
        return question.fkCategory == self.selectedCategory1();
      });
     }else {
       return [];
     }
  }, self);
  self.selectedQuestions1 = ko.observableArray([]);

  self.selectedCategory2 = ko.observable().extend( { clearArrayOnChange: {'arrayParent': self, 'array': 'selectedQuestions2' }} );
  self.selectedClass2 = ko.observable();
  self.categories2 = ko.computed(function() {
    if (self.selectedClass2()){
      return ko.utils.arrayFilter( self.categories(), function(category) {
        return category.fkClass == self.selectedClass2();
      });
     }else {
       return [];
     }
  }, self);
  self.questions2 = ko.computed(function() {
    if (self.selectedClass2() && self.selectedCategory2()){
      return ko.utils.arrayFilter( self.questions(), function(question) {
        return question.fkCategory == self.selectedCategory2();
      });
     }else {
       return [];
     }
  }, self);
  self.selectedQuestions2 = ko.observableArray([]);

  self.selectedCategory3 = ko.observable().extend( { clearArrayOnChange: {'arrayParent': self, 'array': 'selectedQuestions3' } });
  self.selectedClass3 = ko.observable();
  self.categories3 = ko.computed(function() {
    if (self.selectedClass3()){
      return ko.utils.arrayFilter( self.categories(), function(category) {
        return category.fkClass == self.selectedClass3();
      });
     }else {
       return [];
     }
  }, self);
  self.questions3 = ko.computed(function() {
    if (self.selectedClass3() && self.selectedCategory3()){
      return ko.utils.arrayFilter( self.questions(), function(question) {
        return question.fkCategory == self.selectedCategory3();
      });
     }else {
       return [];
     }
  }, self);
  self.selectedQuestions3 = ko.observableArray([]);

  self.selectedCategory4 = ko.observable().extend( { clearArrayOnChange: {'arrayParent': self, 'array': 'selectedQuestions4' } });
  self.selectedClass4 = ko.observable();
  self.categories4 = ko.computed(function() {
    if (self.selectedClass4()){
      return ko.utils.arrayFilter( self.categories(), function(category) {
        return category.fkClass == self.selectedClass4();
      });
     }else {
       return [];
     }
  }, self);
  self.questions4 = ko.computed(function() {
    if (self.selectedClass4() && self.selectedCategory4()){
      return ko.utils.arrayFilter( self.questions(), function(question) {
        return question.fkCategory == self.selectedCategory4();
      });
     }else {
       return [];
     }
  }, self);
  self.selectedQuestions4 = ko.observableArray([]);

  self.selectedCategory5 = ko.observable().extend( { clearArrayOnChange: {'arrayParent': self, 'array': 'selectedQuestions5' } });
  self.selectedClass5 = ko.observable();
  self.categories5 = ko.computed(function() {
    if (self.selectedClass5()){
      return ko.utils.arrayFilter( self.categories(), function(category) {
        return category.fkClass == self.selectedClass5();
      });
     }else {
       return [];
     }
  }, self);
  self.questions5 = ko.computed(function() {
    if (self.selectedClass5() && self.selectedCategory5()){
      return ko.utils.arrayFilter( self.questions(), function(question) {
        return question.fkCategory == self.selectedCategory5();
      });
     }else {
       return [];
     }
  }, self);
  self.selectedQuestions5 = ko.observableArray([]);

  // assets
  self.questions = ko.observableArray([]);
  self.categories = ko.observableArray([]);
  self.classes = ko.observableArray([]);

  self.questionsPerCategory = 1;

  self.validGame = ko.computed(function() {
    var baseName = 'selectedQuestions';
    for (var i = 1, l = 5; i <= l; i ++) {
      var questionsArrayName = baseName + i;
      var categoryQuestions = self[questionsArrayName]();
      if (categoryQuestions.length != self.questionsPerCategory) {
        return false;
      }
    }
    return self.name() && true;
  });

  self.sendData = function() {

    var data = new Object();
    var questions = ko.toJS(self.selectedQuestions1());
    questions = questions.concat(ko.toJS(self.selectedQuestions2()));
    questions = questions.concat(ko.toJS(self.selectedQuestions3()));
    questions = questions.concat(ko.toJS(self.selectedQuestions4()));
    questions = questions.concat(ko.toJS(self.selectedQuestions5()));

    console.log(questions);
    data.questions = questions;
    data.name = self.name();

    $.ajax({
      url: 'GameProfile',
      type: 'POST',
      dataType: 'json',
      data: JSON.stringify(data),
      contentType: 'application/json',
      mimeType: 'application/json'
    }).done(function(data) {
      console.log("Id of created game profile: " + data.id);
    }).fail(function(data) {
      console.log(data);
    })
  }

}

var profileVM = new GameProfileViewModel();
ko.applyBindings(profileVM);
loadValues();
