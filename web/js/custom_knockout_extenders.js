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

ko.extenders.logChange = function(target, option) {

  target.subscribe(function(newValue, event) {
    // aquí va el ajax... si tan solo pudiera obtener el elemento del DOM también para sacar
    // toda la fila
    console.log(option + ": " + newValue);
  });

};
