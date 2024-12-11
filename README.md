# what I did

### main 10.12.2024

1. 修改了文件结构，现在的文件结构如下

> app/  
> ├── src/  
> │   ├── main/  
> │   │   ├── java/  
> │   │   │   └── com/  
> │   │   │       └── example/  
> │   │   │           ├── controller/  
> │   │   │           │   └── MyController.java  
> │   │   │           ├── model/  
> │   │   │           │   └── MyModel.java  
> │   │   │           |── MainApp.java  
> 
> |   |    |            |------ view/
> │   │   ├── resources/  图片(images/)也在这
> │   │   │   ├── fxml/  
> │   │   │   │   └── myview.fxml  
> │   │   │   └── css/  
> │   │   │       └── styles.css  
> │   │   └── ...  
> │   └── test/  
> └── pom.xml 

2. 规范化了文件的名字
- java文件全部采用单词首字母大写命名

> OptionController.java

- fxml文件全部采用小写命名

> setting.fxml
> 
> 并且内部引用图片文件只需要./../images

3. 选定Start.java作为入口文件，其他作为辅助写代码的文件（仅仅参考作用，在最终的项目中需要被删除）

4. 删除了start.fml中不必要的节点

5. css文件放在了/resources/fxml下

6. 将HomeController.java内的一个FXML加载函数的fxml文件从"sample"改成了"option"，因为home.fxml文件中，是Option按钮的回调函数

7. 修改了所有fxml文件的引用其他资源文件的方式，主要采用“@”引用，同时折叠了所有标签，更方便调试

8. 在option.fxml通过按下按钮选择角色，然后把选择角色的信息保存在主类中

> ![](./readme_images\2024-12-10-05-56-07-image.png)
> 
> 这个菜单栏是不是没啥用？这个界面的化只要完成角色的选择就行了。

9. 我发现你写代码的一些问题，文件名，函数名，变量名大部分都是乱命名的，文件的存放也没有规律，这种让新接手项目的人阅读难度提升极大。

> 比如函数名使用了这种命名方法：
> 
> Switch_toHome
> 
> 一般第一个字母小写，然后后面用驼峰或者用全小写加下划线，例如：
> 
> switch_to_home
> 
> switchToHome
> 
> switch2home
> 
> switch2Home
> 
> to经常在命名中用2表示
> 
> .
> 
> 而且资源文件大小写混用，甚至拓展名也有“PNG”的，拓展名一般默认是小写的
> 
> 甚至有下划线，大小写全部混在一起命名的文件:
> 
> Intro_background.jpg

重构了大部分内容，完成了部分gui逻辑。

### feature1 11.12.2024

1. 重构了所有代码

2. HomePageContontroller.java有什么用？目前写代码没有用到
> **没有用到的话，老师删去就好**

3. 创建了object/文件夹，用来存放一些数据结构，例如user选择的character，完成逻辑的过程中还有可能会有得分，游戏状态之类的。

4. 添加了6种设计模式

> Decorator
> 
> Factory
> 
> ObservedSubject
> 
> Observer
> 
> Singleton
> 
> Strategy

> 然后我的理解是需要在编写游戏逻辑的时候用到这些设计模式并且标明哪个类用了这个设计模式对吗？
> 
> 例如 object/GameState.java这个类使用了Singleton的设计模式，就在类的前面注释使用了这个设计模式，是这样吗？
> 
> **答： 是的,并且要在最后的readme.md中表明最重要的五个设计模式（以及为什么使用）以及最重要的五个创新。**
> 
> **除了Javadoc之外，适当的注释也是需要的**
5. 尝试写了一点对函数的javadoc，符合你们要求的格式吗？如果符合后面就采用这种方式进行javadoc标注
> **可以的，javadoc主要是是为了标明我们的维护工作（即重构的设计模式等），例子如下**
> ![](.\readme_images\javadoc.png)

> ![](.\readme_images\Snipaste_2024-12-11_04-05-18.png)