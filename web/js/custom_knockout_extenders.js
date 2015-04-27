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

    var data = new Object();
    data.type = type;
    data.object = ko.toJSON(object);
    switch(type){
      case 'Question':
        console.log(object.id + ": " + object.question());
        break;
      case 'Category':
        console.log(object.id + ": " + object.name());
        break;
      case 'Class':
        console.log(object.id + ": " + object.name());
        break;
    }

    $.ajax({
      url: "ManageAssets",
      type: "POST",
      dataType: "json",
      data: JSON.stringify(data),
      contentType: 'application/json',
      mimeType: 'application/json',
      error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
      }
    });
  });

};