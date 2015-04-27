<%-- 
    Document   : manage_assets
    Created on : Apr 26, 2015, 6:41:38 PM
    Author     : betoesquivel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Manage Assets</title>
  <link rel="stylesheet" href="css/foundation.css"/>
</head>
<body>

  <div class="row section-header">
    <h2 class="large-6 medium-6 small-6 columns">manage classes</h2>
    <h2 class="large-3 medium-3 small-3 columns">manage categories</h2>
    <select class="large-3 medium-3 small-3 columns" data-bind=
                      "options: classes,
                       optionsText: 'name',
                       optionsValue: 'id',
                       value: selectedClassCategory,
                       optionsCaption: 'choose a class:'"></select>
  </div>
  <div class="row manage-classes">
    <table class="large-6 medium-6 small-6 columns">
      <thead>
        <tr>
          <th>class name</th>
        </tr>
      </thead>
      <tbody data-bind="foreach: classes">
        <tr>
          <td >
            <div class="editor">
              <div class="view" data-bind="visible: name.editing() == false, event: { dblclick: name.edit }, text: name() || 'Double click to edit'"></div>
              <input class="edit" type="text" data-bind="visible: name.editing(), value: name, event: {blur: name.stopEditing}" />
              <a class="" href="#" data-bind="visible: name.editing() == false, click: function(data, event) { $root.deleteClass(id); }">delete</a>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
    <table class="large-6 medium-6 small-6 columns">
      <thead>
        <tr>
          <th>category name</th>
        </tr>
      </thead>
      <tbody data-bind="foreach: filteredCategories()">
        <tr>
          <td >
            <div class="editor">
              <div class="view" data-bind="visible: name.editing() == false, event: { dblclick: name.edit }, text: name() || 'Double click to edit'"></div>
              <input class="edit" type="text" data-bind="visible: name.editing(), value: name, event: {blur: name.stopEditing}" />
              <a class="" href="#" data-bind="visible: name.editing() == false, click: function(data, event) { $root.deleteCategory($root.selectedClassCategory(), id); }">delete</a>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="row add-buttons">
    <button class="large-offset-1 medium-offset-1 small-offset-1 large-4 medium-4 small-4 columns" data-bind="click: addClass">Add a class</button>
    <button class="large-offset-2 medium-offset-2 small-offset-2 large-4 medium-4 small-4 end columns" 
      data-bind="click: addCategory($root.selectedClassCategory()), visible: selectedClassCategory">Add a category</button>
  </div>

  <div class="row section-header">
    <h2 class="text-center large-offset-2 medium-offset-2 small-offset-2 large-8 medium-8 small-8 columns">
      manage questions
    </h2>
  </div>
  <div class="row section-selects">
    <select class="large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
      "options: classes,
      optionsText: 'name',
      optionsValue: 'id',
      value: selectedClassQuestion,
      optionsCaption: 'choose a class:'"></select>
    <select class="end large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
      "visible: selectedClassQuestion,
      options: filteredCategoriesQuestions,
      optionsText: 'name',
      optionsValue: 'id',
      value: selectedCategoryQuestion,
      optionsCaption: 'choose a category:'"></select>
  </div>
  <div class="row manage-classes">
    <table class="columns">
      <thead>
        <tr>
          <th>question</th>
          <th>answer</th>
          <th>level</th>
        </tr>
      </thead>
      <tbody data-bind="foreach: filteredQuestions">
        <tr>
          <td >
            <div class="editor">
              <div class="view" data-bind="visible: question.editing() == false, event: { dblclick: question.edit }, text: question() || 'Double click to edit'"></div>
              <input class="edit" type="text" data-bind="visible: question.editing(), value: question, event: {blur: question.stopEditing}" />
            </div>
          </td>
          <td >
            <div class="editor">
              <div class="view" data-bind="visible: answer.editing() == false, event: { dblclick: answer.edit }, text: answer() || 'Double click to edit'"></div>
              <input class="edit" type="text" data-bind="visible: answer.editing(), value: answer, event: {blur: answer.stopEditing}" />
            </div>
          </td>
          <td >
            <div class="editor">
              <div class="view" data-bind="visible: level.editing() == false, event: { dblclick: level.edit }, text: level() || 'Double click to edit'"></div>
              <input class="edit" type="text" data-bind="visible: level.editing(), value: level, event: {blur: level.stopEditing}" />
              <a class="" href="#" data-bind="visible: $root.isEditingQuestion, click: function(data, event) { $root.deleteQuestion(id); }">delete</a>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="row add-buttons">
    <button class="large-offset-2 medium-offset-2 small-offset-2 large-8 medium-8 small-8 end columns" 
      data-bind="visible: selectedCategoryQuestion(), click: addQuestion(selectedClassQuestion(), selectedCategoryQuestion()), visible: selectedCategoryQuestion()">Add a question</button>
  </div>

  <script src="js/vendor/jquery.js"></script>
  <script src="js/vendor/knockout-3.3.0.js"></script>
  
  <script src="js/custom_knockout_extenders.js"></script>
  <script src="js/foundation.min.js"></script>
  <script src="js/sample_data.js"></script>
  <script>
      
    var questionsJSON = '${questionsJSON}';
    var categoriesJSON = '${categoriesJSON}';
    var classesJSON = '${classesJSON}';
    
    var server_questions = JSON.parse(questionsJSON);
    var server_categories = JSON.parse(categoriesJSON);
    var server_classes = JSON.parse(classesJSON);
      
  </script>
  <script src="js/manage_assets.js"></script>
</body>
</html>
