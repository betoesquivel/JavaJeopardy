ko.extenders.liveEditor = function(target, options) {

  target.type = options.type;
  if (target.type == 'select'){
    target.options = options.selectOptions;
  }

  target.editing = ko.observable(false);

  target.edit = function(data, event) {
    target.editing(true);
    $(event.target).next('input').focus().select();
  };
  target.stopEditing = function() {
    target.editing(false);
  };

  target.deleteClass = function(self, index) {
    self.classes.remove( self.classes()[index] );
  };

  return target;

};

ko.extenders.logChange = function(target, element) {

  target.subscribe(function(newValue) {
    // aquí va el ajax... si tan solo pudiera obtener el elemento del DOM también para sacar
    // toda la fila
    object = element.object;
    type = element.type;
    
    console.log("entering the subscribe test 4 function");

    var data = new Object();
    data.type = type;
    data.object = ko.toJSON(object);
    data.action = "update";
    switch(type){
      case 'Question':
        console.log(object.id + ": " + object.question());
        break;
      case 'Category':
        console.log(object.id + ": " + object.name());
        break;
      case 'Class':
        console.log(object.id + ": " + object.name());
        console.log("Clase");
        break;
    }
    console.log(data);
    console.log(JSON.stringify(data));
    $.ajax({
      url: "ManageAssets",
      type: "POST",
      dataType: "json",
      data: JSON.stringify(data),
      contentType: 'application/json',
      mimeType: 'application/json',
    }).done(function(data){
        console.log(data);
        object.id = data.id;
    }).fail(function(data){
        console.log("ERROR");
        console.log(data);
    });
  });

};

ko.extenders.clearArrayOnChange = function(target, arrayInfo) {

  target.subscribe(function(newValue) {
    console.log("Change in value");
    arrayInfo.arrayParent[ arrayInfo.array ]([]);
  });

};
