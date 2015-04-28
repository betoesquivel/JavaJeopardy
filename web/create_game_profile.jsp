<%-- 
    Document   : create_game_profile
    Created on : Apr 23, 2015, 8:23:48 PM
    Author     : betoesquivel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Create Game Profile</title>
  <link rel="stylesheet" href="css/foundation.css"/>
  <style>
    #footer {

      position: fixed;

      bottom: 0;

      width: 100%;

      height: 50px; /* choose any height */

    }
  </style>
</head>
<body>


  <div class="row section-header">
    <h2 class="text-center large-offset-2 medium-offset-2 small-offset-2 large-8 medium-8 small-8 columns">
      New Game Profile:
    </h2>
  </div>
  <div class="row name">
    <h3 class="text-center large-offset-2 medium-offset-2 small-offset-2 large-8 medium-8 small-8 columns" data-bind="text: name">
    </h3>
  </div>

  <div class="row profile-name">
    <div class="columns">
      Name your game profile: <input type="text" data-bind="textInput: name" />
    </div>
  </div>

  <fieldset class="row category-1">
    <legend>Category 1</legend>
    <div class="row section-selects">
      <select class="large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "options: classes,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedClass1,
        optionsCaption: 'choose a class:'"></select>
      <select class="end large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "visible: selectedClass1,
        options: categories1,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedCategory1,
        optionsCaption: 'choose a category:'"></select>
    </div>
    <div class="row">
      <table class="columns">
        <thead>
          <tr>
            <th>question</th>
            <th>answer</th>
            <th>level</th>
            <th>selected</th>
          </tr>
        </thead>
        <tbody data-bind="foreach: questions1">
          <tr>
            <td>
              <div>
                <div data-bind="text: question"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: answer"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: level"></div>
              </div>
            </td>
            <td >
              <div>
                <input type="checkbox" data-bind="checked: $root.selectedQuestions1, attr: { value: id }"/>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </fieldset>

  <fieldset class="row category-1">
    <legend>Category 2</legend>
    <div class="row section-selects">
      <select class="large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "options: classes,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedClass2,
        optionsCaption: 'choose a class:'"></select>
      <select class="end large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "visible: selectedClass2,
        options: categories2,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedCategory2,
        optionsCaption: 'choose a category:'"></select>
    </div>
    <div class="row">
      <table class="columns">
        <thead>
          <tr>
            <th>question</th>
            <th>answer</th>
            <th>level</th>
            <th>selected</th>
          </tr>
        </thead>
        <tbody data-bind="foreach: questions2">
          <tr>
            <td>
              <div>
                <div data-bind="text: question"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: answer"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: level"></div>
              </div>
            </td>
            <td >
              <div>
                <input type="checkbox" data-bind="checked: $root.selectedQuestions2, attr: { value: id }"/>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </fieldset>

  <fieldset class="row category-3">
    <legend>Category 3</legend>
    <div class="row section-selects">
      <select class="large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "options: classes,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedClass3,
        optionsCaption: 'choose a class:'"></select>
      <select class="end large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "visible: selectedClass3,
        options: categories3,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedCategory3,
        optionsCaption: 'choose a category:'"></select>
    </div>
    <div class="row">
      <table class="columns">
        <thead>
          <tr>
            <th>question</th>
            <th>answer</th>
            <th>level</th>
            <th>selected</th>
          </tr>
        </thead>
        <tbody data-bind="foreach: questions3">
          <tr>
            <td>
              <div>
                <div data-bind="text: question"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: answer"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: level"></div>
              </div>
            </td>
            <td >
              <div>
                <input type="checkbox" data-bind="checked: $root.selectedQuestions3, attr: { value: id }"/>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </fieldset>

  <fieldset class="row category-4">
    <legend>Category 4</legend>
    <div class="row section-selects">
      <select class="large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "options: classes,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedClass4,
        optionsCaption: 'choose a class:'"></select>
      <select class="end large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "visible: selectedClass4,
        options: categories4,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedCategory4,
        optionsCaption: 'choose a category:'"></select>
    </div>
    <div class="row">
      <table class="columns">
        <thead>
          <tr>
            <th>question</th>
            <th>answer</th>
            <th>level</th>
            <th>selected</th>
          </tr>
        </thead>
        <tbody data-bind="foreach: questions4">
          <tr>
            <td>
              <div>
                <div data-bind="text: question"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: answer"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: level"></div>
              </div>
            </td>
            <td >
              <div>
                <input type="checkbox" data-bind="checked: $root.selectedQuestions4, attr: { value: id }"/>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </fieldset>
  <fieldset class="row category-5">
    <legend>Category 5</legend>
    <div class="row section-selects">
      <select class="large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "options: classes,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedClass5,
        optionsCaption: 'choose a class:'"></select>
      <select class="end large-offset-2 medium-offset-2 small-offset-2 large-3 medium-3 small-3 columns" data-bind=
        "visible: selectedClass5,
        options: categories5,
        optionsText: 'name',
        optionsValue: 'id',
        value: selectedCategory5,
        optionsCaption: 'choose a category:'"></select>
    </div>
    <div class="row">
      <table class="columns">
        <thead>
          <tr>
            <th>question</th>
            <th>answer</th>
            <th>level</th>
            <th>selected</th>
          </tr>
        </thead>
        <tbody data-bind="foreach: questions5">
          <tr>
            <td>
              <div>
                <div data-bind="text: question"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: answer"></div>
              </div>
            </td>
            <td >
              <div>
                <div data-bind="text: level"></div>
              </div>
            </td>
            <td >
              <div>
                <input type="checkbox" data-bind="checked: $root.selectedQuestions5, attr: { value: id }"/>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </fieldset>

  <div class="row">
    <br>
  </div>
  <div class="row">
    <div id="warning" data-alert class="alert-box warning" data-bind="visible: !validGame()">
      You need to name your game profile and select exactly 5 classes per category.
    </div>
    <div id="success" data-alert class="alert-box success" data-bind="visible: !validGame()">
      Successfully created game profile.
    </div>
    <a id="button" class="large-offset-3 medium-offset-3 small-offset-3 large-6 medium-6 small-6columms button" href="#"
      data-bind="visible: validGame, click: sendData">Create Game Profile</a>
  </div>

  <script src="js/vendor/jquery.js"></script>
  <script src="js/vendor/knockout-3.3.0.js"></script>
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
  <script src="js/custom_knockout_extenders.js"></script>
  <script src="js/create_game_profile.js"></script>
</body>
</html>
