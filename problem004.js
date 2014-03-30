String.prototype.reverse = function() {
  return this.split("").reverse().join("");
}

Number.prototype.mirrorize = function() {
  return this.constructor(this.toString() + this.toString().reverse());
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
        remainingFactors = remaining.factor(minFactor);
        factors.push(i);
        for (var j = 0; j < remainingFactors.length; j++) {
          factors.push(remainingFactors[j]);
        }
        break;
      }
    }
  }
  if (factors.indexOf('giveup') != -1) {
    return [];
  }
  return factors;
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