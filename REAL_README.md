# Readme

> This is a javafx based project, using the MVC model, using five design patterns to complete a breakout game.

### Design Ideas

1. **MVC model**: The game adopts the Model-View-Controller (MVC) architecture, which manages business logic, interface and user input separately. This improves the maintainability and extensibility of the code. For example, the model part handles the game data and logic, the view part is responsible for displaying the UI, and the controller handles user input and coordinates the interaction between the model and the view.

2. **Five Design Patterns**: A variety of design patterns are used in the game, which help standardise the code structure and enhance the flexibility of feature implementation. The following are examples of five possible design patterns:
   
   - **Single instance pattern**: Ensures that certain objects (e.g., the game configuration manager) have only one instance in the entire application for easy global access.
   - **Observer Pattern**: Used to enable dynamic updates between the view and the model, automatically notifying the view to update its display when model data changes.
   - **Strategy Pattern**: allows different breakout strategies (e.g. character movement strategy, enemy behaviour strategy, etc.) to be used in the game, facilitating flexible switching at runtime.
   - **Factory Pattern**: Used to create different types of game objects (e.g., characters, enemies, props), simplifying the instantiation process through factory methods and improving code scalability.
   - **Adapter Pattern**: In the game, adapter pattern can be used to solve the problem of interface incompatibility between different classes. For example, when creating different map contents in the game, you can just call a unified interface directly.

### Test cases:

1. test case 0: MainTest, which starts the entry function of the javafx application, so that you can directly test the completion of the entire game.

2. Test case 1: HomePageTest, you come to the home screen. 3.

3. test case 2: OptionPageTest, used to test the Option page after entering the game interface, in which you can select the character and save it in GameState. 4. test case 3: MatchPageTest, which starts the javafx application entry function directly.

4. Test case 3: MapPageTest, you can select the map and save it in GameState.

5. test case 4: InformationPageTest, you can check some information about this game.

6. Test case 5: ScorePageTest, you can set the value of GameState to control the score displayed in ScorePage.

7. Test case 6: Level1Test, you can test the first level.

8. Test case 7: Level2Test, you can test the second level.

### Some advanced design

> By creating the abstract class Movable, we derived two classes, LineMove and NoMove, so we defined MovableNode (including its derivatives EnemyNode and MovableObjectNode) to own the object of Movable, and can call different derivatives of Movable via step_move. Call the step_move function of the different derived classes of Movable to complete the move of the Node.
> This design greatly reduces duplication of code. 
> This design greatly reduces repetitive code, every time you add a new monster, you only need to inherit from EnemyNode, and if the monster is static, you can set its Movable member to NoMove, in this way, in every computation frame, its step_move will not be called to generate movement. This achieves unification of the interface for movement of all movable objects (creatures or platforms, etc.).








