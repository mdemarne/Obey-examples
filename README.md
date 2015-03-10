### obey-examples-scaladays15
**Potential examples for scaladays**

This project proposes a few examples for a variant of Obey (see https://github.com/mdemarne/Obey/tree/scaladays15) 
which automatically include rules from the `project/rules` folder once the following configuration executed:
1. Add the plugin to your project build (in `project/plugins.sbt`)
2. Define the compilation scheme for the porject in `project/rules`
3. Make your root project depends on the plugin and on the rules project.

See the [build.sbt](https://github.com/mdemarne/obey-examples-scaladays15/blob/master/build.sbt) for an example.
