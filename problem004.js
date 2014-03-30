String.prototype.reverse = function() {
  return this.split("").reverse().join("");
}

Number.prototype.mirrorize = function() {
  return this.constructor(this.toString() + this.toString().reverse());
}

Array.prototype.flatten = function() {
  var flattened = [];
  for (var i = 0; i < this.length; i++) {
    obj = this[i];
    if (obj instanceof Array) {
      inner = obj.flatten();
      for (var j = 0; j < inner.length; j++) {
        flattened.push(inner[j]);
      }
    } else {
      flattened.push(obj);
    }
  }
  return flattened;
}

Number.prototype.factor = function() {
  if (this == 1) {
    return [1];
  }

  var minFactor = arguments[0];
  if (minFactor == undefined)
    minFactor = 2;
  
  if (this < minFactor) {
    return ['giveup'];
  }

  var factors = [];

  for (var i = minFactor; i <= this; i++) {
    if ((this % i) == 0) {
      var prime = i;
      var remaining = this / i;
      if (remaining >= minFactor || remaining == 1) {
        factors.push(i, remaining.factor(minFactor));
        break;
      }
    }
  }
  var flattened = factors.flatten();
  if (flattened.indexOf('giveup') != -1) {
    return [];
  }
  return flattened;
}

if (!('print' in this)) {
  print = function() { return console.log(arguments); }
}

function main() {
  for (var i = 999; i >= 100; i--) {
    var factors = i.mirrorize().factor(100);
    var foundBig = false;
    for (j in factors) {
      factor = factors[j];
      if (factor >= 1000) {
        foundBig = true;
        break;
      }
    }
    if (!foundBig) {
      print(factors);
      break;
    }
  }
}

main();