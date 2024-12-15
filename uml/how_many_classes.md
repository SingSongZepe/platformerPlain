# How many classes are maintained

**学校要求“High-Level Class Diagram with only Classes name and Package(s)”**

**包不一定要明确，包含类名和关系即可**
<img width="347" alt="classdiagram2" src="https://github.com/user-attachments/assets/29c2ebd9-82d9-4958-bcae-27ec2ef3dc3c" />

<img width="460" alt="classdiagram1" src="https://github.com/user-attachments/assets/5a49d2e3-b7c5-4196-835c-e2d45f0be9f7" />

### entrance

- Start
- **最后要把Start.java改成Main.java，这是学校要求**
- **PlatformerPlain需要改成Platformer**
- **com.example.platformerplain这个包的名字也需要修改**

    

- Main

### Controller

- GameOverController

- HomeController

- InformationController

- InformationSubpage1Controller

- InformationSubpage2Controller

- InformationSubpage3Controller

- MapsController

- OptionController

- PlayerController

- ScoreController

- StartController

### Model

- PlayerModel

### Object

- Character

- DestinationBlock

- DestinationNode

- EnemyNode

- Entity

- EntitySelector

- FeatureBlock

- FeatureNode

- FireDragonBlock

- FireDragonNode

- FlyingCarpetBlock

- FlyingCarpetNode

- GameState

- Map

- MovableNode

- MovableObjectNode

- MummyBlock

- MummyNode

- Obstacle

- ObstacleBlock

- PlatformBlock

- Player

- Score

- ScoreManager

- SupplyBlock

- SupplyNode

- Value

### Pattern

- LineMode

- Movable

- NoMove

- ObserverSubject

- Observer

### Utils

- Counter

- EntityCreator

- File

- InitContent

- InitContentAdapter

- InitGameUi

- IntArrayIterator

- RandomNumberGenerator

- ScoreCalculator

### View

- PlayerView

### Level (Map)

- LevelData

> map_data, monster, supplies, (flying platform in desert) are hardcoded in the levelData
