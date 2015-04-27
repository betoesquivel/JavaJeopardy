function loadValues() {
  questions = [];
  for (var i = 0, l = sample_questions.length; i < l; i ++) {
    var q = sample_questions[i];
    questions[questions.length] = new Question(q.id, q.question, q.answer, q.level, q.fkCategory, q.fkClass);
  }
  categories = [];
  for (var i = 0, l = sample_categories.length; i < l; i ++) {
    var c = sample_categories[i];
    categories[categories.length] = new Category(c.id, c.name, c.fkClass);
  }
  classes = [];
  for (var i = 0, l = sample_classes.length; i < l; i ++) {
    var c = sample_classes[i];
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

  self.selectedCategory1 = ko.observable().extend( { clearArrayOnChange: self.selectedQuestions1 } );
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

  self.selectedCategory2 = ko.observable().extend( { clearArrayOnChange: self.selectedQuestions1 } );;
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

  self.selectedCategory3 = ko.observable().extend( { clearArrayOnChange: self.selectedQuestions1 } );;
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

  self.selectedCategory4 = ko.observable().extend( { clearArrayOnChange: self.selectedQuestions1 } );;
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

  self.selectedCategory5 = ko.observable().extend( { clearArrayOnChange: self.selectedQuestions1 } );;
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

}

var profileVM = new GameProfileViewModel();
ko.applyBindings(profileVM);
loadValues();
