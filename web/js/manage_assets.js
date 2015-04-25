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
  assetsVM.questions(questions);
  assetsVM.categories(categories);
  assetsVM.classes(classes);
}
function Question(id, question, answer, level, fkCategory, fkClass) {
  var self = this;

  self.id = id;
  self.question = ko.observable(question).extend({liveEditor: {type:"text"}, logChange: "Element: "});
  self.answer = ko.observable(answer).extend({liveEditor: {type:"text"}, logChange: "Element: "});
  self.level = ko.observable(level).extend({liveEditor: {type:"text"}, logChange: "Element: "});
  self.fkCategory = ko.observable(fkCategory).extend({liveEditor: {type:"text"}, logChange: "Element: "});
  self.fkClass = ko.observable(fkClass).extend({liveEditor: {type:"text"}, logChange: "Element: "});

}

function Category(id, name, fkClass) {
  var self = this;

  self.id = id;
  self.name = ko.observable(name).extend({liveEditor: {type:"text"}, logChange: "Element: "});
  self.fkClass = ko.observable(fkClass).extend({liveEditor: {type:"text"}, logChange: "Element: "});

}

function Class(id, name, categories) {
  var self = this;

  self.id = id;
  self.name = ko.observable(name).extend({liveEditor: {type:"text"}, logChange: "Element"});

}

function AssetsViewModel() {
  var self = this;

  // defaults
  var defaultQuestion = {
    id: -1,
    answer: 'What is the answer?',
    question: 'Give a clue to the answer.',
    level: 0,
    fkCategory: -1,
    fkClass: -1
  };
  var defaultCategory = {
    id: -1,
    name: 'Category name',
    fkClass: -1
  };
  var defaultClass = {
    id: -1,
    name: 'CLass name',
  };

  self.selectedClassCategory = ko.observable();
  self.selectedClassQuestion = ko.observable();
  self.selectedCategoryQuestion = ko.observable();

  // assets
  self.questions = ko.observableArray([]);
  self.categories = ko.observableArray([]);
  self.classes = ko.observableArray([]);

  self.filteredCategories = ko.computed(function() {
    if (self.selectedClassCategory()){
      return ko.utils.arrayFilter( self.categories(), function(category) {
        return category.fkClass() == self.selectedClassCategory();
      });
     }else {
       return [];
     }
  }, self);

  self.filteredCategoriesQuestions = ko.computed(function() {
    if (self.selectedClassQuestion()){
      return ko.utils.arrayFilter( self.categories(), function(category) {
        return category.fkClass() == self.selectedClassQuestion();
      });
     }else {
       return [];
     }
  }, self);

  self.filteredQuestions = ko.computed(function() {
    if (self.selectedClassQuestion() && self.selectedCategoryQuestion()){
      return ko.utils.arrayFilter( self.questions(), function(question) {
        return question.fkCategory() == self.selectedCategoryQuestion();
      });
     }else {
       return [];
     }
  }, self);

  self.isEditingQuestion = ko.computed(function() {
    ko.utils.arrayForEach(self.questions(), function(question) {
      if ( question.question.editing() || question.answer.editing() || question.level.editing() ){
        return true;
      }
    });
    return false;
  }, self);

  // add
  self.addQuestion = function(classId, categoryId) {

    defaultQuestion.fkCategory = categoryId;
    defaultQuestion.fkClass = classId;
    self.questions.push( new Question(
      defaultQuestion.id,
      defaultQuestion.question,
      defaultQuestion.answer,
      defaultQuestion.level,
      defaultQuestion.fkCategory,
      defaultQuestion.fkClass
    ) );

  };
  self.addCategory = function(classId) {

    defaultCategory.fkClass = classId;
    self.categories.push( new Category(defaultCategory.id, defaultCategory.name, defaultCategory.fkClass) );

  };
  self.addClass = function() {

    self.classes.push( new Class(defaultClass) );

  };

  // delete
  self.deleteQuestion = function(id) {

    self.questions.remove(function(question){
      return id == question.id;
    });

  };
  self.deleteCategory = function(id) {

    ko.utils.arrayForEach(self.questions(), function(question) {
      if (id == question.fkCategory){
        self.deleteQuestion(question.id);
      }
    });
    self.categories.remove(function(category) {
      return id == category.id;
    });

  };
  self.deleteClass = function(id) {

    console.log('deleting class');
    ko.utils.arrayForEach(self.categories(), function(category) {
      if (id == category.fkClass){
        self.deletecategory(category.id);
      }
    });
    self.classes.remove(function(classToDelete) {
      return id == classToDelete.id;
    });

  };

}

var assetsVM = new AssetsViewModel();
ko.applyBindings(assetsVM);
loadValues();
