// Client-side JavaScript, bundled and sent to client.
/**
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org/>
**/



/**
* Templates
*/

Session.setDefault('instance_id', null);

var instancesHandle = Meteor.subscribe("instances"); ;

Template.instances.instances  = function () {
  return Instances.find({name : 'calculateArea'});
}


Template.instances.events({
  'mousedown .instance': function (evt) { // select instance
    Session.set("instance_id", this._id);
    this.navigate(this._id, true);
  },
  'click .instance': function (evt) {
    // prevent clicks on <a> from refreshing the page.
    evt.preventDefault();
  }
});

Template.instance.instance_selected = function () {
  return !Session.equals('instance_id', null);
};

Template.instance.instance = function () {

  var instance_id = Session.get('instance_id');

  if (!instance_id) {
    return {};
  }
  return Instances.find({_id: instance_id})  ;

};


Template.instance.varsAsString = function () {
  var output = "" ;
  for(var k in this.vars) { 
      output += k + ": "+JSON.stringify(this.vars[k]) + "\n" ;
  }
  
  return output;
}