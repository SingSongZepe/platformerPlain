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

### feature1 v2 11.12.2024

1. 重构了所有代码

2. HomePageContontroller.java有什么用？目前写代码没有用到

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

5. 尝试写了一点对函数的javadoc，符合你们要求的格式吗？如果符合后面就采用这种方式进行javadoc标注

> ![](.\readme_images\Snipaste_2024-12-11_04-05-18.png)

### feature2 v3 11.12.2024

1. 添加函数Start.initContent用来给Start.appRoot初始化和Start.creatEntity函数

2. 修改了一些Start成员的访问类型(private)

3. 把Start改成了单例模式，并且在init中初始化instance

4. 将主窗口变成unresizable，固定为1280x720

5. 添加了按下option->start之后的进入游戏的主逻辑，可以根据按下start之前玩家选择进入游戏界面（character, map）。

6. 定义游戏的积分规则

> - 这是原版积分规则
> 
> > ![](F:\MyProjects\receive\java_design_mode\code\PlatformerPlain_main\readme_images\Snipaste_2024-12-11_19-17-45.png)
> > 
> > 这个得分规则有点奇怪，通关时间和得分正相关
> 
> - 我定义了新的积分规则，时间最长为300秒，如果超过，判为game over
> 
> > (300-T) +1000*(n/N)
> > 
> > 其中T代表通过时间，n表示获取的物资，N表示总物资，这些数据可能和地图有关，也可能是随机生成的数据。
> > 
> > 并生成了ScoreCalculator.calculateScore函数

7. 删除（注释）了home.fxml中的menu bar（至少目前没用）

8. 更改了character.fxml角色下面的按钮对应的名称问题。

9. 更改了进入游戏之后使用的背景图片（由黑色背景改成map对应的图片）

10. 添加了计时逻辑和计时label，并且添加了一个quit game按钮，用来直接退到home.fxml

11. 更改了部分碰撞逻辑

12. 修改了object.Character  (Decorator)

13. 添加了object.Map  (Decorator)

14. 添加了game_over.fxml，游戏因某种原因结束的时候展示

15. 修改GameState为Factory pattern

16. 背景素材有点少，在测试一个图片的过程中出现了明显的糊了的效果。

> ![](./readme_images\Snipaste_2024-12-11_22-06-07.png)

17. 修改了角色的身高，由于每个角色图片的w:h都不一样，如果让Amy这个角色的高度为60，那Carl这个角色的高度会超过60，会导致有些地方过不去，所以，让角色的w:h大致为 25:50，部分男角色身高可能为51，52左右

18. 添加了file/文件夹，用来存储一些文本文件

> 例如 scores.json

19. 添加了object/Score.java，用来序列化和反序列化，方便存储和读取数据。

20. 添加了test/测试文件夹，并且添加了一个测试

### feature3 v4 12.12.2024

1. 添加了scores.json文件以及数据内容的错误处理系统

2. 在playerController中添加了镜像逻辑，当角色向左走动的时候，图片会朝向左边，反之亦然。

3. 添加了gameState从TimeLabel获取耗时并保存在gameState里面，将会在“score”页面处理得分。

4. 创建了几个文件用来分类不同素材

5. 缺失素材或素材不适合

> - 缺少素材
> 
> > 饼干
> 
> 
> 
> - 素材不适合
> 
> > enemy的火龙，需要在天上飞应该要有翅膀
> > 
> > enemy的木乃伊，太呆了
> > 
> > platform由于是一块一块的60x60像素构成的方块，所以需要的不是很大一片的图，而是一小块一小块的，上面可以有雪覆盖。可以多找几个这样的小块单元，实在不行可以从大图里面ps扣下来一块

ps. 今天没多少时间，只写了一些代码。