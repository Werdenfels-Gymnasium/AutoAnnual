(function() {
  'use strict';

  var glob = require('glob');
  var child_process = require('child_process');

  process.chdir(__dirname);
  child_process.execSync('mkdir -p ../dist');

  glob('../src/**/*.java', (err, files) => {
    var wildCard = files.join(' ');

    child_process.execSync('javac -d ../dist -cp "../libs/jsch-0.1.53.jar" ' + wildCard);

    packageJar();
  });

  function packageJar() {
    child_process.execSync('cd ../dist && jar cvfm ../AutoAnnual.jar ../META-INF/MANIFEST.MF *');
  }

})();