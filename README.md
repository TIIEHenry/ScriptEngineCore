# ScriptWrapper
A script engine wrapper framework for kotlin.(基于Kotlin的脚本引擎Wrapper框架)


    You can also use it for efficient development with script languages.(你也可以用脚本语言来进行快速开发)


## Adapted Script Engines(已经适配的引擎)
[Repo:ScriptEngine](https://github.com/TIIEHenry/ScriptEngine)



## Core Idea
This project is similar to the Java interface ScriptEngine in the JDK that facilitates Java's interaction with various scripting engines (the interface provided by the JDK is not available on android)


When faced with scenarios such as plug-in dynamics in a project, we consider techniques such as dynamically loading Dex hotfixes, but script engines or rules engines are more efficient, flexible and reliable


The traditional method is called directly, which is highly flexible, but the code coupling is very high, and it is difficult to get started


    Each script engine has its own interface, which leads to a lot of code changes when you change a script engine, but in fact the script engine interacts in much the same way, so why not manage them all together? This project aims to solve such problems


ScriptEngineCore's method is to separate the various engines from the App code by writing a common Wrapper, and the App is docked with the Wrapper, which is both simple and efficient.


    Through ScriptEngineCore adaptation of the script engine can write interface, Wrapper extension method, also can directly access the engine, the engine itself has a high degree of flexibility


​    

|    |  code coupling  |  flexible  |  readable  |  learning costs  |
|  :----:  |  :----:  | :----:  |  :----:  |  :----:  |
|  Traditional Method  | high |  high  |  low  |  high  |
|  ScriptEngineCore  | low |  high  |  high  |  low  |




    The Java language is not flexible enough and it is relatively cumbersome to use, so the project is written by Kotlin and serves Kotlin+Android.


## 核心思想
项目类似于jdk中方便Java与各种脚本引擎交互接口ScriptEngine（jdk提供的接口并不能在安卓上使用）


当项目中遇到插件化、动态化之类的场景时，我们会考虑到动态加载Dex、热修复之类的技术，但脚本引擎或者规则引擎会更为高效、灵活和可靠


传统的方法是直接调用，这样灵活度高，但代码耦合非常高，上手难度不一


    每个脚本引擎都有其自己的接口，这也就导致了更换脚本引擎时需要更改大量的代码，而实际上与脚本引擎交互过程中使用的方法都大同小异，那为什么不能将他们统一管理呢？本项目就是为了解决这样的问题

ScriptEngineCore的方法是通过编写一个通用的中间层(Wrapper)，将各种引擎与App代码分离，而App与Wrapper对接，用起来既简洁又高效


    通过ScriptEngineCore适配的脚本引擎可以编写接口，扩展Wrapper的方法，也可以直接访问引擎，具有引擎本身高度的灵活性


|    |  代码耦合  |  灵活度  |  可读性  |  学习成本  |
|  :----:  |  :----:  | :----:  |  :----:  |  :----:  |
|  传统方法  | 高 |  高  |  低  |  高  |
|  ScriptWrapper  | 低 |  高  |  高  |  低  |




    Java语言不够灵活，使用起来也相对麻烦，所以项目由Kotlin编写，服务于Kotlin+Android



## Project Framework(项目架构)

The various engines are separated from the App code by writing a generic Wrapper, and the App interfaces with the Wrapper

通过编写一个通用的中间层(Wrapper)，将各种引擎与App代码分离，而App与Wrapper对接


|  Level(层次结构)  |
|  :----:  |
|  App Code(App代码层)  |
|  Middle Layer(Wrapper)(中间层(Wrapper))  |
|  Script Engine Layer(脚本引擎层)  |


|  Package  |  Info  |
|  :----:  |  :----:  |
|  android  |  Script languages interact with android components(脚本与安卓组件交互)  |
|  bridge  |  Script languages interact with host code(脚本语言与宿主代码交互)  |
|  eval |  Host code executes scripts(宿主代码执行脚本语言)  |
|  framework |  Scripting language environment and entry(脚本语言的环境和入口)  |
|  internal |  Generic built-in methods provided to scripting languages(通用的提供给脚本语言的内置方法)  |


## Usage(使用说明)

[Repo:ScriptEngine](https://github.com/TIIEHenry/ScriptEngine) offers several existing engines that have already been adapted, which can easily be adapted to other engines

[Repo:ScriptEngine](https://github.com/TIIEHenry/ScriptEngine)(提供了现有的几个已经适配的引擎，照猫画虎就可以轻松地适配其他引擎)


