# ScriptWrapper
基于Kotlin的脚本引擎Wrapper框架




## 已经适配的引擎
[Repo:ScriptWrapperCollection](https://github.com/TIIEHenry/ScriptWrapperCollection)


​    


## 核心思想
类似于jdk中方便Java与各种脚本引擎交互的ScriptEngine（jdk提供的接口并不能在安卓上使用）

ScriptWrapper复现了JDK中的ScriptEngine，将各种引擎与App代码分离，而App与Wrapper对接，用起来既简洁又高效，使用Kotlin编写，可以完美运行在安卓平台上




|    |  代码耦合  |  灵活度  |  可读性  |  学习成本  |
|  :----:  |  :----:  | :----:  |  :----:  |  :----:  |
| 直接接入脚本引擎 | 高 |  高  |  低  |  高  |
|  ScriptWrapper  | 低 |  高  |  高  |  低  |







## 项目结构

通过编写一个通用的中间层(Wrapper)，将各种引擎与App代码分离，而App与Wrapper对接


|  Level(层次结构)  |
|  :----:  |
|  App代码层  |
|  中间层(Wrapper)  |
|  脚本引擎层  |


|  Package  |  Info  |
|  :----:  |  :----:  |
|  bridge  |  脚本语言与Java的桥梁  |
|  eval |  代码执行脚本语言  |
|  internal |  通用的内置方法  |


## 使用说明



[Repo:ScriptWrapperCollection](https://github.com/TIIEHenry/ScriptWrapperCollection) (提供了现有的几个已经适配的引擎，照猫画虎就可以轻松地适配其他引擎)


