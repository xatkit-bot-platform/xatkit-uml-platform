Xatkit UML Platform
=====

[![License Badge](https://img.shields.io/badge/license-EPL%202.0-brightgreen.svg)](https://opensource.org/licenses/EPL-2.0)
[![Build Status](https://travis-ci.com/xatkit-bot-platform/xatkit-uml-platform.svg?branch=master)](https://travis-ci.com/xatkit-bot-platform/xatkit-uml-platform)

Create and manipulate [UML](https://www.omg.org/spec/UML/About-UML/) (meta) models in Xatkit execution models. This platform is **not** bundled with the [Xatkit release](https://github.com/xatkit-bot-platform/xatkit-releases/releases).

UML models are internally stored as instances of the Eclipse UML metamodel. To render them (see *Save* action below), we rely on [PlantuML](http://plantuml.com/): the UML model is transformed to PlantUML syntax and render by PlantUML before returning it back to the requester.  

## Providers

The UML platform does not define any provider.

## Actions

| Action  | Parameters | Return                                  | Return Type | Description                                     |
| ------- | ---------- | --------------------------------------- | ----------- | ----------------------------------------------- |
| CreateClass | - `name` (**String**): the name of the UML Class to create          | The created UML [Class](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Class.html)   | [Class](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Class.html)      | Creates a UML Class with the provided `name` |
| GetClass | - `name` (**String**): the name of the UML Class to retrieve in the current model | The UML [Class](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Class.html) with the provided `name` | [Class](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Class.html) | Returns the UML Class in the current model with the provided `name` |
| AddAttribute | - `class` (**Class**): the UML Class to add an attribute to<br/> - `name` (**String**): the name of the attribute to add | The created UML [Property](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Property.html) | [Property](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Property.html) | Adds an attributes `name` to the provided `class` and returns it |
| AddAttribute | - `class` (**Class**): the UML Class to add an attribute to<br/> - `name` (**String**): the name of the attribute to add<br/> - `type` (**String**): the name of the DataType to set as the attribute's type | The created UML [Property](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Property.html) | [Property](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Property.html) | Adds an attribute `name` with the provided `type` to the provided `class` and returns it |
| AddAssociation | - `source` (**Class**): the source Class of the association<br/> - `target` (**Class**): the target Class of the association<br/> - `type` (**String**): the type of the association | The created UML [Association](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Association.html) | [Association](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/Association.html) | Creates an association between `source` and `target` with the given type (the type literals can be found in [AggregationKind](https://download.eclipse.org/modeling/mdt/uml2/javadoc/5.0.0/org/eclipse/uml2/uml/AggregationKind.html)) |
| Save | - | The [File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html) object containing the PNG representation of the model | [File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html) | Save the current model and renders it in a PNG | 

## Options

The UML platform does not support any configuration option.

## Installation Notes

PlantUML uses [Graphviz](https://graphviz.gitlab.io/) for rendering the UML diagram. Make sure you have Graphviz installed before trying to use this platform. [More info on Graphviz installation](http://plantuml.com/fr/graphviz-dot)

