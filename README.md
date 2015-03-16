## Examples for Obey

This project proposes a few examples for Obey. It aims to show a build as simple as possible to let anyone
understand how the linter tool works.

### Use of Obey in this example

If you want to use Obey, you can look at the configuration of this project. Here are a few guidelines:

1. Add the plugin to your project build (in `project/plugins.sbt`) according to [Obey](https://github.com/mdemarne/Obey).
3. Define the compilation scheme for the project `rules` (i.e. your personalized rules).
You can put the `rules` project wherever you want in your repository. By convention, the best way to do so would be to put it
 in `project/rules`. This step is still required, but there will be an option to do it automatically once SBT 1.14
  released on scala 2.11.x (2.10 is for now not supported by scalameta). By default, it will consider the `project/rules` folder.
4. Make your root project depends on the plugin and on the rules project. Even if your project does not need to have
 the rules visible in its space, depending on it will ensure that the rules will be recompiled each time you did a
  change, and before your root project in itself is compiled.
5. Define the path to your project's rule in our project definition, by adding, for example, `obeyRules := "project/rules/target/scala-2.11/classes/"` to the settings of your root project.
6. You are all set! If you run `sbt compile`, it should generate warning based on your rules.

See [build.sbt](https://github.com/mdemarne/Obey-examples/blob/master/build.sbt) for the root project, [Rules.scala](https://github.com/mdemarne/Obey-examples/blob/master/project/Rules.scala) for the `rules`.

### Defining rules, warnings and fixes.

Obey can correct your source code based on your rules. This feature is still in development as it simply reprint the
tree in the source file while saving the original and does not persist comments. By default, Obey only generates
warnings. Check out the [README.md](https://github.com/mdemarne/Obey) of Obey for more details.