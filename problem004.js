String.prototype.reverse = function() {
  return this.split("").reverse().join("");
}

Number.prototype.mirrorize = function() {
  return this.constructor(this.toString() + this.toString().reverse());
}

Number.prototype.threeDigitFactors = function() {
  for (var i = 999; i >= 100; i--) {
    if ((this % i) == 0) {
      var quotient = this / i;
      if (quotient >= 100 && quotient < 1000) {
        return [i, quotient];
      }
    }
  }
  return false;
}

if (!('print' in this)) {
  print = function() { return console.log(arguments); }
}

function main() {
  for (var i = 999; i >= 100; i--) {
    var factors = i.mirrorize().threeDigitFactors();
    if (factors) {
      print(factors);
      return;
    }
  }
}

main();