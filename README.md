### Examples for Obey
**Potential examples for the scaladays**

This project proposes a few examples for a variant of Obey (see [this](https://github.com/mdemarne/Obey/tree/scaladays15)) which automatically includes rules from the `project/rules` folder once the following configuration done:

1. Get the [modified version of Obey](https://github.com/mdemarne/Obey/tree/scaladays15) and publish it locally (since this version is modified, it will not be published to Sonatype).
2. Add the plugin to your project build (in `project/plugins.sbt`)
3. Define the compilation scheme for the project in `project/rules` (i.e. your personalized rules). This step is still required, but there will be an option to do it automatically once SBT 1.14 released on scala 2.11.x.
4. Make your root project depends on the plugin and on the rules project. Even if your project does not need to have the rules visible, depending on it will ensure that the rules will be recompiled each time you did a change.

See the [build.sbt](https://github.com/mdemarne/obey-examples-scaladays15/blob/master/build.sbt) for an example.
